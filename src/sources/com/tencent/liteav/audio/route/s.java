package com.tencent.liteav.audio.route;

import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import com.tencent.liteav.audio.route.b;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s {

    /* renamed from: com.tencent.liteav.audio.route.s$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42712a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f42713b;

        static {
            int[] iArr = new int[b.a.a().length];
            f42713b = iArr;
            try {
                iArr[b.a.f42724a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42713b[b.a.f42725b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42713b[b.a.f42727d - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42713b[b.a.f42726c - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[b.a.values().length];
            f42712a = iArr2;
            try {
                iArr2[b.a.EARPHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f42712a[b.a.SPEAKERPHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f42712a[b.a.WIRED_HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f42712a[b.a.BLUETOOTH_HEADSET.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f42712a[b.a.SOUNDCARD.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final AudioManager f42714a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f42715b;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.liteav.audio.route.a f42717d;

        /* renamed from: c, reason: collision with root package name */
        public b.a f42716c = b.a.NONE;

        /* renamed from: e, reason: collision with root package name */
        public InterfaceC0635a f42718e = null;

        /* renamed from: f, reason: collision with root package name */
        public int f42719f = 0;

        /* renamed from: g, reason: collision with root package name */
        public boolean f42720g = false;

        /* renamed from: h, reason: collision with root package name */
        public final Runnable f42721h = new Runnable() { // from class: com.tencent.liteav.audio.route.s.a.1
            @Override // java.lang.Runnable
            public final void run() {
                long e2 = a.this.e();
                a aVar = a.this;
                aVar.f42719f++;
                aVar.f42715b.removeCallbacks(aVar.f42721h);
                a aVar2 = a.this;
                if (!aVar2.f42720g || e2 < 0) {
                    return;
                }
                aVar2.f42715b.postDelayed(aVar2.f42721h, e2);
            }
        };

        /* renamed from: com.tencent.liteav.audio.route.s$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public interface InterfaceC0635a {
            void a(b.a aVar);

            void b(b.a aVar);
        }

        public a(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            this.f42717d = com.tencent.liteav.audio.route.a.STOPPED;
            this.f42714a = audioManager;
            this.f42715b = handler;
            this.f42717d = aVar;
        }

        public final void a(InterfaceC0635a interfaceC0635a) {
            this.f42718e = interfaceC0635a;
        }

        public void a(boolean z10) {
        }

        public final void b() {
            c();
            this.f42715b.removeCallbacks(this.f42721h);
            this.f42720g = false;
        }

        public void c() {
        }

        public final int d() {
            AudioManager audioManager = this.f42714a;
            if (audioManager == null) {
                return 0;
            }
            try {
                return audioManager.getMode();
            } catch (Exception e2) {
                Log.i("AudioRouteSwitcher", "Exception occurs in getAudioMode " + e2.getMessage(), new Object[0]);
                return 0;
            }
        }

        public abstract long e();

        public final void a() {
            this.f42720g = true;
            InterfaceC0635a interfaceC0635a = this.f42718e;
            if (interfaceC0635a != null) {
                interfaceC0635a.a(this.f42716c);
            }
            this.f42715b.post(this.f42721h);
        }

        public void a(com.tencent.liteav.audio.route.a aVar) {
            this.f42717d = aVar;
            this.f42715b.removeCallbacks(this.f42721h);
            this.f42719f = 0;
            this.f42715b.post(this.f42721h);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends a {
        public c(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f42716c = b.a.EARPHONE;
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final long e() {
            long j10 = this.f42719f < 5 ? 1000L : HwCubicBezierInterpolator.f34870a;
            if (this.f42717d.a() && this.f42714a.isSpeakerphoneOn()) {
                Log.i("AudioRouteSwitcher", "EarphoneSwitcher switch to earphone", new Object[0]);
                this.f42714a.setSpeakerphoneOn(false);
            } else if (this.f42719f == 0) {
                Log.i("AudioRouteSwitcher", "EarphoneSwitcher do nothing, mCurrentIOScene: " + ((Object) this.f42717d) + ", isSpeakerOn: " + this.f42714a.isSpeakerphoneOn() + ", AudioMode: " + d(), new Object[0]);
            }
            return j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d extends a {
        public d(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f42716c = b.a.SOUNDCARD;
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final long e() {
            long j10 = this.f42719f < 5 ? 1000L : HwCubicBezierInterpolator.f34870a;
            if (this.f42717d.a() && this.f42714a.isSpeakerphoneOn()) {
                Log.i("AudioRouteSwitcher", "SoundCardSwitcher switch to soundcard", new Object[0]);
                this.f42714a.setWiredHeadsetOn(true);
                this.f42714a.setSpeakerphoneOn(false);
            } else if (this.f42719f == 0) {
                Log.i("AudioRouteSwitcher", "SoundCardSwitcher do nothing, mCurrentIOScene: " + ((Object) this.f42717d) + ", isWiredHeadsetOn: " + this.f42714a.isWiredHeadsetOn() + ", isSpeakerphoneOn: " + this.f42714a.isSpeakerphoneOn() + ", AudioMode: " + d(), new Object[0]);
            }
            return j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e extends a {
        public e(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f42716c = b.a.SPEAKERPHONE;
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final long e() {
            long j10 = this.f42719f < 5 ? 1000L : HwCubicBezierInterpolator.f34870a;
            if (this.f42717d.a() && !this.f42714a.isSpeakerphoneOn()) {
                Log.i("AudioRouteSwitcher", "SpeakerSwitcher switch to speakerphone", new Object[0]);
                this.f42714a.setSpeakerphoneOn(true);
            } else if (this.f42719f == 0) {
                Log.i("AudioRouteSwitcher", "SpeakerSwitcher do nothing, mCurrentIOScene: " + ((Object) this.f42717d) + ", isSpeakerOn: " + this.f42714a.isSpeakerphoneOn() + ", AudioMode: " + d(), new Object[0]);
            }
            return j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f extends a {
        public f(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f42716c = b.a.WIRED_HEADSET;
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final long e() {
            long j10 = this.f42719f < 5 ? 1000L : HwCubicBezierInterpolator.f34870a;
            if (this.f42717d.a() && this.f42714a.isSpeakerphoneOn()) {
                Log.i("AudioRouteSwitcher", "WiredHeadsetSwitcher switch to wired headset", new Object[0]);
                this.f42714a.setWiredHeadsetOn(true);
                this.f42714a.setSpeakerphoneOn(false);
            } else if (this.f42719f == 0) {
                Log.i("AudioRouteSwitcher", "WiredHeadsetSwitcher do nothing, mCurrentIOScene: " + ((Object) this.f42717d) + ", isWiredHeadsetOn: " + this.f42714a.isWiredHeadsetOn() + ", isSpeakerphoneOn: " + this.f42714a.isSpeakerphoneOn() + ", AudioMode: " + d(), new Object[0]);
            }
            return j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends a {

        /* renamed from: i, reason: collision with root package name */
        private int f42723i;

        /* JADX WARN: $VALUES field not found */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public static final int f42724a = 1;

            /* renamed from: b, reason: collision with root package name */
            public static final int f42725b = 2;

            /* renamed from: c, reason: collision with root package name */
            public static final int f42726c = 3;

            /* renamed from: d, reason: collision with root package name */
            public static final int f42727d = 4;

            /* renamed from: e, reason: collision with root package name */
            private static final /* synthetic */ int[] f42728e = {1, 2, 3, 4};

            public static int[] a() {
                return (int[]) f42728e.clone();
            }
        }

        public b(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f42723i = a.f42725b;
            this.f42716c = b.a.BLUETOOTH_HEADSET;
        }

        private void f() {
            Log.i("AudioRouteSwitcher", "stopBluetoothSco", new Object[0]);
            try {
                this.f42714a.stopBluetoothSco();
                this.f42714a.setBluetoothScoOn(false);
            } catch (Throwable th) {
                Log.w("AudioRouteSwitcher", "stop bluetooth sco exception " + th.getMessage(), new Object[0]);
            }
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final void a(com.tencent.liteav.audio.route.a aVar) {
            if (this.f42717d.a() != aVar.a()) {
                a(false);
            }
            super.a(aVar);
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final void c() {
            Log.i("AudioRouteSwitcher", "beforeStop: stop bluetooth SCO", new Object[0]);
            f();
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final long e() {
            if (!this.f42717d.a()) {
                Log.i("AudioRouteSwitcher", "BluetoothHeadsetSwitcher: Current io scene is not voip, and AudioMode is: " + d() + " , need stop sco.", new Object[0]);
                f();
                return -1L;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() > 30 && !t.a(ContextUtils.getApplicationContext()) && this.f42719f > 0) {
                new IntentFilter();
                Intent registerReceiver = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
                if (registerReceiver != null && registerReceiver.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0) == 1) {
                    this.f42723i = a.f42724a;
                }
            }
            int i10 = AnonymousClass1.f42713b[this.f42723i - 1];
            if (i10 == 1) {
                Log.i("AudioRouteSwitcher", "Bluetooth Headset is connected, isBluetoothScoOn:" + this.f42714a.isBluetoothScoOn(), new Object[0]);
                return -1L;
            }
            if (i10 != 2 && i10 != 3) {
                if (i10 != 4) {
                    return -1L;
                }
                f();
                this.f42723i = a.f42727d;
                return HwCubicBezierInterpolator.f34870a;
            }
            if (this.f42719f > 5) {
                Log.w("AudioRouteSwitcher", "Bluetooth headset connection failed for 3 times, give it up", new Object[0]);
                this.f42718e.b(this.f42716c);
                return -1L;
            }
            Log.i("AudioRouteSwitcher", "BluetoothHeadsetSwitcher start bluetooth SCO mode", new Object[0]);
            try {
                this.f42714a.setBluetoothScoOn(true);
                this.f42714a.startBluetoothSco();
            } catch (Throwable th) {
                Log.w("AudioRouteSwitcher", "start bluetooth sco exception " + th.getMessage(), new Object[0]);
            }
            this.f42723i = a.f42726c;
            return HwCubicBezierInterpolator.f34870a;
        }

        @Override // com.tencent.liteav.audio.route.s.a
        public final void a(boolean z10) {
            this.f42723i = z10 ? a.f42724a : a.f42725b;
        }
    }
}
