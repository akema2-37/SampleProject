package publish;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ThreadModel;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SelectAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest req,
			HttpServletResponse res) {
	SelectForm sf =(SelectForm)_form;
	int id = sf.getId();
	String name = sf.getName();
	String plice = sf.getPlice();
	String phone = sf.getPhone();
	String biography = sf.getBiography();
	ThreadModel tm = new ThreadModel();


	List<ThreaBean> beans = tm.select(id, name, plice, phone,biography);
	if(beans==null){
		String error ="データが存在しません。";
		req.setAttribute("error", error);
		return mapping.findForward("insertFailure");

	}else{
		String insert ="検索結果は以下の通りです。";
		req.setAttribute("insertFailure", insert);
		req.setAttribute("select", beans);
		return mapping.findForward("success");
	}


	}

}
