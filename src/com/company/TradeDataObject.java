package com.company;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dataset"
})
public class TradeDataObject {

    @JsonProperty("dataset")
    private EducationEnrollmentDataSet dataset_ENROL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataset")
    public EducationEnrollmentDataSet getDataset_ENROL() {
        return dataset_ENROL;
    }

    @JsonProperty("dataset")
    public void setDataset_TRADE(EducationEnrollmentDataSet dataset_ENROL) {
        this.dataset_ENROL = dataset_ENROL;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}