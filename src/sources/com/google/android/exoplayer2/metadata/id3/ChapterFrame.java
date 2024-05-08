package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f20885c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20886d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20887e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20888f;

    /* renamed from: g, reason: collision with root package name */
    public final long f20889g;

    /* renamed from: h, reason: collision with root package name */
    public final Id3Frame[] f20890h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChapterFrame[] newArray(int i10) {
            return new ChapterFrame[i10];
        }
    }

    public ChapterFrame(String str, int i10, int i11, long j10, long j11, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f20885c = str;
        this.f20886d = i10;
        this.f20887e = i11;
        this.f20888f = j10;
        this.f20889g = j11;
        this.f20890h = id3FrameArr;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.f20886d == chapterFrame.f20886d && this.f20887e == chapterFrame.f20887e && this.f20888f == chapterFrame.f20888f && this.f20889g == chapterFrame.f20889g && j0.c(this.f20885c, chapterFrame.f20885c) && Arrays.equals(this.f20890h, chapterFrame.f20890h);
    }

    public int hashCode() {
        int i10 = (((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20886d) * 31) + this.f20887e) * 31) + ((int) this.f20888f)) * 31) + ((int) this.f20889g)) * 31;
        String str = this.f20885c;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20885c);
        parcel.writeInt(this.f20886d);
        parcel.writeInt(this.f20887e);
        parcel.writeLong(this.f20888f);
        parcel.writeLong(this.f20889g);
        parcel.writeInt(this.f20890h.length);
        for (Id3Frame id3Frame : this.f20890h) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f20885c = (String) j0.j(parcel.readString());
        this.f20886d = parcel.readInt();
        this.f20887e = parcel.readInt();
        this.f20888f = parcel.readLong();
        this.f20889g = parcel.readLong();
        int readInt = parcel.readInt();
        this.f20890h = new Id3Frame[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f20890h[i10] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
