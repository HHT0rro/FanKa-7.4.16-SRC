package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.fk;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AbstractProtocalHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class bw<T, V> {

    /* renamed from: a, reason: collision with root package name */
    public T f5178a;

    /* renamed from: b, reason: collision with root package name */
    public int f5179b = 3;

    /* renamed from: c, reason: collision with root package name */
    public Context f5180c;

    public bw(Context context, T t2) {
        a(context, t2);
    }

    private void a(Context context, T t2) {
        this.f5180c = context;
        this.f5178a = t2;
    }

    private V d() throws AMapException {
        int i10;
        String str;
        AMapException aMapException;
        int i11 = 0;
        V v2 = null;
        fk.b bVar = null;
        while (i11 < this.f5179b) {
            try {
                bVar = fk.a(this.f5180c, dx.a(), a(), b());
                v2 = a(a(bVar));
                i11 = this.f5179b;
            } finally {
                if (i11 < i10) {
                    continue;
                }
            }
        }
        return v2;
    }

    public abstract V a(JSONObject jSONObject) throws AMapException;

    public abstract String a();

    public abstract JSONObject a(fk.b bVar);

    public abstract Map<String, String> b();

    public final V c() throws AMapException {
        if (this.f5178a != null) {
            return d();
        }
        return null;
    }
}
