package ming.dCommunity.community.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.user.entity.User;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * 댓글 엔티티
 */
@Entity
@Getter
@RequiredArgsConstructor
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
    private Set<User> coVoter; //댓글 추천인



}
