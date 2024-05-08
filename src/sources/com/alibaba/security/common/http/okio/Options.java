package com.alibaba.security.common.http.okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
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
        if (i16 < i12) {
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
            if (byteString.getByte(i10) != byteString2.getByte(i10)) {
                int i20 = 1;
                for (int i21 = i19 + 1; i21 < i12; i21++) {
                    if (list.get(i21 - 1).getByte(i10) != list.get(i21).getByte(i10)) {
                        i20++;
                    }
                }
                long intCount = j10 + intCount(buffer) + 2 + (i20 * 2);
                buffer.writeInt(i20);
                buffer.writeInt(i18);
                for (int i22 = i19; i22 < i12; i22++) {
                    byte b4 = list.get(i22).getByte(i10);
                    if (i22 == i19 || b4 != list.get(i22 - 1).getByte(i10)) {
                        buffer.writeInt(b4 & 255);
                    }
                }
                Buffer buffer3 = new Buffer();
                int i23 = i19;
                while (i23 < i12) {
                    byte b10 = list.get(i23).getByte(i10);
                    int i24 = i23 + 1;
                    int i25 = i24;
                    while (true) {
                        if (i25 >= i12) {
                            i14 = i12;
                            break;
                        } else {
                            if (b10 != list.get(i25).getByte(i10)) {
                                i14 = i25;
                                break;
                            }
                            i25++;
                        }
                    }
                    if (i24 == i14 && i10 + 1 == list.get(i23).size()) {
                        buffer.writeInt(list2.get(i23).intValue());
                        i15 = i14;
                        buffer2 = buffer3;
                    } else {
                        buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                        i15 = i14;
                        buffer2 = buffer3;
                        buildTrieRecursive(intCount, buffer3, i10 + 1, list, i23, i14, list2);
                    }
                    buffer3 = buffer2;
                    i23 = i15;
                }
                Buffer buffer4 = buffer3;
                buffer.write(buffer4, buffer4.size());
                return;
            }
            int i26 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            for (int i27 = i10; i27 < min && byteString.getByte(i27) == byteString2.getByte(i27); i27++) {
                i26++;
            }
            long intCount2 = 1 + j10 + intCount(buffer) + 2 + i26;
            buffer.writeInt(-i26);
            buffer.writeInt(i18);
            int i28 = i10;
            while (true) {
                i13 = i10 + i26;
                if (i28 >= i13) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i28) & 255);
                i28++;
            }
            if (i19 + 1 == i12) {
                if (i13 == list.get(i19).size()) {
                    buffer.writeInt(list2.get(i19).intValue());
                    return;
                }
                throw new AssertionError();
            }
            Buffer buffer5 = new Buffer();
            buffer.writeInt((int) ((intCount(buffer5) + intCount2) * (-1)));
            buildTrieRecursive(intCount2, buffer5, i13, list, i19, i12, list2);
            buffer.write(buffer5, buffer5.size());
            return;
        }
        throw new AssertionError();
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
    public static com.alibaba.security.common.http.okio.Options of(com.alibaba.security.common.http.okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.http.okio.Options.of(com.alibaba.security.common.http.okio.ByteString[]):com.alibaba.security.common.http.okio.Options");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.byteStrings.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i10) {
        return this.byteStrings[i10];
    }
}
