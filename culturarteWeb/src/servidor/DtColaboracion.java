
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtColaboracion complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
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
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the nickname property.
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
     * Sets the value of the nickname property.
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
     * Gets the value of the titulo property.
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
     * Sets the value of the titulo property.
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
     * Gets the value of the montoAporte property.
     * 
     */
    public float getMontoAporte() {
        return montoAporte;
    }

    /**
     * Sets the value of the montoAporte property.
     * 
     */
    public void setMontoAporte(float value) {
        this.montoAporte = value;
    }

    /**
     * Gets the value of the fechaRealizacion property.
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
     * Sets the value of the fechaRealizacion property.
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
     * Gets the value of the retorno property.
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
     * Sets the value of the retorno property.
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
     * Gets the value of the pago property.
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
     * Sets the value of the pago property.
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
