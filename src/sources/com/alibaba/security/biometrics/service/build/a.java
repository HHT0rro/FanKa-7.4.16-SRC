package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.listener.OnLogTrackListener;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.log.RPLogging;
import com.huawei.quickcard.base.Attributes;

/* compiled from: ABLogRecorder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a implements b {
    private static final String bK = "ABLogRecorder";

    /* renamed from: f, reason: collision with root package name */
    public static a f2547f;
    private long bL;
    private long bM;
    private long bN;
    private long bO;
    private long bP;

    /* renamed from: d, reason: collision with root package name */
    public HandlerThread f2551d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f2552e;

    /* renamed from: a, reason: collision with root package name */
    public OnLogTrackListener f2548a = null;

    /* renamed from: b, reason: collision with root package name */
    public long f2549b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f2550c = 0;

    private a() {
        HandlerThread handlerThread = new HandlerThread("ab_log_recorder");
        this.f2551d = handlerThread;
        handlerThread.start();
        this.f2552e = new Handler(this.f2551d.getLooper());
    }

    public static a a() {
        if (f2547f == null) {
            f2547f = new a();
        }
        return f2547f;
    }

    public static void b() {
        HandlerThread handlerThread;
        try {
            a aVar = f2547f;
            if (aVar != null && (handlerThread = aVar.f2551d) != null) {
                handlerThread.getLooper().quit();
            }
            f2547f = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private long c() {
        return this.f2549b;
    }

    private int d() {
        return this.f2550c;
    }

    private void c(String str, Bundle bundle) {
        try {
            if ("10003".equals(str)) {
                this.bL = System.currentTimeMillis();
                return;
            }
            if ("10033".equals(str)) {
                long currentTimeMillis = System.currentTimeMillis() - this.bL;
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", currentTimeMillis);
                this.bL = System.currentTimeMillis();
                return;
            }
            if ("10031".equals(str)) {
                long currentTimeMillis2 = System.currentTimeMillis() - this.bL;
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", currentTimeMillis2);
                return;
            }
            if (b.f2667k.equals(str)) {
                this.bN = System.currentTimeMillis();
                return;
            }
            if (b.f2668l.equals(str)) {
                long currentTimeMillis3 = System.currentTimeMillis() - this.bN;
                bundle.putString("time_key", "time_liveness_adj");
                bundle.putLong("time_time", currentTimeMillis3);
                return;
            }
            if (b.f2669m.equals(str)) {
                this.bM = System.currentTimeMillis();
                return;
            }
            if (b.f2673q.equals(str)) {
                long currentTimeMillis4 = System.currentTimeMillis() - this.bM;
                bundle.putString("time_key", "time_liveness_act_" + bundle.getInt("act_type", -1));
                bundle.putInt("time_result", 1);
                bundle.putLong("time_time", currentTimeMillis4);
                return;
            }
            if (b.f2672p.equals(str)) {
                long currentTimeMillis5 = System.currentTimeMillis() - this.bM;
                bundle.putString("time_key", "time_liveness_act_" + bundle.getInt("act_type", -1));
                bundle.putInt("time_result", 0);
                bundle.putLong("time_time", currentTimeMillis5);
                return;
            }
            if (b.P.equals(str)) {
                this.bO = System.currentTimeMillis();
                return;
            }
            if (b.Q.equals(str)) {
                long currentTimeMillis6 = System.currentTimeMillis() - this.bO;
                bundle.putString("time_key", "time_liveness_rfl");
                bundle.putLong("time_time", currentTimeMillis6);
            } else if ("10041".equals(str)) {
                this.bP = System.currentTimeMillis();
            } else if ("10042".equals(str)) {
                long currentTimeMillis7 = System.currentTimeMillis() - this.bP;
                bundle.putString("time_key", "time_result");
                bundle.putLong("time_time", currentTimeMillis7);
                this.bP = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(OnLogTrackListener onLogTrackListener) {
        this.f2548a = onLogTrackListener;
    }

    private void a(long j10) {
        this.f2549b = j10;
    }

    private static void b(String str, Bundle bundle) {
        if (ABDetectContext.getInstance().getRecordData() == null || !ABDetectContext.getInstance().getRecordData().containsKey(str)) {
            return;
        }
        bundle.putString(str, ABDetectContext.getInstance().getRecordData().getString(str));
    }

    public final void a(int i10) {
        this.f2550c = i10;
    }

    public final void a(Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString(Attributes.Component.STACK, a(th, " "));
        a("10099", bundle);
        th.printStackTrace();
    }

    public final void a(String str, Bundle bundle) {
        if (this.f2548a != null) {
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
                } else if (b.f2667k.equals(str)) {
                    b("aju_c", bundle2);
                    b("gra", bundle2);
                } else if (b.f2668l.equals(str)) {
                    b("result", bundle2);
                    b("frm_c", bundle2);
                    b("bri", bundle2);
                    b("gblur", bundle2);
                    b("mblur", bundle2);
                    b("qua", bundle2);
                    b("gra", bundle2);
                } else if (b.f2669m.equals(str)) {
                    b("act_idx", bundle2);
                    b("act_type", bundle2);
                } else if ("10007".equals(str)) {
                    b("hint_c", bundle2);
                    b("gra", bundle2);
                } else if ("10008".equals(str)) {
                    b("snd_c", bundle2);
                    b("gra", bundle2);
                } else if (b.f2672p.equals(str)) {
                    b("result", bundle2);
                    b("frm_c", bundle2);
                    b("bri", bundle2);
                    b("gblur", bundle2);
                    b("mblur", bundle2);
                    b("qua", bundle2);
                    b("gra", bundle2);
                } else if (b.f2673q.equals(str)) {
                    b("fail_t", bundle2);
                    b("result", bundle2);
                    b("frm_c", bundle2);
                    b("gra", bundle2);
                } else if ("10011".equals(str)) {
                    b("err_tt", bundle2);
                } else if ("10012".equals(str)) {
                    b("retry_tt", bundle2);
                } else if ("10013".equals(str)) {
                    b("confirm", bundle2);
                } else if (b.f2677u.equals(str)) {
                    b("img1_ts", bundle2);
                    b("result", bundle2);
                    b("bri", bundle2);
                    b("gblur", bundle2);
                    b("mblur", bundle2);
                    b("qua", bundle2);
                    b("img2_ts", bundle2);
                    b("img3_ts", bundle2);
                    b("img4_ts", bundle2);
                    b("img5_ts", bundle2);
                } else if (!"10026".equals(str)) {
                    if ("10027".equals(str)) {
                        b("confirm", bundle2);
                    } else if ("10031".equals(str)) {
                        b("succ", bundle2);
                        b("reason", bundle2);
                        b("vol_s", bundle2);
                    } else if ("10099".equals(str)) {
                        bundle2.putString("flsdkversion", VersionKey.FL_SDK_VERSION);
                        bundle2.putString("rpsdkversion", VersionKey.RP_SDK_VERSION);
                    }
                }
                bundle2.putAll(bundle);
                c(str, bundle2);
                this.f2552e.post(new Runnable() { // from class: com.alibaba.security.biometrics.service.build.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            a.this.f2548a.onOldLogRecord(bundle2);
                        } catch (Exception e2) {
                            RPLogging.e(a.bK, e2);
                        } catch (Throwable th) {
                            RPLogging.e(a.bK, th);
                        }
                    }
                });
            } catch (Exception e2) {
                RPLogging.e(bK, e2);
            } catch (Throwable th) {
                RPLogging.e(bK, th);
            }
        }
    }

    public final void a(ALBiometricsParams aLBiometricsParams) {
        Bundle bundle = new Bundle();
        bundle.putInt("cam_w", ABDetectContext.getInstance().getDisplayWidth());
        bundle.putInt("cam_h", ABDetectContext.getInstance().getDisplayHeight());
        bundle.putInt("cam_a", ABDetectContext.getInstance().getRotationAngle());
        bundle.putFloat("act_th", aLBiometricsParams.activeActionThreshold);
        bundle.putFloat("act_wr_th", aLBiometricsParams.inactiveActionThreshold);
        int actionCount = ABDetectContext.getInstance().getActionCount();
        bundle.putInt("act_c", actionCount);
        if (actionCount > 0) {
            bundle.putInt("act_1", ABDetectContext.getInstance().getActions().get(0).getValue());
        }
        if (actionCount > 1) {
            bundle.putInt("act_2", ABDetectContext.getInstance().getActions().get(1).getValue());
        }
        if (actionCount > 2) {
            bundle.putInt("act_3", ABDetectContext.getInstance().getActions().get(2).getValue());
        }
        if (actionCount > 3) {
            bundle.putInt("act_4", ABDetectContext.getInstance().getActions().get(3).getValue());
        }
        if (actionCount > 4) {
            bundle.putInt("act_5", ABDetectContext.getInstance().getActions().get(4).getValue());
        }
        if (actionCount == 0) {
            bundle.putInt("act_c", aLBiometricsParams.actionCount);
        }
        bundle.putInt("retry_m", aLBiometricsParams.retryThreshold);
        bundle.putInt("fail_m", aLBiometricsParams.mineThreshold);
        bundle.putInt("aju_to", aLBiometricsParams.timeout);
        bundle.putInt("act_to", aLBiometricsParams.timeout);
        bundle.putInt("min_face_th", 100);
        bundle.putFloat("act_th", aLBiometricsParams.activeActionThreshold);
        bundle.putFloat("act_wr_th", aLBiometricsParams.inactiveActionThreshold);
        bundle.putFloat("no_face_th", aLBiometricsParams.noFaceThreshold);
        bundle.putFloat("qua_th", aLBiometricsParams.minQuality);
        bundle.putFloat("gblur_th", aLBiometricsParams.gaussianBlur);
        bundle.putFloat("mblur_th", aLBiometricsParams.motionBlur);
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        a("10003", bundle);
        ABDetectContext.getInstance().setFrameCount(0);
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
