

import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Mysql ���ݿ������ ��ѯ ɾ�� ���� �Ķ�
 * link student database
 * **/

public class MySQLDemo {
	    static String selectsql;
		static String DB_URL="jdbc:mysql://localhost:3306/c_studying?useSSL=false&serverTimezone=UTC"; 
		
		static Statement stmt;
		static student s;
		static Teacher t;
	
		static String USER = "root";
		static String PASS = "123456";
     	static String sql = "insert into student values (null,?,?,?)";
	    static Connection conn = null;//��������    ��SQL ���
	    public static  boolean flag = false;
	    
		public static String id;
		public static String passWord;
		public static String Command;
		public static String User;
		public static String Attribute;
		public static String name;
		public static String timer;
		public static void main(String[] args) {
	 
		        try{
		            // ע�� JDBC ����
		      
		        	Class.forName("com.mysql.jdbc.Driver");
		            // ������
		            System.out.println("link database...");
		            conn = DriverManager.getConnection(DB_URL,USER,PASS);
		            //��������
		            id = s.getId();
		            name = s.getName();
		            passWord =s.getPassword();
		            //product time 
		            Date date=new Date();
		            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期时间格式
		            System.out.println(df.format(date));
		            timer = df.format(date);
		            
		           s =new student(id,name,passWord,timer);
		           insertData();//insert data 
		            //�޸�����
		            update();//update data 
		            //ɾ������
		            delete(); //delete data 
		            
		            
		            selectsql = "SELECT * FROM student";
		            stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(selectsql);
		        
		            // չ����������ݿ�
		            while(rs.next()){
		                // ͨ���ֶμ���
		                int id  = rs.getInt("id");
		                String name = rs.getString("name");
		                String password =rs.getString("password");
		                String LoginTimer=rs.getString("LoginTimer");
		                // �������
		                
		                System.out.print("ID: " + id);
		                System.out.println();
		                System.out.print("name: " + name);
		                System.out.println();
		                System.out.println("password: "+password);
		                System.out.println();
		                System.out.println("LoginTimer: "+LoginTimer); 
//		                System.out.print("\n");
//		            
		            }
		            // ��ɺ�ر�
		            rs.close();
		            stmt.close();
		            conn.close();
		        }catch(SQLException se){
		            // ���� JDBC ����
		            se.printStackTrace();
		        }catch(Exception e){
		            // ���� Class.forName ����
		            e.printStackTrace();
		        }finally{
		            // �ر���Դ
		            try{
		                if(stmt!=null) stmt.close();
		            }catch(SQLException se2){
		            }// ʲô������
		            try{
		                if(conn!=null) conn.close();
		            }catch(SQLException se){
		                se.printStackTrace();
		            }
		        }
		        System.out.println("Goodbye!");
		    }
		
		//�������ݷ���
		public static void insertData(){
		    	 String insertsql = "insert into student values('"+s.getId()+"','"+s.getName()+"','" +s.getPassword()+"','" +s.getLoginTimer()+"')";
		    	  
		       try {
		    
				stmt = (Statement) conn.createStatement();
				
			
				
				stmt.execute(insertsql);
				System.out.println(s.getId()+"insert successful");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		      
		}
		public static void update(){
			 String updatesql="UPDATE student SET PASSWORD = '" +s.getPassword()+"'WHERE Id = '"+s.getId()+"'";
			 
			   try {
				    
					stmt = (Statement) conn.createStatement();
					
	
					
					stmt.execute(updatesql);
					System.out.println(s.getId()+"update successful");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  
		}
		public static void delete(){
			String deletesql="DELETE FROM student WHERE Id = "+s.getId();
			   try {
				    
					stmt = (Statement) conn.createStatement();
					
	
					
					stmt.execute(deletesql);
					System.out.println(s.getId()+"delete successful");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  
		}
		}

