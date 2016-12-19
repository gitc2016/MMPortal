package am.gitc.mportal.action;

/**
 * Created by gtc-user29 on 12/19/2016.
 */
public class ManageProfileAction extends GlobalAction {

    private String description;
    private String experience;
    private String skills;


    public ManageProfileAction() throws Exception {

    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


}
