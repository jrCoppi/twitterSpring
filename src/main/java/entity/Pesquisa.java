package entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pesquisa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_pesquisa;

	private Date dt_pesquisa;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_termo", referencedColumnName = "id_termo")
    private Termo id_termo;
	
	
	public Termo getId_termo() {
		return id_termo;
	}

	public void setId_termo(Termo id_termo) {
		this.id_termo = id_termo;
	}

	public long getIdpesquisa() {
		return id_pesquisa;
	}

	public Date getDtpesquisa() {
		return dt_pesquisa;
	}
	
	public void setDtpesquisa(Date dtpesquisa) {
		this.dt_pesquisa = dtpesquisa;
	}
}
