import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import util.HtmlParser;
import form.Message;

public class Main {
	public static void main(String[] args) {
		Document doc = null;
		try {
			doc = Jsoup.connect(
					"http://bbs.meizu.com/space.php?item=threads&uid=2").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Message> messages = HtmlParser.getMessages(doc);
		for (Message message : messages) {
			System.out.println(message);
		}
	}
}
