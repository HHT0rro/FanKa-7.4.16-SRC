package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.android.internal.os.PowerProfile;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ir {
    public static final float Code = -1.0f;
    private static final String I = "android.media.VOLUME_CHANGED_ACTION";
    private static final String V = "VolumeChangeObserver";
    private static final String Z = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private b B;
    private a C;
    private boolean D = false;
    private AudioManager F;
    private Context S;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends BroadcastReceiver {
        private WeakReference<ir> Code;

        public a(ir irVar) {
            this.Code = new WeakReference<>(irVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ir irVar;
            b I;
            try {
                if (!(("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra(ir.Z, 0) == 3) || intent.getIntExtra(ir.Z, 0) == 1) || (irVar = this.Code.get()) == null || (I = irVar.I()) == null) {
                    return;
                }
                I.Code();
            } catch (Throwable th) {
                gl.I(ir.V, "onReceive error:" + th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void Code();
    }

    public ir(Context context) {
        this.S = context;
        this.F = (AudioManager) context.getApplicationContext().getSystemService(PowerProfile.POWER_AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b I() {
        return this.B;
    }

    public float Code(boolean z10) {
        AudioManager audioManager = this.F;
        if (audioManager != null) {
            return is.Code(audioManager, z10);
        }
        return 0.0f;
    }

    public void Code() {
        if (this.C == null) {
            this.C = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            try {
                this.S.registerReceiver(this.C, intentFilter);
            } catch (Exception e2) {
                gl.V(V, "registerReceiver, " + e2.getClass().getSimpleName());
            }
            this.D = true;
        }
    }

    public void Code(b bVar) {
        this.B = bVar;
    }

    public void V() {
        if (this.D) {
            try {
                this.S.unregisterReceiver(this.C);
            } catch (Exception e2) {
                gl.V(V, "unregisterReceiver, " + e2.getClass().getSimpleName());
            }
            this.B = null;
            this.D = false;
        }
    }
}
