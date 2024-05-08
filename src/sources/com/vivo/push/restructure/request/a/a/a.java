package com.vivo.push.restructure.request.a.a;

import com.vivo.push.restructure.request.a.a.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JsonParcel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f46341a;

    /* renamed from: b, reason: collision with root package name */
    private int f46342b;

    /* renamed from: c, reason: collision with root package name */
    private JSONArray f46343c;

    public a() {
        this.f46341a = 0;
        this.f46343c = new JSONArray();
    }

    public final void a(int i10) {
        this.f46343c.put(i10);
    }

    public final long b() throws JSONException {
        int i10 = this.f46341a;
        if (i10 >= this.f46342b) {
            return 0L;
        }
        JSONArray jSONArray = this.f46343c;
        this.f46341a = i10 + 1;
        return jSONArray.getLong(i10);
    }

    public final String c() throws JSONException {
        int i10 = this.f46341a;
        if (i10 >= this.f46342b) {
            return null;
        }
        JSONArray jSONArray = this.f46343c;
        this.f46341a = i10 + 1;
        return jSONArray.getString(i10);
    }

    public final String d() {
        JSONArray jSONArray = this.f46343c;
        return jSONArray != null ? jSONArray.toString() : "";
    }

    public final void a(long j10) {
        this.f46343c.put(j10);
    }

    public final void a(String str) {
        this.f46343c.put(str);
    }

    public a(String str) throws JSONException {
        this.f46341a = 0;
        JSONArray jSONArray = new JSONArray(str);
        this.f46343c = jSONArray;
        this.f46341a = 0;
        this.f46342b = jSONArray.length();
    }

    public final <T extends c> void a(List<T> list) {
        if (list != null) {
            this.f46343c.put(list.size());
            Iterator<T> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                this.f46343c.put(iterator2.next().a());
            }
            return;
        }
        this.f46343c.put((Object) null);
    }

    public final int a() throws JSONException {
        int i10 = this.f46341a;
        if (i10 >= this.f46342b) {
            return 0;
        }
        JSONArray jSONArray = this.f46343c;
        this.f46341a = i10 + 1;
        return jSONArray.getInt(i10);
    }

    public final <T extends c> void a(c.a<T> aVar, List<T> list) throws JSONException {
        T t2;
        int i10 = this.f46341a;
        if (i10 < this.f46342b ? this.f46343c.isNull(i10) : true) {
            this.f46341a++;
            return;
        }
        JSONArray jSONArray = this.f46343c;
        int i11 = this.f46341a;
        this.f46341a = i11 + 1;
        int i12 = jSONArray.getInt(i11);
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = this.f46341a;
            if (i14 < this.f46342b) {
                JSONArray jSONArray2 = this.f46343c;
                this.f46341a = i14 + 1;
                t2 = aVar.a(jSONArray2.getString(i14));
            } else {
                t2 = null;
            }
            list.add(t2);
        }
    }
}
