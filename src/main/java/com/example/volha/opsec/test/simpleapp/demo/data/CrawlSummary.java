package com.example.volha.opsec.test.simpleapp.demo.data;

public class CrawlSummary {
    private String id;
    private String url;
    private int internalLinks;
    private int externalLinks;
    private int images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public CrawlSummary(String id, String url, int internalLinks, int externalLinks, int images) {
        this.id = id;
        this.url = url;
        this.internalLinks = internalLinks;
        this.externalLinks = externalLinks;
        this.images = images;
    }
}
