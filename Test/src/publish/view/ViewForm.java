package publish.view;

import org.apache.struts.action.ActionForm;

public class ViewForm extends ActionForm{
	private String id;
	private String name;
	private String plice;
	private String phone;


	public String getId() {
		return id;
	}
	public void setId(String id) {
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



}
