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
    private Integer qId; //id

    @Column(nullable = false)
    private String qSubject; //1:1문의 질문 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String qContent; //1:1문의 질문 내용

    private LocalDateTime qCreateDate; //작성일시

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uId", nullable = false)
    private User qAuthor; //1:1문의 질문 작성자


    private QnaQuestion(String fSubject, String fContent, User fAuthor) {
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
