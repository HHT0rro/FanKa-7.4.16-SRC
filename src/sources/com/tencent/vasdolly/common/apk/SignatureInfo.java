package com.tencent.vasdolly.common.apk;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SignatureInfo {
    public final long apkSigningBlockOffset;
    public final long centralDirOffset;
    public final ByteBuffer eocd;
    public final long eocdOffset;
    public final ByteBuffer signatureBlock;

    public SignatureInfo(ByteBuffer byteBuffer, long j10, long j11, long j12, ByteBuffer byteBuffer2) {
        this.signatureBlock = byteBuffer;
        this.apkSigningBlockOffset = j10;
        this.centralDirOffset = j11;
        this.eocdOffset = j12;
        this.eocd = byteBuffer2;
    }
}
