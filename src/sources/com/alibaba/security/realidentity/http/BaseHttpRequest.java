package com.alibaba.security.realidentity.http;

import com.alibaba.security.common.json.annotation.RPJSONField;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.build.aq;
import com.alibaba.security.realidentity.build.hj;
import com.alibaba.security.realidentity.build.i;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BaseHttpRequest extends HttpRequest {

    @RPJSONField(name = aq.f3110f)
    private ClientInfo clientInfo;

    @RPJSONField(name = aq.f3108d)
    private String verifyToken;

    public BaseHttpRequest(String str) {
        this.verifyToken = str;
        ClientInfo clientInfo = new ClientInfo();
        this.clientInfo = clientInfo;
        clientInfo.setClientType(GrsBaseInfo.CountryCodeSource.APP);
        this.clientInfo.setAppInfo(hj.a(str));
        this.clientInfo.setDeviceInfo(hj.a());
        this.clientInfo.setNetWorkInfo(hj.b(str));
        i.a(str);
        i.b(JsonUtils.toJSON(this.clientInfo));
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }
}
