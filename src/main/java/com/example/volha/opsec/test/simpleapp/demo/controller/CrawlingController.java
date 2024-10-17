package com.example.volha.opsec.test.simpleapp.demo.controller;

import com.example.volha.opsec.test.simpleapp.demo.data.CrawlSummary;
import com.example.volha.opsec.test.simpleapp.demo.service.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        public ResponseEntity<CrawlSummary> crawl(@RequestParam String url) {
            try {
                new URL(url);
                crawlingService.crawl(url);
                return ResponseEntity.ok(crawlingService.crawl(url));
            }catch (MalformedURLException e) {
                return ResponseEntity.badRequest().body(null);
            }
        }
    }
