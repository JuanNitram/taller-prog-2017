
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtProponente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtProponente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dtUsuario">
 *       &lt;sequence>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biografia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkSitio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propuestas" type="{http://servidor/}dtPropuesta" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtProponente", propOrder = {
    "direccion",
    "biografia",
    "linkSitio",
    "propuestas"
})
public class DtProponente
    extends DtUsuario
{

    protected String direccion;
    protected String biografia;
    protected String linkSitio;
    @XmlElement(nillable = true)
    protected List<DtPropuesta> propuestas;

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad biografia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Define el valor de la propiedad biografia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiografia(String value) {
        this.biografia = value;
    }

    /**
     * Obtiene el valor de la propiedad linkSitio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkSitio() {
        return linkSitio;
    }

    /**
     * Define el valor de la propiedad linkSitio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkSitio(String value) {
        this.linkSitio = value;
    }

    /**
     * Gets the value of the propuestas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propuestas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropuestas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtPropuesta }
     * 
     * 
     */
    public List<DtPropuesta> getPropuestas() {
        if (propuestas == null) {
            propuestas = new ArrayList<DtPropuesta>();
        }
        return this.propuestas;
    }

}
