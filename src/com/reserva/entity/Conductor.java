package com.reserva.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conductor database table.
 * 
 */
@Entity
@NamedQuery(name="Conductor.findAll", query="SELECT c FROM Conductor c")
public class Conductor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idConductor;
	private String apellido;
	private String direccion;
	private String dui;
	private String nombre;
	private String numLicencia;
	private String tipoVehiculo;
	private List<Viaje> viajes;

	public Conductor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conductor")
	public int getIdConductor() {
		return this.idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="num_licencia")
	public String getNumLicencia() {
		return this.numLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}


	@Column(name="tipo_vehiculo")
	public String getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	//bi-directional many-to-one association to Viaje
	@OneToMany(mappedBy="conductor")
	public List<Viaje> getViajes() {
		return this.viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public Viaje addViaje(Viaje viaje) {
		getViajes().add(viaje);
		viaje.setConductor(this);

		return viaje;
	}

	public Viaje removeViaje(Viaje viaje) {
		getViajes().remove(viaje);
		viaje.setConductor(null);

		return viaje;
	}

}