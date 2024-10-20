package com.example.volha.opsec.test.simpleapp.demo;

public class ControllerIntegrationTest {


    // src/test/java/com/example/webcrawler/controller/CrawlControllerTest.java
//package com.example.webcrawler.controller;
//
//import com.example.webcrawler.model.CrawlSummary;
//import com.example.webcrawler.service.CrawlService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//    @SpringBootTest
//    @AutoConfigureMockMvc
//    class CrawlControllerTest {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @MockBean
//        private CrawlService crawlService;
//
//        @Test
//        void testStartCrawl_Success() throws Exception {
//            String url = "https://example.com";
//            CrawlSummary summary = new CrawlSummary(1L, url, 10, 5, 20);
//
//            Mockito.when(crawlService.crawlSite(url)).thenReturn(summary);
//
//            mockMvc.perform(post("/api/crawl")
//                            .param("url", url)
//                            .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$.url").value(url))
//                    .andExpect(jsonPath("$.internalLinks").value(10))
//                    .andExpect(jsonPath("$.externalLinks").value(5))
//                    .andExpect(jsonPath("$.imageCount").value(20));
//        }
//
//        @Test
//        void testStartCrawl_InvalidUrl() throws Exception {
//            String invalidUrl = "htp:/invalid-url";
//
//            mockMvc.perform(post("/api/crawl")
//                            .param("url", invalidUrl)
//                            .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isBadRequest());
//        }
//
//        // Additional tests for error scenarios
//    }

}
