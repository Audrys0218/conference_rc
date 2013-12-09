package lt.nfq.conference.service;

import java.util.Date;
import java.util.List;

import lt.nfq.conference.domain.Conference;
import lt.nfq.conference.service.dao.ConferenceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {
	
    @Autowired
    private ConferenceMapper conferenceMapper;

    public int deleteConference(int id){
        return conferenceMapper.deleteConference(id);
    }

    public List<Conference> getConferencesByCreatorId(int creator_id){
        return conferenceMapper.getConferenceByCreatorId(creator_id);
    }

    public List<Conference> getConferences(){
        return conferenceMapper.getConferences();
    }

    public List<Conference> getConferencesByDates(Date start, Date end) {
        return conferenceMapper.getConferencesByDates(start, end);
    }

    public Conference getConference(int id) {
        return conferenceMapper.getConference(id);
    }

    public boolean updateConference(Conference conference) {
        return conferenceMapper.updateConference(conference) > 0;
    }

    public void saveConference(Conference conference) {
    	if (conference.getId() != null) {
    		conferenceMapper.updateConference(conference);
    	} else {
    		conferenceMapper.insertConference(conference);
    	}
    }
}
