package ext.util.helper;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class Helper {
	private static final String ENCODING="UTF-8";
	private static String IP=null;
	private final static Logger logger = LogManager.getLogger(Helper.class.getName());
	
	private static void ipinit(){
		Enumeration allNetInterfaces;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements())
			{
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			if(!netInterface.getName().equals("eth0")){
				continue;
			}
			Enumeration addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements())
			{
			ip = (InetAddress) addresses.nextElement();
			if (ip != null && ip instanceof Inet4Address)
			{
				IP=ip.getHostAddress();
			} 
			}
			}	
		} catch (SocketException e) {
		}
		
	}
	
	public static Map<String, Object> transBean2Map(Object obj) {  
		  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
  
                    map.put(key, value);  
                }  
  
            }  
        } catch (Exception e) {  
            logger.error("transBean2Map Error " + e);  
        }  
  
        return map;  
  
    }  
	
	public static void restful(HttpServletResponse  response , Object bean) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		response.setHeader("Context-Type", "application/json;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw  = response.getWriter();
		String json = mapper.writeValueAsString(bean);
		pw.println(json);
		pw.flush();
		logger.info("the message is "+ json);
	}
	
	
	public static void errorRestful(HttpServletResponse  response , String message) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		response.setHeader("Context-Type", "application/json;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		Map result = initResponse();
		result.put("state", 0);
		result.put("message", message);
		PrintWriter pw  = response.getWriter();
		String json = mapper.writeValueAsString(result);
		pw.println(json);
		pw.flush();
		logger.info("the error message is "+ json);
	}
	
	public static Map initResponse(){
		if(IP==null)
			ipinit();
		Map<String,String> map = new HashMap<String,String>();
		map.put("state", "1");
		map.put("code", "");
		map.put("message", "");
		map.put("ip", IP);
		return map;
	}
	
	public static void errorResonse(Map map){
		map.put("state", 0);
		map.put("message", "内容非法");
	}
	public static void processError(HttpServletResponse  response){
		if(IP==null)
			ipinit();
		Map<String,String> map = new HashMap<String,String>();
		map.put("state", "2");
		map.put("code", "");
		map.put("message", "sometings error");
		map.put("ip", IP);
	}
	
	
}
