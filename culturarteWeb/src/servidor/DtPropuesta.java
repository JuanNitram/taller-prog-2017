
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtPropuesta complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtPropuesta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nickProponente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="categoria" type="{http://servidor/}dtCategoria" minOccurs="0"/&gt;
 *         &lt;element name="lugar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaRealizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaPublicacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaExtension" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="montoRequerido" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="montoReunido" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="tipoRetorno" type="{http://servidor/}tRetorno" minOccurs="0"/&gt;
 *         &lt;element name="rutaImg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="precioEntrada" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="estado" type="{http://servidor/}tEstado" minOccurs="0"/&gt;
 *         &lt;element name="favoritos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPropuesta", propOrder = {
    "nickProponente",
    "titulo",
    "descripcion",
    "categoria",
    "lugar",
    "fechaRealizacion",
    "fechaPublicacion",
    "fechaExtension",
    "montoRequerido",
    "montoReunido",
    "tipoRetorno",
    "rutaImg",
    "precioEntrada",
    "estado",
    "favoritos"
})
public class DtPropuesta {

    protected String nickProponente;
    protected String titulo;
    protected String descripcion;
    protected DtCategoria categoria;
    protected String lugar;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRealizacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPublicacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaExtension;
    protected float montoRequerido;
    protected float montoReunido;
    @XmlSchemaType(name = "string")
    protected TRetorno tipoRetorno;
    protected String rutaImg;
    protected float precioEntrada;
    @XmlSchemaType(name = "string")
    protected TEstado estado;
    @XmlElement(nillable = true)
    protected List<String> favoritos;

    /**
     * Gets the value of the nickProponente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickProponente() {
        return nickProponente;
    }

    /**
     * Sets the value of the nickProponente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickProponente(String value) {
        this.nickProponente = value;
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
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the categoria property.
     * 
     * @return
     *     possible object is
     *     {@link DtCategoria }
     *     
     */
    public DtCategoria getCategoria() {
        return categoria;
    }

    /**
     * Sets the value of the categoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link DtCategoria }
     *     
     */
    public void setCategoria(DtCategoria value) {
        this.categoria = value;
    }

    /**
     * Gets the value of the lugar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Sets the value of the lugar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugar(String value) {
        this.lugar = value;
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
     * Gets the value of the fechaPublicacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Sets the value of the fechaPublicacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPublicacion(XMLGregorianCalendar value) {
        this.fechaPublicacion = value;
    }

    /**
     * Gets the value of the fechaExtension property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaExtension() {
        return fechaExtension;
    }

    /**
     * Sets the value of the fechaExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaExtension(XMLGregorianCalendar value) {
        this.fechaExtension = value;
    }

    /**
     * Gets the value of the montoRequerido property.
     * 
     */
    public float getMontoRequerido() {
        return montoRequerido;
    }

    /**
     * Sets the value of the montoRequerido property.
     * 
     */
    public void setMontoRequerido(float value) {
        this.montoRequerido = value;
    }

    /**
     * Gets the value of the montoReunido property.
     * 
     */
    public float getMontoReunido() {
        return montoReunido;
    }

    /**
     * Sets the value of the montoReunido property.
     * 
     */
    public void setMontoReunido(float value) {
        this.montoReunido = value;
    }

    /**
     * Gets the value of the tipoRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link TRetorno }
     *     
     */
    public TRetorno getTipoRetorno() {
        return tipoRetorno;
    }

    /**
     * Sets the value of the tipoRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetorno }
     *     
     */
    public void setTipoRetorno(TRetorno value) {
        this.tipoRetorno = value;
    }

    /**
     * Gets the value of the rutaImg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaImg() {
        return rutaImg;
    }

    /**
     * Sets the value of the rutaImg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaImg(String value) {
        this.rutaImg = value;
    }

    /**
     * Gets the value of the precioEntrada property.
     * 
     */
    public float getPrecioEntrada() {
        return precioEntrada;
    }

    /**
     * Sets the value of the precioEntrada property.
     * 
     */
    public void setPrecioEntrada(float value) {
        this.precioEntrada = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link TEstado }
     *     
     */
    public TEstado getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link TEstado }
     *     
     */
    public void setEstado(TEstado value) {
        this.estado = value;
    }

    /**
     * Gets the value of the favoritos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the favoritos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavoritos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFavoritos() {
        if (favoritos == null) {
            favoritos = new ArrayList<String>();
        }
        return this.favoritos;
    }

}
