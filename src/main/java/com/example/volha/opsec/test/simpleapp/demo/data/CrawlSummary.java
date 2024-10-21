package com.example.volha.opsec.test.simpleapp.demo.data;


public class CrawlSummary {

    private Long id;

    private String url;

    private int internalLinks;

    private int externalLinks;

    private int images;

    private int unknownLinks;

    public CrawlSummary() {
    }

    public CrawlSummary(String url, int internalLinks, int externalLinks, int images, int unknownLinks) {
        this.url = url;
        this.internalLinks = internalLinks;
        this.externalLinks = externalLinks;
        this.images = images;
        this.unknownLinks = unknownLinks;
    }

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

    public void incrementInternalLinks() {
        this.internalLinks++;
    }

    public void incrementExternalLinks() {
        this.externalLinks++;
    }

    public void incrementImages(int size) {
        this.images += size;
    }

    public void incrementUnknownLinks() {
        this.unknownLinks++;
    }


}
