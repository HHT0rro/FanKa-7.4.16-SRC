package com.tencent.cloud.huiyansdkface.facelight.process;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.cloud.huiyansdkface.facelight.process.b;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f40790e = "c";

    /* renamed from: b, reason: collision with root package name */
    public int f40792b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f40791a = false;

    /* renamed from: c, reason: collision with root package name */
    public int f40793c = 1280;

    /* renamed from: d, reason: collision with root package name */
    public int f40794d = MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH;

    public int a(float[] fArr, float[] fArr2, int i10, byte[] bArr, int i11, int i12, float f10, float f11, float f12, int i13, int i14) {
        this.f40793c = i11;
        this.f40794d = i12;
        return YTPoseDetectJNIInterface.poseDetect(fArr, fArr2, i10, bArr, i11, i12, this.f40792b, f10, f11, f12, i13, i14);
    }

    public void a() {
    }

    public void a(int i10, b.InterfaceC0623b interfaceC0623b) {
        if (this.f40791a) {
            WLogger.d(f40790e, "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
        }
        this.f40792b = i10;
        this.f40791a = true;
        interfaceC0623b.a();
    }

    public void b() {
    }

    public void c() {
        if (this.f40791a) {
            this.f40791a = false;
            YTPoseDetectJNIInterface.resetDetect();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
    }
}
