package ming.dCommunity.community.service;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getList() {
        return this.boardRepository.findAll();

    }

    public List<String> getBoardNameList() {
        List<String> boardNameList = new ArrayList<>();
        for(int i = 0; i<getList().size(); i++) {
            boardNameList.add(getList().get(i).getCommBoardName());
        }
        return boardNameList;
    }
}
