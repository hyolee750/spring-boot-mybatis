package com.hyolee.user.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JSON日期反序列化
 * Created by Administrator on 2016/6/3.
 */
public class JsonDateDeserializer extends JsonDeserializer<Date>{

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            return FORMAT.parse(jsonParser.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
