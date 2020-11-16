package by.grodno.nosevich.webapp.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "department_table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String city;
    @OneToMany(mappedBy = "department")
    private List<User> users = new ArrayList<User>();

    public Department(){}
    public Department(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public boolean equals(Department dept) {
        if (getName().trim().toLowerCase().equals(dept.getName().trim().toLowerCase())
            && getCity().trim().toLowerCase().equals(dept.getCity().trim().toLowerCase())){
            return true;
        }
        return false;
    }
}
