# crawlingapp

## Overview

This is a simple web crawler application built with Spring Boot, utilizing Jsoup for HTML parsing and H2 as an embedded database. The crawler can traverse web pages, collect links, images, and store crawl summaries in the database.

## Features

- Crawl web pages and extract:
  - Internal links
  - External links
  - Images
  - Unknown links
- Store crawl summaries in an H2 database
- REST API for triggering crawls and retrieving summaries

## Technologies Used

- **Java**: The programming language used for building the application.
- **Spring Boot**: A framework to simplify the development of Java applications.
- **Jsoup**: A library for working with real-world HTML.
- **H2 Database**: An embedded database for storing crawl summaries.
- **JUnit**: For unit and integration testing.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation

1. Clone the repository:

    git clone [volha-crawling-repository](https://github.com/VoliaSi/crawlingapp.git)

2. Navigate to the project directory and build the project with Maven

    mvn clean install

### Running the application

mvn spring-boot:run

The application will start on http://localhost:8080.

### API Endpoints
#### Start a Crawl
POST /demo/crawl

##### Request Parameters:

url: The URL to start crawling.
depth: The maximum depth to crawl (default is 1).

Example:

POST "http://localhost:8080/demo/crawl?url=http://example.com&depth=2"

#### Get All Crawl Summaries
GET /demo/crawl

Response: Returns a list of all crawl summaries.

Example:

GET "http://localhost:8080/demo/crawl"


## My approach to solving the problem and assumptions made
I consider this app as an initial version of some crawling Application.

H2 database was used because it is an embedded one - to avoid additional configuration. It also supports some No-SQL features, but they were not used in this version, as the final decision on the database to use is not made.

Jsoup was used for parsing HTML as the most known library. It doesn't natively execute JavaScript embedded within web pages, which is a challenge for working with modern web-sites. JavaScript parsing is left for the next release. This will probably need using another library or some manual processing. Now such links are carefully logged, counted and classified as "Unknown links".

Testing was performed with unit tests and sending requests with Postman.

The main challenge for me was my fear of navigating internet using Java code, as I'm absolutely new to web crawling and web scrapping, so I haven't tested the application thoroughly.
In addition, most logic is in private methods and I preferred my approach to creating more tests.

