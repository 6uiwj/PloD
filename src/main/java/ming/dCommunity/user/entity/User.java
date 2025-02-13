package ming.dCommunity.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uId; //id

    @Column(nullable = false, unique = true)
    private String userId; //유저ID

    private String username; //유저 실명

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname; //유저 별명

    private String email;

    private User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public static User create(String nickname, String email, String password) {
        return new User(nickname, email, password);
    }

}
