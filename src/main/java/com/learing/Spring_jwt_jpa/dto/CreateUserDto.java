package com.learing.Spring_jwt_jpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserDto {
    @NonNull
    @JsonProperty("username")
    private String userName;
    @NonNull
    @JsonProperty("password")
    private String password;
    @NonNull
    @JsonProperty("firstname")
    private String firstName;
    @NonNull
    @JsonProperty("lastname")
    private String lastName;
    @NonNull
    @JsonProperty("email")
    private String email;
    @NonNull
    @JsonProperty("mobile")
    private String mobile;
}
