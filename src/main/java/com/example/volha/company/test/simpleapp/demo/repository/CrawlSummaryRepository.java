package com.example.volha.company.test.simpleapp.demo.repository;

import com.example.volha.company.test.simpleapp.demo.data.CrawlSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrawlSummaryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(CrawlSummary crawlSummary) {
        String sql = "INSERT INTO crawl_summary (url, internal_links, external_links, images, unknown_links) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, crawlSummary.getUrl(), crawlSummary.getInternalLinks(),
                crawlSummary.getExternalLinks(), crawlSummary.getImages(), crawlSummary.getUnknownLinks());
    }

    public List<CrawlSummary> findAll() {
        String sql = "SELECT * FROM crawl_summary";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CrawlSummary summary = new CrawlSummary();
            summary.setId(rs.getLong("id"));
            summary.setUrl(rs.getString("url"));
            summary.setInternalLinks(rs.getInt("internal_links"));
            summary.setExternalLinks(rs.getInt("external_links"));
            summary.setImages(rs.getInt("images"));
            summary.setUnknownLinks(rs.getInt("unknown_links"));
            return summary;
        });
    }
}
