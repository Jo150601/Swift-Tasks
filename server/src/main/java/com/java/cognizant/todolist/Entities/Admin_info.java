package com.java.cognizant.todolist.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
	import jakarta.persistence.Table;

		@Entity
		@Table(name="Admin_info")
		public class Admin_info {
			@Id
			
			@Column(name ="Admin_id")
			private String Admin_id;
			@Column(name="Admin_name")
			private String Admin_name;
			@Column(name="Admin_email")
			private String Admin_email;
			@Column(name="Admin_phone")
			private long Admin_phoneno;
			
			public Admin_info(String admin_id, String admin_name, String admin_email, long admin_phoneno) {
				super();
				Admin_id = admin_id;
				Admin_name = admin_name;
				Admin_email = admin_email;
				Admin_phoneno = admin_phoneno;
			}
			public Admin_info() {
				super();
				// TODO Auto-generated constructor stub
			}
			public String getAdmin_id() {
				return Admin_id;
			}
			public void setAdmin_id(String admin_id) {
				Admin_id = admin_id;
			}
			public String getAdmin_name() {
				return Admin_name;
			}
			public void setAdmin_name(String admin_name) {
				Admin_name = admin_name;
			}
			public String getAdmin_email() {
				return Admin_email;
			}
			public void setAdmin_email(String admin_email) {
				Admin_email = admin_email;
			}
			public long getAdmin_phoneno() {
				return Admin_phoneno;
			}
			public void setAdmin_phoneno(long admin_phoneno) {
				Admin_phoneno = admin_phoneno;
			}
	
			
}

