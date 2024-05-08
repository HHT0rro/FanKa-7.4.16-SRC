package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<Uri, b> f23812h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f23813i = {"key", "value"};

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f23814a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f23815b;

    /* renamed from: e, reason: collision with root package name */
    public volatile Map<String, String> f23818e;

    /* renamed from: d, reason: collision with root package name */
    public final Object f23817d = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final Object f23819f = new Object();

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("listenersLock")
    public final List<d> f23820g = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ContentObserver f23816c = new c(this, null);

    public b(ContentResolver contentResolver, Uri uri) {
        this.f23814a = contentResolver;
        this.f23815b = uri;
    }

    public static b a(ContentResolver contentResolver, Uri uri) {
        ConcurrentHashMap<Uri, b> concurrentHashMap = f23812h;
        b bVar = concurrentHashMap.get(uri);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(contentResolver, uri);
        b putIfAbsent = concurrentHashMap.putIfAbsent(uri, bVar2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        bVar2.f23814a.registerContentObserver(bVar2.f23815b, false, bVar2.f23816c);
        return bVar2;
    }

    public final Map<String, String> c() {
        Map<String, String> e2 = e.h("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? e() : this.f23818e;
        if (e2 == null) {
            synchronized (this.f23817d) {
                e2 = this.f23818e;
                if (e2 == null) {
                    e2 = e();
                    this.f23818e = e2;
                }
            }
        }
        return e2 != null ? e2 : Collections.emptyMap();
    }

    public final void d() {
        synchronized (this.f23817d) {
            this.f23818e = null;
        }
    }

    public final Map<String, String> e() {
        try {
            HashMap hashMap = new HashMap();
            Cursor query = this.f23814a.query(this.f23815b, f23813i, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        hashMap.put(query.getString(0), query.getString(1));
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
            }
            return hashMap;
        } catch (SQLiteException | SecurityException unused) {
            return null;
        }
    }

    public final void f() {
        synchronized (this.f23819f) {
            Iterator<d> iterator2 = this.f23820g.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().zzk();
            }
        }
    }
}
