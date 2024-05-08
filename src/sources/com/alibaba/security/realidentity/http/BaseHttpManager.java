package com.alibaba.security.realidentity.http;

import android.content.Context;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.build.gw;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseHttpManager implements IHttpManager {
    public static final int CONNECT_TIMEOUT = 10000;
    public static final int DEFAULT_READ_TIMEOUT = 10000;
    public static final String HTTP_REQ_PROPERTY_CHARSET = "Accept-Charset";
    public static final String HTTP_REQ_PROPERTY_CONTENT_LENGTH = "Content-Length";
    public static final String HTTP_REQ_PROPERTY_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_REQ_VALUE_CHARSET = "UTF-8";
    public static final String HTTP_REQ_VALUE_CONTENT_TYPE = "application/json";
    public static final String ONLINE_REQUEST_HOST = "https://cro-dualstack.cn-hangzhou.aliyuncs.com";
    public static final String PRE_REQUEST_HOST = "http://pre-verify-cloud.alibaba-inc.com";
    private gw mSecurityManager;
    private RPEnv mRPEnv = RPEnv.ONLINE;
    private final HeadBuilder mHeadBuilder = new HeadBuilder();

    public Map<String, Object> buildHeaders(Context context, String str, String str2, String str3) {
        return this.mHeadBuilder.buildHeaders(context, str, str2, str3);
    }

    public String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf(47) + 1;
        int length = str.length();
        int lastIndexOf2 = str.lastIndexOf(63);
        if (lastIndexOf2 == -1) {
            lastIndexOf2 = length;
        }
        int lastIndexOf3 = str.lastIndexOf(35);
        if (lastIndexOf3 != -1) {
            length = lastIndexOf3;
        }
        return str.substring(lastIndexOf, Math.min(lastIndexOf2, length));
    }

    public RPEnv getRPEnv() {
        return this.mRPEnv;
    }

    public gw getSecurityManager() {
        return this.mSecurityManager;
    }

    public String getUrl(String str) {
        return (isDailyOrPreEnv() ? PRE_REQUEST_HOST : ONLINE_REQUEST_HOST) + str;
    }

    public void init(gw gwVar, RPEnv rPEnv) {
        this.mSecurityManager = gwVar;
        setRPEnv(rPEnv);
        this.mHeadBuilder.init(gwVar, rPEnv);
    }

    public boolean isDailyOrPreEnv() {
        RPEnv rPEnv = this.mRPEnv;
        return rPEnv == RPEnv.DAILY || rPEnv == RPEnv.PRE;
    }

    public void setRPEnv(RPEnv rPEnv) {
        this.mRPEnv = rPEnv;
        this.mHeadBuilder.setCurEnv(rPEnv);
    }
}
