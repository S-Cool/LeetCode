package com.interview.etulover;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UrlShortener {

    private final Map<String, String> linkMap = new HashMap<>();
    private final String domain = "http://sh.com";

    public String shortedUrl(String longUrl){
        String uniqueStringId = UUID.randomUUID().toString().substring(0, 8);
        String shortUrl = domain + uniqueStringId;
        linkMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl){
        return linkMap.get(shortUrl);
    }

    public static void main(String[] args) {
        UrlShortener urlShortener = new UrlShortener();

        var longUrl = "https://www.revolut.com/en-US/cards/";
        String shortedUrl = urlShortener.shortedUrl(longUrl);
        System.out.println("Shorted URL: " + shortedUrl);

        String originalUrl = urlShortener.getOriginalUrl(shortedUrl);
        System.out.println("Original URL: " + originalUrl);
    }
}
