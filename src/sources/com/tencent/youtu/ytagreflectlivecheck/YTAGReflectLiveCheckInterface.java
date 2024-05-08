package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.CountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.c.b.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.LiveStyleReq;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YTAGReflectLiveCheckInterface {

    /* renamed from: a, reason: collision with root package name */
    public static com.tencent.cloud.huiyansdkface.facelight.process.c.a f46018a = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f46020c = "YTAGReflectLiveCheckInterface";

    /* renamed from: d, reason: collision with root package name */
    private static int f46021d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f46022e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static int f46023f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static int f46024g = 3;

    /* renamed from: h, reason: collision with root package name */
    private static int f46025h = 4;

    /* renamed from: i, reason: collision with root package name */
    private static int f46026i;

    /* renamed from: k, reason: collision with root package name */
    private static b f46028k;

    /* renamed from: l, reason: collision with root package name */
    private static int f46029l;

    /* renamed from: m, reason: collision with root package name */
    private static CountDownTimer f46030m;

    /* renamed from: p, reason: collision with root package name */
    private static int f46033p;

    /* renamed from: q, reason: collision with root package name */
    private static Camera f46034q;

    /* renamed from: r, reason: collision with root package name */
    private static int f46035r;

    /* renamed from: s, reason: collision with root package name */
    private static String f46036s;

    /* renamed from: j, reason: collision with root package name */
    private static Lock f46027j = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public static String f46019b = "";

    /* renamed from: n, reason: collision with root package name */
    private static c f46031n = null;

    /* renamed from: o, reason: collision with root package name */
    private static a f46032o = null;

    /* renamed from: t, reason: collision with root package name */
    private static int f46037t = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(int i10, String str, String str2);

        void a(LiveStyleReq liveStyleReq);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        float a();

        void a(int i10, float f10);

        void a(long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void a(int i10, String str, String str2);

        void a(FullPack fullPack);
    }

    public static /* synthetic */ int a() {
        int i10 = f46029l;
        f46029l = i10 + 1;
        return i10;
    }

    public static void cancel() {
        YTAGReflectLiveCheckJNIInterface.nativeLog(f46020c, "[YTAGReflectLiveCheckInterface.cancel] --- ");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRRelease();
    }

    public static int getLiveCheckType(Context context, a aVar) {
        a aVar2;
        LiveStyleReq liveStyleReq;
        String str = f46020c;
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
        int i10 = 1;
        if (aVar != null) {
            if (context == null) {
                aVar.a(1, "Input context is null.", "You can try to input getActivity().getApplicationContext() and test again.");
                i10 = 2;
            } else {
                if (f46032o != null) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(str, "[YTAGReflectLiveCheckInterface.getLiveCheckType] repeated calls. this may cause the previous call lost callback.");
                }
                f46032o = aVar;
                f46029l = 0;
                int a10 = com.tencent.cloud.huiyansdkface.facelight.c.b.c.a().a(context, new c.b() { // from class: com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.c.b
                    public void a(float f10) {
                        YTAGReflectLiveCheckInterface.a();
                        YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.f46020c, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + f10 + " mOnGetValueCount: " + YTAGReflectLiveCheckInterface.f46029l);
                        if (YTAGReflectLiveCheckInterface.f46029l > 1) {
                            YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.f46020c, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + f10);
                            if (YTAGReflectLiveCheckInterface.f46030m != null) {
                                YTAGReflectLiveCheckInterface.f46030m.cancel();
                                CountDownTimer unused = YTAGReflectLiveCheckInterface.f46030m = null;
                            }
                            if (YTAGReflectLiveCheckInterface.f46032o != null) {
                                YTAGReflectLiveCheckInterface.f46032o.a(new LiveStyleReq(f10, YTAGReflectLiveCheckInterface.f46019b));
                                a unused2 = YTAGReflectLiveCheckInterface.f46032o = null;
                            }
                            com.tencent.cloud.huiyansdkface.facelight.c.b.c.a().c();
                        }
                    }
                });
                if (a10 == 1) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(str, "[YTAGReflectLiveCheckInterface.getLiveCheckType] Can't find light sensor.");
                    aVar2 = f46032o;
                    if (aVar2 != null) {
                        liveStyleReq = new LiveStyleReq(-1.0f, f46019b);
                        aVar2.a(liveStyleReq);
                        f46032o = null;
                    }
                    i10 = 0;
                } else {
                    if (a10 != 0) {
                        aVar2 = f46032o;
                        if (aVar2 != null) {
                            liveStyleReq = new LiveStyleReq(com.tencent.cloud.huiyansdkface.facelight.c.b.c.a().b(), f46019b);
                            aVar2.a(liveStyleReq);
                            f46032o = null;
                        }
                    } else {
                        long j10 = com.huawei.openalliance.ad.ipc.c.Code;
                        CountDownTimer countDownTimer = new CountDownTimer(j10, j10) { // from class: com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.2
                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.f46020c, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onFinish] ");
                                if (YTAGReflectLiveCheckInterface.f46032o != null) {
                                    YTAGReflectLiveCheckInterface.f46032o.a(new LiveStyleReq(-2.0f, YTAGReflectLiveCheckInterface.f46019b));
                                    a unused = YTAGReflectLiveCheckInterface.f46032o = null;
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onTick(long j11) {
                                YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.f46020c, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onTick] onTick");
                            }
                        };
                        f46030m = countDownTimer;
                        countDownTimer.start();
                    }
                    i10 = 0;
                }
            }
        }
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: " + i10);
        return i10;
    }

    public static RawYuvData[] getRawYuvDatas() {
        return YTAGReflectLiveCheckJNIInterface.getInstance().FRGetRawYuvDatas();
    }

    public static b getReflectListener() {
        return f46028k;
    }

    public static synchronized int initModel(String str) {
        int i10;
        synchronized (YTAGReflectLiveCheckInterface.class) {
            try {
                try {
                    f46027j.lock();
                    if (f46026i > 0) {
                        YTAGReflectLiveCheckJNIInterface.nativeLog(f46020c, "initModel repeated calls.");
                    } else {
                        f46019b = str;
                        if (str == null) {
                            f46019b = "";
                        }
                    }
                    f46026i++;
                    f46027j.unlock();
                    i10 = 0;
                } finally {
                    f46027j.unlock();
                }
            } catch (Exception e2) {
                YTAGReflectLiveCheckJNIInterface.nativeLog(f46020c, "initModel failed. message: " + e2.toString());
                e2.printStackTrace();
                KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_init_failed", "initYoutuReflectLiveness exception:" + e2.toString(), null);
                i10 = -1;
            }
        }
        return i10;
    }

    public static void onCameraChanged(int i10) {
        WLogger.d(f46020c, "on Camera changed " + i10);
        try {
            Camera.Parameters parameters = f46034q.getParameters();
            parameters.setExposureCompensation(i10);
            f46034q.setParameters(parameters);
        } catch (Exception e2) {
            WLogger.e(f46020c, "on camera changed failed:" + e2.getLocalizedMessage());
        }
    }

    public static int[] onFetchCameraInfo() {
        int i10;
        int i11;
        int i12;
        try {
            try {
                Camera.Parameters parameters = f46034q.getParameters();
                i10 = parameters.getExposureCompensation();
                try {
                    i10 = Integer.parseInt(parameters.get(com.alibaba.security.biometrics.service.build.b.bp));
                } catch (Exception e2) {
                    WLogger.e(f46020c, "on fectch camera compoensation failed:" + e2.getLocalizedMessage());
                }
                i11 = parameters.getMinExposureCompensation();
                try {
                    i12 = parameters.getMaxExposureCompensation();
                } catch (Exception e10) {
                    e = e10;
                    WLogger.e(f46020c, "on fectch camera info failed:" + e.getLocalizedMessage());
                    i12 = 0;
                    WLogger.d(f46020c, "on fetch camera exp:" + i10 + " min:" + i11 + " max:" + i12);
                    return new int[]{i10, i11, i12};
                }
            } catch (Exception e11) {
                e = e11;
                i11 = 0;
                WLogger.e(f46020c, "on fectch camera info failed:" + e.getLocalizedMessage());
                i12 = 0;
                WLogger.d(f46020c, "on fetch camera exp:" + i10 + " min:" + i11 + " max:" + i12);
                return new int[]{i10, i11, i12};
            }
        } catch (Exception e12) {
            e = e12;
            i10 = 0;
            i11 = 0;
            WLogger.e(f46020c, "on fectch camera info failed:" + e.getLocalizedMessage());
            i12 = 0;
            WLogger.d(f46020c, "on fetch camera exp:" + i10 + " min:" + i11 + " max:" + i12);
            return new int[]{i10, i11, i12};
        }
        WLogger.d(f46020c, "on fetch camera exp:" + i10 + " min:" + i11 + " max:" + i12);
        return new int[]{i10, i11, i12};
    }

    public static void onFinish() {
        String str = f46020c;
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "on finished");
        int FRDoDetectionYuvs = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, f46035r);
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "on finished " + FRDoDetectionYuvs);
        if (FRDoDetectionYuvs == 0) {
            f46031n.a(YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin());
            return;
        }
        f46031n.a(FRDoDetectionYuvs, "JNI return failed", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: " + FRDoDetectionYuvs);
    }

    public static void onScreenChanged(int i10, int i11, int i12, int i13, float f10) {
        int argb = Color.argb(i10, i11, i12, i13);
        b bVar = f46028k;
        if (bVar == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(f46020c, "On reflection screen change failed:mReflectListener is null");
        } else {
            bVar.a(argb, f10);
        }
    }

    public static void onStateChanged(int i10) {
        f46033p = i10;
        String str = f46020c;
        WLogger.d(str, "on state changed call " + f46033p);
        try {
            if (i10 == 0) {
                WLogger.d(str, "onStateChanged:0 ");
                Camera.Parameters parameters = f46034q.getParameters();
                parameters.setAutoWhiteBalanceLock(true);
                f46034q.setParameters(parameters);
                return;
            }
            if (i10 == 1) {
                WLogger.d(str, "onStateChanged:1 ");
                com.tencent.cloud.huiyansdkface.facelight.process.c.a aVar = f46018a;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            if (i10 == 2) {
                WLogger.d(str, "onStateChanged:2 ");
                try {
                    Camera.Parameters parameters2 = f46034q.getParameters();
                    parameters2.setAutoWhiteBalanceLock(false);
                    f46034q.setParameters(parameters2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "light_state_change_2_cam_exception", e2.toString(), null);
                }
                onFinish();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            WLogger.e(f46020c, "on state changed:" + i10 + ",failed:" + e10.getLocalizedMessage());
        }
    }

    public static void pushImageData(byte[] bArr, int i10, int i11, long j10, int i12, float[] fArr, float f10, float f11, float f12) {
        String str = f46020c;
        WLogger.d(str, "Light pushImageData");
        int i13 = f46033p;
        if (i13 != 0) {
            if (i13 == 1) {
                YTAGReflectLiveCheckJNIInterface.nativeLog(str, "[ReflectController.onPreviewFrameReceived] record ios");
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(bArr, i10, i11);
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(com.tencent.cloud.huiyansdkface.facelight.c.b.a(j10));
                return;
            }
            return;
        }
        int FRGetConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin() - 2;
        int FRGetConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd() + 4;
        int FRGetTriggerTime = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetTriggerTime();
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "onPreviewFrameReceived. beginFrame: " + FRGetConfigBegin + " endFrame: " + FRGetConfigEnd + " currentFrame: " + FRGetTriggerTime);
        if (FRGetTriggerTime <= FRGetConfigBegin || FRGetTriggerTime >= FRGetConfigEnd) {
            return;
        }
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "onPreviewFrameReceived. insertYuv and time");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(bArr, i10, i11, j10, i12, fArr);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(com.tencent.cloud.huiyansdkface.facelight.c.b.a(j10));
    }

    public static synchronized void releaseModel() {
        synchronized (YTAGReflectLiveCheckInterface.class) {
            WLogger.d(f46020c, "releaseModel");
            try {
                f46027j.lock();
                int i10 = f46026i - 1;
                f46026i = i10;
                if (i10 <= 0) {
                    f46026i = 0;
                    f46018a = null;
                    f46028k = null;
                    CountDownTimer countDownTimer = f46030m;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        f46030m = null;
                    }
                    f46032o = null;
                    f46031n = null;
                    f46034q = null;
                }
                f46027j.unlock();
                YTAGReflectLiveCheckJNIInterface.clearInstance();
            } catch (Throwable th) {
                f46027j.unlock();
                throw th;
            }
        }
    }

    public static void setReflectListener(b bVar) {
        f46028k = bVar;
    }

    public static void setReflectNotice(com.tencent.cloud.huiyansdkface.facelight.process.c.a aVar) {
        f46018a = aVar;
    }

    public static void setSafetyLevel(int i10) {
        YTAGReflectLiveCheckJNIInterface.nativeLog(f46020c, "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: " + i10);
    }

    public static void setupConfig(String str, String str2) {
        if (str == "overlay_alpha") {
            try {
                f46037t = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                f46037t = 0;
            }
        }
    }

    public static void start(Context context, Camera camera, int i10, String str, c cVar) {
        String str2 = f46020c;
        YTAGReflectLiveCheckJNIInterface.nativeLog(str2, "[YTAGReflectLiveCheckInterface.start] ---");
        if (cVar == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(str2, "On reflection start failed:checkResult is null");
            return;
        }
        f46031n = cVar;
        if (f46026i <= 0) {
            cVar.a(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
            return;
        }
        f46035r = i10;
        f46036s = str;
        f46034q = camera;
        long[] jArr = new long[2];
        if (f46028k == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(str2, "On reflection start failed:mReflectListener is null");
        }
        b bVar = f46028k;
        YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(false, str, 0, jArr, bVar != null ? bVar.a() : -1.0f);
        YTAGReflectLiveCheckJNIInterface.nativeLog(str2, "output duration ms" + jArr[0] + " " + jArr[1]);
        b bVar2 = f46028k;
        if (bVar2 != null) {
            bVar2.a(jArr[0]);
        }
    }
}
