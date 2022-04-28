package com.rickcm.authapi.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName="user")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 5658816903134946878L;

    @Id
    @DynamoDBHashKey(attributeName="email")
    private String email;
    @DynamoDBAttribute(attributeName="uuid")
    private String uuid;
    @DynamoDBAttribute(attributeName="password")
    private String password;
    @DynamoDBAttribute(attributeName="permissions")
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
    private List<UserPermission> permissions;

    public User(String email,
                String uuid,
                String password,
                List<UserPermission> permissions) {
        this.email = email;
        this.uuid = uuid;
        this.password = password;
        this.permissions = permissions;
    }

    public static String encript(String password){
        return new String(Base64.getEncoder().encodeToString(password.getBytes()));
    }

    @DynamoDBIgnore
    public List<String> getRoles(){
        List<String> roles = new ArrayList<>();
        this.permissions.stream()
                .forEach(permission -> {
                    roles.add(permission.getAuthority());
                });
        return roles;
    }

    @DynamoDBIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @DynamoDBIgnore
    @Override
    public String getUsername() {
        return email;
    }
    @DynamoDBIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @DynamoDBIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @DynamoDBIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @DynamoDBIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
