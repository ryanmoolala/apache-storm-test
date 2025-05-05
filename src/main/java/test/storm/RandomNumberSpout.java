package test.storm;

import java.util.Map;
import java.util.Random;

import org.apache.hadoop.thirdparty.org.checkerframework.checker.units.qual.s;
import org.apache.storm.daemon.nimbus.TopoCache;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class RandomNumberSpout extends BaseRichSpout {
    private Random random;
    private SpoutOutputCollector collector;

    public RandomNumberSpout() {
        this.random = new Random();
    }

    @Override
    public void open(Map map, TopologyContext context, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
    }

    @Override
    public void nextTuple() {
        // Generate a random number between 0 and 100
        int randomNumber = random.nextInt(10);
        long timestamp = System.currentTimeMillis();
        // Emit the random number
        collector.emit(new Values(randomNumber));
        // Sleep for a short period to simulate data generation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // Declare the output fields for the spout
        declarer.declare(new Fields("randomNumber", "timestamp"));
    }
}
