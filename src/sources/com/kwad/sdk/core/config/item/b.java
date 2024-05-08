package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b<T> {
    private T atk;
    private T atl;
    private String mKey;

    public b(String str, T t2) {
        this(str, t2, t2);
    }

    public static String dk(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.a.c.dH(str) : str;
    }

    public static String dl(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.a.c.dJ(str)) ? str : com.kwad.sdk.core.a.c.dI(str);
    }

    public final T CH() {
        return this.atk;
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.atl;
    }

    public abstract void k(JSONObject jSONObject);

    public final void setValue(T t2) {
        this.atl = t2;
    }

    private b(String str, T t2, T t10) {
        this.mKey = str;
        this.atl = t2;
        this.atk = t10;
        com.kwad.sdk.core.config.b.a(this);
    }
}
