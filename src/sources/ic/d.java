package ic;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.t0;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public Context f49875a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, HashMap<String, gc.d>> f49876b;

    public d(Context context) {
        this.f49875a = context;
    }

    public static String d(gc.d dVar) {
        return String.valueOf(dVar.f49448a) + "#" + dVar.f49449b;
    }

    @Override // ic.e
    public void a() {
        t0.c(this.f49875a, "perf", "perfUploading");
        File[] f10 = t0.f(this.f49875a, "perfUploading");
        if (f10 == null || f10.length <= 0) {
            return;
        }
        for (File file : f10) {
            if (file != null) {
                List<String> e2 = g.e(this.f49875a, file.getAbsolutePath());
                file.delete();
                e(e2);
            }
        }
    }

    @Override // ic.f
    public void b() {
        HashMap<String, HashMap<String, gc.d>> hashMap = this.f49876b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> iterator2 = this.f49876b.h().iterator2();
            while (iterator2.hasNext()) {
                HashMap<String, gc.d> hashMap2 = this.f49876b.get(iterator2.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    gc.d[] dVarArr = new gc.d[hashMap2.size()];
                    hashMap2.values().toArray(dVarArr);
                    f(dVarArr);
                }
            }
        }
        this.f49876b.clear();
    }

    @Override // ic.b
    public void b(HashMap<String, HashMap<String, gc.d>> hashMap) {
        this.f49876b = hashMap;
    }

    @Override // ic.f
    public void c(gc.d dVar) {
        if ((dVar instanceof gc.c) && this.f49876b != null) {
            gc.c cVar = (gc.c) dVar;
            String d10 = d(cVar);
            String c4 = g.c(cVar);
            HashMap<String, gc.d> hashMap = this.f49876b.get(d10);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            gc.c cVar2 = (gc.c) hashMap.get(c4);
            if (cVar2 != null) {
                cVar.f49446i += cVar2.f49446i;
                cVar.f49447j += cVar2.f49447j;
            }
            hashMap.put(c4, cVar);
            this.f49876b.put(d10, hashMap);
        }
    }

    public void e(List<String> list) {
        throw null;
    }

    public void f(gc.d[] dVarArr) {
        String h10 = h(dVarArr[0]);
        if (TextUtils.isEmpty(h10)) {
            return;
        }
        g.g(h10, dVarArr);
    }

    public final String g(gc.d dVar) {
        String str;
        int i10 = dVar.f49448a;
        String str2 = dVar.f49449b;
        if (i10 <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i10) + "#" + str2;
        }
        File externalFilesDir = this.f49875a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            fc.c.n("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    public final String h(gc.d dVar) {
        String g3 = g(dVar);
        if (TextUtils.isEmpty(g3)) {
            return null;
        }
        for (int i10 = 0; i10 < 20; i10++) {
            String str = g3 + i10;
            if (t0.d(this.f49875a, str)) {
                return str;
            }
        }
        return null;
    }
}
