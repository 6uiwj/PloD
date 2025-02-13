package ming.dCommunity.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna")
public class QnaController {
    @GetMapping
    public String qnaMain(){
        return "/qna/qna_main";
    }
}
