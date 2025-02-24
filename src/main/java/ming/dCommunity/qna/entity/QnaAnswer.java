package ming.dCommunity.qna.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
public class QnaAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;
    private String aSubject; //1:1문의 답변 제목
    private String aContent; //1:1문의 답변 내용
    private LocalDateTime aCreateDate;

    @OneToOne
    private QnaQuestion qnaQuestions; //1:1문의 답변에 해당하는 질문


}

