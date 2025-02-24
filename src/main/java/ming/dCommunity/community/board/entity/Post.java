package ming.dCommunity.community.board.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.comment.entity.Comment;
import ming.dCommunity.user.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId; //게시판 id, 고유번호 부여

    @Column(nullable = false)
    private String pSubject; //게시글 제목(내용 입력 필수)

    @Column(nullable = false, columnDefinition = "TEXT") //긴 텍스트데이터 저장
    private String pContent; //게시글 내용(내용 입력 필수)

    private LocalDateTime pCreateDate; //작성일시

    //여러 개의 게시글, 하나의 작성자
    @ManyToOne(fetch = FetchType.LAZY) //지연 로딩
    @JoinColumn(name = "uId", nullable = false) //외래키 컬럼 이름 uId
    private User pAuthor; //작성자(User Entity에서 가져옴)

    private LocalDateTime pModifyDate; //수정일시

    @ManyToMany
    private Set<User> pVoter; //추천인


    //하나의 게시글 여러개의 댓글
    //mappedBy = "board" : Comment엔티티에서 board 필드가 연관관계의 주인
    //orphanRemoval = true : 고아객체 제거
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="board_id", nullable = false)
    private Board board;

}
