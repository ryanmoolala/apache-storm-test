package test.storm;


import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.topology.OutputFieldsDeclarer;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;

public class PrintBolt extends BaseBasicBolt {

    public PrintBolt() {

    }

    @Override
    public void execute(Tuple tuple, BasicOutputCollector collector) {
        System.out.println("PrintBolt: Executing PrintBolt");
        System.out.println("TUPLE Printed " + tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
    }
}
