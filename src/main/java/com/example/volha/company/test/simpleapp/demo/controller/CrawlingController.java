package com.example.volha.company.test.simpleapp.demo.controller;

import com.example.volha.company.test.simpleapp.demo.data.CrawlSummary;
import com.example.volha.company.test.simpleapp.demo.service.CrawlingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/demo/crawl")
public class CrawlingController {
    private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);

    @Autowired
    private CrawlingService crawlingService;

    @PostMapping
    public ResponseEntity<CrawlSummary> crawl(@RequestParam String url,
                                              @RequestParam(defaultValue = "1") int depth) {
        try {
            new URL(url);
            return ResponseEntity.ok(crawlingService.crawl(depth, url));
        } catch (MalformedURLException e) {
            logger.error("The provided url {} is not valid: {}", url, e.getMessage(), e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public List<CrawlSummary> getAll() {
        return crawlingService.findAll();
    }

}
