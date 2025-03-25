package ming.dCommunity.community.controller;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.service.PostService;
import ming.dCommunity.community.service.BoardService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@RequiredArgsConstructor
@Controller
@RequestMapping("/community")
public class CommunityController {

    private final BoardService boardService;
    private final PostService postService;
    private MessageSource messageSource;

    //모든 요청 전에 실행되어 model에 데이터 추가
    @ModelAttribute
    public void addBoardAttributes(Model model) {
        model.addAttribute("boardList", boardService.getList());
        model.addAttribute("boardNameList", boardService.getBoardNameList());
    }

    @GetMapping
    public String communityMain(Model model) {
        return "/community/community_main";
    }

    @GetMapping("/python")
    public String pythonComm(Model model) {
        if (postService.getList(5) != null) {
            model.addAttribute(postService.getBoardName(5),postService.getList(5));
        } else {
            notFoundPostMessage(model);
        }        return "/community/pythonComm";
    }

    @GetMapping("/java")
    public String javaComm(Model model) {

          if (postService.getList(1) != null) {
              model.addAttribute(postService.getBoardName(1),postService.getList(1));
          } else {
              notFoundPostMessage(model);
          }
          return "/community/javaComm";
    }

    @GetMapping("/c")
    public String cComm(Model model) {
        if (postService.getList(6) != null) {
            model.addAttribute(postService.getBoardName(6),postService.getList(6));
        } else {
            notFoundPostMessage(model);
        }
        return "/community/cComm";
    }

    public void notFoundPostMessage(Model model) {
        String notFoundPostMessage =
                messageSource.getMessage("NotFoundPost", null, Locale.getDefault());
        //위에서 가져온 errors의 값을 model에 넣어줄 것임
        model.addAttribute("NotFoundPost", notFoundPostMessage);
    }

}
