

import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Mysql ���ݿ������ ��ѯ ɾ�� ���� �Ķ�
 * teacher link database
 * **/

public class Mysql {
	    static String selectsql;
		static String DB_URL="jdbc:mysql://localhost:3306/c_studying?useSSL=false&serverTimezone=UTC"; 
		
		static Statement stmt;

		static Teacher t;

		static String USER = "root";
		static String PASS = "123456";
     	static String sql = "insert into teacher values (null,?,?,?)";
	    static Connection conn = null;
	    public static  boolean flag = false;
		public static void main(String[] args) {
	 
		        try{
		     
		      
		        	Class.forName("com.mysql.jdbc.Driver");
		 
		            System.out.println("link database...");
		            conn = DriverManager.getConnection(DB_URL,USER,PASS);
		        
		            
		           t =new Teacher("0023","cg","123456","Login");
		            insertData();
	
		         update();
		   
		         delete();
		            
		            
		            selectsql = "SELECT * FROM teacher";
		            stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(selectsql);
		        
		       
		            while(rs.next()){
		     
		                int id  = rs.getInt("id");
		                String name = rs.getString("name");
		                String password =rs.getString("password");
		               String command=rs.getString("command");
		            
		                
		                System.out.print("ID: " + id);
		                System.out.println();
		                System.out.print("name: " + name);
		                System.out.println();
		                System.out.println("password: "+password);
		                System.out.println();
		                System.out.println("command "+command); 
//		                System.out.print("\n");
//		                if(command.equals(t.getId()) && password.equals(t.getPassword())){
//		                	System.out.println("id and password is right");
//		                	flag = true ;
//		                }else{
//		                	System.out.println("id and password is wrong");
//		                	flag = false;
//		                }
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
			 String insertsql = "insert into teacher values('"+t.getId()+"','"+t.getUser()+"','" +t.getPassword()+"','" +t.getCommand()+"')";
	    	  
		    	  
		       try {
		    
				stmt = (Statement) conn.createStatement();
				
			
				
				stmt.execute(insertsql);
				System.out.println(t.getCommand()+"insert successful");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		      
		}
		public static void update(){
			 String updatesql="UPDATE teacher SET PASSWORD = '" +t.getPassword()+"'WHERE Id = '"+t.getId()+"'";;
			 
			   try {
				    
					stmt = (Statement) conn.createStatement();
					
	
					
					stmt.execute(updatesql);
					System.out.println(t.getCommand()+"update successful");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  
		}
		public static void delete(){
			String deletesql="DELETE FROM teacher WHERE Id = "+t.getId();
			   try {
				    
					stmt = (Statement) conn.createStatement();
					
	
					
					stmt.execute(deletesql);
					System.out.println(t.getCommand()+"delete successful");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  
		}
		}

