package edu.jsu.mcis;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter {
    
    /*
    
        Consider the following CSV data:
        
        "ID","Total","Assignment 1","Assignment 2","Exam 1"
        "111278","611","146","128","337"
        "111352","867","227","228","412"
        "111373","461","96","90","275"
        "111305","835","220","217","398"
        "111399","898","226","229","443"
        "111160","454","77","125","252"
        "111276","579","130","111","338"
        "111241","973","236","237","500"
        
        The corresponding JSON data would be similar to the following (tabs and
        other whitespace have been added for clarity).  Note the curly braces,
        square brackets, and double-quotes!  These indicate which values should
        be encoded as strings, and which values should be encoded as integers!
        
        {
            "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"],
            "rowHeaders":["111278","111352","111373","111305","111399","111160",
            "111276","111241"],
            "data":[[611,146,128,337],
                    [867,227,228,412],
                    [461,96,90,275],
                    [835,220,217,398],
                    [898,226,229,443],
                    [454,77,125,252],
                    [579,130,111,338],
                    [973,236,237,500]
            ]
        }
    
        Your task for this program is to complete the two conversion methods in
        this class, "csvToJson()" and "jsonToCsv()", so that the CSV data shown
        above can be converted to JSON format, and vice-versa.  Both methods
        should return the converted data as strings, but the strings do not need
        to include the newlines and whitespace shown in the examples; again,
        this whitespace has been added only for clarity.
    
        NOTE: YOU SHOULD NOT WRITE ANY CODE WHICH MANUALLY COMPOSES THE OUTPUT
        STRINGS!!!  Leave ALL string conversion to the two data conversion
        libraries we have discussed, OpenCSV and json-simple.  See the "Data
        Exchange" lecture notes for more details, including example code.
    
    */
    
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {
        
        String results = "";
        
        try {
            
            CSVReader reader = new CSVReader(new StringReader(csvString));
            List<String[]> full = reader.readAll();
            Iterator<String[]> iterator = full.iterator();
            
            // INSERT YOUR CODE HERE
            LinkedHashMap<String,Object> jsonObject = new LinkedHashMap<>();
            jsonObject = new LinkedHashMap<>();
            
            String[] first = iterator.next();
            JSONArray colHeaders = new JSONArray();
            JSONArray rowHeaders = new JSONArray();
            JSONArray data = new JSONArray();
            
            String[]record;
            String[]headings;
            JSONArray dataRow;
            String jsonString = "";
            
            for(int i = 0; i< first.length; ++i) {
                String field = first[i];
                colHeaders.add(field);
            }
            
            while(iterator.hasNext()) {
                first = iterator.next();
                rowHeaders.add(first[0]);
                dataRow = new JSONArray();
                
                for(int i =1; i<first.length; ++i) {
                    dataRow.add(Integer.parseInt(first[i]));
                }
                data.add(dataRow);
                jsonObject.put("colHeaders", "colHeaders");
                jsonObject.put("data", "data");
                jsonObject.put("colHeaders", "colHeaders");
                jsonString = JSONValue.toJSONString(jsonObject);
                results += jsonString;
            }  
        }        
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }
    
    public static String jsonToCsv(String jsonString) {
        
        String results = "";
        
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(jsonString);

            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer, ',', '"', '\n');
            
            // INSERT YOUR CODE HERE
            ArrayList<String> colHeaders = (ArrayList<String>) jsonObject.get("colHeaders");
            
            ArrayList<String> rowHeaders = (ArrayList<String>) jsonObject.get("rowHeaders");
            ArrayList data = (ArrayList) jsonObject.get("data");
            
            
            String[] colHeads = new String[colHeaders.size()];
            ArrayList dataRow;
            
            
            
            for(int i=0; i < colHeaders.size(); ++i){
                
                colHeads[i] = (String)colHeaders.get(i);
                
            }
            
            //Parse Data using csvwriter
            csvWriter.writeNext(colHeads);
            
            
            for(int i = 0; i < rowHeaders.size(); ++i){
                
                String[] rowAndData = new String[colHeaders.size()];
                
                //ROW HEADERS.
                
                rowAndData[0] = rowHeaders.get(i);
                
                
                
                dataRow = (ArrayList)data.get(i);
                for(int j = 0; j < dataRow.size(); ++j){
                    //DATA FOR EACH ROW. 
                    rowAndData[j+1] = Long.toString((Long)dataRow.get(j));
                    
                }
                
                //Parse Data using csvwriter
                
                csvWriter.writeNext(rowAndData);
            
            }
            
            results+=writer.toString();
            
        }
        
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }

}