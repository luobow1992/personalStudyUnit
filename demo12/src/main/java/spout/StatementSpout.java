package spout;

import mq.MqQueueConsumer;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.StatementSpout
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/18 13:51
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/18      wangtongbang          v1.0.0               修改原因
 */
public class StatementSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;


//    private String statement = "Apache Storm is a free and open source distributed realtime computation system. Storm makes it easy to" + " reliably process unbounded streams of data, doing for realtime processing what Hadoop did for batch processing. Storm is simple, can be used with any programming language, and is a lot of fun to use!Storm has many use cases: realtime analytics, online machine learning, continuous computation, distributed RPC, ETL, and more. Storm is fast: a benchmark clocked it at over a million tuples processed per second per node. It is scalable, fault-tolerant, guarantees your data will be processed, and is easy to set up and operate.Storm integrates with the queueing and database technologies you already use. A Storm topology consumes streams of data and processes those streams in arbitrarily complex ways, repartitioning the streams between each stage of the computation however needed. Read more in the tutorial. ";


    public static BlockingQueue<String> mqStatement = new LinkedBlockingQueue<String>();

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //可以声明对应的streamId信息,不写也可以，默认是default
        declarer.declareStream("stream1",new Fields("statement"));
//        declarer.declare(new Fields("statement"));
    }

    @Override
    public void open(Map config, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
        MqQueueConsumer mqQueueConsumer = new MqQueueConsumer();
        mqStatement = mqQueueConsumer.getMqStatement();
        if (mqStatement.isEmpty()) {
            try {
                mqQueueConsumer.statementConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void nextTuple() {
        if (!mqStatement.isEmpty()) {
            try {
                this.collector.emit("stream1",new Values(mqStatement.take()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }

}
