package com.bitacademy.myportal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal.service.BoardService;
import com.bitacademy.myportal.vo.BoardVo;
import com.bitacademy.myportal.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardServiceImpl;

    //리스트 페이지
    @RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        List<BoardVo> list = boardServiceImpl.getList();
        System.out.println(list.toString());

        model.addAttribute("list", list);

        return "board/list";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writeform() {
        return "board/write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String writeAction(@ModelAttribute BoardVo vo, HttpSession session) {
        //만약에 세션에 authUser라고 설정된 UserVo가 없다면
        // 로그인 안한 상태 -> 로그인 폼으로 리다이렉트
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        System.out.println(authUser.toString());
        if (authUser == null) {
            System.err.println("로그인 사용자 아님!");
            return "redirect:/users/login";
        } else {
            vo.setUser_no(authUser.getNo());
            boolean success = boardServiceImpl.write(vo);
            System.out.println("글쓰기 성공 유무 : " + success);
            return "redirect:/board/list";
        }
    }

    @RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
    public String delete(@PathVariable("no") Long no) {
        BoardVo vo = new BoardVo();
        vo.setNo(no);
        boolean deleteResult = boardServiceImpl.delete(vo);
        System.out.println("삭제 결과 : " + deleteResult);

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/view/{no}", method = RequestMethod.GET)
    public String view(@PathVariable("no") Long no, Model model) {
        BoardVo vo = new BoardVo();
        vo.setNo(no);
        BoardVo result = boardServiceImpl.view(vo);
        System.out.println(result.toString());

        model.addAttribute("vo", result);

        return "board/view";
    }

    @RequestMapping(value = "/modify/{no}", method = RequestMethod.GET)
    public String modifyform(@PathVariable("no") Long no, Model model) {
        BoardVo vo = new BoardVo();
        vo.setNo(no);
        BoardVo result = boardServiceImpl.view(vo);
        System.out.println(result.toString());

        model.addAttribute("vo", result);

        return "board/modify";
    }

    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ModelAndView modifyAction(@ModelAttribute BoardVo vo) {
        System.out.println("수정 시작, 넘어온 vo : " + vo.toString());
        boolean success = boardServiceImpl.modify(vo);
        System.out.println("수정 결과 : " + success);

        ModelAndView mav = new ModelAndView("redirect:/board/list");
        mav.addObject(success);

        return mav;
    }
}
