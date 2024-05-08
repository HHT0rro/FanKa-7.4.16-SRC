package com.wangmai.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GsonUtils {
    public static final String TAG = "GsonUtils";
    public static volatile GsonUtils gsonUtils;
    public Gson gson;

    public GsonUtils() {
        if (this.gson == null) {
            this.gson = new Gson();
        }
    }

    public static GsonUtils getInstance() {
        if (gsonUtils == null) {
            synchronized (GsonUtils.class) {
                if (gsonUtils == null) {
                    gsonUtils = new GsonUtils();
                }
            }
        }
        return gsonUtils;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        try {
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return (T) this.gson.fromJson(str, (Class) cls);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fromJson error：");
            sb2.append(th.toString());
            return null;
        }
    }

    public String toJson(Object obj) {
        try {
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return this.gson.toJson(obj);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("toJson error：");
            sb2.append(th.toString());
            return "";
        }
    }

    public <T> T fromJson(String str, TypeToken typeToken) {
        try {
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return (T) this.gson.fromJson(str, typeToken.getType());
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fromJson error：");
            sb2.append(th.toString());
            return null;
        }
    }
}
