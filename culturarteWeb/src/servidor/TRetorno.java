
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tRetorno.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tRetorno">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PORCENTAJE_GANANCIA"/>
 *     &lt;enumeration value="ENTRADA_GRATIS"/>
 *     &lt;enumeration value="PORCENTAJE_Y_ENTRADAS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tRetorno")
@XmlEnum
public enum TRetorno {

    PORCENTAJE_GANANCIA,
    ENTRADA_GRATIS,
    PORCENTAJE_Y_ENTRADAS;

    public String value() {
        return name();
    }

    public static TRetorno fromValue(String v) {
        return valueOf(v);
    }

}
