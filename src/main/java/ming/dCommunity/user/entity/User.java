package ming.dCommunity.user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
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


}
