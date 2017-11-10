package dataTypes;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class DtCategorias {
	private DefaultMutableTreeNode raiz = new DefaultMutableTreeNode();
	
	public DtCategorias(){}

	public DefaultMutableTreeNode getRaiz() {
		return raiz;
	}

	public void setRaiz(DefaultMutableTreeNode raiz) {
		this.raiz = raiz;
	}
	 
}
