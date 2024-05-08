package com.jd.ad.sdk.jad_kv;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cn {
    public boolean jad_an;
    public final Handler jad_bo = new Handler(Looper.getMainLooper(), new jad_an());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_an implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((jad_xk) message.obj).jad_dq();
            return true;
        }
    }

    public synchronized void jad_an(jad_xk<?> jad_xkVar, boolean z10) {
        if (!this.jad_an && !z10) {
            this.jad_an = true;
            jad_xkVar.jad_dq();
            this.jad_an = false;
        }
        this.jad_bo.obtainMessage(1, jad_xkVar).sendToTarget();
    }
}
