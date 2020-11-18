package com.bw.model;

/**
 * 
 * @author xiebaowei
 *
 */
public class AdjuBean {

    private String adjudicator_id;
    private String adjudicator_password;
    private String adjudicator_name;
 
    public AdjuBean() {
    }

   

    public AdjuBean(String adjudicator_id,  String adjudicator_name) {
		super();
		this.adjudicator_id = adjudicator_id;
		this.adjudicator_name = adjudicator_name;
		
	}



	public String getAdjudicator_id() {
		return adjudicator_id;
	}



	public void setAdjudicator_id(String adjudicator_id) {
		this.adjudicator_id = adjudicator_id;
	}



	public String getAdjudicator_password() {
		return adjudicator_password;
	}



	public void setAdjudicator_password(String adjudicator_password) {
		this.adjudicator_password = adjudicator_password;
	}



	public String getAdjudicator_name() {
        return adjudicator_name;
    }

    public void setAdjudicator_name(String adjuName) {
        this.adjudicator_name = adjuName;
    }



	@Override
	public String toString() {
		return "AdjuBean [adjudicator_id=" + adjudicator_id + ", adjudicator_password=" + adjudicator_password
				+ ", adjudicator_name=" + adjudicator_name + "]";
	}


    
    
    
    
}

