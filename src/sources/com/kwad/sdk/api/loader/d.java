package com.kwad.sdk.api.loader;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private static d amc;
    private Thread.UncaughtExceptionHandler amd;
    private int ame;
    private long amg;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean amf = new AtomicBoolean();

    private d(Context context) {
        this.mContext = context;
    }

    public static d ay(Context context) {
        if (amc == null) {
            synchronized (d.class) {
                if (amc == null) {
                    amc = new d(context);
                }
            }
        }
        return amc;
    }

    public final void bW(int i10) {
        this.amg = System.currentTimeMillis();
        this.ame = i10;
    }

    public final void cancel() {
        this.amf.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.amd = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                StringBuilder sb2 = new StringBuilder("AutoRevertHandler uncaughtException, mStartCheckTime:");
                sb2.append(this.amg);
                sb2.append(",mMaxDuration:");
                sb2.append(this.ame);
                sb2.append(",mIsCancel:");
                sb2.append(this.amf.get());
            }
            if (!this.amf.get() && this.amg > 0 && System.currentTimeMillis() - this.amg <= this.ame) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.f("filterStack", th);
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && booleanValue) {
                    t.a(context, g.amm, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.amd;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.amd;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.amd != null) {
                    this.amd.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }
}
