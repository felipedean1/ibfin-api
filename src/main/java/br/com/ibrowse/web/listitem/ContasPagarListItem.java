/*
 * Created on 23 mai 2017 ( Time 18:19:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.web.listitem;

import br.com.ibrowse.bean.ContasPagar;
import br.com.ibrowse.web.common.ListItem;

public class ContasPagarListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ContasPagarListItem(ContasPagar contasPagar) {
		super();

		this.value = ""
			 + contasPagar.getOidContasPagar()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = contasPagar.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
