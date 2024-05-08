package com.bytedance.android.live.base.api.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface PushInterceptor {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class InterceptResult {
        public final boolean intercept;
        public final String interceptReason;

        public InterceptResult(boolean z10) {
            this(z10, "");
        }

        public InterceptResult(boolean z10, String str) {
            this.intercept = z10;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
