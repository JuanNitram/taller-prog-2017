
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tEstado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tEstado"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="INGRESADA"/&gt;
 *     &lt;enumeration value="PUBLICADA"/&gt;
 *     &lt;enumeration value="EN_FINANCIACION"/&gt;
 *     &lt;enumeration value="FINANCIADA"/&gt;
 *     &lt;enumeration value="NO_FINANCIADA"/&gt;
 *     &lt;enumeration value="CANCELADA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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
