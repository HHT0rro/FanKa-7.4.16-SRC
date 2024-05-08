package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f20861b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20862c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20863d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20864e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20865f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20866g;

    /* renamed from: h, reason: collision with root package name */
    public final int f20867h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f20868i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<PictureFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PictureFrame[] newArray(int i10) {
            return new PictureFrame[i10];
        }
    }

    public PictureFrame(int i10, String str, String str2, int i11, int i12, int i13, int i14, byte[] bArr) {
        this.f20861b = i10;
        this.f20862c = str;
        this.f20863d = str2;
        this.f20864e = i11;
        this.f20865f = i12;
        this.f20866g = i13;
        this.f20867h = i14;
        this.f20868i = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.f20861b == pictureFrame.f20861b && this.f20862c.equals(pictureFrame.f20862c) && this.f20863d.equals(pictureFrame.f20863d) && this.f20864e == pictureFrame.f20864e && this.f20865f == pictureFrame.f20865f && this.f20866g == pictureFrame.f20866g && this.f20867h == pictureFrame.f20867h && Arrays.equals(this.f20868i, pictureFrame.f20868i);
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
        return ((((((((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20861b) * 31) + this.f20862c.hashCode()) * 31) + this.f20863d.hashCode()) * 31) + this.f20864e) * 31) + this.f20865f) * 31) + this.f20866g) * 31) + this.f20867h) * 31) + Arrays.hashCode(this.f20868i);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        builder.G(this.f20868i, this.f20861b);
    }

    public String toString() {
        String str = this.f20862c;
        String str2 = this.f20863d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(str2).length());
        sb2.append("Picture: mimeType=");
        sb2.append(str);
        sb2.append(", description=");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f20861b);
        parcel.writeString(this.f20862c);
        parcel.writeString(this.f20863d);
        parcel.writeInt(this.f20864e);
        parcel.writeInt(this.f20865f);
        parcel.writeInt(this.f20866g);
        parcel.writeInt(this.f20867h);
        parcel.writeByteArray(this.f20868i);
    }

    public PictureFrame(Parcel parcel) {
        this.f20861b = parcel.readInt();
        this.f20862c = (String) j0.j(parcel.readString());
        this.f20863d = (String) j0.j(parcel.readString());
        this.f20864e = parcel.readInt();
        this.f20865f = parcel.readInt();
        this.f20866g = parcel.readInt();
        this.f20867h = parcel.readInt();
        this.f20868i = (byte[]) j0.j(parcel.createByteArray());
    }
}
