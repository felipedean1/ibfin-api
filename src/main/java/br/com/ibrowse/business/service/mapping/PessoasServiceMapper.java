/*
 * Created on 23 mai 2017 ( Time 18:19:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import br.com.ibrowse.bean.Pessoas;
import br.com.ibrowse.bean.jpa.PessoasEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class PessoasServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public PessoasServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'PessoasEntity' to 'Pessoas'
	 * @param pessoasEntity
	 */
	public Pessoas mapPessoasEntityToPessoas(PessoasEntity pessoasEntity) {
		if(pessoasEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Pessoas pessoas = map(pessoasEntity, Pessoas.class);

		return pessoas;
	}
	
	/**
	 * Mapping from 'Pessoas' to 'PessoasEntity'
	 * @param pessoas
	 * @param pessoasEntity
	 */
	public void mapPessoasToPessoasEntity(Pessoas pessoas, PessoasEntity pessoasEntity) {
		if(pessoas == null) {
			return;
		}

		//--- Generic mapping 
		map(pessoas, pessoasEntity);

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