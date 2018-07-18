package demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: demo.QueueConsumer
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/17 16:40
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/17      wangtongbang          v1.0.0               修改原因
 */
public class QueueConsumer {
    public static void main(final String[] args) throws Exception {
        final ConnectionFactory connFactory = new ActiveMQConnectionFactory();

        final Connection conn = connFactory.createConnection();
        conn.start();

        final Session sess = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);

        final Destination dest = sess.createQueue("SampleQueue");


         MessageConsumer consumer = sess.createConsumer(dest);


        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message ;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
