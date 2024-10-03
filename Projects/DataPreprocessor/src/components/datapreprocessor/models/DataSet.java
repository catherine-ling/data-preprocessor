package components.datapreprocessor.models;
import java.util.List;
import java.util.ArrayList;

/**
 * Class representing a dataset that can be used by different preprocessors.
 */
public class DataSet {
    private List<Double> data;

    /**
     * Constructor to initialize the dataset.
     *
     * @param data the list of double values representing the dataset.
     */
    public DataSet(List<Double> data) {
        // Copy the data to protect against changes to the original list
        this.data = new ArrayList<>(data);
    }

    /**
     * Returns the data as a list of double values.
     *
     * @return the list of data values.
     */
    public List<Double> getData() {
        return new ArrayList<>(data);
    }

    /**
     * Sets the data to a new list of double values.
     *
     * @param data the new list of data values.
     */
    public void setData(List<Double> data) {
        this.data = new ArrayList<>(data);
    }
}
