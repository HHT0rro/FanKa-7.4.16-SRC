package com.xiaomi.push.service;

import com.xiaomi.push.service.j;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f48302b;

    public k(j jVar) {
        this.f48302b = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.f48302b.f48298d;
            Iterator iterator2 = concurrentHashMap.values().iterator2();
            while (iterator2.hasNext()) {
                ((j.a) iterator2.next()).run();
            }
        } catch (Exception e2) {
            fc.c.i("Sync job exception :" + e2.getMessage());
        }
        this.f48302b.f48297c = false;
    }
}
