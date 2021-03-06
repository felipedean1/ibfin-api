/*
 * Created on 23 mai 2017 ( Time 18:19:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import br.com.ibrowse.bean.ContasReceber;
import br.com.ibrowse.bean.jpa.ContasReceberEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ContasReceberServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public ContasReceberServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'ContasReceberEntity' to 'ContasReceber'
	 * @param contasReceberEntity
	 */
	public ContasReceber mapContasReceberEntityToContasReceber(ContasReceberEntity contasReceberEntity) {
		if(contasReceberEntity == null) {
			return null;
		}

		//--- Generic mapping 
		ContasReceber contasReceber = map(contasReceberEntity, ContasReceber.class);

		return contasReceber;
	}
	
	/**
	 * Mapping from 'ContasReceber' to 'ContasReceberEntity'
	 * @param contasReceber
	 * @param contasReceberEntity
	 */
	public void mapContasReceberToContasReceberEntity(ContasReceber contasReceber, ContasReceberEntity contasReceberEntity) {
		if(contasReceber == null) {
			return;
		}

		//--- Generic mapping 
		map(contasReceber, contasReceberEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}