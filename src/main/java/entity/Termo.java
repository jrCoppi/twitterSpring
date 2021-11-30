package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Termo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_termo;

	private String ds_termo;
	
	public long getIdtermo() {
		return id_termo;
	}

	public String getDstermo() {
		return ds_termo;
	}
	
	public void setDstermo(String dstermo) {
		this.ds_termo = dstermo;
	}
}
