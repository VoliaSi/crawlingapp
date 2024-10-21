package com.example.volha.opsec.test.simpleapp.demo.service;

import com.example.volha.opsec.test.simpleapp.demo.data.CrawlSummary;
import com.example.volha.opsec.test.simpleapp.demo.repository.CrawlSummaryRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service
public class CrawlingService {
    private static final Logger logger = LoggerFactory.getLogger(CrawlingService.class);

    @Autowired
    private CrawlSummaryRepository crawlSummaryRepository;

    public CrawlSummary crawl(int crawlDepth, String stringUrl) {
        List<String> crawledUrls = new ArrayList<>();
        CrawlSummary crawlSummary = new CrawlSummary(stringUrl,
                0,
                0,
                0,
                0);

        crawlOneLevel(crawlDepth, 1, stringUrl, crawledUrls, crawlSummary);

        crawlSummaryRepository.save(crawlSummary);
        return crawlSummary;
    }

    private void crawlOneLevel(int crawlDepth, int currDepth, String
            stringUrl, List<String> crawledUrls, CrawlSummary crawlSummary) {
        if (currDepth <= crawlDepth) {
            Document urlContent = getUrlContent(stringUrl, crawledUrls);

            if (urlContent != null) {
                Elements urlContentLinks = urlContent.select("a[href]");
                logger.info("General found links number: {}", urlContentLinks.size());
                Elements imgs = urlContent.select("img[src]");
                crawlSummary.incrementImages(imgs.size());

                try {
                    String rootUrl = new URL(stringUrl).getHost();

                    for ( Element link : urlContentLinks ) {
                        String nextLink = link.absUrl("href");

                        incrementLinksCount(crawlSummary, rootUrl, nextLink);

                        if (!crawledUrls.contains(nextLink)) {
                            crawlOneLevel(crawlDepth, currDepth++, nextLink, crawledUrls, crawlSummary);
                        }
                    }


                } catch (MalformedURLException e) {
                    crawlSummary.incrementUnknownLinks();
                    e.printStackTrace();
                }
            }
        }
    }

    private void incrementLinksCount(CrawlSummary crawlSummary, String rootUrl, String nextLink) throws
            MalformedURLException {
        if (new URL(nextLink).getHost().equals(rootUrl)) {
            crawlSummary.incrementInternalLinks();
        } else {
            crawlSummary.incrementExternalLinks();
        }
    }

    private Document getUrlContent(String stringUrl, List<String> crawledUrls) {
        try {
            Connection connection = Jsoup.connect(stringUrl).followRedirects(false); // By default, it’s true
            Document document = connection.get();

            if (connection.response().statusCode() == 200) {
                logger.info("log Found link: {}", stringUrl);
                logger.info(" log link {} has root: {}", stringUrl, document.title());
                crawledUrls.add(stringUrl);
                return document;
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public void save(CrawlSummary crawlSummary) {
        crawlSummaryRepository.save(crawlSummary);
    }

    public List<CrawlSummary> findAll() {
        return crawlSummaryRepository.findAll();
    }
}
