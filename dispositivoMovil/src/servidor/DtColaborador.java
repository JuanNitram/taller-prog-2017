
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtColaborador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtColaborador">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dtUsuario">
 *       &lt;sequence>
 *         &lt;element name="colaboraciones" type="{http://servidor/}dtColaboracion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtColaborador", propOrder = {
    "colaboraciones"
})
public class DtColaborador
    extends DtUsuario
{

    @XmlElement(nillable = true)
    protected List<DtColaboracion> colaboraciones;

    /**
     * Gets the value of the colaboraciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colaboraciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColaboraciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtColaboracion }
     * 
     * 
     */
    public List<DtColaboracion> getColaboraciones() {
        if (colaboraciones == null) {
            colaboraciones = new ArrayList<DtColaboracion>();
        }
        return this.colaboraciones;
    }

}
