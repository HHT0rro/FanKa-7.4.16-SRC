package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bg;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class bj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f9890a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bg.a f9891b;

    public bj(bg.a aVar, IOAdEvent iOAdEvent) {
        this.f9891b = aVar;
        this.f9890a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        IOAdEvent iOAdEvent = this.f9890a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f9890a.getType();
        if (x.J.equals(type)) {
            bg.this.a(this.f9890a);
            return;
        }
        if (x.M.equals(type)) {
            bg.this.f9884n = this.f9890a.getMessage();
            bg.this.q();
            return;
        }
        if (x.N.equals(type)) {
            bg.this.e(this.f9890a);
            return;
        }
        if (x.O.equals(type)) {
            bg.this.f(this.f9890a);
            return;
        }
        if (x.W.equals(type)) {
            bg.this.g(this.f9890a);
            return;
        }
        String str = "";
        int i10 = 0;
        int i11 = 0;
        r5 = false;
        boolean z10 = false;
        if (x.f10433r.equals(type)) {
            HashMap hashMap2 = (HashMap) this.f9890a.getData();
            if (hashMap2 != null) {
                str = (String) hashMap2.get("error_message");
                Object obj = hashMap2.get("error_code");
                Object obj2 = obj;
                if (obj == null) {
                    obj2 = 0;
                }
                i10 = ((Integer) obj2).intValue();
            }
            bg.this.b(str, i10);
            return;
        }
        if (x.L.equals(type)) {
            HashMap hashMap3 = (HashMap) this.f9890a.getData();
            if (hashMap3 != null) {
                str = (String) hashMap3.get("error_message");
                Object obj3 = hashMap3.get("error_code");
                Object obj4 = obj3;
                if (obj3 == null) {
                    obj4 = 0;
                }
                i11 = ((Integer) obj4).intValue();
            }
            bg.this.a(i11, str);
            return;
        }
        if (x.H.equals(type)) {
            bg.this.h(this.f9890a);
            return;
        }
        if (x.X.equals(type)) {
            bg.this.d();
            return;
        }
        if (x.Y.equals(type)) {
            bg.this.d(this.f9890a);
            return;
        }
        if (x.f10411aa.equals(type)) {
            bg.this.s();
            return;
        }
        if (x.f10412ab.equals(type)) {
            IOAdEvent iOAdEvent2 = this.f9890a;
            if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                z10 = "1".equals((String) hashMap.get("serverVerify"));
            }
            bg.this.b(z10);
            return;
        }
        if (x.f10413ac.equals(type)) {
            bg.this.b_();
            return;
        }
        if (x.f10414ad.equals(type)) {
            bg.this.c_();
            return;
        }
        if (x.K.equals(type)) {
            bg.this.b(this.f9890a);
            return;
        }
        if (x.f10415ae.equals(type)) {
            bg.this.a(this.f9890a.getMessage(), 1 == this.f9890a.getCode());
            return;
        }
        if (x.af.equals(type)) {
            bg.this.e(this.f9890a.getMessage());
            return;
        }
        if (x.ag.equals(type)) {
            bg.this.f(this.f9890a.getMessage());
            return;
        }
        if (x.ah.equals(type)) {
            bg.this.d(this.f9890a.getMessage());
            return;
        }
        if (x.D.equals(type)) {
            bg.this.g(this.f9890a.getMessage());
            return;
        }
        if (x.Z.equals(type)) {
            bg.this.t();
            return;
        }
        if (x.ai.equals(type)) {
            bg.this.b(this.f9890a.getMessage(), 1 == this.f9890a.getCode());
            return;
        }
        if (x.al.equals(type)) {
            bg.this.c(this.f9890a);
            return;
        }
        if (x.aj.equals(type)) {
            bg.this.u();
            return;
        }
        if (x.ak.equals(type)) {
            bg.this.v();
            return;
        }
        if (x.an.equals(type)) {
            bg.this.i(this.f9890a);
        } else if (x.ao.equals(type)) {
            bg.this.j(this.f9890a);
        } else if (x.am.equals(type)) {
            bg.this.k(this.f9890a);
        }
    }
}
