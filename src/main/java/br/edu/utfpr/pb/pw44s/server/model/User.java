package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{utfpr.pw44s.user.username.notNull}")
    @Size(min = 4, max = 255)
    private String username;

    @NotNull (message = "O campo displayName não pode ser nulo")
    @Size(min = 4, max = 255)
    private String displayName;

    @NotNull
    @Size (min = 6)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getPassword() {
        return password;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
