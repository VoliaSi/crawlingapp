package com.example.volha.company.test.simpleapp.demo.service;

import com.example.volha.company.test.simpleapp.demo.data.CrawlSummary;
import com.example.volha.company.test.simpleapp.demo.repository.CrawlSummaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CrawlingServiceTest {

    @Mock
    private CrawlSummaryRepository crawlSummaryRepository;

    @InjectMocks
    private CrawlingService crawlingService;
//    private CrawlingService crawlingServiceSpy;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrawlShouldSaveCrawlSummary() {
        // Given
        String testUrl = "http://example.com";
        int crawlDepth = 2;

        // When
        crawlingService.crawl(crawlDepth, testUrl);

        // Then
        verify(crawlSummaryRepository, times(1)).save(any(CrawlSummary.class));
    }

    @Test
    void testCrawlOneLevelShouldReturnCrawlSummaryForSpecifiedURL() {
        String testUrl = "http://example.com";
        int crawlDepth = 1;

        CrawlSummary result = crawlingService.crawl(crawlDepth, testUrl);
        String actualUrl = result.getUrl();
        assertEquals(testUrl, actualUrl);

    }
}