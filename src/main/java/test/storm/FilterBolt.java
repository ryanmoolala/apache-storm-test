package test.storm;

import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.BasicOutputCollector;

public class FilterBolt extends BaseBasicBolt {
    FilterBolt() {
        // Constructor logic here
    }

    @Override
    public void execute(Tuple tuple, BasicOutputCollector collector) {
        int number = tuple.getIntegerByField("randomNumber");
        if (number % 2 == 0) {
            collector.emit(new Values(number, tuple.getLongByField("timestamp")));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // Declare the output fields here if needed
        declarer.declare(new Fields("randomNumber", "timestamp"));
    }
}
