package com.huawei.hms.core.aidl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int i10) {
        if (i10 == 2) {
            return new MessageCodecV2();
        }
        return new MessageCodec();
    }
}
