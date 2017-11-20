
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tEstado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tEstado">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INGRESADA"/>
 *     &lt;enumeration value="PUBLICADA"/>
 *     &lt;enumeration value="EN_FINANCIACION"/>
 *     &lt;enumeration value="FINANCIADA"/>
 *     &lt;enumeration value="NO_FINANCIADA"/>
 *     &lt;enumeration value="CANCELADA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tEstado")
@XmlEnum
public enum TEstado {

    INGRESADA,
    PUBLICADA,
    EN_FINANCIACION,
    FINANCIADA,
    NO_FINANCIADA,
    CANCELADA;

    public String value() {
        return name();
    }

    public static TEstado fromValue(String v) {
        return valueOf(v);
    }

}
