package bolt;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.WordCountBolt
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wangtongbang
 * @date: 2018/7/18 13:53
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2018/7/18      wangtongbang          v1.0.0               修改原因
 */
public class WordCountBolt extends BaseBasicBolt {

    private Map<String, Long> counts = null;

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        this.counts = new HashMap<String, Long>();

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        String word = input.getStringByField("word");
        Long count = this.counts.get(word);
        if (count == null) {
            count = 0L;
        }
        count++;
        this.counts.put(word, count);

    }

    @Override
    public void cleanup() {
        //拓扑结束执行
        System.out.println("***************===我是WordCountBolt类===***************************");

        for (String key : counts.keySet()) {
            System.out.println(key + " : " + this.counts.get(key));
        }

        System.out.println("***************===我是WordCountBolt类===***************************");

    }
}
