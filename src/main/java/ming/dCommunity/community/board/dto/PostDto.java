package ming.dCommunity.community.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//userInfo -> nickname 추출 (Post Entity의 UserInfo를 UserInfo의Nickname으로 가공)
@Getter
@Setter
public class PostDto {
    private Integer pId;          // 게시글 ID
    private String pSubject;      // 게시글 제목
    private String pContent;      // 게시글 내용
    private LocalDateTime pCreateDate;  // 작성일시
    private String pAuthorNickname;  // 작성자 닉네임만
    private String boardName;

    /**
     * Constructor
     * @param pId
     * @param pSubject
     * @param pContent
     * @param pCreateDate
     * @param pAuthorNickname
     */
    public PostDto(Integer pId, String pSubject, String pContent, LocalDateTime pCreateDate, String pAuthorNickname, String boardName) {
        this.pId = pId;
        this.pSubject = pSubject;
        this.pContent = pContent;
        this.pCreateDate = pCreateDate;
        this.pAuthorNickname = pAuthorNickname;
        this.boardName = boardName;
    }


}
