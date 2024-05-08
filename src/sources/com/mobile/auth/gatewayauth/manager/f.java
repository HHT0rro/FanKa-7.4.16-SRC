package com.mobile.auth.gatewayauth.manager;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.VendorConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private SystemManager f37328a;

    /* renamed from: b, reason: collision with root package name */
    private a f37329b;

    /* renamed from: c, reason: collision with root package name */
    private a f37330c;

    /* renamed from: d, reason: collision with root package name */
    private a f37331d;

    /* renamed from: e, reason: collision with root package name */
    private d f37332e;

    public f(SystemManager systemManager, d dVar) {
        this.f37328a = systemManager;
        this.f37332e = dVar;
        this.f37329b = new com.mobile.auth.s.d(systemManager.e(), this.f37332e);
        this.f37330c = new com.mobile.auth.u.a(this.f37328a.e(), this.f37332e);
        this.f37331d = new com.mobile.auth.t.a(this.f37328a.e(), this.f37332e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r0 == 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        if (r0 == 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        return r6.f37331d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        return r6.f37330c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.mobile.auth.gatewayauth.manager.a a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = -1
            r1 = 0
            int r2 = r7.hashCode()     // Catch: java.lang.Throwable -> L45
            r3 = -1350608857(0xffffffffaf7f5827, float:-2.3223433E-10)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L2c
            r3 = 95009260(0x5a9b9ec, float:1.596098E-35)
            if (r2 == r3) goto L22
            r3 = 880617272(0x347d2738, float:2.3576729E-7)
            if (r2 == r3) goto L18
            goto L35
        L18:
            java.lang.String r2 = "cm_zyhl"
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> L45
            if (r7 == 0) goto L35
            r0 = 0
            goto L35
        L22:
            java.lang.String r2 = "cu_xw"
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> L45
            if (r7 == 0) goto L35
            r0 = 1
            goto L35
        L2c:
            java.lang.String r2 = "ct_sjl"
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> L45
            if (r7 == 0) goto L35
            r0 = 2
        L35:
            if (r0 == 0) goto L42
            if (r0 == r5) goto L3f
            if (r0 == r4) goto L3c
            return r1
        L3c:
            com.mobile.auth.gatewayauth.manager.a r7 = r6.f37331d     // Catch: java.lang.Throwable -> L45
            return r7
        L3f:
            com.mobile.auth.gatewayauth.manager.a r7 = r6.f37330c     // Catch: java.lang.Throwable -> L45
            return r7
        L42:
            com.mobile.auth.gatewayauth.manager.a r7 = r6.f37329b     // Catch: java.lang.Throwable -> L45
            return r7
        L45:
            r7 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r7)     // Catch: java.lang.Throwable -> L4a
            return r1
        L4a:
            r7 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.manager.f.a(java.lang.String):com.mobile.auth.gatewayauth.manager.a");
    }

    public List<a> a() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f37329b);
            arrayList.add(this.f37330c);
            arrayList.add(this.f37331d);
            return arrayList;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public boolean a(VendorSdkInfoManager vendorSdkInfoManager) {
        int i10;
        try {
            VendorConfig a10 = vendorSdkInfoManager.a(1);
            VendorConfig a11 = vendorSdkInfoManager.a(2);
            VendorConfig a12 = vendorSdkInfoManager.a(3);
            if (a10 != null) {
                this.f37329b.a(a10.getVendorAccessId(), a10.getVendorAccessSecret());
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (a11 != null) {
                this.f37330c.a(a11.getVendorAccessId(), a11.getVendorAccessSecret());
                i10++;
            }
            if (a12 != null) {
                this.f37331d.a(a12.getVendorAccessId(), a12.getVendorAccessSecret());
                i10++;
            }
            return i10 == 3;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }
}
