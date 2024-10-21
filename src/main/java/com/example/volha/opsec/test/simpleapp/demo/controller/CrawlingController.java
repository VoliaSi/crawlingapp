package com.example.volha.opsec.test.simpleapp.demo.controller;

import com.example.volha.opsec.test.simpleapp.demo.data.CrawlSummary;
import com.example.volha.opsec.test.simpleapp.demo.service.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/demo/crawl")
public class CrawlingController {

    @Autowired
    private CrawlingService crawlingService;

    @PostMapping
    public ResponseEntity<CrawlSummary> crawl(@RequestParam String url,
                                              @RequestParam(defaultValue = "1") int depth) {
        try {
            new URL(url);
            crawlingService.save(crawlingService.crawl(depth, url));
            return ResponseEntity.ok(crawlingService.crawl(depth, url));
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public List<CrawlSummary> getAll() {
        return crawlingService.findAll();
    }

}
