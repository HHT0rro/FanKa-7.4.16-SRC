package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface BfUKf {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg {
        public final byte[] data;
        public final int errCode;

        public spXPg(int i10, byte[] bArr) {
            this.errCode = (i10 > 0 || i10 < -9999) ? -1 : i10;
            this.data = bArr;
        }
    }

    spXPg onHttpPost(byte[] bArr);
}
