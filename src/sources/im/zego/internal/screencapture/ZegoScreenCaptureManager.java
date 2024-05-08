package im.zego.internal.screencapture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import com.zego.zegoavkit2.screencapture.ZegoScreenCaptureFactory;
import od.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoScreenCaptureManager {

    /* renamed from: n, reason: collision with root package name */
    public static final ZegoScreenCaptureManager f49918n = new ZegoScreenCaptureManager();

    /* renamed from: o, reason: collision with root package name */
    public static long f49919o;

    /* renamed from: a, reason: collision with root package name */
    public ServiceConnection f49920a;

    /* renamed from: b, reason: collision with root package name */
    public Context f49921b;

    /* renamed from: c, reason: collision with root package name */
    public a f49922c;

    /* renamed from: d, reason: collision with root package name */
    public MediaProjection f49923d;

    /* renamed from: e, reason: collision with root package name */
    public ZegoScreenCaptureFactory f49924e;

    /* renamed from: f, reason: collision with root package name */
    public ZegoScreenCapture f49925f;

    /* renamed from: g, reason: collision with root package name */
    public ZegoAudioCapture f49926g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f49927h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f49928i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f49929j;

    /* renamed from: k, reason: collision with root package name */
    public int f49930k;

    /* renamed from: l, reason: collision with root package name */
    public int f49931l;

    /* renamed from: m, reason: collision with root package name */
    public int f49932m = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ZegoScreenCaptureAssistantActivity extends Activity {

        /* renamed from: b, reason: collision with root package name */
        public MediaProjectionManager f49933b;

        /* renamed from: c, reason: collision with root package name */
        public final int f49934c = 1001;

        @Override // android.app.Activity
        public void onActivityResult(int i10, int i11, Intent intent) {
            super.onActivityResult(i10, i11, intent);
            if (ZegoScreenCaptureManager.f49918n.f49920a == null) {
                if (ZegoScreenCaptureManager.f49918n.f49922c != null) {
                    ZegoScreenCaptureManager.f49918n.f49922c.h();
                }
                ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(ZegoScreenCaptureManager.f49919o, 7);
            } else if (i10 == 1001 && i11 == -1) {
                ZegoScreenCaptureManager.f49918n.f(this.f49933b.getMediaProjection(i11, intent));
            } else {
                if (ZegoScreenCaptureManager.f49918n.f49922c != null) {
                    ZegoScreenCaptureManager.f49918n.f49922c.a();
                }
                ZegoScreenCaptureManager.OnScreenCaptureExceptionOccurredNative(ZegoScreenCaptureManager.f49919o, 4);
            }
            finish();
        }

        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            this.f49933b = mediaProjectionManager;
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 1001);
        }
    }

    public static native void OnScreenCaptureExceptionOccurredNative(long j10, int i10);

    public final void f(MediaProjection mediaProjection) {
        this.f49923d = mediaProjection;
        if (this.f49925f == null) {
            ZegoScreenCapture zegoScreenCapture = new ZegoScreenCapture(this.f49921b, this.f49924e, mediaProjection, this.f49932m, this.f49922c);
            this.f49925f = zegoScreenCapture;
            zegoScreenCapture.h(f49919o);
        }
        if (this.f49926g == null) {
            ZegoAudioCapture zegoAudioCapture = new ZegoAudioCapture(this.f49921b, this.f49931l, this.f49930k, mediaProjection, this.f49932m, this.f49922c);
            this.f49926g = zegoAudioCapture;
            zegoAudioCapture.h(f49919o);
        }
        g();
    }

    public final void g() {
        ZegoAudioCapture zegoAudioCapture = this.f49926g;
        if (zegoAudioCapture != null && this.f49925f != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                zegoAudioCapture.k(this.f49929j && this.f49927h, this.f49930k, this.f49931l);
            } else {
                a aVar = this.f49922c;
                if (aVar != null) {
                    aVar.b();
                }
                OnScreenCaptureExceptionOccurredNative(f49919o, 2);
            }
            this.f49925f.l(this.f49928i);
            return;
        }
        a aVar2 = this.f49922c;
        if (aVar2 != null) {
            aVar2.d();
        }
        OnScreenCaptureExceptionOccurredNative(f49919o, 5);
    }
}
