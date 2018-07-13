import service.impl.RpcServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.WebServicePublisher
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/13 15:12
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/13      wangtongbang          v1.0.0               修改原因
 */
public class WebServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9966/rpc", new RpcServiceImpl());
    }
}
