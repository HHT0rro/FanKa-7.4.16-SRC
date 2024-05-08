package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.build.h;
import com.alibaba.security.biometrics.build.k;
import com.alibaba.security.biometrics.build.l;
import com.alibaba.security.biometrics.build.m;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.utils.LocalBroadcastManagerUtils;
import com.android.internal.os.PowerProfile;
import com.huawei.openalliance.ad.constant.u;

@m(a = 7)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AudioSettingComponent extends h {

    /* renamed from: d, reason: collision with root package name */
    public boolean f2419d;

    /* renamed from: e, reason: collision with root package name */
    public AudioManager f2420e;

    /* renamed from: f, reason: collision with root package name */
    private SoundBroadCastReceiver f2421f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class SoundBroadCastReceiver extends BroadcastReceiver {
        public SoundBroadCastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d10 = AudioSettingComponent.this.d();
            AudioSettingComponent.this.f2419d = d10 == 0;
            ((k) l.a(k.class)).a(AudioSettingComponent.this.f2419d);
        }
    }

    private boolean e() {
        return this.f2419d;
    }

    private void f() {
        try {
            this.f2420e.setRingerMode(2);
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean b() {
        if (this.f2421f != null) {
            try {
                LocalBroadcastManagerUtils.getInstance(this.f2302c).unregisterReceiver(this.f2421f);
            } catch (Throwable unused) {
            }
            this.f2421f = null;
        }
        return super.b();
    }

    public final int d() {
        try {
            AudioManager audioManager = this.f2420e;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        this.f2420e = (AudioManager) activity.getSystemService(PowerProfile.POWER_AUDIO);
        int d10 = d();
        boolean z10 = this.f2301b.soundOn;
        this.f2419d = true;
        if (d10 == 0) {
            this.f2419d = true;
        } else if (z10) {
            this.f2419d = false;
        }
        activity.setVolumeControlStream(3);
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a() {
        if (this.f2421f == null) {
            this.f2421f = new SoundBroadCastReceiver();
            LocalBroadcastManagerUtils.getInstance(this.f2302c).registerReceiver(this.f2421f, new IntentFilter(u.f32364ca));
        }
        return super.a();
    }

    private void a(boolean z10) {
        this.f2419d = z10;
    }

    private void a(Activity activity) {
        int d10 = d();
        boolean z10 = this.f2301b.soundOn;
        this.f2419d = true;
        if (d10 == 0) {
            this.f2419d = true;
        } else if (z10) {
            this.f2419d = false;
        }
        activity.setVolumeControlStream(3);
    }
}
