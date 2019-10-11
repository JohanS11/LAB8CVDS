package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;

import java.util.Date;

import org.apache.ibatis.exceptions.PersistenceException;



public interface ClienteDAO {


	public Cliente load(long id) throws ExcepcionServiciosAlquiler;

	void save(Cliente cli) throws PersistenceException;

	void agregarItemRentado(long docu, Item item, java.sql.Date fechaini, java.sql.Date fechafin);

}
