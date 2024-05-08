package com.amap.api.col.p0003l;

import com.amap.api.services.core.AMapException;

/* compiled from: AMapException.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fa extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f5697a;

    /* renamed from: b, reason: collision with root package name */
    private int f5698b;

    public fa(String str) {
        super(str);
        this.f5698b = 1000;
        this.f5697a = str;
        a(str);
    }

    public final String a() {
        return this.f5697a;
    }

    private void a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.f5698b = 1001;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_KEY.equals(str)) {
            this.f5698b = 1002;
            return;
        }
        if (AMapException.AMAP_SERVICE_NOT_AVAILBALE.equals(str)) {
            this.f5698b = 1003;
            return;
        }
        if (AMapException.AMAP_DAILY_QUERY_OVER_LIMIT.equals(str)) {
            this.f5698b = 1004;
            return;
        }
        if (AMapException.AMAP_ACCESS_TOO_FREQUENT.equals(str)) {
            this.f5698b = 1005;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_IP.equals(str)) {
            this.f5698b = 1006;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_DOMAIN.equals(str)) {
            this.f5698b = 1007;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_SCODE.equals(str)) {
            this.f5698b = 1008;
            return;
        }
        if (AMapException.AMAP_USERKEY_PLAT_NOMATCH.equals(str)) {
            this.f5698b = 1009;
            return;
        }
        if (AMapException.AMAP_IP_QUERY_OVER_LIMIT.equals(str)) {
            this.f5698b = 1010;
            return;
        }
        if (AMapException.AMAP_NOT_SUPPORT_HTTPS.equals(str)) {
            this.f5698b = 1011;
            return;
        }
        if (AMapException.AMAP_INSUFFICIENT_PRIVILEGES.equals(str)) {
            this.f5698b = 1012;
            return;
        }
        if (AMapException.AMAP_USER_KEY_RECYCLED.equals(str)) {
            this.f5698b = 1013;
            return;
        }
        if (AMapException.AMAP_ENGINE_RESPONSE_ERROR.equals(str)) {
            this.f5698b = 1100;
            return;
        }
        if (AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str)) {
            this.f5698b = 1101;
            return;
        }
        if (AMapException.AMAP_ENGINE_CONNECT_TIMEOUT.equals(str)) {
            this.f5698b = 1102;
            return;
        }
        if (AMapException.AMAP_ENGINE_RETURN_TIMEOUT.equals(str)) {
            this.f5698b = 1103;
            return;
        }
        if (AMapException.AMAP_SERVICE_INVALID_PARAMS.equals(str)) {
            this.f5698b = 1200;
            return;
        }
        if (AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str)) {
            this.f5698b = 1201;
            return;
        }
        if (AMapException.AMAP_SERVICE_ILLEGAL_REQUEST.equals(str)) {
            this.f5698b = 1202;
            return;
        }
        if (AMapException.AMAP_SERVICE_UNKNOWN_ERROR.equals(str)) {
            this.f5698b = 1203;
            return;
        }
        if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f5698b = AMapException.CODE_AMAP_CLIENT_ERROR_PROTOCOL;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f5698b = AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION;
            return;
        }
        if ("url异常 - MalformedURLException".equals(str)) {
            this.f5698b = AMapException.CODE_AMAP_CLIENT_URL_EXCEPTION;
            return;
        }
        if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f5698b = AMapException.CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION;
            return;
        }
        if (AMapException.AMAP_CLIENT_UNKNOWN_ERROR.equals(str)) {
            this.f5698b = 1900;
            return;
        }
        if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f5698b = 1901;
            return;
        }
        if (AMapException.AMAP_CLIENT_NETWORK_EXCEPTION.equals(str)) {
            this.f5698b = 1806;
            return;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f5698b = 1902;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f5698b = 1903;
        } else {
            this.f5698b = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        }
    }

    public fa() {
        this.f5697a = "";
        this.f5698b = 1000;
    }
}
