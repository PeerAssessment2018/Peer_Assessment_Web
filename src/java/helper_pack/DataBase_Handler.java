/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper_pack;

/**
 *
 * @author Indranil
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Collections;
import java.util.Collection;
import java.util.Locale;
import java.util.Random;

class author_temp {
    
    public static int author_id;
    public static String course_id;
    public static String question_id;
    public static int no_assessor;
    public static int no_assessments;
    public static int fb=0;
    public static int flag=0;  //going from cms3 to cms2
}


public class DataBase_Handler 
{
    Connection conn;
    
    public DataBase_Handler()
    {   
        conn = null;
         try{
            Properties conn_prop=new Properties();
            conn_prop.put("user", "root");
            conn_prop.put("password", "");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/peer_assessment",conn_prop);
            System.out.println("Connection established !!");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
          /*try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/pa_tool?autoReconnect=true&useSSL=false","adminpa","adminadmin");
            System.out.println("Connection established !!");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }*/
    }
    public boolean insert_student_data_handler(String username,String first_name,String last_name,String email,String password,String course_id)
    {
        boolean f=false;
        f=insert_student_data(username, first_name, last_name, email, password);
        
        try{
            String sql ="SELECT id FROM student_data WHERE username="+"'"+username+"';";//+ " AND "+"'"+first_name+"'"+","+"'"+last_name+"'"+","+"'"+email+"'"+","+"'"+password+"'"+");";
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            
            int id=rs.getInt("id");
            
            sql ="INSERT INTO student_courseenrollment(user_id,course_id) VALUES ("+id+ ","+"'"+course_id+"');";//+","+"'"+last_name+"'"+","+"'"+email+"'"+","+"'"+password+"'"+");";
            stmt = conn.createStatement();
            f=stmt.execute(sql);   
        
            int n = 0;
            boolean i=false;
            while(!i)
            {
                Random rand=new Random();
                n=rand.nextInt(999999)+100;
                
                sql="SELECT anonymous_user_id FROM student_anonymoususerid";
                stmt = conn.createStatement();
                rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    if(rs.getInt("anonymous_user_id")==n)
                        i=true;
                }
                if(i==true)
                    i=false;
                else
                    i=true;
            }
            
            sql ="SELECT id FROM student_data WHERE username="+"'"+username+"';";
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            rs.next();
            
            sql ="INSERT INTO student_anonymoususerid(user_id,anonymous_user_id,course_id) VALUES (" + id + "," + n + ",'"+course_id+"')";
            stmt = conn.createStatement();
            f=stmt.execute(sql);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return f;
    }
    
    public boolean insert_student_data(String username,String first_name,String last_name,String email,String password)
    {
        boolean f=false;
        try{
            String sql ="INSERT INTO student_data(username,first_name,last_name,email,password) VALUES ("+"'"+username+"'"+ ","+"'"+first_name+"'"+","+"'"+last_name+"'"+","+"'"+email+"'"+","+"'"+password+"'"+");";
            Statement stmt = conn.createStatement();
            f=stmt.execute(sql);
            
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return f;
    }
    
    public boolean insert_faculty_data_handler(String username,String first_name,String last_name,String email,String password,String course_id)
    {
        boolean f=false;
       // f=insert_faculty_data(username, first_name, last_name, email, password);
        try{
            String sql ="SELECT id FROM author_data WHERE username="+"'"+username+"';";//+ " AND "+"'"+first_name+"'"+","+"'"+last_name+"'"+","+"'"+email+"'"+","+"'"+password+"'"+");";
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            
            int id=rs.getInt("id");
            
            sql ="INSERT INTO author_coursecreated(author_id,course_id) VALUES ("+id+ ","+"'"+course_id+"');";//+","+"'"+last_name+"'"+","+"'"+email+"'"+","+"'"+password+"'"+");";
            stmt = conn.createStatement();
            f=stmt.execute(sql);   
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return f;
    }
    
    public boolean insert_faculty_data(String username,String first_name,String last_name,String email,String password)
    {
        boolean f=false;
        try{
            String sql ="INSERT INTO author_data(username,first_name,last_name,email,password) VALUES ("+"'"+username+"'"+ ","+"'"+first_name+"'"+","+"'"+last_name+"'"+","+"'"+email+"'"+","+"'"+password+"'"+");";
            Statement stmt = conn.createStatement();
            f=stmt.execute(sql);   
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return f;
    }
    
    public ArrayList get_Answers()
    {
            ArrayList arr=new ArrayList();
            String sql="SELECT (user_id,state) FROM courseware_studentmodule;";
            try 
            {
            Statement statem=conn.createStatement();
            ResultSet rs=statem.executeQuery(sql);
            while(rs.next())
            {
                ArrayList arr2=new ArrayList();
                arr2.add(rs.getString("user_id"));
                arr2.add(rs.getString("state"));
                arr.add(arr2);
            }
            } 
            catch (Exception ex) 
            {
            //System.out.println(ex.getMessage());
            }
            return arr;
    }
    
    public boolean insert_question_details_1(String course_id, String question_id,int x,int y)
    {
        boolean f=false;
        try 
        {
            String sql = "INSERT INTO question_details(course_id,question_id,no_assessors,no_assessment) VALUES ("+"'"+course_id+"'"+ ","+"'"+question_id+"'"+","+x+","+y+ ");";
            Statement stmt = conn.createStatement();
            f=stmt.execute(sql);
        } 
        catch (Exception ex)
        {
             System.out.println(ex.getMessage());
	}
        return f;
    }
    
    public int count_no_of_students()
    {
        try 
        {
            String sql = " SELECT COUNT(*) FROM student_data ";
            Statement stmt = conn.createStatement();
            //stmt.execute(sql);
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            int rc=rs.getInt(1);
            System.out.println(rc);
            return rc;
        } 
        catch (Exception ex)
        {
             System.out.println(ex.getMessage());
             return 0;
	}
    }
    
    public int insert_student_answer(int user_id,String course_id, String question_id,String prompt)
    {
        int f=0;
        try 
        {
            String sql = "INSERT INTO courseware_studentmodule (user_id,course_id,question_id,state) VALUES ("+user_id+","+"'"+course_id+"'"+ ","+"'"+question_id+"'"+","+"'"+prompt+"'"+ ");";
            Statement stmt = conn.createStatement();
            f=(stmt.execute(sql)==true)?1:0;
        } 
        catch (Exception ex)
        {
             System.out.println(ex.getMessage());
	}   
        return f;
    }
    
    public void insert_question_details_2(String cri_name, String cri_prompt,int nop,int fb)
    {		
        
                try {
			String insertString =" INSERT INTO question_details (course"
                       + "_id, question_id, no_assessors, no_assessment,criterion_id, criterion_prompt, no_of_options, feedback) VALUES ('"+author_temp.course_id+
                       "' , '"+author_temp.question_id+"' , "+author_temp.no_assessor+", "+author_temp.no_assessments+", '"+cri_name+"' , '"+cri_prompt+"' , "+nop+","+fb+");";
                Statement stmt = conn.createStatement();
                stmt.execute(insertString);
                
                } catch (Exception e) {
			System.out.println("ERROR: Could not insert record" + e);
			return;
		}
    }
    
    public int response_submitted(int user_id, String course)
    {
        try
            {
               String sql =  "SELECT user_id,submitted FROM courseware_studentmodule WHERE user_id = "+user_id + " AND course_id = '" + course+"'";
               Statement stmt = conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                rs.next();
                if(rs.getInt("submitted")==0)
                    return 0;
                else if(rs.getInt("submitted")==1)
                    return 1;
            }catch(SQLException e){
                System.out.println(e);
            } 
        return 2;
    }
    
public int insert_courseware_studentmodule(int user_id,String ans,String question_id, String course,int submitted)
        {   
            int f=0;
           
            java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
            
            //if(response_submitted(user_id,question_id,course)==2)   
            {try {
			String insertString = " INSERT INTO courseware_studentmodule ( user_id, course_id, question_id, state,date_of_submission, submitted )" +" VALUES ( " +
                                +user_id+" , '"+course+"' , '"+ question_id+"' , '" +ans+"','"+ sqlDate  +"', " + submitted +" ) ";
			Statement stmt = conn.createStatement();
                stmt.execute(insertString);
                f=1;
               } catch (Exception e) {
			System.out.println("ERROR: Could not insert record"+e);
			
		}
            return f;
            }
            
            /*else if((response_submitted(user_id,question_id,course)==0))
            {
                try{
                String sql = "UPDATE courseware_studentmodule SET state = '" + ans + "',submitted = "+submitted+" WHERE user_id = "+user_id + " AND state = '" + ans + "' AND course_id = '" + course+ "' AND question_id = '" + question_id +"'";
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
                }catch(SQLException e)
                {
                    System.out.println(e);
                }
            }*/
        }
    public void insert_options_details_1(String ques_id, String course_id,String cri_id,String op_id,String op_desc,int scale)
    {		
                try {
			String insertString=" INSERT INTO option_details " + " ( " + " course_id, " + " question_id, " +
					" criterion_id, " + " option_id, " + " option_description, " + " option_points " + " ) " + " VALUES "  + " (" + "'" +course_id + "'" + ","
					+ "'" +ques_id + "'" + ","+ "'" +cri_id + "'" + ", '"+op_id + "' ," + "'" +op_desc + "'," +scale + ")";
		Statement stmt = conn.createStatement();
                stmt.execute(insertString);
                } catch (Exception e) {
			System.out.println(e);
			return;
		}
    }
    
     /*public void insert_pa_grade_postshuffle(int user_id, int assesser_id , String course_id, String question_id )
    {
        //Convert arr from user_id list to anonymous_user_id from the student_anonymoususerid table
        
        
            ArrayList<String> criterias = new ArrayList<String>();
        
            try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT anonymous_user_id FROM student_anonymoususerid WHERE user_id = " + assesser_id ;
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                    assesser_id = rs.getInt("anonymous_user_id");
                else
                    System.out.println("no results");
                System.out.println(assesser_id);
                } catch (Exception e) {
		System.out.println("ERROR: Could not fetch record");
		return;
            }
       
        
        //Fetch the criteris ids from question id and course_id which are common to different criteria ids in question_details table
        
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT criterion_id FROM question_details WHERE course_id= '" + course_id + "' AND question_id = '" + question_id +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                    criterias.add(rs.getString("criterion_id"));
                } catch (Exception e) {
		System.out.println("ERROR: Could not fetch record");
		return;
            }
        
        //for(int i=0; i<criterias.size();i++)
         //   System.out.println(criterias.get(i));//
        
        
        //for each criteria give seperate entry in the pa_grade table
        //Duplicate the above entries for different ids from ArrayList
        
        
        
            for(int j=0;j<criterias.size();j++)
            {
                try {
			String sql=" INSERT INTO pa_grade ( user_id, anonymous_assesser_id, course_id, question_id, criteria_id, grade_points) VALUES "  + " (" + user_id + ","
					+ assesser_id + ","+ "'" + course_id + "'" + ", '" + question_id + "' ," + "'" + criterias.get(j) + "'," + 0 +")";
		Statement stmt = conn.createStatement();
                stmt.execute(sql);
                } catch (SQLException e) {
			System.out.println(e);
			return;
		}
            }
        
    }
    */
    
    public int anonymous_to_user(int auid)
    {
        int uid=0;
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT user_id FROM student_anonymoususerid WHERE anonymous_user_id = " + auid ;
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                    uid = rs.getInt("user_id");
                else
                    System.out.println("no results");
                System.out.println(uid);
                } catch (Exception e) {
		System.out.println("ERROR: Could not fetch record");
            }
        return uid;
    }
    
    public int user_to_anonymous(int uid)
    {
        int auid=0;
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT anonymous_user_id FROM student_anonymoususerid WHERE user_id = " + uid ;
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                    auid = rs.getInt("anonymous_user_id");
                else
                    System.out.println("no results");
                } catch (Exception e) {
		System.out.println("ERROR: Could not fetch record");
            }
        return auid;
    }
    
    /*public void lms3_f( int user_id, String course_id,String question_id )
    {
              
        ArrayList<String> criterias = new ArrayList<String>();
        
        try {
                //int x = 10;
                //System.out.println(x);
                System.out.println("quest - " + question_id);
                String sql=" SELECT criterion_id FROM question_details WHERE course_id = '" + course_id + "'AND question_id = '" + question_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    criterias.add(rs.getString("criterion_id"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
       System.out.println("cri - " + criterias);
       
      // lms3.cb3.removeAllItems();
        
        for(int i=0;i<criterias.size();i++)
        {
        //    lms3 frame=new lms3();
            cms3 frame1=new cms3();
          //  if(frame.isVisible()==true)
            //lms3.cb3.addItem(criterias.get(i));
            if(frame1.isVisible()==true)
            cms3.cb2.addItem(criterias.get(i));
        }
     
    }*/
    
    public ArrayList<String> r_lms3_f(int user_id, String course_id,String question_id )
    {
              
        ArrayList<String> criterias = new ArrayList<String>();
        
        try {
                //int x = 10;
                //System.out.println(x);
                System.out.println("quest - " + question_id);
                String sql=" SELECT criterion_id FROM question_details WHERE course_id = '" + course_id + "'AND question_id = '" + question_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    criterias.add(rs.getString("criterion_id"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
       System.out.println("cri - " + criterias);
       
       return criterias;
    }
    
  /*  public void lms3_f1( int user_id, String course_id,String question_id )
    {
             
        ArrayList<String> criterias = new ArrayList<String>();
        
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT criterion_id FROM question_details WHERE course_id = '" + course_id + "'AND question_id = '" + question_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    criterias.add(rs.getString("criterion_id"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
        ArrayList<String> options = new ArrayList<String>();
        ArrayList<String> options_description = new ArrayList<String>();
        ArrayList<Integer> options_points = new ArrayList<Integer>();
        
//        String selected_criteria = (String)lms3.cb3.getSelectedItem();
        
        //String selected_criteria = "cked";
        
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT option_id,option_description,option_points FROM option_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id + "' AND criterion_id = '" + selected_criteria +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    options.add(rs.getString("option_id"));
                    options_description.add(rs.getString("option_description"));
                    options_points.add(rs.getInt("option_points"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
        System.out.println(options.size());
        System.out.println(options);
        lms3 f=new lms3();
        lms4 f1=new lms4();
        if(f.isVisible()==true)
        {
        if(options.size()==1)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
        }
        else if(options.size()==2)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
        }
        else if(options.size()==3)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
            lms3.rd3.setVisible(true);
            lms3.rd3.setText(options.get(2));
        }
        else if(options.size()==4)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
            lms3.rd3.setVisible(true);
            lms3.rd3.setText(options.get(2));
            lms3.rd4.setVisible(true);
            lms3.rd4.setText(options.get(3));
        }
        else if(options.size()==5)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
            lms3.rd3.setVisible(true);
            lms3.rd3.setText(options.get(2));
            lms3.rd4.setVisible(true);
            lms3.rd4.setText(options.get(3));
            lms3.rd5.setVisible(true);
            lms3.rd5.setText(options.get(4));
        }
        }
        if(f1.isVisible()==true)
        {
            if(options.size()==1)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
        }
        else if(options.size()==2)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
        }
        else if(options.size()==3)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
            lms4.rd3.setVisible(true);
            lms4.rd3.setText(options.get(2));
        }
        else if(options.size()==4)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
            lms4.rd3.setVisible(true);
            lms4.rd3.setText(options.get(2));
            lms4.rd4.setVisible(true);
            lms4.rd4.setText(options.get(3));
        }
        else if(options.size()==5)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
            lms4.rd3.setVisible(true);
            lms4.rd3.setText(options.get(2));
            lms4.rd4.setVisible(true);
            lms4.rd4.setText(options.get(3));
            lms4.rd5.setVisible(true);
            lms4.rd5.setText(options.get(4));
        }
        }
        //System.out.println(options_points);
    }
    */
    
  public ArrayList<String> r_lms3_f1( int user_id, String course_id,String question_id,String criteria)
    {
             
        ArrayList<String> options = new ArrayList<String>();
        ArrayList<String> options_description = new ArrayList<String>();
        ArrayList<Integer> options_points = new ArrayList<Integer>();
                
        
        
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT option_id,option_description,option_points FROM option_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id + "' AND criterion_id = '" + criteria +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    options.add(rs.getString("option_id"));
                    options_description.add(rs.getString("option_description"));
                    options_points.add(rs.getInt("option_points"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
        //System.out.println(options.size());
        //System.out.println(options);
        
        return options;
    }
        /*
        lms3 f=new lms3();
        lms4 f1=new lms4();
        if(f.isVisible()==true)
        {
        if(options.size()==1)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
        }
        else if(options.size()==2)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
        }
        else if(options.size()==3)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
            lms3.rd3.setVisible(true);
            lms3.rd3.setText(options.get(2));
        }
        else if(options.size()==4)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
            lms3.rd3.setVisible(true);
            lms3.rd3.setText(options.get(2));
            lms3.rd4.setVisible(true);
            lms3.rd4.setText(options.get(3));
        }
        else if(options.size()==5)
        {
            lms3.rd1.setVisible(true);
            lms3.rd1.setText(options.get(0));
            lms3.rd2.setVisible(true);
            lms3.rd2.setText(options.get(1));
            lms3.rd3.setVisible(true);
            lms3.rd3.setText(options.get(2));
            lms3.rd4.setVisible(true);
            lms3.rd4.setText(options.get(3));
            lms3.rd5.setVisible(true);
            lms3.rd5.setText(options.get(4));
        }
        }
        if(f1.isVisible()==true)
        {
            if(options.size()==1)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
        }
        else if(options.size()==2)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
        }
        else if(options.size()==3)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
            lms4.rd3.setVisible(true);
            lms4.rd3.setText(options.get(2));
        }
        else if(options.size()==4)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
            lms4.rd3.setVisible(true);
            lms4.rd3.setText(options.get(2));
            lms4.rd4.setVisible(true);
            lms4.rd4.setText(options.get(3));
        }
        else if(options.size()==5)
        {
            lms4.rd1.setVisible(true);
            lms4.rd1.setText(options.get(0));
            lms4.rd2.setVisible(true);
            lms4.rd2.setText(options.get(1));
            lms4.rd3.setVisible(true);
            lms4.rd3.setText(options.get(2));
            lms4.rd4.setVisible(true);
            lms4.rd4.setText(options.get(3));
            lms4.rd5.setVisible(true);
            lms4.rd5.setText(options.get(4));
        }
        }
        System.out.println(options_points);
    }
    */
   /* public ArrayList<String> r2_lms3_f1( int user_id, String course_id,String question_id , String criteria )
    {
       
        ArrayList<String> options = new ArrayList<String>();
        ArrayList<String> options_description = new ArrayList<String>();
        ArrayList<Integer> options_points = new ArrayList<Integer>();
        
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT option_id,option_description,option_points FROM option_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id + "' AND criterion_id = '" + criteria +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    options.add(rs.getString("option_id"));
                    options_description.add(rs.getString("option_description"));
                    options_points.add(rs.getInt("option_points"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
        //System.out.println(options.size());
        //System.out.println(options);
        
        return options_description;
    }
    
        
    public ArrayList<Integer> r3_lms3_f1( int user_id, String course_id,String question_id , String criteria )
    {
       
        ArrayList<String> options = new ArrayList<String>();
        ArrayList<String> options_description = new ArrayList<String>();
        ArrayList<Integer> options_points = new ArrayList<Integer>();
        
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT option_id,option_description,option_points FROM option_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id + "' AND criterion_id = '" + criteria +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    options.add(rs.getString("option_id"));
                    options_description.add(rs.getString("option_description"));
                    options_points.add(rs.getInt("option_points"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
        //System.out.println(options.size());
        //System.out.println(options);
        
        return options_points;
    }
    
    public void lms3_f2( int user_id, String course_id,String question_id )
    {
        //int a_user_id = user_to_anonymous(user_id);
        //System.out.println(a_user_id);
        /*<Integer> ids_to_assess = new ArrayList<Integer>();
        
            try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT user_id FROM pa_grade WHERE anonymous_assesser_id = " + a_user_id ;
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    int temp = rs.getInt("user_id");
                    if(!ids_to_assess.contains(temp))
                        ids_to_assess.add(temp);
                }
                //System.out.println(ids_to_assess);
                } catch (Exception e) {
		System.out.println(e);
            }
        
        ArrayList<Integer> a_user_ids=new ArrayList<Integer>();
        for(int i=0;i<ids_to_assess.size();i++)
        {
            a_user_ids.add(user_to_anonymous(ids_to_assess.get(i)));
        }
       ArrayList<String> responses = new ArrayList<String>();
            
        for (int i = 0 ; i<ids_to_assess.size() ; i++ )
        {
            try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT state FROM courseware_studentmodule WHERE user_id = '" + ids_to_assess.get(i)+ "' AND course_id = '" + course_id + "'AND question_id = '" + question_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    responses.add(rs.getString("state"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }    
        }
        lms3 f=new lms3();
        lms4 f1=new lms4();
        
        String s=(String)lms3.cb2.getSelectedItem();
        int j=0;
        int uid=Integer.parseInt(s);
        for(int i=0;i<a_user_ids.size();i++)
        {
            if(a_user_ids.get(i)==uid)
                j=i;
        }
        if(f.isVisible()==true)
            lms3.ta.setText(responses.get(j));
        if(f1.isVisible()==true)
            lms4.ta.setText(responses.get(j));
    }
    */
     public void results(int user_id, String course_id, String question_id)
    {
        int a=0,b=0,sas=0,pas=0;
        
        try {
                String sql=" SELECT no_assessors,no_assessment FROM question_details WHERE course_id = '" + course_id + "'AND question_id = '" + question_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    a=rs.getInt("no_assessors");
                    b=rs.getInt("no_assessment");
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        
        /*System.out.println(a);
        System.out.println(b);*/
        
        try {
                String sql=" SELECT self_assessed_grade FROM courseware_studentmodule WHERE user_id = " + user_id + " AND course_id = '" + course_id + "'AND question_id = '" + question_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    sas=rs.getInt("self_assessed_grade");
                }
                } catch (Exception e) {
		System.out.println(e);
            } 
        
        ArrayList<Integer> marks = new ArrayList<>();
        
         try {
                String sql=" SELECT AVG(grade_points) as avg_grade FROM pa_grade WHERE user_id = " + user_id + " AND course_id = '" + course_id + "'AND question_id = '" + question_id + "' GROUP BY anonymous_assessor_id HAVING count(*)>1";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    marks.add(rs.getInt("avg_grade"));
                }
                } catch (Exception e) {
		System.out.println(e);
            } 
        
        Collections.sort(marks);
        pas = (marks.get(marks.size()/2-1)+marks.get(marks.size()/2))/2;
        System.out.println(pas);
    }
     
    public void insert_pa_grade(int user_id,int assessor_id,String course, String q_id, ArrayList<String> cri_id,ArrayList<Integer> points,ArrayList<String> feedback)
    {		
        for(int i =0 ; i<cri_id.size(); i++)
                {
                    System.out.println("in insert_pa_grade --> " + user_id +" "+ assessor_id +" "+ course + " "+q_id + " "+ cri_id +" "+ points);
                    try {
                        String insertString="INSERT INTO pa_grade (user_id, anonymous_assessor_id, course_id, question_id, criteria_id,"
                                    + " grade_points) VALUES ("+user_id+","+assessor_id+", '"+course+"' , '"+q_id+"','"+cri_id.get(i)+"' ,"+points.get(i)+")";
                    Statement stmt = conn.createStatement();
                    stmt.execute(insertString);
                    } catch (SQLException e) {
                            System.out.println("ERROR: Could not insert record in pa_grade" + e);
                            return;
                    }
                }
    }
    
    public ArrayList<String> courses_available()
    {
        ArrayList<String> courses = new ArrayList<String>();
        
        try {
                String sql=" SELECT course_id FROM author_coursecreated" ;
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    courses.add(rs.getString("course_id"));
                }
                } catch (Exception e) {
		System.out.println(e);
         }   
        return courses;
    }
    
    public ArrayList<String> courses_created(int author_id)
    {
        ArrayList<String> courses = new ArrayList<String>();
        
        try {
                String sql=" SELECT course_id FROM author_coursecreated WHERE author_id = " + author_id ;
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    courses.add(rs.getString("course_id"));
                }
                } catch (Exception e) {
		System.out.println(e);
         }
        return courses;     
    }
    
    public ArrayList<String> courses_enrolled(int user_id)
    {
        ArrayList<String> courses = new ArrayList<String>();
        
        try {
                String sql=" SELECT DISTINCT course_id FROM student_courseenrollment WHERE user_id = "+ user_id;
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    String s=rs.getString("course_id");
                    courses.add(s);
                }
                } catch (Exception e) {
		System.out.println(e+" error in course");
         }
        return courses;     
    }
    
    public int username_to_id(String username)
    {
        int user_id=0;
        
        try {
                String sql=" SELECT id FROM student_data WHERE username = '" + username +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    user_id=rs.getInt("id");
                }
                } catch (Exception e) {
		System.out.println("username not found ");
         }
        return user_id;     
    }
    
    public boolean check_valid_login_lms(String username,String password)
    {
        try {
            System.out.println("Connection Established !");
            String sql="SELECT COUNT(username) as count1 FROM student_data WHERE username='"+username+"' AND password='"+password+"';";
            Statement statement=conn.createStatement();
            ResultSet rs= statement.executeQuery(sql);
            rs.next();
            int f=rs.getInt("count1");
            if(f>0)
                return true;
        } catch (Exception e) 
        {
            System.out.println("Error Login  !"+e.getMessage());
        }
        return false;
    }
    
    public boolean check_valid_login_cms(String username,String password)
    {
        try {
            System.out.println("Connection Established !");
            String sql="SELECT COUNT(username) as count1 FROM author_data WHERE username='"+username+"' AND password='"+password+"';";
            Statement statement=conn.createStatement();
            ResultSet rs= statement.executeQuery(sql);
            rs.next();
            int f=rs.getInt("count1");
            if(f>0)
                return true;
        } catch (Exception e) 
        {
            System.out.println("Error Login  !"+e.getMessage());
        }
        return false;
    }
    
     public int username_to_aid(String username)
    {
        int user_id=0;
        
        try {
                String sql=" SELECT id FROM author_data WHERE username = '" + username +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    user_id=rs.getInt("id");
                }
                } catch (Exception e) {
		System.out.println("username not found ");
         }
        return user_id;     
    }
     
    public String course_question ( String course_id)
    {
        String ques = null;
        try{
            String sql = "SELECT question_id FROM question_details WHERE course_id = '" + course_id +"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                ques = rs.getString("question_id");
            }
        }catch(SQLException e)
                {
                  System.out.println(e); 
                }
        return ques;
    }
    
    public String response_for_id( int user_id, String course_id , String question_id)
    {
        String response = null;
        try{
            String sql = "SELECT state FROM courseware_studentmodule WHERE user_id=" +user_id + " AND course_id ='" + course_id +"' AND question_id = '" + question_id +"';";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            response = rs.getString("state");
                     
        }catch(SQLException e)
                {
                  System.out.println(e); 
                }
        return response;
    }
    
    public void set_no_of_sample_answers(int nosa, String course_id , String question_id)
    {
        try{
            String sql = "UPDATE question_details SET no_of_sample_answers = "+ nosa + " WHERE course_id = '" + course_id +"' AND question_id = '"+question_id +"'";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }catch(SQLException e)
                {
                  System.out.println(e); 
                }
    }
    
    public void set_sample_answer_details(int author_id, String course_id, String question_id, String sample_answer, String criteria, String correct_option )
    {
        try{
            String sql = "INSERT INTO sample_answer_details(author_id,course_id,question_id,sample_answer,criteria,correct_option) VALUES ("+author_id+",'"+course_id+"','"+question_id+"','"+sample_answer+"','"+criteria+"','"+correct_option+"')";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }catch(SQLException e)
                {
                  System.out.println(e); 
                }
    }
    
    public int get_no_assessed(int user_id)
    {
        int no_assessed=0;
        try {
            Statement statement=conn.createStatement();
            String sql="SELECT assessments_done FROM courseware_studentmodule WHERE user_id="+user_id+";";
            ResultSet rs=statement.executeQuery(sql);
            rs.next();
            no_assessed=rs.getInt("assessments_done");
        } catch (Exception e) 
        {
            System.out.println("err getting get_no_assessed !");
        }
        System.out.println("no_assessed:"+no_assessed);
        return no_assessed;
    }
    
    public int get_no_being_assessed(int user_id)
    {
        int no_being_assessed=0;
        try {
            Statement statement=conn.createStatement();
            String sql="SELECT times_assessed FROM courseware_studentmodule WHERE user_id="+user_id+";";
            ResultSet rs=statement.executeQuery(sql);
            rs.next();
            no_being_assessed=rs.getInt("times_assessed");
        } catch (Exception e) 
        {
            System.out.println("err getting get_no_assessed !");
        }
        System.out.println("no_being_assessed:"+no_being_assessed);
        return no_being_assessed;
    }
    
      
    public int get_no_assessments(String course_id,String question_id)
    {
        
        // returns the number of assesments *for* each student
               
        int no_assessor=0;
        try {
            Statement statement=conn.createStatement();
            ResultSet rs=statement.executeQuery("SELECT no_assessment FROM question_details WHERE course_id='"+course_id+"' AND question_id='"+question_id+"';");
            rs.next();
            no_assessor=rs.getInt("no_assessment");
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return no_assessor;
    }
    
    public int get_no_assessors(String course_id,String question_id)
    {
        //returns the number of assessments to be done *by* each student
        
        int no_assessor=0;
        try {
            Statement statement=conn.createStatement();
            ResultSet rs=statement.executeQuery("SELECT no_assessors FROM question_details WHERE course_id='"+course_id+"' AND question_id='"+question_id+"';");
            rs.next();
            no_assessor=rs.getInt("no_assessors");
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return no_assessor;
    }
    
    public boolean should_assess(int user_id)
    {
        boolean f=false;
        String course_id="15",question_id="15";
        
        if(get_no_assessed(user_id)<get_no_assessors(course_id,question_id))
            f=true;
        return f;
    }
    
    public String[] get_answer(int user_id, String course_id, String question_id)
    {
        
        // whenever called selects one suitable person to assess by the user_id , creates the entry in pa_grade table
        //Issue : has to be called multiple times to complete the peer assessment process for a particular user
        
        
        String str[]=new String[2];
          
        //boolean valid = false;
        
        //while(!valid)
        //{
        try {
            String sql;
            //System.out.println(get_no_assessed(user_id));
            if(get_no_assessed(user_id)==0)
            {
                System.out.println("first SQL"); 
                sql="SELECT * FROM courseware_studentmodule WHERE submitted = " +1 + " AND user_id!="+user_id+" AND times_assessed < " + get_no_assessments(course_id,question_id) + " AND course_id = '" +course_id +"' AND question_id = '" + question_id +"' ORDER BY date_of_submission ASC LIMIT 1;"; 
            }
            else
            {
                System.out.println("second SQL"); 
                sql="SELECT * FROM courseware_studentmodule WHERE submitted = " + 1 + " AND user_id!="+user_id+" AND times_assessed < " + get_no_assessments(course_id,question_id) + " AND course_id = '" +course_id +"' AND question_id = '" + question_id +"' AND user_id NOT IN (SELECT user_id FROM pa_grade WHERE anonymous_assessor_id = " + user_to_anonymous(user_id) +") ORDER BY date_of_submission ASC LIMIT 1;";
            }
            ResultSet rs=conn.createStatement().executeQuery(sql);
            rs.next();
            str[0]=rs.getString("state");
            str[1] = String.valueOf(rs.getInt("user_id"));
            /*ResultSet rs2 = conn.createStatement().executeQuery("SELECT COUNT(*) AS match FROM pa_grade WHERE user_id = " + Integer.parseInt(str[1]) + " AND anonymous_assesser_id= " + user_to_anonymous(user_id) + " ;");
            rs2.next();
            int t = rs.getInt("match");
            if(t==0)
                valid=true;
            */
            }catch (SQLException e) {
                System.out.println("Error getting answer !" + e);
            }
        
        //insert_pa_grade_postshuffle(Integer.parseInt(str[1]), user_id ,course_id, question_id );
        
        //}
        return str;    
    }
    
    public ArrayList<String> criteria(String course_id, String question_id)
    {
        ArrayList<String> criterias = new ArrayList<String>();
        
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT criterion_id FROM question_details WHERE course_id = '" + course_id + "'AND question_id = '" + question_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    criterias.add(rs.getString("criterion_id"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }  
        System.out.println(criterias);
        return criterias;
        
    }
    
   /* public void option(String cri_id,String course_id,String question_id)
    {
        ArrayList<String> options = new ArrayList<String>();
        ArrayList<String> options_description = new ArrayList<String>();
        ArrayList<Integer> options_points = new ArrayList<Integer>();
       
        try {
                //int x = 10;
                //System.out.println(x);
                String sql=" SELECT option_id,option_description,option_points FROM option_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id + "' AND criterion_id = '" + cri_id +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    options.add(rs.getString("option_id"));
                    options_description.add(rs.getString("option_description"));
                    options_points.add(rs.getInt("option_points"));
                }
                } catch (Exception e) {
		System.out.println(e);
            }   
        System.out.println(options.size());
        System.out.println(options);
        cms3 f=new cms3();
       // lms4 f1=new lms4();
        if(f.isVisible()==true)
        {
        if(options.size()==1)
        {
            cms3.rd1.setVisible(true);
            cms3.rd1.setText(options.get(0));
        }
        else if(options.size()==2)
        {
            cms3.rd1.setVisible(true);
            cms3.rd1.setText(options.get(0));
            cms3.rd2.setVisible(true);
            cms3.rd2.setText(options.get(1));
        }
        else if(options.size()==3)
        {
            cms3.rd1.setVisible(true);
            cms3.rd1.setText(options.get(0));
            cms3.rd2.setVisible(true);
            cms3.rd2.setText(options.get(1));
            cms3.rd3.setVisible(true);
            cms3.rd3.setText(options.get(2));
        }
        else if(options.size()==4)
        {
            cms3.rd1.setVisible(true);
            cms3.rd1.setText(options.get(0));
            cms3.rd2.setVisible(true);
            cms3.rd2.setText(options.get(1));
            cms3.rd3.setVisible(true);
            cms3.rd3.setText(options.get(2));
            cms3.rd4.setVisible(true);
            cms3.rd4.setText(options.get(3));
        }
        else if(options.size()==5)
        {
            cms3.rd1.setVisible(true);
            cms3.rd1.setText(options.get(0));
            cms3.rd2.setVisible(true);
            cms3.rd2.setText(options.get(1));
            cms3.rd3.setVisible(true);
            cms3.rd3.setText(options.get(2));
            cms3.rd4.setVisible(true);
            cms3.rd4.setText(options.get(3));
            cms3.rd5.setVisible(true);
            cms3.rd5.setText(options.get(4));
        }
        }
        
    }
    */
    public boolean check_PA(int user_id, String course_id , String question_id)
    {
        if(get_no_assessed(user_id) < get_no_assessors(course_id,question_id))
            return true;
        return false;
    }
     
    public void append_assessments_done(int user_id,String course_id, String question_id)
    {
        int a_d = 0;
        try {
                String sql=" SELECT assessments_done FROM courseware_studentmodule WHERE user_id = " + user_id + " AND course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                a_d=rs.getInt("assessments_done") + 1;
                
                String sql2="UPDATE courseware_studentmodule SET assessments_done = " + a_d + " WHERE user_id = " + user_id + " AND course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
		stmt=conn.createStatement();
                stmt.execute(sql2);
                } catch (SQLException e) {
		System.out.println(e);
            }   
    }
        
     public int assessments_done(int user_id,String course_id, String question_id)
    {
        int a_d = 0;
        
        try {
                String sql=" SELECT assessments_done FROM courseware_studentmodule WHERE user_id = " + user_id + " AND course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                a_d=rs.getInt("assessments_done");
               } catch (SQLException e) {
		System.out.println(e);
            }   
        return a_d;
    }
        
    public void append_times_assessed(int user_id,String course_id, String question_id)
    {
        int t_a = 0;
        try {
                String sql=" SELECT times_assessed FROM courseware_studentmodule WHERE user_id = " + user_id + " AND course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                t_a=rs.getInt("times_assessed") + 1;
                
                String sql2 = "UPDATE courseware_studentmodule SET times_assessed = " + t_a + " WHERE user_id = " + user_id + " AND course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
		stmt=conn.createStatement();
                stmt.execute(sql2);
                } catch (SQLException e) {
		System.out.println(e);
            }   
    }    
    
    public int max_points_for_criteria(String course_id, String question_id, String criterion_id)
    {
        int max = 0;
        
        try{
                String sql=" SELECT MAX(option_points) AS max_points FROM option_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id +"' AND criterion_id = '"+ criterion_id + "'";
		Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                    max=rs.getInt("max_points");
            
        }catch(SQLException e){
            System.out.println(e);
        }
         System.out.println(max);
      return max;  
    }
    
    public void insert_self_grade(int user_id, String course_id, String question_id , int grade)
    {
                try {
                    String insertString="UPDATE courseware_studentmodule SET self_assessed_grade = " + grade + " WHERE user_id = "+user_id + " AND course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
                    Statement stmt = conn.createStatement();
                    stmt.execute(insertString);
                    } catch (SQLException e) {
                            System.out.println("ERROR: Could not insert record in pa_grade" + e);
                    }
    }
            
    public void prev_called_from_cms2(String course_id, String question_id)
    {
        try {
                    String insertString="DELETE FROM question_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
                    Statement stmt = conn.createStatement();
                    stmt.execute(insertString);
                    } catch (SQLException e) {
                            System.out.println("ERROR: Could not insert record in pa_grade" + e);
                    }
    }
    public void prev_called_from_cms3(String course_id, String question_id)
    {
        try {
                    String insertString="DELETE FROM question_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
                    Statement stmt = conn.createStatement();
                    stmt.execute(insertString);
                    } catch (SQLException e) {
                            System.out.println("ERROR: Could not delete record in question_details" + e);
                    }
        
        try {
                    String insertString="DELETE FROM option_details WHERE course_id = '" + course_id + "' AND question_id = '" + question_id +"'";
                    Statement stmt = conn.createStatement();
                    stmt.execute(insertString);
                    } catch (SQLException e) {
                            System.out.println("ERROR: Could not delete record in option_details" + e);
                    }
    }
    
    public ArrayList<String> get_sample_answers(String course_id, String question_id) {
       ArrayList<String> s = new ArrayList<String>();
        try{
            String sql = "SELECT DISTINCT sample_answer FROM sample_answer_details WHERE course_id = '" + course_id +"' AND question_id = '"+question_id +"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            s.add(rs.getString("sample_answer"));
        }
        catch(SQLException e)
                {
                  System.out.println(e); 
                }
        return s;
    }
   public ArrayList<String> get_sample_criteria(String course_id, String question_id, String answer) {
        ArrayList<String> s = new ArrayList<String>();
        try{
            String sql = "SELECT DISTINCT criteria FROM sample_answer_details WHERE course_id = '" + course_id +"' AND question_id = '"+question_id +"' AND sample_answer = '"+answer +"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            s.add(rs.getString("criteria"));
        }
        catch(SQLException e)
                {
                  System.out.println(e); 
                }
        return s;
    }
   public ArrayList<String> get_correct_option(String course_id, String question_id,String answer) {
        ArrayList<String> s = new ArrayList<String>();
        try{
            String sql = "SELECT DISTINCT correct_option FROM sample_answer_details WHERE course_id = '" + course_id +"' AND question_id = '"+question_id +"' AND sample_answer = '"+answer +"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            s.add(rs.getString("correct_option"));
        }catch(SQLException e)
                {
                  System.out.println(e); 
                }
        return s;
    }
    public static void  main(String args[])
    {
        
        DataBase_Handler db =new DataBase_Handler(); 
        db.insert_self_grade(1, "C", "Q", 0);
    } 
}
    
