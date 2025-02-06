package ming.dCommunity.qna.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import ming.dCommunity.user.entity.User;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QnaQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qId;

    @Column(nullable = false)
    private String qSubject;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String qContent;

    private LocalDateTime qCreateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uId", nullable = false)
    private User qAuthor;


    private QnaQuestion(String qSubject, String qContent, User qAuthor) {
        this.qSubject = qSubject;
        this.qContent = qContent;
        this.qAuthor = qAuthor;
        this.qCreateDate = LocalDateTime.now();
    }

    private static QnaQuestion create(String qSubject, String qContent, User qAuthor) {
        return new QnaQuestion(qSubject, qContent, qAuthor);
    }


    //글 작성자로 입력할 닉네임 가져오기
    public String getAuthorNickname() {
        return qAuthor.getNickname();
    }
}
