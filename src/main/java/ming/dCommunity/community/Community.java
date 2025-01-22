package ming.dCommunity.community;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Community {
    @Id
    private Integer cId;
}
