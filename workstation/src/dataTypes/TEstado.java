package dataTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public enum TEstado {

		INGRESADA,
		PUBLICADA,
		EN_FINANCIACION,
		FINANCIADA,
		NO_FINANCIADA,
		CANCELADA 
		
}
