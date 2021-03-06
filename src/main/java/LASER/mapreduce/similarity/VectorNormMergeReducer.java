package LASER.mapreduce.similarity;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.mahout.math.VarIntWritable;
import org.apache.mahout.math.Vector;
import org.apache.mahout.math.VectorWritable;
import org.apache.mahout.math.hadoop.similarity.cooccurrence.Vectors;

import java.io.IOException;

public class VectorNormMergeReducer extends Reducer<VarIntWritable, VectorWritable, VarIntWritable, VectorWritable> {

    @Override
    public void reduce(VarIntWritable key, Iterable<VectorWritable> vectors, Context context) throws IOException, InterruptedException {
        Vector mergedVectors = Vectors.merge(vectors);

        context.write(key, new VectorWritable(mergedVectors, true));
    }
}
