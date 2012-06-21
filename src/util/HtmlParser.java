package util;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import form.Message;
import form.Quote;
import form.Title;

public class HtmlParser {
	public static ArrayList<Message> getMessages(Document document) {
		ArrayList<Message> messages = new ArrayList<>();
		// 找到对应的帖子
		Elements messageElementes = document.getElementsByTag("li").select(
				"li:has(span.x_title)");
		for (Element messageElement : messageElementes) {

			// 解析标题
			int type = Message.TYPE_POST;
			Title title = new Title();

			Element titleElement = messageElement.select("span.x_title").get(0);
			Elements titleItems = titleElement.select("a.x_blue");
			for (Element element : titleItems) {
				String url = element.attr("abs:href");
				if (url.contains("uid")) {
					type = Message.TYPE_REPLY;
					title.repliedUserUrl = url;
					title.repliedUser = element.html();
				} else {
					title.post = element.html();
					title.postUrl = url;
				}
			}

			// 解析时间
			String time = messageElement.select("span.x_time").get(0).html();

			// 解析内容
			Element contentElement = messageElement.select("div.msge").get(0);
			Elements urlElements = messageElement.select("a");
			String url = urlElements.last().attr("abs:href");

			// 解析引用
			Elements quoteElements = messageElement.select("blockquote");
			Quote quote = null;
			if (!quoteElements.isEmpty()) {
				java.util.List<TextNode> textNodes = quoteElements.get(0)
						.textNodes();
				quote = new Quote(quoteElements.get(0).select("i").text()
						+ textNodes.get(1), textNodes.get(textNodes.size() - 1)
						.toString());
			}

			String content = contentElement.ownText();

			Message message = new Message(type, title, time, quote, content,
					url);
			messages.add(message);
		}
		return messages;
	}
}
