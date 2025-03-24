package ming.dCommunity.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class Utils {
    private static final ResourceBundle errorsBundle;
    static {
        errorsBundle = ResourceBundle.getBundle("messages.errors");
    }

    public static String getMessage(String code, String type){
        // 타입이 지정되지 않으면 'errors'로 설정
        type = StringUtils.hasText(type) ? type : "errors";
        ResourceBundle bundle = null;

        if (type.equals("errors")) {
            bundle = errorsBundle; // 'errors' 타입일 경우 errorsBundle 사용
        }

        // 예외 처리: 'type'이 'errors'가 아닌 경우 빈 문자열 반환
        if (bundle == null) {
            return ""; // 혹은 null을 반환하거나 예외를 던질 수 있다.
        }

        return bundle.getString(code); // 해당 코드에 맞는 메시지를 반환
    }
}
