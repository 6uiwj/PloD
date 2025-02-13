package ming.dCommunity.community.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ming.dCommunity.community.comment.entity.Comment;
import ming.dCommunity.community.entity.Community;
import ming.dCommunity.user.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @NoArgsConstructor(기본생성자)를 사욯하는 이유
 * 1. JPA에서 프록시 생성을 위해 필요 (JPA는 엔티티를 프록시 객체로 감싸서 관리) -> 이떄 기본 생성자 필요
 * 2. 프레임워크(Spring, Hibernate)에서 리플렉션을 사용할 때 필요
 *      -> Spring, Hibernate는 리플렉션을 사용하여 객체를 생성함
 *      **리플렉션**
 *      프로그램이 실행되는 중에 객체의 구조(클래스, 메서드, 필드 등)를 동적으로 조사하고 수정할 수 있는 기술
 */

/**
 * access = AccessLevel.PROTECTED : 접근제어자를 PROTECTED로 설정
 * (class자체에 protected 설정이 불가능 하므로)
 */
@Entity
@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cbId; //게시판 id, 고유번호 부여

    @Column(nullable = false)
    private String cbSubject; //게시판 제목(내용 입력 필수)

    @Column(nullable = false, columnDefinition = "TEXT") //긴 텍스트데이터 저장
    private String cbContent; //게시판 내용(내용 입력 필수)

    private LocalDateTime cbCreateDate; //작성일시

    //여러 개의 게시글, 하나의 작성자
    @ManyToOne(fetch = FetchType.LAZY) //지연 로딩
    @JoinColumn(name = "uId", nullable = false) //외래키 컬럼 이름 uId
    private User cbAuthor; //작성자(User Entity에서 가져옴)

    private LocalDateTime cbModifyDate; //수정일시


    private Set<User> cbVoter; //추천인

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId", nullable = false)
    private Community community;

    //하나의 게시글 여러개의 댓글
    //mappedBy = "board" : Comment엔티티에서 board 필드가 연관관계의 주인
    //orphanRemoval = true : 고아객체 제거
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    //Board 생성자 (Board객체 초기화) -> 객체 생성이 외부에서 이루어지지 않도록 통제
    //아래의 정보들은 생성 후 상태가 변경되지 않음
    private Board(String cbSubject, String cbContent, User cbAuthor) {
        this.cbSubject = cbSubject;
        this.cbContent = cbContent;
        this.cbAuthor = cbAuthor;
        this.cbCreateDate = LocalDateTime.now();
    }

    /**
     * 정적 팩토리 메서드 -> Board 객체 생성
     * 객체 생성 로직 캡슐화
     *  Board 객체를 생성할 때 추가적인 로직이나 검증을 할 수 있으며,
     *  외부에서 Board 객체를 쉽게 생성 가능
     *
     *  DDD에서 엔티티의 객체 생성은 도메인 로직과 연결될 수 있기 때문에,
     *  정적 팩토리 메서드를 사용하여 객체 생성 과정을 도메인 서비스나 팩토리에 위임
     *
     *  객체가 생성되는 방식에 대한 제어권을 도메인 클래스 자체가 갖게 하여 객체의 일관성을 보장
     * @param cbSubject
     * @param cbContent
     * @param cbAuthor
     * @return
     */
    //이 메서드를 외부에서 호출하여 Board 생성자를 호출해 Board객체를 생성
    public static Board create(String cbSubject, String cbContent, User cbAuthor) {
        return new Board(cbSubject, cbContent, cbAuthor);
    }

    //글 작성자로 입력할 닉네임 가져오기
    public String getAuthorNickname() {
        return cbAuthor.getNickname();
    }

}
