package com.amap.api.col.p0003l;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import java.lang.ref.WeakReference;

/* compiled from: MarkInfoManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ii {

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference<ig> f6459a;

    public static void a(final String str, final Context context) {
        gy.d().submit(new Runnable() { // from class: com.amap.api.col.3l.ii.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (ii.class) {
                    try {
                        String a10 = fq.a(fv.a(String.this));
                        ig a11 = in.a(ii.f6459a);
                        in.a(context, a11, gw.f6171j, 50, AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, "10");
                        if (a11.f6454e == null) {
                            a11.f6454e = new ho(new hr(new hq()));
                        }
                        ih.a(a10, fv.a(" \"timestamp\":\"" + fv.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss") + "\",\"details\":" + String.this), a11);
                    } finally {
                    }
                }
            }
        });
    }
}
