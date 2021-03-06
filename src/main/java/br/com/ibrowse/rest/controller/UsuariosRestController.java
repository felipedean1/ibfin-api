/*
 * Created on 21 fev 2018 ( Time 15:06:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.com.ibrowse.bean.Usuarios;
import br.com.ibrowse.business.service.UsuariosService;
import br.com.ibrowse.web.listitem.UsuariosListItem;

/**
 * Spring MVC controller for 'Usuarios' management.
 */
@Controller
public class UsuariosRestController {

	@Resource
	private UsuariosService usuariosService;
	
	@RequestMapping( value="/items/usuarios",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UsuariosListItem> findAllAsListItems() {
		List<Usuarios> list = usuariosService.findAll();
		List<UsuariosListItem> items = new LinkedList<UsuariosListItem>();
		for ( Usuarios usuarios : list ) {
			items.add(new UsuariosListItem( usuarios ) );
		}
		return items;
	}
	
	@RequestMapping( value="/usuarios",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Usuarios> findAll() {
		return usuariosService.findAll();
	}

	@RequestMapping( value="/usuarios/{oidUsuarios}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Usuarios findOne(@PathVariable("oidUsuarios") Long oidUsuarios) {
		return usuariosService.findById(oidUsuarios);
	}
	
	@RequestMapping( value="/usuarios",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Usuarios create(@RequestBody Usuarios usuarios) {
		return usuariosService.create(usuarios);
	}

	@RequestMapping( value="/usuarios/{oidUsuarios}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Usuarios update(@PathVariable("oidUsuarios") Long oidUsuarios, @RequestBody Usuarios usuarios) {
		return usuariosService.update(usuarios);
	}

	@RequestMapping( value="/usuarios/{oidUsuarios}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("oidUsuarios") Long oidUsuarios) {
		usuariosService.delete(oidUsuarios);
	}
	
}
