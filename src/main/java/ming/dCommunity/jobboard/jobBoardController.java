package ming.dCommunity.jobboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobBoard")
public class jobBoardController {
    @GetMapping
    public String jobBoardMain() {
        return "/jobBoard/jobBoard_main";
    }
}
