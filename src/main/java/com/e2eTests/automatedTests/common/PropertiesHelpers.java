package com.e2eTests.automatedTests.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
        //import lombok.Getter;

public class PropertiesHelpers {


    private static Logger logger = Logger.getLogger(PropertiesHelpers.class);
    //@Getter
    private static Properties properties;

    private static String PROFILE_PATH_PROPERTY_FILE_PATTERN = "src/test/resources/profiles/recette/profile.properties";
    private static String DATA_PROPERTY_FILE = "src/test/resources/DataProvider/";
    //private static String ASSERT_ERROR_PROPERTY_FILE = "assert-error-message.properties";


    // **********************************************************************
    // Load properties files as a single java.util.Property object
    // **********************************************************************
    /**
     * Load the properties files related to the Maven profile configured in pom.xml or the profile value from command line <i>(mvn test –P profile)</i>
     * @return A {@link Properties} object where all data from the properties files are stored
     */
    public static Properties loadPropertiesFile() {
        return loadPropertiesFile(null);
    }

    /**
     * Load the properties files related to the given Maven profile in parameter
     * @param profile Specific Maven profile to use
     * @return A {@link Properties} object where all data from the properties files are stored
     */
    public static Properties loadPropertiesFile(String profile) {
        String propertiesFilePath = "";


        if (StringUtils.isBlank(profile)) {
            propertiesFilePath = System.getProperty("propertiesFilePath");
        } else {
            propertiesFilePath = StringUtils.replace(PROFILE_PATH_PROPERTY_FILE_PATTERN, "{profile}", profile);
        }

        logger.info("propertiesFilePath: " + propertiesFilePath);

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        logger.info("rootPath: " + rootPath);

        try {
            properties = new Properties();

            // Load environment specific properties files      
            FileInputStream in = new FileInputStream(propertiesFilePath);
            properties.load(new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)));

            // Load data properties files           
            File folder = new File(DATA_PROPERTY_FILE);
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                	in = new FileInputStream(file);
                    properties.load(new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)));
                }
            }  
            
            // Load the common assert error messages properties file
            /*in = new FileInputStream(rootPath + ASSERT_ERROR_PROPERTY_FILE);
            properties.load(new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)));*/

            return properties;
        } catch (IOException e) {
            logger.error("An error has occured when trying to load the properties file from profile", e);
        }
        return null;
    }
    
    // **********************************************************************
    // Load browserConfig file
    // **********************************************************************
    public static Properties LoadBrowserFile(String FileName) throws IOException {
    	
        FileInputStream in = new FileInputStream("src/test/resources/browserConfig/"+FileName);
        properties.load(new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)));
    	
    	return properties;
    }

    // **********************************************************************
    // Get property
    // **********************************************************************
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    // **********************************************************************
    // Set property
    // **********************************************************************
    public static void setProperty(String key, String value) {
         properties.setProperty(key, value);
    }

    
    // **********************************************************************
    // Format keys
    // **********************************************************************
    /**
     * Generate a new string where:<br/>
     * <ul>
     * <li>all accents are removed</li>
     * <li>convert all characters to lowercase</li>
     * <li>convert space characters to underscore</li>
     * </ul>
     * @param param
     * @return
     */
    public static String toLowerCaseAndStripAccentsAndReplaceSpaces(String param) {
        return StringUtils.stripAccents(param).toLowerCase().replace(" ", "_");
    }

    public static String formatKeyAndConcat(String param, String stringToConcat, boolean addAtTheEnd) {
        String result = toLowerCaseAndStripAccentsAndReplaceSpaces(param);
        if (addAtTheEnd) {
            return result.concat(stringToConcat);
        } else {
            return stringToConcat.concat(result);
        }
    }
}