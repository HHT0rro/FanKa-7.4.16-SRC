package com.tencent.turingcam;

import android.hardware.Camera;
import com.tencent.turingcam.kWj12;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class s7Dnc {

    /* renamed from: a, reason: collision with root package name */
    private final String f45456a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg {

        /* renamed from: a, reason: collision with root package name */
        public long f45457a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f45458b;
    }

    public s7Dnc(String str) {
        this.f45456a = str;
    }

    public abstract long a(kWj12.spXPg spxpg);

    public String a() {
        return this.f45456a;
    }

    public abstract boolean a(spXPg spxpg, Camera camera, wmqhz wmqhzVar);
}
