package demo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_INFO")
@Data
public class UserInfo {

//    @Id
//    @GeneratedValue
//    @Column(name = "user_id")
//    private Long id;

    @Id
    @Column(name = "user_id")
    private String username;

    private String address;

    public UserInfo() {

    }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
