
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtPago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtPago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="nombreTitular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Obtiene el valor de la propiedad monto.
     * 
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     */
    public void setMonto(float value) {
        this.monto = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTitular.
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
     * Define el valor de la propiedad nombreTitular.
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
