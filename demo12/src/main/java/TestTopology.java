import bolt.StatementSplitBolt;
import bolt.WordCountBolt;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.utils.Utils;
import spout.StatementSpout;

/**
 * Copyright: Copyright (c) 2018 Ztesoft
 *
 * @ClassName: PACKAGE_NAME.TestTopology
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
public class TestTopology {

    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("statementSpout", new StatementSpout(), 1);
        builder.setBolt("statementSplitBolt", new StatementSplitBolt(), 2).shuffleGrouping("statementSpout");
        builder.setBolt("wordCountBolt", new WordCountBolt(), 1).fieldsGrouping("statementSplitBolt", new Fields("word"));

        Config conf = new Config();
        conf.setDebug(false);

        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("word-count", conf, builder.createTopology());

        Utils.sleep(10000);

        localCluster.killTopology("word-count");
    }
}
