package ming.dCommunity.community.board.service;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.dto.PostDto;
import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.entity.Post;
import ming.dCommunity.community.board.repository.BoardRepository;
import ming.dCommunity.community.board.repository.PostRepository;
import ming.dCommunity.exception.DataNotFoundException;
import ming.dCommunity.user.controller.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final UserService userService;


    /**
     * 게시판 별 게시글 목록 가져오는 메서드  -> model에 저장
     * model에 저장할 때 이름을 게시판명+postList로 해줄것임
     * 이를 위해 post 엔티티에 저장된 boardId로 board를 저장해 boardName을 가져옴
     * @param boardId
     */
    public List<PostDto> getList(Integer boardId) {
// *******************아래 메서드로 이관 ***************************
//        //게시판 별 게시글 목록을 조회하여 model에 저장할때 java게시글은 javaPostList, C는 CPostList로 이름을 저장하기 위해 게시판의 이름을 가져오기
//        ////게시판 이름을 얻기 위해 해당 게시판의 ID로 게시판 조회
        Optional<Board> boardTemp = this.boardRepository.findById(boardId);
//
//
        if (boardTemp.isPresent()) {
            Board board = boardTemp.get();
            //게시판별 게시글 조회 위해 게시판을 키워드로 검색해서 게시글을 목록 조회할 것임
            //ex) 자바커뮤니티의 게시물이면 -> post(게시글)들에 저장된 Board(게시판)정보를 이용해서 board = java 인 게시글들 검색
            Optional<List<Post>> postListTemp = this.postRepository.findByBoard(board, Sort.by(Sort.Direction.DESC, "pCreateDate"));

            if (postListTemp.isPresent()) {
                List<Post> postList = postListTemp.get();

                //조회한 Post 리스트를 PostDTO 리스트로 변환
                return postList.stream()
                        .map(Post::toPostDto) // Post -> PostDTO 변환
                        .toList();
                //model.addAttribute(postAttributeName, postDtoList);
// 게시글이 없을 경우 처리 (TODO)
            } else {
                return null;
                //model.addAttribute("message", "게시글이 존재하지 않습니다.");
            }

            //  } else throw new NoSuchElementException();
        } else return null;
    }

    public String getBoardName(Integer boardId) {
        Optional<Board> boardNameTemp = this.boardRepository.findById(boardId);

        if(boardNameTemp.isPresent()) {
            Board board = boardNameTemp.get();
            //model에 저장할 이름 : 게시판이름+PostList (ex: JAVAPostList)
            return board.getCommBoardName() + "PostList";
        }
        return null;

    }

    /**
     * 게시글 상세페이지 만들기 위해 단일게시글 조회
     * @param id
     * @return
     */
    public Post getPost(Integer id) {
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()) {
            return post.get();
        } else {
            throw new DataNotFoundException("post not found");
        }
    }

    /**
     * 커뮤니티 게시글 저장 서비스
     * @param subject
     * @param content
     */
    public void savePost(String subject, String content, Integer boardId) {
        Post post = new Post();
        post.setPSubject(subject);
        post.setPContent(content);
        //TODO 회원가입-로그인 서비스 개발 후 글 작성자 로직 바꾸기
        post.setPAuthor(this.userService.getUser(1));
        post.setPCreateDate(LocalDateTime.now());
        post.setBoard(this.boardRepository.findById(boardId).get());
        this.postRepository.save(post);
    }

}
