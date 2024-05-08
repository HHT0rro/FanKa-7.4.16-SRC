package com.tencent.turingcam;

import android.hardware.Camera;
import android.text.TextUtils;
import com.tencent.turingcam.EQsUZ;
import com.tencent.turingcam.kWj12;
import com.tencent.turingcam.s7Dnc;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class nyvKz extends s7Dnc {

    /* renamed from: b, reason: collision with root package name */
    private static final String f45448b = WOMZP.b("XrAtCLyRZD+iVG+xiPkUocfEh7sxA2as2/upDg==");

    /* renamed from: c, reason: collision with root package name */
    private static final String f45449c = WOMZP.b("QkyoZDoA2EfeXs1uxHxbayaYRl76hMTg");

    /* renamed from: d, reason: collision with root package name */
    private String f45450d;

    /* renamed from: e, reason: collision with root package name */
    private int f45451e;

    /* renamed from: f, reason: collision with root package name */
    private int f45452f;

    /* renamed from: g, reason: collision with root package name */
    private int f45453g;

    /* renamed from: h, reason: collision with root package name */
    private long f45454h;

    public nyvKz() {
        super("4");
        this.f45452f = -1;
        this.f45454h = 0L;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public long a(kWj12.spXPg spxpg) {
        this.f45452f = -1;
        this.f45450d = spxpg.d();
        this.f45451e = spxpg.a(5);
        Camera a10 = spxpg.a();
        EQsUZ.spXPg spxpg2 = new EQsUZ.spXPg();
        if (!EQsUZ.a(a10, f45448b, spxpg2)) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1001L));
            return -1001L;
        }
        this.f45453g = ((Integer) spxpg2.a()).intValue();
        if (a10 != null && !TextUtils.isEmpty(this.f45450d)) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(0L));
            return 0L;
        }
        hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1001L));
        return -1001L;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public boolean a(s7Dnc.spXPg spxpg, Camera camera, wmqhz wmqhzVar) {
        if (this.f45452f < 0) {
            byte[] bArr = spxpg.f45458b;
            byte[] bytes = this.f45450d.getBytes();
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
            System.arraycopy((Object) bytes, 0, (Object) bArr2, 0, bytes.length);
            WeakReference weakReference = new WeakReference(camera);
            Class<Integer> cls = Integer.TYPE;
            if (!EQsUZ.a(camera, f45449c, new Class[]{Object.class, cls, cls, cls, Object.class}, new Object[]{weakReference, Integer.valueOf(this.f45453g), 0, 0, bArr2})) {
                return true;
            }
            this.f45454h = System.currentTimeMillis();
            this.f45452f++;
            return false;
        }
        if (this.f45454h > spxpg.f45457a) {
            return false;
        }
        int length = this.f45450d.getBytes().length;
        byte[] bArr3 = new byte[length];
        System.arraycopy((Object) spxpg.f45458b, 0, (Object) bArr3, 0, length);
        Bi3eT bi3eT = new Bi3eT();
        bi3eT.f45389b = a();
        bi3eT.f45390c = this.f45452f;
        bi3eT.f45391d = bArr3;
        wmqhzVar.f45473c.add(bi3eT);
        Arrays.equals(bArr3, this.f45450d.getBytes());
        int i10 = this.f45452f + 1;
        this.f45452f = i10;
        return i10 > this.f45451e;
    }
}
