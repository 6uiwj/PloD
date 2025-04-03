package ming.dCommunity.user.controller;

import lombok.RequiredArgsConstructor;
import ming.dCommunity.user.entity.UserInfo;
import ming.dCommunity.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfo getUser(Integer uId) {
        return this.userRepository.findById(uId).get();
    }
}
