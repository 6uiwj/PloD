package ming.dCommunity.qna.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import ming.dCommunity.user.entity.UserInfo;

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
    private UserInfo qAuthor; //1:1문의 질문 작성자

}
