package com.google.android.exoplayer2.drm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i10, String str) {
        super(str);
        this.errorCode = i10;
    }
}
