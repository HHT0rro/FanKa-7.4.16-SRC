package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
enum LittleEndianByteArray$UnsafeByteArray {
    UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.1
        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public long getLongLittleEndian(byte[] bArr, int i10) {
            return LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i10 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
        }

        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i10 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j10);
        }
    },
    UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.2
        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public long getLongLittleEndian(byte[] bArr, int i10) {
            return Long.reverseBytes(LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i10 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
        }

        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i10 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j10));
        }
    };

    private static final int BYTE_ARRAY_BASE_OFFSET;
    private static final Unsafe theUnsafe;

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
        BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        if (unsafe.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
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

    public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i10);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i10, long j10);
}
