package im.zego.internal.screencapture;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoAudioCapture {

    /* renamed from: k, reason: collision with root package name */
    public static long f49894k;

    /* renamed from: a, reason: collision with root package name */
    public final Context f49895a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaProjection f49896b;

    /* renamed from: c, reason: collision with root package name */
    public a f49897c;

    /* renamed from: d, reason: collision with root package name */
    public AudioRecord f49898d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f49899e;

    /* renamed from: f, reason: collision with root package name */
    public int f49900f;

    /* renamed from: g, reason: collision with root package name */
    public int f49901g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f49902h;

    /* renamed from: i, reason: collision with root package name */
    public final int f49903i;

    /* renamed from: j, reason: collision with root package name */
    public final od.a f49904j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f49905b;

        public a(String str) {
            super(str);
            this.f49905b = true;
        }

        public void a() {
            this.f49905b = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (ZegoAudioCapture.this.f49898d.getRecordingState() != 3) {
                return;
            }
            while (this.f49905b) {
                int read = ZegoAudioCapture.this.f49898d.read(ZegoAudioCapture.this.f49899e, ZegoAudioCapture.this.f49899e.capacity());
                if (read > 0) {
                    if (this.f49905b) {
                        ZegoAudioCapture.onRecordAudioFrame(ZegoAudioCapture.this.f49903i, ZegoAudioCapture.this.f49899e, ZegoAudioCapture.this.f49899e.capacity(), ZegoAudioCapture.this.f49901g, ZegoAudioCapture.this.f49900f);
                    }
                } else if (read == -3) {
                    this.f49905b = false;
                }
            }
            try {
                if (ZegoAudioCapture.this.f49898d != null) {
                    ZegoAudioCapture.this.f49898d.stop();
                }
            } catch (IllegalStateException unused) {
            }
        }
    }

    public ZegoAudioCapture(Context context, int i10, int i11, MediaProjection mediaProjection, int i12, od.a aVar) {
        this.f49895a = context;
        this.f49896b = mediaProjection;
        this.f49900f = i10;
        this.f49901g = i11;
        this.f49903i = i12;
        this.f49904j = aVar;
    }

    public static native int initCapture(int i10);

    public static native int onRecordAudioFrame(int i10, ByteBuffer byteBuffer, int i11, int i12, int i13);

    public static native int startCapture(int i10);

    public static native int stopCapture(int i10);

    public boolean f() {
        if (this.f49895a.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            this.f49904j.e();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49894k, 3);
            return false;
        }
        if (this.f49898d != null) {
            this.f49904j.i();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49894k, 6);
            return false;
        }
        if (this.f49900f == 0) {
            this.f49900f = 2;
        }
        if (this.f49901g == 0) {
            this.f49901g = 16000;
        }
        int i10 = this.f49900f == 2 ? 12 : 16;
        int minBufferSize = AudioRecord.getMinBufferSize(this.f49901g, i10, 2);
        if (minBufferSize < 0) {
            this.f49904j.j();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49894k, 9);
            return false;
        }
        int i11 = minBufferSize * 2;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i11);
        this.f49899e = allocateDirect;
        if (!allocateDirect.hasArray()) {
            this.f49904j.f();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49894k, 3);
            return false;
        }
        AudioPlaybackCaptureConfiguration build = new AudioPlaybackCaptureConfiguration.Builder(this.f49896b).addMatchingUsage(1).addMatchingUsage(14).addMatchingUsage(0).build();
        AudioFormat.Builder builder = new AudioFormat.Builder();
        builder.setEncoding(2);
        builder.setSampleRate(this.f49901g);
        builder.setChannelMask(i10);
        AudioFormat build2 = builder.build();
        AudioRecord.Builder builder2 = new AudioRecord.Builder();
        builder2.setAudioFormat(build2);
        builder2.setAudioPlaybackCaptureConfig(build);
        builder2.setBufferSizeInBytes(i11);
        AudioRecord build3 = builder2.build();
        this.f49898d = build3;
        if (build3 != null && build3.getState() == 1) {
            return true;
        }
        this.f49904j.g();
        ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49894k, 3);
        g();
        return false;
    }

    public final void g() {
        AudioRecord audioRecord = this.f49898d;
        if (audioRecord != null) {
            audioRecord.stop();
            this.f49898d.release();
            this.f49898d = null;
        }
    }

    public void h(long j10) {
        f49894k = j10;
    }

    public boolean i() {
        if (!f()) {
            return false;
        }
        try {
            this.f49898d.startRecording();
            if (this.f49898d.getRecordingState() != 3) {
                this.f49904j.g();
                ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49894k, 3);
                return false;
            }
            initCapture(this.f49903i);
            startCapture(this.f49903i);
            a aVar = new a("ZegoAudioRecordThread");
            this.f49897c = aVar;
            aVar.start();
            this.f49902h = true;
            return true;
        } catch (IllegalStateException unused) {
            this.f49904j.g();
            ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(f49894k, 3);
            return false;
        }
    }

    public void j() {
        this.f49902h = false;
        stopCapture(this.f49903i);
        a aVar = this.f49897c;
        if (aVar != null) {
            aVar.a();
            try {
                this.f49897c.join(500L);
            } catch (InterruptedException unused) {
            }
            this.f49897c = null;
        }
        g();
    }

    public void k(boolean z10, int i10, int i11) {
        if (z10 && !this.f49902h) {
            i();
            return;
        }
        if (!z10 && this.f49902h) {
            j();
            return;
        }
        if (z10) {
            if (i10 == this.f49901g && i11 == this.f49900f) {
                return;
            }
            j();
            this.f49901g = i10;
            this.f49900f = i11;
            i();
        }
    }
}
