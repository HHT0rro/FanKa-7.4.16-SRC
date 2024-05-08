package com.alibaba.security.biometrics.build;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.log.RPLogging;
import com.huawei.quickcard.base.Attributes;

/* compiled from: ABLogRecorder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ak implements al {

    /* renamed from: ba, reason: collision with root package name */
    private static final String f2220ba = "ABLogRecorder";

    /* renamed from: d, reason: collision with root package name */
    public static ak f2221d;

    /* renamed from: a, reason: collision with root package name */
    public ALBiometricsEventListener f2222a;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f2223b;

    /* renamed from: bb, reason: collision with root package name */
    private Bundle f2224bb;

    /* renamed from: c, reason: collision with root package name */
    public Handler f2225c;

    /* renamed from: e, reason: collision with root package name */
    public long f2226e;

    /* renamed from: f, reason: collision with root package name */
    public long f2227f;

    /* renamed from: g, reason: collision with root package name */
    public long f2228g;

    /* renamed from: h, reason: collision with root package name */
    public long f2229h;

    /* renamed from: i, reason: collision with root package name */
    public long f2230i;

    /* renamed from: j, reason: collision with root package name */
    public long f2231j;

    private ak() {
        HandlerThread handlerThread = new HandlerThread(f2220ba);
        this.f2223b = handlerThread;
        handlerThread.start();
        this.f2225c = new Handler(this.f2223b.getLooper());
    }

    public static ak b() {
        if (f2221d == null) {
            f2221d = new ak();
        }
        return f2221d;
    }

    public static void c() {
        HandlerThread handlerThread;
        try {
            ak akVar = f2221d;
            if (akVar != null && (handlerThread = akVar.f2223b) != null) {
                handlerThread.getLooper().quit();
            }
            f2221d = null;
        } catch (Throwable unused) {
        }
    }

    public final Bundle a() {
        if (this.f2224bb == null) {
            this.f2224bb = new Bundle();
        }
        return this.f2224bb;
    }

    private void b(String str, Bundle bundle) {
        if (a() == null || !a().containsKey(str)) {
            return;
        }
        bundle.putString(str, a().getString(str));
    }

    private void c(String str, Bundle bundle) {
        try {
            if ("10001".equals(str)) {
                this.f2226e = System.currentTimeMillis();
                return;
            }
            if ("10002".equals(str)) {
                long currentTimeMillis = System.currentTimeMillis() - this.f2226e;
                bundle.putString("time_key", "time_nav");
                bundle.putLong("time_time", currentTimeMillis);
                this.f2226e = System.currentTimeMillis();
                return;
            }
            if ("10003".equals(str)) {
                this.f2227f = System.currentTimeMillis();
                return;
            }
            if ("10033".equals(str)) {
                long currentTimeMillis2 = System.currentTimeMillis() - this.f2227f;
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", currentTimeMillis2);
                this.f2227f = System.currentTimeMillis();
                return;
            }
            if ("10031".equals(str)) {
                long currentTimeMillis3 = System.currentTimeMillis() - this.f2227f;
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", currentTimeMillis3);
            } else if ("10041".equals(str)) {
                this.f2231j = System.currentTimeMillis();
            } else if ("10042".equals(str)) {
                long currentTimeMillis4 = System.currentTimeMillis() - this.f2231j;
                bundle.putString("time_key", "time_result");
                bundle.putLong("time_time", currentTimeMillis4);
                this.f2231j = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(ALBiometricsEventListener aLBiometricsEventListener) {
        this.f2222a = aLBiometricsEventListener;
    }

    public final void a(Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString(Attributes.Component.STACK, a(th, " "));
        a("10099", bundle);
        th.printStackTrace();
    }

    public final void a(String str, Bundle bundle) {
        if (this.f2222a != null) {
            try {
                final Bundle bundle2 = new Bundle();
                bundle2.putString("code", str);
                bundle2.putString("eventId", str);
                if ("10000".equals(str)) {
                    b("vol_s", bundle2);
                } else if ("10003".equals(str)) {
                    b("cam_w", bundle2);
                    b("cam_h", bundle2);
                    b("cam_a", bundle2);
                    b("vol_s", bundle2);
                    b("nav", bundle2);
                    b("act_c", bundle2);
                    b("act_1", bundle2);
                    b("act_2", bundle2);
                    b("act_3", bundle2);
                    b("act_4", bundle2);
                    b("act_5", bundle2);
                    b("retry_m", bundle2);
                    b("fail_m", bundle2);
                    b("aju_to", bundle2);
                    b("act_to", bundle2);
                    b("act_th", bundle2);
                    b("act_wr_th", bundle2);
                    b("min_face_th", bundle2);
                    b("gblur_th", bundle2);
                    b("mblur_th", bundle2);
                    b("qua_th", bundle2);
                    b("no_face_th", bundle2);
                    b("gra", bundle2);
                } else if ("10001".equals(str)) {
                    b("gra", bundle2);
                } else if ("10002".equals(str)) {
                    b("gra", bundle2);
                } else if ("10007".equals(str)) {
                    b("hint_c", bundle2);
                    b("gra", bundle2);
                } else if ("10008".equals(str)) {
                    b("snd_c", bundle2);
                    b("gra", bundle2);
                } else if ("10011".equals(str)) {
                    b("err_tt", bundle2);
                } else if ("10012".equals(str)) {
                    b("retry_tt", bundle2);
                } else if ("10013".equals(str)) {
                    b("confirm", bundle2);
                } else if ("10025".equals(str)) {
                    b("vol_s", bundle2);
                } else if (!"10026".equals(str)) {
                    if ("10027".equals(str)) {
                        b("confirm", bundle2);
                    } else if (!"10028".equals(str) && !"10029".equals(str) && !"10030".equals(str)) {
                        if ("10031".equals(str)) {
                            b("succ", bundle2);
                            b("reason", bundle2);
                            b("vol_s", bundle2);
                        } else if ("10099".equals(str)) {
                            bundle2.putString("flsdkversion", VersionKey.FL_SDK_VERSION);
                            bundle2.putString("rpsdkversion", VersionKey.RP_SDK_VERSION);
                        }
                    }
                }
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                c(str, bundle2);
                this.f2225c.post(new Runnable() { // from class: com.alibaba.security.biometrics.build.ak.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            ALBiometricsEventListener aLBiometricsEventListener = ak.this.f2222a;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onOldLogRecord(bundle2);
                            }
                        } catch (Exception e2) {
                            RPLogging.e(ak.f2220ba, e2);
                        } catch (Throwable th) {
                            RPLogging.e(ak.f2220ba, th);
                        }
                    }
                });
            } catch (Exception e2) {
                RPLogging.e(f2220ba, e2);
            } catch (Throwable th) {
                RPLogging.e(f2220ba, th);
            }
        }
    }

    private static String a(Throwable th, String str) {
        if (th == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(th.getMessage());
        sb2.append(str);
        if (th.getStackTrace() != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb2.append((Object) stackTraceElement);
                sb2.append(str);
            }
        }
        return sb2.toString();
    }
}
