import service.IRpcService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.Client
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/13 15:19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/13      wangtongbang          v1.0.0               修改原因
 */
public class Client {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9966/rpc?wsdl");
            QName qname = new QName("http://impl.service/","RpcServiceImplService");
            Service service = Service.create(url, qname);
            IRpcService irpc = service.getPort(IRpcService.class);
            System.out.println(irpc.printSomething("client"));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
