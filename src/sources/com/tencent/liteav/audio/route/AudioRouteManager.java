package com.tencent.liteav.audio.route;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.HandlerThread;
import androidx.annotation.RequiresApi;
import com.android.internal.os.PowerProfile;
import com.tencent.liteav.audio.route.b;
import com.tencent.liteav.audio.route.s;
import com.tencent.liteav.audio.route.t;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import java.util.Iterator;
import java.util.List;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AudioRouteManager extends t.a implements t.c {
    private static final int BLUETOOTH_SCO_RECONNECT_INTERVAL = 1000;
    private static final long IN_CALL_DETECTION_TIME = 500;
    private static final int RECORDING_CONFIGS_LIMIT = 10;
    private static final String TAG = "AudioRouteManager";
    private AudioDeviceCallback mAudioDeviceCallback;
    private final AudioManager mAudioManager;
    private AudioManager.AudioRecordingCallback mAudioRecordingCallback;
    private final r mAudioRouteSupervisor;
    private final t mBroadcastReceiver;
    private a mCurrentAudioIOScene;
    private String mCurrentRouteConfig;
    private b.a mCurrentRouteType;
    private int mCurrentSystemVolume;
    private a mExpectedAudioIOScene;
    private final Runnable mForceUpdateRouteRunnable;
    private boolean mHasModeConflict;
    private final long mNativeAudioRouteManager;
    private s.a mSwitcher;
    private s.a.InterfaceC0635a mSwitcherListener;
    private CustomHandler mHandler = null;
    private boolean mIsServiceStarted = false;

    /* renamed from: com.tencent.liteav.audio.route.AudioRouteManager$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass2 extends AudioManager.AudioRecordingCallback {
        public AnonymousClass2() {
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public final void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            AudioRouteManager.this.runOnWorkThread(o.a(this, list));
        }
    }

    /* renamed from: com.tencent.liteav.audio.route.AudioRouteManager$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass3 extends AudioDeviceCallback {
        public AnonymousClass3() {
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (audioDeviceInfoArr.length == 0) {
                return;
            }
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                Log.i(AudioRouteManager.TAG, "added device type is " + audioDeviceInfo.getType() + " sink: " + audioDeviceInfo.isSink(), new Object[0]);
                if (audioDeviceInfo.getType() == 8) {
                    AudioRouteManager.this.runOnWorkThread(p.a(this));
                }
            }
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (audioDeviceInfoArr.length == 0) {
                return;
            }
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                Log.i(AudioRouteManager.TAG, "removed device type is " + audioDeviceInfo.getType() + " sink: " + audioDeviceInfo.isSink(), new Object[0]);
                if (audioDeviceInfo.getType() == 8) {
                    AudioRouteManager.this.runOnWorkThread(q.a(this));
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class RecordingConfig {

        /* renamed from: a, reason: collision with root package name */
        public int f42665a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42666b;

        @CalledByNative("RecordingConfig")
        public int getSessionId() {
            return this.f42665a;
        }

        @CalledByNative("RecordingConfig")
        public boolean isSilenced() {
            return this.f42666b;
        }
    }

    @CalledByNative
    public AudioRouteManager(long j10) {
        a aVar = a.STOPPED;
        this.mCurrentAudioIOScene = aVar;
        this.mExpectedAudioIOScene = aVar;
        this.mCurrentRouteType = b.a.NONE;
        this.mSwitcher = null;
        this.mCurrentRouteConfig = "";
        this.mHasModeConflict = false;
        this.mCurrentSystemVolume = -1;
        this.mAudioRecordingCallback = null;
        this.mAudioDeviceCallback = null;
        this.mForceUpdateRouteRunnable = c.a(this);
        this.mSwitcherListener = new s.a.InterfaceC0635a() { // from class: com.tencent.liteav.audio.route.AudioRouteManager.1
            @Override // com.tencent.liteav.audio.route.s.a.InterfaceC0635a
            public final void a(b.a aVar2) {
                AudioRouteManager.nativeNotifyAudioRouteChangedFromJava(AudioRouteManager.this.mNativeAudioRouteManager, aVar2.value);
            }

            @Override // com.tencent.liteav.audio.route.s.a.InterfaceC0635a
            public final void b(b.a aVar2) {
                b.a aVar3 = b.a.BLUETOOTH_HEADSET;
                if (aVar2 == aVar3) {
                    Log.w(AudioRouteManager.TAG, "switch to bluetooth failed  mode conflict:" + AudioRouteManager.this.mHasModeConflict + " ,set it unavailable and update route again", new Object[0]);
                    AudioRouteManager.this.mAudioRouteSupervisor.a(aVar3, false);
                    AudioRouteManager.this.autoCheckRouteUpdate(false);
                    AudioRouteManager.nativeNotifyBluetoothConnectionFailedFromJava(AudioRouteManager.this.mNativeAudioRouteManager, AudioRouteManager.this.mHasModeConflict);
                    return;
                }
                Log.w(AudioRouteManager.TAG, "switch to %s failed, do nothing", aVar2);
            }
        };
        this.mNativeAudioRouteManager = j10;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mAudioRouteSupervisor = new r();
        this.mAudioManager = (AudioManager) applicationContext.getSystemService(PowerProfile.POWER_AUDIO);
        this.mBroadcastReceiver = new t(applicationContext, this, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void autoCheckRouteUpdate(boolean r7) {
        /*
            r6 = this;
            com.tencent.liteav.audio.route.a r0 = r6.mCurrentAudioIOScene
            com.tencent.liteav.audio.route.a r1 = com.tencent.liteav.audio.route.a.STOPPED
            if (r0 != r1) goto Le
            com.tencent.liteav.audio.route.b$a r7 = com.tencent.liteav.audio.route.b.a.NONE
            r6.mCurrentRouteType = r7
            r6.destroySwitcher()
            return
        Le:
            com.tencent.liteav.audio.route.r r0 = r6.mAudioRouteSupervisor
            boolean r1 = r0.f42711c
            r2 = 0
            if (r1 != 0) goto L20
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "AudioRouteSupervisor"
            java.lang.String r3 = "err in getHighestPriorityRoute(), it's not been initialized yet"
            com.tencent.liteav.base.Log.e(r1, r3, r0)
            goto L52
        L20:
            java.util.HashMap<com.tencent.liteav.audio.route.b$a, com.tencent.liteav.audio.route.b> r0 = r0.f42710b
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator2()
            r1 = r2
        L2b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L4d
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            com.tencent.liteav.audio.route.b r3 = (com.tencent.liteav.audio.route.b) r3
            if (r3 == 0) goto L2b
            boolean r4 = r3.f42675b
            if (r4 == 0) goto L2b
            if (r1 == 0) goto L4b
            int r4 = r3.f42676c
            int r5 = r1.f42676c
            if (r4 < r5) goto L2b
        L4b:
            r1 = r3
            goto L2b
        L4d:
            if (r1 == 0) goto L52
            com.tencent.liteav.audio.route.b$a r0 = r1.f42674a
            goto L54
        L52:
            com.tencent.liteav.audio.route.b$a r0 = com.tencent.liteav.audio.route.r.f42709a
        L54:
            com.tencent.liteav.audio.route.b$a r1 = r6.mCurrentRouteType
            if (r1 != r0) goto L5a
            if (r7 == 0) goto La6
        L5a:
            r6.mCurrentRouteType = r0
            r6.destroySwitcher()
            android.media.AudioManager r7 = r6.mAudioManager
            com.tencent.liteav.base.util.CustomHandler r1 = r6.mHandler
            com.tencent.liteav.audio.route.a r3 = r6.mCurrentAudioIOScene
            int[] r4 = com.tencent.liteav.audio.route.s.AnonymousClass1.f42712a
            int r0 = r0.ordinal()
            r0 = r4[r0]
            r4 = 1
            if (r0 == r4) goto L95
            r4 = 2
            if (r0 == r4) goto L8f
            r4 = 3
            if (r0 == r4) goto L89
            r4 = 4
            if (r0 == r4) goto L83
            r4 = 5
            if (r0 == r4) goto L7d
            goto L9a
        L7d:
            com.tencent.liteav.audio.route.s$d r2 = new com.tencent.liteav.audio.route.s$d
            r2.<init>(r7, r1, r3)
            goto L9a
        L83:
            com.tencent.liteav.audio.route.s$b r2 = new com.tencent.liteav.audio.route.s$b
            r2.<init>(r7, r1, r3)
            goto L9a
        L89:
            com.tencent.liteav.audio.route.s$f r2 = new com.tencent.liteav.audio.route.s$f
            r2.<init>(r7, r1, r3)
            goto L9a
        L8f:
            com.tencent.liteav.audio.route.s$e r2 = new com.tencent.liteav.audio.route.s$e
            r2.<init>(r7, r1, r3)
            goto L9a
        L95:
            com.tencent.liteav.audio.route.s$c r2 = new com.tencent.liteav.audio.route.s$c
            r2.<init>(r7, r1, r3)
        L9a:
            r6.mSwitcher = r2
            com.tencent.liteav.audio.route.s$a$a r7 = r6.mSwitcherListener
            r2.a(r7)
            com.tencent.liteav.audio.route.s$a r7 = r6.mSwitcher
            r7.a()
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.route.AudioRouteManager.autoCheckRouteUpdate(boolean):void");
    }

    private void buildAudioDeviceCallback() {
        if (this.mAudioDeviceCallback != null) {
            return;
        }
        this.mAudioDeviceCallback = new AnonymousClass3();
    }

    @RequiresApi(api = 24)
    private void buildAudioRecordingCallback() {
        if (this.mAudioRecordingCallback != null) {
            return;
        }
        this.mAudioRecordingCallback = new AnonymousClass2();
    }

    private void destroySwitcher() {
        s.a aVar = this.mSwitcher;
        if (aVar == null) {
            return;
        }
        aVar.b();
        this.mSwitcher = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableUsbDeviceInternal(boolean z10) {
        if (this.mBroadcastReceiver == null) {
            Log.e(TAG, "broadcast receiver is null", new Object[0]);
            return;
        }
        Log.i(TAG, "enable usb device: ".concat(String.valueOf(z10)), new Object[0]);
        this.mBroadcastReceiver.f42731c = z10;
        updateAudioRouteStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBluetoothHeadsetChangedInternal(boolean z10) {
        if (!this.mIsServiceStarted) {
            Log.i(TAG, "ignore bluetooth headset changing, AudioRouteManager is not started", new Object[0]);
        } else if (this.mAudioRouteSupervisor.a(b.a.BLUETOOTH_HEADSET, z10)) {
            autoCheckRouteUpdate(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBluetoothSCOChangedInternal(boolean z10) {
        s.a aVar = this.mSwitcher;
        if (aVar != null) {
            aVar.a(z10);
        }
        removeCallbacksOnWorkThread(this.mForceUpdateRouteRunnable);
        if (z10 || !this.mIsServiceStarted || this.mCurrentAudioIOScene == a.STOPPED) {
            return;
        }
        runOnWorkThread(this.mForceUpdateRouteRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 24)
    public void handleRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
        if (list.isEmpty()) {
            return;
        }
        int min = Math.min(list.size(), 10);
        RecordingConfig[] recordingConfigArr = new RecordingConfig[min];
        for (int i10 = 0; i10 < min; i10++) {
            recordingConfigArr[i10] = new RecordingConfig();
            AudioRecordingConfiguration audioRecordingConfiguration = list.get(i10);
            recordingConfigArr[i10].f42665a = audioRecordingConfiguration.getClientAudioSessionId();
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 29) {
                recordingConfigArr[i10].f42666b = audioRecordingConfiguration.isClientSilenced();
            } else {
                recordingConfigArr[i10].f42666b = false;
            }
        }
        nativeNotifyAudioRecordingConfigChangedFromJava(this.mNativeAudioRouteManager, recordingConfigArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSystemVolumeChangedInternal() {
        int streamVolume = this.mAudioManager.getStreamVolume(this.mAudioManager.getMode() == 0 ? 3 : 0);
        if (this.mCurrentSystemVolume != streamVolume) {
            this.mCurrentSystemVolume = streamVolume;
            nativeNotifySystemVolumeChangedFromJava(this.mNativeAudioRouteManager, streamVolume);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUsbChangedInternal(boolean z10) {
        if (!this.mIsServiceStarted) {
            Log.i(TAG, "ignore usb changing, AudioRouteManager is not started", new Object[0]);
        } else if (this.mAudioRouteSupervisor.a(b.a.SOUNDCARD, z10)) {
            autoCheckRouteUpdate(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWiredHeadsetChangedInternal(boolean z10) {
        if (!this.mIsServiceStarted) {
            Log.i(TAG, "ignore wired headset changing, AudioRouteManager is not started", new Object[0]);
        } else if (this.mAudioRouteSupervisor.a(b.a.WIRED_HEADSET, z10)) {
            autoCheckRouteUpdate(false);
        }
    }

    public static /* synthetic */ void lambda$notifyAudioIOSceneChanged$3(AudioRouteManager audioRouteManager, int i10) {
        audioRouteManager.mExpectedAudioIOScene = a.a(i10);
        audioRouteManager.notifyAudioIOSceneChangedInternal();
    }

    private static native void nativeNotifyAudioRecordingConfigChangedFromJava(long j10, RecordingConfig[] recordingConfigArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyAudioRouteChangedFromJava(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyBluetoothConnectionFailedFromJava(long j10, boolean z10);

    private static native void nativeNotifySystemVolumeChangedFromJava(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAudioIOSceneChangedInternal() {
        a aVar = this.mCurrentAudioIOScene;
        a aVar2 = this.mExpectedAudioIOScene;
        if (aVar == aVar2) {
            return;
        }
        Log.i(TAG, "notify audio io scene changed, %s -> %s", aVar, aVar2);
        if (this.mAudioManager.getMode() == 2) {
            runOnWorkThread(f.a(this), 500L);
            return;
        }
        int a10 = a.a(this.mExpectedAudioIOScene);
        Log.i(TAG, "setMode to ".concat(String.valueOf(a10)), new Object[0]);
        try {
            if (this.mAudioManager.getMode() == a10 && a10 == 3) {
                this.mHasModeConflict = true;
                Log.w(TAG, "set communication mode repeatedly, maybe can't be the mode owner", new Object[0]);
            } else {
                this.mHasModeConflict = false;
            }
            this.mAudioManager.setMode(a10);
        } catch (Exception unused) {
            Log.w(TAG, "AudioManager setMode failed, ignore it", new Object[0]);
        }
        a aVar3 = this.mExpectedAudioIOScene;
        this.mCurrentAudioIOScene = aVar3;
        s.a aVar4 = this.mSwitcher;
        if (aVar4 != null) {
            aVar4.a(aVar3);
        } else {
            autoCheckRouteUpdate(false);
        }
    }

    private void registerAudioDeviceCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() <= 30) {
            return;
        }
        if (this.mAudioDeviceCallback == null) {
            buildAudioDeviceCallback();
        }
        AudioDeviceCallback audioDeviceCallback = this.mAudioDeviceCallback;
        if (audioDeviceCallback == null) {
            return;
        }
        this.mAudioManager.registerAudioDeviceCallback(audioDeviceCallback, null);
        Log.i(TAG, "register audio device callback", new Object[0]);
    }

    private void registerAudioRecordingCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 24) {
            return;
        }
        if (this.mAudioRecordingCallback == null) {
            buildAudioRecordingCallback();
        }
        this.mAudioManager.registerAudioRecordingCallback(this.mAudioRecordingCallback, null);
    }

    private void removeCallbacksOnWorkThread(Runnable runnable) {
        CustomHandler customHandler = this.mHandler;
        if (customHandler != null) {
            customHandler.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnWorkThread(Runnable runnable) {
        CustomHandler customHandler = this.mHandler;
        if (customHandler != null) {
            customHandler.post(runnable);
        }
    }

    private void runOnWorkThreadAndWaitDone(Runnable runnable, long j10) {
        CustomHandler customHandler = this.mHandler;
        if (customHandler != null) {
            customHandler.runAndWaitDone(runnable, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setHandFreeModeEnabledInternal(boolean r7) {
        /*
            r6 = this;
            boolean r0 = r6.mIsServiceStarted
            r1 = 0
            if (r0 != 0) goto Lf
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r0 = "AudioRouteManager"
            java.lang.String r1 = "set handfree mode failed, AudioRouteManager is not started"
            com.tencent.liteav.base.Log.w(r0, r1, r7)
            return
        Lf:
            com.tencent.liteav.audio.route.r r0 = r6.mAudioRouteSupervisor
            boolean r2 = r0.f42711c
            java.lang.String r3 = "AudioRouteSupervisor"
            if (r2 != 0) goto L20
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r0 = "error in setHandFreeModeEnabled(), it's not been initialized yet"
            com.tencent.liteav.base.Log.e(r3, r0, r7)
        L1e:
            r7 = 0
            goto L60
        L20:
            java.util.HashMap<com.tencent.liteav.audio.route.b$a, com.tencent.liteav.audio.route.b> r2 = r0.f42710b
            com.tencent.liteav.audio.route.b$a r4 = com.tencent.liteav.audio.route.b.a.SPEAKERPHONE
            java.lang.Object r2 = r2.get(r4)
            com.tencent.liteav.audio.route.b r2 = (com.tencent.liteav.audio.route.b) r2
            java.util.HashMap<com.tencent.liteav.audio.route.b$a, com.tencent.liteav.audio.route.b> r0 = r0.f42710b
            com.tencent.liteav.audio.route.b$a r4 = com.tencent.liteav.audio.route.b.a.EARPHONE
            java.lang.Object r0 = r0.get(r4)
            com.tencent.liteav.audio.route.b r0 = (com.tencent.liteav.audio.route.b) r0
            if (r2 == 0) goto L58
            if (r0 != 0) goto L39
            goto L58
        L39:
            int r3 = r2.f42676c
            int r4 = r0.f42676c
            int r3 = java.lang.Math.min(r3, r4)
            int r4 = r2.f42676c
            int r5 = r0.f42676c
            int r4 = java.lang.Math.max(r4, r5)
            if (r7 == 0) goto L4d
            r5 = r4
            goto L4e
        L4d:
            r5 = r3
        L4e:
            r2.f42676c = r5
            if (r7 == 0) goto L53
            goto L54
        L53:
            r3 = r4
        L54:
            r0.f42676c = r3
            r7 = 1
            goto L60
        L58:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r0 = "setHandFreeModeEnabled failed, speakerphone or earphone not existed"
            com.tencent.liteav.base.Log.e(r3, r0, r7)
            goto L1e
        L60:
            if (r7 == 0) goto L65
            r6.autoCheckRouteUpdate(r1)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.route.AudioRouteManager.setHandFreeModeEnabledInternal(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0 A[LOOP:0: B:29:0x0066->B:36:0x00c0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0031 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startInternal(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.route.AudioRouteManager.startInternal(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        Log.i(TAG, "stopInternal", new Object[0]);
        if (!this.mIsServiceStarted) {
            Log.e(TAG, "AudioRouteManager is not started", new Object[0]);
            return;
        }
        unregisterAudioRecordingCallback();
        destroySwitcher();
        try {
            this.mAudioManager.setMode(0);
        } catch (Exception unused) {
            Log.w(TAG, "AudioManager setMode failed, ignore it", new Object[0]);
        }
        this.mCurrentRouteType = b.a.NONE;
        a aVar = a.STOPPED;
        this.mCurrentAudioIOScene = aVar;
        this.mExpectedAudioIOScene = aVar;
        t tVar = this.mBroadcastReceiver;
        Context context = tVar.f42729a;
        if (context != null) {
            try {
                context.unregisterReceiver(tVar);
            } catch (Exception unused2) {
            }
            t.b bVar = tVar.f42730b;
            if (bVar != null) {
                synchronized (bVar.f42736c) {
                    if (bVar.f42734a != null && bVar.f42735b != null) {
                        bVar.b();
                        bVar.f42735b = null;
                    }
                }
                tVar.f42730b = null;
            }
        }
        unregisterAudioDeviceCallback();
        r rVar = this.mAudioRouteSupervisor;
        if (!rVar.f42711c) {
            Log.w("AudioRouteSupervisor", "error in uninitialize(), it's not been initialized yet", new Object[0]);
        } else {
            rVar.f42710b.clear();
            rVar.f42711c = false;
        }
        this.mCurrentRouteConfig = "";
        this.mIsServiceStarted = false;
        this.mHasModeConflict = false;
    }

    private void unregisterAudioDeviceCallback() {
        AudioDeviceCallback audioDeviceCallback;
        if (LiteavSystemInfo.getSystemOSVersionInt() > 30 && (audioDeviceCallback = this.mAudioDeviceCallback) != null) {
            this.mAudioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
            Log.i(TAG, "unregister audio device callback", new Object[0]);
        }
    }

    private void unregisterAudioRecordingCallback() {
        AudioManager.AudioRecordingCallback audioRecordingCallback;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 24 && (audioRecordingCallback = this.mAudioRecordingCallback) != null) {
            this.mAudioManager.unregisterAudioRecordingCallback(audioRecordingCallback);
        }
    }

    private void updateAudioRouteStatus() {
        UsbManager usbManager;
        t tVar = this.mBroadcastReceiver;
        if (tVar == null) {
            this.mAudioRouteSupervisor.a(b.a.BLUETOOTH_HEADSET, false);
        } else {
            r rVar = this.mAudioRouteSupervisor;
            b.a aVar = b.a.BLUETOOTH_HEADSET;
            t.b bVar = tVar.f42730b;
            rVar.a(aVar, bVar == null ? false : bVar.a());
        }
        this.mAudioRouteSupervisor.a(b.a.WIRED_HEADSET, this.mAudioManager.isWiredHeadsetOn());
        boolean z10 = true;
        this.mAudioRouteSupervisor.a(b.a.SPEAKERPHONE, true);
        this.mAudioRouteSupervisor.a(b.a.EARPHONE, true);
        r rVar2 = this.mAudioRouteSupervisor;
        b.a aVar2 = b.a.SOUNDCARD;
        t tVar2 = this.mBroadcastReceiver;
        if (tVar2.f42731c && (usbManager = (UsbManager) tVar2.f42729a.getSystemService("usb")) != null) {
            Iterator<UsbDevice> iterator2 = usbManager.getDeviceList().values().iterator2();
            while (iterator2.hasNext()) {
                if (t.a(iterator2.next())) {
                    break;
                }
            }
        }
        z10 = false;
        rVar2.a(aVar2, z10);
        autoCheckRouteUpdate(false);
    }

    @CalledByNative
    public void enableUsbDevice(boolean z10) {
        runOnWorkThread(i.a(this, z10));
    }

    @CalledByNative
    public void initialize() {
        HandlerThread handlerThread = new HandlerThread("AudioRouteManagerLooper");
        handlerThread.start();
        this.mHandler = new CustomHandler(handlerThread.getLooper());
    }

    @CalledByNative
    public void notifyAudioIOSceneChanged(int i10, long j10) {
        runOnWorkThreadAndWaitDone(j.a(this, i10), j10);
    }

    @Override // com.tencent.liteav.audio.route.t.a
    public void onBluetoothConnectionChanged(boolean z10) {
        runOnWorkThread(m.a(this, z10));
    }

    @Override // com.tencent.liteav.audio.route.t.a
    public void onBluetoothSCOConnected(boolean z10) {
        runOnWorkThread(n.a(this, z10));
    }

    @Override // com.tencent.liteav.audio.route.t.c
    public void onSystemVolumeChanged() {
        runOnWorkThread(e.a(this));
    }

    @Override // com.tencent.liteav.audio.route.t.a
    public void onUsbConnectionChanged(boolean z10) {
        runOnWorkThread(d.a(this, z10));
    }

    @Override // com.tencent.liteav.audio.route.t.a
    public void onWiredHeadsetConnectionChanged(boolean z10) {
        runOnWorkThread(l.a(this, z10));
    }

    @CalledByNative
    public void setHandFreeModeEnabled(boolean z10) {
        runOnWorkThread(k.a(this, z10));
    }

    @CalledByNative
    public void start(String str) {
        runOnWorkThread(g.a(this, str));
    }

    @CalledByNative
    public void stop() {
        runOnWorkThread(h.a(this));
    }

    @CalledByNative
    public void uninitialize() {
        CustomHandler customHandler = this.mHandler;
        this.mHandler = null;
        if (customHandler != null) {
            customHandler.quitLooperAndWaitDone();
        }
    }

    private void runOnWorkThread(Runnable runnable, long j10) {
        CustomHandler customHandler = this.mHandler;
        if (customHandler != null) {
            customHandler.postDelayed(runnable, j10);
        }
    }
}
