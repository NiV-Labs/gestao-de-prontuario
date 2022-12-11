package br.com.nivlabs.cliniv.models.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.nivlabs.cliniv.models.BaseObjectWithCreatedAt;

/**
 * Classe User.java
 * 
 * @author <a href="mailto:viniciosarodrigues@gmail.com">Vinícios Rodrigues</a>
 * 
 * @since 6 de set de 2019
 */
@Entity
@Table(name = "USUARIO")
public class UserApplication extends BaseObjectWithCreatedAt {

    private static final long serialVersionUID = -4066717030226233952L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_PESSOA")
    private Person person;

    @Column(name = "USUARIO")
    private String userName;

    @JsonIgnore
    @Column(name = "SENHA", nullable = false, length = 500)
    private String password;

    @Column(name = "ATIVO")
    private boolean active;

    @Column(name = "PRIMEIRO_LOGIN")
    private boolean firstSignin;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USUARIO_PERMISSAO", joinColumns = {@JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns = {@JoinColumn(name = "ID_PERMISSAO")})
    private List<Role> roles = new ArrayList<>();

    public UserApplication() {
        super();
    }

    public UserApplication(Long id, Person person, String userName, String password, boolean active, boolean firstSignin,
            List<Role> roles) {
        super();
        this.id = id;
        this.person = person;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.firstSignin = firstSignin;
        this.roles = roles;
    }

    /**
     * @param userId
     */
    public UserApplication(Long userId) {
        this.id = userId;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the firstSignin
     */
    public boolean isFirstSignin() {
        return firstSignin;
    }

    /**
     * @param firstSignin the firstSignin to set
     */
    public void setFirstSignin(boolean firstSignin) {
        this.firstSignin = firstSignin;
    }

    /**
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserApplication [id=");
        builder.append(id);
        builder.append(", person=");
        builder.append(person);
        builder.append(", userName=");
        builder.append(userName);
        builder.append(", password=");
        builder.append(password);
        builder.append(", active=");
        builder.append(active);
        builder.append(", firstSignin=");
        builder.append(firstSignin);
        builder.append(", roles=");
        builder.append(roles);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, firstSignin, id, password, person, roles, userName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserApplication other = (UserApplication) obj;
        return active == other.active && firstSignin == other.firstSignin && Objects.equals(id, other.id)
                && Objects.equals(password, other.password) && Objects.equals(person, other.person) && Objects.equals(roles, other.roles)
                && Objects.equals(userName, other.userName);
    }

}