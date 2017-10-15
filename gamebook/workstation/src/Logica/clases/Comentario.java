package Logica.clases;

public class Comentario {
	
	private String nickname;
	private String comentario;
	
	public Comentario(String nickname, String comentario) {
		this.nickname = nickname;
		this.comentario = comentario;
	}
	
	public String getNickname() { return this.nickname; }
	
	public void setNickname(String nickname) { this.nickname = nickname; }
	
	public String getComentario() { return this.comentario; }
	
	public void setComentario(String comentario) { this.comentario = comentario; }
}