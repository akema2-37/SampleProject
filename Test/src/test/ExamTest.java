package test;

import org.junit.Test;

public class ExamTest {

	@Test
	public void test() {
		String q1 = "ほげ";
		String a = String.format("%sです%08dです", q1,49);
		System.out.println(a);
	}

}
