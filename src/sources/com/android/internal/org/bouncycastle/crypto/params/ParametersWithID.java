package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ParametersWithID implements CipherParameters {

    /* renamed from: id, reason: collision with root package name */
    private byte[] f9229id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters parameters, byte[] id2) {
        this.parameters = parameters;
        this.f9229id = id2;
    }

    public byte[] getID() {
        return this.f9229id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
