package am.gitc.mportal.action;

import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.User;
import am.gitc.mportal.util.Global_Keys;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by gtc-user29 on 12/16/2016.
 */
public class ProfileSettingsAction extends GlobalAction implements ModelDriven<User> {

    private User user;
    private String newPassword;
    private UserDaoImpl userDao;


    public ProfileSettingsAction() throws Exception {
        userDao=new UserDaoImpl();
    }

//    public String execute() throws Exception {
//        super.getUserFromSession();
//        return SUCCESS;
//    }

    public String updateProfile() {
        System.out.println(user);
//        user.setPassword(newPassword);
        return SUCCESS;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public void validate(){
      int id=(Integer) mapSession.get(Global_Keys.LOGIN);
        try {
            if (!(user.getPassword().isEmpty()) && !(userDao.getById(id).getPassword()).equals(user.getPassword())) {
                if (newPassword.isEmpty()) {
                    addFieldError("user.password", "Please enter your right passsword");
                }else if (newPassword.length()<2 || newPassword.length()>20){
                    addFieldError("newPassword", "Please enter valid new");
                }
                else if(!newPassword.equals(user.getConfirmPassword())){
                    addFieldError("user.confirmPassword","Please enter valid confirmPassword");
                }
            }
            if(!newPassword.isEmpty()){
                if(!newPassword.equals(user.getConfirmPassword())){
                    addFieldError("user.confirmPassword","Please enter valid confirmPassword");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
