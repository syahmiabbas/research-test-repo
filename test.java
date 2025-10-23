import java.util.List;
import java.util.ArrayList;

public class DataPipeline {
    private List<String> processingSteps;
    private String outputFormat;

    // Private constructor to enforce builder usage
    private DataPipeline() {
        this.processingSteps = new ArrayList<>();
    }

    public void addStep(String step) {
        if (step == null || step.trim().isEmpty()) {
            throw new IllegalArgumentException("Processing step cannot be null or empty");
        }
        this.processingSteps.add(step);
    }

    public void setOutputFormat(String format) {
        if (format == null || format.trim().isEmpty()) {
            throw new IllegalArgumentException("Output format cannot be null or empty");
        }
        this.outputFormat = format;
    }

    public List<String> getProcessingSteps() {
        return new ArrayList<>(processingSteps);
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void execute() {
        System.out.println("Executing pipeline with " + processingSteps.size() + " steps");
        for (int i = 0; i < processingSteps.size(); i++) {
            System.out.println("Step " + (i + 1) + ": " + processingSteps.get(i));
        }
        System.out.println("Output format: " + outputFormat);
    }

    static DataPipeline createInstance() {
        return new DataPipeline();
    }
}

// Guides the construction of a DataPipeline object
public class PipelineBuilder {
    private DataPipeline pipeline;

    public PipelineBuilder() {
        this.pipeline = DataPipeline.createInstance();
    }

    public PipelineBuilder addStep(String step) {
        pipeline.addStep(step);
        return this;
    }

    public PipelineBuilder setOutputFormat(String format) {
        pipeline.setOutputFormat(format);
        return this;
    }

    public DataPipeline build() {
        if (pipeline.getProcessingSteps().isEmpty()) {
            throw new IllegalStateException("Pipeline must have at least one processing step");
        }

        if (pipeline.getOutputFormat() == null) {
            throw new IllegalStateException("Pipeline must have an output format defined");
        }
        
        return pipeline;
    }
}
