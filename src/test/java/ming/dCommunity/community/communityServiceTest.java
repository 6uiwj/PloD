package ming.dCommunity.community;

import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.repository.BoardRepository;
import ming.dCommunity.community.entity.Community;
import ming.dCommunity.community.repository.CommunityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class communityServiceTest {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    BoardRepository boardRepository;

    @Test
    void CreateCommunity() {
        Community community = new Community();
        communityRepository.save(community);
    }
    @Test
    void InsertBoardTest () {
//        Board board1 = new Board();
//        board1.setCommBoardName("JAVA");
//        board1.setCommunity(communityRepository.findById(3).get());
//        boardRepository.save(board1);


        Board board2 = new Board();
        board2.setCommBoardName("PYTHON");
        board2.setCommunity(communityRepository.findById(3).get());
        boardRepository.save(board2);

        Board board3 = new Board();
        board3.setCommBoardName("C");
        board3.setCommunity(communityRepository.findById(3).get());
        boardRepository.save(board3);
    }
}
