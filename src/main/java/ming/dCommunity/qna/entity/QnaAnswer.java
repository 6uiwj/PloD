package ming.dCommunity.qna.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
public class QnaAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;
    private String aSubject; //1:1문의 답변 제목
    private String aContent; //1:1문의 답변 내용
    private LocalDateTime aCreateDate;


    @OneToOne
    private List<QnaQuestion> qnaQuestions; //1:1문의 답변에 해당하는 질문

    private QnaAnswer(String aSubject, String aContent) {
        this.aSubject = aSubject;
        this.aContent = aContent;
        this.aCreateDate = LocalDateTime.now();
    }

    public static QnaAnswer create(String aSubject, String aContent ) {
        return new QnaAnswer(aSubject, aContent);
    }

}

