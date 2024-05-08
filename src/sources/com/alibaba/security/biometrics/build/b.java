package com.alibaba.security.biometrics.build;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.build.d;
import com.alibaba.security.biometrics.camera.size.AspectRatio;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: BaseCameraAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2256a = "CameraAdapter";

    /* renamed from: b, reason: collision with root package name */
    public static final int f2257b = 540;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2258c = 300;

    /* renamed from: d, reason: collision with root package name */
    public Point f2259d;

    /* renamed from: e, reason: collision with root package name */
    public Point f2260e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f2261f;

    /* renamed from: h, reason: collision with root package name */
    public d.a f2263h;

    /* renamed from: i, reason: collision with root package name */
    public int f2264i;

    /* renamed from: j, reason: collision with root package name */
    public int f2265j;

    /* renamed from: l, reason: collision with root package name */
    public ALBiometricsParams f2267l;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f2270o;

    /* renamed from: p, reason: collision with root package name */
    private int f2271p;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f2266k = false;

    /* renamed from: m, reason: collision with root package name */
    public int f2268m = 0;

    /* renamed from: n, reason: collision with root package name */
    private c f2269n = new c(this);

    /* renamed from: g, reason: collision with root package name */
    public Comparator<Point> f2262g = new C0030b();

    /* compiled from: BaseCameraAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements Comparator<Point> {

        /* renamed from: a, reason: collision with root package name */
        public float f2276a = 0.0f;

        public a() {
        }

        private int a(Point point, Point point2) {
            int i10;
            int i11 = point.x;
            if (i11 == 0 || (i10 = point.y) == 0) {
                return -100000;
            }
            if (point2.x == 0 || point2.y == 0) {
                return 100000;
            }
            return (int) ((Math.min(Math.abs(((i11 * 1.0f) / i10) - this.f2276a), Math.abs(((point.y * 1.0f) / point.x) - this.f2276a)) * 1000.0f) - (Math.min(Math.abs(((point2.x * 1.0f) / point2.y) - this.f2276a), Math.abs(((point2.y * 1.0f) / point2.x) - this.f2276a)) * 1000.0f));
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Point point, Point point2) {
            int i10;
            Point point3 = point;
            Point point4 = point2;
            int i11 = point3.x;
            if (i11 == 0 || (i10 = point3.y) == 0) {
                return -100000;
            }
            if (point4.x == 0 || point4.y == 0) {
                return 100000;
            }
            return (int) ((Math.min(Math.abs(((i11 * 1.0f) / i10) - this.f2276a), Math.abs(((point3.y * 1.0f) / point3.x) - this.f2276a)) * 1000.0f) - (Math.min(Math.abs(((point4.x * 1.0f) / point4.y) - this.f2276a), Math.abs(((point4.y * 1.0f) / point4.x) - this.f2276a)) * 1000.0f));
        }
    }

    /* compiled from: BaseCameraAdapter.java */
    /* renamed from: com.alibaba.security.biometrics.build.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class C0030b implements Comparator<Point> {

        /* renamed from: a, reason: collision with root package name */
        public int f2278a = 640;

        /* renamed from: b, reason: collision with root package name */
        public int f2279b = 480;

        public C0030b() {
        }

        private int a(Point point, Point point2) {
            int i10;
            int i11 = this.f2278a;
            int i12 = 0;
            if (i11 > 0) {
                i12 = Math.abs(i11 - point.x) + 0;
                i10 = 0 + Math.abs(this.f2278a - point2.x);
            } else {
                i10 = 0;
            }
            int i13 = this.f2279b;
            if (i13 > 0) {
                i12 += Math.abs(i13 - point.y);
                i10 += Math.abs(this.f2279b - point2.y);
            }
            return i12 - i10;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Point point, Point point2) {
            int i10;
            Point point3 = point;
            Point point4 = point2;
            int i11 = this.f2278a;
            int i12 = 0;
            if (i11 > 0) {
                i12 = Math.abs(i11 - point3.x) + 0;
                i10 = 0 + Math.abs(this.f2278a - point4.x);
            } else {
                i10 = 0;
            }
            int i13 = this.f2279b;
            if (i13 > 0) {
                i12 += Math.abs(i13 - point3.y);
                i10 += Math.abs(this.f2279b - point4.y);
            }
            return i12 - i10;
        }
    }

    /* compiled from: BaseCameraAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final b f2281a;

        public c(b bVar) {
            super(Looper.getMainLooper());
            this.f2281a = bVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public b(Context context, ALBiometricsParams aLBiometricsParams) {
        this.f2261f = context;
        this.f2267l = aLBiometricsParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Point b(List<Point> list) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(a(list, 300));
        if (linkedList.size() == 0) {
            linkedList.addAll(a(list, 0));
        }
        if (linkedList.size() == 0) {
            linkedList.addAll(list);
        }
        Collections.sort(linkedList, new a());
        return (Point) linkedList.get(0);
    }

    private static Point c(List<Point> list) {
        g gVar = new g();
        for (Point point : list) {
            f fVar = new f(point.x, point.y);
            Iterator<AspectRatio> iterator2 = gVar.f2299a.h().iterator2();
            while (true) {
                if (iterator2.hasNext()) {
                    AspectRatio next = iterator2.next();
                    int b4 = AspectRatio.b(fVar.f2297a, fVar.f2298b);
                    if (next.f2417b == fVar.f2297a / b4 && next.f2418c == fVar.f2298b / b4) {
                        SortedSet<f> sortedSet = gVar.f2299a.get(next);
                        if (!sortedSet.contains(fVar)) {
                            sortedSet.add(fVar);
                        }
                    }
                } else {
                    TreeSet treeSet = new TreeSet();
                    treeSet.add(fVar);
                    gVar.f2299a.put(AspectRatio.a(fVar.f2297a, fVar.f2298b), treeSet);
                    break;
                }
            }
        }
        SortedSet<f> a10 = gVar.a(AspectRatio.f2415a);
        if (a10 == null) {
            a10 = gVar.a(a(gVar));
        }
        f a11 = a(a10, 300);
        if (a11 == null) {
            a11 = a(a10, 0);
        }
        return new Point(a11.f2297a, a11.f2298b);
    }

    public abstract void a();

    @Override // com.alibaba.security.biometrics.build.d
    public final void a(d.a aVar) {
        if (this.f2266k) {
            return;
        }
        this.f2268m = 0;
        this.f2263h = aVar;
        a();
    }

    public abstract void b();

    public abstract void c();

    @Override // com.alibaba.security.biometrics.build.d
    public final void d() {
        if (this.f2266k) {
            b();
            this.f2263h = null;
            this.f2266k = false;
        }
    }

    public final void e() {
        this.f2269n.post(new Runnable() { // from class: com.alibaba.security.biometrics.build.b.2
            @Override // java.lang.Runnable
            public final void run() {
                d.a aVar = b.this.f2263h;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final String f() {
        HashMap hashMap = new HashMap();
        hashMap.put("previewWidth", Integer.valueOf(this.f2260e.x));
        hashMap.put("previewHeight", Integer.valueOf(this.f2260e.y));
        return JsonUtils.toJSON(hashMap);
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final Point g() {
        return this.f2260e;
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final byte[] h() {
        return this.f2270o;
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final int i() {
        return this.f2271p;
    }

    private Point d(List<Point> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, this.f2262g);
        int i10 = 0;
        for (Point point : list) {
            int i11 = point.x;
            if (i11 >= 600) {
                if (((double) Math.abs((((float) i11) / ((float) point.y)) - 0.0f)) <= 0.05d) {
                    break;
                }
            }
            i10++;
        }
        return list.get(i10 != list.size() ? i10 : 0);
    }

    public final void a(final int i10, final String str) {
        this.f2269n.post(new Runnable() { // from class: com.alibaba.security.biometrics.build.b.1
            @Override // java.lang.Runnable
            public final void run() {
                d.a aVar = b.this.f2263h;
                if (aVar != null) {
                    aVar.a(i10, str);
                }
            }
        });
    }

    public final void a(byte[] bArr, int i10) {
        if (this.f2263h == null || !this.f2266k) {
            return;
        }
        this.f2268m++;
        this.f2271p = i10;
        this.f2270o = bArr;
        d.a aVar = this.f2263h;
        Point point = this.f2260e;
        aVar.a(bArr, point.x, point.y, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Point a(List<Point> list) {
        if (!this.f2267l.cameraPreviewSizeSwitch) {
            if (list == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(a(list, 300));
            if (linkedList.size() == 0) {
                linkedList.addAll(a(list, 0));
            }
            if (linkedList.size() == 0) {
                linkedList.addAll(list);
            }
            Collections.sort(linkedList, new a());
            return (Point) linkedList.get(0);
        }
        g gVar = new g();
        for (Point point : list) {
            f fVar = new f(point.x, point.y);
            Iterator<AspectRatio> iterator2 = gVar.f2299a.h().iterator2();
            while (true) {
                if (iterator2.hasNext()) {
                    AspectRatio next = iterator2.next();
                    int b4 = AspectRatio.b(fVar.f2297a, fVar.f2298b);
                    if (next.f2417b == fVar.f2297a / b4 && next.f2418c == fVar.f2298b / b4) {
                        SortedSet<f> sortedSet = gVar.f2299a.get(next);
                        if (!sortedSet.contains(fVar)) {
                            sortedSet.add(fVar);
                        }
                    }
                } else {
                    TreeSet treeSet = new TreeSet();
                    treeSet.add(fVar);
                    gVar.f2299a.put(AspectRatio.a(fVar.f2297a, fVar.f2298b), treeSet);
                    break;
                }
            }
        }
        SortedSet<f> a10 = gVar.a(AspectRatio.f2415a);
        if (a10 == null) {
            a10 = gVar.a(a(gVar));
        }
        f a11 = a(a10, 300);
        if (a11 == null) {
            a11 = a(a10, 0);
        }
        return new Point(a11.f2297a, a11.f2298b);
    }

    private static f a(SortedSet<f> sortedSet, int i10) {
        Iterator<f> it = sortedSet.iterator2();
        f fVar = null;
        while (it.hasNext()) {
            fVar = it.next();
            if (Math.min(fVar.f2297a, fVar.f2298b) <= 540 && Math.min(fVar.f2297a, fVar.f2298b) >= i10) {
                break;
            }
        }
        return fVar;
    }

    private static List<Point> a(List<Point> list, int i10) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Point point : list) {
                if (Math.min(point.x, point.y) <= 540 && Math.min(point.x, point.y) >= i10) {
                    arrayList.add(point);
                }
            }
        }
        return arrayList;
    }

    private static boolean a(Point point, float f10) {
        return ((double) Math.abs((((float) point.x) / ((float) point.y)) - f10)) <= 0.05d;
    }

    private static AspectRatio a(g gVar) {
        Iterator<AspectRatio> iterator2 = gVar.f2299a.h().iterator2();
        AspectRatio aspectRatio = null;
        while (iterator2.hasNext()) {
            aspectRatio = iterator2.next();
            if (AspectRatio.f2415a.equals(aspectRatio)) {
                break;
            }
        }
        return aspectRatio;
    }
}
