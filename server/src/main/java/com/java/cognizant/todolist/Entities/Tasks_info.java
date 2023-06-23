package com.java.cognizant.todolist.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


	@Entity
	@Table(name="Tasks_info")
		public class Tasks_info {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		@Column(name = "task_id")
		    private Long task_id;
		
		@Column(name = "task_name")
		    private String task_name;
		
		@Column(name = "task_start_date")
		    private String task_start_date;
		
		@Column(name = "task_end_date")
	    private String task_end_date;
		
		@Column(name = "task_category")
		    private String task_category;
		
		@Column(name = "isdone")
			private Boolean isdone;
		
		@ManyToOne
	    @JoinColumn(name = "user_id")
	    private User_info user_id;

		

		public Tasks_info(Long task_id, String task_name, String task_start_date, String task_end_date,
				String task_category, Boolean isdone, User_info user_id) {
			super();
			this.task_id = task_id;
			this.task_name = task_name;
			this.task_start_date = task_start_date;
			this.task_end_date = task_end_date;
			this.task_category = task_category;
			this.isdone = isdone;
			this.user_id = user_id;
		}



		public Tasks_info() {
	        // Empty constructor required by JPA
	    }



			public long getTask_id() {
				return task_id;
			}


			public void setTask_id(long task_id) {
				this.task_id = task_id;
			}


			public String getTask_name() {
				return task_name;
			}


			public void setTask_name(String task_name) {
				this.task_name = task_name;
			}


			public String getTask_start_date() {
				return task_start_date;
			}


			public void setTask_start_date(String task_start_date) {
				this.task_start_date = task_start_date;
			}


			public String getTask_end_date() {
				return task_end_date;
			}


			public void setTask_end_date(String task_end_date) {
				this.task_end_date = task_end_date;
			}


			public String getTask_category() {
				return task_category;
			}


			public void setTask_category(String task_category) {
				this.task_category = task_category;
			}


			public Boolean getIsdone() {
				return isdone;
			}


			public void setIsdone(Boolean isdone) {
				this.isdone = isdone;
			}



			public User_info getUser_id() {
				return user_id;
			}



			public void setUser_id(User_info user_id) {
				this.user_id = user_id;
			}
		    
			

		   
}
