
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
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
