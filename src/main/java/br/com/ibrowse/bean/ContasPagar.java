/*
 * Created on 23 mai 2017 ( Time 18:19:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ibrowse.bean.jpa.BancosEntity;
import br.com.ibrowse.bean.jpa.CentrosCustosEntity;
import br.com.ibrowse.bean.jpa.PessoasEntity;
import br.com.ibrowse.bean.jpa.TiposTitulosEntity;

public class ContasPagar implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long oidContasPagar;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    @Size( min = 1, max = 100 )
    private String nrDocumentoFiscal;

    @NotNull
    private Long oidPessoas;

    @NotNull
    private Date dtPrevisao;

    @NotNull
    private Date dtVencimento;

    private Date dtPagamento;

    @NotNull
    private Long vrBruto;

    private Long vrJuros;

    private Long vrDesconto;

    private Long oidTiposTitulos;

    private Long oidBancos;
    
    private Long oidCentrosCustos;

    @Size( max = 20 )
    private String dsFormaPagamento;

    @Size( max = 500 )
    private String dsObservacao;

    @NotNull
    @Size( min = 1, max = 30 )
    private String dsUsuAlter = "IBROWSE";

    @NotNull
    private Date dtUltAlter = new Date();

    @NotNull
    private Long vsVersao = 0L;
    
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    private PessoasEntity pessoa;
    
    private TiposTitulosEntity tiposTitulo;
    
    private BancosEntity banco;
    
    private CentrosCustosEntity centrosCusto;

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setOidContasPagar( Long oidContasPagar ) {
        this.oidContasPagar = oidContasPagar ;
    }

    public Long getOidContasPagar() {
        return this.oidContasPagar;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setNrDocumentoFiscal( String nrDocumentoFiscal ) {
        this.nrDocumentoFiscal = nrDocumentoFiscal;
    }
    public String getNrDocumentoFiscal() {
        return this.nrDocumentoFiscal;
    }

    public void setOidPessoas( Long oidPessoas ) {
        this.oidPessoas = oidPessoas;
    }
    public Long getOidPessoas() {
        return this.oidPessoas;
    }

    public void setDtPrevisao( Date dtPrevisao ) {
        this.dtPrevisao = dtPrevisao;
    }
    public Date getDtPrevisao() {
        return this.dtPrevisao;
    }

    public void setDtVencimento( Date dtVencimento ) {
        this.dtVencimento = dtVencimento;
    }
    public Date getDtVencimento() {
        return this.dtVencimento;
    }

    public void setDtPagamento( Date dtPagamento ) {
        this.dtPagamento = dtPagamento;
    }
    public Date getDtPagamento() {
        return this.dtPagamento;
    }

    public void setVrBruto( Long vrBruto ) {
        this.vrBruto = vrBruto;
    }
    public Long getVrBruto() {
        return this.vrBruto;
    }

    public void setVrJuros( Long vrJuros ) {
        this.vrJuros = vrJuros;
    }
    public Long getVrJuros() {
        return this.vrJuros;
    }

    public void setVrDesconto( Long vrDesconto ) {
        this.vrDesconto = vrDesconto;
    }
    public Long getVrDesconto() {
        return this.vrDesconto;
    }

    public void setOidTiposTitulos( Long oidTiposTitulos ) {
        this.oidTiposTitulos = oidTiposTitulos;
    }
    public Long getOidTiposTitulos() {
        return this.oidTiposTitulos;
    }

    public void setOidBancos( Long oidBancos ) {
        this.oidBancos = oidBancos;
    }
    public Long getOidBancos() {
        return this.oidBancos;
    }

    public void setDsFormaPagamento( String dsFormaPagamento ) {
        this.dsFormaPagamento = dsFormaPagamento;
    }
    public String getDsFormaPagamento() {
        return this.dsFormaPagamento;
    }

    public void setDsObservacao( String dsObservacao ) {
        this.dsObservacao = dsObservacao;
    }
    public String getDsObservacao() {
        return this.dsObservacao;
    }

    public Long getOidCentrosCustos() {
		return oidCentrosCustos;
	}
	public void setOidCentrosCustos(Long oidCentrosCustos) {
		this.oidCentrosCustos = oidCentrosCustos;
	}

	public void setDsUsuAlter( String dsUsuAlter ) {
        this.dsUsuAlter = dsUsuAlter;
    }
    public String getDsUsuAlter() {
        return this.dsUsuAlter;
    }

    public void setDtUltAlter( Date dtUltAlter ) {
        this.dtUltAlter = dtUltAlter;
    }
    public Date getDtUltAlter() {
        return this.dtUltAlter;
    }

    public void setVsVersao( Long vsVersao ) {
        this.vsVersao = vsVersao;
    }
    public Long getVsVersao() {
        return this.vsVersao;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public PessoasEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoasEntity pessoa) {
		this.pessoa = pessoa;
	}

	public TiposTitulosEntity getTiposTitulo() {
		return tiposTitulo;
	}

	public void setTiposTitulo(TiposTitulosEntity tiposTitulo) {
		this.tiposTitulo = tiposTitulo;
	}

	public BancosEntity getBanco() {
		return banco;
	}

	public void setBanco(BancosEntity banco) {
		this.banco = banco;
	}

	public CentrosCustosEntity getCentrosCusto() {
		return centrosCusto;
	}

	public void setCentrosCusto(CentrosCustosEntity centrosCusto) {
		this.centrosCusto = centrosCusto;
	}
    
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(oidContasPagar);
        sb.append("|");
        sb.append(nrDocumentoFiscal);
        sb.append("|");
        sb.append(oidPessoas);
        sb.append("|");
        sb.append(dtPrevisao);
        sb.append("|");
        sb.append(dtVencimento);
        sb.append("|");
        sb.append(dtPagamento);
        sb.append("|");
        sb.append(vrBruto);
        sb.append("|");
        sb.append(vrJuros);
        sb.append("|");
        sb.append(vrDesconto);
        sb.append("|");
        sb.append(oidTiposTitulos);
        sb.append("|");
        sb.append(oidBancos);
        sb.append("|");
        sb.append(dsFormaPagamento);
        sb.append("|");
        sb.append(dsObservacao);
        sb.append("|");
        sb.append(dsUsuAlter);
        sb.append("|");
        sb.append(dtUltAlter);
        sb.append("|");
        sb.append(vsVersao);
        return sb.toString(); 
    }

}
