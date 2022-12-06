import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class timeMapper
        extends Mapper<Object, Text, Text, IntWritable>{
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
        String line = value.toString();
        String[] lines = line.split("\n");
        for(String actual: lines){
            String[] record = actual.split(",");
            String time = record[3].substring(0,4);
            String[] date = record[1].split("/");
            char ch = time.charAt(0);
            if(ch!='V'){
            int timeInt = Integer.parseInt(time);
            String ampm = record[3].substring(4);
            if((timeInt < 0600 && ampm.equals("A")) || (timeInt > 1000 && ampm.equals("P"))){
            if(date[0].equals("07")){
                word.set("before 24 & outside hours");
            }
            else if(date[0].equals("08")){
                word.set("after 24 & outside hours");
            }
            }
            else {
            if(date[0].equals("07")){
                word.set("before 24 & inside hours");
            }
            else if(date[0].equals("08")){
                word.set("after 24 & inside hours");
            }
            }
            context.write(word, one);
}
}
}
}
