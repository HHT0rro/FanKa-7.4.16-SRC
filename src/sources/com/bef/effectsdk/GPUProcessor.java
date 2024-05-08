package com.bef.effectsdk;

import com.bef.effectsdk.message.MessageCenter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GPUProcessor {
    private static Listener sListener;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface Listener {
        void onMessageReceived(int i10, int i11, int i12, String str);
    }

    public static void destroy() {
        MessageCenter.c();
        sListener = null;
    }

    public static void init() {
        MessageCenter.e();
        MessageCenter.g(new MessageCenter.a() { // from class: com.bef.effectsdk.GPUProcessor.1
            @Override // com.bef.effectsdk.message.MessageCenter.a
            public void onMessageReceived(int i10, int i11, int i12, String str) {
                if (GPUProcessor.sListener != null) {
                    GPUProcessor.sListener.onMessageReceived(i10, i11, i12, str);
                }
            }
        });
    }

    public static void setListener(Listener listener) {
        sListener = listener;
    }
}
