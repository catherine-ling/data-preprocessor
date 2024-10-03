package components.datapreprocessor.processors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import components.datapreprocessor.interfaces.DataPreprocessor2;
import components.datapreprocessor.models.DataSet;

/**
 * Abstract class that implements the DataPreprocessor2 interface.
 * Provides concrete implementations for most of the basic and advanced preprocessing methods.
 */
public abstract class DataPreprocessorSecondary implements DataPreprocessor2 {
    protected DataSet dataSet;

    /**
     * Constructor to initialize the dataset for preprocessing.
     *
     * @param dataSet the dataset to be processed.
     */
    public DataPreprocessorSecondary(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public double calculateMean() {
        List<Double> data = dataSet.getData();
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    @Override
    public double calculateMedian() {
        List<Double> data = dataSet.getData();
        List<Double> sortedData = new ArrayList<>(data);
        Collections.sort(sortedData);
        int size = sortedData.size();
        if (size % 2 == 0) {
            return (sortedData.get(size / 2 - 1) + sortedData.get(size / 2)) / 2.0;
        } else {
            return sortedData.get(size / 2);
        }
    }

    @Override
    public double calculateVariance() {
        List<Double> data = dataSet.getData();
        double mean = calculateMean();
        double variance = 0;
        for (double num : data) {
            variance += Math.pow(num - mean, 2);
        }
        return variance / data.size();
    }

    @Override
    public List<Double> normalize() {
        List<Double> data = dataSet.getData();
        double min = Collections.min(data);
        double max = Collections.max(data);
        List<Double> normalizedData = new ArrayList<>();

        for (double num : data) {
            normalizedData.add((num - min) / (max - min));
        }
        return normalizedData;
    }

    @Override
    public List<Double> standardize() {
        List<Double> data = dataSet.getData();
        double mean = calculateMean();
        double variance = calculateVariance();
        double standardDeviation = Math.sqrt(variance);
        List<Double> standardizedData = new ArrayList<>();

        for (double num : data) {
            standardizedData.add((num - mean) / standardDeviation);
        }
        return standardizedData;
    }

    @Override
    public List<Double> removeOutliers(double threshold) {
        List<Double> data = dataSet.getData();
        double mean = calculateMean();
        double variance = calculateVariance();
        double standardDeviation = Math.sqrt(variance);
        List<Double> filteredData = new ArrayList<>();

        for (double num : data) {
            double zScore = (num - mean) / standardDeviation;
            if (Math.abs(zScore) <= threshold) {
                filteredData.add(num);
            }
        }
        return filteredData;
    }
}
