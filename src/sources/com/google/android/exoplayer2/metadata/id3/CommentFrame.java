package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f20896c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20897d;

    /* renamed from: e, reason: collision with root package name */
    public final String f20898e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<CommentFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommentFrame[] newArray(int i10) {
            return new CommentFrame[i10];
        }
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f20896c = str;
        this.f20897d = str2;
        this.f20898e = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return j0.c(this.f20897d, commentFrame.f20897d) && j0.c(this.f20896c, commentFrame.f20896c) && j0.c(this.f20898e, commentFrame.f20898e);
    }

    public int hashCode() {
        String str = this.f20896c;
        int hashCode = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20897d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f20898e;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f20903b;
        String str2 = this.f20896c;
        String str3 = this.f20897d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": language=");
        sb2.append(str2);
        sb2.append(", description=");
        sb2.append(str3);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20903b);
        parcel.writeString(this.f20896c);
        parcel.writeString(this.f20898e);
    }

    public CommentFrame(Parcel parcel) {
        super("COMM");
        this.f20896c = (String) j0.j(parcel.readString());
        this.f20897d = (String) j0.j(parcel.readString());
        this.f20898e = (String) j0.j(parcel.readString());
    }
}
