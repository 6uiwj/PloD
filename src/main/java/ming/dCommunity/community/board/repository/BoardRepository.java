package ming.dCommunity.community.board.repository;

import ming.dCommunity.community.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Integer> {
    //게시판 ID 조회 -> 최신 게시글 가져올때 게시판별로 가져오기 위해서
    @Query("SELECT DISTINCT b.cbId FROM Board b")
    List<Integer> findAllBoardIds();

    //cbId(보드 기본키 ID로 게시판 이름 조회)
    @Query("SELECT b.commBoardName FROM Board b WHERE b.cbId = :cbId")
    String findAllBoardName(@Param("cbId") Integer cbId);

    @Query("SELECT b.cbId FROM Board b WHERE b.commBoardName = :commBoardName")
    Integer findIdByCommBoardName(@Param("commBoardName") String commBoardName);



}
