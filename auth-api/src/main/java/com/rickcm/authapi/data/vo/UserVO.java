package com.rickcm.authapi.data.vo;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class UserVO implements Serializable {

    private static final long serialVersionUID = -1053145115990389635L;

    private String email;

    private String password;

}
