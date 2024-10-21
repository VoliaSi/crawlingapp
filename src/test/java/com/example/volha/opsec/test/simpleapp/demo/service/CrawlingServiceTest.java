package com.example.volha.opsec.test.simpleapp.demo.service;

import com.example.volha.opsec.test.simpleapp.demo.data.CrawlSummary;
import com.example.volha.opsec.test.simpleapp.demo.repository.CrawlSummaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CrawlingServiceTest {

    @Mock
    private CrawlSummaryRepository crawlSummaryRepository;

    @InjectMocks
    private CrawlingService crawlingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrawlShouldSaveCrawlSummary() {
        // Given
        String testUrl = "http://example.com";
        int crawlDepth = 2;

        // When
        crawlingService.crawl(crawlDepth, testUrl);

        // Then
        verify(crawlSummaryRepository, times(1)).save(any(CrawlSummary.class));
    }
}
//
//    @Test
//    void crawl() {
//    }
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void findAll() {
//    }
