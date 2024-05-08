package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;

/* compiled from: InfoCollectUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class dl {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5358a;

    /* renamed from: d, reason: collision with root package name */
    private static volatile dl f5359d;

    /* renamed from: b, reason: collision with root package name */
    private Hashtable<String, String> f5360b = new Hashtable<>();

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f5361c = null;

    private dl() {
    }

    public static dl a() {
        if (f5359d == null) {
            synchronized (dl.class) {
                if (f5359d == null) {
                    f5359d = new dl();
                }
            }
        }
        return f5359d;
    }

    public static void b() {
        if (f5359d != null) {
            if (f5359d.f5360b != null && f5359d.f5360b.size() > 0) {
                synchronized (f5359d.f5360b) {
                    f5359d.d();
                    if (f5359d.f5361c != null) {
                        f5359d.f5361c.clear();
                    }
                }
            }
            f5359d = null;
        }
        a(false);
    }

    public static boolean c() {
        return f5358a;
    }

    private void d() {
        WeakReference<Context> weakReference;
        if (!f5358a) {
            this.f5360b.clear();
            return;
        }
        if (this.f5360b != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i10 = 0;
            int size = this.f5360b.size();
            if (size > 0) {
                stringBuffer.append("[");
                Iterator<String> iterator2 = this.f5360b.values().iterator2();
                while (iterator2.hasNext()) {
                    i10++;
                    stringBuffer.append(iterator2.next());
                    if (i10 < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2) && (weakReference = this.f5361c) != null && weakReference.get() != null) {
                    ii.a(stringBuffer2, this.f5361c.get());
                }
            }
            this.f5360b.clear();
        }
    }

    private boolean e() {
        Hashtable<String, String> hashtable = this.f5360b;
        return hashtable != null && hashtable.size() > 20;
    }

    public static void a(boolean z10) {
        f5358a = z10;
    }

    public final void a(Context context) {
        if (context != null) {
            this.f5361c = new WeakReference<>(context);
        }
    }

    public final void a(LatLng latLng, String str, String str2) {
        if (!f5358a) {
            this.f5360b.clear();
            return;
        }
        if (latLng == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("\"lon\":");
        stringBuffer.append(latLng.longitude);
        stringBuffer.append(",");
        stringBuffer.append("\"lat\":");
        stringBuffer.append(latLng.latitude);
        stringBuffer.append(",");
        stringBuffer.append("\"title\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        stringBuffer.append("\"snippet\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        stringBuffer.append(i.f4738d);
        a(stringBuffer.toString());
    }

    private void a(String str) {
        Hashtable<String, String> hashtable;
        if (str == null || (hashtable = this.f5360b) == null) {
            return;
        }
        synchronized (hashtable) {
            String b4 = fq.b(str);
            Hashtable<String, String> hashtable2 = this.f5360b;
            if (hashtable2 != null && !hashtable2.contains(b4)) {
                this.f5360b.put(b4, str);
            }
            if (e()) {
                d();
            }
        }
    }
}
