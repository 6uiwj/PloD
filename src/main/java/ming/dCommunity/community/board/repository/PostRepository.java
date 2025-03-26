package ming.dCommunity.community.board.repository;

import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    //게시판으로 게시글리스트 조회 (게시판 별로 게시글목록 가져오기 위해서)
    Optional <List<Post>> findByBoard(Board board);

    //최신순로 게시판별 게시글 가져오기
    @Query("SELECT p FROM Post p WHERE p.board.id = :boardId ORDER BY p.pCreateDate DESC")
    List<Post> findPostsByBoardIdOrderByCreateDateDesc(@Param("boardId") Integer boardId);

    //모든 게시판 통틀어서 최근게시글
    @Query("SELECT p FROM Post p ORDER BY p.pCreateDate DESC")
    List<Post> findPostsOrderByCreateDateDesc();
}
