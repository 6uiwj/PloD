package ming.dCommunity.faq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
public class Faq {
    @Id
    private Integer fId;
    private String fSubject;
    private String fContent;
    private LocalDateTime fCreateDate;


}
