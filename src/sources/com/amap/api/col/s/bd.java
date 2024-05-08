package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WeatherSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class bd<T, V> extends f<T, V> {
    public bd(Context context, T t2) {
        super(context, t2);
    }

    @Override // com.amap.api.col.s.dz
    public String b() {
        return m.a() + "/weather/weatherInfo?";
    }

    public T c_() {
        return ((e) this).f7860b;
    }
}
