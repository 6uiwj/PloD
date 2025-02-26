package ming.dCommunity.notice.repository;

import ming.dCommunity.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Integer> {
}
