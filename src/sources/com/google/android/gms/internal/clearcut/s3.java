package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class s3 {
    public static void d(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i10 = 0;
        while (i10 < length) {
            try {
                char charAt = charSequence.charAt(i10);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i10, (byte) charAt);
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                int position2 = byteBuffer.position() + Math.max(i10, (position - byteBuffer.position()) + 1);
                char charAt2 = charSequence.charAt(i10);
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Failed writing ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(position2);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
        }
        if (i10 == length) {
            byteBuffer.position(position + i10);
            return;
        }
        position += i10;
        while (i10 < length) {
            char charAt3 = charSequence.charAt(i10);
            if (charAt3 < 128) {
                byteBuffer.put(position, (byte) charAt3);
            } else if (charAt3 < 2048) {
                int i11 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt3 >>> 6) | 192));
                    byteBuffer.put(i11, (byte) ((charAt3 & '?') | 128));
                    position = i11;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i11;
                    int position22 = byteBuffer.position() + Math.max(i10, (position - byteBuffer.position()) + 1);
                    char charAt22 = charSequence.charAt(i10);
                    StringBuilder sb22 = new StringBuilder(37);
                    sb22.append("Failed writing ");
                    sb22.append(charAt22);
                    sb22.append(" at index ");
                    sb22.append(position22);
                    throw new ArrayIndexOutOfBoundsException(sb22.toString());
                }
            } else {
                if (charAt3 >= 55296 && 57343 >= charAt3) {
                    int i12 = i10 + 1;
                    if (i12 != length) {
                        try {
                            char charAt4 = charSequence.charAt(i12);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                int i13 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    int i14 = i13 + 1;
                                    byteBuffer.put(i13, (byte) (((codePoint >>> 12) & 63) | 128));
                                    int i15 = i14 + 1;
                                    byteBuffer.put(i14, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i15, (byte) ((codePoint & 63) | 128));
                                    position = i15;
                                    i10 = i12;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i13;
                                    i10 = i12;
                                    int position222 = byteBuffer.position() + Math.max(i10, (position - byteBuffer.position()) + 1);
                                    char charAt222 = charSequence.charAt(i10);
                                    StringBuilder sb222 = new StringBuilder(37);
                                    sb222.append("Failed writing ");
                                    sb222.append(charAt222);
                                    sb222.append(" at index ");
                                    sb222.append(position222);
                                    throw new ArrayIndexOutOfBoundsException(sb222.toString());
                                }
                            } else {
                                i10 = i12;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                        }
                    }
                    throw new zzfi(i10, length);
                }
                int i16 = position + 1;
                byteBuffer.put(position, (byte) ((charAt3 >>> '\f') | 224));
                position = i16 + 1;
                byteBuffer.put(i16, (byte) (((charAt3 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt3 & '?') | 128));
            }
            i10++;
            position++;
        }
        byteBuffer.position(position);
    }

    public abstract int a(int i10, byte[] bArr, int i11, int i12);

    public abstract int b(CharSequence charSequence, byte[] bArr, int i10, int i11);

    public abstract void c(CharSequence charSequence, ByteBuffer byteBuffer);

    public final boolean e(byte[] bArr, int i10, int i11) {
        return a(0, bArr, i10, i11) == 0;
    }
}
