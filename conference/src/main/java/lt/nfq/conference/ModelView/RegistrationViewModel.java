package lt.nfq.conference.ModelView;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/3/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationViewModel {
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    private String name;
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    private String surname;
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    private String username;
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    private String password;
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    private String retypedPassword;
    @Email(message = "Not valid email format.")
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    private String email;
    @Email(message = "Not valid email format.")
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    private String retypedEmail;

    public String getRetypedEmail() {
        return retypedEmail;
    }

    public void setRetypedEmail(String retypedEmail) {
        this.retypedEmail = retypedEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypedPassword() {
        return retypedPassword;
    }

    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegistrationViewModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retypedPassword='" + retypedPassword + '\'' +
                ", email='" + email + '\'' +
                ", retypedEmail='" + retypedEmail + '\'' +
                '}';
    }
}
