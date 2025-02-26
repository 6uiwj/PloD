package ming.dCommunity.community.comment.repository;

import ming.dCommunity.community.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
