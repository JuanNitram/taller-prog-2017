
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
<<<<<<< HEAD
 * <p>Java class for tTarjeta.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tTarjeta"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OCA"/&gt;
 *     &lt;enumeration value="VISA"/&gt;
 *     &lt;enumeration value="MASTER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
=======
 * <p>Clase Java para tTarjeta.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tTarjeta">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OCA"/>
 *     &lt;enumeration value="VISA"/>
 *     &lt;enumeration value="MASTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
>>>>>>> branch 'master' of https://gitlab.fing.edu.uy/tprog/tpgr05.git
 * </pre>
 * 
 */
@XmlType(name = "tTarjeta")
@XmlEnum
public enum TTarjeta {

    OCA,
    VISA,
    MASTER;

    public String value() {
        return name();
    }

    public static TTarjeta fromValue(String v) {
        return valueOf(v);
    }

}
