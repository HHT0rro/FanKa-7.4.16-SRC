package com.vivo.push;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: BundleWapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f46146a;

    /* renamed from: b, reason: collision with root package name */
    private String f46147b;

    /* renamed from: c, reason: collision with root package name */
    private String f46148c;

    public d(String str, String str2, Bundle bundle) {
        this.f46147b = str;
        this.f46148c = str2;
        this.f46146a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.push.d a(android.content.Intent r6) {
        /*
            java.lang.String r0 = "BundleWapper"
            r1 = 0
            if (r6 != 0) goto Lb
            java.lang.String r6 = "create error : intent is null"
            com.vivo.push.util.u.a(r0, r6)
            return r1
        Lb:
            android.os.Bundle r2 = r6.getExtras()
            if (r2 == 0) goto L1e
            java.lang.String r3 = "client_pkgname"
            java.lang.String r3 = r2.getString(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L1e
            goto L1f
        L1e:
            r3 = r1
        L1f:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L2a
            java.lang.String r4 = "create warning: pkgName is null"
            com.vivo.push.util.u.b(r0, r4)
        L2a:
            java.lang.String r4 = r6.getPackage()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L4f
            android.content.ComponentName r4 = r6.getComponent()
            if (r4 != 0) goto L3b
            goto L43
        L3b:
            android.content.ComponentName r6 = r6.getComponent()
            java.lang.String r1 = r6.getPackageName()
        L43:
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L4e
            java.lang.String r6 = "create warning: targetPkgName is null"
            com.vivo.push.util.u.b(r0, r6)
        L4e:
            r4 = r1
        L4f:
            com.vivo.push.d r6 = new com.vivo.push.d
            r6.<init>(r3, r4, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.d.a(android.content.Intent):com.vivo.push.d");
    }

    public final int b(String str, int i10) {
        Bundle bundle = this.f46146a;
        return bundle == null ? i10 : bundle.getInt(str, i10);
    }

    public final ArrayList<String> c(String str) {
        Bundle bundle = this.f46146a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final Serializable d(String str) {
        Bundle bundle = this.f46146a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(String str) {
        Bundle bundle = this.f46146a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    public final byte[] b(String str) {
        Bundle bundle = this.f46146a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final long b(String str, long j10) {
        Bundle bundle = this.f46146a;
        return bundle == null ? j10 : bundle.getLong(str, j10);
    }

    public final Bundle b() {
        return this.f46146a;
    }

    public final void a(String str, int i10) {
        if (this.f46146a == null) {
            this.f46146a = new Bundle();
        }
        this.f46146a.putInt(str, i10);
    }

    public final void a(String str, long j10) {
        if (this.f46146a == null) {
            this.f46146a = new Bundle();
        }
        this.f46146a.putLong(str, j10);
    }

    public final void a(String str, String str2) {
        if (this.f46146a == null) {
            this.f46146a = new Bundle();
        }
        this.f46146a.putString(str, str2);
    }

    public final void a(String str, byte[] bArr) {
        if (this.f46146a == null) {
            this.f46146a = new Bundle();
        }
        this.f46146a.putByteArray(str, bArr);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f46146a == null) {
            this.f46146a = new Bundle();
        }
        this.f46146a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z10) {
        if (this.f46146a == null) {
            this.f46146a = new Bundle();
        }
        this.f46146a.putBoolean(str, z10);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f46146a == null) {
            this.f46146a = new Bundle();
        }
        this.f46146a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        Bundle bundle = this.f46146a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final String a() {
        return this.f46147b;
    }
}
