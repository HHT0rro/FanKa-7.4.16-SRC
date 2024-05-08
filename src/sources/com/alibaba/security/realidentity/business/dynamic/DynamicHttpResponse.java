package com.alibaba.security.realidentity.business.dynamic;

import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DynamicHttpResponse extends HttpResponse {
    private int code;
    private Data data;
    private String msg;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Data implements Serializable {
        private String data;

        public String getData() {
            return this.data;
        }

        public void setData(String str) {
            this.data = str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DataConfig implements Serializable {
        private Map<String, Object> config;
        private String domain;

        public Map<String, Object> getConfig() {
            return this.config;
        }

        public String getDomain() {
            return this.domain;
        }

        public void setConfig(Map<String, Object> map) {
            this.config = map;
        }

        public void setDomain(String str) {
            this.domain = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override // com.alibaba.security.realidentity.http.model.HttpResponse
    public boolean isSuccessful() {
        return this.code == 200;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
