package com.muntanji.velocitydemo.registration;

import com.muntanji.velocitydemo.registration.exception.ApiError;
import com.muntanji.velocitydemo.registration.model.User;
import org.jboss.resteasy.annotations.Form;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/registration")
@Component
public class RegistrationResource {
    // Extend the current resource to receive and store the data in memory.
    // Return a success information to the user including the entered information.
    // In case of the address split the information into a better format/structure
    // for better handling later on.
    @GET
    public Response save() {
        return Response.ok().build();
    }

    @POST
    public Response save(User user) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        List<String> errors = new ArrayList<>();
        violations.forEach(error -> errors.add(error.getMessage()));
        if (!violations.isEmpty()) {
            return Response.ok(new ApiError("Form has issues", HttpStatus.BAD_REQUEST, errors)).build();
        }
        return Response.ok(user).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
