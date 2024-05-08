package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("ConfigurationContentLoader.class")
    public static final Map<Uri, h> f25501c = new ArrayMap();

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f25502d = {"key", "value"};

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f25503a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentObserver f25504b;

    public static synchronized void a() {
        synchronized (h.class) {
            for (h hVar : f25501c.values()) {
                hVar.f25503a.unregisterContentObserver(hVar.f25504b);
            }
            f25501c.clear();
        }
    }
}
