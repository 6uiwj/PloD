package ming.dCommunity.faq.repository;

import ming.dCommunity.faq.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Integer> {
}
