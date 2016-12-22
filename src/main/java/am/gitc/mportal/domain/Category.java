package am.gitc.mportal.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gtc-user17 on 11/13/2016.
 */

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    @Column(name = "parent_id")
    private int parentId;

    @ManyToMany(mappedBy = "categoryList")
    private List<User> userList = new ArrayList<User>();

    public Category() {

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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (getId() != category.getId()) return false;
        if (getParentId() != category.getParentId()) return false;
        if (getName() != null ? !getName().equals(category.getName()) : category.getName() != null) return false;
        return getUserList() != null ? getUserList().equals(category.getUserList()) : category.getUserList() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getParentId();
        result = 31 * result + (getUserList() != null ? getUserList().hashCode() : 0);
        return result;
    }
}
