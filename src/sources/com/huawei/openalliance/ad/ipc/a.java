package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.utils.ba;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {
    private static final int Code = 60000;
    private static final String I = "Monitor";
    private static final String V = "unbindTask";
    private final String B = V + hashCode();
    private int C = 0;
    private Context F;
    private String S;
    private InterfaceC0335a Z;

    /* renamed from: com.huawei.openalliance.ad.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0335a {
        void Code();
    }

    public a(Context context, String str, InterfaceC0335a interfaceC0335a) {
        this.F = context.getApplicationContext();
        this.S = str;
        this.Z = interfaceC0335a;
    }

    private int B() {
        return TextUtils.equals(u.co, this.F.getPackageName()) ? 0 : 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        gl.V(Z(), "unbindService");
        try {
            this.Z.Code();
        } catch (Throwable th) {
            gl.I(I, "unbindService err: %s", th.getClass().getSimpleName());
        }
    }

    private String Z() {
        return "Monitor_" + this.S;
    }

    public Context Code() {
        return this.F;
    }

    public synchronized void I() {
        int i10 = this.C - 1;
        this.C = i10;
        if (i10 < 0) {
            this.C = 0;
        }
        gl.Code(Z(), "dec count: %d", Integer.valueOf(this.C));
        if (this.C <= 0) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.C();
                }
            }, this.B, B());
        }
    }

    public synchronized void V() {
        this.C++;
        ba.Code(this.B);
        gl.V(Z(), "inc count: " + this.C);
    }
}
