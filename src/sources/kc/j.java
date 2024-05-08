package kc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.hv;
import com.xiaomi.push.m0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    public static volatile j f50808c;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f50809a;

    /* renamed from: b, reason: collision with root package name */
    public HashSet<a> f50810b = new HashSet<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public int f50811b;

        /* renamed from: c, reason: collision with root package name */
        public String f50812c;

        public a(int i10, String str) {
            this.f50811b = i10;
            this.f50812c = str;
        }

        public abstract void a();

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f50811b == ((a) obj).f50811b;
        }

        public int hashCode() {
            return this.f50811b;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();
        }
    }

    public j(Context context) {
        this.f50809a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static j d(Context context) {
        if (f50808c == null) {
            synchronized (j.class) {
                if (f50808c == null) {
                    f50808c = new j(context);
                }
            }
        }
        return f50808c;
    }

    public int a(int i10, int i11) {
        String j10 = j(i10);
        if (this.f50809a.contains(j10)) {
            return this.f50809a.getInt(j10, 0);
        }
        String b4 = b(i10);
        return this.f50809a.contains(b4) ? this.f50809a.getInt(b4, 0) : i11;
    }

    public final String b(int i10) {
        return "normal_oc_" + i10;
    }

    public String c(int i10, String str) {
        String j10 = j(i10);
        if (this.f50809a.contains(j10)) {
            return this.f50809a.getString(j10, null);
        }
        String b4 = b(i10);
        return this.f50809a.contains(b4) ? this.f50809a.getString(b4, null) : str;
    }

    public synchronized void e() {
        this.f50810b.clear();
    }

    public final void f(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            }
        } else {
            String str2 = (String) obj;
            if (str.equals(b(hv.AppIsInstalledList.a()))) {
                str2 = m0.a(str2);
            }
            editor.putString(str, str2);
        }
    }

    public void g(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.h.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f50809a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                f(edit, pair, b(((Integer) obj).intValue()));
            }
        }
        edit.commit();
    }

    public synchronized void h(a aVar) {
        if (!this.f50810b.contains(aVar)) {
            this.f50810b.add(aVar);
        }
    }

    public boolean i(int i10, boolean z10) {
        String j10 = j(i10);
        if (this.f50809a.contains(j10)) {
            return this.f50809a.getBoolean(j10, false);
        }
        String b4 = b(i10);
        return this.f50809a.contains(b4) ? this.f50809a.getBoolean(b4, false) : z10;
    }

    public final String j(int i10) {
        return "custom_oc_" + i10;
    }

    public void k() {
        fc.c.m("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f50810b);
        }
        Iterator iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            a aVar = (a) iterator2.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public void l(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.h.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f50809a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String j10 = j(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(j10);
                } else {
                    f(edit, pair, j10);
                }
            }
        }
        edit.commit();
    }
}
