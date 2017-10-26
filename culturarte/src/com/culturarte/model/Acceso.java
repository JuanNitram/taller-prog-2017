package com.culturarte.model;

import java.util.Date;

public class Acceso {
	// 1 192.168.1.103 http:// culturarte.com/usuario/1.jpg Firefox Windows
	private String ip;
	private String url;
	private String browser;
	private String so;
	private Date fecha;
	
	public Acceso(String ip, String url, String browser, String so, Date fecha) {
		super();
		this.ip = ip;
		this.url = url;
		this.browser = browser;
		this.so = so;
		this.fecha = fecha;
	}
	
	public String getIp() {
		return ip;
	}
	public String getUrl() {
		return url;
	}
	public String getBrowser() {
		return browser;
	}
	public String getSo() {
		return so;
	}
	public Date getFecha() {
		return fecha;
	}
}
