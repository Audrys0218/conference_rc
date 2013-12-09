package lt.nfq.conference.service.dao;

import lt.nfq.conference.domain.Participants;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/7/13
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantsMapperTest extends DaoTestBase {
    private ParticipantsMapper mapper;
    @Before
    public void setup() {
        mapper = sqlSession.getMapper(ParticipantsMapper.class);
    }

    @Test
    public void testGetParticipantsByIds(){
        Participants actual = mapper.getParticipantByIds(1, 3);
        assertEquals(Integer.valueOf(4), actual.getId());
        assertEquals(Integer.valueOf(1), actual.getParticipant_id());
        assertEquals(Integer.valueOf(3), actual.getConference_id());
    }
    @Test
    public void testgetParticipant(){
        Participants p1 = new Participants();
        p1.setId(1);
        p1.setParticipant_id(1);
        p1.setConference_id(1);

        Participants actual = mapper.getParticipant(1);
        assertEquals(p1, actual);
    }

    @Test
    public void testgetParticipants(){
        List<Participants> actual = mapper.getParticipants(1);
        Participants p1 = new Participants();
        p1.setId(1);
        p1.setParticipant_id(1);
        p1.setConference_id(1);

        Participants p2 = new Participants();
        p2.setId(4);
        p2.setParticipant_id(1);
        p2.setConference_id(3);

        List<Participants> expected = new LinkedList<Participants>();
        expected.add(p1);
        expected.add(p2);
        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }
    @Test
    public void testInsertParticipant(){
        Participants participant = new Participants();
        participant.setParticipant_id(Integer.valueOf(1));
        participant.setConference_id(Integer.valueOf(2));
        assertEquals(1, mapper.insertParticipant(participant));
        Participants insertedParticipant = mapper.getParticipant(participant.getId());
        assertEquals(Integer.valueOf(1), insertedParticipant.getParticipant_id());
        assertEquals(Integer.valueOf(2), insertedParticipant.getConference_id());
    }


}
