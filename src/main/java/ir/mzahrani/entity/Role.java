package ir.mzahrani.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN("ADMIN"),
    MEMBER("MEMBER"),
    GUEST("GUEST");

    private String name;

    Role(String name){
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
