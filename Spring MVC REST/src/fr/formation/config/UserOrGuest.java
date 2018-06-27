package fr.formation.config;

import java.lang.annotation.*;

import org.springframework.security.access.annotation.Secured;

@Retention(RetentionPolicy.RUNTIME)
@Secured({ "ROLE_GUEST", "ROLE_USER" })
public @interface UserOrGuest {
    //
}
