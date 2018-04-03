package chapter1.enums;

public enum Title {

	MR("Mr. "), MRS("Mrs. "), MS("Ms. ");
	private String title;

	private Title(String s) {
		title = s;
	}

	public String format(String first, String last) {
		return title + " " + first + " " + last;
	}
}
