
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtProponente complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtProponente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://servidor/}dtUsuario"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="biografia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkSitio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="propuestas" type="{http://servidor/}dtPropuesta" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * Gets the value of the direccion property.
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
     * Sets the value of the direccion property.
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
     * Gets the value of the biografia property.
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
     * Sets the value of the biografia property.
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
     * Gets the value of the linkSitio property.
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
     * Sets the value of the linkSitio property.
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
