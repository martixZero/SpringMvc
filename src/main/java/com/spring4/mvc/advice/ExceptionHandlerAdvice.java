package com.spring4.mvc.advice;/**
 * Created by user on 16/10/6.
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * controllerAdvice
 *
 * @author user
 * @create 2016 -10-06 下午1:02
 */

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView=new ModelAndView("error");

        modelAndView.addObject("errorMessage",exception.getMessage());

        System.out.println(exception.getMessage());

        return modelAndView;

    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","other messages");
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");


    }
}
