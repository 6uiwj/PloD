package ming.dCommunity.qna.repository;

import ming.dCommunity.qna.entity.QnaQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaQuestionRepository extends JpaRepository<QnaQuestion, Integer> {
}
