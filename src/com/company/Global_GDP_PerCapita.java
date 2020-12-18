package com.company;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Global_GDP_PerCapita {

    public Global_GDP_PerCapita() throws IOException {
        calculateGDP();
    }

    public static void calculateGDP() throws IOException {
        // GDP FOR all countries: top 5 and lowest 5 GDPs
        GDP();
    }

    /**
     * GDP(): Retreives the GDP for the countries with the highest and lowest GDP's
     */
    public static void GDP() throws IOException {
        // https://www.quandl.com/api/v3/datasets/UNAE/GDPKD_GBR?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("GDP - The countries with the Highest + Lowest GDP");
            System.out.println("Gross Domestic Product");
            System.out.println("---------------------------------------------------------------------------");
            // create connection

            // gather the urls for the top 5 countries
            String[] urlList = {"https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_USA?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_CHN?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_JPN?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_DEU?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_GBR?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_COD?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    //"https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_TZA?start_date=2000-12-31&end_date=2000-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_ETH?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_HTI?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                    "https://www.quandl.com/api/v3/datasets/UNAE/GDPCDPC_ZWE?start_date=2018-12-31&end_date=2018-12-31&api_key=zMyy5kAH2HSPkRRVco4w"};

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
                DataObject_GDPPerCapita GDP_Country = mapper.readValue(unitedNationsResponse,DataObject_GDPPerCapita.class);

                // Display the response:
                System.out.println(GDP_Country.getDataset().getName());

                // Display the child mortality rates:

                // PRINT: Date of obtained value
                List<List<String>> GDP_Data = GDP_Country.getDataset().getData(); // stores the population data for USA

                // first object is the date: at index 0
                String GDP_Value = GDP_Data.get(0).toString();


                // Display water and sanitation population data:
                String GDP = "";
                GDP = GDP_Value.substring(13,20).replace(']','0');
                if(GDP.contains("null")){
                    System.out.println("The value for this doesn't exist in the United Nations Database");
                    System.out.println();
                } else {
                    System.out.print(" -> GDP based on USD: $ " + GDP + "\n");
                    System.out.println();
                }
            }
    }


}
////////////////////////////////////////////////////////////////////////////////////////////////////////

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dataset"
})
class DataObject_GDPPerCapita {

    @JsonProperty("dataset")
    private Dataset_GDPPerCapita dataset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataset")
    public Dataset_GDPPerCapita getDataset() {
        return dataset;
    }

    @JsonProperty("dataset")
    public void setDataset(Dataset_GDPPerCapita dataset) {
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
class Dataset_GDPPerCapita {

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
