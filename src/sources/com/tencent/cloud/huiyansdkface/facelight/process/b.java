package com.tencent.cloud.huiyansdkface.facelight.process;

import com.tencent.cloud.huiyansdkface.facelight.c.b.b;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.process.c.e;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f40781a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final String f40782b = "b";

    /* renamed from: c, reason: collision with root package name */
    private static int f40783c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f40784d;

    /* renamed from: e, reason: collision with root package name */
    private static InterfaceC0623b f40785e;

    /* renamed from: f, reason: collision with root package name */
    private static c f40786f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a();

        void a(int i10);

        void a(int i10, String str, String str2);

        void a(byte[][] bArr, int i10, int i11);
    }

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.process.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0623b {
        void a();

        void a(int i10, String str, String str2);
    }

    public static int a() {
        try {
            String str = f40782b;
            YTPoseDetectJNIInterface.nativeLog(str, "[YTFacePreviewInterface.initModel] ---");
            if (f40783c > 0) {
                YTPoseDetectJNIInterface.nativeLog(str, "[YTFacePreviewInterface.initModel] has already inited.");
                f40783c++;
                return 0;
            }
            int initModel = YTPoseDetectJNIInterface.initModel("");
            if (initModel != 0) {
                return initModel;
            }
            c cVar = new c();
            f40786f = cVar;
            cVar.a();
            f40783c++;
            return 0;
        } catch (Exception e2) {
            WLogger.e(f40782b, "initModel failed. message: " + e2.toString());
            e2.printStackTrace();
            KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_init_failed", "PoseDetectInterface exception:" + e2.toString(), null);
            return 10;
        }
    }

    public static int a(int i10, InterfaceC0623b interfaceC0623b) {
        YTPoseDetectJNIInterface.nativeLog(f40782b, "[YTPoseDetectInterface.start] ---");
        if (interfaceC0623b == null) {
            return -1;
        }
        f40785e = interfaceC0623b;
        if (f40783c > 0) {
            f40786f.a(i10, new InterfaceC0623b() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.5
                @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0623b
                public void a() {
                    b.i();
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0623b
                public void a(int i11, String str, String str2) {
                    b.b(i11, str, str2);
                }
            });
            return 0;
        }
        b(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
        return 0;
    }

    public static void a(final com.tencent.cloud.huiyansdkface.facelight.process.c.d dVar) {
        WLogger.i(f40782b, "getActReflectDataOnSubThread");
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public YTActRefData call() {
                WLogger.i(b.f40782b, "getActReflectData enter");
                return YTPoseDetectJNIInterface.getActionReflectData(b.f40786f.f40792b);
            }
        }, new b.a<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.4
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(YTActRefData yTActRefData) {
                WLogger.i(b.f40782b, "getActReflectData success,get bestImages!");
                com.tencent.cloud.huiyansdkface.facelight.process.c.d.this.a(yTActRefData);
            }
        });
    }

    public static void a(final e eVar) {
        WLogger.i(f40782b, "getFrameListOnSubThread");
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<byte[][]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public byte[][] call() {
                WLogger.i(b.f40782b, "getFrameList enter");
                return YTPoseDetectJNIInterface.getFrameList();
            }
        }, new b.a<byte[][]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.2
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(byte[][] bArr) {
                WLogger.i(b.f40782b, "pushBackupData success,get bestImages!");
                e.this.a(bArr);
            }
        });
    }

    public static void a(float[] fArr, float[] fArr2, int i10, byte[] bArr, int i11, int i12, float f10, float f11, float f12, a aVar, int i13, int i14) {
        int i15;
        String str;
        String str2;
        if (f40783c <= 0) {
            i15 = 2;
            str = "Not init model on poseDetect.";
            str2 = "Call YTPoseDetectInterface.initModel() before.";
        } else {
            if (f40784d) {
                int a10 = f40786f.a(fArr, fArr2, i10, bArr, i11, i12, f10, f11, f12, i13, i14);
                if (i10 != 5) {
                    aVar.a(a10);
                }
                if (YTPoseDetectJNIInterface.canReflect()) {
                    aVar.a();
                }
                if (YTPoseDetectJNIInterface.isRecordingDone()) {
                    YTPoseDetectJNIInterface.nativeLog(f40782b, "poseDetectOnFrame.onRecordingDone.");
                    aVar.a((byte[][]) null, 0, 0);
                    return;
                }
                return;
            }
            i15 = 3;
            str = "Not call start() interface before.";
            str2 = "Call YTPoseDetectInterface.start() before.";
        }
        aVar.a(i15, str, str2);
    }

    public static void b() {
        YTPoseDetectJNIInterface.nativeLog(f40782b, "[YTFacePreviewInterface.finalize] ---");
        int i10 = f40783c - 1;
        f40783c = i10;
        if (i10 <= 0) {
            c cVar = f40786f;
            if (cVar != null) {
                cVar.b();
            }
            YTPoseDetectJNIInterface.releaseAll();
            f40783c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i10, String str, String str2) {
        YTPoseDetectJNIInterface.nativeLog(f40782b, "[YTPoseDetectInterface.noticeFailed] resultCode: " + i10 + " \r\nmessage: " + str + " \r\ntips: " + str2);
        f40785e.a(i10, str, str2);
        f40785e = null;
        f40784d = false;
    }

    public static void c() {
        YTPoseDetectJNIInterface.resetDetect();
    }

    public static void d() {
        YTPoseDetectJNIInterface.nativeLog(f40782b, "[YTPoseDetectInterface.stop] ---");
        c cVar = f40786f;
        if (cVar != null) {
            cVar.c();
        }
        f40784d = false;
    }

    public static boolean e() {
        c cVar = f40786f;
        return cVar != null && cVar.f40791a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        YTPoseDetectJNIInterface.nativeLog(f40782b, "[YTPoseDetectInterface.noticeSuccess] ---");
        f40785e.a();
        f40785e = null;
        f40784d = true;
    }
}
