package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f20880c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20881d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20882e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f20883f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<ApicFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ApicFrame[] newArray(int i10) {
            return new ApicFrame[i10];
        }
    }

    public ApicFrame(String str, @Nullable String str2, int i10, byte[] bArr) {
        super("APIC");
        this.f20880c = str;
        this.f20881d = str2;
        this.f20882e = i10;
        this.f20883f = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.f20882e == apicFrame.f20882e && j0.c(this.f20880c, apicFrame.f20880c) && j0.c(this.f20881d, apicFrame.f20881d) && Arrays.equals(this.f20883f, apicFrame.f20883f);
    }

    public int hashCode() {
        int i10 = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20882e) * 31;
        String str = this.f20880c;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20881d;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f20883f);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        builder.G(this.f20883f, this.f20882e);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f20903b;
        String str2 = this.f20880c;
        String str3 = this.f20881d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": mimeType=");
        sb2.append(str2);
        sb2.append(", description=");
        sb2.append(str3);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20880c);
        parcel.writeString(this.f20881d);
        parcel.writeInt(this.f20882e);
        parcel.writeByteArray(this.f20883f);
    }

    public ApicFrame(Parcel parcel) {
        super("APIC");
        this.f20880c = (String) j0.j(parcel.readString());
        this.f20881d = parcel.readString();
        this.f20882e = parcel.readInt();
        this.f20883f = (byte[]) j0.j(parcel.createByteArray());
    }
}
