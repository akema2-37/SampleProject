package test;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import models.LoginVerificationModel;

public class LoginVerificationTest {

	@Test
	public void test() throws NoSuchAlgorithmException {
		LoginVerificationModel model = new LoginVerificationModel();
		System.out.println(model.sha256("aa"));
	}

}
