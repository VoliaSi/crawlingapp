package com.example.volha.opsec.test.simpleapp.demo.repository;

import com.example.volha.opsec.test.simpleapp.demo.data.CrawlSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrawlSummaryRepository extends JpaRepository<CrawlSummary, Long> {
}
