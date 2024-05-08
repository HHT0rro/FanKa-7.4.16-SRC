package com.tencent.cloud.huiyansdkface.okio;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SegmentPool {
    public static final long MAX_SIZE = 65536;
    public static long byteCount;
    public static Segment next;

    private SegmentPool() {
    }

    public static void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException();
        }
        if (segment.shared) {
            return;
        }
        synchronized (SegmentPool.class) {
            long j10 = byteCount;
            if (j10 + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                return;
            }
            byteCount = j10 + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            segment.next = next;
            segment.limit = 0;
            segment.pos = 0;
            next = segment;
        }
    }

    public static Segment take() {
        synchronized (SegmentPool.class) {
            Segment segment = next;
            if (segment == null) {
                return new Segment();
            }
            next = segment.next;
            segment.next = null;
            byteCount -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return segment;
        }
    }
}
