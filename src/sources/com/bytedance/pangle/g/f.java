package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, SparseArray<m>> f10786a = new HashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a implements j {

        /* renamed from: a, reason: collision with root package name */
        private final MessageDigest[] f10787a;

        public a(MessageDigest[] messageDigestArr) {
            this.f10787a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) {
            ByteBuffer slice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.f10787a) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    @RequiresApi(api = 21)
    public static void a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, m mVar) {
        if (!map.isEmpty()) {
            ArrayMap arrayMap = new ArrayMap();
            boolean z10 = true;
            if (map.containsKey(1)) {
                arrayMap.put(1, map.get(1));
            }
            if (map.containsKey(2)) {
                arrayMap.put(2, map.get(2));
            }
            boolean z11 = false;
            if (!arrayMap.isEmpty()) {
                try {
                    a(arrayMap, randomAccessFile.getFD(), mVar);
                    z10 = false;
                } catch (IOException e2) {
                    throw new SecurityException("Cannot get FD", e2);
                }
            }
            if (map.containsKey(3)) {
                try {
                    if (!Arrays.equals(a(map.get(3), randomAccessFile.length(), mVar), g.a(randomAccessFile, mVar, new i() { // from class: com.bytedance.pangle.g.f.1
                        @Override // com.bytedance.pangle.g.i
                        public final ByteBuffer a(int i10) {
                            return ByteBuffer.allocate(i10);
                        }
                    }).f10790b)) {
                        throw new SecurityException("APK verity digest of contents did not verify");
                    }
                } catch (IOException | DigestException | NoSuchAlgorithmException e10) {
                    throw new SecurityException("Error during verification", e10);
                }
            } else {
                z11 = z10;
            }
            if (z11) {
                throw new SecurityException("No known digest exists for integrity check");
            }
            return;
        }
        throw new SecurityException("No digests provided");
    }

    public static String b(int i10) {
        if (i10 == 1) {
            return "SHA-256";
        }
        if (i10 == 2) {
            return "SHA-512";
        }
        if (i10 == 3) {
            return "SHA-256";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i10)));
    }

    public static String c(int i10) {
        if (i10 == 513 || i10 == 514) {
            return "EC";
        }
        if (i10 == 769) {
            return "DSA";
        }
        if (i10 == 1057) {
            return "RSA";
        }
        if (i10 == 1059) {
            return "EC";
        }
        if (i10 == 1061) {
            return "DSA";
        }
        switch (i10) {
            case 257:
            case 258:
            case 259:
            case 260:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i10 & (-1)));
        }
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> d(int i10) {
        if (i10 != 513) {
            if (i10 != 514) {
                if (i10 != 769) {
                    if (i10 != 1057) {
                        if (i10 != 1059) {
                            if (i10 != 1061) {
                                switch (i10) {
                                    case 257:
                                        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                    case 258:
                                        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                    case 259:
                                        break;
                                    case 260:
                                        return Pair.create("SHA512withRSA", null);
                                    default:
                                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i10 & (-1)));
                                }
                            }
                        }
                    }
                    return Pair.create("SHA256withRSA", null);
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    private static int e(int i10) {
        if (i10 == 1) {
            return 32;
        }
        if (i10 == 2) {
            return 64;
        }
        if (i10 == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i10)));
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i10) {
        if (i10 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i11 = i10 + position;
            if (i11 >= position && i11 <= limit) {
                byteBuffer.limit(i11);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i11);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: ".concat(String.valueOf(i10)));
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        int i10 = byteBuffer.getInt();
        if (i10 >= 0) {
            if (i10 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i10];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i10 + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private static void a(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, m mVar) {
        l lVar = new l(fileDescriptor, 0L, mVar.f10802b);
        long j10 = mVar.f10803c;
        l lVar2 = new l(fileDescriptor, j10, mVar.f10804d - j10);
        ByteBuffer duplicate = mVar.f10805e.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        long j11 = mVar.f10802b;
        s.a(duplicate);
        int position = duplicate.position() + 16;
        if (j11 >= 0 && j11 <= 4294967295L) {
            duplicate.putInt(duplicate.position() + position, (int) j11);
            h hVar = new h(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            Iterator<Integer> iterator2 = map.h().iterator2();
            int i10 = 0;
            while (iterator2.hasNext()) {
                iArr[i10] = iterator2.next().intValue();
                i10++;
            }
            try {
                byte[][] a10 = a(iArr, new k[]{lVar, lVar2, hVar});
                for (int i11 = 0; i11 < size; i11++) {
                    int i12 = iArr[i11];
                    if (!MessageDigest.isEqual(map.get(Integer.valueOf(i12)), a10[i11])) {
                        throw new SecurityException(b(i12) + " digest of contents did not verify");
                    }
                }
                return;
            } catch (DigestException e2) {
                throw new SecurityException("Failed to compute digest(s) of contents", e2);
            }
        }
        throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j11)));
    }

    private static byte[][] a(int[] iArr, k[] kVarArr) {
        int i10;
        long j10;
        long j11 = 0;
        long j12 = 0;
        int i11 = 0;
        while (true) {
            i10 = 3;
            j10 = 1048576;
            if (i11 >= 3) {
                break;
            }
            j12 += ((kVarArr[i11].a() + 1048576) - 1) / 1048576;
            i11++;
        }
        if (j12 < 2097151) {
            int i12 = (int) j12;
            byte[][] bArr = new byte[iArr.length];
            for (int i13 = 0; i13 < iArr.length; i13++) {
                byte[] bArr2 = new byte[(e(iArr[i13]) * i12) + 5];
                bArr2[0] = 90;
                a(i12, bArr2);
                bArr[i13] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i14 = 0; i14 < iArr.length; i14++) {
                String b4 = b(iArr[i14]);
                try {
                    messageDigestArr[i14] = MessageDigest.getInstance(b4);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(b4 + " digest not supported", e2);
                }
            }
            a aVar = new a(messageDigestArr);
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i15 < i10) {
                k kVar = kVarArr[i15];
                long j13 = j11;
                int i18 = i17;
                a aVar2 = aVar;
                long a10 = kVar.a();
                while (a10 > j11) {
                    int min = (int) Math.min(a10, j10);
                    a(min, bArr3);
                    for (int i19 = 0; i19 < length; i19++) {
                        messageDigestArr[i19].update(bArr3);
                    }
                    a aVar3 = aVar2;
                    long j14 = j13;
                    try {
                        kVar.a(aVar3, j14, min);
                        aVar2 = aVar3;
                        k kVar2 = kVar;
                        int i20 = 0;
                        while (i20 < iArr.length) {
                            int i21 = iArr[i20];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i20];
                            int e10 = e(i21);
                            int i22 = length;
                            MessageDigest messageDigest = messageDigestArr[i20];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i18 * e10) + 5, e10);
                            if (digest != e10) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                            i20++;
                            bArr3 = bArr4;
                            length = i22;
                            messageDigestArr = messageDigestArr2;
                        }
                        long j15 = min;
                        long j16 = j14 + j15;
                        a10 -= j15;
                        i18++;
                        j11 = 0;
                        j10 = 1048576;
                        kVar = kVar2;
                        bArr3 = bArr3;
                        j13 = j16;
                    } catch (IOException e11) {
                        throw new DigestException("Failed to digest chunk #" + i18 + " of section #" + i16, e11);
                    }
                }
                i16++;
                i15++;
                i17 = i18;
                aVar = aVar2;
                j11 = 0;
                i10 = 3;
                j10 = 1048576;
            }
            byte[][] bArr6 = new byte[iArr.length];
            for (int i23 = 0; i23 < iArr.length; i23++) {
                int i24 = iArr[i23];
                byte[] bArr7 = bArr[i23];
                String b10 = b(i24);
                try {
                    bArr6[i23] = MessageDigest.getInstance(b10).digest(bArr7);
                } catch (NoSuchAlgorithmException e12) {
                    throw new RuntimeException(b10 + " digest not supported", e12);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(j12)));
    }

    public static byte[] a(byte[] bArr, long j10, m mVar) {
        if (bArr.length == 40) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() == j10 - (mVar.f10803c - mVar.f10802b)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    public static int a(int i10, int i11) {
        int a10 = a(i10);
        int a11 = a(i11);
        if (a10 == 1) {
            if (a11 == 1) {
                return 0;
            }
            if (a11 == 2 || a11 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a11)));
        }
        if (a10 == 2) {
            if (a11 != 1) {
                if (a11 == 2) {
                    return 0;
                }
                if (a11 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a11)));
                }
            }
            return 1;
        }
        if (a10 != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(a10)));
        }
        if (a11 == 1) {
            return 1;
        }
        if (a11 == 2) {
            return -1;
        }
        if (a11 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a11)));
    }

    public static int a(int i10) {
        if (i10 == 513) {
            return 1;
        }
        if (i10 == 514) {
            return 2;
        }
        if (i10 == 769) {
            return 1;
        }
        if (i10 == 1057 || i10 == 1059 || i10 == 1061) {
            return 3;
        }
        switch (i10) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i10 & (-1)));
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i10) {
        if (i10 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i10 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i10);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i10 + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i10 + " < 8");
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i10 = byteBuffer.getInt();
            if (i10 >= 0) {
                if (i10 <= byteBuffer.remaining()) {
                    return b(byteBuffer, i10);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i10 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    private static void a(int i10, byte[] bArr) {
        bArr[1] = (byte) (i10 & 255);
        bArr[2] = (byte) ((i10 >>> 8) & 255);
        bArr[3] = (byte) ((i10 >>> 16) & 255);
        bArr[4] = (byte) ((i10 >>> 24) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0246  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r24, java.io.RandomAccessFile r25, int... r26) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.f.a(java.lang.String, java.io.RandomAccessFile, int[]):void");
    }
}
