package com.alibaba.security.realidentity.http.base;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Request {
    public final String body;
    public final String method;
    public final String path;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Builder {
        public String bodyJSON;
        public String method;
        public String path;

        public Builder body(String str) {
            this.bodyJSON = str;
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder method(String str) {
            this.method = str;
            return this;
        }

        public Builder path(String str) {
            this.path = str;
            return this;
        }
    }

    public Request(Builder builder) {
        this.method = builder.method;
        this.path = builder.path;
        this.body = builder.bodyJSON;
    }

    public String body() {
        return this.body;
    }

    public String getBodyJSON() {
        return this.body;
    }

    public String method() {
        return this.method;
    }

    public String path() {
        return this.path;
    }
}
