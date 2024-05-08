package com.tencent.turingcam;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.turingface.sdk.mfa.A48DB;
import com.tencent.turingface.sdk.mfa.CFgXs;
import com.tencent.turingface.sdk.mfa.HDnuc;
import com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider;
import com.tencent.turingface.sdk.mfa.LJPko;
import com.tencent.turingface.sdk.mfa.ZIDl7;
import com.tencent.turingface.sdk.mfa.i3cNc;
import com.tencent.turingface.sdk.mfa.jb1kT;
import com.tencent.turingface.sdk.mfa.n6fHX;
import com.tencent.turingface.sdk.mfa.rBDKv;
import com.tencent.turingface.sdk.mfa.vneRm;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class y8N3A {

    /* renamed from: a, reason: collision with root package name */
    private static final y8N3A f45475a = new y8N3A();

    /* renamed from: b, reason: collision with root package name */
    public static final String f45476b = Build.MODEL;

    /* renamed from: c, reason: collision with root package name */
    private Context f45477c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ShGzN implements n6fHX {
        public ShGzN(y8N3A y8n3a) {
        }

        @Override // com.tencent.turingface.sdk.mfa.spXPg
        public boolean a() {
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SkEpO {

        /* renamed from: a, reason: collision with root package name */
        public int f45478a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f45479b = "";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements ITuringDeviceInfoProvider {
        public spXPg(y8N3A y8n3a) {
        }

        @Override // com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider
        public String getAndroidId() {
            return null;
        }

        @Override // com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider
        public String getImei() {
            return null;
        }

        @Override // com.tencent.turingface.sdk.mfa.ITuringDeviceInfoProvider
        public String getImsi() {
            return null;
        }
    }

    private y8N3A() {
    }

    public static y8N3A a() {
        return f45475a;
    }

    public SkEpO b() {
        vneRm a10;
        Context context = this.f45477c;
        int a11 = HDnuc.a();
        if (a11 != 0) {
            a10 = vneRm.a(a11);
        } else {
            a10 = rBDKv.f45926a.a(context, true, 1);
        }
        SkEpO skEpO = new SkEpO();
        skEpO.f45479b = a10.f45965a;
        skEpO.f45478a = a10.f45967c;
        return skEpO;
    }

    public byte[] c() {
        Context context = this.f45477c;
        com.tencent.turingface.sdk.mfa.CvowV cvowV = LJPko.f45634a;
        ZIDl7 zIDl7 = new ZIDl7();
        zIDl7.f45735b = 0;
        return LJPko.a(context, zIDl7, false);
    }

    public void a(TuringFaceBuilder turingFaceBuilder) {
        this.f45477c = turingFaceBuilder.getContext().getApplicationContext();
        HashSet hashSet = new HashSet();
        hashSet.add(17);
        hashSet.add(43);
        hashSet.add(40);
        hashSet.add(102);
        hashSet.add(114);
        hashSet.add(5);
        hashSet.add(4);
        jb1kT.spXPg spxpg = new jb1kT.spXPg(this.f45477c, new ShGzN(this));
        spxpg.f45822m = !TextUtils.isEmpty(turingFaceBuilder.getHostUrl()) ? turingFaceBuilder.getHostUrl() : "";
        spxpg.f45811b = 108098;
        spxpg.f45818i = true;
        spxpg.f45819j = true;
        spxpg.f45821l = new spXPg(this);
        spxpg.f45824o = 0L;
        spxpg.f45823n = turingFaceBuilder.getTuringNetwork();
        spxpg.f45825p = hashSet;
        spxpg.f45826q = f45476b;
        jb1kT jb1kt = new jb1kT(spxpg);
        HDnuc.f45600e = jb1kt;
        i3cNc.a(jb1kt.f45543e);
        AtomicBoolean atomicBoolean = HDnuc.f45599d;
        if (atomicBoolean.get()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(Locale.SIMPLIFIED_CHINESE, "TuringFD v%d", 77));
        sb2.append(" (7A239E5DD15748A2");
        sb2.append(", mfa");
        sb2.append(", 150176e");
        StringBuilder sb3 = new StringBuilder();
        if (sb3.toString().length() > 0) {
            sb3.append(";");
        }
        sb3.append("tss");
        if (sb3.toString().length() > 0) {
            sb3.append(";");
        }
        sb3.append("rfr");
        if (sb3.toString().length() > 0) {
            sb3.append(";");
        }
        sb3.append("ite");
        if (sb3.toString().length() > 0) {
            sb3.append(";");
        }
        sb3.append("rs");
        String sb4 = sb3.toString();
        if (!TextUtils.isEmpty(sb4)) {
            sb2.append(", ");
            sb2.append(sb4);
        }
        sb2.append(", ");
        StringBuilder sb5 = new StringBuilder();
        if (sb5.toString().length() > 0) {
            sb5.append(";");
        }
        sb5.append("wup");
        sb2.append(sb5.toString());
        sb2.append(String.format(Locale.SIMPLIFIED_CHINESE, ", compiled %s)", "2023_03_20_15_32_49"));
        com.tencent.turingface.sdk.mfa.CvowV cvowV = HDnuc.f45600e;
        if (cvowV != null) {
            sb2.append(" [");
            StringBuilder sb6 = new StringBuilder();
            StringBuilder b4 = oqKCa.b("url(");
            b4.append(cvowV.f45547i);
            b4.append(")");
            String sb7 = b4.toString();
            if (sb6.toString().length() > 0) {
                sb6.append(";");
            }
            sb6.append(sb7);
            String str = "c(" + cvowV.f45544f + ")";
            if (sb6.toString().length() > 0) {
                sb6.append(";");
            }
            sb6.append(str);
            if (cvowV.f45562x) {
                if (sb6.toString().length() > 0) {
                    sb6.append(";");
                }
                sb6.append("ext");
            }
            sb2.append(sb6.toString());
            sb2.append("]");
        }
        synchronized (HDnuc.f45598c) {
            int i10 = jb1kt.f45544f;
            if (i10 > 0) {
                oqKCa.f45455a = i10;
            }
            String str2 = jb1kt.f45564z;
            AtomicReference<String> atomicReference = CFgXs.f45537a;
            if (!TextUtils.isEmpty(str2)) {
                synchronized (atomicReference) {
                    atomicReference.set(str2);
                }
            }
            AtomicBoolean atomicBoolean2 = HDnuc.f45597b;
            if (atomicBoolean2.get()) {
                HDnuc.a(jb1kt);
                return;
            }
            if (atomicBoolean.get()) {
                return;
            }
            atomicBoolean.set(true);
            System.currentTimeMillis();
            if (HDnuc.b(jb1kt) != 0) {
                atomicBoolean2.set(false);
                return;
            }
            if (HDnuc.c(jb1kt) != 0) {
                atomicBoolean2.set(false);
                return;
            }
            if (oqKCa.f45455a == 0) {
                atomicBoolean2.set(false);
                return;
            }
            A48DB.f45525a.f45526b = jb1kt;
            HDnuc.a(jb1kt);
            atomicBoolean2.set(true);
            atomicBoolean.set(false);
        }
    }
}
