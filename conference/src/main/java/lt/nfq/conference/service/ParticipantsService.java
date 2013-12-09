package lt.nfq.conference.service;

import lt.nfq.conference.domain.Participants;
import lt.nfq.conference.service.dao.ParticipantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 12/9/13
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ParticipantsService {
    @Autowired
    private ParticipantsMapper participantsMapper;

    public int cancelParticipation(int participant_id, int category_id){
        return participantsMapper.deleteParticipation(participant_id, category_id);
    }

    public List<Participants> getParticipants(int participant_id){
        return participantsMapper.getParticipants(participant_id);
    }

    public void saveParticipant(Participants participant) {
        Participants part = participantsMapper.getParticipantByIds(participant.getParticipant_id(), participant.getConference_id());
        if(part != null){
            participantsMapper.updateParticipant(participant);
        }else{
            participantsMapper.insertParticipant(participant);
        }
    }
}
