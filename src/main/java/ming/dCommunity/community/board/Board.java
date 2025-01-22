package ming.dCommunity.community.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Board {
    @Id
    private Integer cbId;

    private String cbSubject;

    private String cbContent;

    private LocalDateTime cbCreateDate;

    private LocalDateTime cbModifyDate;

    private String cdAuthor;

}
