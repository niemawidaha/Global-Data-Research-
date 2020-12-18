package com.company;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Global_WaterSanitation {

    public Global_WaterSanitation() throws IOException {

        // Display water and sanitation statistics for the worlds highest GDP's:
        waterSanitation_HighestGDP();

        // Display water and sanitation statistics for the worlds lowest GDP's
        waterSanitation_LowestGDP();
    }

    /**
     * waterSanitation_HighestGDP
     * - displays the water and sanitation statistics for the countries with the highest GDP
     */
    private static void waterSanitation_HighestGDP() throws IOException {

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Water and Sanitation Statistics - The countries with the Highest GDP");
        System.out.println("This dictates the proportion of the population using: \n1. improved drinking water sources\n2. improved sanitation facilities");
        System.out.println("---------------------------------------------------------------------------");
        // create connection

        // gather the urls for the top 5 countries
        String[] urlList = {"https://www.quandl.com/api/v3/datasets/UGID/H2O_USA?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_CHN?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_DEU?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_JPN?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_GBR?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w"};

        // iterate through string list to display the contents:
        for(String countryURL : urlList){

            URL unitedNationsURL = new URL(countryURL);

            // Open connection on the URL + cast its response
            HttpURLConnection unitedNationsConnection = (HttpURLConnection)unitedNationsURL.openConnection();

            // Now that it's open, we can set the request method, headers etc:
            unitedNationsConnection.setRequestProperty("accept","application/json");

            // Make the request to open the stream
            InputStream unitedNationsResponse = unitedNationsConnection.getInputStream();

            // Manually Convert the response body InputStream to DataObject_ChildMortality using Jackson library
            ObjectMapper mapper = new ObjectMapper();
            DataObject_WaterSanitation waterSanitation_Country = mapper.readValue(unitedNationsResponse,DataObject_WaterSanitation.class);

            // Display the response:
            System.out.println(waterSanitation_Country.getDataset().getName());

            // Display the child mortality rates:

            // PRINT: Date of obtained value
            List<List<String>> waterSanitationData = waterSanitation_Country.getDataset().getData(); // stores the population data for USA

            // first object is the date: at index 0
            String waterSanitationValues = waterSanitationData.get(0).toString();

            // Display water and sanitation population data:
            String waterPopulationRate = "", sanitationPopulationRate = "";
            waterPopulationRate = waterSanitationValues.substring(13,18);
            System.out.print(" -> Improved Water %: " + waterPopulationRate + "\n");

            sanitationPopulationRate = waterSanitationValues.substring(19,24).replace(']', '0');
            System.out.print(" -> Improved Sanitation %: " + sanitationPopulationRate + "\n");
            System.out.println();
        }
    } // ends waterSanitation_HighestGDP



    /**
     * waterSanitation_LowestGDP
     * - displays the water and sanitation statistics for the countries with the lowest GDP
     */
    private static void waterSanitation_LowestGDP() throws IOException {

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Water and Sanitation Statistics - The countries with the Lowest GDP");
        System.out.println("This dictates the proportion of the population using: \n1. improved drinking water sources\n2. improved sanitation facilities");
        System.out.println("---------------------------------------------------------------------------");
        // create connection

        // gather the urls for the top 5 countries
        String[] urlList = {"https://www.quandl.com/api/v3/datasets/UGID/H2O_COD?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_ETH?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_HTI?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_TZA?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/H2O_ZWE?start_date=2015-12-31&end_date=2015-12-31&api_key=zMyy5kAH2HSPkRRVco4w"};

        // iterate through string list to display the contents:
        for(String countryURL : urlList){

            URL unitedNationsURL = new URL(countryURL);

            // Open connection on the URL + cast its response
            HttpURLConnection unitedNationsConnection = (HttpURLConnection)unitedNationsURL.openConnection();

            // Now that it's open, we can set the request method, headers etc:
            unitedNationsConnection.setRequestProperty("accept","application/json");

            // Make the request to open the stream
            InputStream unitedNationsResponse = unitedNationsConnection.getInputStream();

            // Manually Convert the response body InputStream to DataObject_ChildMortality using Jackson library
            ObjectMapper mapper = new ObjectMapper();
            DataObject_WaterSanitation waterSanitation_Country = mapper.readValue(unitedNationsResponse,DataObject_WaterSanitation.class);

            // Display the response:
            System.out.println(waterSanitation_Country.getDataset().getName());

            // Display the child mortality rates:

            // PRINT: Date of obtained value
            List<List<String>> waterSanitationData = waterSanitation_Country.getDataset().getData(); // stores the population data for USA

            // first object is the date: at index 0
            String waterSanitationValues = waterSanitationData.get(0).toString();

            // Display water and sanitation population data:
            String waterPopulationRate = "", sanitationPopulationRate = "";
            waterPopulationRate = waterSanitationValues.substring(13,18);
            System.out.print(" -> Improved Water %: " + waterPopulationRate + "\n");

            sanitationPopulationRate = waterSanitationValues.substring(19,23);
            System.out.print(" -> Improved Sanitation %: " + sanitationPopulationRate + "\n");
            System.out.println();
        }
    } // ends waterSanitation_LowestGDP
}
////////////////////////////////////////////////////////////////////////////////////////////////////////

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dataset"
})

