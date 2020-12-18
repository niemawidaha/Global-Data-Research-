package com.company;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ObjectBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // For testing purposes: I will call the information here:
        initializeData();

    } // ends main method

    public static void initializeData() throws IOException {

        // GDP Per Capita:
        Global_GDP_PerCapita global_GDP = new Global_GDP_PerCapita();

        // Water Sanitation:
        Global_WaterSanitation global_waterSanitation = new Global_WaterSanitation();

        // Internet Penetration:
        Global_InternetPenetration global_internetPenetration = new Global_InternetPenetration();

        // Education Enrollment:
        Global_EducationEnrolment global_educationEnrolment = new Global_EducationEnrolment();

        // Child Mortality:
        Global_ChildMortality global_childMortality = new Global_ChildMortality();

        // Currency Reserves:
        Global_CurrencyReserves global_currencyReserves = new Global_CurrencyReserves();

        // External Debt:
        Global_ExternalDebt global_externalDebt = new Global_ExternalDebt();

    }

} // ends main class
