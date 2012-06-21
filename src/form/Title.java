package form;

/**
 * 信息标题类 post 回复的帖子 postUrl 回复帖子的链接 repliedUser 回复的用户 repliedUserUrl 用户链接
 * 
 * @author issac
 * 
 */
public class Title {
	public String post;
	public String postUrl;
	public String repliedUser;
	public String repliedUserUrl;

	public Title(String post, String postUrl, String repliedUser,
			String repliedUserUrl) {
		this.post = post;
		this.postUrl = postUrl;
		this.repliedUser = repliedUser;
		this.repliedUserUrl = repliedUserUrl;
	}

	public Title(String post, String postUrl, String time) {
		// TODO Auto-generated constructor stub
		this(post, postUrl, null, null);
	}

	public Title() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return post + "(url:" + postUrl + ")\n" + repliedUser + "(url:"
				+ repliedUserUrl + ")";
	}
}