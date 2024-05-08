package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f20904c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20905d;

    /* renamed from: e, reason: collision with root package name */
    public final String f20906e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<InternalFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InternalFrame[] newArray(int i10) {
            return new InternalFrame[i10];
        }
    }

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f20904c = str;
        this.f20905d = str2;
        this.f20906e = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return j0.c(this.f20905d, internalFrame.f20905d) && j0.c(this.f20904c, internalFrame.f20904c) && j0.c(this.f20906e, internalFrame.f20906e);
    }

    public int hashCode() {
        String str = this.f20904c;
        int hashCode = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20905d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f20906e;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f20903b;
        String str2 = this.f20904c;
        String str3 = this.f20905d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": domain=");
        sb2.append(str2);
        sb2.append(", description=");
        sb2.append(str3);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20903b);
        parcel.writeString(this.f20904c);
        parcel.writeString(this.f20906e);
    }

    public InternalFrame(Parcel parcel) {
        super("----");
        this.f20904c = (String) j0.j(parcel.readString());
        this.f20905d = (String) j0.j(parcel.readString());
        this.f20906e = (String) j0.j(parcel.readString());
    }
}
