package com.bytedance.pangle.res.a;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g extends f {
    public g(i iVar) {
        super(iVar);
    }

    public final int[] a(int i10) {
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = readInt();
        }
        return iArr;
    }

    public final void b() {
        byte readByte = readByte();
        if (readByte != 0) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (byte) 0, Byte.valueOf(readByte)));
        }
    }

    @Override // com.bytedance.pangle.res.a.f, java.io.DataInput
    public final int skipBytes(int i10) {
        int i11 = 0;
        while (i11 < i10) {
            int skipBytes = super.skipBytes(i10 - i11);
            if (skipBytes <= 0) {
                break;
            }
            i11 += skipBytes;
        }
        return i11;
    }

    public final void a() {
        short readShort = readShort();
        if (readShort != 8) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (short) 8, Short.valueOf(readShort)));
        }
    }

    public final void b(int i10) {
        int readInt;
        while (true) {
            readInt = readInt();
            if (readInt != i10 && readInt >= 1835009) {
                break;
            } else {
                i10 = -1;
            }
        }
        if (readInt != 1835009) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", 1835009, Integer.valueOf(readInt)));
        }
    }
}
