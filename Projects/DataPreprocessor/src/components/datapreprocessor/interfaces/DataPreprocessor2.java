package components.datapreprocessor.interfaces;

import java.util.List;

/**
 * Interface for advanced data preprocessing operations.
 * Extends DataPreprocessorKernel to add more advanced functionality.
 */
public interface DataPreprocessor2 extends DataPreprocessorKernel {

    /**
     * Normalizes the list of numbers to the range [0, 1].
     *
     * @return a list of normalized values.
     */
    List<Double> normalize();

    /**
     * Standardizes the list of numbers using z-score normalization.
     *
     * @return a list of standardized values.
     */
    List<Double> standardize();

    /**
     * Removes outliers from the list using the Z-score method.
     *
     * @param threshold the Z-score threshold for identifying outliers.
     * @return a list of values with outliers removed.
     */
    List<Double> removeOutliers(double threshold);
}

