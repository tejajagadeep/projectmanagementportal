//package com.cts.projectmanagementportalbackend.Security;
//
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
//@Configuration
//public class MVCProperties extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.serializerByType(String.class, new ToStringSerializer());
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(builder.build());
//        converters.add(converter);
//    }
//}