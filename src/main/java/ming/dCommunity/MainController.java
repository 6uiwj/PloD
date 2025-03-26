package ming.dCommunity;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.service.PostService;
import ming.dCommunity.community.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private final PostService postService;

    @Autowired
    private final BoardService boardService;



    @ModelAttribute
    public void addIndexPageBoardAttributes(Model model) {
        model.addAttribute("AllCommBoardLatestPostList", boardService.getAllBoardLatestPost());
    }

    @GetMapping("/")
    public String index() {

        return "main";
    }


}
