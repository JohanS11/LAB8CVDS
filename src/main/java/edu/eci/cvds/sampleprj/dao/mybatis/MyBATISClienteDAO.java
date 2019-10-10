package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;

import com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;

import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBATISClienteDAO implements ClienteDAO{

  @Inject
  private ClienteMapper ClienteMapper;    

  @Override
  public void save(Cliente cli) throws PersistenceException{
  try{
	  
	 ClienteMapper.AgregarCliente(cli);
	 
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar un cliente "+cli.toString(),e);
  }        

  }

  @Override
  public Cliente load(long id) throws ExcepcionServiciosAlquiler {
	  Cliente cliente = null;
	  try{
		  cliente = ClienteMapper.consultarCliente(id);
		  if (cliente == null) {
			  throw new ExcepcionServiciosAlquiler("Error al consultar");
		  }
	  } catch(org.apache.ibatis.exceptions.PersistenceException e){
		  throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,e);
	  }
	  return cliente;

  }

}