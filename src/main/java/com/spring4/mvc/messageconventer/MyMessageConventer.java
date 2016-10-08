package com.spring4.mvc.messageconventer;/**
 * Created by user on 16/10/6.
 */

import com.spring4.mvc.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author user
 * @create 2016 -10-06 下午2:51
 */

public class MyMessageConventer extends AbstractHttpMessageConverter <DemoObj>{

    public MyMessageConventer(){

        super(new MediaType("application","x-wisely", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {

        return DemoObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {

       String temp = StreamUtils.copyToString(httpInputMessage.getBody(),Charset.forName("UTF-8"));

        String[] tempArr=temp.split("-");

        return new DemoObj(new Long(tempArr[0]),tempArr[1]);
    }

    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        String out="Hello :"+obj.getId()+ "-" +obj.getName();

        httpOutputMessage.getBody().write(out.getBytes());


    }
}
