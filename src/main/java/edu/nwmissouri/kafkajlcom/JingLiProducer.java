package edu.nwmissouri.kafkajlcom;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.Scanner;

/**
 * Created by sunilpatil on 1/2/16.
 */
public class JingLiProducer {
    private static Scanner in;
    public static void main(String[] argv)throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameters ");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        System.out.println("Enter message(type exit to quit)");

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
        
        
        String message = newProducer();
        ProducerRecord<String, String> rec = new ProducerRecord<String, String> (topicName, message);
        producer.send(rec);
        

        /*String line = in.nextLine();
        while(!line.equals("exit")) {
            //ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);

            producer.send(rec, new Callback()); 
            producer.send(rec);   
            
            line = in.nextLine();
        }*/


        in.close();
        producer.close();
    }

        private static String newProducer(){
            int x = 1;
            int total = 0;
            int num = 1;
        while(x <= 10){
            int result;
            result = num * x ;
            
            x +=1;
            num += 1;
            
            total += result;
        } 
        return "summation of all the results : " + total;
    }       

}
