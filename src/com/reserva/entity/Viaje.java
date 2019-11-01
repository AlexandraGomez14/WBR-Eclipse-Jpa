package com.reserva.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the viaje database table.
 * 
 */
@Entity
@NamedQuery(name="Viaje.findAll", query="SELECT v FROM Viaje v")
public class Viaje implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idViaje;
	private String destino;
	private String distanciaViaje;
	private Date fecha;
	private String horaFin;
	private String horaInicio;
	private String origen;
	private BigDecimal precio;
	private String tiempoViaje;
	private Conductor conductor;
	private Cliente cliente;

	public Viaje() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_viaje")
	public int getIdViaje() {
		return this.idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}


	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}


	@Column(name="distancia_viaje")
	public String getDistanciaViaje() {
		return this.distanciaViaje;
	}

	public void setDistanciaViaje(String distanciaViaje) {
		this.distanciaViaje = distanciaViaje;
	}


	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Column(name="hora_fin")
	public String getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}


	@Column(name="hora_inicio")
	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	@Column(name="tiempo_viaje")
	public String getTiempoViaje() {
		return this.tiempoViaje;
	}

	public void setTiempoViaje(String tiempoViaje) {
		this.tiempoViaje = tiempoViaje;
	}


	//bi-directional many-to-one association to Conductor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_conductor")
	public Conductor getConductor() {
		return this.conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}


	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}