package com.catalogo.CatalogoShopMo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean verify=false;
    private Integer cantidad;
    private Integer unicode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	
	public Integer getUnicode() {
		return unicode;
	}
	public void setUnicode(Integer unicode) {
		this.unicode = unicode;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Boolean getVerify() {
		return verify;
	}
	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	

	public Categorias(String nombre, Boolean verify, Integer cantidad, Integer unicode) {
		super();
		this.nombre = nombre;
		this.verify = verify;
		this.cantidad = cantidad;
		this.unicode = unicode;
	}
	public Categorias() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
