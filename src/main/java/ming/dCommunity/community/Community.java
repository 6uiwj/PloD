package ming.dCommunity.community;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.entity.Board;

import java.util.List;

@Entity
@RequiredArgsConstructor
public class Community {
    @Id @GeneratedValue
    private Integer cId;

    @OneToMany(mappedBy = "community", cascade = CascadeType.REMOVE)
    private List<Board> commBoard;
}
