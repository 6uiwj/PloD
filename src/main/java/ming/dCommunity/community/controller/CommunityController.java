package ming.dCommunity.community.controller;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.service.PostService;
import ming.dCommunity.community.service.BoardService;
import org.springframework.context.MessageSource;
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
    private MessageSource messageSource;

    @GetMapping
    public String communityMain(Model model) {
        model.addAttribute("boardList",boardService.getList());
        model.addAttribute("boardNameList", boardService.getBoardNameList());
        return "/community/community_main";
    }

    @GetMapping("/python")
    public String pythonComm(Model model) {
        model.addAttribute(postService.getBoardName(5),postService.getList(5));
        return "/community/pythonComm";
    }

    @GetMapping("/java")
    public String javaComm(Model model) {
        /**
         * if (postService.getList(1) != null) {
         *     model.addAttribute(postService.getBoardName(1),postService.getList(1));
         * } else {
         *     String notFoundPostMessage =
         *          messageSource.getMessage("NotFound,post", null, LocalContextHolder.getLocale());
         *          model.addAttribute("NotFoundPost", notFoundPostMessage);
         * }
         */
        model.addAttribute(postService.getBoardName(1),postService.getList(1));
        return "/community/javaComm";
    }

    @GetMapping("/c")
    public String cComm(Model model) {
        postService.getList(6);
        return "/community/cComm";
    }

}