class DataObject_WaterSanitation {

    @JsonProperty("dataset")
    private Dataset_WaterSanitation dataset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataset")
    public Dataset_WaterSanitation getDataset() {
        return dataset;
    }

    @JsonProperty("dataset")
    public void setDataset(Dataset_WaterSanitation dataset) {
        this.dataset = dataset;
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "dataset_code",
        "database_code",
        "name",
        "description",
        "refreshed_at",
        "newest_available_date",
        "oldest_available_date",
        "column_names",
        "frequency",
        "type",
        "premium",
        "limit",
        "transform",
        "column_index",
        "start_date",
        "end_date",
        "data",
        "collapse",
        "order",
        "database_id"
})
class Dataset_WaterSanitation {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("dataset_code")
    private String datasetCode;
    @JsonProperty("database_code")
    private String databaseCode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("refreshed_at")
    private String refreshedAt;
    @JsonProperty("newest_available_date")
    private String newestAvailableDate;
    @JsonProperty("oldest_available_date")
    private String oldestAvailableDate;
    @JsonProperty("column_names")
    private List<String> columnNames = null;
    @JsonProperty("frequency")
    private String frequency;
    @JsonProperty("type")
    private String type;
    @JsonProperty("premium")
    private Boolean premium;
    @JsonProperty("limit")
    private Object limit;
    @JsonProperty("transform")
    private Object transform;
    @JsonProperty("column_index")
    private Object columnIndex;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("data")
    private List<List<String>> data = null;
    @JsonProperty("collapse")
    private Object collapse;
    @JsonProperty("order")
    private Object order;
    @JsonProperty("database_id")
    private Integer databaseId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("dataset_code")
    public String getDatasetCode() {
        return datasetCode;
    }

    @JsonProperty("dataset_code")
    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    @JsonProperty("database_code")
    public String getDatabaseCode() {
        return databaseCode;
    }

    @JsonProperty("database_code")
    public void setDatabaseCode(String databaseCode) {
        this.databaseCode = databaseCode;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("refreshed_at")
    public String getRefreshedAt() {
        return refreshedAt;
    }

    @JsonProperty("refreshed_at")
    public void setRefreshedAt(String refreshedAt) {
        this.refreshedAt = refreshedAt;
    }

    @JsonProperty("newest_available_date")
    public String getNewestAvailableDate() {
        return newestAvailableDate;
    }

    @JsonProperty("newest_available_date")
    public void setNewestAvailableDate(String newestAvailableDate) {
        this.newestAvailableDate = newestAvailableDate;
    }

    @JsonProperty("oldest_available_date")
    public String getOldestAvailableDate() {
        return oldestAvailableDate;
    }

    @JsonProperty("oldest_available_date")
    public void setOldestAvailableDate(String oldestAvailableDate) {
        this.oldestAvailableDate = oldestAvailableDate;
    }

    @JsonProperty("column_names")
    public List<String> getColumnNames() {
        return columnNames;
    }

    @JsonProperty("column_names")
    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    @JsonProperty("frequency")
    public String getFrequency() {
        return frequency;
    }

    @JsonProperty("frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("premium")
    public Boolean getPremium() {
        return premium;
    }

    @JsonProperty("premium")
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    @JsonProperty("limit")
    public Object getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Object limit) {
        this.limit = limit;
    }

    @JsonProperty("transform")
    public Object getTransform() {
        return transform;
    }

    @JsonProperty("transform")
    public void setTransform(Object transform) {
        this.transform = transform;
    }

    @JsonProperty("column_index")
    public Object getColumnIndex() {
        return columnIndex;
    }

    @JsonProperty("column_index")
    public void setColumnIndex(Object columnIndex) {
        this.columnIndex = columnIndex;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("data")
    public List<List<String>> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<List<String>> data) {
        this.data = data;
    }

    @JsonProperty("collapse")
    public Object getCollapse() {
        return collapse;
    }

    @JsonProperty("collapse")
    public void setCollapse(Object collapse) {
        this.collapse = collapse;
    }

    @JsonProperty("order")
    public Object getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Object order) {
        this.order = order;
    }

    @JsonProperty("database_id")
    public Integer getDatabaseId() {
        return databaseId;
    }

    @JsonProperty("database_id")
    public void setDatabaseId(Integer databaseId) {
        this.databaseId = databaseId;
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

////////////////////////////////////////////////////////////////////////////////////////////////////////
