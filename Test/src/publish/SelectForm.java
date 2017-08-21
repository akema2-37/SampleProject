package publish;

import org.apache.struts.action.ActionForm;

public class SelectForm extends ActionForm {
	private int id;
	private String name;
	private String plice;
	private String phone;
	private String biography;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlice() {
		return plice;
	}
	public void setPlice(String plice) {
		this.plice = plice;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}

}
