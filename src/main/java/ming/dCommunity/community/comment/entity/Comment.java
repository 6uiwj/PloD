package ming.dCommunity.community.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.user.entity.User;

import java.time.LocalDateTime;

/**
 * 댓글 엔티티
 */
@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer coId; //id

    @Column(nullable = false,  columnDefinition = "TEXT")
    private String coContent; //댓글 내용

    private LocalDateTime coCreateDate; //댓글 작성일시

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cbId", nullable = false)
    private Board board; //댓글에 주인이 되는 게시판

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uId", nullable = false)
    private User coAuthor; //댓글 작성자

    @ManyToMany
    private String coVoter; //댓글 추천인

    //Comment 생성자 (Comment 객체 초기화) -> 객체 생성이 외부에서 이루어지지 않도록 통제
    //아래의 정보들은 생성 후 상태가 변경되지 않음
    private Comment(String coContent, Board board) {
        this.coContent = coContent;
        this.coCreateDate = LocalDateTime.now();
        this.board = board;
    }

    //이 메서드를 외부에서 호출하여 comment 생성자를 호출해 comment 객체를 생성
    public static Comment create(String coContent, Board board) {
        return new Comment(coContent, board);
    }

    //댓글을 남길 게시글 가져오기
    protected void setBoard(Board board) {
        this.board = board;
    }

    //댓글 작성자 닉네임가져오기
    public String getAuthorNickname() {
        return coAuthor.getNickname();
    }

}
