package com.aircos.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Date2UnixTimestampSerializer Json序列化生成器
 *
 * @author 龚国玮
 */
public class Date2UnixTimestampSerializer extends JsonSerializer {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Date value = (Date) o;
        jsonGenerator.writeNumber(value.getTime() / 1000);
    }

}