package io.grpc.internal;

import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InsightBuilder {
    private final ArrayList<String> buffer = new ArrayList<>();

    public InsightBuilder append(Object obj) {
        this.buffer.add(String.valueOf(obj));
        return this;
    }

    public InsightBuilder appendKeyValue(String str, Object obj) {
        this.buffer.add(str + "=" + obj);
        return this;
    }

    public String toString() {
        return this.buffer.toString();
    }
}
