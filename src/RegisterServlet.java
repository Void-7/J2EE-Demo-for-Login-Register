import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=utf-8");
        PrintWriter printer=response.getWriter();
//        String name = request.getParameter("userName");
        String id = request.getParameter("userId");
        String pw=request.getParameter("userPas");
        String pw2=request.getParameter("userPas2");
        boolean flag=false;
        if(id.equals("")){
            printer.write("<script language='javascript'>alert('注册失败！账号不能为空！');window.location.href='Register.jsp';</script>");
        }else if(pw.equals("")||pw2.equals("")){
            printer.write("<script language='javascript'>alert('注册失败！两次输入密码不能为空！');window.location.href='Register.jsp';</script>");
        }else if(pw.length()<6) {
            printer.write("<script language='javascript'>alert('注册失败！密码长度小于6！');window.location.href='Register.jsp';</script>");
        }else if(pw.length()>127){
            printer.write("<script language='javascript'>alert('注册失败！密码长度大于127！');window.location.href='Register.jsp';</script>");
        }else{
            if(pw.equals(pw2)){
                try{
                    Database db=new Database("root","root");
                    if(db.getUser(id)!=null){
                        printer.write("<script language='javascript'>alert('error:0，注册失败！该id已存在,请重试！');window.location.href='Register.jsp';</script>");
                    }else{
                        flag=true;
                        db.insert(id," ",pw);
                        printer.write("<script language='javascript'>alert('恭喜您，注册成功！');window.location.href='index.jsp';</script>");
                    }
                    db.close();
                }catch( SQLException e){
                    e.printStackTrace();
                    printer.write("<script language='javascript'>alert('error:1，注册失败！数据库异常。');window.location.href='Register.jsp';</script>");
                }catch(ClassNotFoundException e){
                    e.printStackTrace();
                    printer.write("<script language='javascript'>alert('error:2，注册失败！');window.location.href='Register.jsp';</script>");
                }
            }else{
                printer.write("<script language='javascript'>alert('两次密码输入不一致，请重试。');window.location.href='Register.jsp';</script>");
            }
        }
        HttpSession session=request.getSession();
        if(!flag) session.setAttribute("id",id);//一旦注册失败就将id放入session
        else session.removeAttribute("id");//注册成功就删除该信息

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}

