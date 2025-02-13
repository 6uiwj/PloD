package ming.dCommunity.notice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId; //id

    private String nSubject; //공지 제목

    private String nContent; //공지 내용

    private LocalDateTime nCreateDate;

    /**
     * Notice 생성자 (Notice 객체 초기화) : 객체 생성이 외부에서 이루어지지 않도록 통제
     * 아래의 정보들은 생성 후 상태가 변경되지 않음
     * @param nSubject
     * @param nContent
     */
    private Notice(String nSubject, String nContent) {
        this.nSubject = nSubject;
        this.nContent = nContent;
        this.nCreateDate = LocalDateTime.now();
    }

    /**
     * 이 메서드를 외부에서 호출하여 Notice 생성자를 호출해 Notice 객체를 생성
     * @param nSubject
     * @param nContent
     * @return
     */
    public static Notice create(String nSubject, String nContent) {
        return new Notice(nSubject, nContent);
    }

}
