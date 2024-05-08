package com.tencent.turingcam;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.turingcam.kWj12;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ucT3w extends s7Dnc {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<View> f45459b;

    /* renamed from: c, reason: collision with root package name */
    private int f45460c;

    /* renamed from: d, reason: collision with root package name */
    private int f45461d;

    /* renamed from: e, reason: collision with root package name */
    private long f45462e;

    /* renamed from: f, reason: collision with root package name */
    private long f45463f;

    public ucT3w() {
        super("3");
        this.f45460c = 0;
        this.f45461d = 180;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public long a(kWj12.spXPg spxpg) {
        View b4 = spxpg.b();
        this.f45462e = System.currentTimeMillis();
        this.f45463f = spxpg.e();
        if (b4 == null) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1001L));
            return -1001L;
        }
        if (!(b4 instanceof com.tencent.turingcam.view.ShGzN)) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1002L));
            return -1002L;
        }
        int b10 = spxpg.b(180);
        if (b10 > 0) {
            this.f45461d = b10;
        }
        this.f45459b = new WeakReference<>(b4);
        this.f45460c = 0;
        hxUS9.b().a("checker_start_codes", a(), String.valueOf(0L));
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    @Override // com.tencent.turingcam.s7Dnc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.tencent.turingcam.s7Dnc.spXPg r18, android.hardware.Camera r19, com.tencent.turingcam.wmqhz r20) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.ucT3w.a(com.tencent.turingcam.s7Dnc$spXPg, android.hardware.Camera, com.tencent.turingcam.wmqhz):boolean");
    }

    private Bi3eT a(Bitmap bitmap, int i10) {
        Bi3eT bi3eT = new Bi3eT();
        bi3eT.f45389b = a();
        bi3eT.f45390c = i10;
        bi3eT.f45392e = bitmap.getWidth();
        bi3eT.f45393f = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        bi3eT.f45391d = byteArrayOutputStream.toByteArray();
        return bi3eT;
    }
}
