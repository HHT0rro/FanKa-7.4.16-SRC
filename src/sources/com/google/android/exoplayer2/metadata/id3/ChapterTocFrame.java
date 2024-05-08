package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f20891c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20892d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f20893e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f20894f;

    /* renamed from: g, reason: collision with root package name */
    public final Id3Frame[] f20895g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame[] newArray(int i10) {
            return new ChapterTocFrame[i10];
        }
    }

    public ChapterTocFrame(String str, boolean z10, boolean z11, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f20891c = str;
        this.f20892d = z10;
        this.f20893e = z11;
        this.f20894f = strArr;
        this.f20895g = id3FrameArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.f20892d == chapterTocFrame.f20892d && this.f20893e == chapterTocFrame.f20893e && j0.c(this.f20891c, chapterTocFrame.f20891c) && Arrays.equals(this.f20894f, chapterTocFrame.f20894f) && Arrays.equals(this.f20895g, chapterTocFrame.f20895g);
    }

    public int hashCode() {
        int i10 = (((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + (this.f20892d ? 1 : 0)) * 31) + (this.f20893e ? 1 : 0)) * 31;
        String str = this.f20891c;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20891c);
        parcel.writeByte(this.f20892d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f20893e ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f20894f);
        parcel.writeInt(this.f20895g.length);
        for (Id3Frame id3Frame : this.f20895g) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f20891c = (String) j0.j(parcel.readString());
        this.f20892d = parcel.readByte() != 0;
        this.f20893e = parcel.readByte() != 0;
        this.f20894f = (String[]) j0.j(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f20895g = new Id3Frame[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f20895g[i10] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
