package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: PsshAtomUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k {

    /* compiled from: PsshAtomUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f20216a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20217b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f20218c;

        public a(UUID uuid, int i10, byte[] bArr) {
            this.f20216a = uuid;
            this.f20217b = i10;
            this.f20218c = bArr;
        }
    }

    public static byte[] a(UUID uuid, @Nullable byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    @Nullable
    public static a d(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.f() < 32) {
            return null;
        }
        parsableByteArray.P(0);
        if (parsableByteArray.n() != parsableByteArray.a() + 4 || parsableByteArray.n() != 1886614376) {
            return null;
        }
        int c4 = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        if (c4 > 1) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Unsupported pssh version: ");
            sb2.append(c4);
            com.google.android.exoplayer2.util.m.h("PsshAtomUtil", sb2.toString());
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.w(), parsableByteArray.w());
        if (c4 == 1) {
            parsableByteArray.Q(parsableByteArray.H() * 16);
        }
        int H = parsableByteArray.H();
        if (H != parsableByteArray.a()) {
            return null;
        }
        byte[] bArr2 = new byte[H];
        parsableByteArray.j(bArr2, 0, H);
        return new a(uuid, c4, bArr2);
    }

    @Nullable
    public static byte[] e(byte[] bArr, UUID uuid) {
        a d10 = d(bArr);
        if (d10 == null) {
            return null;
        }
        if (!uuid.equals(d10.f20216a)) {
            String valueOf = String.valueOf(uuid);
            String valueOf2 = String.valueOf(d10.f20216a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 33 + valueOf2.length());
            sb2.append("UUID mismatch. Expected: ");
            sb2.append(valueOf);
            sb2.append(", got: ");
            sb2.append(valueOf2);
            sb2.append(".");
            com.google.android.exoplayer2.util.m.h("PsshAtomUtil", sb2.toString());
            return null;
        }
        return d10.f20218c;
    }

    @Nullable
    public static UUID f(byte[] bArr) {
        a d10 = d(bArr);
        if (d10 == null) {
            return null;
        }
        return d10.f20216a;
    }

    public static int g(byte[] bArr) {
        a d10 = d(bArr);
        if (d10 == null) {
            return -1;
        }
        return d10.f20217b;
    }
}
