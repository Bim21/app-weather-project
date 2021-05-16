package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IPPublic", catalog = "heroku_b127bd7a389e7b4")
public class IPPublic implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int count=0;
	
	@Id
	@Column(name = "IpPublic", nullable = false, length = 20)
	private String ipPublic;

	
	
	public IPPublic(String ipPublic) {
		super();
		this.ipPublic = ipPublic;
		setCount(count++);
	}
	
	public IPPublic() {
		super();
		
	}
	
	

	public String getIpPublic() {
		return ipPublic;
	}

	public void setIpPublic(String ipPublic) {
		this.ipPublic = ipPublic;
	}

	public static int getCount() {
		return count;
	}
	public static int setCount(int count) {
		return count;
	}

}
