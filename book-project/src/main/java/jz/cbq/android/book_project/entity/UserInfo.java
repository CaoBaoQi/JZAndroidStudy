package jz.cbq.android.book_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserInfo
 *
 * @author CBQ
 * @date 2023/11/11 0:13
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    /**
     * id
     */
    private Integer user_id;
    /**
     * username
     */
    private String username;
    /**
     * nickname
     */
    private String nickname;
    /**
     * email
     */
    private String email;
    /**
     * password
     */
    private String password;

}
