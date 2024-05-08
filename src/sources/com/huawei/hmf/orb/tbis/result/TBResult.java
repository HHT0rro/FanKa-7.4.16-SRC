package com.huawei.hmf.orb.tbis.result;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class TBResult {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Callback {
        void onException(String str);

        void onResult(String str);

        void onStreamingResult(String str);
    }

    public abstract Object getValue();
}
