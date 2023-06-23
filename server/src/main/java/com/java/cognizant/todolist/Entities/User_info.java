package com.java.cognizant.todolist.Entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User_info {
	@Id
	@Column(name = "user_id")
		private String user_id;
	@Column(name = "user_name")
	    private String user_name;
	
	@Column(name = "user_email")
	    private String user_email;
	@Column(name = "user_phoneno")
	    private long user_phoneno;
	
	
		public User_info() {
			super();
		}

		
		public User_info(String user_id, String user_name, String user_email, long user_phoneno) {
			super();
	        this.user_id = user_id;
	        this.user_name = user_name;
	        this.user_email = user_email;
	        this.user_phoneno = user_phoneno;
	    }
		
		
		public String getUser_id() {
	    	return user_id;
	    }
	    public void setUser_id(String user_id) {
	    	this.user_id = user_id;
	    }
	    public String getUser_name() {
	        return user_name;
	    }
	    public void setUser_name(String user_name) {
	        this.user_name = user_name;
	    }
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public long getUser_phoneno() {
			return user_phoneno;
		}
		
		public void setUser_phoneno(long user_phoneno) {
		    this.user_phoneno = user_phoneno;
			
		}
		
	  
}

