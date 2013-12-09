package lt.nfq.conference.controller;

import lt.nfq.conference.domain.Conference;
import lt.nfq.conference.domain.Participants;
import lt.nfq.conference.service.ConferenceService;
import lt.nfq.conference.service.ParticipantsService;
import lt.nfq.conference.service.dao.ParticipantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UserConferencesController {
    //Veliau sita reikes paimti is duomenu bazes naudojant sprin secure frameworka
    private final static Integer USER_ID = 1;
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    ParticipantsService participantsService;

//
//    @RequestMapping(value = "/lists", method = RequestMethod.GET)
//    public String myConferences(ModelMap model) {
//        model.addAttribute("createdConf", conferenceService.getConferencesByCreatorId(USER_ID));
//        model.addAttribute("dateFormat", getDateFormat());
//        model.addAttribute("participantsConf", getParticipantConferences());
//        return "lists";
//    }
//
//    private LinkedList<Conference> getParticipantConferences(){
//        LinkedList<Conference> result = new LinkedList<>();
//        List<Participants> participants = participantsService.getParticipants(USER_ID);
//        for (Participants participant : participants) {
//            result.add(conferenceService.getConference(participant.getConference_id()));
//        }
//        return result;
//    }

    private SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

}
