package jz.cbq.android.complex_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author CBQ
 * @date 2023/11/7 13:56
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
     * password
     */
    private String password;
    /**
     * nickname
     */
    private String nickname;
}
