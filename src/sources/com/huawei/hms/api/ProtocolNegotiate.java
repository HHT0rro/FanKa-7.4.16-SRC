package com.huawei.hms.api;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ProtocolNegotiate {
    private static final int MAX_VERSION = 2;
    private static ProtocolNegotiate instance = new ProtocolNegotiate();
    private int version = 1;

    public static ProtocolNegotiate getInstance() {
        return instance;
    }

    public int getVersion() {
        return this.version;
    }

    public int negotiate(List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            if (!list.contains(2)) {
                this.version = list.get(list.size() - 1).intValue();
            } else {
                this.version = 2;
            }
            return this.version;
        }
        this.version = 1;
        return 1;
    }
}
