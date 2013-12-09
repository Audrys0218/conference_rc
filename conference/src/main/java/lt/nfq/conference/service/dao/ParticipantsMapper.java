package lt.nfq.conference.service.dao;

import lt.nfq.conference.domain.Participants;
import lt.nfq.conference.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/7/13
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ParticipantsMapper {

    @Delete("DELETE FROM Participants WHERE participant_id=#{participant_id} AND conference_id=#{conference_id}")
    public int deleteParticipation(@Param("participant_id") int participant_id,@Param("conference_id") int conference_id );

    @Select("SELECT * FROM Participants WHERE id=#{id}")
    public Participants getParticipant(@Param("id") int id);

    @Select("SELECT * FROM Participants WHERE participant_id=#{participant_id} AND conference_id=#{conference_id}")
    public Participants getParticipantByIds(@Param("participant_id") int participant_id,@Param("conference_id") int conference_id );

    @Select("SELECT * FROM Participants WHERE participant_id=#{participant_id}")
    public List<Participants> getParticipants(@Param("participant_id") int participant_id);

    @Options(flushCache=true)
    @Update("UPDATE Participants set id = #{id}, participant_id = #{participant_id}, conference_id = #{conference_id} WHERE id=#{id}")
    public int updateParticipant(Participants participant);

    @Options(flushCache=true)
    @Insert("INSERT INTO Participants (participant_id, conference_id) VALUES (#{participant_id}, #{conference_id})")
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=int.class)
    public int insertParticipant(Participants participant);

}
