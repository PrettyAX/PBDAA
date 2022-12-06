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

public class CleanMapper
        extends Mapper<Object, Text, Text, Text>{
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
        String line = value.toString();
        String[] row = line.split(",");
        String registration = row[2];
        String date = row[4];
        String make = row[7];
        String time = row[19];
        String houseNum = row[23];
        String street = row[24];
        String intersect = row[25];
        String color = row[33];
        String year = row[35];
        context.write(new Text(registration+","+date+","+make+","+time+","+houseNum+","+street+","+intersect+","+color+","+year),new Text(""));

}
}
