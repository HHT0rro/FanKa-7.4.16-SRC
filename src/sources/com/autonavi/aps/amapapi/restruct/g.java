package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fn;
import com.amap.api.col.p0003l.ks;
import com.amap.api.col.p0003l.kv;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HistoryLocationRecorder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    private File f9481b;

    /* renamed from: d, reason: collision with root package name */
    private Handler f9483d;

    /* renamed from: e, reason: collision with root package name */
    private String f9484e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9485f;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<f> f9480a = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f9482c = false;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f9486g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (g.this.f9482c) {
                return;
            }
            if (g.this.f9485f) {
                g.this.b();
                g.d(g.this);
            }
            if (g.this.f9483d != null) {
                g.this.f9483d.postDelayed(g.this.f9486g, 60000L);
            }
        }
    };

    public g(Context context, Handler handler) {
        this.f9484e = null;
        this.f9483d = handler;
        String path = context.getFilesDir().getPath();
        if (this.f9484e == null) {
            this.f9484e = com.autonavi.aps.amapapi.utils.j.l(context);
        }
        try {
            this.f9481b = new File(path, "hisloc");
        } catch (Throwable th) {
            kv.a(th);
        }
        a();
        Handler handler2 = this.f9483d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.f9486g);
            this.f9483d.postDelayed(this.f9486g, 60000L);
        }
    }

    public static /* synthetic */ boolean d(g gVar) {
        gVar.f9485f = false;
        return false;
    }

    public final void a(boolean z10) {
        if (!z10) {
            this.f9486g.run();
        }
        Handler handler = this.f9483d;
        if (handler != null) {
            handler.removeCallbacks(this.f9486g);
        }
        this.f9482c = true;
    }

    public final void b(f fVar) {
        if (this.f9480a.size() > 0) {
            int i10 = fVar.f9472a;
            if (i10 != 6 && i10 != 5) {
                if (this.f9480a.contains(fVar)) {
                    return;
                }
                if (this.f9480a.size() >= 10) {
                    this.f9480a.removeFirst();
                }
                this.f9480a.add(fVar);
                this.f9485f = true;
                return;
            }
            f last = this.f9480a.getLast();
            if (last.f9474c == fVar.f9474c && last.f9473b == fVar.f9473b && last.f9476e == fVar.f9476e) {
                return;
            }
            if (this.f9480a.size() >= 10) {
                this.f9480a.removeFirst();
            }
            this.f9480a.add(fVar);
            this.f9485f = true;
        }
    }

    public final void a(f fVar) {
        Iterator<f> it = this.f9480a.iterator2();
        f fVar2 = null;
        f fVar3 = null;
        int i10 = 0;
        while (it.hasNext()) {
            f next = it.next();
            if (next.f9472a == 1) {
                if (fVar3 == null) {
                    fVar3 = next;
                }
                i10++;
                fVar2 = next;
            }
        }
        if (fVar2 != null) {
            new Location(GeocodeSearch.GPS);
            if (fVar.f9475d - fVar2.f9475d < 20000 && com.autonavi.aps.amapapi.utils.j.a(new double[]{fVar.f9473b, fVar.f9474c, fVar2.f9473b, fVar2.f9474c}) < 20.0f) {
                return;
            }
        }
        if (i10 >= 5) {
            this.f9480a.remove(fVar3);
        }
        if (this.f9480a.size() >= 10) {
            this.f9480a.removeFirst();
        }
        this.f9480a.add(fVar);
        this.f9485f = true;
    }

    private static boolean b(ArrayList<d> arrayList, ArrayList<ks> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    public final List<f> a(ArrayList<d> arrayList, ArrayList<ks> arrayList2) {
        if (!b(arrayList, arrayList2)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        int i10 = 0;
        Iterator<f> it = this.f9480a.iterator2();
        while (it.hasNext()) {
            f next = it.next();
            if (currentTimeMillis - next.f9475d < 21600000000L) {
                arrayList3.add(next);
                i10++;
            }
            if (i10 == 10) {
                break;
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<f> it = this.f9480a.iterator2();
        while (it.hasNext()) {
            try {
                sb2.append(fn.b(com.autonavi.aps.amapapi.security.a.a(it.next().a().getBytes("UTF-8"), this.f9484e)) + "\n");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        String sb3 = sb2.toString();
        if (TextUtils.isEmpty(sb3)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.j.a(this.f9481b, sb3);
    }

    private void a() {
        LinkedList<f> linkedList = this.f9480a;
        if (linkedList == null || linkedList.size() <= 0) {
            Iterator<String> iterator2 = com.autonavi.aps.amapapi.utils.j.a(this.f9481b).iterator2();
            while (iterator2.hasNext()) {
                try {
                    String str = new String(com.autonavi.aps.amapapi.security.a.b(fn.b(iterator2.next()), this.f9484e), "UTF-8");
                    f fVar = new f();
                    fVar.a(new JSONObject(str));
                    this.f9480a.add(fVar);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
