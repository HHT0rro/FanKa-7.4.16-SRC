package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzbb implements Serializable, Iterable<Byte> {
    public static final zzbb zzfi = new zzbi(z0.f24121c);
    private static final b0 zzfj;
    private int zzfk = 0;

    static {
        z zVar = null;
        zzfj = u.b() ? new d0(zVar) : new a0(zVar);
    }

    public static int zzb(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Beginning index: ");
            sb2.append(i10);
            sb2.append(" < 0");
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < i10) {
            StringBuilder sb3 = new StringBuilder(66);
            sb3.append("Beginning index larger than ending index: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        StringBuilder sb4 = new StringBuilder(37);
        sb4.append("End index: ");
        sb4.append(i11);
        sb4.append(" >= ");
        sb4.append(i12);
        throw new IndexOutOfBoundsException(sb4.toString());
    }

    public static zzbb zzb(byte[] bArr, int i10, int i11) {
        return new zzbi(zzfj.a(bArr, i10, i11));
    }

    public static zzbb zzf(String str) {
        return new zzbi(str.getBytes(z0.f24119a));
    }

    public static c0 zzk(int i10) {
        return new c0(i10, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i10 = this.zzfk;
        if (i10 == 0) {
            int size = size();
            i10 = zza(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.zzfk = i10;
        }
        return i10;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public /* synthetic */ Iterator<Byte> iterator2() {
        return new z(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract int zza(int i10, int i11, int i12);

    public abstract zzbb zza(int i10, int i11);

    public abstract String zza(Charset charset);

    public abstract void zza(y yVar) throws IOException;

    public abstract boolean zzaa();

    public final int zzab() {
        return this.zzfk;
    }

    public abstract byte zzj(int i10);

    public final String zzz() {
        return size() == 0 ? "" : zza(z0.f24119a);
    }
}
