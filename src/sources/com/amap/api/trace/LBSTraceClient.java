package com.amap.api.trace;

import android.content.Context;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.ff;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.fs;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = "定位超时";
    public static final String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
    public static final String TRACE_SUCCESS = "纠偏成功";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* renamed from: a, reason: collision with root package name */
    private static LBSTraceBase f9129a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile LBSTraceClient f9130b;

    public LBSTraceClient(Context context) throws Exception {
        a(context);
    }

    private static void a(Context context) throws Exception {
        fs a10 = fr.a(context, dx.a());
        if (a10.f5947a != fr.c.SuccessCode) {
            throw new Exception(a10.f5948b);
        }
        if (context != null) {
            f9129a = new ff(context.getApplicationContext());
        }
    }

    public static LBSTraceClient getInstance(Context context) throws Exception {
        if (f9130b == null) {
            synchronized (LBSTraceClient.class) {
                if (f9130b == null) {
                    a(context);
                    f9130b = new LBSTraceClient();
                }
            }
        }
        return f9130b;
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = f9129a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            a();
        }
    }

    public void queryProcessedTrace(int i10, List<TraceLocation> list, int i11, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = f9129a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i10, list, i11, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = f9129a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = f9129a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }

    private LBSTraceClient() {
    }

    private static void a() {
        f9129a = null;
        f9130b = null;
    }
}
