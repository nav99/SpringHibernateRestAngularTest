package com.syncom.services;

import com.syncom.request.RequestObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;

@Component
public class PersistentService {

    public void saveToFile(RequestObject requestObject) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(String.valueOf(Thread.currentThread().getContextClassLoader()
                    .getResource("output.json"))));
            JSONObject jsonObject = (JSONObject) obj;
            if (isInteger(requestObject.getValue())) {
                JSONArray values = (JSONArray) jsonObject.get("integers");
                if (values == null) {
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(Integer.parseInt(requestObject.getValue().toString()));
                    jsonObject.put("integers", jsonArray);
                } else {
                    values.add(requestObject.getValue());
                }
            } else {
                JSONArray values = (JSONArray) jsonObject.get("strings");
                if (values == null) {
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(requestObject.getValue());
                    jsonObject.put("string", jsonArray);
                } else {
                    values.add(requestObject.getValue());
                }
            }

            FileWriter file = new FileWriter(String.valueOf(Thread.currentThread().getContextClassLoader()
                    .getResource("output.json")));
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isInteger(Object value) {
        try {
            Integer.parseInt(value.toString());
            return true;
        } catch (RuntimeException r) {

        }
        return false;
    }
}
