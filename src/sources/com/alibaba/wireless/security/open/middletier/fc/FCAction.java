package com.alibaba.wireless.security.open.middletier.fc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FCAction {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum FCMainAction {
        SUCCESS,
        FAIL,
        CANCEL,
        RETRY,
        TIMEOUT
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum FCSubAction {
        WUA(1),
        NC(2),
        FL(4),
        LOGIN(8),
        DENY(16);


        /* renamed from: a, reason: collision with root package name */
        private long f4084a;

        FCSubAction(long j10) {
            this.f4084a = j10;
        }

        public long getValue() {
            return this.f4084a;
        }
    }
}
