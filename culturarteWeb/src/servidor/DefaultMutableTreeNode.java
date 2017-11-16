
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for defaultMutableTreeNode complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="defaultMutableTreeNode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="allowsChildren" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="userObject" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * Gets the value of the allowsChildren property.
     * 
     */
    public boolean isAllowsChildren() {
        return allowsChildren;
    }

    /**
     * Sets the value of the allowsChildren property.
     * 
     */
    public void setAllowsChildren(boolean value) {
        this.allowsChildren = value;
    }

    /**
     * Gets the value of the userObject property.
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
     * Sets the value of the userObject property.
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
