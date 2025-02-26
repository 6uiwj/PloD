package ming.dCommunity.community.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ming.dCommunity.community.entity.Community;

import java.util.List;

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
@RequiredArgsConstructor
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cbId; //게시판 id, 고유번호 부여

    private String commBoardName; //게시판이름

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_Id")
    private Community community;

    //관계만 정의, 실제 테이블엔 생성X
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;



}
