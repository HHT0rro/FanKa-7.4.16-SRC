package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f21478b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f21479c;

    /* renamed from: d, reason: collision with root package name */
    public final List<VariantInfo> f21480d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<HlsTrackMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HlsTrackMetadataEntry[] newArray(int i10) {
            return new HlsTrackMetadataEntry[i10];
        }
    }

    public HlsTrackMetadataEntry(@Nullable String str, @Nullable String str2, List<VariantInfo> list) {
        this.f21478b = str;
        this.f21479c = str2;
        this.f21480d = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        return TextUtils.equals(this.f21478b, hlsTrackMetadataEntry.f21478b) && TextUtils.equals(this.f21479c, hlsTrackMetadataEntry.f21479c) && this.f21480d.equals(hlsTrackMetadataEntry.f21480d);
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
        String str = this.f21478b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f21479c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f21480d.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        n5.a.c(this, builder);
    }

    public String toString() {
        String str;
        String str2 = this.f21478b;
        if (str2 != null) {
            String str3 = this.f21479c;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 5 + String.valueOf(str3).length());
            sb2.append(" [");
            sb2.append(str2);
            sb2.append(", ");
            sb2.append(str3);
            sb2.append("]");
            str = sb2.toString();
        } else {
            str = "";
        }
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(valueOf) : new String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21478b);
        parcel.writeString(this.f21479c);
        int size = this.f21480d.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeParcelable(this.f21480d.get(i11), 0);
        }
    }

    public HlsTrackMetadataEntry(Parcel parcel) {
        this.f21478b = parcel.readString();
        this.f21479c = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f21480d = Collections.unmodifiableList(arrayList);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public final int f21481b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21482c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f21483d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f21484e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f21485f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public final String f21486g;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class a implements Parcelable.Creator<VariantInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public VariantInfo[] newArray(int i10) {
                return new VariantInfo[i10];
            }
        }

        public VariantInfo(int i10, int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f21481b = i10;
            this.f21482c = i11;
            this.f21483d = str;
            this.f21484e = str2;
            this.f21485f = str3;
            this.f21486g = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            return this.f21481b == variantInfo.f21481b && this.f21482c == variantInfo.f21482c && TextUtils.equals(this.f21483d, variantInfo.f21483d) && TextUtils.equals(this.f21484e, variantInfo.f21484e) && TextUtils.equals(this.f21485f, variantInfo.f21485f) && TextUtils.equals(this.f21486g, variantInfo.f21486g);
        }

        public int hashCode() {
            int i10 = ((this.f21481b * 31) + this.f21482c) * 31;
            String str = this.f21483d;
            int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f21484e;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f21485f;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f21486g;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f21481b);
            parcel.writeInt(this.f21482c);
            parcel.writeString(this.f21483d);
            parcel.writeString(this.f21484e);
            parcel.writeString(this.f21485f);
            parcel.writeString(this.f21486g);
        }

        public VariantInfo(Parcel parcel) {
            this.f21481b = parcel.readInt();
            this.f21482c = parcel.readInt();
            this.f21483d = parcel.readString();
            this.f21484e = parcel.readString();
            this.f21485f = parcel.readString();
            this.f21486g = parcel.readString();
        }
    }
}
