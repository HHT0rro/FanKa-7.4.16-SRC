package com.ss.android.socialbase.downloader.segment;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Segment {
    private static final String TAG = "Segment";
    public int competitor;
    private final AtomicLong currentOffset;
    private volatile long currentOffsetRead;
    private long endOffset;
    private int index;
    private JSONObject jsonObject;
    public volatile SegmentReader owner;
    private final long startOffset;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface JsonKey {
        public static final String CURRENT = "cu";
        public static final String END = "en";
        public static final String START = "st";
    }

    public Segment(long j10) {
        this(j10, -1L);
    }

    public void decreaseCompetitor() {
        this.competitor--;
    }

    public int getCompetitor() {
        return this.competitor;
    }

    public long getCurrentOffset() {
        long j10 = this.currentOffset.get();
        long j11 = this.endOffset;
        if (j11 > 0) {
            long j12 = j11 + 1;
            if (j10 > j12) {
                return j12;
            }
        }
        return j10;
    }

    public long getCurrentOffsetRead() {
        SegmentReader segmentReader = this.owner;
        if (segmentReader != null) {
            long curSegmentReadOffset = segmentReader.getCurSegmentReadOffset();
            if (curSegmentReadOffset > this.currentOffsetRead) {
                return curSegmentReadOffset;
            }
        }
        return this.currentOffsetRead;
    }

    public long getDownloadBytes() {
        return this.currentOffset.get() - this.startOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public int getIndex() {
        return this.index;
    }

    public long getReadBytes() {
        return getCurrentOffsetRead() - this.startOffset;
    }

    public long getRemainDownloadBytes() {
        long j10 = this.endOffset;
        if (j10 >= this.startOffset) {
            return (j10 - this.currentOffset.get()) + 1;
        }
        return -1L;
    }

    public long getRemainReadBytes() {
        long j10 = this.endOffset;
        if (j10 >= this.startOffset) {
            return (j10 - getCurrentOffsetRead()) + 1;
        }
        return -1L;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public void increaseCompetitor() {
        this.competitor++;
    }

    public void increaseCurrentOffset(long j10) {
        this.currentOffset.addAndGet(j10);
    }

    public boolean isDownloaded() {
        return this.endOffset >= this.startOffset && this.currentOffset.get() > this.endOffset;
    }

    public boolean isReadFinish() {
        return this.endOffset >= this.startOffset && getCurrentOffsetRead() > this.endOffset;
    }

    public void setCompetitor(int i10) {
        this.competitor = i10;
    }

    public void setCurrentOffset(long j10) {
        long j11 = this.startOffset;
        if (j10 < j11) {
            j10 = j11;
        }
        long j12 = this.endOffset;
        if (j12 > 0) {
            long j13 = j12 + 1;
            if (j10 > j13) {
                j10 = j13;
            }
        }
        this.currentOffset.set(j10);
    }

    public void setCurrentOffsetRead(long j10) {
        if (j10 >= this.currentOffset.get()) {
            this.currentOffsetRead = j10;
        }
    }

    public void setEndOffset(long j10) {
        if (j10 >= this.startOffset) {
            this.endOffset = j10;
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setEndOffset: endOffset = ");
        sb2.append(j10);
        sb2.append(", segment = ");
        sb2.append((Object) this);
        if (j10 == -1) {
            this.endOffset = j10;
        }
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.jsonObject = jSONObject;
        }
        jSONObject.put(JsonKey.START, getStartOffset());
        jSONObject.put(JsonKey.CURRENT, getCurrentOffset());
        jSONObject.put("en", getEndOffset());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.startOffset + ",\t currentOffset=" + ((Object) this.currentOffset) + ",\t currentOffsetRead=" + getCurrentOffsetRead() + ",\t endOffset=" + this.endOffset + '}';
    }

    public Segment(long j10, long j11) {
        AtomicLong atomicLong = new AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = j10;
        atomicLong.set(j10);
        this.currentOffsetRead = j10;
        if (j11 >= j10) {
            this.endOffset = j11;
        } else {
            this.endOffset = -1L;
        }
    }

    public static String toString(List<Segment> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<Segment>() { // from class: com.ss.android.socialbase.downloader.segment.Segment.1
            @Override // java.util.Comparator
            public int compare(Segment segment, Segment segment2) {
                return (int) (segment.getStartOffset() - segment2.getStartOffset());
            }
        });
        StringBuilder sb2 = new StringBuilder();
        Iterator<Segment> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append((Object) iterator2.next());
            sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        return sb2.toString();
    }

    public Segment(Segment segment) {
        AtomicLong atomicLong = new AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = segment.startOffset;
        this.endOffset = segment.endOffset;
        atomicLong.set(segment.currentOffset.get());
        this.currentOffsetRead = atomicLong.get();
        this.index = segment.index;
    }

    public Segment(JSONObject jSONObject) {
        this.currentOffset = new AtomicLong();
        this.competitor = 0;
        this.startOffset = jSONObject.optLong(JsonKey.START);
        setEndOffset(jSONObject.optLong("en"));
        setCurrentOffset(jSONObject.optLong(JsonKey.CURRENT));
        setCurrentOffsetRead(getCurrentOffset());
    }
}
