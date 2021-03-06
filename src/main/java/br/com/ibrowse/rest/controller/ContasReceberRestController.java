/*
 * Created on 23 mai 2017 ( Time 18:19:53 )
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

import br.com.ibrowse.bean.ContasReceber;
import br.com.ibrowse.business.service.ContasReceberService;
import br.com.ibrowse.web.listitem.ContasReceberListItem;

/**
 * Spring MVC controller for 'ContasReceber' management.
 */
@Controller
public class ContasReceberRestController {

	@Resource
	private ContasReceberService contasReceberService;
	
	@RequestMapping( value="/items/contasReceber",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ContasReceberListItem> findAllAsListItems() {
		List<ContasReceber> list = contasReceberService.findAll();
		List<ContasReceberListItem> items = new LinkedList<ContasReceberListItem>();
		for ( ContasReceber contasReceber : list ) {
			items.add(new ContasReceberListItem( contasReceber ) );
		}
		return items;
	}
	
	@RequestMapping( value="/contasReceber",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ContasReceber> findAll() {
		return contasReceberService.findAll();
	}

	@RequestMapping( value="/contasReceber/{oidContasReceber}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ContasReceber findOne(@PathVariable("oidContasReceber") Long oidContasReceber) {
		return contasReceberService.findById(oidContasReceber);
	}
	
	@RequestMapping( value="/contasReceber",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ContasReceber create(@RequestBody ContasReceber contasReceber) {
		return contasReceberService.create(contasReceber);
	}

	@RequestMapping( value="/contasReceber/{oidContasReceber}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ContasReceber update(@PathVariable("oidContasReceber") Long oidContasReceber, @RequestBody ContasReceber contasReceber) {
		return contasReceberService.update(contasReceber);
	}

	@RequestMapping( value="/contasReceber/{oidContasReceber}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("oidContasReceber") Long oidContasReceber) {
		contasReceberService.delete(oidContasReceber);
	}
	
}
