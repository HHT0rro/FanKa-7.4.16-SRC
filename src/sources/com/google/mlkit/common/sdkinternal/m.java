package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import java.util.UUID;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    @RecentlyNonNull
    public static final z7.c<?> f27057b = z7.c.a(m.class).b(z7.m.e(i.class)).b(z7.m.e(Context.class)).d(z.f27083a).c();

    /* renamed from: a, reason: collision with root package name */
    public final Context f27058a;

    public m(@NonNull Context context) {
        this.f27058a = context;
    }

    public static final /* synthetic */ m b(z7.d dVar) {
        return new m((Context) dVar.get(Context.class));
    }

    @RecentlyNonNull
    public synchronized String a() {
        String string = c().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        c().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    public final SharedPreferences c() {
        return this.f27058a.getSharedPreferences("com.google.mlkit.internal", 0);
    }
}
