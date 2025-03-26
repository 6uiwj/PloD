package ming.dCommunity.community;

import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.repository.BoardRepository;
import ming.dCommunity.community.board.repository.PostRepository;
import ming.dCommunity.community.entity.Community;
import ming.dCommunity.community.repository.CommunityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class communityServiceTest {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    BoardRepository boardRepository;


    @Autowired
    PostRepository postRepository;

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

    /**
     * 커뮤니티 내 게시판 이름들 가져오는 테스트
     */
    @Test
    void BoardListTest() {
        List<Board> boardList = boardRepository.findAll();
        List<String> boardNameList = new ArrayList<>();
        for(int i = 0; i<boardList.size(); i++) {
            boardNameList.add(boardList.get(i).getCommBoardName());
        }
        for(String name : boardNameList) {
            System.out.println(name);
        }
    }

    @Test
    void GetLatestPostService() {
//           List<Post> Top4PostList = this.postRepository.findTop4LatestPosts();
//           for ( int i = 0; i<4; i++) {
//               Top4PostList.get(i);
//           }
       }
    }

