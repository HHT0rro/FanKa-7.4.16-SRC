package com.tencent.liteav.audio.earmonitor;

import android.content.Context;
import android.media.AudioManager;
import com.android.internal.os.PowerProfile;
import com.tencent.liteav.audio.LiteavAudioTrack;
import com.tencent.liteav.base.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i extends SystemAudioKit {

    /* renamed from: a, reason: collision with root package name */
    private final AudioManager f42658a;

    /* renamed from: b, reason: collision with root package name */
    private a f42659b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f42660a = false;

        /* renamed from: b, reason: collision with root package name */
        private final SystemAudioKit f42661b;

        public a(SystemAudioKit systemAudioKit) {
            this.f42661b = systemAudioKit;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            LiteavAudioTrack liteavAudioTrack = new LiteavAudioTrack();
            liteavAudioTrack.startPlayout(3, 48000, 12, 3840, false);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(3840);
            byte[] bArr = new byte[3840];
            Arrays.fill(bArr, (byte) 0);
            allocateDirect.put(bArr);
            while (!this.f42660a && !isInterrupted()) {
                try {
                    liteavAudioTrack.write(allocateDirect, 0, 3840, 1);
                } catch (Exception unused) {
                    this.f42661b.notifySystemError(this.f42661b);
                }
            }
            liteavAudioTrack.stopPlayout();
        }
    }

    public i(long j10, Context context) {
        super(j10);
        this.f42658a = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
    }

    private boolean a() {
        try {
            String parameters = this.f42658a.getParameters("vivo_ktv_mic_type");
            if (parameters == null) {
                return false;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(parameters, "=");
            if (stringTokenizer.countTokens() != 2 || !stringTokenizer.nextToken().equals("vivo_ktv_mic_type")) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                return parseInt == 0 || parseInt == 1;
            } catch (NumberFormatException unused) {
                return false;
            }
        } catch (Throwable th) {
            Log.e("VivoSystemAudioKit", "getParameters failed. ".concat(String.valueOf(th)), new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void initialize() {
        if (!a()) {
            Log.w("VivoSystemAudioKit", "initialize failed. current device dose not support system ear monitoring.", new Object[0]);
            notifyEarMonitoringInitialized(this, false);
            return;
        }
        try {
            this.f42658a.setParameters("vivo_ktv_mode=1");
            this.f42658a.setParameters("vivo_ktv_rec_source=0");
            this.f42658a.setParameters("vivo_ktv_play_source=0");
            notifyEarMonitoringInitialized(this, true);
        } catch (Throwable th) {
            Log.d("VivoSystemAudioKit", "initialize failed. ".concat(String.valueOf(th)), new Object[0]);
            notifyEarMonitoringInitialized(this, false);
        }
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void setEarMonitoringVolume(int i10) {
        a("vivo_ktv_volume_mic=".concat(String.valueOf(Math.min(com.tencent.liteav.base.util.h.a(i10, 0, 100) / 6, 15))));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void startEarMonitoring() {
        if (this.f42659b != null) {
            return;
        }
        a("vivo_ktv_play_source=1");
        a aVar = new a(this);
        this.f42659b = aVar;
        aVar.start();
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void stopEarMonitoring() {
        if (this.f42659b == null) {
            return;
        }
        a("vivo_ktv_play_source=0");
        this.f42659b.f42660a = true;
        this.f42659b = null;
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void terminate() {
        a("vivo_ktv_mode=0");
        stopEarMonitoring();
    }

    private void a(String str) {
        try {
            this.f42658a.setParameters(str);
        } catch (Throwable th) {
            Log.e("VivoSystemAudioKit", "setParameters failed. ".concat(String.valueOf(th)), new Object[0]);
            notifySystemError(this);
        }
    }
}
