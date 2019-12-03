package com.oracle.appliaction.mobile.listener;

import com.aliyuncs.exceptions.ClientException;
import com.oracle.appliaction.mobile.SendMobileService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MobileListener implements MessageListener {

    @Autowired
    private SendMobileService sendMobileService;

    // 手机号 + 验证码
    // 111#222
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String[] strs = textMessage.getText().split("#");
            this.sendMobileService.sendMobile(strs[0],strs[1]);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
