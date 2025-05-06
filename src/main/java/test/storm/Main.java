package test.storm;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.thrift.TException;
import org.apache.storm.topology.TopologyBuilder;

public class Main {
    public static void main(String[] args) {
        Config conf = new Config();
        TopologyBuilder builder = new TopologyBuilder();
    
        // Define topology
        builder.setSpout("random_int_spout", new RandomNumberSpout());
        builder.setBolt("filter_bolt", new FilterBolt()).shuffleGrouping("random_int_spout");
        builder.setBolt("print_bolt", new PrintBolt()).shuffleGrouping("filter_bolt");
    
        
    
        try (LocalCluster cluster = new LocalCluster()) {
            cluster.submitTopology("random_number_topology", conf, builder.createTopology());
            System.out.println("Topology running for 60 seconds...");
            //Thread.sleep(60000); //sleeps the main thread for 60 seconds, allowing the cluster to run separately
            while (true) {
                Thread.sleep(1000); // Sleep in small intervals to avoid busy-waiting
            }
        } catch (TException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.out.println("Topology already exists");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Shutting down cluster...");
        }
    }
    
}