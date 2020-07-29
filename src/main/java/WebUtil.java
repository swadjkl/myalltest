import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;

public class WebUtil {
    public static final String url = "http://10.1.0.62/webService/EASWebService.asmx";
    public static void main(String[] args){
        Object[] params = new Object[]{"602313","2020","04",""};
        String result = sendWebservice(params,url);
        System.out.println(result);
    }

    public static String sendWebservice(Object[] params, String url) {
        String soapaction = "http://tempuri.org/"; // ������������server�����
        String operationName = "GetStandardWelfare";// ���÷�����
        Service service = new Service();
        String ret = "";
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName(soapaction, operationName)); // ����Ҫ�����ĸ�����
            call.addParameter(new QName(soapaction, "StaffCode"), // ����Ҫ���ݵĲ���(����)
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "FYear"), // ����Ҫ���ݵĲ�������ݣ�
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "FMonth"), // ����Ҫ���ݵĲ������·ݣ�
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "FType"), // ����Ҫ���ݵĲ��������ͣ�
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);

            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// ����׼�����ͣ�
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + operationName);

            ret = (String) call.invoke(params);// ���÷��������ݲ���
            System.out.println(ret);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }
}