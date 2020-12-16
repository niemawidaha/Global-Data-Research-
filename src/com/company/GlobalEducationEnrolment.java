package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class GlobalEducationEnrolment {

    public static void main(String[] args) throws IOException {

        // Display education enrollment for worlds highest GDP's:
        educationEnrollment_HighestGDP();

        // VALUE FOR JAPAN MUST BE HARD CODED

        // Display education enrollment for worlds lowest GDP's
        educationEnrollment_LowestGDP();

        // VALUE FOR ZIMBABWE + HAITI + TANZANIA
    }

    /**
     * educationEnrollment_HighestGDP
     * - displays the education enrollment for the worlds highest GDP's
     */
    private static void educationEnrollment_HighestGDP() throws IOException {

        // create connection:
        // database code: UGID
        // item_country: ENROL_USA

        String[] urlList = {"https://www.quandl.com/api/v3/datasets/UGID/ENROL_USA?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                            "https://www.quandl.com/api/v3/datasets/UGID/ENROL_CHN?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                            "https://www.quandl.com/api/v3/datasets/UGID/ENROL_DEU?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                            "https://www.quandl.com/api/v3/datasets/UGID/ENROL_GBR?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w"};

        for(String countryURL : urlList ){

            URL unitedNationsURL = new URL(countryURL);

            // Open connection on the URL + cast the response:
            HttpURLConnection unitedNationsConnection = (HttpURLConnection)unitedNationsURL.openConnection();

            // Now that it's open, we can set the request method, headers etc:
            unitedNationsConnection.setRequestProperty("accept","application/json");

            // Make the request to open the stream:
            InputStream unitedNationsResponse = unitedNationsConnection.getInputStream();

            // Manually Convert the response body InputStream to TradeDataObject using Jackson library
            ObjectMapper mapper = new ObjectMapper();
            TradeDataObject trade_COUNTRY = mapper.readValue(unitedNationsResponse,TradeDataObject.class);

            // Display the response:
            System.out.println(trade_COUNTRY.getDataset_ENROL().getName());

            // PRINT: Date of obtained value
            List<Object> enrollmentUSAData = trade_COUNTRY.getDataset_ENROL().getData(); // stores the population data for USA

            // first object is the date: at index 0
            String enrollmentValues = enrollmentUSAData.get(0).toString();

            char[] populationYearChars = new char[20];
            enrollmentValues.getChars(1,11,populationYearChars,0);

            System.out.print("Most recent recorded date: ");
            System.out.print(populationYearChars);

            // PRINT THE MOST RECENT TOTAL POPULATION EDUCATED:
            char[] totalPopulationEducated = new char[20];
            enrollmentValues.getChars(12,24,totalPopulationEducated,0);
            System.out.print("\nTotal Population Value: ");
            System.out.print(totalPopulationEducated);
            System.out.println("\n");
        } // ends for each
    } // ends educationEnrollment_HighestGDP

    /**
     * educationEnrollment_LowestGDP
     * - displays the education enrollment for the worlds lowest GDP's
     */
    private static void educationEnrollment_LowestGDP() throws IOException {

        // create connection:
        // database code: UGID
        // item_country: ENROL_USA

        String[] urlList = {"https://www.quandl.com/api/v3/datasets/UGID/ENROL_COD?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                "https://www.quandl.com/api/v3/datasets/UGID/ENROL_ETH?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                //"https://www.quandl.com/api/v3/datasets/UGID/ENROL_HTI?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                // "https://www.quandl.com/api/v3/datasets/UGID/ENROL_ZWE?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w",
                // "https://www.quandl.com/api/v3/datasets/UGID/ENROL_TZA?start_date=2014-12-31&end_date=2014-12-31&api_key=zMyy5kAH2HSPkRRVco4w"
        };

        for(String countryURL : urlList ){

            URL unitedNationsURL = new URL(countryURL);

            // Open connection on the URL + cast the response:
            HttpURLConnection unitedNationsConnection = (HttpURLConnection)unitedNationsURL.openConnection();

            // Now that it's open, we can set the request method, headers etc:
            unitedNationsConnection.setRequestProperty("accept","application/json");

            // Make the request to open the stream:
            InputStream unitedNationsResponse = unitedNationsConnection.getInputStream();

            // Manually Convert the response body InputStream to TradeDataObject using Jackson library
            ObjectMapper mapper = new ObjectMapper();
            TradeDataObject trade_COUNTRY = mapper.readValue(unitedNationsResponse,TradeDataObject.class);

            // Display the response:
            System.out.println(trade_COUNTRY.getDataset_ENROL().getName());

            // PRINT: Date of obtained value
            List<Object> enrollmentUSAData = trade_COUNTRY.getDataset_ENROL().getData(); // stores the population data for USA

            // first object is the date: at index 0
            String enrollmentValues = enrollmentUSAData.get(0).toString();

            char[] populationYearChars = new char[20];
            enrollmentValues.getChars(1,11,populationYearChars,0);

            System.out.print("Most recent recorded date: ");
            System.out.print(populationYearChars);

            // PRINT THE MOST RECENT TOTAL POPULATION EDUCATED:
            char[] totalPopulationEducated = new char[20];
            enrollmentValues.getChars(12,24,totalPopulationEducated,0);
            System.out.print("\nTotal Population Value: ");
            System.out.print(totalPopulationEducated);
            System.out.println("\n");
        } // ends for each
    }
} // ends class: GlobalEducationEnrollment
