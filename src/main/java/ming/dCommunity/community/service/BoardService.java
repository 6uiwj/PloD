package ming.dCommunity.community.service;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.entity.Post;
import ming.dCommunity.community.board.repository.BoardRepository;
import ming.dCommunity.community.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;

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

    public List<Post> getAllBoardLatestPost() {
        List<Post> LatestPost = this.postRepository.findPostsOrderByCreateDateDesc();
        int loopLimit = Math.min(LatestPost.size(),4);
        List<Post> LatestPostTop4 = new ArrayList<>();
        for(int i = 0; i<loopLimit; i++) {
            LatestPostTop4.add(LatestPost.get(i));
        }
        return LatestPostTop4;
    }

    /**
     * 최신글 가져오기 (게시판별)
     * @param boardId
     * @return
     */
    public List<Post> getLatestPost(Integer boardId) {
        //System.out.println("보드서비스 getLatestPost boardID 뭐에여" + boardId);
        List<Post> OrderedPost = this.postRepository.findPostsByBoardIdOrderByCreateDateDesc(boardId);
        List<Post> LatestPost = new ArrayList<>(); //최신게시글 4개만
        int loopLimit = Math.min(OrderedPost.size(),4);
        for(int i = 0; i<loopLimit; i++) {
            System.out.println(i);
            LatestPost.add(OrderedPost.get(i));
        }
        return LatestPost; //최신게시글 4개 반환
    }




    /**
     * 모든게시판 종류 가져오기 -> 게시판별 최신게시글 가져오기위해
     * ex) JAVA=1, PYTHON =5, C=6,
     * @return
     */
    public List<Integer> getAllBoardType() {
        return this.boardRepository.findAllBoardIds();
    }

    public String getBoardName(Integer boardId) {
        return this.boardRepository.findAllBoardName(boardId);
    }


}
