CREATE TABLE crawl_summary (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    internal_links INT,
    external_links INT,
    images INT,
    unknown_links INT
);
