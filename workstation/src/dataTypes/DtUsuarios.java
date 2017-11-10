package dataTypes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DtUsuarios {
	private ArrayList<DtUsuario> users = new ArrayList<DtUsuario>();
	
	public DtUsuarios(){
	}

	public ArrayList<DtUsuario> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<DtUsuario> users) {
		this.users = users;
	}

}