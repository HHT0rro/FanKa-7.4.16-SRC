package com.alibaba.security.realidentity.build;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.realidentity.build.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AbsRealIdentityEasyTrack.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3386a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f3387b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f3388c = 2;

    /* renamed from: d, reason: collision with root package name */
    public d f3389d;

    /* renamed from: e, reason: collision with root package name */
    public HandlerThread f3390e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f3391f;

    /* compiled from: AbsRealIdentityEasyTrack.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f3392a = new i();

        private a() {
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("rp_easytrack_thread");
        this.f3390e = handlerThread;
        handlerThread.start();
        this.f3391f = new Handler(this.f3390e.getLooper());
    }

    public static d a() {
        if (a.f3392a.f3389d == null) {
            a.f3392a.f3389d = l.a.f3948a.d();
        }
        return a.f3392a;
    }

    public void b() {
        d dVar = this.f3389d;
        if (dVar != null) {
            dVar.b();
        }
    }

    private static void a(d dVar) {
        a.f3392a.f3389d = dVar;
    }

    public void a(Map<String, Object> map) {
        d dVar = this.f3389d;
        if (dVar != null) {
            dVar.a(map);
        }
    }

    public void a(String str, String str2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        a(1, str, str2, hashMap2);
    }

    public void a(String str, String str2, Object obj, Object obj2, Object obj3, HashMap<String, String> hashMap) {
        d dVar = this.f3389d;
        if (dVar != null) {
            dVar.a(str, str2, obj, obj2, obj3, hashMap);
        }
    }

    public void a(int i10, String str, String str2, Map<String, Object> map) {
        d dVar = this.f3389d;
        if (dVar != null) {
            dVar.a(i10, str, str2, map);
        }
    }
}
