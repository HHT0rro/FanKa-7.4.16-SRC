package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20916c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20917d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<UrlLinkFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UrlLinkFrame[] newArray(int i10) {
            return new UrlLinkFrame[i10];
        }
    }

    public UrlLinkFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.f20916c = str2;
        this.f20917d = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.f20903b.equals(urlLinkFrame.f20903b) && j0.c(this.f20916c, urlLinkFrame.f20916c) && j0.c(this.f20917d, urlLinkFrame.f20917d);
    }

    public int hashCode() {
        int hashCode = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20903b.hashCode()) * 31;
        String str = this.f20916c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20917d;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f20903b;
        String str2 = this.f20917d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 6 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(": url=");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20903b);
        parcel.writeString(this.f20916c);
        parcel.writeString(this.f20917d);
    }

    public UrlLinkFrame(Parcel parcel) {
        super((String) j0.j(parcel.readString()));
        this.f20916c = parcel.readString();
        this.f20917d = (String) j0.j(parcel.readString());
    }
}
