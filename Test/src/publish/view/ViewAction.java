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

public class ViewAction extends Action {

	int limit = 5;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest req,
			HttpServletResponse res) {



		if(hasPByttonClicked(req)){
			ThreadModel tm = new ThreadModel();

			int page;
			int n =tm.countRecord();
			if(n%5==0){
				page = n / 5;
			}else{
				page = n / 5;
				page++;
			}
			int array[]=new int[page];
			for(int i = 0;i<page;i++){
				array[i]= i+1;
			}
			req.setAttribute("navis", array);

			int o = Integer.parseInt(req.getParameter("p"));
			if(o==1){
				List<ThreaBean> beans = tm.selectAll(limit,0);
				req.setAttribute("db", beans);
				return mapping.findForward("page");
			}else{
				int offset = o  * 5;

				List<ThreaBean> beans = tm.selectAll(limit, offset);
				req.setAttribute("db", beans);

				return mapping.findForward("page");
			}

		}else{
			ThreadModel tm = new ThreadModel();
			int p= 1;
			int page;
			int n =tm.countRecord();
			if(n%5==0){
				page = n / 5;
			}else{
				page = n / 5;
				page++;
			}
			int array[]=new int[page];
			for(int i = 0;i<page;i++){
				array[i]= p;
				p++;
			}
			req.setAttribute("navis", array);

			List<ThreaBean> beans = tm.selectAll(limit,0);
			req.setAttribute("db", beans);

			return mapping.findForward("firstopen");
		}


	}
	private boolean hasPByttonClicked(HttpServletRequest req){
		return req.getParameterMap().containsKey("p");

	}

}
