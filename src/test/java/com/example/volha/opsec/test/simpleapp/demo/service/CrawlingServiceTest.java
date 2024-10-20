package com.example.volha.opsec.test.simpleapp.demo.service;

class CrawlingServiceTest {

//    private CrawlingService crawlingService; // Assuming this is the class containing the 'crawl' method.
//
//    @BeforeEach
//    public void setUp() {
//        crawlingService = new CrawlingService();
//    }
//
//    @Test
//    public void testCrawl_withValidDepthAndUrl_shouldReturnCrawlSummary() {
//        // Arrange
//        int crawlDepth = 2;
//        String stringUrl = "http://example.com";
//
//        // Act
//        CrawlSummary result = crawlService.crawl(crawlDepth, stringUrl);
//
//        // Assert
//        assertNotNull(result, "CrawlSummary should not be null");
//        assertEquals(stringUrl, result.getRootUrl(), "Root URL should match the input URL");
//        assertEquals(0, result.getInternalLinks(), "Initially, there should be no internal links");
//        assertEquals(0, result.getExternalLinks(), "Initially, there should be no external links");
//        assertEquals(0, result.getImageCount(), "Initially, there should be no images");
//
//        // You could also add more logic here to verify the crawl behavior, depending on how `crawlOneLevel` works
//    }
//
//    @Test
//    public void testCrawl_withZeroDepth_shouldReturnEmptyCrawlSummary() {
//        // Arrange
//        int crawlDepth = 0;
//        String stringUrl = "http://example.com";
//
//        // Act
//        CrawlSummary result = crawlService.crawl(crawlDepth, stringUrl);
//
//        // Assert
//        assertNotNull(result, "CrawlSummary should not be null");
//        assertEquals(stringUrl, result.getRootUrl(), "Root URL should match the input URL");
//        assertEquals(0, result.getInternalLinks(), "There should be no internal links if depth is 0");
//        assertEquals(0, result.getExternalLinks(), "There should be no external links if depth is 0");
//        assertEquals(0, result.getImageCount(), "There should be no images if depth is 0");
//    }
//
//    @Test
//    public void testCrawl_withInvalidUrl_shouldHandleException() {
//        // Arrange
//        int crawlDepth = 1;
//        String invalidUrl = "invalid-url";
//
//        // Act & Assert
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            crawlService.crawl(crawlDepth, invalidUrl);
//        });
//
//        assertEquals("Invalid URL", exception.getMessage(), "The exception message should indicate an invalid URL");
//    }


//    public CrawlSummary crawl(int crawlDepth, String stringUrl) {
//
//        List<String> crawledUrls = new ArrayList<>();
//        CrawlSummary crawlSummary = new CrawlSummary(stringUrl, 0, 0, 0);
//
//        crawlOneLevel(crawlDepth, 1, stringUrl, crawledUrls, crawlSummary);
//
//        return crawlSummary;
//    }

//
//    @Mock
//    private CrawlService crawlService;
//
//    @Test
//    public void testCrawlWithMocking() {
//        when(crawlService.crawlOneLevel(anyInt(), anyInt(), anyString(), anyList(), any(CrawlSummary.class)))
//                .thenReturn(...); // Return a mocked result
//
//        // Test logic
//    }
}