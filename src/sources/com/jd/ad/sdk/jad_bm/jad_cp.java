package com.jd.ad.sdk.jad_bm;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ep.jad_jw;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_cp<Z> extends com.jd.ad.sdk.jad_bm.jad_an<Z> {
    public static final Handler jad_er = new Handler(Looper.getMainLooper(), new jad_an());
    public final jad_jw jad_dq;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            jad_cp jad_cpVar = (jad_cp) message.obj;
            jad_cpVar.jad_dq.jad_an(jad_cpVar);
            return true;
        }
    }

    public jad_cp(jad_jw jad_jwVar, int i10, int i11) {
        super(i10, i11);
        this.jad_dq = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public void jad_an(@Nullable Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public void jad_an(@NonNull Z z10, @Nullable com.jd.ad.sdk.jad_en.jad_bo<? super Z> jad_boVar) {
        com.jd.ad.sdk.jad_al.jad_dq jad_dqVar = this.jad_cp;
        if (jad_dqVar == null || !jad_dqVar.jad_cp()) {
            return;
        }
        jad_er.obtainMessage(1, this).sendToTarget();
    }
}
