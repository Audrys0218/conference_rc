package lt.nfq.conference.service.dao;

import java.util.Date;
import java.util.List;

import lt.nfq.conference.domain.Conference;

import org.apache.ibatis.annotations.*;

public interface ConferenceMapper {
    @Delete("DELETE FROM conference WHERE id=#{id}")
    public int deleteConference(@Param("id") int id);

    @Select("SELECT * FROM conference WHERE creator_id=#{creator_id}")
    public List<Conference> getConferenceByCreatorId(@Param("creator_id") int creator_id);

    @Select("SELECT * FROM conference WHERE id=#{id}")
    public Conference getConference(@Param("id") int id);

    @Select("SELECT * FROM conference")
    public List<Conference> getConferences();

    @Select("SELECT * FROM conference WHERE startDate > #{start} and startDate < #{end} and endDate < #{end} and endDate > #{start}")
    public List<Conference> getConferencesByDates(@Param("start") Date start, @Param("end") Date end);

    @Options(flushCache=true)
    @Update("UPDATE conference set name = #{name}, startDate = #{startDate}, endDate = #{endDate}, description = #{description}, " +
            "city = #{city}, street = #{street}, category_id = #{category_id}, creator_id = #{creator_id}  WHERE id=#{id}")
    public int updateConference(Conference conference);

    @Options(flushCache=true)
    @Insert("INSERT INTO conference (name, startDate, endDate, description, city, street, category_id, creator_id) VALUES (#{name}, #{startDate}, #{endDate}, #{description}, #{city}, #{street}, #{category_id}, #{creator_id})")
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=int.class)
    public int insertConference(Conference conference);
    
}
