package ming.dCommunity.community.controller;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.service.PostService;
import ming.dCommunity.community.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/community")
public class CommunityController {

    private final BoardService boardService;
    private final PostService postService;

    @GetMapping
    public String communityMain(Model model) {
        model.addAttribute("boardList",boardService.getList());
        model.addAttribute("boardNameList", boardService.getBoardNameList());
        return "/community/community_main";
    }

    @GetMapping("/python")
    public String pythonComm(Model model) {
        postService.getList(model,5);
        return "/community/pythonComm";
    }

    @GetMapping("/java")
    public String javaComm(Model model) {
        postService.getList(model, 1);
        return "/community/javaComm";
    }

    @GetMapping("/c")
    public String cComm(Model model) {
        postService.getList(model,6 );
        return "/community/cComm";
    }

}
