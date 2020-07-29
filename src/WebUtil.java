import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class WebUtil {
    public static final String url = "http://10.1.0.62/webService/EASWebService.asmx";
    public static void main(String[] args){
        Object[] params = new Object[]{"602313","2020","04",""};
        String result = sendWebservice(params,url);
        System.out.println(result);
    }

    public static String sendWebservice(Object[] params, String url) {
        String soapaction = "http://tempuri.org/"; // 域名，这是在server定义的
        String operationName = "GetStandardWelfare";// 调用方法名
        Service service = new Service();
        String ret = "";
        try {
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName(soapaction, operationName)); // 设置要调用哪个方法
            call.addParameter(new QName(soapaction, "StaffCode"), // 设置要传递的参数(工号)
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "FYear"), // 设置要传递的参数（年份）
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "FMonth"), // 设置要传递的参数（月份）
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "FType"), // 设置要传递的参数（类型）
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);

            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + operationName);

            ret = (String) call.invoke(params);// 调用方法并传递参数
            System.out.println(ret);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }
}