package ming.dCommunity.community.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.entity.Board;

import java.util.List;

/**
 * 커뮤니티 엔티티
 */
@Entity
@RequiredArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId; //id

    @OneToMany(mappedBy = "community", cascade = CascadeType.REMOVE)
    private List<Board> commBoardList; //커뮤니티 내 게시판

}
