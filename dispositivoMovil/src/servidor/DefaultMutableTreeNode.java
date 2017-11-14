
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para defaultMutableTreeNode complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="defaultMutableTreeNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allowsChildren" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userObject" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "defaultMutableTreeNode", propOrder = {
    "allowsChildren",
    "userObject"
})
public class DefaultMutableTreeNode {

    protected boolean allowsChildren;
    protected Object userObject;

    /**
     * Obtiene el valor de la propiedad allowsChildren.
     * 
     */
    public boolean isAllowsChildren() {
        return allowsChildren;
    }

    /**
     * Define el valor de la propiedad allowsChildren.
     * 
     */
    public void setAllowsChildren(boolean value) {
        this.allowsChildren = value;
    }

    /**
     * Obtiene el valor de la propiedad userObject.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getUserObject() {
        return userObject;
    }

    /**
     * Define el valor de la propiedad userObject.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setUserObject(Object value) {
        this.userObject = value;
    }

}
