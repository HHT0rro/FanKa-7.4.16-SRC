package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f20899c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20900d;

    /* renamed from: e, reason: collision with root package name */
    public final String f20901e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f20902f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<GeobFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GeobFrame[] newArray(int i10) {
            return new GeobFrame[i10];
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f20899c = str;
        this.f20900d = str2;
        this.f20901e = str3;
        this.f20902f = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return j0.c(this.f20899c, geobFrame.f20899c) && j0.c(this.f20900d, geobFrame.f20900d) && j0.c(this.f20901e, geobFrame.f20901e) && Arrays.equals(this.f20902f, geobFrame.f20902f);
    }

    public int hashCode() {
        String str = this.f20899c;
        int hashCode = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20900d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f20901e;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f20902f);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f20903b;
        String str2 = this.f20899c;
        String str3 = this.f20900d;
        String str4 = this.f20901e;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb2.append(str);
        sb2.append(": mimeType=");
        sb2.append(str2);
        sb2.append(", filename=");
        sb2.append(str3);
        sb2.append(", description=");
        sb2.append(str4);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20899c);
        parcel.writeString(this.f20900d);
        parcel.writeString(this.f20901e);
        parcel.writeByteArray(this.f20902f);
    }

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f20899c = (String) j0.j(parcel.readString());
        this.f20900d = (String) j0.j(parcel.readString());
        this.f20901e = (String) j0.j(parcel.readString());
        this.f20902f = (byte[]) j0.j(parcel.createByteArray());
    }
}
