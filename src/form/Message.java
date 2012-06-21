package form;

public class Message {
	public static final int TYPE_POST = 0;
	public static final int TYPE_REPLY = 1;

	private int type = TYPE_REPLY; // 帖子类型
	private Title title;
	private String time;
	private Quote quote;
	private String content; // 帖子内容
	private String url;

	public Message(int type, Title title, String time, Quote quote,
			String content, String url) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.title = title;
		this.time = time;
		this.quote = quote;
		this.content = content;
		this.url = url;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String typeString = type == TYPE_POST ? "主题" : "回复";
		return typeString + "\n" + "title:" + title + "\ntime:" + time
				+ "\nquote:" + quote + "\ncontent:" + content + "\nurl:" + url
				+ "\n\n\n";
	}

	public Title getTitle() {
		return title;
	}

	public String getTime() {
		return time;
	}

	public Quote getQuote() {
		return quote;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}
}
