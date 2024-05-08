package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LinkedHashMapPack {
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public LinkedHashMap<String, String> getAll() {
        return this.map;
    }

    public LinkedHashMapPack put(String str, String str2) {
        if (str != null && str2 != null) {
            this.map.put(str, str2);
        }
        return this;
    }

    public LinkedHashMapPack putIfNotDefault(String str, long j10, long j11) {
        return j10 == j11 ? this : put(str, j10);
    }

    public LinkedHashMapPack put(String str, boolean z10) {
        if (str != null) {
            if (z10) {
                this.map.put(str, "1");
            } else {
                this.map.put(str, "0");
            }
        }
        return this;
    }

    public LinkedHashMapPack put(String str, long j10) {
        if (str != null) {
            this.map.put(str, "" + j10);
        }
        return this;
    }
}
