
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtPago complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtPago"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="nombreTitular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPago", propOrder = {
    "monto",
    "nombreTitular"
})
public abstract class DtPago {

    protected float monto;
    protected String nombreTitular;

    /**
     * Gets the value of the monto property.
     * 
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     */
    public void setMonto(float value) {
        this.monto = value;
    }

    /**
     * Gets the value of the nombreTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTitular() {
        return nombreTitular;
    }

    /**
     * Sets the value of the nombreTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTitular(String value) {
        this.nombreTitular = value;
    }

}
