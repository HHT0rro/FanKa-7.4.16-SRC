package okio.internal;

import com.android.internal.midi.MidiConstants;
import java.io.EOFException;
import kotlin.collections.l;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Buffer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BufferKt {

    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@NotNull Buffer commonClear) {
        s.i(commonClear, "$this$commonClear");
        commonClear.skip(commonClear.size());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer commonCompleteSegmentByteCount) {
        s.i(commonCompleteSegmentByteCount, "$this$commonCompleteSegmentByteCount");
        long size = commonCompleteSegmentByteCount.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = commonCompleteSegmentByteCount.head;
        s.f(segment);
        Segment segment2 = segment.prev;
        s.f(segment2);
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (r2 - segment2.pos);
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer commonCopy) {
        s.i(commonCopy, "$this$commonCopy");
        Buffer buffer = new Buffer();
        if (commonCopy.size() == 0) {
            return buffer;
        }
        Segment segment = commonCopy.head;
        s.f(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            s.f(segment3);
            s.f(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(commonCopy.size());
        return buffer;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer commonCopyTo, @NotNull Buffer out, long j10, long j11) {
        s.i(commonCopyTo, "$this$commonCopyTo");
        s.i(out, "out");
        Util.checkOffsetAndCount(commonCopyTo.size(), j10, j11);
        if (j11 == 0) {
            return commonCopyTo;
        }
        out.setSize$okio(out.size() + j11);
        Segment segment = commonCopyTo.head;
        while (true) {
            s.f(segment);
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            segment = segment.next;
        }
        while (j11 > 0) {
            s.f(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i12 = sharedCopy.pos + ((int) j10);
            sharedCopy.pos = i12;
            sharedCopy.limit = Math.min(i12 + ((int) j11), sharedCopy.limit);
            Segment segment2 = out.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                out.head = sharedCopy;
            } else {
                s.f(segment2);
                Segment segment3 = segment2.prev;
                s.f(segment3);
                segment3.push(sharedCopy);
            }
            j11 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j10 = 0;
        }
        return commonCopyTo;
    }

    public static final boolean commonEquals(@NotNull Buffer commonEquals, @Nullable Object obj) {
        s.i(commonEquals, "$this$commonEquals");
        if (commonEquals == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (commonEquals.size() != buffer.size()) {
            return false;
        }
        if (commonEquals.size() == 0) {
            return true;
        }
        Segment segment = commonEquals.head;
        s.f(segment);
        Segment segment2 = buffer.head;
        s.f(segment2);
        int i10 = segment.pos;
        int i11 = segment2.pos;
        long j10 = 0;
        while (j10 < commonEquals.size()) {
            long min = Math.min(segment.limit - i10, segment2.limit - i11);
            long j11 = 0;
            while (j11 < min) {
                int i12 = i10 + 1;
                int i13 = i11 + 1;
                if (segment.data[i10] != segment2.data[i11]) {
                    return false;
                }
                j11++;
                i10 = i12;
                i11 = i13;
            }
            if (i10 == segment.limit) {
                segment = segment.next;
                s.f(segment);
                i10 = segment.pos;
            }
            if (i11 == segment2.limit) {
                segment2 = segment2.next;
                s.f(segment2);
                i11 = segment2.pos;
            }
            j10 += min;
        }
        return true;
    }

    public static final byte commonGet(@NotNull Buffer commonGet, long j10) {
        s.i(commonGet, "$this$commonGet");
        Util.checkOffsetAndCount(commonGet.size(), j10, 1L);
        Segment segment = commonGet.head;
        if (segment == null) {
            s.f(null);
            throw null;
        }
        if (commonGet.size() - j10 < j10) {
            long size = commonGet.size();
            while (size > j10) {
                segment = segment.prev;
                s.f(segment);
                size -= segment.limit - segment.pos;
            }
            s.f(segment);
            return segment.data[(int) ((segment.pos + j10) - size)];
        }
        long j11 = 0;
        while (true) {
            long j12 = (segment.limit - segment.pos) + j11;
            if (j12 > j10) {
                s.f(segment);
                return segment.data[(int) ((segment.pos + j10) - j11)];
            }
            segment = segment.next;
            s.f(segment);
            j11 = j12;
        }
    }

    public static final int commonHashCode(@NotNull Buffer commonHashCode) {
        s.i(commonHashCode, "$this$commonHashCode");
        Segment segment = commonHashCode.head;
        if (segment == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = segment.limit;
            for (int i12 = segment.pos; i12 < i11; i12++) {
                i10 = (i10 * 31) + segment.data[i12];
            }
            segment = segment.next;
            s.f(segment);
        } while (segment != commonHashCode.head);
        return i10;
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, byte b4, long j10, long j11) {
        Segment segment;
        int i10;
        s.i(commonIndexOf, "$this$commonIndexOf");
        long j12 = 0;
        if (!(0 <= j10 && j11 >= j10)) {
            throw new IllegalArgumentException(("size=" + commonIndexOf.size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        if (j11 > commonIndexOf.size()) {
            j11 = commonIndexOf.size();
        }
        if (j10 == j11 || (segment = commonIndexOf.head) == null) {
            return -1L;
        }
        if (commonIndexOf.size() - j10 < j10) {
            j12 = commonIndexOf.size();
            while (j12 > j10) {
                segment = segment.prev;
                s.f(segment);
                j12 -= segment.limit - segment.pos;
            }
            while (j12 < j11) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j11) - j12);
                i10 = (int) ((segment.pos + j10) - j12);
                while (i10 < min) {
                    if (bArr[i10] != b4) {
                        i10++;
                    }
                }
                j12 += segment.limit - segment.pos;
                segment = segment.next;
                s.f(segment);
                j10 = j12;
            }
            return -1L;
        }
        while (true) {
            long j13 = (segment.limit - segment.pos) + j12;
            if (j13 > j10) {
                break;
            }
            segment = segment.next;
            s.f(segment);
            j12 = j13;
        }
        while (j12 < j11) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j11) - j12);
            i10 = (int) ((segment.pos + j10) - j12);
            while (i10 < min2) {
                if (bArr2[i10] != b4) {
                    i10++;
                }
            }
            j12 += segment.limit - segment.pos;
            segment = segment.next;
            s.f(segment);
            j10 = j12;
        }
        return -1L;
        return (i10 - segment.pos) + j12;
    }

    public static final long commonIndexOfElement(@NotNull Buffer commonIndexOfElement, @NotNull ByteString targetBytes, long j10) {
        int i10;
        int i11;
        s.i(commonIndexOfElement, "$this$commonIndexOfElement");
        s.i(targetBytes, "targetBytes");
        long j11 = 0;
        if (j10 >= 0) {
            Segment segment = commonIndexOfElement.head;
            if (segment == null) {
                return -1L;
            }
            if (commonIndexOfElement.size() - j10 < j10) {
                j11 = commonIndexOfElement.size();
                while (j11 > j10) {
                    segment = segment.prev;
                    s.f(segment);
                    j11 -= segment.limit - segment.pos;
                }
                if (targetBytes.size() == 2) {
                    byte b4 = targetBytes.getByte(0);
                    byte b10 = targetBytes.getByte(1);
                    while (j11 < commonIndexOfElement.size()) {
                        byte[] bArr = segment.data;
                        i10 = (int) ((segment.pos + j10) - j11);
                        int i12 = segment.limit;
                        while (i10 < i12) {
                            byte b11 = bArr[i10];
                            if (b11 != b4 && b11 != b10) {
                                i10++;
                            }
                            i11 = segment.pos;
                        }
                        j11 += segment.limit - segment.pos;
                        segment = segment.next;
                        s.f(segment);
                        j10 = j11;
                    }
                } else {
                    byte[] internalArray$okio = targetBytes.internalArray$okio();
                    while (j11 < commonIndexOfElement.size()) {
                        byte[] bArr2 = segment.data;
                        i10 = (int) ((segment.pos + j10) - j11);
                        int i13 = segment.limit;
                        while (i10 < i13) {
                            byte b12 = bArr2[i10];
                            for (byte b13 : internalArray$okio) {
                                if (b12 == b13) {
                                    i11 = segment.pos;
                                }
                            }
                            i10++;
                        }
                        j11 += segment.limit - segment.pos;
                        segment = segment.next;
                        s.f(segment);
                        j10 = j11;
                    }
                }
                return -1L;
            }
            while (true) {
                long j12 = (segment.limit - segment.pos) + j11;
                if (j12 > j10) {
                    break;
                }
                segment = segment.next;
                s.f(segment);
                j11 = j12;
            }
            if (targetBytes.size() == 2) {
                byte b14 = targetBytes.getByte(0);
                byte b15 = targetBytes.getByte(1);
                while (j11 < commonIndexOfElement.size()) {
                    byte[] bArr3 = segment.data;
                    i10 = (int) ((segment.pos + j10) - j11);
                    int i14 = segment.limit;
                    while (i10 < i14) {
                        byte b16 = bArr3[i10];
                        if (b16 != b14 && b16 != b15) {
                            i10++;
                        }
                        i11 = segment.pos;
                    }
                    j11 += segment.limit - segment.pos;
                    segment = segment.next;
                    s.f(segment);
                    j10 = j11;
                }
            } else {
                byte[] internalArray$okio2 = targetBytes.internalArray$okio();
                while (j11 < commonIndexOfElement.size()) {
                    byte[] bArr4 = segment.data;
                    i10 = (int) ((segment.pos + j10) - j11);
                    int i15 = segment.limit;
                    while (i10 < i15) {
                        byte b17 = bArr4[i10];
                        for (byte b18 : internalArray$okio2) {
                            if (b17 == b18) {
                                i11 = segment.pos;
                            }
                        }
                        i10++;
                    }
                    j11 += segment.limit - segment.pos;
                    segment = segment.next;
                    s.f(segment);
                    j10 = j11;
                }
            }
            return -1L;
            return (i10 - i11) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
    }

    public static final boolean commonRangeEquals(@NotNull Buffer commonRangeEquals, long j10, @NotNull ByteString bytes, int i10, int i11) {
        s.i(commonRangeEquals, "$this$commonRangeEquals");
        s.i(bytes, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || commonRangeEquals.size() - j10 < i11 || bytes.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (commonRangeEquals.getByte(i12 + j10) != bytes.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink) {
        s.i(commonRead, "$this$commonRead");
        s.i(sink, "sink");
        return commonRead.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(@NotNull Buffer commonReadAll, @NotNull Sink sink) {
        s.i(commonReadAll, "$this$commonReadAll");
        s.i(sink, "sink");
        long size = commonReadAll.size();
        if (size > 0) {
            sink.write(commonReadAll, size);
        }
        return size;
    }

    public static final byte commonReadByte(@NotNull Buffer commonReadByte) {
        s.i(commonReadByte, "$this$commonReadByte");
        if (commonReadByte.size() != 0) {
            Segment segment = commonReadByte.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            int i12 = i10 + 1;
            byte b4 = segment.data[i10];
            commonReadByte.setSize$okio(commonReadByte.size() - 1);
            if (i12 == i11) {
                commonReadByte.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i12;
            }
            return b4;
        }
        throw new EOFException();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray) {
        s.i(commonReadByteArray, "$this$commonReadByteArray");
        return commonReadByteArray.readByteArray(commonReadByteArray.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString) {
        s.i(commonReadByteString, "$this$commonReadByteString");
        return commonReadByteString.readByteString(commonReadByteString.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c7 A[EDGE_INSN: B:48:0x00c7->B:42:0x00c7 BREAK  A[LOOP:0: B:4:0x0016->B:47:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.Buffer r17) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull byte[] sink) {
        s.i(commonReadFully, "$this$commonReadFully");
        s.i(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int read = commonReadFully.read(sink, i10, sink.length - i10);
            if (read == -1) {
                throw new EOFException();
            }
            i10 += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3 A[EDGE_INSN: B:39:0x00b3->B:36:0x00b3 BREAK  A[LOOP:0: B:4:0x0012->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r15) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.s.i(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lbd
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.s.f(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1d:
            if (r8 >= r9) goto L9f
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L2e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L2e
            int r11 = r10 - r11
            goto L48
        L2e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3d
        L38:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L48
        L3d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L80
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L80
            goto L38
        L48:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L58
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1d
        L58:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L80:
            if (r0 == 0) goto L84
            r1 = 1
            goto L9f
        L84:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L9f:
            if (r8 != r9) goto Lab
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto Lad
        Lab:
            r6.pos = r8
        Lad:
            if (r1 != 0) goto Lb3
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Lb3:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lbd:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@NotNull Buffer commonReadInt) {
        s.i(commonReadInt, "$this$commonReadInt");
        if (commonReadInt.size() >= 4) {
            Segment segment = commonReadInt.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 4) {
                return (commonReadInt.readByte() & 255) | ((commonReadInt.readByte() & 255) << 24) | ((commonReadInt.readByte() & 255) << 16) | ((commonReadInt.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
            int i15 = i13 + 1;
            int i16 = i14 | ((bArr[i13] & 255) << 8);
            int i17 = i15 + 1;
            int i18 = i16 | (bArr[i15] & 255);
            commonReadInt.setSize$okio(commonReadInt.size() - 4);
            if (i17 == i11) {
                commonReadInt.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i17;
            }
            return i18;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(@NotNull Buffer commonReadLong) {
        s.i(commonReadLong, "$this$commonReadLong");
        if (commonReadLong.size() >= 8) {
            Segment segment = commonReadLong.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 8) {
                return ((commonReadLong.readInt() & 4294967295L) << 32) | (4294967295L & commonReadLong.readInt());
            }
            byte[] bArr = segment.data;
            long j10 = (bArr[i10] & 255) << 56;
            long j11 = j10 | ((bArr[r6] & 255) << 48);
            long j12 = j11 | ((bArr[r1] & 255) << 40);
            int i12 = i10 + 1 + 1 + 1 + 1;
            long j13 = ((bArr[r6] & 255) << 32) | j12;
            long j14 = j13 | ((bArr[i12] & 255) << 24);
            long j15 = j14 | ((bArr[r8] & 255) << 16);
            long j16 = j15 | ((bArr[r1] & 255) << 8);
            int i13 = i12 + 1 + 1 + 1 + 1;
            long j17 = j16 | (bArr[r8] & 255);
            commonReadLong.setSize$okio(commonReadLong.size() - 8);
            if (i13 == i11) {
                commonReadLong.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return j17;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(@NotNull Buffer commonReadShort) {
        s.i(commonReadShort, "$this$commonReadShort");
        if (commonReadShort.size() >= 2) {
            Segment segment = commonReadShort.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 2) {
                return (short) ((commonReadShort.readByte() & 255) | ((commonReadShort.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
            commonReadShort.setSize$okio(commonReadShort.size() - 2);
            if (i13 == i11) {
                commonReadShort.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return (short) i14;
        }
        throw new EOFException();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer commonReadUtf8, long j10) {
        s.i(commonReadUtf8, "$this$commonReadUtf8");
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (commonReadUtf8.size() < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        Segment segment = commonReadUtf8.head;
        s.f(segment);
        int i10 = segment.pos;
        if (i10 + j10 > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(commonReadUtf8.readByteArray(j10), 0, 0, 3, null);
        }
        int i11 = (int) j10;
        String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i10, i10 + i11);
        segment.pos += i11;
        commonReadUtf8.setSize$okio(commonReadUtf8.size() - j10);
        if (segment.pos == segment.limit) {
            commonReadUtf8.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return commonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer commonReadUtf8CodePoint) {
        int i10;
        int i11;
        int i12;
        s.i(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        if (commonReadUtf8CodePoint.size() != 0) {
            byte b4 = commonReadUtf8CodePoint.getByte(0L);
            if ((b4 & 128) == 0) {
                i10 = b4 & Byte.MAX_VALUE;
                i11 = 1;
                i12 = 0;
            } else if ((b4 & MidiConstants.STATUS_PITCH_BEND) == 192) {
                i10 = b4 & 31;
                i11 = 2;
                i12 = 128;
            } else if ((b4 & 240) == 224) {
                i10 = b4 & 15;
                i11 = 3;
                i12 = 2048;
            } else {
                if ((b4 & 248) != 240) {
                    commonReadUtf8CodePoint.skip(1L);
                    return 65533;
                }
                i10 = b4 & 7;
                i11 = 4;
                i12 = 65536;
            }
            long j10 = i11;
            if (commonReadUtf8CodePoint.size() >= j10) {
                for (int i13 = 1; i13 < i11; i13++) {
                    long j11 = i13;
                    byte b10 = commonReadUtf8CodePoint.getByte(j11);
                    if ((b10 & 192) != 128) {
                        commonReadUtf8CodePoint.skip(j11);
                        return 65533;
                    }
                    i10 = (i10 << 6) | (b10 & Utf8.REPLACEMENT_BYTE);
                }
                commonReadUtf8CodePoint.skip(j10);
                if (i10 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i10 && 57343 >= i10) || i10 < i12) {
                    return 65533;
                }
                return i10;
            }
            throw new EOFException("size < " + i11 + ": " + commonReadUtf8CodePoint.size() + " (to read code point prefixed 0x" + Util.toHexString(b4) + ')');
        }
        throw new EOFException();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer commonReadUtf8Line) {
        s.i(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long indexOf = commonReadUtf8Line.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(commonReadUtf8Line, indexOf);
        }
        if (commonReadUtf8Line.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer commonReadUtf8LineStrict, long j10) {
        s.i(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (j10 >= 0) {
            long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
            byte b4 = (byte) 10;
            long indexOf = commonReadUtf8LineStrict.indexOf(b4, 0L, j11);
            if (indexOf != -1) {
                return readUtf8Line(commonReadUtf8LineStrict, indexOf);
            }
            if (j11 < commonReadUtf8LineStrict.size() && commonReadUtf8LineStrict.getByte(j11 - 1) == ((byte) 13) && commonReadUtf8LineStrict.getByte(j11) == b4) {
                return readUtf8Line(commonReadUtf8LineStrict, j11);
            }
            Buffer buffer = new Buffer();
            commonReadUtf8LineStrict.copyTo(buffer, 0L, Math.min(32, commonReadUtf8LineStrict.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.size(), j10) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    public static final int commonSelect(@NotNull Buffer commonSelect, @NotNull Options options) {
        s.i(commonSelect, "$this$commonSelect");
        s.i(options, "options");
        int selectPrefix$default = selectPrefix$default(commonSelect, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        commonSelect.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer commonSkip, long j10) {
        s.i(commonSkip, "$this$commonSkip");
        while (j10 > 0) {
            Segment segment = commonSkip.head;
            if (segment != null) {
                int min = (int) Math.min(j10, segment.limit - segment.pos);
                long j11 = min;
                commonSkip.setSize$okio(commonSkip.size() - j11);
                j10 -= j11;
                int i10 = segment.pos + min;
                segment.pos = i10;
                if (i10 == segment.limit) {
                    commonSkip.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot) {
        s.i(commonSnapshot, "$this$commonSnapshot");
        if (commonSnapshot.size() <= ((long) Integer.MAX_VALUE)) {
            return commonSnapshot.snapshot((int) commonSnapshot.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + commonSnapshot.size()).toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer commonWritableSegment, int i10) {
        s.i(commonWritableSegment, "$this$commonWritableSegment");
        if (i10 >= 1 && i10 <= 8192) {
            Segment segment = commonWritableSegment.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                commonWritableSegment.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            s.f(segment);
            Segment segment2 = segment.prev;
            s.f(segment2);
            return (segment2.limit + i10 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull ByteString byteString, int i10, int i11) {
        s.i(commonWrite, "$this$commonWrite");
        s.i(byteString, "byteString");
        byteString.write$okio(commonWrite, i10, i11);
        return commonWrite;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer commonWrite, ByteString byteString, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = byteString.size();
        }
        s.i(commonWrite, "$this$commonWrite");
        s.i(byteString, "byteString");
        byteString.write$okio(commonWrite, i10, i11);
        return commonWrite;
    }

    public static final long commonWriteAll(@NotNull Buffer commonWriteAll, @NotNull Source source) {
        s.i(commonWriteAll, "$this$commonWriteAll");
        s.i(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(commonWriteAll, 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer commonWriteByte, int i10) {
        s.i(commonWriteByte, "$this$commonWriteByte");
        Segment writableSegment$okio = commonWriteByte.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        writableSegment$okio.limit = i11 + 1;
        bArr[i11] = (byte) i10;
        commonWriteByte.setSize$okio(commonWriteByte.size() + 1);
        return commonWriteByte;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer commonWriteDecimalLong, long j10) {
        s.i(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (j10 == 0) {
            return commonWriteDecimalLong.writeByte(48);
        }
        boolean z10 = false;
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return commonWriteDecimalLong.writeUtf8("-9223372036854775808");
            }
            z10 = true;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        Segment writableSegment$okio = commonWriteDecimalLong.writableSegment$okio(i10);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = getHEX_DIGIT_BYTES()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i11 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i10;
        commonWriteDecimalLong.setSize$okio(commonWriteDecimalLong.size() + i10);
        return commonWriteDecimalLong;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer commonWriteHexadecimalUnsignedLong, long j10) {
        s.i(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (j10 == 0) {
            return commonWriteHexadecimalUnsignedLong.writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = commonWriteHexadecimalUnsignedLong.writableSegment$okio(i10);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = getHEX_DIGIT_BYTES()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        writableSegment$okio.limit += i10;
        commonWriteHexadecimalUnsignedLong.setSize$okio(commonWriteHexadecimalUnsignedLong.size() + i10);
        return commonWriteHexadecimalUnsignedLong;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer commonWriteInt, int i10) {
        s.i(commonWriteInt, "$this$commonWriteInt");
        Segment writableSegment$okio = commonWriteInt.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        writableSegment$okio.limit = i14 + 1;
        commonWriteInt.setSize$okio(commonWriteInt.size() + 4);
        return commonWriteInt;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer commonWriteLong, long j10) {
        s.i(commonWriteLong, "$this$commonWriteLong");
        Segment writableSegment$okio = commonWriteLong.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i10 = writableSegment$okio.limit;
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j10 >>> 48) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j10 >>> 40) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((j10 >>> 32) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((j10 >>> 24) & 255);
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((j10 >>> 16) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j10 >>> 8) & 255);
        bArr[i17] = (byte) (j10 & 255);
        writableSegment$okio.limit = i17 + 1;
        commonWriteLong.setSize$okio(commonWriteLong.size() + 8);
        return commonWriteLong;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer commonWriteShort, int i10) {
        s.i(commonWriteShort, "$this$commonWriteShort");
        Segment writableSegment$okio = commonWriteShort.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        writableSegment$okio.limit = i12 + 1;
        commonWriteShort.setSize$okio(commonWriteShort.size() + 2);
        return commonWriteShort;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer commonWriteUtf8, @NotNull String string, int i10, int i11) {
        s.i(commonWriteUtf8, "$this$commonWriteUtf8");
        s.i(string, "string");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 >= i10) {
            if (!(i11 <= string.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
            }
            while (i10 < i11) {
                char charAt = string.charAt(i10);
                if (charAt < 128) {
                    Segment writableSegment$okio = commonWriteUtf8.writableSegment$okio(1);
                    byte[] bArr = writableSegment$okio.data;
                    int i12 = writableSegment$okio.limit - i10;
                    int min = Math.min(i11, 8192 - i12);
                    int i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) charAt;
                    while (i13 < min) {
                        char charAt2 = string.charAt(i13);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i13 + i12] = (byte) charAt2;
                        i13++;
                    }
                    int i14 = writableSegment$okio.limit;
                    int i15 = (i12 + i13) - i14;
                    writableSegment$okio.limit = i14 + i15;
                    commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + i15);
                    i10 = i13;
                } else {
                    if (charAt < 2048) {
                        Segment writableSegment$okio2 = commonWriteUtf8.writableSegment$okio(2);
                        byte[] bArr2 = writableSegment$okio2.data;
                        int i16 = writableSegment$okio2.limit;
                        bArr2[i16] = (byte) ((charAt >> 6) | 192);
                        bArr2[i16 + 1] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio2.limit = i16 + 2;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 2);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i17 = i10 + 1;
                        char charAt3 = i17 < i11 ? string.charAt(i17) : (char) 0;
                        if (charAt <= 56319 && 56320 <= charAt3 && 57343 >= charAt3) {
                            int i18 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            Segment writableSegment$okio3 = commonWriteUtf8.writableSegment$okio(4);
                            byte[] bArr3 = writableSegment$okio3.data;
                            int i19 = writableSegment$okio3.limit;
                            bArr3[i19] = (byte) ((i18 >> 18) | 240);
                            bArr3[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                            bArr3[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                            bArr3[i19 + 3] = (byte) ((i18 & 63) | 128);
                            writableSegment$okio3.limit = i19 + 4;
                            commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 4);
                            i10 += 2;
                        } else {
                            commonWriteUtf8.writeByte(63);
                            i10 = i17;
                        }
                    } else {
                        Segment writableSegment$okio4 = commonWriteUtf8.writableSegment$okio(3);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i20 = writableSegment$okio4.limit;
                        bArr4[i20] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i20 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i20 + 2] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio4.limit = i20 + 3;
                        commonWriteUtf8.setSize$okio(commonWriteUtf8.size() + 3);
                    }
                    i10++;
                }
            }
            return commonWriteUtf8;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer commonWriteUtf8CodePoint, int i10) {
        s.i(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (i10 < 128) {
            commonWriteUtf8CodePoint.writeByte(i10);
        } else if (i10 < 2048) {
            Segment writableSegment$okio = commonWriteUtf8CodePoint.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i11 = writableSegment$okio.limit;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            writableSegment$okio.limit = i11 + 2;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 2);
        } else if (55296 <= i10 && 57343 >= i10) {
            commonWriteUtf8CodePoint.writeByte(63);
        } else if (i10 < 65536) {
            Segment writableSegment$okio2 = commonWriteUtf8CodePoint.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i12 = writableSegment$okio2.limit;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            writableSegment$okio2.limit = i12 + 3;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 3);
        } else if (i10 <= 1114111) {
            Segment writableSegment$okio3 = commonWriteUtf8CodePoint.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i13 = writableSegment$okio3.limit;
            bArr3[i13] = (byte) ((i10 >> 18) | 240);
            bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
            writableSegment$okio3.limit = i13 + 4;
            commonWriteUtf8CodePoint.setSize$okio(commonWriteUtf8CodePoint.size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i10));
        }
        return commonWriteUtf8CodePoint;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i10, @NotNull byte[] bytes, int i11, int i12) {
        s.i(segment, "segment");
        s.i(bytes, "bytes");
        int i13 = segment.limit;
        byte[] bArr = segment.data;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.next;
                s.f(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i10 = segment.pos;
                i13 = segment.limit;
            }
            if (bArr[i10] != bytes[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer readUtf8Line, long j10) {
        s.i(readUtf8Line, "$this$readUtf8Line");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (readUtf8Line.getByte(j11) == ((byte) 13)) {
                String readUtf8 = readUtf8Line.readUtf8(j11);
                readUtf8Line.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8Line.readUtf8(j10);
        readUtf8Line.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(@NotNull Buffer seek, long j10, @NotNull Function2<? super Segment, ? super Long, ? extends T> lambda) {
        s.i(seek, "$this$seek");
        s.i(lambda, "lambda");
        Segment segment = seek.head;
        if (segment == null) {
            return lambda.mo1743invoke(null, -1L);
        }
        if (seek.size() - j10 < j10) {
            long size = seek.size();
            while (size > j10) {
                segment = segment.prev;
                s.f(segment);
                size -= segment.limit - segment.pos;
            }
            return lambda.mo1743invoke(segment, Long.valueOf(size));
        }
        long j11 = 0;
        while (true) {
            long j12 = (segment.limit - segment.pos) + j11;
            if (j12 > j10) {
                return lambda.mo1743invoke(segment, Long.valueOf(j11));
            }
            segment = segment.next;
            s.f(segment);
            j11 = j12;
        }
    }

    public static final int selectPrefix(@NotNull Buffer selectPrefix, @NotNull Options options, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        Segment segment;
        s.i(selectPrefix, "$this$selectPrefix");
        s.i(options, "options");
        Segment segment2 = selectPrefix.head;
        if (segment2 == null) {
            return z10 ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i14 = segment2.pos;
        int i15 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i16 = 0;
        int i17 = -1;
        loop0: while (true) {
            int i18 = i16 + 1;
            int i19 = trie$okio[i16];
            int i20 = i18 + 1;
            int i21 = trie$okio[i18];
            if (i21 != -1) {
                i17 = i21;
            }
            if (segment3 == null) {
                break;
            }
            if (i19 >= 0) {
                i10 = i14 + 1;
                int i22 = bArr[i14] & 255;
                int i23 = i20 + i19;
                while (i20 != i23) {
                    if (i22 == trie$okio[i20]) {
                        i11 = trie$okio[i20 + i19];
                        if (i10 == i15) {
                            segment3 = segment3.next;
                            s.f(segment3);
                            i10 = segment3.pos;
                            bArr = segment3.data;
                            i15 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i20++;
                    }
                }
                return i17;
            }
            int i24 = i20 + (i19 * (-1));
            while (true) {
                int i25 = i14 + 1;
                int i26 = i20 + 1;
                if ((bArr[i14] & 255) != trie$okio[i20]) {
                    return i17;
                }
                boolean z11 = i26 == i24;
                if (i25 == i15) {
                    s.f(segment3);
                    Segment segment4 = segment3.next;
                    s.f(segment4);
                    i13 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i12 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z11) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    Segment segment5 = segment3;
                    i12 = i15;
                    i13 = i25;
                    segment = segment5;
                }
                if (z11) {
                    i11 = trie$okio[i26];
                    i10 = i13;
                    i15 = i12;
                    segment3 = segment;
                    break;
                }
                i14 = i13;
                i15 = i12;
                i20 = i26;
                segment3 = segment;
            }
            if (i11 >= 0) {
                return i11;
            }
            i16 = -i11;
            i14 = i10;
        }
        if (z10) {
            return -2;
        }
        return i17;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return selectPrefix(buffer, options, z10);
    }

    public static final int commonRead(@NotNull Buffer commonRead, @NotNull byte[] sink, int i10, int i11) {
        s.i(commonRead, "$this$commonRead");
        s.i(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i10, i11);
        Segment segment = commonRead.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i12 = segment.pos;
        l.e(bArr, sink, i10, i12, i12 + min);
        segment.pos += min;
        commonRead.setSize$okio(commonRead.size() - min);
        if (segment.pos == segment.limit) {
            commonRead.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer commonReadByteArray, long j10) {
        s.i(commonReadByteArray, "$this$commonReadByteArray");
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (commonReadByteArray.size() >= j10) {
            byte[] bArr = new byte[(int) j10];
            commonReadByteArray.readFully(bArr);
            return bArr;
        }
        throw new EOFException();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer commonReadByteString, long j10) {
        s.i(commonReadByteString, "$this$commonReadByteString");
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (commonReadByteString.size() < j10) {
            throw new EOFException();
        }
        if (j10 >= 4096) {
            ByteString snapshot = commonReadByteString.snapshot((int) j10);
            commonReadByteString.skip(j10);
            return snapshot;
        }
        return new ByteString(commonReadByteString.readByteArray(j10));
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source) {
        s.i(commonWrite, "$this$commonWrite");
        s.i(source, "source");
        return commonWrite.write(source, 0, source.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull byte[] source, int i10, int i11) {
        s.i(commonWrite, "$this$commonWrite");
        s.i(source, "source");
        long j10 = i11;
        Util.checkOffsetAndCount(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            Segment writableSegment$okio = commonWrite.writableSegment$okio(1);
            int min = Math.min(i12 - i10, 8192 - writableSegment$okio.limit);
            int i13 = i10 + min;
            l.e(source, writableSegment$okio.data, writableSegment$okio.limit, i10, i13);
            writableSegment$okio.limit += min;
            i10 = i13;
        }
        commonWrite.setSize$okio(commonWrite.size() + j10);
        return commonWrite;
    }

    public static final void commonReadFully(@NotNull Buffer commonReadFully, @NotNull Buffer sink, long j10) {
        s.i(commonReadFully, "$this$commonReadFully");
        s.i(sink, "sink");
        if (commonReadFully.size() >= j10) {
            sink.write(commonReadFully, j10);
        } else {
            sink.write(commonReadFully, commonReadFully.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer commonSnapshot, int i10) {
        s.i(commonSnapshot, "$this$commonSnapshot");
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(commonSnapshot.size(), 0L, i10);
        Segment segment = commonSnapshot.head;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            s.f(segment);
            int i14 = segment.limit;
            int i15 = segment.pos;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                segment = segment.next;
            } else {
                throw new AssertionError((Object) "s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13];
        int[] iArr = new int[i13 * 2];
        Segment segment2 = commonSnapshot.head;
        int i16 = 0;
        while (i11 < i10) {
            s.f(segment2);
            bArr[i16] = segment2.data;
            i11 += segment2.limit - segment2.pos;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = segment2.pos;
            segment2.shared = true;
            i16++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer commonWrite, @NotNull Source source, long j10) {
        s.i(commonWrite, "$this$commonWrite");
        s.i(source, "source");
        while (j10 > 0) {
            long read = source.read(commonWrite, j10);
            if (read == -1) {
                throw new EOFException();
            }
            j10 -= read;
        }
        return commonWrite;
    }

    public static final long commonRead(@NotNull Buffer commonRead, @NotNull Buffer sink, long j10) {
        s.i(commonRead, "$this$commonRead");
        s.i(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (commonRead.size() == 0) {
            return -1L;
        }
        if (j10 > commonRead.size()) {
            j10 = commonRead.size();
        }
        sink.write(commonRead, j10);
        return j10;
    }

    public static final void commonWrite(@NotNull Buffer commonWrite, @NotNull Buffer source, long j10) {
        Segment segment;
        s.i(commonWrite, "$this$commonWrite");
        s.i(source, "source");
        if (source != commonWrite) {
            Util.checkOffsetAndCount(source.size(), 0L, j10);
            while (j10 > 0) {
                Segment segment2 = source.head;
                s.f(segment2);
                int i10 = segment2.limit;
                s.f(source.head);
                if (j10 < i10 - r2.pos) {
                    Segment segment3 = commonWrite.head;
                    if (segment3 != null) {
                        s.f(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j10) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = source.head;
                            s.f(segment4);
                            segment4.writeTo(segment, (int) j10);
                            source.setSize$okio(source.size() - j10);
                            commonWrite.setSize$okio(commonWrite.size() + j10);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    s.f(segment5);
                    source.head = segment5.split((int) j10);
                }
                Segment segment6 = source.head;
                s.f(segment6);
                long j11 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = commonWrite.head;
                if (segment7 == null) {
                    commonWrite.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    s.f(segment7);
                    Segment segment8 = segment7.prev;
                    s.f(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j11);
                commonWrite.setSize$okio(commonWrite.size() + j11);
                j10 -= j11;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(@NotNull Buffer commonIndexOf, @NotNull ByteString bytes, long j10) {
        long j11;
        int i10;
        long j12 = j10;
        s.i(commonIndexOf, "$this$commonIndexOf");
        s.i(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j13 = 0;
        if (j12 >= 0) {
            Segment segment = commonIndexOf.head;
            if (segment == null) {
                return -1L;
            }
            if (commonIndexOf.size() - j12 < j12) {
                j11 = commonIndexOf.size();
                while (j11 > j12) {
                    segment = segment.prev;
                    s.f(segment);
                    j11 -= segment.limit - segment.pos;
                }
                byte[] internalArray$okio = bytes.internalArray$okio();
                byte b4 = internalArray$okio[0];
                int size = bytes.size();
                long size2 = (commonIndexOf.size() - size) + 1;
                while (j11 < size2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + size2) - j11);
                    i10 = (int) ((segment.pos + j12) - j11);
                    while (i10 < min) {
                        if (bArr[i10] != b4 || !rangeEquals(segment, i10 + 1, internalArray$okio, 1, size)) {
                            i10++;
                        }
                    }
                    j11 += segment.limit - segment.pos;
                    segment = segment.next;
                    s.f(segment);
                    j12 = j11;
                }
                return -1L;
            }
            while (true) {
                long j14 = (segment.limit - segment.pos) + j13;
                if (j14 > j12) {
                    break;
                }
                segment = segment.next;
                s.f(segment);
                j13 = j14;
            }
            byte[] internalArray$okio2 = bytes.internalArray$okio();
            byte b10 = internalArray$okio2[0];
            int size3 = bytes.size();
            long size4 = (commonIndexOf.size() - size3) + 1;
            j11 = j13;
            while (j11 < size4) {
                byte[] bArr2 = segment.data;
                long j15 = size4;
                int min2 = (int) Math.min(segment.limit, (segment.pos + size4) - j11);
                i10 = (int) ((segment.pos + j12) - j11);
                while (i10 < min2) {
                    if (bArr2[i10] == b10 && rangeEquals(segment, i10 + 1, internalArray$okio2, 1, size3)) {
                    }
                    i10++;
                }
                j11 += segment.limit - segment.pos;
                segment = segment.next;
                s.f(segment);
                size4 = j15;
                j12 = j11;
            }
            return -1L;
            return (i10 - segment.pos) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j12).toString());
    }
}
