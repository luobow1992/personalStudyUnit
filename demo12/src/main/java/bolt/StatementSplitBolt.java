package bolt;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.StatementBolt
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/18 13:52
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/18      wangtongbang          v1.0.0               修改原因
 */
public class StatementSplitBolt extends BaseBasicBolt {

    List<Integer> taskIdlist = null;

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        taskIdlist = context.getComponentTasks("wordCountBolt");
        System.out.println(taskIdlist.toString());
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(true, new Fields("word"));
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {

        System.out.println(input.getSourceStreamId());

        String statement = input.getStringByField("statement").replace(".", " ").replace("!", " ").replace(",", " ");
        String[] words = statement.split(" ");
        for (String word : words) {
            //有时候我们需要直接指定某个bolt对应的task来执行我们的逻辑，那么就需要使用emitDirect，同时还需要将topology的
            //分组方式改成直连模式
            collector.emitDirect(taskIdlist.get(0), new Values(word));
//            collector.emit(new Values(word));
        }


    }

    @Override
    public void cleanup() {
        System.out.println("我是第一个bolt的结束执行语句");
        System.out.println("我是第一个bolt的结束执行语句");
        System.out.println("我是第一个bolt的结束执行语句");
        System.out.println("我是第一个bolt的结束执行语句");
    }

}
