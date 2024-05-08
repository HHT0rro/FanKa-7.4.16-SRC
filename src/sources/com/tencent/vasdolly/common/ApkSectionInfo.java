package com.tencent.vasdolly.common;

import com.tencent.vasdolly.common.apk.ApkSigningBlockUtils;
import com.tencent.vasdolly.common.apk.SignatureNotFoundException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ApkSectionInfo {
    public static int COPY_CONTENT_MAX_SIZE = 536870912;
    public Pair<ByteBuffer, Long> apkSigningBlock;
    public long apkSize;
    public Pair<ByteBuffer, Long> centralDir;
    public Pair<ByteBuffer, Long> contentEntry;
    public Pair<ByteBuffer, Long> eocd;
    public boolean lowMemory = false;

    public void checkEocdCentralDirOffset() throws SignatureNotFoundException {
        long centralDirOffset = ApkSigningBlockUtils.getCentralDirOffset(this.eocd.getFirst(), this.eocd.getSecond().longValue());
        if (centralDirOffset == this.centralDir.getSecond().longValue()) {
            return;
        }
        throw new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + centralDirOffset + ", centralDirOffset : " + ((Object) this.centralDir.getSecond()));
    }

    public void checkParamters() throws SignatureNotFoundException {
        boolean z10 = this.lowMemory;
        if ((!z10 && this.contentEntry == null) || this.apkSigningBlock == null || this.centralDir == null || this.eocd == null) {
            throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
        }
        if ((z10 || (this.contentEntry.getSecond().longValue() == 0 && ((long) this.contentEntry.getFirst().remaining()) == this.apkSigningBlock.getSecond().longValue())) && ((long) this.apkSigningBlock.getFirst().remaining()) + this.apkSigningBlock.getSecond().longValue() == this.centralDir.getSecond().longValue() && ((long) this.centralDir.getFirst().remaining()) + this.centralDir.getSecond().longValue() == this.eocd.getSecond().longValue() && ((long) this.eocd.getFirst().remaining()) + this.eocd.getSecond().longValue() == this.apkSize) {
            checkEocdCentralDirOffset();
            return;
        }
        throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
    }

    public void rewind() {
        Pair<ByteBuffer, Long> pair = this.contentEntry;
        if (pair != null) {
            pair.getFirst().rewind();
        }
        Pair<ByteBuffer, Long> pair2 = this.apkSigningBlock;
        if (pair2 != null) {
            pair2.getFirst().rewind();
        }
        Pair<ByteBuffer, Long> pair3 = this.centralDir;
        if (pair3 != null) {
            pair3.getFirst().rewind();
        }
        Pair<ByteBuffer, Long> pair4 = this.eocd;
        if (pair4 != null) {
            pair4.getFirst().rewind();
        }
    }

    public String toString() {
        return "lowMemory : " + this.lowMemory + "\n apkSize : " + this.apkSize + "\n contentEntry : " + ((Object) this.contentEntry) + "\n schemeV2Block : " + ((Object) this.apkSigningBlock) + "\n centralDir : " + ((Object) this.centralDir) + "\n eocd : " + ((Object) this.eocd);
    }
}
