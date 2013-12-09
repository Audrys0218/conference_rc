package lt.nfq.conference.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/9/13
 * Time: 9:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRole {
    private int user_role_id;
    private int user_id;
    private String authority;
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user_role_id=" + user_role_id +
                ", user_id=" + user_id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
