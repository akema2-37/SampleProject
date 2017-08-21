package publish;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import models.ThreadModel;

public class UpdateAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest req,
			HttpServletResponse res) {
		if(hasUpdateByttonClicked(req)){
			UpdateForm uf =(UpdateForm)_form;
			String name = uf.getName();
			String plice = uf.getPlice();
			String phone = uf.getPhone();
			String biography = uf.getBiography();
			int id = Integer.parseInt(req.getParameter("id"));
			ThreadModel tm = new ThreadModel();
			boolean Judge = tm.update(name, plice, phone,biography, id);
			if(Judge){
				return mapping.findForward("updateSuccess");
			}else{

				List<ThreaBean> bean = tm.idAll(id);
				req.setAttribute("db",bean);
				String error ="名前、住所、携帯、経歴は空欄することができません";
				req.setAttribute("error",error);
				return mapping.findForward("error");
			}

		}else{
			ThreadModel tm = new ThreadModel();
			int id = Integer.parseInt(req.getParameter("id"));
			List<ThreaBean> bean = tm.idAll(id);
			req.setAttribute("db",bean);
			return mapping.findForward("success");
		}
	}
	private boolean hasUpdateByttonClicked(HttpServletRequest req){
		return req.getParameterMap().containsKey("send");
	}

}
