package ming.dCommunity.faq.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Faq {
    private Integer fId;
    private String fSubject;
    private String fContent;
    private LocalDateTime fCreateDate;


    private Faq(String fSubject, String fContent) {
        this.fSubject = fSubject;
        this.fContent = fContent;
        this.fCreateDate = LocalDateTime.now();
    }

    public static Faq create(String fSubject, String fContent) {
        return new Faq(fSubject, fContent);
    }


}
