package com.culturarte.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import javax.xml.datatype.DatatypeConfigurationException;

import com.culturarte.model.Utils;

import servidor.DataDate;
import servidor.DtColaboracion;
import servidor.DtColaborador;
import servidor.DtProponente;
import servidor.DtPropuesta;
import servidor.PublicadorService;
import servidor.TRetorno;
import servidor.TTarjeta;

/**
 * Servlet implementation class Colaboraciones
 */
@WebServlet("/Colaboraciones")
public class Colaboraciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DtColaboracion colaboracion;
	private static PublicadorService servicios = new PublicadorService();
       
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
		request.getRequestDispatcher("/WEB-INF/colaboracion/pagarColaboracion.jsp").forward(request, response);
	}
	
	private static void pagarColaboracion(HttpServletRequest request) {
		servicios.getPublicadorPort().infoColaboracion(Integer.parseInt(request.getParameter("idColab")));
		if(request.getParameter("tipoPago").equals("tarjeta")) {
			try {
				TTarjeta tipoTarjeta = null;
				if(request.getParameter("tipoTarjeta").equals("Master")) tipoTarjeta = TTarjeta.MASTER;
				else if(request.getParameter("tipoTarjeta").equals("Visa")) tipoTarjeta = TTarjeta.VISA;
				else if(request.getParameter("tipoTarjeta").equals("Oca")) tipoTarjeta = TTarjeta.OCA;
				
				String vencimiento = request.getParameter("vencimiento");
				Calendar calendar = Calendar.getInstance();
				calendar.set(Integer.parseInt(vencimiento.substring(vencimiento.indexOf("/")+1,vencimiento.indexOf("/")+2)), Integer.parseInt(vencimiento.substring(0,1)), 1);
				
				DataDate dataDate = new DataDate();
				dataDate.setDate(Utils.getXmlGregorianCalendarFromDate(calendar.getTime()));
				
				servicios.getPublicadorPort().pagarColabTarjeta(
						Float.parseFloat(request.getParameter("monto")),
						request.getParameter("titular"),
						request.getParameter("nroTarjeta"),
						tipoTarjeta,
						dataDate,
						request.getParameter("cvc")
					);
			} catch(DatatypeConfigurationException configurationException) {
				configurationException.printStackTrace();
			}
		} else if(request.getParameter("tipoPago").equals("paypal")) {
			servicios.getPublicadorPort().pagarColabPayPal(
					Float.parseFloat(request.getParameter("monto")),
					request.getParameter("titularPayPal"),
					request.getParameter("nroPayPal")
				);
		} else if(request.getParameter("tipoPago").equals("transferencia")) {
			servicios.getPublicadorPort().pagarColabTransferencia(
					Float.parseFloat(request.getParameter("monto")),
					request.getParameter("titularTransferencia"),
					request.getParameter("bancoTransferencia"),
					request.getParameter("nroTransferencia")
				);
		}
		servicios.getPublicadorPort().infoColaboracion(Integer.parseInt(request.getParameter("idColab")));
		System.out.println("Colaboraci�n paga.");
	}
	
	private static void enviarMail(String destinatario, String asunto, String cuerpo) {
		Properties props = new Properties();
		
		// Nombre del host de correo, es smtp.gmail.com
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS si est� disponible
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
			DtPropuesta dtP = servicios.getPublicadorPort().infoPropuesta(colaboracion.getTitulo());
			String cuerpoProponente = "Estimado Proponente. El pago correspondiente a la colaboraci�n de la propuesta "
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
			
			String asunto = "[Culturarte] [" + ahora + "] Pago de colaboraci�n registrado";
			
			DtColaborador colaborador = servicios.getPublicadorPort().infoColaborador(colaboracion.getNickname());
			DtProponente proponente = servicios.getPublicadorPort().infoProponente(dtP.getNickProponente());
			System.out.println(colaboracion.getPago());
			System.out.println("Pago" + colaboracion.getPago().getMonto() + colaboracion.getPago().getNombreTitular());
			
			Colaboraciones.enviarMail(colaborador.getEmail(), asunto, cuerpoColaborador);
			Colaboraciones.enviarMail(proponente.getEmail(), asunto, cuerpoProponente);

		} else if(request.getParameter("action").equals("registrarColaboracion")) {
    		
    		String propuesta = (String) (request.getParameter("tituloProp"));
			String retorno = request.getParameter("selectRetorno");
			String monto = request.getParameter("txtMonto");
			String nickName = (String) request.getSession().getAttribute("usuario_logueado");
	    	
			TRetorno ret = null;
			if (retorno.equals("PORCENTAJE_GANANCIA"))
				ret = TRetorno.PORCENTAJE_GANANCIA;
			else if (retorno.equals("ENTRADA_GRATIS"))
				ret = TRetorno.ENTRADA_GRATIS;

			servicios.getPublicadorPort().infoPropuesta(propuesta);
			servicios.getPublicadorPort().agregarColaboracion(nickName, Float.parseFloat(monto), ret );
    		
			PrintWriter out = response.getWriter();
			out.println("<span style=\"text-align: center\"><h3>Colaboradores</h3></span>");
			List<DtColaboracion> colaboraciones = (ArrayList) servicios.getPublicadorPort().listarColaboraciones().getDatos();
			for (int i = 0; i < colaboraciones.size(); i++) {
				DtColaboracion dtColab = colaboraciones.get(i);
				if (dtColab.getTitulo().equals(propuesta)) {
					DtColaborador colaborador = servicios.getPublicadorPort().infoColaborador(dtColab.getNickname());
					out.println("<a href=\"consultaUsuario?usuario=<%=colaborador.getNickName()%>\">");
					out.println(colaborador.getNombre() + " " + colaborador.getApellido() + " (" + colaborador.getNickName() + ")");
					out.println("</a><br>");
				}
			}
    	}
	}

}
