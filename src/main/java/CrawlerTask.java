import us.codecraft.webmagic.Spider;

public class CrawlerTask {

    public static void main(String[] args) {
        Spider.create(new MyProcessor()).addUrl("https://blog.csdn.net/nav/ai");
    }
}
