package next.users.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Next on 28.04.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    int id;
    String name;
    int age;
    boolean admin;
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    public User() {
    }

    public User(String name, int age, boolean admin) {
        this.name = name;
        this.age = age;
        this.admin = admin;
        this.createdDate = new Date();
    }

    public User(int id, String name, int age, boolean admin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.admin = admin;
        this.createdDate = new Date();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", admin=" + admin +
                ", createdDate=" + createdDate +
                '}';
    }
}
