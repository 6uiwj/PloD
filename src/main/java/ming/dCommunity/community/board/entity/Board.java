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

    @ManyToMany
    private Set<User> cbVoter; //추천인

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cId", nullable = false)
    private Community community;

    //하나의 게시글 여러개의 댓글
    //mappedBy = "board" : Comment엔티티에서 board 필드가 연관관계의 주인
    //orphanRemoval = true : 고아객체 제거
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();



}
