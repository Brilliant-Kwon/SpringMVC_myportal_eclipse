package com.bitacademy.myportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.service.GuestbookService;
import com.bitacademy.myportal.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
    GuestbookService guestbookServiceImpl;

//  @ResponseBody
  @RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
  public String list(Model model) {
      List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
      model.addAttribute("list", list);

      return "guestbook/list";
//      return list.toString();
  }


  @RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
  public String deleteform(@PathVariable("no") Long no, Model model) {
      System.out.println("패스 변수 : "+no);
      model.addAttribute("no", no);
      return "guestbook/deleteform";
  }
  
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public String deleteAction(@ModelAttribute GuestbookVo vo) {
      System.out.println("FORM:"+vo);
      boolean success = guestbookServiceImpl.deleteMessage(vo);
      System.out.println("방명록 삭제 결과 : " + success);
      return "redirect:/guestbook";
  }

  @RequestMapping(value = "/write", method = RequestMethod.POST)
  public String write(@ModelAttribute GuestbookVo vo) {
      //서비스의 writeMessage
      System.out.println("FORM:" + vo);
      boolean success = guestbookServiceImpl.writeMessage(vo);
      System.out.println("방명록 작성 결과 : " + success);
      return "redirect:/guestbook";
  }
}

