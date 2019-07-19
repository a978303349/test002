import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyProcessor implements PageProcessor {
    //分析页面
    public void process(Page page) {
        System.out.println(page.getHtml());
        //把当前页面的所有链接都添加到目标页面进行爬取
        page.addTargetRequest((Request) page.getHtml().links().all());

        System.out.println(page.getHtml().xpath("//[@id=\"nav\"]/div/div/ul/li[5]/a/text()").toString());
    }

    public Site getSite() {
        Site site=new Site();
        //设置失败3次,设置两个页面之间爬去间隔为0.1s
        site.setRetryTimes(3).setSleepTime(100);
        return site;
    }
}
