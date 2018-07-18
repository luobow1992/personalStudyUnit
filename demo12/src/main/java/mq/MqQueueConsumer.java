package mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.*;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: mq.MqQueueConsumer
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/18 14:55
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/18      wangtongbang          v1.0.0               修改原因
 */
public class MqQueueConsumer {

    private BlockingQueue<String> mqStatement = new LinkedBlockingDeque<String>();

    public BlockingQueue<String> getMqStatement() {
        return mqStatement;
    }


    public void statementConsumer() throws Exception {
        final ConnectionFactory connFactory = new ActiveMQConnectionFactory();

        final Connection conn = connFactory.createConnection();
        conn.start();

        final Session sess = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);

        final Destination dest = sess.createQueue("SampleQueue");

        MessageConsumer consumer = sess.createConsumer(dest);


        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                    mqStatement.put(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
