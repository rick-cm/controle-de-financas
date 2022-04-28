package com.rickcm.authapi.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.rickcm.authapi.enums.UserAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class UserPermission implements GrantedAuthority {

    @DynamoDBAttribute(attributeName="permission")
    private String permission;

    @Override
    @DynamoDBIgnore
    public String getAuthority() {
        return permission;
    }
}
