package com.web;

import com.pojo.Student;
import com.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private StudentService stu = new StudentService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //System.out.println(name+" "+password );
        String remember = request.getParameter("remember");
        Student student = stu.login(name, password);
        //System.out.println(student);
        if(student != null){
            //登录成功
            //记录
            if("1".equals(remember)) {
                Cookie c_name = new Cookie("name", name);
                Cookie c_password = new Cookie("password", password);
                //设置存活时间
                c_name.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);
                //2. 发送
                response.addCookie(c_name);
                response.addCookie(c_password);
            }
                HttpSession session = request.getSession();
                session.setAttribute("student",student);

                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath+"/selectAllServlet");

        }
        else {
            //失败
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
