
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtCategorias complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtCategorias"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="raiz" type="{http://servidor/}defaultMutableTreeNode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtCategorias", propOrder = {
    "raiz"
})
public class DtCategorias {

    protected DefaultMutableTreeNode raiz;

    /**
     * Gets the value of the raiz property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultMutableTreeNode }
     *     
     */
    public DefaultMutableTreeNode getRaiz() {
        return raiz;
    }

    /**
     * Sets the value of the raiz property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultMutableTreeNode }
     *     
     */
    public void setRaiz(DefaultMutableTreeNode value) {
        this.raiz = value;
    }

}
