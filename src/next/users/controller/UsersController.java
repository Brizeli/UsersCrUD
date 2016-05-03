package next.users.controller;

import next.users.dao.User;
import next.users.model.UsersHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Next on 29.04.2016.
 */
@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    UsersHibernate usersdb;

    @RequestMapping({"/", "home"})
    String index() {
        return "index";
//        return "forward:/index";
    }

    @RequestMapping(value = "/searchUsers")
    public String searchUsers(Integer page, String userName, Model model) {
        List<User> usersResult;
        int size = 10;
        if (page == null) page = 1;
        long numberOfRecords = usersdb.getNumgerOfRecords(userName);
        usersResult = usersdb.findByName(userName, page, size);
        int numberOfPages = (int) Math.ceil(numberOfRecords*1.0/size);
        model.addAttribute("currentPage", page);
        model.addAttribute("noOfPages", numberOfPages);
        model.addAttribute("userList", usersResult);
        model.addAttribute("userName", userName);
        return "viewUsers";
    }

    @RequestMapping(value = "/getInfo")
    public String getUserInfo(int userId, Model model) {
        User user = usersdb.getUser(userId);
        model.addAttribute("user", user);
        return "viewUserInfo";
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(Integer userId, String userName, Integer userAge, String userAdmin, @RequestParam String action, Model model) {
        User user = new User(userId, userName, userAge, userAdmin.equals("on") ? true : false);
        if (action.equals("update")) {
            boolean editResult = usersdb.edit(user);
            model.addAttribute("user", user);
            model.addAttribute("result", editResult ? "User updated" : "Error updating user");
        } else {
            boolean deleteResult = usersdb.delete(userId);
            model.addAttribute("result", deleteResult ? "User deleted" : "Error deleting user");
            return "userDeleted";
        }
        return "viewUserInfo";
    }

    @RequestMapping(value = "/addUserForm")
    String addUserForm() {
        return "addUserForm";
    }

    @RequestMapping(value = "/addUser")
    String addUser(String name, Integer age, String isAdm, Model model) {
        boolean adm = isAdm.equals("on") ? true : false;
        User user = new User(name, age, adm);
        boolean addResult = usersdb.addUser(user);
        model.addAttribute("result", addResult);
        return "addUserForm";
    }
//    @RequestMapping("/index1")
//    public String setupForm(Map<String, Object> map) {
//        User user = new User();
//        map.put("user", user);
//        map.put("userList", usersdb.getAllUsers());
//        return "user";
//    }
//
//    @RequestMapping(value = "/user.do", method = RequestMethod.POST)
//    public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map) {
//        User userResult = new User();
//        switch (action.toLowerCase()) {
//            case "add":
//                usersdb.addUser(user);
//                userResult = user;
//                break;
//            case "edit":
//                usersdb.edit(user);
//                userResult = user;
//                break;
//            case "delete":
//                usersdb.delete(user.getId());
//                userResult = new User();
//                break;
//            case "search":
//                User userSearch = usersdb.getUser(user.getId());
//                userResult = userSearch != null ? userSearch : new User();
//                break;
//        }
//        map.put("user", userResult);
//        map.put("userList", usersdb.getAllUsers());
//        return "user";
//    }
//    @RequestMapping("/")
//    String home() {
//        return "home";
//    }
//
//    @RequestMapping(value = "addUserForm")
//    String addUserForm() {
//        return "addUserForm";
//    }
//
//    @RequestMapping(value = "addUser", method = RequestMethod.POST)
//    String addUser(String name, String age, String isAdm, Model model) {
//        int uAge = Integer.parseInt(age);
//        boolean adm = isAdm.equals("on") ? true : false;
//        User user = new User(name, uAge, adm);
//        boolean res = usersdb.addUser(user);
//        model.addAttribute("result", res);
//        return "home";
//    }
//
//    @RequestMapping(value = "showUsers", method = RequestMethod.GET)
//    String showUsers(Model model) {
//        List<User> users = usersdb.getAllUsers();
//        model.addAttribute("result", users);
//        return "viewUsers";
//    }
}
