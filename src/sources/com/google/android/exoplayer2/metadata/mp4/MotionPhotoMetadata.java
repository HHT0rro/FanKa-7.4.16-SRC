package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.primitives.Longs;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f20922b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20923c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20924d;

    /* renamed from: e, reason: collision with root package name */
    public final long f20925e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20926f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<MotionPhotoMetadata> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MotionPhotoMetadata[] newArray(int i10) {
            return new MotionPhotoMetadata[i10];
        }
    }

    public /* synthetic */ MotionPhotoMetadata(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        return this.f20922b == motionPhotoMetadata.f20922b && this.f20923c == motionPhotoMetadata.f20923c && this.f20924d == motionPhotoMetadata.f20924d && this.f20925e == motionPhotoMetadata.f20925e && this.f20926f == motionPhotoMetadata.f20926f;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return n5.a.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format getWrappedMetadataFormat() {
        return n5.a.b(this);
    }

    public int hashCode() {
        return ((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + Longs.e(this.f20922b)) * 31) + Longs.e(this.f20923c)) * 31) + Longs.e(this.f20924d)) * 31) + Longs.e(this.f20925e)) * 31) + Longs.e(this.f20926f);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        n5.a.c(this, builder);
    }

    public String toString() {
        long j10 = this.f20922b;
        long j11 = this.f20923c;
        long j12 = this.f20924d;
        long j13 = this.f20925e;
        long j14 = this.f20926f;
        StringBuilder sb2 = new StringBuilder(218);
        sb2.append("Motion photo metadata: photoStartPosition=");
        sb2.append(j10);
        sb2.append(", photoSize=");
        sb2.append(j11);
        sb2.append(", photoPresentationTimestampUs=");
        sb2.append(j12);
        sb2.append(", videoStartPosition=");
        sb2.append(j13);
        sb2.append(", videoSize=");
        sb2.append(j14);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f20922b);
        parcel.writeLong(this.f20923c);
        parcel.writeLong(this.f20924d);
        parcel.writeLong(this.f20925e);
        parcel.writeLong(this.f20926f);
    }

    public MotionPhotoMetadata(long j10, long j11, long j12, long j13, long j14) {
        this.f20922b = j10;
        this.f20923c = j11;
        this.f20924d = j12;
        this.f20925e = j13;
        this.f20926f = j14;
    }

    public MotionPhotoMetadata(Parcel parcel) {
        this.f20922b = parcel.readLong();
        this.f20923c = parcel.readLong();
        this.f20924d = parcel.readLong();
        this.f20925e = parcel.readLong();
        this.f20926f = parcel.readLong();
    }
}
