package com.tencent.turingcam;

import android.hardware.Camera;
import com.tencent.turingcam.kWj12;
import com.tencent.turingcam.s7Dnc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class yiZAu extends s7Dnc {

    /* renamed from: b, reason: collision with root package name */
    private int f45480b;

    /* renamed from: c, reason: collision with root package name */
    private long f45481c;

    /* renamed from: d, reason: collision with root package name */
    private int f45482d;

    /* renamed from: e, reason: collision with root package name */
    private float f45483e;

    /* renamed from: f, reason: collision with root package name */
    private int f45484f;

    /* renamed from: g, reason: collision with root package name */
    private int f45485g;

    /* renamed from: h, reason: collision with root package name */
    private int f45486h;

    /* renamed from: i, reason: collision with root package name */
    private long f45487i;

    public yiZAu() {
        super("5");
        this.f45481c = 0L;
        this.f45482d = 0;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public long a(kWj12.spXPg spxpg) {
        Camera.Parameters parameters = spxpg.a().getParameters();
        if (parameters.getMaxExposureCompensation() == parameters.getMinExposureCompensation()) {
            return -1002L;
        }
        this.f45480b = parameters.getExposureCompensation();
        this.f45484f = spxpg.e(300);
        this.f45485g = spxpg.d(1000);
        this.f45486h = spxpg.c(300);
        this.f45483e = spxpg.c();
        this.f45482d = 0;
        this.f45481c = System.currentTimeMillis();
        this.f45487i = System.currentTimeMillis();
        return 0L;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public boolean a(s7Dnc.spXPg spxpg, Camera camera, wmqhz wmqhzVar) {
        if (System.currentTimeMillis() - this.f45487i < this.f45486h) {
            return false;
        }
        float f10 = this.f45483e;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setExposureCompensation(Math.max(Math.min(Math.round(f10 / parameters.getExposureCompensationStep()), parameters.getMaxExposureCompensation()), parameters.getMinExposureCompensation()));
        camera.setParameters(parameters);
        Camera.Parameters parameters2 = camera.getParameters();
        int i10 = parameters2.getPreviewSize().width;
        int i11 = parameters2.getPreviewSize().height;
        if (System.currentTimeMillis() - this.f45481c > this.f45484f) {
            int i12 = (int) (i10 * 0.1f);
            int i13 = (int) (i11 * 0.1f);
            byte[] bArr = new byte[i12 * i13];
            byte[] bArr2 = spxpg.f45458b;
            int i14 = (i11 - i13) / 2;
            int i15 = (i10 - i12) / 2;
            for (int i16 = 0; i16 < i13; i16++) {
                System.arraycopy((Object) bArr2, ((i14 + i16) * i10) + i15, (Object) bArr, i12 * i16, i12);
            }
            Bi3eT bi3eT = new Bi3eT();
            bi3eT.f45389b = a();
            int i17 = this.f45482d;
            this.f45482d = i17 + 1;
            bi3eT.f45390c = i17;
            bi3eT.f45392e = i12;
            bi3eT.f45393f = i13;
            bi3eT.f45391d = bArr;
            wmqhzVar.f45473c.add(bi3eT);
            this.f45481c = System.currentTimeMillis();
            if (this.f45482d >= this.f45485g / this.f45484f) {
                parameters2.setExposureCompensation(this.f45480b);
                camera.setParameters(parameters2);
                return true;
            }
        }
        return false;
    }
}
