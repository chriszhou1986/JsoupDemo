package form;
public class Quote {
	public String info;
	public String content;

	public Quote(String info, String content) {
		this.info = info;
		this.content = content;
	}

	@Override
	public String toString() {
		return info + "\n" + content;
	}
}