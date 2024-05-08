package com.bytedance.pangle.res.a;

import java.io.InputStream;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e extends j {

    /* renamed from: a, reason: collision with root package name */
    private long f10931a;

    public e(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.a.j
    public final synchronized void a(int i10) {
        if (i10 != -1) {
            this.f10931a += i10;
        }
    }

    public final synchronized long b() {
        return this.f10931a;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j10) {
        long skip;
        skip = super.skip(j10);
        this.f10931a += skip;
        return skip;
    }

    public final int a() {
        long b4 = b();
        if (b4 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            return (int) b4;
        }
        throw new ArithmeticException("The byte count " + b4 + " is too large to be converted to an int");
    }
}
