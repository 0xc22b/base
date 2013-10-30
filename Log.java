package com.wit.base;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Log {

    public static class LogInfo {

        public String type;
        public boolean isValid;
        public String value;
        public String msg;
        public String subType;
        public String subValue;

        public LogInfo(String type, boolean isValid, String value, String msg) {
            this.type = type;
            this.isValid = isValid;
            this.value = value;
            this.msg = msg;
        }
        
        public LogInfo(String type, boolean isValid, String value, String msg, String subType,
                String subValue) {
            this.type = type;
            this.isValid = isValid;
            this.value = value;
            this.msg = msg;
            this.subType = subType;
            this.subValue = subValue;
        }

        public JSONObject getJSONObject() throws JSONException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(BaseConstants.TYPE, type);
            jsonObject.put(BaseConstants.IS_VALID, isValid);
            jsonObject.put(BaseConstants.VALUE, value);
            jsonObject.put(BaseConstants.MSG, msg);
            jsonObject.put(BaseConstants.SUB_TYPE, subType);
            jsonObject.put(BaseConstants.SUB_VALUE, subValue);
            return jsonObject;
        }
    }

    private ArrayList<LogInfo> logInfoList;

    public Log() {
        logInfoList = new ArrayList<LogInfo>();
    }

    public void addLogInfo(String type, boolean isValid, String value,
            String msg) {
        logInfoList.add(new LogInfo(type, isValid, value, msg));
    }
    
    public void addLogInfo(String type, boolean isValid, String value, String msg, String subType,
            String subValue) {
        logInfoList.add(new LogInfo(type, isValid, value, msg, subType, subValue));
    }

    public boolean isValid() {
        for (LogInfo logInfo : logInfoList) {
            if (logInfo.isValid == false) {
                return false;
            }
        }
        return true;
    }

    public String getJSONString() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (LogInfo logInfo : logInfoList) {
            jsonArray.put(logInfo.getJSONObject());
        }
        return jsonArray.toString();
    }
}
