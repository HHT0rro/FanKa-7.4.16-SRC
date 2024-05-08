package com.google.android.gms.internal.vision;

import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("SharedPreferencesLoader.class")
    public static final Map<String, p> f25576c = new ArrayMap();

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f25577a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences.OnSharedPreferenceChangeListener f25578b;

    public static synchronized void a() {
        synchronized (p.class) {
            for (p pVar : f25576c.values()) {
                pVar.f25577a.unregisterOnSharedPreferenceChangeListener(pVar.f25578b);
            }
            f25576c.clear();
        }
    }
}
