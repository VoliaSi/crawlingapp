package com.example.volha.opsec.test.simpleapp.demo.service;

import com.example.volha.opsec.test.simpleapp.demo.data.CrawlSummary;
import org.springframework.stereotype.Service;

    @Service
    public class CrawlingService {


//        @Autowired
//        private CrawlingSummaryRepository crawlingSummaryRepository;

        public CrawlSummary crawl(String stringUrl) {
            CrawlSummary crawlSummary = new CrawlSummary("site1", "url", 3, 7, 8);
            System.out.println("crawlSummary" + crawlSummary.toString());
            return crawlSummary;
        }

    }
