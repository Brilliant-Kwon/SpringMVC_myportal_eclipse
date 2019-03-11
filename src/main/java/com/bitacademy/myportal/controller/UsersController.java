package com.bitacademy.myportal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.myportal.service.UserService;
import com.bitacademy.myportal.vo.UserVo;


@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userServiceImpl;

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join() {
        return "users/joinform";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinAction(@ModelAttribute UserVo vo) {
        // TODO: 2019-03-11 가입처리
        // TODO: 2019-03-11 성공하면 /users/joinsuccess로 리다이렉트 / 실패 시 /users/join (GET)으로 리다이렉트
        System.out.println("FORM:" + vo);
        boolean success = userServiceImpl.join(vo);
        System.out.println("가입 결과 : " + success);
        if (success)
            return "redirect:/users/joinsuccess";
        else
            return "redirect:/users/join";
    }

    @RequestMapping(value = "/joinsuccess")
    public String joinSuccess() {
        return "users/joinsuccess";
    }

    //로그인 관련
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginform() {
        return "users/loginform";
    }

//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginAction(@ModelAttribute UserVo vo) {
//        if (vo.getEmail() != null) {
//            if (vo.getPassword().equals("")) {
//                System.out.println("중복검사 시작");
//                System.out.println("FORM:" + vo);
//                System.out.println("이메일 : " + vo.getEmail());
//                UserVo vo1 = userServiceImpl.getUser(vo.getEmail());
//                System.out.println("아이디 중복검사 : " + vo1.toString());
//
//                return vo1.toString();
//            } else {
//                System.out.println("로그인 시작");
//                System.out.println("FORM:" + vo);
//                System.out.println("이메일 : " + vo.getEmail() + "비번 : " + vo.getPassword());
//                UserVo vo1 = userServiceImpl.getUser(vo.getEmail(), vo.getPassword());
//                System.out.println("검색된 아이디 : " + vo1.toString());
//                return "redirect:/";
////                return vo1.toString();
//            }
//        } else {
//            return "값이 둘 다 없습니다.";
//        }
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginAction(@RequestParam(value = "email", required = false) String email, @RequestParam(value = "password", required = false) String password,
                              HttpSession session) {
        //이메일, 패스워드가 전송되지 않았을 경우
        //users/login으로 리다이렉트
        if (email.length() == 0 || password.length() == 0) {
            System.err.println("email, password 입력 값이 없습니다.");
            return "redirect:/users/login";
        } else {
            System.out.println("로그인 시작");
            UserVo authUser = userServiceImpl.getUser(email, password);
            System.out.println(authUser.toString());
            //사용자가 있다면 session에 authUser 적재
            if (authUser != null) {
                System.out.println("유저 있음, 로그인 가능");
                session.setAttribute("authUser", authUser);
                return "redirect:/";
            } else {
                System.out.println("유저 없음");
                return "redirect:/users/login";
            }
        }

    }

    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        //로그인 정보 삭제
        session.removeAttribute("authUser");
        //세션 무효화
        session.invalidate();
        return "redirect:/";
    }

}

