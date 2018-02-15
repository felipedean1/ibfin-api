/*
 * Created on 23 mai 2017 ( Time 18:19:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//--- Entities
import br.com.ibrowse.bean.TiposTitulos;
//--- Services 
import br.com.ibrowse.business.service.TiposTitulosService;
//--- Common classes
import br.com.ibrowse.web.common.AbstractController;
import br.com.ibrowse.web.common.FormMode;
import br.com.ibrowse.web.common.Message;
import br.com.ibrowse.web.common.MessageType;


/**
 * Spring MVC controller for 'TiposTitulos' management.
 */
@Controller
@RequestMapping("/tiposTitulos")
public class TiposTitulosController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "tiposTitulos";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "tiposTitulos/form";
	private static final String JSP_LIST   = "tiposTitulos/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/tiposTitulos/create";
	private static final String SAVE_ACTION_UPDATE   = "/tiposTitulos/update";

	//--- Main entity service
	@Resource
    private TiposTitulosService tiposTitulosService; // Injected by Spring
	//--- Other service(s)

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public TiposTitulosController() {
		super(TiposTitulosController.class, MAIN_ENTITY_NAME );
		log("TiposTitulosController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------

	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param tiposTitulos
	 */
	private void populateModel(Model model, TiposTitulos tiposTitulos, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, tiposTitulos);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of TiposTitulos found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<TiposTitulos> list = tiposTitulosService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new TiposTitulos
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		TiposTitulos tiposTitulos = new TiposTitulos();	
		populateModel( model, tiposTitulos, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing TiposTitulos
	 * @param model Spring MVC model
	 * @param oidTiposTitulos  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{oidTiposTitulos}")
	public String formForUpdate(Model model, @PathVariable("oidTiposTitulos") Long oidTiposTitulos ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		TiposTitulos tiposTitulos = tiposTitulosService.findById(oidTiposTitulos);
		populateModel( model, tiposTitulos, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param tiposTitulos  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid TiposTitulos tiposTitulos, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				TiposTitulos tiposTitulosCreated = tiposTitulosService.create(tiposTitulos); 
				model.addAttribute(MAIN_ENTITY_NAME, tiposTitulosCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, tiposTitulos.getOidTiposTitulos() );
			} else {
				populateModel( model, tiposTitulos, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "tiposTitulos.error.create", e);
			populateModel( model, tiposTitulos, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param tiposTitulos  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid TiposTitulos tiposTitulos, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				TiposTitulos tiposTitulosSaved = tiposTitulosService.update(tiposTitulos);
				model.addAttribute(MAIN_ENTITY_NAME, tiposTitulosSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, tiposTitulos.getOidTiposTitulos());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, tiposTitulos, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "tiposTitulos.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, tiposTitulos, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param oidTiposTitulos  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{oidTiposTitulos}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("oidTiposTitulos") Long oidTiposTitulos) {
		log("Action 'delete'" );
		try {
			tiposTitulosService.delete( oidTiposTitulos );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "tiposTitulos.error.delete", e);
		}
		return redirectToList();
	}

}