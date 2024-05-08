package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.util.ParsableByteArray;
import e6.c;
import e6.e;
import java.util.List;

/* compiled from: DvbDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends c {

    /* renamed from: o, reason: collision with root package name */
    public final DvbParser f22221o;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        this.f22221o = new DvbParser(parsableByteArray.J(), parsableByteArray.J());
    }

    @Override // e6.c
    public e A(byte[] bArr, int i10, boolean z10) {
        if (z10) {
            this.f22221o.r();
        }
        return new b(this.f22221o.b(bArr, i10));
    }
}
