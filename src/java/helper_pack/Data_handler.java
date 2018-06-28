/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper_pack;
import java.sql.*;
/**
 *
 * @author Indranil
 */
public class Data_handler 
{
      Connection connection=null;
      PreparedStatement preparedStatement=null;
      ResultSet rs=null;
      String URL="jdbc:mysql://localhost:3306/peer_assessment";
      String user="root",password="";
      

    public Data_handler() {
        try{
            String URL="jdbc:mysql://localhost:3306/peer_assessment";
                String user="root",password="";
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection(URL,user,password);
            System.out.println("Conn!");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public Data_handler(String username) 
    {
        try {
                            connection=DriverManager.getConnection(URL,user,password);
                        System.out.println("Connection Established !");
                        /*int user_id=get_userid(user_name);
                        out.print("user_id : "+user_id);*/
                         preparedStatement=connection.prepareStatement("SELECT DISTINCT course_id from student_courseenrollment"); //where user_id=?);
                         //ps.setInt(1, user_id);
                         rs=preparedStatement.executeQuery();
                         /*numberof_courses=0;
                         while(rs.next())
                                numberof_courses++;*/
                    } 
                         catch (Exception e) 
                        {
                            e.printStackTrace();
                        }
    }
    public ResultSet get_all_studentData()
    {
        try {
        preparedStatement=connection.prepareStatement("Select * from student_data");
        rs=preparedStatement.executeQuery();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet get_courses()
                {
                    ResultSet resultSet=null;
                    try {
                            resultSet=preparedStatement.executeQuery();
                        } catch (Exception e) {
                        }
                    return resultSet;
                }
                public int get_userid(String username)
                {
                    int user_id=0;
                    try {
                           preparedStatement=connection.prepareStatement("Select user_id from student_data where username='"+username+"'");
                           ResultSet rs=preparedStatement.executeQuery();
                           rs.next();
                           user_id=rs.getInt("user_id");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    return user_id;
                }
      
                
                public int register_Student(String usernameString,String firString,String lasString,String passwoString,String emailString)
                {
                    int f=0;
                    try{
                        preparedStatement=connection.prepareStatement("INSERT INTO student_data(username,first_name,last_name,email,password) VALUES (?,?,?,?,?)");
                        preparedStatement.setString(1, usernameString);
                        preparedStatement.setString(2, firString);
                        preparedStatement.setString(3, lasString);
                        preparedStatement.setString(4, emailString);
                        preparedStatement.setString(5, passwoString);
                        f=preparedStatement.executeUpdate();
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                    return f;
                }
      
      
}
