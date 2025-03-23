package ming.dCommunity.community.board.controller;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.community.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {

    private final PostService postService;

}
