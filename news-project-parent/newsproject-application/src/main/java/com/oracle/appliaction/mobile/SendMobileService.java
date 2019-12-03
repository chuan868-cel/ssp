package com.oracle.appliaction.mobile;

import com.aliyuncs.exceptions.ClientException;

public interface SendMobileService {

    void sendMobile(String mobile, String code) throws ClientException;
}
