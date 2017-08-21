package publish;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import models.ThreadModel;

public class DeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping,ActionForm _form,HttpServletRequest req,
			HttpServletResponse res){
		if(hasdeleteByttonClicked(req)){
			int id = Integer.parseInt(req.getParameter("id"));
			ThreadModel tm = new ThreadModel();
			tm.delete(id);
			return mapping.findForward("successDelete");

		}else{
			int id = Integer.parseInt(req.getParameter("id"));
			ThreadModel tm = new ThreadModel();
			List<ThreaBean> bean = tm.idAll(id);
			req.setAttribute("db", bean);

			return mapping.findForward("success");
		}


	}
	private boolean hasdeleteByttonClicked(HttpServletRequest req){
		return req.getParameterMap().containsKey("delete");
	}

}
