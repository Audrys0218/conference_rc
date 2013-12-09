package lt.nfq.conference.service.dao;

import lt.nfq.conference.domain.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/9/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRoleMapper {
    @Options(flushCache=true)
    @Insert("INSERT INTO user_roles (USER_ID, AUTHORITY) VALUES (#{user_id}, #{authority})")
    @SelectKey(statement="CALL IDENTITY()", keyProperty="user_role_id", before=false, resultType=int.class)
    public int insertUserRole(UserRole userRole);
}
