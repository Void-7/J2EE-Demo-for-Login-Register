import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setHeader("content-type","text/html;charset:utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("userId");
        String pw=request.getParameter("userPas");
        System.out.println(id+" "+pw);//print id pw

        //获取Session对象
        HttpSession session=request.getSession();
        session.removeAttribute("id");

        try {
            Database db=new Database("root","root");
            Userdata userdata = db.check(id,pw);
            PrintWriter printer=response.getWriter();
            db.close();
            if(userdata==null){
                printer.write("<script language='javascript'>alert('账号不存在或密码错误，请重试');window.location.href='index.jsp'</script>");
            }else{
                printer.write("<script language='javascript'>alert('登录成功，欢迎您');window.location.href='Info.jsp';</script>");
                //将属性写入Session域
                //session.setAttribute("userName",userdata.getUserName());
                session.setAttribute("userId",id);
                session.setAttribute("userPas",pw);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
