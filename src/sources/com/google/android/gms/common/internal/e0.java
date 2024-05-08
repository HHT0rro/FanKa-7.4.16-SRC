package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static Object f23675a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f23676b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static String f23677c;

    /* renamed from: d, reason: collision with root package name */
    public static int f23678d;

    public static int a(Context context) {
        b(context);
        return f23678d;
    }

    public static void b(Context context) {
        Bundle bundle;
        synchronized (f23675a) {
            if (f23676b) {
                return;
            }
            f23676b = true;
            try {
                bundle = d7.b.a(context).b(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            f23677c = bundle.getString("com.google.app.id");
            f23678d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
