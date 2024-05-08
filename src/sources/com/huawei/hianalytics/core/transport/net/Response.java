package com.huawei.hianalytics.core.transport.net;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Response {
    public String content;
    public int httpCode;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Code {
        public static final int BACKUP_ADDRESS_INVALID = -107;
        public static final int CONNECTION_ERROR = -103;
        public static final int EMPTY_URL = -100;
        public static final int HOST_ERROR = -104;
        public static final int INTERNET_PERMISSION_ERROR = -101;
        public static final int PTAH_ERROR = 404;
        public static final int SSL_CONFIG_ERROR = -105;
        public static final int SSL_VALIDATION_ERROR = -106;
        public static final int TIMEOUT_OR_OTHER_ERROR = -102;
    }

    public Response(int i10, String str) {
        this.httpCode = i10;
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setHttpCode(int i10) {
        this.httpCode = i10;
    }
}
