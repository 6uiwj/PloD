package ming.dCommunity.community.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ming.dCommunity.community.board.entity.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * 커뮤니티 엔티티
 */
@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId; //id


    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> commBoardList = new ArrayList<>();

//    @ElementCollection
//    @CollectionTable(name = "community_board_ids", joinColumns = @JoinColumn(name = "community_id"))
//    @Column(name = "board_id")
//    private List<Integer> boardIds = new ArrayList<>();
//
//    // Board를 추가하는 편의 메서드
//    public void addBoard(Board board) {
//        commBoardList.add(board); // 리스트에 Board 추가
//        board.setCommunity(this); // Board의 Community 설정 (양방향 관계 유지)
//
//        // Board ID도 따로 저장
//        if (board.getCbId() != null) {
//            boardIds.add(board.getCbId());
//        }
//    }



}
