package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ExternalDecodeFactoryManager {

    /* renamed from: a, reason: collision with root package name */
    private static r f43772a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f43773b;

    public static synchronized void a(r rVar) {
        synchronized (ExternalDecodeFactoryManager.class) {
            f43773b = null;
            f43772a = rVar;
        }
    }

    @CalledByNative
    public static synchronized long createH265Decoder() {
        synchronized (ExternalDecodeFactoryManager.class) {
            r rVar = f43772a;
            if (rVar == null) {
                return 0L;
            }
            return rVar.a();
        }
    }

    @CalledByNative
    public static synchronized void destroyH265Decoder(long j10) {
        synchronized (ExternalDecodeFactoryManager.class) {
            r rVar = f43772a;
            if (rVar == null) {
                LiteavLog.w("ExternalDecodeFactoryManager", "DestroyHevcDecoder sDecoderFactory is null: ".concat(String.valueOf(j10)));
            } else {
                rVar.a(j10);
            }
        }
    }

    @CalledByNative
    public static synchronized boolean isExternalDecoderHevcSupport() {
        synchronized (ExternalDecodeFactoryManager.class) {
            r rVar = f43772a;
            if (rVar == null) {
                return false;
            }
            Boolean bool = f43773b;
            if (bool != null) {
                return bool.booleanValue();
            }
            long a10 = rVar.a();
            if (a10 != 0) {
                f43772a.a(a10);
                f43773b = Boolean.TRUE;
            } else {
                f43773b = Boolean.FALSE;
            }
            return f43773b.booleanValue();
        }
    }
}
