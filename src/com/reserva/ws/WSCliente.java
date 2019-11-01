package com.reserva.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.reserva.dao.ClienteFacade;
import com.reserva.entity.Cliente;
/*
 * conversion de un array a un jsonArray y luego a un jsonObject
 * https://stackoverflow.com/questions/18857884/how-to-convert-arraylist-of-custom-class-to-jsonarray-in-java
 * */
@Path("/WSCliente")
public class WSCliente {
	
		private ClienteFacade cf;
		private Cliente c;
		
		public WSCliente() {
			cf = new ClienteFacade();
			c = new Cliente();
		}
		
		/*Metodo para guardar en la BD*/
		@POST
		@Path("/saveClient")
		@Produces({MediaType.APPLICATION_JSON})
		public String guardarCliente(@QueryParam("nombre") String nombre ,@QueryParam("apellido") String apellido,@QueryParam("dui") String dui){
			if (cf.create(new Cliente(0,nombre, apellido, dui))){
				return "Cliente Ingresado";
			}else {
				return "Ocurrio un problema";
			}
		}
		
		/*Metodo para eliminar registros de la BD*/
		@PUT
		@Path("/deleteCliente")
		@Produces({MediaType.APPLICATION_JSON})
		public String getUsuario(@QueryParam("idCliente")int idCliente) {
			if (idCliente != 0) {
				this.c = cf.findId(idCliente);
				cf.delete(c);
				return "datos eliminados correctamente";	
			}else {
				return "ocurrio un problema";	
			}
		}
		
		/*Metodo para mostrar los datos de BD*/
		@GET
		@Path("/listaCliente")
		@Produces(MediaType.APPLICATION_JSON)
		public String clientesAll() {
			List<Cliente> lista = new ArrayList<Cliente>();
			lista = cf.mostrar();
			
			Gson gson = new Gson();
			String data = gson.toJson(lista);
			JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
			String resultado = gson.toJson(jsonArray);
			return resultado;
		}
		
}
