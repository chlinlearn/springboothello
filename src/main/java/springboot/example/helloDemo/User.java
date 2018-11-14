package springboot.example.helloDemo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Role;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
public class User implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @DateTimeFormat(pattern = "yy-mm-dd hh:mm;ss")
    private Date createdate;

    @ManyToOne
    @JoinColumn(name="did")
    @JsonBackReference
    private Department department;
    @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(name="user.role",
             joinColumns={@JoinColumn(name="user.id")},
             inverseJoinColumns={@JoinColumn(name="roles_id")})
    private List<Role> roles;
    public User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
