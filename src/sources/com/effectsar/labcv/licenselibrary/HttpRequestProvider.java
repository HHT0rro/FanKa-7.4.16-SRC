package com.effectsar.labcv.licenselibrary;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface HttpRequestProvider {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class RequestInfo {
        public String url = "";
        public HashMap<String, String> requestHead = new HashMap<>();
        public String bodydata = "";
        public int bodySize = 0;
        public long userdata = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ResponseInfo {
        public boolean isSuc = false;
        public int status_code = 0;
        public HashMap<String, String> responseHead = new HashMap<>();
        public String bodydata = "";
        public int bodySize = 0;
        public long userdata = 0;
    }

    ResponseInfo getRequest(RequestInfo requestInfo);

    ResponseInfo postRequest(RequestInfo requestInfo);
}
