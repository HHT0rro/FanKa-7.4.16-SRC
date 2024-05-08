package com.bytedance.sdk.openadsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TTAdDislike {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i10, String str, boolean z10);

        void onShow();
    }

    boolean isShow();

    void resetDislikeStatus();

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeSource(String str);

    void showDislikeDialog();
}
