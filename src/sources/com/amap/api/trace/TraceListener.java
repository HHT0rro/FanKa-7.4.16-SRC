package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TraceListener {
    void onFinished(int i10, List<LatLng> list, int i11, int i12);

    void onRequestFailed(int i10, String str);

    void onTraceProcessing(int i10, int i11, List<LatLng> list);
}
