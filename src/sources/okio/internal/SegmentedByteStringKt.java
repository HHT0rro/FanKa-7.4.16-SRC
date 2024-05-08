package okio.internal;

import kotlin.collections.l;
import kotlin.d;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SegmentedByteString.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] binarySearch, int i10, int i11, int i12) {
        s.i(binarySearch, "$this$binarySearch");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = binarySearch[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString commonEquals, @Nullable Object obj) {
        s.i(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.size() && commonEquals.rangeEquals(0, byteString, 0, commonEquals.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString commonGetSize) {
        s.i(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getDirectory$okio()[commonGetSize.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString commonHashCode) {
        s.i(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = commonHashCode.getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i10 < length) {
            int i13 = commonHashCode.getDirectory$okio()[length + i10];
            int i14 = commonHashCode.getDirectory$okio()[i10];
            byte[] bArr = commonHashCode.getSegments$okio()[i10];
            int i15 = (i14 - i11) + i13;
            while (i13 < i15) {
                i12 = (i12 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i11 = i14;
        }
        commonHashCode.setHashCode$okio(i12);
        return i12;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString commonInternalGet, int i10) {
        s.i(commonInternalGet, "$this$commonInternalGet");
        Util.checkOffsetAndCount(commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length - 1], i10, 1L);
        int segment = segment(commonInternalGet, i10);
        return commonInternalGet.getSegments$okio()[segment][(i10 - (segment == 0 ? 0 : commonInternalGet.getDirectory$okio()[segment - 1])) + commonInternalGet.getDirectory$okio()[commonInternalGet.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i10, @NotNull ByteString other, int i11, int i12) {
        s.i(commonRangeEquals, "$this$commonRangeEquals");
        s.i(other, "other");
        if (i10 < 0 || i10 > commonRangeEquals.size() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int segment = segment(commonRangeEquals, i10);
        while (i10 < i13) {
            int i14 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i15 = commonRangeEquals.getDirectory$okio()[segment] - i14;
            int i16 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i13, i15 + i14) - i10;
            if (!other.rangeEquals(i11, commonRangeEquals.getSegments$okio()[segment], i16 + (i10 - i14), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString commonSubstring, int i10, int i11) {
        s.i(commonSubstring, "$this$commonSubstring");
        if (i10 >= 0) {
            if (!(i11 <= commonSubstring.size())) {
                throw new IllegalArgumentException(("endIndex=" + i11 + " > length(" + commonSubstring.size() + ')').toString());
            }
            int i12 = i11 - i10;
            if (i12 >= 0) {
                if (i10 == 0 && i11 == commonSubstring.size()) {
                    return commonSubstring;
                }
                if (i10 == i11) {
                    return ByteString.EMPTY;
                }
                int segment = segment(commonSubstring, i10);
                int segment2 = segment(commonSubstring, i11 - 1);
                byte[][] bArr = (byte[][]) l.j(commonSubstring.getSegments$okio(), segment, segment2 + 1);
                int[] iArr = new int[bArr.length * 2];
                if (segment <= segment2) {
                    int i13 = segment;
                    int i14 = 0;
                    while (true) {
                        iArr[i14] = Math.min(commonSubstring.getDirectory$okio()[i13] - i10, i12);
                        int i15 = i14 + 1;
                        iArr[i14 + bArr.length] = commonSubstring.getDirectory$okio()[commonSubstring.getSegments$okio().length + i13];
                        if (i13 == segment2) {
                            break;
                        }
                        i13++;
                        i14 = i15;
                    }
                }
                int i16 = segment != 0 ? commonSubstring.getDirectory$okio()[segment - 1] : 0;
                int length = bArr.length;
                iArr[length] = iArr[length] + (i10 - i16);
                return new SegmentedByteString(bArr, iArr);
            }
            throw new IllegalArgumentException(("endIndex=" + i11 + " < beginIndex=" + i10).toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString commonToByteArray) {
        s.i(commonToByteArray, "$this$commonToByteArray");
        byte[] bArr = new byte[commonToByteArray.size()];
        int length = commonToByteArray.getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = commonToByteArray.getDirectory$okio()[length + i10];
            int i14 = commonToByteArray.getDirectory$okio()[i10];
            int i15 = i14 - i11;
            l.e(commonToByteArray.getSegments$okio()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString commonWrite, @NotNull Buffer buffer, int i10, int i11) {
        s.i(commonWrite, "$this$commonWrite");
        s.i(buffer, "buffer");
        int i12 = i11 + i10;
        int segment = segment(commonWrite, i10);
        while (i10 < i12) {
            int i13 = segment == 0 ? 0 : commonWrite.getDirectory$okio()[segment - 1];
            int i14 = commonWrite.getDirectory$okio()[segment] - i13;
            int i15 = commonWrite.getDirectory$okio()[commonWrite.getSegments$okio().length + segment];
            int min = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            Segment segment2 = new Segment(commonWrite.getSegments$okio()[segment], i16, i16 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                s.f(segment3);
                Segment segment4 = segment3.prev;
                s.f(segment4);
                segment4.push(segment2);
            }
            i10 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + commonWrite.size());
    }

    public static final void forEachSegment(@NotNull SegmentedByteString forEachSegment, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, p> action) {
        s.i(forEachSegment, "$this$forEachSegment");
        s.i(action, "action");
        int length = forEachSegment.getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = forEachSegment.getDirectory$okio()[length + i10];
            int i13 = forEachSegment.getDirectory$okio()[i10];
            action.invoke(forEachSegment.getSegments$okio()[i10], Integer.valueOf(i12), Integer.valueOf(i13 - i11));
            i10++;
            i11 = i13;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segment, int i10) {
        s.i(segment, "$this$segment");
        int binarySearch = binarySearch(segment.getDirectory$okio(), i10 + 1, 0, segment.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i10, int i11, Function3<? super byte[], ? super Integer, ? super Integer, p> function3) {
        int segment = segment(segmentedByteString, i10);
        while (i10 < i11) {
            int i12 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i13 = segmentedByteString.getDirectory$okio()[segment] - i12;
            int i14 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i11, i13 + i12) - i10;
            function3.invoke(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i14 + (i10 - i12)), Integer.valueOf(min));
            i10 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString commonRangeEquals, int i10, @NotNull byte[] other, int i11, int i12) {
        s.i(commonRangeEquals, "$this$commonRangeEquals");
        s.i(other, "other");
        if (i10 < 0 || i10 > commonRangeEquals.size() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int segment = segment(commonRangeEquals, i10);
        while (i10 < i13) {
            int i14 = segment == 0 ? 0 : commonRangeEquals.getDirectory$okio()[segment - 1];
            int i15 = commonRangeEquals.getDirectory$okio()[segment] - i14;
            int i16 = commonRangeEquals.getDirectory$okio()[commonRangeEquals.getSegments$okio().length + segment];
            int min = Math.min(i13, i15 + i14) - i10;
            if (!Util.arrayRangeEquals(commonRangeEquals.getSegments$okio()[segment], i16 + (i10 - i14), other, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }
}
