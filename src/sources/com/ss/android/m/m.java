package com.ss.android.m;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m implements dk {

    /* renamed from: m, reason: collision with root package name */
    private final RandomAccessFile f38831m;

    public m(File file) throws FileNotFoundException {
        this.f38831m = new RandomAccessFile(file, t.f36226k);
    }

    @Override // com.ss.android.m.dk
    public void dk() throws IOException {
        this.f38831m.close();
    }

    @Override // com.ss.android.m.dk
    public long m() throws IOException {
        return this.f38831m.length();
    }

    @Override // com.ss.android.m.dk
    public int m(byte[] bArr, int i10, int i11) throws IOException {
        return this.f38831m.read(bArr, i10, i11);
    }

    @Override // com.ss.android.m.dk
    public void m(long j10, long j11) throws IOException {
        this.f38831m.seek(j10);
    }
}
