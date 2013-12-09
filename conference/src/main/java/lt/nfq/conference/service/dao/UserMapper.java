package lt.nfq.conference.service.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 11/27/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */

import lt.nfq.conference.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

public interface UserMapper {

    @Select("SELECT * FROM Users WHERE username=#{username}")
    public User getUserByUsername(@Param("username") String username);

    @Select("SELECT * FROM Users WHERE id = #{id}")
    public User getUser(@Param("id") int id);

    @Select("SELECT * FROM Users")
    public LinkedList<User> getUsers();

    @Options(flushCache=true)
    @Update("UPDATE Users set name = #{name}, surname = #{surname}, username = #{username}, password = #{password}, email = #{email} WHERE id=#{id}")
    public int updateUser(User user);

    @Options(flushCache=true)
    @Insert("INSERT INTO Users (name, surname, username, password, email) VALUES (#{name}, #{surname}, #{username}, #{password}, #{email})")
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=int.class)
    public int insertUser(User user);
}
