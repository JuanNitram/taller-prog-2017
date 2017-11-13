package com.culturarte.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataTypes.DtColaboracion;
import dataTypes.DtColaborador;
import dataTypes.DtProponente;
import dataTypes.DtPropuesta;
import dataTypes.TTarjeta;
import logica.Fabrica;

/**
 * Servlet implementation class Colaboraciones
 */
@WebServlet("/Colaboraciones")
public class Colaboraciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DtColaboracion colaboracion;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Colaboraciones() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/colaboracion/pagarColaboracion.jsp").forward(request, response);
	}
	
	private static void pagarColaboracion(HttpServletRequest request) {
		Fabrica.getInstance().getICtrlPropuesta().infoColaboracion(Integer.parseInt(request.getParameter("idColab")));
		if(request.getParameter("tipoPago").equals("tarjeta")) {
			TTarjeta tipoTarjeta = null;
			if(request.getParameter("tipoTarjeta").equals("Master")) tipoTarjeta = TTarjeta.MASTER;
			else if(request.getParameter("tipoTarjeta").equals("Visa")) tipoTarjeta = TTarjeta.VISA;
			else if(request.getParameter("tipoTarjeta").equals("Oca")) tipoTarjeta = TTarjeta.OCA;
			
			String vencimiento = request.getParameter("vencimiento");
			Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.parseInt(vencimiento.substring(vencimiento.indexOf("/")+1,vencimiento.indexOf("/")+2)), Integer.parseInt(vencimiento.substring(0,1)), 1);
			
			Fabrica.getInstance().getICtrlPropuesta().pagarColabTarjeta(
					Float.parseFloat(request.getParameter("monto")),
					request.getParameter("titular"),
					request.getParameter("nroTarjeta"),
					tipoTarjeta,
					calendar.getTime(),
					request.getParameter("cvc")
				);
		} else if(request.getParameter("tipoPago").equals("paypal")) {
			Fabrica.getInstance().getICtrlPropuesta().pagarColabPayPal(
					Float.parseFloat(request.getParameter("monto")),
					request.getParameter("titularPayPal"),
					request.getParameter("nroPayPal")
				);
		} else if(request.getParameter("tipoPago").equals("transferencia")) {
			Fabrica.getInstance().getICtrlPropuesta().pagarColabTransferencia(
					Float.parseFloat(request.getParameter("monto")),
					request.getParameter("titularTransferencia"),
					request.getParameter("bancoTransferencia"),
					request.getParameter("nroTransferencia")
				);
		}
		colaboracion = Fabrica.getInstance().getICtrlPropuesta().infoColaboracion(Integer.parseInt(request.getParameter("idColab")));
		System.out.println("Colaboración paga.");
	}
	
	private static void enviarMail(String destinatario, String asunto, String cuerpo) {
		Properties props = new Properties();
		
		// Nombre del host de correo, es smtp.gmail.com
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS si está disponible
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port","587");

		// Nombre del usuario
		props.setProperty("mail.smtp.user", "tprog05.2017@gmail.com");

		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session sesion = Session.getDefaultInstance(props);
		sesion.setDebug(true);
		MimeMessage mensaje = new MimeMessage(sesion);
		
		try {
			mensaje.setFrom(new InternetAddress("tprog05.2017@gmail.com"));
			mensaje.addRecipient(Message.RecipientType.CC, new InternetAddress("tprog05.2017@gmail.com"));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mensaje.setSubject(asunto);
			mensaje.setText(cuerpo,"UTF-8","html");
			
			Transport transporte = sesion.getTransport("smtp");
			transporte.connect("tprog05.2017@gmail.com", "culturarte");
			transporte.sendMessage(mensaje, mensaje.getAllRecipients());
			transporte.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("confirmaPagar")) 
			Colaboraciones.pagarColaboracion(request);
		else if(request.getParameter("action").equals("notificacionEmail")) {
			String ahora = (new SimpleDateFormat("dd-MM-yyyy hh:mm")).format(new Date());
			DtPropuesta dtP = Fabrica.getInstance().getICtrlPropuesta().infoPropuesta(colaboracion.getTitulo());
			String cuerpoProponente = "Estimado Proponente. El pago correspondiente a la colaboración de la propuesta "
					+ colaboracion.getTitulo() + " realizada por " + colaboracion.getNickname() + " ha sido registrado en forma exitosa.<br><br>";
			cuerpoProponente += "-Propuesta:<br>";
			cuerpoProponente += "- " + colaboracion.getTitulo() + "<br>";
			cuerpoProponente += "-Proponente:<br>";
			cuerpoProponente += "- " + dtP.getNickProponente() + "<br>";
			cuerpoProponente += "-Colaborador:<br>";
			cuerpoProponente += "- " + colaboracion.getNickname() + "<br>";
			cuerpoProponente += "-Monto:<br>";
			cuerpoProponente += "- $" + colaboracion.getPago().getMonto() + "<br>";
			cuerpoProponente += "- Fecha de pago:<br>";
			cuerpoProponente += "- " + ahora + "<br><br>";
			cuerpoProponente += "Gracias por preferirnos,<br>";
			cuerpoProponente += "Saludos.<br>";
			cuerpoProponente += "Culturarte.<br>";
			String cuerpoColaborador = cuerpoProponente;
			cuerpoColaborador = cuerpoColaborador.replace(" Proponente.", " Colaborador.");
			cuerpoColaborador = cuerpoColaborador.replace("<br><br>Gracias", "<br><br><i>link de solicitud de constancia de pago</i><br><br>Gracias");
			
			String asunto = "[Culturarte] [" + ahora + "] Pago de colaboración registrado";
			
			DtColaborador colaborador = Fabrica.getInstance().getICtrlUsuario().infoColaborador(colaboracion.getNickname());
			DtProponente proponente = Fabrica.getInstance().getICtrlUsuario().infoProponente(dtP.getNickProponente());
			System.out.println(colaboracion.getPago());
			System.out.println("Pago" + colaboracion.getPago().getMonto() + colaboracion.getPago().getNombreTitular());
			
			Colaboraciones.enviarMail(colaborador.getEmail(), asunto, cuerpoColaborador);
			Colaboraciones.enviarMail(proponente.getEmail(), asunto, cuerpoProponente);

		}
	}

}
