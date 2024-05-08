package com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ResponseBean extends JsonBean {
    public static final int ERROR = 1;
    public static final int NETWORK_ERROR = 3;
    public static final int OK = 0;
    public static final int PARSE_ERROR = 4;
    public static final int READ_CACHE_ERROR = 6;
    public static final int REQUEST_FAILED = 1;
    public static final int REQUEST_SUCCESS = 0;
    public static final int REQ_PARAM_ERROR = 5;
    public static final int RESPONSE_ERROR = 7;
    public static final int TIMEOUT = 2;

    /* renamed from: a, reason: collision with root package name */
    public int f27620a = 1;

    /* renamed from: b, reason: collision with root package name */
    public a f27621b = a.NORMAL;

    @InstallerNetTransmission
    private int rtnCode;

    @InstallerNetTransmission
    private String rtnDesc;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum a {
        NORMAL,
        NO_NETWORK,
        JSON_ERROR,
        PARAM_ERROR,
        RESPONSE_EXCEPTION,
        IO_EXCEPTION,
        CONNECT_EXCEPTION,
        UNKNOWN_EXCEPTION
    }

    public a getErrCause() {
        return this.f27621b;
    }

    public int getResponseCode() {
        return this.f27620a;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public String getRtnDesc() {
        return this.rtnDesc;
    }

    public void setErrCause(a aVar) {
        this.f27621b = aVar;
    }

    public void setResponseCode(int i10) {
        this.f27620a = i10;
    }

    public void setRtnCode(int i10) {
        this.rtnCode = i10;
    }

    public void setRtnDesc(String str) {
        this.rtnDesc = str;
    }

    public String toString() {
        return "ResponseBean{responseCode=" + this.f27620a + ", rtnCode=" + this.rtnCode + ", rtnDesc='" + this.rtnDesc + "', errCause=" + ((Object) this.f27621b) + '}';
    }
}
