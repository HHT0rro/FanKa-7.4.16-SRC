package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.bq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class av implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44565a;

    private av(am amVar) {
        this.f44565a = amVar;
    }

    public static Runnable a(am amVar) {
        return new av(amVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        bq.a aVar = this.f44565a.f44529e;
        if (aVar != null) {
            aVar.onEncodedFail(h.a.ERR_VIDEO_ENCODE_FAIL);
        }
    }
}
