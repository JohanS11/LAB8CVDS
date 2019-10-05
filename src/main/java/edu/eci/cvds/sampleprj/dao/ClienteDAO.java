package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import java.util.Date;

import org.apache.ibatis.exceptions.PersistenceException;



public interface ClienteDAO {


	public Cliente load(int id) throws PersistenceException;

	void save(Cliente cli) throws PersistenceException;

}
