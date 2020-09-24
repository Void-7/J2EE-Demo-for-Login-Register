import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection connection=null;
    public Database(String name,String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL&allowMultiQueries=true&useSSL=false&allowPublicKeyRetrieval=true",name,password);

    }
    public void insert(String userId,String userName,String userPas) throws SQLException {
        PreparedStatement prep=connection.prepareStatement("INSERT INTO userdata values (?,?,?)");
        prep.setString(1,userId);
        prep.setString(2,userName);
        prep.setString(3,userPas);
        prep.executeUpdate();
    }
    public void delete(String userId) throws SQLException {
        PreparedStatement prep=connection.prepareStatement("delete from userdata where USER_ID=?");
        prep.setString(1,userId);
        prep.executeQuery();
    }
    public Userdata getUser(String userId) throws SQLException {
        PreparedStatement prep=connection.prepareStatement("select * from userdata where USER_ID=?");
        prep.setString(1,userId);
        prep.executeQuery();
        ResultSet r=prep.getResultSet();
        if(r.next()){
            String name = r.getString("user_name");
            String id = r.getString("user_id");
            String pas = r.getString("user_pas");
            return new Userdata(name,id,pas);
        }
        else{
            return null;
        }
    }
    public ArrayList<Userdata> getAllUser()throws SQLException {
        ArrayList<Userdata> userList = new ArrayList<Userdata>();
        PreparedStatement prep=connection.prepareStatement("select * from userdata");
        prep.executeQuery();
        ResultSet r=prep.getResultSet();
        while(r.next()){
            String name = r.getString("user_name");
            String id = r.getString("user_id");
            String pas = r.getString("user_pas");
            userList.add(new Userdata(id,name,pas));
        }
        return userList;
    }
    public void close() throws SQLException {
        connection.close();
    }
    public Userdata check(String userId,String userPas) throws SQLException {
        PreparedStatement prep=connection.prepareStatement("select  userdata.user_pas from userdata where user_id=?");
        prep.setString(1,userId);
        System.out.println("check(): "+userId+" "+userId);//print id pw
        prep.executeQuery();
        ResultSet r=prep.getResultSet();
        if(r.next()){
            String pas = r.getString("user_pas");
            if(userPas.equals(pas)){
                return getUser(userId);
            }else return null;
        }
        else return null;
    }

    public static  void main(String[]args) throws SQLException, ClassNotFoundException {
        Database db=new Database("root","root");
        System.out.println(db.connection);
        ArrayList<Userdata> userList = db.getAllUser();
        for(Userdata x:userList){
            System.out.println(x.getUserId()+" "+x.getUserName()+" "+x.getUserPas());
        }
//
//        Userdata userdata = db.check("161800002","breakingbad");
//        if(userdata==null)  System.out.println("User id doesnt exist or wrong password");
//        else System.out.println("Welcome "+userdata.getUserName()+"!");
//        db.close();
//        Userdata userdata=db.getUser("091801329");
//        System.out.println(userdata.getUserName());
    }
}
