package am.gitc.mportal.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RuBen on 30.11.2016.
 */
@Entity
@Table(name = "mentor_category")
public class MentorCategory {
    @Id
    @GeneratedValue
    private int id;
    @JoinColumn(name = "user")
    @Column(name = "user_id")
//    private int userId;
    private List<User> userList;
    @Column(name = "category_id")
//    private int categoryId;
    private List<Category> categoryList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(int categoryId) {
//        this.categoryId = categoryId;
//    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "MentorCategory{" +
                "id=" + id +
                ", userList=" + userList +
                ", categoryList=" + categoryList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MentorCategory)) return false;

        MentorCategory that = (MentorCategory) o;

        if (getId() != that.getId()) return false;
        if (getUserList() != null ? !getUserList().equals(that.getUserList()) : that.getUserList() != null)
            return false;
        return getCategoryList() != null ? getCategoryList().equals(that.getCategoryList()) : that.getCategoryList() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getUserList() != null ? getUserList().hashCode() : 0);
        result = 31 * result + (getCategoryList() != null ? getCategoryList().hashCode() : 0);
        return result;
    }
}
