package com.tencent.turingface.sdk.mfa;

import com.tencent.turingface.sdk.mfa.BfUKf;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ITuringNetwork extends BfUKf {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Resp extends BfUKf.spXPg {
        public Resp(int i10, byte[] bArr) {
            super(i10, bArr);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.BfUKf
    /* synthetic */ BfUKf.spXPg onHttpPost(byte[] bArr);

    @Override // com.tencent.turingface.sdk.mfa.BfUKf
    Resp onHttpPost(byte[] bArr);
}
