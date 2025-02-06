package ming.dCommunity.community.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ming.dCommunity.community.comment.entity.Comment;
import ming.dCommunity.user.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cbId; //게시판 id

    @Column(nullable = false)
    private String cbSubject;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String cbContent;

    private LocalDateTime cbCreateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uId", nullable = false)
    private User cbAuthor;

    private LocalDateTime cbModifyDate;


    private String cbVoter;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    private Board(String cbSubject, String cbContent, User cbAuthor) {
        this.cbSubject = cbSubject;
        this.cbContent = cbContent;
        this.cbAuthor = cbAuthor;
        this.cbCreateDate = LocalDateTime.now();
    }

    public static Board create(String cbSubject, String cbContent, User cbAuthor) {
        return new Board(cbSubject, cbContent, cbAuthor);
    }

    //글 작성자로 입력할 닉네임 가져오기
    public String getAuthorNickname() {
        return cbAuthor.getNickname();
    }

}
