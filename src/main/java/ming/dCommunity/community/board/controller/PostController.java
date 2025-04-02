package ming.dCommunity.community.board.controller;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.entity.Post;
import ming.dCommunity.community.board.service.PostService;
import ming.dCommunity.community.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {

    @Autowired
    private final PostService postService;

    @Autowired
    private final BoardService boardService;

    /**
     * post_detail에서도 boardSkin템플릿을 레이아웃으로 꼈을 때
     * 메뉴(커뮤니티 리스트)가 제대로 출력되게 하기 위해 communityController와 똑같이 boardName 가져와줌
     * @param model
     */
    @ModelAttribute
    public void addBoardAttributes(Model model) {
        model.addAttribute("boardList", boardService.getList());
        model.addAttribute("boardNameList", boardService.getBoardNameList());
    }


    /**
     * 게시판별 게시글 상세페이지
     * @param model
     * @param boardName
     * @param id
     * @return
     */
    @GetMapping("/{boardName}/detail/{id}")
    public String detail(Model model, @PathVariable("boardName") String boardName, @PathVariable("id") Integer id) {
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);
        return "/community/post_detail";

    }

//    /**
//     * 게시판ID로 게시판 이름 가져오기
//     * @param boardId
//     * @return
//     */
//    public String boardName(Integer boardId) {
//        String boardName = "";
//        if(boardId==1) {
//            boardName = boardService.getBoardName(1);
//        } else if (boardId==5) {
//            boardName = boardService.getBoardName(5);
//        } else if (boardId==6) {
//            boardName = boardService.getBoardName(6);
//        } else {
//            return null;
//        }
//        return boardName;
//    }
}
