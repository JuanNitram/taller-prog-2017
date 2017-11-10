
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
 * <p>Clase Java para dtPropuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtPropuesta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nickProponente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoria" type="{http://servidor/}dtCategoria" minOccurs="0"/>
 *         &lt;element name="lugar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaRealizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaPublicacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaExtension" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="montoRequerido" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="montoReunido" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="tipoRetorno" type="{http://servidor/}tRetorno" minOccurs="0"/>
 *         &lt;element name="rutaImg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precioEntrada" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="estado" type="{http://servidor/}tEstado" minOccurs="0"/>
 *         &lt;element name="favoritos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Obtiene el valor de la propiedad nickProponente.
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
     * Define el valor de la propiedad nickProponente.
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
     * Obtiene el valor de la propiedad descripcion.
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
     * Define el valor de la propiedad descripcion.
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
     * Obtiene el valor de la propiedad categoria.
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
     * Define el valor de la propiedad categoria.
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
     * Obtiene el valor de la propiedad lugar.
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
     * Define el valor de la propiedad lugar.
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
     * Obtiene el valor de la propiedad fechaPublicacion.
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
     * Define el valor de la propiedad fechaPublicacion.
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
     * Obtiene el valor de la propiedad fechaExtension.
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
     * Define el valor de la propiedad fechaExtension.
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
     * Obtiene el valor de la propiedad montoRequerido.
     * 
     */
    public float getMontoRequerido() {
        return montoRequerido;
    }

    /**
     * Define el valor de la propiedad montoRequerido.
     * 
     */
    public void setMontoRequerido(float value) {
        this.montoRequerido = value;
    }

    /**
     * Obtiene el valor de la propiedad montoReunido.
     * 
     */
    public float getMontoReunido() {
        return montoReunido;
    }

    /**
     * Define el valor de la propiedad montoReunido.
     * 
     */
    public void setMontoReunido(float value) {
        this.montoReunido = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoRetorno.
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
     * Define el valor de la propiedad tipoRetorno.
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
     * Obtiene el valor de la propiedad rutaImg.
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
     * Define el valor de la propiedad rutaImg.
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
     * Obtiene el valor de la propiedad precioEntrada.
     * 
     */
    public float getPrecioEntrada() {
        return precioEntrada;
    }

    /**
     * Define el valor de la propiedad precioEntrada.
     * 
     */
    public void setPrecioEntrada(float value) {
        this.precioEntrada = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
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
     * Define el valor de la propiedad estado.
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
