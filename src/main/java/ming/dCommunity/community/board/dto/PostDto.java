package ming.dCommunity.community.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//userInfo -> nickname
@Getter
@Setter
public class PostDto {
    private Integer pId;          // 게시글 ID
    private String pSubject;      // 게시글 제목
    private String pContent;      // 게시글 내용
    private LocalDateTime pCreateDate;  // 작성일시
    private String pAuthorNickname;  // 작성자 닉네임만

    // 생성자, getter, setter 추가

    public PostDto(Integer pId, String pSubject, String pContent, LocalDateTime pCreateDate, String pAuthorNickname) {
        this.pId = pId;
        this.pSubject = pSubject;
        this.pContent = pContent;
        this.pCreateDate = pCreateDate;
        this.pAuthorNickname = pAuthorNickname;
    }


}
