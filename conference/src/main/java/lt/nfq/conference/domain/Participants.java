package lt.nfq.conference.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/7/13
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Participants {
    Integer id;
    Integer participant_id;
    Integer conference_id;

    public Integer getConference_id() {
        return conference_id;
    }

    public void setConference_id(Integer conference_id) {
        this.conference_id = conference_id;
    }

    public Integer getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participants that = (Participants) o;

        if (conference_id != null ? !conference_id.equals(that.conference_id) : that.conference_id != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (participant_id != null ? !participant_id.equals(that.participant_id) : that.participant_id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (participant_id != null ? participant_id.hashCode() : 0);
        result = 31 * result + (conference_id != null ? conference_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Participants{" +
                "id=" + id +
                ", participant_id=" + participant_id +
                ", conference_id=" + conference_id +
                '}';
    }
}
