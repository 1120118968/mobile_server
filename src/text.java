import java.lang.reflect.Type;

import com.google.gson.Gson;


public class text {
public static void main(String[] args) {
	 //String jsonData = "{'name':'John'|'age':'20'}";
	 String jsonData ="ssss|aaaa";
	// Gson gson = new Gson();
	 String s[]=jsonData.split("|");
	 System.out.println(s[0]);
	 System.out.println(s[1]);
	 for(int i = 0;i > s.length ; i++){
		 System.out.println(s[i]);
	 }
	// Person person = gson.fromJson(jsonData,Person.class);
	//student person = gson.fromJson(jsonData,student.class);

	
//System.out.println(person.getName() + "," + person.getPassword());
}

}
// class GsonUtil {
//     //将Json数据解析成相应的映射对象
//     public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
//         Gson gson = new Gson();
//        T result = gson.fromJson(jsonData, type);
//        return result;
//    }
// 
