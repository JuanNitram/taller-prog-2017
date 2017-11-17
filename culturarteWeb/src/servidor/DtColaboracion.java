
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtColaboracion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtColaboracion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="montoAporte" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="fechaRealizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="retorno" type="{http://servidor/}tRetorno" minOccurs="0"/&gt;
 *         &lt;element name="pago" type="{http://servidor/}dtPago" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtColaboracion", propOrder = {
    "id",
    "nickname",
    "titulo",
    "montoAporte",
    "fechaRealizacion",
    "retorno",
    "pago"
})
public class DtColaboracion {

    protected int id;
    protected String nickname;
    protected String titulo;
    protected float montoAporte;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRealizacion;
    @XmlSchemaType(name = "string")
    protected TRetorno retorno;
    protected DtPago pago;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nickname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Define el valor de la propiedad nickname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad montoAporte.
     * 
     */
    public float getMontoAporte() {
        return montoAporte;
    }

    /**
     * Define el valor de la propiedad montoAporte.
     * 
     */
    public void setMontoAporte(float value) {
        this.montoAporte = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRealizacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRealizacion() {
        return fechaRealizacion;
    }

    /**
     * Define el valor de la propiedad fechaRealizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRealizacion(XMLGregorianCalendar value) {
        this.fechaRealizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad retorno.
     * 
     * @return
     *     possible object is
     *     {@link TRetorno }
     *     
     */
    public TRetorno getRetorno() {
        return retorno;
    }

    /**
     * Define el valor de la propiedad retorno.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetorno }
     *     
     */
    public void setRetorno(TRetorno value) {
        this.retorno = value;
    }

    /**
     * Obtiene el valor de la propiedad pago.
     * 
     * @return
     *     possible object is
     *     {@link DtPago }
     *     
     */
    public DtPago getPago() {
        return pago;
    }

    /**
     * Define el valor de la propiedad pago.
     * 
     * @param value
     *     allowed object is
     *     {@link DtPago }
     *     
     */
    public void setPago(DtPago value) {
        this.pago = value;
    }

}
