package ming.dCommunity.community.board.repository;

import ming.dCommunity.community.board.entity.Board;
import ming.dCommunity.community.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
Optional <List<Post>> findByBoard(Board board);
}
