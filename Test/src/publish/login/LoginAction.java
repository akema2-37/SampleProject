package publish.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import models.LoginVerificationModel;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm _form, HttpServletRequest req,
			HttpServletResponse res) {

		if(hasLoginButtonClicked(req)){

			LoginForm form = (LoginForm) _form;
			String name = form.getName();
			String password = form.getPassword();

			LoginVerificationModel model = new LoginVerificationModel();
			boolean isLogedIn =model.verify(name, password);

			if(isLogedIn){
				return mapping.findForward("success_login");
			}else{
				String error ="ユーザとパスワードが違います";
				req.setAttribute("errorMessage",error);
				return mapping.findForward("fail_login");
			}

		} else {
			return mapping.findForward("firstopen");
		}
	}

	private boolean hasLoginButtonClicked(HttpServletRequest req) {
		return req.getParameterMap().containsKey("btnLoginClicked");
	}

}
