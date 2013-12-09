package lt.nfq.conference.ModelView;

import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/4/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewConferenceViewModel {
    String id;
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    String title;
    String starts;
    String ends;
    Integer category_id;
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    String city;
    @Size(min = 6, max = 30, message = "Field should be between 6 and 30 characters length.")
    String street;
    String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getEnds() {
        return ends;
    }

    public void setEnds(String ends) {
        this.ends = ends;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NewConferenceViewModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", starts='" + starts + '\'' +
                ", ends='" + ends + '\'' +
                ", category_id=" + category_id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
