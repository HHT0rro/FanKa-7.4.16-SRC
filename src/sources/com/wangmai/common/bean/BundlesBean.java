package com.wangmai.common.bean;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BundlesBean {
    public Map<String, String> packageName;

    public Map<String, String> getPackageName() {
        return this.packageName;
    }

    public void setPackageName(Map<String, String> map) {
        this.packageName = map;
    }

    public String toString() {
        return "BundlesBean{packageName=" + ((Object) this.packageName) + '}';
    }
}
