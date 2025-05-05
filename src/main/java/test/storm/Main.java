package test.storm;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TopologyBuilder builder = new TopologyBuilder();

        // Create a spout and a bolt
        builder.setSpout("random_int_spout", new RandomNumberSpout(), 1);
        builder.setBolt("print_bolt", new PrintBolt(), 1);
        // Set the bolt to receive data from the spout
        
        Config conf = new Config();
        conf.setDebug(true);

        try (LocalCluster cluster = new LocalCluster()) {
            // Submit the topology to the local cluster
            cluster.submitTopology("random_number_topology", conf, builder.createTopology());
            // Sleep for a while to let the topology run
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("TopologyBuilder, Spout, Bolt created!");
    }
}