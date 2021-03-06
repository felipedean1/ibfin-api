/*
 * Created on 23 mai 2017 ( Time 18:19:52 )
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

import br.com.ibrowse.bean.Bancos;
import br.com.ibrowse.business.service.BancosService;
import br.com.ibrowse.web.listitem.BancosListItem;

/**
 * Spring MVC controller for 'Bancos' management.
 */
@Controller
public class BancosRestController {

	@Resource
	private BancosService bancosService;
	
	@RequestMapping( value="/items/bancos",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<BancosListItem> findAllAsListItems() {
		List<Bancos> list = bancosService.findAll();
		List<BancosListItem> items = new LinkedList<BancosListItem>();
		for ( Bancos bancos : list ) {
			items.add(new BancosListItem( bancos ) );
		}
		return items;
	}
	
	@RequestMapping( value="/bancos",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Bancos> findAll() {
		return bancosService.findAll();
	}

	@RequestMapping( value="/bancos/{oidBancos}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Bancos findOne(@PathVariable("oidBancos") Long oidBancos) {
		return bancosService.findById(oidBancos);
	}
	
	@RequestMapping( value="/bancos",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Bancos create(@RequestBody Bancos bancos) {
		return bancosService.create(bancos);
	}

	@RequestMapping( value="/bancos/{oidBancos}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Bancos update(@PathVariable("oidBancos") Long oidBancos, @RequestBody Bancos bancos) {
		return bancosService.update(bancos);
	}

	@RequestMapping( value="/bancos/{oidBancos}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("oidBancos") Long oidBancos) {
		bancosService.delete(oidBancos);
	}
	
}
