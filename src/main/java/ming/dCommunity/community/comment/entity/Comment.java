package ming.dCommunity.community.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer coId;

    @Column(nullable = false,  columnDefinition = "TEXT")
    private String coContent;

    private LocalDateTime coCreateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cbId", nullable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uId", nullable = false)
    private User coAuthor;

    private String coVoter;

    private Comment(String coContent, Board board) {
        this.coContent = coContent;
        this.coCreateDate = LocalDateTime.now();
        this.board = board;
    }

    public static Comment create(String coContent, Board board) {
        return new Comment(coContent, board);
    }

    protected void setBoard(Board board) {
        this.board = board;
    }
}
