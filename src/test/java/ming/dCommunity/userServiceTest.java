package ming.dCommunity;

import ming.dCommunity.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void userCreateTest() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId("test");
//        userInfo.setEmail("test@test.org");
//        userInfo.setPassword("1234");
//        userInfo.setUsername("홍길동");
//        userInfo.setNickname("태평양넙치");
//
//        userRepository.save(userInfo);
    }
}
