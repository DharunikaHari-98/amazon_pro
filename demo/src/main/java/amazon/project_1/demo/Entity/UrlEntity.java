package amazon.project_1.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "urls")
@Getter
@Setter

public class UrlEntity {
    public Long getId() {
        return id;
    }
    public UrlEntity() {
        // Default constructor (JPA needs this)
    }
    public UrlEntity(String longUrl, String shortUrl, Long createdAt) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.createdAt = createdAt;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String longUrl;

    @Column(nullable = false, unique = true)
    private String shortUrl;

    @Column(nullable = false)
    private Long createdAt;
}
