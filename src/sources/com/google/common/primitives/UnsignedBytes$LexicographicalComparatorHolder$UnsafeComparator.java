package com.google.common.primitives;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator implements Comparator<byte[]> {
    INSTANCE;

    public static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
    public static final int BYTE_ARRAY_BASE_OFFSET;
    public static final Unsafe theUnsafe;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        Unsafe unsafe = getUnsafe();
        theUnsafe = unsafe;
        int arrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
            throw new Error();
        }
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new a());
            }
        } catch (PrivilegedActionException e2) {
            throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
    }

    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        int i10 = min & (-8);
        int i11 = 0;
        while (i11 < i10) {
            Unsafe unsafe = theUnsafe;
            int i12 = BYTE_ARRAY_BASE_OFFSET;
            long j10 = i11;
            long j11 = unsafe.getLong(bArr, i12 + j10);
            long j12 = unsafe.getLong(bArr2, i12 + j10);
            if (j11 != j12) {
                if (BIG_ENDIAN) {
                    return UnsignedLongs.a(j11, j12);
                }
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(j11 ^ j12) & (-8);
                return ((int) ((j11 >>> numberOfTrailingZeros) & 255)) - ((int) ((j12 >>> numberOfTrailingZeros) & 255));
            }
            i11 += 8;
        }
        while (i11 < min) {
            int b4 = f.b(bArr[i11], bArr2[i11]);
            if (b4 != 0) {
                return b4;
            }
            i11++;
        }
        return bArr.length - bArr2.length;
    }
}
