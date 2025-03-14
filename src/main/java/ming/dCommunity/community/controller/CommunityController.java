package ming.dCommunity.community.controller;

import lombok.RequiredArgsConstructor;
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

    @GetMapping
    public String communityMain(Model model) {
        model.addAttribute("boardList",boardService.getList());
        model.addAttribute("boardNameList", boardService.getBoardNameList());
        return "/community/community_main";
    }

    @GetMapping("/python")
    public String pythonComm() {
        return "/community/pythonComm";
    }

    @GetMapping("/java")
    public String javaComm() {
        return "/community/javaComm";
    }

    @GetMapping("/c")
    public String cComm() {
        return "/community/cComm";
    }

}
