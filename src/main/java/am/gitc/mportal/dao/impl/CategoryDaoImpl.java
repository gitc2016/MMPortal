package am.gitc.mportal.dao.impl;

import am.gitc.mportal.dao.CategoryDao;
import am.gitc.mportal.domain.Category;
import am.gitc.mportal.domain.User;
import am.gitc.mportal.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private Session session;

    public CategoryDaoImpl(){
    session = HibernateUtil.createSessionFactory().openSession();
    }

    @Override
    public List<Category> getCategoryByParentId() {
        Criteria criteria = session.createCriteria(Category.class);
        Criterion result = Restrictions.eq("parentId", 0);
        return criteria.add(result).list();
    }

    public List<Category> getSubCategory(int id){
        Criteria criteria = session.createCriteria(Category.class);
        Criterion result = Restrictions.eq("parentId", id);
        return (List<Category>) criteria.add(result).list();
    }
    public Category getCategoryById(int id) {
        return (Category) session.get(Category.class,id);
    }

    @Override
    public void addCategory(Category category) {
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }
    public static void main(String[] args) throws Exception {
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        Category category = categoryDao.getCategoryById(12);

//        System.out.println(category.getUserList());

        for (User user : category.getUserList()) {
            if (user.getName().startsWith("Rube")) {
                System.out.println(user);
            }
        }

//        List<User> userList = category.getUserList();
//        for (User user : userList) {
//            if (user.getName().startsWith("R")){
//                System.out.println(user);
//            }
//        }

//        UserDaoImpl userDao= new UserDaoImpl();
//        User user = userDao.getById(48);
//        System.out.println(user.getName());
//        System.out.println("Rub category list:"+user.getCategoryList());
//
//        System.out.println(category.getName());
//        System.out.println("Mysql users list"+category.getUserList());
//        List<User> searchList = (List<User>) userDao.getSearchUserListByName(12);
//        for (User user1 : searchList) {
//            System.out.println("search list is :"+user1.getName());
//        }



//        System.out.println(categoryDao.getUserByCategory(category).toString());
    }
}
