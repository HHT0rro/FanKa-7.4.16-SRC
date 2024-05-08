package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.f;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class aw {
    private static final String Code = "aw";
    private static final int V = 1;

    public static <RESULT> RESULT Code(Callable<RESULT> callable, long j10, RESULT result) {
        return (RESULT) Code(callable, result, j10, TimeUnit.MILLISECONDS);
    }

    public static <RESULT> RESULT Code(Callable<RESULT> callable, RESULT result) {
        return (RESULT) Code(callable, result, 1L, TimeUnit.SECONDS);
    }

    private static <RESULT> RESULT Code(Callable<RESULT> callable, RESULT result, long j10, TimeUnit timeUnit) {
        String str;
        StringBuilder sb2;
        if (callable == null) {
            return result;
        }
        try {
            return (RESULT) f.Code(callable, f.a.SYNC_CALL).get(j10, timeUnit);
        } catch (InterruptedException e2) {
            e = e2;
            str = Code;
            sb2 = new StringBuilder();
            sb2.append("call ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str, sb2.toString());
            return result;
        } catch (Throwable th) {
            e = th;
            str = Code;
            sb2 = new StringBuilder();
            sb2.append("call ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str, sb2.toString());
            return result;
        }
    }
}
