package ming.dCommunity.qna.repository;

import ming.dCommunity.qna.entity.QnaAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaAnswerRepository extends JpaRepository<QnaAnswer,Integer> {
}
