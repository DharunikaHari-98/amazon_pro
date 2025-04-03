package amazon.project_1.demo.Controller;


import amazon.project_1.demo.Entity.UrlEntity;
import amazon.project_1.demo.Service.UrlService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {
    private final UrlService urlService;
    Logger l= LoggerFactory.getLogger(UrlController.class);
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
//
    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody UrlEntity longUrl) {
        l.info(longUrl.getLongUrl());
        return urlService.shortenUrl(longUrl.getLongUrl());
    }

    @GetMapping("/{shortUrl}")
    public String getLongUrl(@PathVariable String shortUrl) {
        return urlService.getLongUrl(shortUrl);
    }
}
