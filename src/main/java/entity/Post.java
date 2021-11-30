package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_post;

	private String ds_post;
	
	public long getIdPost() {
		return id_post;
	}

	public String getDsPost() {
		return ds_post;
	}
	
	public void setDsPost(String dsPost) {
		this.ds_post = dsPost;
	}
}
