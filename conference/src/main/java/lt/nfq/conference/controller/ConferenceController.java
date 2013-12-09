package lt.nfq.conference.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import lt.nfq.conference.ModelView.NewConferenceViewModel;
import lt.nfq.conference.domain.Category;
import lt.nfq.conference.domain.Conference;
import lt.nfq.conference.domain.Participants;
import lt.nfq.conference.domain.User;
import lt.nfq.conference.service.CategoryService;
import lt.nfq.conference.service.ConferenceService;
import lt.nfq.conference.service.ParticipantsService;
import lt.nfq.conference.service.UserService;
import lt.nfq.conference.service.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/conference")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ParticipantsService participantsService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {

        SimpleDateFormat simpleDateFormat = getDateFormat();
        long timeNow = new Date().getTime();

        String startDate = simpleDateFormat.format(timeNow);
        String endDate = simpleDateFormat.format(timeNow + 1000 * 60 * 60 * 24 * 10); // + 10d
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("dateFormat", simpleDateFormat);
        model.addAttribute("categories", categoryService.getCategories());
        try {
            model.addAttribute("conferenceList", conferenceService.getConferencesByDates(simpleDateFormat.parse(startDate), simpleDateFormat.parse(endDate)));
        } catch (ParseException e) {
            System.out.println("Problem with finding conferenceList by given startDate and endDate");
            e.printStackTrace();
        }
        System.out.println("================================================");
        System.out.println(getLogedUserId());
        return "conference/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String filterList(ModelMap model,
                             @RequestParam(value = "start") Date start,
                             @RequestParam(value = "end") Date end,
                             @RequestParam(value = "category_id") int category_id) {
        LinkedList<Conference> conferenceList =  conferencesWithCateCategory_id(conferenceService.getConferencesByDates(start, end), category_id);
        model.addAttribute("conferenceList", conferenceList);
        model.addAttribute("dateFormat", getDateFormat());

        return "conference/items";
    }
    private LinkedList<Conference> conferencesWithCateCategory_id(List<Conference> list,int id){
        LinkedList<Conference> result = new LinkedList<>();
        for(Conference a: list){
            if(a.getCategory_id()==id){
                result.add(a);
            }
        }
        return result;
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("catTitles", catTitles(categoryService.getCategories()));
        model.addAttribute("conMod", new NewConferenceViewModel());
        return "conference/form";
    }

    private Map<Integer, String> catTitles(LinkedList<Category> categories){
        Map<Integer, String> result = new HashMap<>();
        for (Category category : categories) {
            result.put(category.getId(), category.getTitle());
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(ModelMap model, @RequestParam(value = "id") int id) {
        NewConferenceViewModel m = ConferenceToNewConferencViewModel(conferenceService.getConference(id));
        model.addAttribute("catTitles", catTitles(categoryService.getCategories()));
        model.addAttribute("conMod", m);
        model.addAttribute("dateFormat", getDateFormat());
        return "conference/form";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public
//    @ResponseBody
//    HashMap<String, String> save(@ModelAttribute("conference") Conference conference) {
//        HashMap<String, String> response = new HashMap<String, String>();
//        if (conferenceService.updateConference(conference)) {
//            response.put("success", "saved");
//        } else {
//            response.put("error", "error with saving");
//        }
//        response.put("status", "ok");
//        return response;
//    }

    private SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    //Mano requestmappingai

    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    public String save1(@ModelAttribute("conMod") @Valid NewConferenceViewModel newConferenceViewModel, BindingResult result, ModelMap model){

        if(result.hasErrors()){
            model.addAttribute("catTitles", catTitles(categoryService.getCategories()));
            return "conference/form";
        }
        Conference conference = null;
        try {
            conference = newConferenceViewModelToConference(newConferenceViewModel);
            conferenceService.saveConference(conference);
            model.addAttribute("createdConf", conferenceService.getConferencesByCreatorId(getLogedUserId()));
            model.addAttribute("dateFormat", getDateFormat());
            model.addAttribute("participantsConf", getParticipantConferences());
        } catch (ParseException e) {
            //Aprasyti veiksmus, kai į datos laukelis suvedami blogo formato duomenys
            e.printStackTrace();
        }
        return "lists";
    }

    private Conference newConferenceViewModelToConference(NewConferenceViewModel newConferenceViewModel) throws ParseException {
        Conference conference = new Conference();
        if(newConferenceViewModel.getId() != ""){
            conference.setId(Integer.valueOf(newConferenceViewModel.getId()));
        }
        conference.setName(newConferenceViewModel.getTitle());
        Date starts = getDateFormat().parse(newConferenceViewModel.getStarts());
        Date ends   = getDateFormat().parse(newConferenceViewModel.getEnds());
        conference.setStartDate(starts);
        conference.setEndDate(ends);
        conference.setCategory_id(newConferenceViewModel.getCategory_id());
        conference.setDescription(newConferenceViewModel.getDescription());
        conference.setCreator_id(Integer.valueOf(getLogedUserId()));
        conference.setStreet(newConferenceViewModel.getStreet());
        conference.setCity(newConferenceViewModel.getCity());
        return  conference;
    }
    private NewConferenceViewModel ConferenceToNewConferencViewModel(Conference conference){
        NewConferenceViewModel result = new NewConferenceViewModel();
        result.setId(conference.getId().toString());
        result.setStreet(conference.getStreet());
        result.setCity(conference.getCity());
        result.setCategory_id(conference.getCategory_id());
        result.setStarts(getDateFormat().format(conference.getStartDate()));
        result.setEnds(getDateFormat().format(conference.getEndDate()));
        result.setDescription(conference.getDescription());
        result.setTitle(conference.getName());
        return result;
    }

    @RequestMapping(value = "/participate", method = RequestMethod.GET)
    public String participate(ModelMap model, @RequestParam(value = "conference_id") int conference_id) {
        Participants part = new Participants();
        part.setConference_id(conference_id);
        part.setParticipant_id(getLogedUserId());
        participantsService.saveParticipant(part);
        return "conference/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteConference(@RequestParam(value = "conference_id") int conference_id) {
        conferenceService.deleteConference(conference_id);
        return "redirect:lists";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancelConference(@RequestParam(value = "conference_id") int conference_id) {
        participantsService.cancelParticipation(getLogedUserId(), conference_id);
        return "redirect:lists";
    }


    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public String myConferences(ModelMap model) {
        model.addAttribute("createdConf", conferenceService.getConferencesByCreatorId(getLogedUserId()));
        model.addAttribute("dateFormat", getDateFormat());
        model.addAttribute("participantsConf", getParticipantConferences());
        return "lists";
    }

    private LinkedList<Conference> getParticipantConferences(){
        LinkedList<Conference> result = new LinkedList<>();
        List<Participants> participants = participantsService.getParticipants(getLogedUserId());
        for (Participants participant : participants) {
            result.add(conferenceService.getConference(participant.getConference_id()));
        }
        return result;
    }

    private int getLogedUserId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName());
        return user.getId();
    }

}
