package com.google.android.exoplayer2.metadata.mp4;

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
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f20918b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f20919c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20920d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20921e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<MdtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry[] newArray(int i10) {
            return new MdtaMetadataEntry[i10];
        }
    }

    public /* synthetic */ MdtaMetadataEntry(Parcel parcel, a aVar) {
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
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.f20918b.equals(mdtaMetadataEntry.f20918b) && Arrays.equals(this.f20919c, mdtaMetadataEntry.f20919c) && this.f20920d == mdtaMetadataEntry.f20920d && this.f20921e == mdtaMetadataEntry.f20921e;
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
        return ((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20918b.hashCode()) * 31) + Arrays.hashCode(this.f20919c)) * 31) + this.f20920d) * 31) + this.f20921e;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        n5.a.c(this, builder);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f20918b);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20918b);
        parcel.writeByteArray(this.f20919c);
        parcel.writeInt(this.f20920d);
        parcel.writeInt(this.f20921e);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i10, int i11) {
        this.f20918b = str;
        this.f20919c = bArr;
        this.f20920d = i10;
        this.f20921e = i11;
    }

    public MdtaMetadataEntry(Parcel parcel) {
        this.f20918b = (String) j0.j(parcel.readString());
        this.f20919c = (byte[]) j0.j(parcel.createByteArray());
        this.f20920d = parcel.readInt();
        this.f20921e = parcel.readInt();
    }
}
