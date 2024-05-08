package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.util.j0;
import com.google.common.base.l;
import com.google.common.collect.p;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new a();
    public final List<Segment> segments;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Segment implements Parcelable {

        /* renamed from: b, reason: collision with root package name */
        public final long f20928b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20929c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20930d;

        /* renamed from: e, reason: collision with root package name */
        public static final Comparator<Segment> f20927e = new Comparator() { // from class: s5.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b4;
                b4 = SlowMotionData.Segment.b((SlowMotionData.Segment) obj, (SlowMotionData.Segment) obj2);
                return b4;
            }
        };
        public static final Parcelable.Creator<Segment> CREATOR = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class a implements Parcelable.Creator<Segment> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Segment[] newArray(int i10) {
                return new Segment[i10];
            }
        }

        public Segment(long j10, long j11, int i10) {
            com.google.android.exoplayer2.util.a.a(j10 < j11);
            this.f20928b = j10;
            this.f20929c = j11;
            this.f20930d = i10;
        }

        public static /* synthetic */ int b(Segment segment, Segment segment2) {
            return p.k().e(segment.f20928b, segment2.f20928b).e(segment.f20929c, segment2.f20929c).d(segment.f20930d, segment2.f20930d).j();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.f20928b == segment.f20928b && this.f20929c == segment.f20929c && this.f20930d == segment.f20930d;
        }

        public int hashCode() {
            return l.b(Long.valueOf(this.f20928b), Long.valueOf(this.f20929c), Integer.valueOf(this.f20930d));
        }

        public String toString() {
            return j0.D("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f20928b), Long.valueOf(this.f20929c), Integer.valueOf(this.f20930d));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeLong(this.f20928b);
            parcel.writeLong(this.f20929c);
            parcel.writeInt(this.f20930d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<SlowMotionData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SlowMotionData[] newArray(int i10) {
            return new SlowMotionData[i10];
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.segments = list;
        com.google.android.exoplayer2.util.a.a(!doSegmentsOverlap(list));
    }

    private static boolean doSegmentsOverlap(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j10 = list.get(0).f20929c;
        for (int i10 = 1; i10 < list.size(); i10++) {
            if (list.get(i10).f20928b < j10) {
                return true;
            }
            j10 = list.get(i10).f20929c;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.segments.equals(((SlowMotionData) obj).segments);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public /* bridge */ /* synthetic */ byte[] getWrappedMetadataBytes() {
        return n5.a.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public /* bridge */ /* synthetic */ Format getWrappedMetadataFormat() {
        return n5.a.b(this);
    }

    public int hashCode() {
        return this.segments.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* bridge */ /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        n5.a.c(this, builder);
    }

    public String toString() {
        String valueOf = String.valueOf(this.segments);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
        sb2.append("SlowMotion: segments=");
        sb2.append(valueOf);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.segments);
    }
}
