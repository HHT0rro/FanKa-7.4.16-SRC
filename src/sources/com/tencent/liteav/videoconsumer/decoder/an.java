package com.tencent.liteav.videoconsumer.decoder;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.liteav.videoconsumer.decoder.e;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class an implements e.d {

    /* renamed from: a, reason: collision with root package name */
    private static final an f43866a = new an();

    private an() {
    }

    public static e.d a() {
        return f43866a;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.e.d
    public final SpsInfo a(boolean z10, ByteBuffer byteBuffer) {
        SpsInfo nativeDecodeSps = SpsInfo.nativeDecodeSps(z10, byteBuffer);
        if (nativeDecodeSps == null) {
            nativeDecodeSps = new SpsInfo();
        }
        if (nativeDecodeSps.width <= 0 || nativeDecodeSps.height <= 0) {
            nativeDecodeSps.width = MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH;
            nativeDecodeSps.height = 1280;
        }
        return nativeDecodeSps;
    }
}
