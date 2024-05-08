package com.tencent.turingface.sdk.mfa;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class A0PGF extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f45521a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f45522b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ITuringDeviceInfoProvider f45523c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f45524d;

    public A0PGF(AtomicBoolean atomicBoolean, HashMap hashMap, ITuringDeviceInfoProvider iTuringDeviceInfoProvider, Object obj) {
        this.f45521a = atomicBoolean;
        this.f45522b = hashMap;
        this.f45523c = iTuringDeviceInfoProvider;
        this.f45524d = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        if (this.f45521a.get()) {
            return;
        }
        try {
            HashMap hashMap = this.f45522b;
            String imei = this.f45523c.getImei();
            if (imei == null) {
                imei = "";
            }
            hashMap.put("274", imei);
            HashMap hashMap2 = this.f45522b;
            String imsi = this.f45523c.getImsi();
            if (imsi == null) {
                imsi = "";
            }
            hashMap2.put("276", imsi);
            HashMap hashMap3 = this.f45522b;
            String androidId = this.f45523c.getAndroidId();
            if (androidId == null) {
                androidId = "";
            }
            hashMap3.put("275", androidId);
        } catch (Throwable unused) {
        }
        synchronized (this.f45524d) {
            this.f45524d.notify();
        }
    }
}
