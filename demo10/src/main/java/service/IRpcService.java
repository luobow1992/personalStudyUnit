package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: service.IRpcService
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/13 15:01
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/13      wangtongbang          v1.0.0               修改原因
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IRpcService {
    /**
     * 打印点东西
     * @param str
     * @return
     */
    @WebMethod
    public String printSomething(String str);
}
