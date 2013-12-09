package lt.nfq.conference.controller;

import lt.nfq.conference.ModelView.RegistrationViewModel;
import lt.nfq.conference.domain.User;
import lt.nfq.conference.service.UserService;
import lt.nfq.conference.service.dao.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        model.addAttribute("regModel", new RegistrationViewModel());
        return "registration";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public  String save(@ModelAttribute("regModel")@Valid RegistrationViewModel regModel, BindingResult result){
        if(result.hasErrors()){
            return "registration";
        }
        User user = regModelToUser(regModel);
        userService.saveUser(user);
        return "login";

    }
    private User regModelToUser(RegistrationViewModel model){
        User user = new User();
        user.setName(model.getName());
        user.setSurname(model.getSurname());
        user.setUsername(model.getUsername());
        user.setPassword(model.getPassword());
        user.setEmail(model.getEmail());
        return user;
    }

}
