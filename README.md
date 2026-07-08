# Flipkart Web Automation & Data Scraping Testing

An automated end-to-end (E2E) testing and web scraping suite for Flipkart's e-commerce platform. This project demonstrates advanced browser interactions, dynamic product data extraction, and conditional validation logic across multiple search categories using Selenium and TestNG.

## Tech Stack & Skills Used
* **Automation Framework** : Selenium WebDriver
* **Testing Framework** : TestNG
* **Locator Strategy** : Dynamic & Relative XPath
* **Concepts Applied** : Explicit/Implicit Waits, Java Collections (ArrayList for dynamic data handling)

---

## Automated Test Cases & Workflows

The test suite executes comprehensive data-gathering and filtering logic across three distinct product categories on Flipkart.com:

### 1. Washing Machine Category – Popularity & Rating Analysis
* Navigates to `Flipkart.com` and executes a targeted search for **"Washing Machine"**.
* Applies the platform's native **"Popularity"** sort filter.
* Scrapes the results page, parses individual product ratings, and dynamically calculates and logs the total count of items with a rating $\le 4.0$ stars.

### 2. iPhone Category – Deal & Discount Extraction
* Executes a search for **"iPhone"**.
* Scrapes the resulting product listing page to extract metadata.
* Implements conditional parsing logic to filter out and print the exact **Product Titles** and **Discount Percentages** for all models featuring a discount $> 17\%$.

### 3. Coffee Mug Category – Review & Media Scraping
* Generates a search for **"Coffee Mug"** and applies a UI filter for items rated **4 Stars and Above**.
* Evaluates the filtered list to locate the top **5 items with the highest overall review count**.
* Dynamically extracts and logs both the **Product Title** and the underlying **Image URL asset** for each of these top 5 high-review items.

---
