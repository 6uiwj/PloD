package ming.dCommunity.community.board.repository;

import ming.dCommunity.community.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
