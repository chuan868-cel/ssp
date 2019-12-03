package com.oracle.search.service.listener;

import com.oracel.search.api.SearchApi;
import com.oracle.search.service.impl.IndexServiceApi;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @ClassName:SolrIndexListener
 * @Author : chuan
 * @Date : 2019/7/29 20:24
 * @Version : 1.0
 **/

public class SolrIndexListener implements MessageListener {


    @Autowired
    private IndexServiceApi indexServiceApi;


    @Override
    public void onMessage(Message message) {
        //异步
        TextMessage textMessage = (TextMessage) message;
        try {
            this.indexServiceApi.addIndex(Integer.parseInt(textMessage.getText()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}