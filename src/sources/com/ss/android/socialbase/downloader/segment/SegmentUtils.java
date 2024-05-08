package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SegmentUtils {
    public static long getDownloadedBytes(@NonNull List<Segment> list) {
        long j10;
        long j11;
        long j12 = 0;
        loop0: while (true) {
            j10 = -1;
            j11 = -1;
            for (Segment segment : list) {
                if (j10 == -1) {
                    if (segment.getDownloadBytes() > 0) {
                        j10 = segment.getStartOffset();
                        j11 = segment.getCurrentOffset();
                    }
                } else if (segment.getStartOffset() > j11) {
                    j12 += j11 - j10;
                    if (segment.getDownloadBytes() > 0) {
                        j10 = segment.getStartOffset();
                        j11 = segment.getCurrentOffset();
                    }
                } else if (segment.getCurrentOffset() > j11) {
                    j11 = segment.getCurrentOffset();
                }
            }
        }
        return (j10 < 0 || j11 <= j10) ? j12 : j12 + (j11 - j10);
    }

    public static long getFirstOffset(@NonNull List<Segment> list) {
        int size = list.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Segment segment = list.get(i10);
            if (segment.getStartOffset() > j10) {
                break;
            }
            if (segment.getCurrentOffsetRead() > j10) {
                j10 = segment.getCurrentOffsetRead();
            }
        }
        return j10;
    }
}
