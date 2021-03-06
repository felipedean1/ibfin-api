/*
 * Created on 21 fev 2018 ( Time 15:06:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.business.service;

import java.util.List;

import br.com.ibrowse.bean.Usuarios;
import br.com.ibrowse.dto.LoginFinanceiroDTO;
import br.com.ibrowse.dto.LoginResponseFinanceiroDTO;


/**
 * Business Service Interface for entity Usuarios.
 */
public interface UsuariosService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param oidUsuarios
	 * @return entity
	 */
	Usuarios findById(Long oidUsuarios  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Usuarios> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Usuarios save(Usuarios entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Usuarios update(Usuarios entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Usuarios create(Usuarios entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param oidUsuarios
	 */
	void delete( Long oidUsuarios );
	
	public LoginResponseFinanceiroDTO login(LoginFinanceiroDTO loginFinanceiroDTO);


}
