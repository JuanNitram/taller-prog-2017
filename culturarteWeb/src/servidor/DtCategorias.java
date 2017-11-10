
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtCategorias complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtCategorias">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="raiz" type="{http://servidor/}defaultMutableTreeNode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Obtiene el valor de la propiedad raiz.
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
     * Define el valor de la propiedad raiz.
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
