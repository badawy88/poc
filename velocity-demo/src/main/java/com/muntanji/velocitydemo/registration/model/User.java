package com.muntanji.velocitydemo.registration.model;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author badawy88
 * @since 2020
 **/
@Data
public class User {

    @Size(min = 5 , max = 20 , message = "name size shoud be between 5 and 20")
    @NotNull(message = "name cannot be null")
    private String name;

    @Size(min = 5 , max = 20, message = "password size shoud be between 5 and 20")
    @NotNull(message = "password cannot be null")
    private String password;

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "address cannot be null")
    private String address;

    private String phone;
}
