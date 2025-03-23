package ming.dCommunity.community;

import ming.dCommunity.community.board.repository.BoardRepository;
import ming.dCommunity.community.board.repository.PostRepository;
import ming.dCommunity.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class postServiceTest {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

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
}
