package dataTypes;

public class DtComentario {
	private String nickName;
	private String comentario;
	
	public DtComentario(String nickName, String comentario){
		this.nickName = nickName;
		this.comentario = comentario;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public String getComentario() {
		return comentario;
	}
	
}
