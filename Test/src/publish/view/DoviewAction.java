package publish.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import models.ThreadModel;
import publish.ThreaBean;

public class DoviewAction extends Action{public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest req,
		HttpServletResponse res) {
		ThreadModel tm = new ThreadModel();
		int limit = 5;
		int p = Integer.parseInt(req.getParameter("p"));
		int offset = (p - 1) * 5;

		List<ThreaBean> beans = tm.selectAll(limit, offset);
		req.setAttribute("db", beans);

		return mapping.findForward("success");
}

}
