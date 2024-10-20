package com.example.volha.opsec.test.simpleapp.demo.controller;

import com.example.volha.opsec.test.simpleapp.demo.data.CrawlSummary;
import com.example.volha.opsec.test.simpleapp.demo.service.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/demo/crawl")
public class CrawlingController {

    @Autowired
    private CrawlingService crawlingService;

    @GetMapping
    public String crawl() {
        // Simulate a crawl action or return a success message
        return "Crawl endpoint reached!";
    }

    @PostMapping
    public ResponseEntity<CrawlSummary> crawl(@RequestParam String url,
                                              @RequestParam(defaultValue = "2") int depth) {
        try {
            new URL(url);
            return ResponseEntity.ok(crawlingService.crawl(depth, url));
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


//
//    @Autowired
//    private CrawlSummaryService crawlSummaryService;
//
//    // Save a CrawlSummary (POST)
//    @PostMapping
//    public ResponseEntity<CrawlSummary> saveCrawlSummary(@RequestBody CrawlSummary crawlSummary) {
//        CrawlSummary savedCrawlSummary = crawlSummaryService.saveCrawlSummary(crawlSummary);
//        return new ResponseEntity<>(savedCrawlSummary, HttpStatus.CREATED);
//    }
//
//    // Get all CrawlSummaries (GET)
//    @GetMapping
//    public ResponseEntity<List<CrawlSummary>> getAllCrawlSummaries() {
//        List<CrawlSummary> crawlSummaries = crawlSummaryService.getAllCrawlSummaries();
//        return new ResponseEntity<>(crawlSummaries, HttpStatus.OK);
//    }
//
//    // Get a CrawlSummary by ID (GET)
//    @GetMapping("/{id}")
//    public ResponseEntity<CrawlSummary> getCrawlSummaryById(@PathVariable Long id) {
//        CrawlSummary crawlSummary = crawlSummaryService.getCrawlSummaryById(id);
//        if (crawlSummary != null) {
//            return new ResponseEntity<>(crawlSummary, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
