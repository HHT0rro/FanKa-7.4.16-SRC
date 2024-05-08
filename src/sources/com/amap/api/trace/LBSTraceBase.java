package com.amap.api.trace;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i10, List<TraceLocation> list, int i11, TraceListener traceListener);

    void setLocationInterval(long j10);

    void setTraceStatusInterval(int i10);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}
