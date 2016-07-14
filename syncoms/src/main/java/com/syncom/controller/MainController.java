package com.syncom.controller;

import com.syncom.request.RequestObject;
import com.syncom.response.SuccessResponse;
import com.syncom.services.PersistentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    PersistentService persistentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getHome() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse postData(@RequestBody RequestObject requestObject) {
        System.out.println(requestObject);
        persistentService.saveToFile(requestObject);
        return new SuccessResponse();
    }
}
