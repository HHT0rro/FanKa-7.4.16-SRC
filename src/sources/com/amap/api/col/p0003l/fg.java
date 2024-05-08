package com.amap.api.col.p0003l;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TraceResultPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class fg {

    /* renamed from: b, reason: collision with root package name */
    private static volatile fg f5742b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f5743a;

    /* compiled from: TraceResultPool.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private int f5745b;

        /* renamed from: c, reason: collision with root package name */
        private int f5746c;

        /* renamed from: e, reason: collision with root package name */
        private int f5748e;

        /* renamed from: g, reason: collision with root package name */
        private HashMap<Integer, List<LatLng>> f5750g;

        /* renamed from: d, reason: collision with root package name */
        private int f5747d = 0;

        /* renamed from: f, reason: collision with root package name */
        private int f5749f = 0;

        /* renamed from: h, reason: collision with root package name */
        private List<LatLng> f5751h = new ArrayList();

        public a(int i10, int i11, int i12, HashMap<Integer, List<LatLng>> hashMap) {
            this.f5745b = 0;
            this.f5746c = 0;
            this.f5748e = 0;
            this.f5745b = i11;
            this.f5750g = hashMap;
            this.f5746c = i10;
            this.f5748e = i12;
        }

        private void b(Handler handler) {
            if (this.f5749f > 0) {
                int a10 = fd.a(this.f5751h);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = this.f5751h;
                obtainMessage.what = 101;
                obtainMessage.arg1 = a10;
                obtainMessage.arg2 = this.f5748e;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.f5746c);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                return;
            }
            fg.a(handler, this.f5746c, LBSTraceClient.MIN_GRASP_POINT_ERROR);
        }

        public final HashMap<Integer, List<LatLng>> a() {
            return this.f5750g;
        }

        public final void a(Handler handler) {
            List<LatLng> list;
            for (int i10 = this.f5747d; i10 <= this.f5745b && (list = this.f5750g.get(Integer.valueOf(i10))) != null; i10++) {
                this.f5751h.addAll(list);
                a(handler, list);
            }
            if (this.f5747d == this.f5745b + 1) {
                b(handler);
            }
        }

        private void a(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.f5747d;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.f5746c);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.f5747d++;
            this.f5749f++;
        }
    }

    public fg() {
        this.f5743a = null;
        this.f5743a = Collections.synchronizedMap(new HashMap());
    }

    public static fg a() {
        if (f5742b == null) {
            synchronized (fg.class) {
                if (f5742b == null) {
                    f5742b = new fg();
                }
            }
        }
        return f5742b;
    }

    public final synchronized void a(String str, int i10, List<LatLng> list) {
        Map<String, a> map = this.f5743a;
        if (map != null) {
            map.get(str).a().put(Integer.valueOf(i10), list);
        }
    }

    public final synchronized void a(String str, int i10, int i11, int i12) {
        Map<String, a> map = this.f5743a;
        if (map != null) {
            map.put(str, new a(i10, i11, i12, new HashMap(16)));
        }
    }

    public final synchronized a a(String str) {
        Map<String, a> map = this.f5743a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void a(Handler handler, int i10, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i10);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }
}
