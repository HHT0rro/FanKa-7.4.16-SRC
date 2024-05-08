package com.xiaomi.push;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class r4 extends n4 {
    public r4() {
        j("PING", null);
        i("0");
        g(0);
    }

    @Override // com.xiaomi.push.n4
    public ByteBuffer e(ByteBuffer byteBuffer) {
        return n().length == 0 ? byteBuffer : super.e(byteBuffer);
    }

    @Override // com.xiaomi.push.n4
    public int s() {
        if (n().length == 0) {
            return 0;
        }
        return super.s();
    }
}
