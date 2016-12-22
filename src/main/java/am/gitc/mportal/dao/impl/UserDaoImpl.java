package am.gitc.mportal.dao.impl;

import am.gitc.mportal.dao.UserDao;
import am.gitc.mportal.domain.Category;
import am.gitc.mportal.domain.Status;
import am.gitc.mportal.domain.User;
import am.gitc.mportal.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private Session session;


    public UserDaoImpl() throws Exception {
        session = HibernateUtil.createSessionFactory().openSession();
    }

    @Override
    public void create(User user) throws Exception {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void delete(User user) {
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    @Override
    public User getById(int id) throws Exception {
        return (User) session.get(User.class,id);
    }




    public void update(User user) throws Exception {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAll() throws Exception {
        return null;
    }


    @Override
    public User getUserByEmail(String email) throws Exception {
        Criteria criteria = session.createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public User getUserByEmailPassword(String email, String password) throws Exception {
        Criteria criteria = session.createCriteria(User.class);

        return (User) criteria.add(Restrictions.and(Restrictions.eq("email", email), Restrictions.eq("password", password))).uniqueResult();

    }

    @Override
    public List<User> getUserByStatus(String status) {
        Criteria criteria = session.createCriteria(User.class);
        Criterion resualt = Restrictions.eq("status",Status.valueOf(status));
        return (List<User>) criteria.add(resualt).list();
    }

    public List<User> getSearchUserListByName(String name, int categoryId) {
//        Criteria criteria = session.createCriteria(User.class);
//        Criterion result = Restrictions.like("name", name + "%");
//        return (List<User>) criteria.add(result).list();

//        SQLQuery query = session.createSQLQuery("SELECT * FROM `user` \n" +
//                "INNER JOIN mentor_category ON mentor_category.`user_id` = user.`id`\n" +
//                "\n" +
//                " WHERE user.name LIKE 'R%'");
//
//        return   query.list();
        return (List<User>) session.createCriteria(User.class).add(Restrictions.or(Restrictions.like("name",name+"%"),
                Restrictions.eq("id",categoryId))).list();

    }



    public User getUserByHashCode(String hashCode) throws Exception {//TODO think about better way to generate link for useractiovation
        Criteria criteria = session.createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("hashCode", hashCode)).uniqueResult();
    }

}
