package publish;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import models.ThreadModel;

public class InsertAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest req,
			HttpServletResponse res) {
		if(hasInsertByttonClicked(req)){
			InsertForm ia = (InsertForm) _form;
			int id     = ia.getId();
			String name   = ia.getName();
			String plice  = ia.getPlice();
			String phone  = ia.getPhone();
			String biography = ia.getBiography();
			ThreadModel tm = new ThreadModel();
			boolean judge = tm.insert(id,name,plice,phone,biography);
			if(judge){
				return mapping.findForward("inserSuccess");
			}else{
				String error = "全て、入力してください 。まだIDは間違います";
				req.setAttribute("errorMessage", error);
				return mapping.findForward("insertFailure");
			}
		}else{
			return mapping.findForward("success");
		}

	}
	private boolean hasInsertByttonClicked(HttpServletRequest req){
		return req.getParameterMap().containsKey("send");
	}


}
