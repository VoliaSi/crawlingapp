package com.example.volha.opsec.test.simpleapp.demo.data;

import javax.persistence.*;

@Entity
@Table(name = "crawl_summary")
public class CrawlSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "internal_links")
    private int internalLinks;

    @Column(name = "external_links")
    private int externalLinks;

    @Column(name = "images")
    private int images;

    @Column(name = "unknown_links")
    private int unknownLinks;

//    @Lob // Stores the JSON as a large object (text)
//    @Column(name = "metadata")
//    private String metadata;

    public CrawlSummary() {
    }

    // Constructor without metadata
    public CrawlSummary(String url, int internalLinks, int externalLinks, int images) {
        this.url = url;
        this.internalLinks = internalLinks;
        this.externalLinks = externalLinks;
        this.images = images;
    }

//    // Constructor with metadata
//    public CrawlSummary(String url, int internalLinks, int externalLinks, int images, String metadata) {
//        this.url = url;
//        this.internalLinks = internalLinks;
//        this.externalLinks = externalLinks;
//        this.images = images;
//        this.metadata = metadata;
//    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getInternalLinks() {
        return internalLinks;
    }

    public void setInternalLinks(int internalLinks) {
        this.internalLinks = internalLinks;
    }

    public int getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(int externalLinks) {
        this.externalLinks = externalLinks;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getUnknownLinks() {
        return unknownLinks;
    }

    public void setUnknownLinks(int unknownLinks) {
        this.unknownLinks = unknownLinks;
    }
//
//    public String getMetadata() {
//        return metadata;
//    }
//
//    public void setMetadata(String metadata) {
//        this.metadata = metadata;
//    }

    public void incrementInternalLinks() {
        this.internalLinks++;
    }

    public void incrementExternalLinks() {
        this.externalLinks++;
    }

    public void incrementImages(int size) {
        this.images += size;
    }
}
