import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;

import com.google.gson.*;
import com.google.gson.internal.$Gson$Types;
public class CstudyingServer {
	private static List<Socket> mList = null;
    static ServerSocket serverSocket;
    static InetAddress address;
    static String ip ;
    static Socket socket = null;
    static InputStream is=null;
    static InputStreamReader isr=null;
    static BufferedReader br=null;
    OutputStream os=null;
    static PrintWriter pw=null;
    private  final static int HOST = 8090; 
      
      

public static  void main(String[] args) throws IOException {
 
	mList = new ArrayList<>();
	
     
  
     	while(true){
     		serverSocket = new ServerSocket(HOST);
     	     address = InetAddress.getLocalHost();
     	     ip = address.getHostAddress();
     		socket = serverSocket.accept();
	     for (Socket s : mList) {
			if(s.isClosed()){
				mList.remove(s);
				break;
			}
		}
	     mList.add(socket);

	     System.out.println( socket.getInetAddress() + "ip");    
	    //2.����accept()�ȴ��ͻ�������
	    System.out.println("ip add successfulַ: " + ip+"size"+mList.size());
	    //3.���Ӻ��ȡ����������ȡ�ͻ�����Ϣ
	
	    is = socket.getInputStream();     //��ȡ������
	    isr = new InputStreamReader(is,"UTF-8");
	    br = new BufferedReader(isr);
	     MySQLDemo m = new MySQLDemo();
	    pw.print(m.flag);//��ͻ��˷�����Ϣ
	    pw.flush();
	    socket.shutdownOutput();
	    String info = null;
    while((info=br.readLine())!=null){//ѭ����ȡ�ͻ��˵���Ϣ
        System.out.println("User Message" + info);
    
    	
        Gson gs =new Gson();
        
        Teacher t = gs.fromJson(info, Teacher.class);
        String id = t.getId();
        String psd = t.getPassword();
        String Command = t.getCommand();
        String Attribute = t.getAttribute();

    
        switch(Command){
        case "登录":
        	//Login 
        	;break;
        case "注册": 
        	//if attribute is student 
        	if(Attribute == "Student"){
     
        	//register insert data
        	
        	MySQLDemo.insertData();
        }else{
        	
        }
        	//Resiger
        	;break;
        case "查询":
        	//Select 
        	;break;
        }
        System.out.print(id);
        System.out.print(psd);
        System.out.println(Command);

    }
    socket.shutdownInput();//�ر�������
    socket.close();
    pw.close();
    is.close();
    isr.close();
    br.close();
    
}
}

}
