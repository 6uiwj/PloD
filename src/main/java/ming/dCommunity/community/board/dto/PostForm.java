package ming.dCommunity.community.board.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {
    //글자제한 : 영어/한글/숫자 모두 한글자=1개로 취급
    @NotEmpty(message = "제목을 입력해주세요.")
    @Size(max=20)
    private String subject;

    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;
}
