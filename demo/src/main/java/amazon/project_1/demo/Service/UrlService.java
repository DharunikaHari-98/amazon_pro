package amazon.project_1.demo.Service;

import amazon.project_1.demo.Entity.UrlEntity;
import amazon.project_1.demo.Repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String longUrl) {
        Optional<UrlEntity> existing = urlRepository.findByLongUrl(longUrl);
        if (existing.isPresent()) {
            return existing.get().getShortUrl();
        }

        String shortCode = generateShortCode(); // ✅ Use random short code instead of Base64
        UrlEntity urlEntity = new UrlEntity(longUrl, shortCode, System.currentTimeMillis());
        urlRepository.save(urlEntity);
        return shortCode;
    }

    public String getLongUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl)
                .map(UrlEntity::getLongUrl)
                .orElseThrow(() -> new RuntimeException("URL not found!"));
    }

    private String generateShortCode() {
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString(); // Example: "xYz9A1"
    }
}
