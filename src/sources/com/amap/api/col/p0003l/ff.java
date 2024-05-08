package com.amap.api.col.p0003l;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: TraceManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ff implements LocationSource.OnLocationChangedListener, LBSTraceBase {

    /* renamed from: b, reason: collision with root package name */
    private Context f5711b;

    /* renamed from: c, reason: collision with root package name */
    private CoordinateConverter f5712c;

    /* renamed from: d, reason: collision with root package name */
    private jd f5713d;

    /* renamed from: e, reason: collision with root package name */
    private jd f5714e;

    /* renamed from: h, reason: collision with root package name */
    private TraceStatusListener f5717h;

    /* renamed from: i, reason: collision with root package name */
    private aw f5718i;

    /* renamed from: n, reason: collision with root package name */
    private c f5723n;

    /* renamed from: f, reason: collision with root package name */
    private long f5715f = 2000;

    /* renamed from: g, reason: collision with root package name */
    private int f5716g = 5;

    /* renamed from: j, reason: collision with root package name */
    private List<TraceLocation> f5719j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private int f5720k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f5721l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f5722m = 0;

    /* renamed from: o, reason: collision with root package name */
    private TraceLocation f5724o = null;

    /* renamed from: p, reason: collision with root package name */
    private List<LatLng> f5725p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private List<LatLng> f5726q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    private List<LatLng> f5727r = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public int f5710a = Runtime.getRuntime().availableProcessors();

    /* renamed from: s, reason: collision with root package name */
    private BlockingQueue<Runnable> f5728s = new LinkedBlockingQueue();

    /* renamed from: t, reason: collision with root package name */
    private BlockingQueue<Runnable> f5729t = new LinkedBlockingQueue();

    /* compiled from: TraceManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b implements TraceListener {

        /* renamed from: b, reason: collision with root package name */
        private final List<TraceLocation> f5740b;

        public b(List<TraceLocation> list) {
            this.f5740b = list;
        }

        private void a(int i10, List<LatLng> list) {
            try {
                synchronized (ff.this.f5727r) {
                    ff.this.f5727r.clear();
                    ff.this.f5727r.addAll(list);
                }
                ff.this.f5726q.clear();
                if (i10 == 0) {
                    ff.this.f5726q.addAll(ff.this.f5727r);
                } else {
                    ff.this.f5726q.addAll(ff.this.f5725p);
                    ff.this.f5726q.addAll(ff.this.f5727r);
                }
                ff.this.f5717h.onTraceStatus(ff.this.f5719j, ff.this.f5726q, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i10, List<LatLng> list, int i11, int i12) {
            a(i10, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i10, String str) {
            ArrayList arrayList = new ArrayList();
            if (ff.this.f5727r != null) {
                arrayList.addAll(ff.this.f5727r);
            }
            List<TraceLocation> list = this.f5740b;
            if (list != null) {
                int size = list.size();
                if (this.f5740b.size() > ff.this.f5716g) {
                    for (int i11 = size - ff.this.f5716g; i11 < size; i11++) {
                        TraceLocation traceLocation = this.f5740b.get(i11);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i10, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i10, int i11, List<LatLng> list) {
        }
    }

    /* compiled from: TraceManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private TraceListener f5741a;

        public c(Looper looper) {
            super(looper);
        }

        public final void a(TraceListener traceListener) {
            this.f5741a = traceListener;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.f5741a == null || (data = message.getData()) == null) {
                    return;
                }
                int i10 = data.getInt("lineID");
                switch (message.what) {
                    case 100:
                        this.f5741a.onTraceProcessing(i10, message.arg1, (List) message.obj);
                        return;
                    case 101:
                        this.f5741a.onFinished(i10, (List) message.obj, message.arg1, message.arg2);
                        return;
                    case 102:
                        this.f5741a.onRequestFailed(i10, (String) message.obj);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public ff(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5711b = applicationContext;
        this.f5712c = new CoordinateConverter(applicationContext);
        this.f5723n = new c(Looper.getMainLooper());
        fo.a().a(this.f5711b);
        this.f5713d = dw.a(this.f5710a * 2, this.f5728s, "AMapTraceManagerProcess");
        this.f5714e = dw.a(this.f5710a * 2, this.f5729t, "AMapTraceManagerRequest");
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void destroy() {
        try {
            stopTrace();
            jd jdVar = this.f5713d;
            if (jdVar != null) {
                jdVar.e();
                this.f5713d = null;
            }
            jd jdVar2 = this.f5714e;
            if (jdVar2 != null) {
                jdVar2.e();
                this.f5714e = null;
            }
            this.f5719j = null;
            this.f5717h = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f5711b = null;
        this.f5712c = null;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        TraceStatusListener traceStatusListener;
        if (this.f5717h != null) {
            try {
                if (System.currentTimeMillis() - this.f5722m >= 30000 && (traceStatusListener = this.f5717h) != null) {
                    traceStatusListener.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.f5722m = System.currentTimeMillis();
                Bundle extras = location.getExtras();
                int i10 = extras.getInt("errorCode");
                if (i10 != 0) {
                    StringBuilder sb2 = new StringBuilder("Locate failed [errorCode:\"");
                    sb2.append(i10);
                    sb2.append("\"  errorInfo:");
                    sb2.append(extras.getString(MyLocationStyle.ERROR_INFO));
                    sb2.append("\"]");
                    return;
                }
                synchronized (this.f5719j) {
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    if (a(this.f5724o, traceLocation)) {
                        return;
                    }
                    this.f5719j.add(traceLocation);
                    this.f5724o = traceLocation;
                    int i11 = this.f5720k + 1;
                    this.f5720k = i11;
                    if (i11 == this.f5716g) {
                        this.f5721l += i11;
                        a();
                        this.f5720k = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void queryProcessedTrace(int i10, List<TraceLocation> list, int i11, TraceListener traceListener) {
        try {
            this.f5713d.a(new a(i10, list, i11, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setLocationInterval(long j10) {
        this.f5715f = j10;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setTraceStatusInterval(int i10) {
        this.f5716g = Math.max(i10, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void startTrace(TraceStatusListener traceStatusListener) {
        if (this.f5711b == null) {
            return;
        }
        this.f5722m = System.currentTimeMillis();
        this.f5717h = traceStatusListener;
        if (this.f5718i == null) {
            aw awVar = new aw(this.f5711b);
            this.f5718i = awVar;
            awVar.a(this.f5715f);
            this.f5718i.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void stopTrace() {
        b();
        c();
    }

    private static boolean a(TraceLocation traceLocation, TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    private void b() {
        aw awVar = this.f5718i;
        if (awVar != null) {
            awVar.deactivate();
            this.f5718i = null;
        }
    }

    private void c() {
        this.f5728s.clear();
        this.f5729t.clear();
        List<TraceLocation> list = this.f5719j;
        if (list != null) {
            synchronized (list) {
                List<TraceLocation> list2 = this.f5719j;
                if (list2 != null) {
                    list2.clear();
                }
                this.f5721l = 0;
                this.f5720k = 0;
                this.f5722m = 0L;
                this.f5724o = null;
            }
        }
    }

    private void a() {
        int size = this.f5719j.size();
        if (size < this.f5716g) {
            return;
        }
        if (size <= 50) {
            ArrayList arrayList = new ArrayList(this.f5719j);
            queryProcessedTrace(0, arrayList, 1, new b(arrayList));
            return;
        }
        int i10 = size - 50;
        if (i10 < 0) {
            return;
        }
        a(new ArrayList(this.f5719j.subList(i10 - this.f5716g, i10)));
        ArrayList arrayList2 = new ArrayList(this.f5719j.subList(i10, size));
        queryProcessedTrace(i10, arrayList2, 1, new b(arrayList2));
    }

    /* compiled from: TraceManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends je {

        /* renamed from: c, reason: collision with root package name */
        private int f5732c;

        /* renamed from: d, reason: collision with root package name */
        private int f5733d;

        /* renamed from: e, reason: collision with root package name */
        private List<TraceLocation> f5734e;

        /* renamed from: h, reason: collision with root package name */
        private TraceListener f5736h;

        /* renamed from: b, reason: collision with root package name */
        private List<TraceLocation> f5731b = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        private String f5735g = dp.a();

        public a(int i10, List<TraceLocation> list, int i11, TraceListener traceListener) {
            this.f5732c = i11;
            this.f5733d = i10;
            this.f5734e = list;
            this.f5736h = traceListener;
        }

        private int a() {
            List<TraceLocation> list = this.f5734e;
            int i10 = 0;
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (TraceLocation traceLocation : this.f5734e) {
                    if (traceLocation != null) {
                        if (traceLocation.getSpeed() < 0.01d) {
                            arrayList.add(traceLocation);
                        } else {
                            i10 += a(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return i10;
        }

        @Override // com.amap.api.col.p0003l.je
        public final void runTask() {
            try {
                ff.this.f5723n.a(this.f5736h);
                int a10 = a();
                List<TraceLocation> list = this.f5734e;
                if (list != null && list.size() >= 2) {
                    Iterator<TraceLocation> iterator2 = this.f5734e.iterator2();
                    while (iterator2.hasNext()) {
                        TraceLocation copy = iterator2.next().copy();
                        if (copy != null && copy.getLatitude() > ShadowDrawableWrapper.COS_45 && copy.getLongitude() > ShadowDrawableWrapper.COS_45) {
                            this.f5731b.add(copy);
                        }
                    }
                    int size = (this.f5731b.size() - 2) / 500;
                    fg.a().a(this.f5735g, this.f5733d, size, a10);
                    int i10 = 500;
                    int i11 = 0;
                    while (i11 <= size) {
                        if (i11 == size) {
                            i10 = this.f5731b.size();
                        }
                        int i12 = i10;
                        ArrayList arrayList = new ArrayList();
                        for (int i13 = 0; i13 < i12; i13++) {
                            TraceLocation remove = this.f5731b.remove(0);
                            if (remove != null) {
                                int i14 = this.f5732c;
                                if (i14 != 1) {
                                    if (i14 == 3) {
                                        ff.this.f5712c.from(CoordinateConverter.CoordType.BAIDU);
                                    } else if (i14 == 2) {
                                        ff.this.f5712c.from(CoordinateConverter.CoordType.GPS);
                                    }
                                    ff.this.f5712c.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                    LatLng convert = ff.this.f5712c.convert();
                                    if (convert != null) {
                                        remove.setLatitude(convert.latitude);
                                        remove.setLongitude(convert.longitude);
                                    }
                                }
                                arrayList.add(remove);
                            }
                        }
                        if (arrayList.size() >= 2 && arrayList.size() <= 500) {
                            final fe feVar = new fe(ff.this.f5711b, ff.this.f5723n, arrayList, this.f5735g, this.f5733d, i11);
                            ff.this.f5714e.a(new je() { // from class: com.amap.api.col.3l.ff.a.1
                                @Override // com.amap.api.col.p0003l.je
                                public final void runTask() {
                                    feVar.run();
                                }
                            });
                            i11++;
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                        i10 = i12;
                    }
                    return;
                }
                fg.a();
                fg.a(ff.this.f5723n, this.f5733d, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private static int a(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }
    }

    private void a(List<TraceLocation> list) {
        ff ffVar = this;
        synchronized (ffVar.f5727r) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                if (ffVar.f5727r.size() <= 0) {
                    return;
                }
                LatLng latLng = null;
                double d10 = ShadowDrawableWrapper.COS_45;
                TraceLocation traceLocation = null;
                double d11 = 0.0d;
                for (TraceLocation traceLocation2 : list) {
                    if (traceLocation2 != null) {
                        if (traceLocation != null) {
                            double a10 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                            if (a10 <= 100.0d) {
                                d11 += a10;
                            }
                        }
                        traceLocation = traceLocation2;
                    }
                }
                Iterator<LatLng> iterator2 = ffVar.f5727r.iterator2();
                while (iterator2.hasNext()) {
                    LatLng next = iterator2.next();
                    if (next == null) {
                        iterator2.remove();
                    } else {
                        if (latLng == null) {
                            ffVar.f5725p.add(next);
                            iterator2.remove();
                        } else {
                            Iterator<LatLng> it = iterator2;
                            try {
                                d10 += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                if (d10 >= d11) {
                                    break;
                                }
                                ffVar = this;
                                ffVar.f5725p.add(next);
                                it.remove();
                                iterator2 = it;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        latLng = next;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static double a(double d10, double d11, double d12, double d13) {
        double d14 = d10 > d12 ? d10 - d12 : d12 - d10;
        double d15 = d11 > d13 ? d11 - d13 : d13 - d11;
        return Math.sqrt((d14 * d14) + (d15 * d15));
    }
}
