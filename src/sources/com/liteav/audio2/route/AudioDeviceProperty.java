package com.liteav.audio2.route;

import android.media.AudioManager;
import com.liteav.audio2.route.a;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AudioDeviceProperty implements a.InterfaceC0555a {

    /* renamed from: a, reason: collision with root package name */
    public long f36663a;

    /* renamed from: b, reason: collision with root package name */
    public int f36664b;

    /* renamed from: c, reason: collision with root package name */
    public final AudioManager f36665c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class RecordingConfig {
    }

    private static native void nativeNotifyAudioRecordingConfigChangedFromJava(long j10, RecordingConfig[] recordingConfigArr);

    private static native void nativeNotifyBluetoothConnectionChangedFromJava(long j10, boolean z10);

    private static native void nativeNotifyBluetoothScoConnectedFromJava(long j10, boolean z10);

    private static native void nativeNotifySystemVolumeChangedFromJava(long j10, int i10);

    private static native void nativeNotifyWiredHeadsetConnectionChangedFromJava(long j10, boolean z10);

    @Override // com.liteav.audio2.route.a.InterfaceC0555a
    public void a(boolean z10) {
        nativeNotifyWiredHeadsetConnectionChangedFromJava(this.f36663a, z10);
    }

    @Override // com.liteav.audio2.route.a.InterfaceC0555a
    public void b(boolean z10) {
        nativeNotifyBluetoothScoConnectedFromJava(this.f36663a, z10);
    }

    @Override // com.liteav.audio2.route.a.InterfaceC0555a
    public void c(boolean z10) {
        nativeNotifyBluetoothConnectionChangedFromJava(this.f36663a, z10);
    }

    @Override // com.liteav.audio2.route.a.InterfaceC0555a
    public void onSystemVolumeChanged() {
        int streamVolume = this.f36665c.getStreamVolume(this.f36665c.getMode() == 0 ? 3 : 0);
        if (this.f36664b != streamVolume) {
            this.f36664b = streamVolume;
            nativeNotifySystemVolumeChangedFromJava(this.f36663a, streamVolume);
        }
    }
}
