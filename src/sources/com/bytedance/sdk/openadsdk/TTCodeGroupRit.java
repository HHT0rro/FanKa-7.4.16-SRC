package com.bytedance.sdk.openadsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TTCodeGroupRit {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface TTCodeGroupRitListener {
        void onFail(int i10, String str);

        void onSuccess(TTCodeGroupRit tTCodeGroupRit);
    }

    String getRit();

    int getSlotType();
}
