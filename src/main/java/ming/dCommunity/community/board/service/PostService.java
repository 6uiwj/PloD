package ming.dCommunity.community.board.service;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.dto.PostDto;
import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.entity.Post;
import ming.dCommunity.community.board.repository.BoardRepository;
import ming.dCommunity.community.board.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;


    /**
     * 게시판 별 게시글 목록 가져오는 메서드  -> model에 저장
     * model에 저장할 때 이름을 게시판명+postList로 해줄것임
     * 이를 위해 post 엔티티에 저장된 boardId로 board를 저장해 boardName을 가져옴
     * @param model
     * @param boardId
     */
    public void getList(Model model, Integer boardId) {

        //게시판 별 게시글 목록을 조회하여 model에 저장할때 java게시글은 javaPostList, C는 CPostList로 이름을 저장하기 위해 게시판의 이름을 가져오기
        ////게시판 이름을 얻기 위해 해당 게시판의 ID로 게시판 조회
        Optional <Board> boardNameTemp = this.boardRepository.findById(boardId);


        if(boardNameTemp.isPresent()) {
            Board board = boardNameTemp.get();
            String postAttributeName = board.getCommBoardName() + "PostList";

            //게시판별 게시글 조회 위해 게시판을 키워드로 검색해서 게시글을 목록 조회할 것임
            //ex) 자바커뮤니티의 게시물이면 -> post(게시글)들에 저장된 Board(게시판)정보를 이용해서 board = java 인 게시글들 검색
            Optional<List<Post>> postListTemp = this.postRepository.findByBoard(board);

            if (postListTemp.isPresent()) {
                List<Post> postList = postListTemp.get();

                // Post 리스트를 PostDTO 리스트로 변환
                List<PostDto> postDtoList = postList.stream()
                        .map(Post::toPostDto) // Post -> PostDTO 변환
                        .toList();
                System.out.println("닉네임아 잘있니..? "+ postDtoList.get(0).getPAuthorNickname());
                model.addAttribute(postAttributeName, postDtoList);

            } else throw new NoSuchElementException();
        } else throw new NoSuchElementException();
    }

}
