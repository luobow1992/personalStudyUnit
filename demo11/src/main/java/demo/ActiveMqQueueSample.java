package demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: demo.ActiveMqQueueSample
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/17 16:20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/17      wangtongbang          v1.0.0               修改原因
 */
public class ActiveMqQueueSample {

    public static void main(final String[] args) throws Exception {
        final ConnectionFactory connFactory = new ActiveMQConnectionFactory();

        final Connection conn = connFactory.createConnection();

        final Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        final Destination dest = sess.createQueue("SampleQueue");

        final MessageProducer prod = sess.createProducer(dest);

        final Message msg = sess.createTextMessage("Simples Assim");

        prod.send(msg);

        conn.close();
    }
}
