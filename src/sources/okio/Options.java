package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.b;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Options.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Options extends b<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final ByteString[] byteStrings;

    @NotNull
    private final int[] trie;

    /* compiled from: Options.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long j10, Buffer buffer, int i10, List<? extends ByteString> list, int i11, int i12, List<Integer> list2) {
            int i13;
            int i14;
            int i15;
            int i16;
            Buffer buffer2;
            int i17 = i10;
            if (i11 < i12) {
                for (int i18 = i11; i18 < i12; i18++) {
                    if (!(list.get(i18).size() >= i17)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = list.get(i11);
                ByteString byteString2 = list.get(i12 - 1);
                if (i17 == byteString.size()) {
                    int intValue = list2.get(i11).intValue();
                    int i19 = i11 + 1;
                    ByteString byteString3 = list.get(i19);
                    i13 = i19;
                    i14 = intValue;
                    byteString = byteString3;
                } else {
                    i13 = i11;
                    i14 = -1;
                }
                if (byteString.getByte(i17) != byteString2.getByte(i17)) {
                    int i20 = 1;
                    for (int i21 = i13 + 1; i21 < i12; i21++) {
                        if (list.get(i21 - 1).getByte(i17) != list.get(i21).getByte(i17)) {
                            i20++;
                        }
                    }
                    long intCount = j10 + getIntCount(buffer) + 2 + (i20 * 2);
                    buffer.writeInt(i20);
                    buffer.writeInt(i14);
                    for (int i22 = i13; i22 < i12; i22++) {
                        byte b4 = list.get(i22).getByte(i17);
                        if (i22 == i13 || b4 != list.get(i22 - 1).getByte(i17)) {
                            buffer.writeInt(b4 & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    while (i13 < i12) {
                        byte b10 = list.get(i13).getByte(i17);
                        int i23 = i13 + 1;
                        int i24 = i23;
                        while (true) {
                            if (i24 >= i12) {
                                i15 = i12;
                                break;
                            } else {
                                if (b10 != list.get(i24).getByte(i17)) {
                                    i15 = i24;
                                    break;
                                }
                                i24++;
                            }
                        }
                        if (i23 == i15 && i17 + 1 == list.get(i13).size()) {
                            buffer.writeInt(list2.get(i13).intValue());
                            i16 = i15;
                            buffer2 = buffer3;
                        } else {
                            buffer.writeInt(((int) (intCount + getIntCount(buffer3))) * (-1));
                            i16 = i15;
                            buffer2 = buffer3;
                            buildTrieRecursive(intCount, buffer3, i17 + 1, list, i13, i15, list2);
                        }
                        buffer3 = buffer2;
                        i13 = i16;
                    }
                    buffer.writeAll(buffer3);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i25 = 0;
                for (int i26 = i17; i26 < min && byteString.getByte(i26) == byteString2.getByte(i26); i26++) {
                    i25++;
                }
                long intCount2 = j10 + getIntCount(buffer) + 2 + i25 + 1;
                buffer.writeInt(-i25);
                buffer.writeInt(i14);
                int i27 = i17 + i25;
                while (i17 < i27) {
                    buffer.writeInt(byteString.getByte(i17) & 255);
                    i17++;
                }
                if (i13 + 1 == i12) {
                    if (i27 == list.get(i13).size()) {
                        buffer.writeInt(list2.get(i13).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer4 = new Buffer();
                buffer.writeInt(((int) (getIntCount(buffer4) + intCount2)) * (-1));
                buildTrieRecursive(intCount2, buffer4, i27, list, i13, i12, list2);
                buffer.writeAll(buffer4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j10, Buffer buffer, int i10, List list, int i11, int i12, List list2, int i13, Object obj) {
            companion.buildTrieRecursive((i13 & 1) != 0 ? 0L : j10, buffer, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00f1, code lost:
        
            continue;
         */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(@org.jetbrains.annotations.NotNull okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 328
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @NotNull
    public static final Options of(@NotNull ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Options) byteString);
    }

    @Override // kotlin.collections.b, java.util.List
    @NotNull
    public ByteString get(int i10) {
        return this.byteStrings[i10];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Options) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Options) byteString);
    }
}
