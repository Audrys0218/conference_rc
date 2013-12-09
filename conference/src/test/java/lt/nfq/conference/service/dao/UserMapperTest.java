package lt.nfq.conference.service.dao;

import lt.nfq.conference.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 11/27/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserMapperTest extends DaoTestBase {
    private UserMapper mapper;
    @Before
    public void setup() {
        mapper = sqlSession.getMapper(UserMapper.class);
    }

//   @Test
//   public void testGetConference() {
//        Conference conference = mapper.getConference(1);
//        assertEquals(Integer.valueOf(1), conference.getId());
//        assertEquals("Conference B", conference.getName());
//        assertEquals("2013-10-01 17:00:00", formatDate(conference.getStartDate()));
//        assertEquals("2013-10-02 18:00:00", formatDate(conference.getEndDate()));
//   }

//    INSERT INTO Users (user_id, name, surname, username, password, email) VALUES (1, 'AudriusA', 'ADanielevicius', 'AAudrys0218', 'AApassword', 'AAudrys0218@gmail.com');
//    INSERT INTO Users (user_id, name, surname, username, password, email) VALUES (2, 'AudriusB', 'BDanielevicius', 'BAudrys0218', 'BApassword', 'BAudrys0218@gmail.com');
//    INSERT INTO Users (user_id, name, surname, username, password, email) VALUES (3, 'AudriusC', 'CDanielevicius', 'CAudrys0218', 'CApassword', 'CAudrys0218@gmail.com');

    @Test
    public void testUpdateUser(){
        Integer id = 1;
        String name     = "UpdatedName";
        String surname  = "UpdatedSurname";
        String username = "UpdatedUserName";
        String password = "UpdatedUserPassword";
        String email    = "UpdatedUserEmail";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setUsername(username);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);

        assertEquals(1, mapper.updateUser(user));

        User userResult = mapper.getUser(id);
        assertEquals(Integer.valueOf(id), userResult.getId());
        assertEquals(name, userResult.getName());
        assertEquals(surname, userResult.getSurname());
        assertEquals(username, userResult.getUsername());
        assertEquals(password, userResult.getPassword());
        assertEquals(email, userResult.getEmail());
    }

    @Test
    public void testUpdateUserNonExisting(){
        Integer id = 10;
        String name     = "UpdatedName";
        String surname  = "UpdatedSurname";
        String username = "UpdatedUserName";
        String password = "UpdatedUserPassword";
        String email    = "UpdatedUserEmail";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setUsername(username);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);
        assertEquals(0, mapper.updateUser(user));
    }

    @Test
    public void testInsertUser(){
        String name     = "InsertedName";
        String surname  = "InsertedSurname";
        String username = "InsertedUserName";
        String password = "InsertedUserPassword";
        String email    = "InsertedUserEmail";

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        assertEquals(1, mapper.insertUser(user));

        User userResult = mapper.getUser(user.getId());
        assertEquals(name, userResult.getName());
        assertEquals(surname, userResult.getSurname());
        assertEquals(username, userResult.getUsername());
        assertEquals(password, userResult.getPassword());
        assertEquals(email, userResult.getEmail());
    }

    @Test
    public void testGetUserNonExisting(){
        User user = mapper.getUser(10);
        assertNull(user);
    }
    @Test
    public void testGetUsers(){
        User user1 = new User();          user1.setId(Integer.valueOf(1));
        user1.setName("AudriusA");        user1.setSurname("ADanielevicius");
        user1.setUsername("AAudrys0218"); user1.setPassword("AApassword");
        user1.setEmail("AAudrys0218@gmail.com");

        User user2 = new User();          user2.setId(Integer.valueOf(2));
        user2.setName("AudriusB");        user2.setSurname("BDanielevicius");
        user2.setUsername("BAudrys0218"); user2.setPassword("BApassword");
        user2.setEmail("BAudrys0218@gmail.com");

        User user3 = new User();          user3.setId(Integer.valueOf(3));
        user3.setName("AudriusC");        user3.setSurname("CDanielevicius");
        user3.setUsername("CAudrys0218"); user3.setPassword("CApassword");
        user3.setEmail("CAudrys0218@gmail.com");
        List<User> expected = new LinkedList<>();
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        List<User> actual = mapper.getUsers();
        assertEquals(3, actual.size());
        assertEquals(expected, actual);

    }

    @Test
    public void testGetUser(){
        User actual1 = mapper.getUser(2);
        assertEquals(Integer.valueOf(2), actual1.getId());
        assertEquals("AudriusB", actual1.getName());
        assertEquals("BDanielevicius", actual1.getSurname());
        assertEquals("BAudrys0218", actual1.getUsername());
        assertEquals("BApassword", actual1.getPassword());
        assertEquals("BAudrys0218@gmail.com", actual1.getEmail());
    }

}
