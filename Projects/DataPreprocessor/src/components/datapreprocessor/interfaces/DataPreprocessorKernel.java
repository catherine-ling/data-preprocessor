package components.datapreprocessor.interfaces;
import java.util.List;

/**
 * Interface for basic data preprocessing operations.
 */
public interface DataPreprocessorKernel {

    /**
     * Calculates the mean of the list of numbers.
     *
     * @return the mean value.
     */
    double calculateMean();

    /**
     * Calculates the median of the list of numbers.
     *
     * @return the median value.
     */
    double calculateMedian();

    /**
     * Calculates the variance of the list of numbers.
     *
     * @return the variance value.
     */
    double calculateVariance();
}
