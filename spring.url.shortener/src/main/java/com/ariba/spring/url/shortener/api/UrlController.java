package com.ariba.spring.url.shortener.api;

import com.ariba.spring.url.shortener.dao.UrlDao;
import com.ariba.spring.url.shortener.model.Url;
import com.ariba.spring.url.shortener.model.User;
import com.ariba.spring.url.shortener.service.UrlService;
import com.ariba.spring.url.shortener.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;


@RestController
public class UrlController {

    private final UrlService urlService;
    private final UserService userService;

    private UrlDao urlDao;

    @Autowired
    public UrlController(UrlService urlService,
                         UserService userService,
                         UrlDao urlDao) {
        this.urlService = urlService;
        this.userService = userService;
        this.urlDao = urlDao;
    }

    @PostMapping
    public ResponseEntity<Object> addUrl (@RequestBody Map<String, Object> payload){
        String url = (String)payload.get("url");
        Url tmp = new Url(urlService.rand_id(),url);
        urlService.addUrl(tmp);
        HashMap<String,String> map = new HashMap<>();
        map.put("id",tmp.getId());
        return ResponseEntity.accepted().body(map);
    }

    @GetMapping("/{id}")
    public RedirectView getOriginalUrl(@PathVariable("id") final String id){
        Url oUrl = urlService.getUrlById(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(oUrl.getUrl());
        return redirectView;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<Object> registerUser(@RequestBody User user){
        int result = userService.registerUser(user);
        HashMap<String,String> response = new HashMap<>();
        if (result ==1) {
            response.put("status","successful");
            return ResponseEntity.accepted().body(response);
        }
            response.put("status","unsuccessful");
            response.put("cause","user already exist");
            return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/getUser")
    public ResponseEntity<Object> getUser(@RequestBody Map<String, Object> payload){
        String username = (String)payload.get("username");
        String password = (String)payload.get("password");
        HashMap<String,String> response = new HashMap<>();
        User user = userService.getUser(username);
        if (user== null){
            response.put("login","false");
            return ResponseEntity.badRequest().body(response);
        }
        else if (user.getPassword().equals(password)){
            response.put("login","true");
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/userUrl")
    public ResponseEntity<Object> addUserUrl(@RequestBody Map<String, Object> payload){
        String username = (String)payload.get("username");
        String string_url = (String)payload.get("url");
        Url tmp = new Url(urlService.rand_id(),string_url);
        int result = urlService.addUrl(tmp);
        HashMap<String,String> map = new HashMap<>();
        if (result == 1 ){
        userService.addToUsersLink(username,tmp.getId());
        map.put("id",tmp.getId());
        return ResponseEntity.accepted().body(map);
        }
        map.put("cause","url with same id exist");
        return ResponseEntity.badRequest().body(map);
    }

    @PostMapping("/getUsersLinks")
    public ResponseEntity<Object> getUsersLinks(@RequestBody Map<String, Object> payload){
        String username = (String)payload.get("username");
        if (!(userService.userDoExist(username)))
            return ResponseEntity.badRequest().body("");
        Iterator<String> iterator = (Iterator<String>) userService.getUserLinks(username);
        HashMap<String,String> map = new HashMap<>();
        while (iterator.hasNext()){
            String id = iterator.next();
            Url tmp = urlService.getUrlById(id);
            if (tmp == null){
                User user = userService.getUser(username);
                if (user.deleteUserId(id)==1)
                    userService.updateUser(user);
            }
            else {
                map.put(id, tmp.getUrl());
            }
        }
        return ResponseEntity.accepted().body(map);
    }

    @PostMapping("/customUrl")
    public ResponseEntity<Object> customUrl(@RequestBody Map<String, Object> payload){
        HashMap<String,String> map = new HashMap<>();
        String username = (String)payload.get("username");
        String string_url = (String)payload.get("url");
        String custom_id = (String)payload.get("custom_id");
        Url tmp = new Url(custom_id,string_url);
        int result = urlService.addUrl(tmp);
        if (custom_id.length()>8){
            map.put("cause","url length exceeded");
            return ResponseEntity.badRequest().body(map);
        }
        if (result == 1){
        userService.addToUsersLink(username,tmp.getId());
        map.put("id",tmp.getId());
        return ResponseEntity.accepted().body(map);
        }
        else return ResponseEntity.badRequest().body("");
    }

}
