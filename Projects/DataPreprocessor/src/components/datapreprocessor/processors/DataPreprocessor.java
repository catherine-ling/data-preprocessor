package components.datapreprocessor.processors;

import java.util.List;

import components.datapreprocessor.interfaces.DataPreprocessor2;
import components.datapreprocessor.interfaces.DataPreprocessorKernel;
import components.datapreprocessor.models.DataSet;

/**
 * Factory class to create instances of DataPreprocessorKernel or DataPreprocessor2 using a DataSet.
 */
public class DataPreprocessor {

    /**
     * Creates an instance of DataPreprocessorKernel using a given dataset.
     *
     * @param dataSet the dataset to be used by the preprocessor.
     * @return an instance of DataPreprocessorKernel.
     */
    public static DataPreprocessorKernel createBasicPreprocessor(DataSet dataSet) {
        return new DataPreprocessorKernel2(dataSet);
    }

    /**
     * Creates an instance of DataPreprocessor2 using a given dataset.
     *
     * @param dataSet the dataset to be used by the preprocessor.
     * @return an instance of DataPreprocessor2.
     */
    public static DataPreprocessor2 createAdvancedPreprocessor(DataSet dataSet) {
        return new DataPreprocessor2a(dataSet);
    }

    /**
     * Internal implementation of DataPreprocessorKernel interface.
     * Provides basic data processing functionality.
     */
    private static class DataPreprocessorKernel2 extends DataPreprocessorSecondary implements DataPreprocessorKernel {

        /**
         * Constructor to initialize the dataset for basic processing.
         *
         * @param dataSet the dataset to be processed.
         */
        public DataPreprocessorKernel2(DataSet dataSet) {
            super(dataSet);
        }

        // The advanced methods are not supported in this basic implementation
        @Override
        public List<Double> normalize() {
            throw new UnsupportedOperationException("Normalization not supported in DataPreprocessorKernel.");
        }

        @Override
        public List<Double> standardize() {
            throw new UnsupportedOperationException("Standardization not supported in DataPreprocessorKernel.");
        }

        @Override
        public List<Double> removeOutliers(double threshold) {
            throw new UnsupportedOperationException("Outlier removal not supported in DataPreprocessorKernel.");
        }
    }
}
