package service.impl;

import service.IRpcService;

import javax.jws.WebService;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: service.impl.RpcServiceImpl
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/13 15:03
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/13      wangtongbang          v1.0.0               修改原因
 */
@WebService(endpointInterface = "service.IRpcService")
public class RpcServiceImpl implements IRpcService {
    @Override
    public String printSomething(String str){
        return "Hello world" + str;
    }
}
