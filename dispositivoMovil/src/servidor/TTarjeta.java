
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
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
