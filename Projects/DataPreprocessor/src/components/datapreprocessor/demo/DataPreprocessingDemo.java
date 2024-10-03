package components.datapreprocessor.demo;
import components.datapreprocessor.interfaces.*;
import components.datapreprocessor.models.DataSet;
import components.datapreprocessor.processors.DataPreprocessor;
import java.util.Arrays;
import java.util.List;

public class DataPreprocessingDemo {
    public static void main(String[] args) {
        List<Double> rawData = Arrays.asList(10.0, 12.0, 23.0, 23.0, 16.0, 35.0, 45.0);
        DataSet dataSet = new DataSet(rawData);

        DataPreprocessorKernel basicProcessor = DataPreprocessor.createBasicPreprocessor(dataSet);
        System.out.println("Basic Processor - Mean: " + basicProcessor.calculateMean());
        System.out.println("Basic Processor - Median: " + basicProcessor.calculateMedian());
        System.out.println("Basic Processor - Variance: " + basicProcessor.calculateVariance());

        DataPreprocessor2 advancedProcessor = DataPreprocessor.createAdvancedPreprocessor(dataSet);
        System.out.println("Advanced Processor - Normalized Data: " + advancedProcessor.normalize());
        System.out.println("Advanced Processor - Standardized Data: " + advancedProcessor.standardize());
        System.out.println("Advanced Processor - Data after removing outliers (threshold = 2.0): " + advancedProcessor.removeOutliers(2.0));
    }
}

