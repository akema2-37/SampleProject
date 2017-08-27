package test;

public class Sample {

	Sample() {

		System.out.println("コンストラクタ追加");

	}

	Sample(String s) {

		System.out.println(s + "さんこんにちは");
		System.out.println("よろしくお願いします");

	}

	Sample(String s, int i) {

		System.out.println(s + "さんの年齢は" + i + "ですぜ");

	}

	public void test() {

	}
}
