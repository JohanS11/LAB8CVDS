package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.*;

import org.primefaces.PrimeFaces;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

@ManagedBean(name = "servicios")
@ApplicationScoped
public class Servicios extends BasePageBean {
	private List<Cliente> clientes;
	private List<ItemRentado> items;
	private Cliente clienteIngresado;
	private long idClienteIngresado;
	@Inject
	private ServiciosAlquiler service;
	
	public List<Item> itemsAlquilados(){
		return null;
	}
	public List<Cliente> getClientes() {
		List<Cliente> clientes = null;
		try {
			 clientes = service.consultarClientes();
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<ItemRentado> getItems() throws ExcepcionServiciosAlquiler {
		return items;
	}

	public void setItems(List<ItemRentado> list) {
		this.items = list;
	}
	public Cliente getClienteIngresado() {
		return clienteIngresado;
	}
	public void setClienteIngresado(Cliente clienteIngresado) {
		this.clienteIngresado = clienteIngresado;
	}
	public long getIdClienteIngresado() {
		return idClienteIngresado;
	}
	public void setIdClienteIngresado(long idClienteIngresado) throws ExcepcionServiciosAlquiler {
		setItems(service.consultarItemsCliente(idClienteIngresado));
		System.out.println(idClienteIngresado);
		System.out.println(service.consultarItemsCliente(idClienteIngresado));
		this.idClienteIngresado = idClienteIngresado;
	}
	
	
}
