package com.tencent.cloud.huiyansdkface.okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public final ByteString[] byteStrings;
    public final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j10, Buffer buffer, int i10, List<ByteString> list, int i11, int i12, List<Integer> list2) {
        int i13;
        int i14;
        int i15;
        Buffer buffer2;
        int i16 = i11;
        if (i16 >= i12) {
            throw new AssertionError();
        }
        for (int i17 = i16; i17 < i12; i17++) {
            if (list.get(i17).size() < i10) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i11);
        ByteString byteString2 = list.get(i12 - 1);
        int i18 = -1;
        if (i10 == byteString.size()) {
            i18 = list2.get(i16).intValue();
            i16++;
            byteString = list.get(i16);
        }
        int i19 = i16;
        if (byteString.getByte(i10) == byteString2.getByte(i10)) {
            int i20 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            for (int i21 = i10; i21 < min && byteString.getByte(i21) == byteString2.getByte(i21); i21++) {
                i20++;
            }
            long intCount = 1 + j10 + intCount(buffer) + 2 + i20;
            buffer.writeInt(-i20);
            buffer.writeInt(i18);
            int i22 = i10;
            while (true) {
                i13 = i10 + i20;
                if (i22 >= i13) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i22) & 255);
                i22++;
            }
            if (i19 + 1 == i12) {
                if (i13 != list.get(i19).size()) {
                    throw new AssertionError();
                }
                buffer.writeInt(list2.get(i19).intValue());
                return;
            } else {
                Buffer buffer3 = new Buffer();
                buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                buildTrieRecursive(intCount, buffer3, i13, list, i19, i12, list2);
                buffer.write(buffer3, buffer3.size());
                return;
            }
        }
        int i23 = 1;
        for (int i24 = i19 + 1; i24 < i12; i24++) {
            if (list.get(i24 - 1).getByte(i10) != list.get(i24).getByte(i10)) {
                i23++;
            }
        }
        long intCount2 = j10 + intCount(buffer) + 2 + (i23 * 2);
        buffer.writeInt(i23);
        buffer.writeInt(i18);
        for (int i25 = i19; i25 < i12; i25++) {
            byte b4 = list.get(i25).getByte(i10);
            if (i25 == i19 || b4 != list.get(i25 - 1).getByte(i10)) {
                buffer.writeInt(b4 & 255);
            }
        }
        Buffer buffer4 = new Buffer();
        int i26 = i19;
        while (i26 < i12) {
            byte b10 = list.get(i26).getByte(i10);
            int i27 = i26 + 1;
            int i28 = i27;
            while (true) {
                if (i28 >= i12) {
                    i14 = i12;
                    break;
                } else {
                    if (b10 != list.get(i28).getByte(i10)) {
                        i14 = i28;
                        break;
                    }
                    i28++;
                }
            }
            if (i27 == i14 && i10 + 1 == list.get(i26).size()) {
                buffer.writeInt(list2.get(i26).intValue());
                i15 = i14;
                buffer2 = buffer4;
            } else {
                buffer.writeInt((int) ((intCount(buffer4) + intCount2) * (-1)));
                i15 = i14;
                buffer2 = buffer4;
                buildTrieRecursive(intCount2, buffer4, i10 + 1, list, i26, i14, list2);
            }
            buffer4 = buffer2;
            i26 = i15;
        }
        Buffer buffer5 = buffer4;
        buffer.write(buffer5, buffer5.size());
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bc, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.cloud.huiyansdkface.okio.Options of(com.tencent.cloud.huiyansdkface.okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Options.of(com.tencent.cloud.huiyansdkface.okio.ByteString[]):com.tencent.cloud.huiyansdkface.okio.Options");
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i10) {
        return this.byteStrings[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.byteStrings.length;
    }
}
