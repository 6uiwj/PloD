package ming.dCommunity.community;

import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.entity.Post;
import ming.dCommunity.community.board.repository.BoardRepository;
import ming.dCommunity.community.board.repository.PostRepository;
import ming.dCommunity.community.board.service.PostService;
import ming.dCommunity.user.entity.UserInfo;
import ming.dCommunity.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
public class postServiceTest {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    PostService postService;

    @Test
    void javaPost() {
//        Post post = new Post();
//        post.setPSubject("게시판테스트제목1"); //제목
//        post.setPContent("게시판테스트내용1"); //내용
//        post.setPCreateDate(LocalDateTime.now()); //작성일
//        Optional<UserInfo> userInfotemp = userRepository.findById(1);
//        if(userInfotemp.isPresent()) {
//            UserInfo userInfo = userInfotemp.get();
//            post.setPAuthor(userInfo); //작성자
//        } else throw new NoSuchElementException();
//
//
//        post.setBoard(boardRepository.findById(1).get());
//        postRepository.save(post);
    }

@Test
    void getList() {

        //게시판 별 게시글 목록을 조회하여 model에 저장할때 java게시글은 javaPostList, C는 CPostList로 이름을 저장하기 위해 게시판의 이름을 가져오기
        ////게시판 이름을 얻기 위해 해당 게시판의 ID로 게시판 조회
        Optional<Board> boardNameTemp = this.boardRepository.findById(1);


        if(boardNameTemp.isPresent()) {
            Board board = boardNameTemp.get();
            String postAttributeName = board.getCommBoardName() + "PostList";
            System.out.println("게시판이름은? " + postAttributeName);
            //게시판별 게시글 조회 위해 게시판을 키워드로 검색해서 게시글을 목록 조회할 것임
            //ex) 자바커뮤니티의 게시물이면 -> post(게시글)들에 저장된 Board(게시판)정보를 이용해서 board = java 인 게시글들 검색
            Optional<List<Post>> postListTemp = this.postRepository.findByBoard(board);

            if (postListTemp.isPresent()) { //게시글이 있을 때
                System.out.println("List담겼나?");

                List<Post> postList = postListTemp.get();

                for (Post item : postList) {
                    System.out.println(item);  // list의 각 항목을 출력
                }
            } else {
                //게시글이 존재하지 않습니다.
                //throw new NoSuchElementException();
            }

        } else throw new NoSuchElementException();
    }

    @Test
    void BulkCPostTest() {
        Board board = boardRepository.findById(6).get();
        UserInfo userInfo = userRepository.findById(1).get();
        for(int i = 0; i<30; i++) {
            String subject = String.format("C게시글 제목 %03d",i);
            String content = String.format("C게시글 내용 %03d",i);

            Post post = new Post();
            post.setPSubject(subject);
            post.setPContent(content);
            post.setBoard(board);
            post.setPCreateDate(LocalDateTime.now());
            post.setPAuthor(userInfo);
            this.postRepository.save(post);
        }
    }
}
