package jz.cbq.android.complex_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserInfo
 *
 * @author Cola777jz
 * @date 2023/11/7 13:56
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer user_id;
    private String username;
    private String password;
    private String nickname;
}
