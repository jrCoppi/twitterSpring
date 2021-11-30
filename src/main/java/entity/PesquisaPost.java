package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PesquisaPost {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_pesquisa_post;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pesquisa", referencedColumnName = "id_pesquisa")
    private Pesquisa id_pesquisa;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_post", referencedColumnName = "id_post")
    private Post id_post;

	public Pesquisa getId_pesquisa() {
		return id_pesquisa;
	}

	public void setId_pesquisa(Pesquisa id_pesquisa) {
		this.id_pesquisa = id_pesquisa;
	}

	public Post getId_post() {
		return id_post;
	}

	public void setId_post(Post id_post) {
		this.id_post = id_post;
	}

	public long getIdpesquisaPost() {
		return id_pesquisa_post;
	}
}
