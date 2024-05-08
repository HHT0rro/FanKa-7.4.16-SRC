package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.j0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f20869b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20870c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<VorbisComment> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VorbisComment[] newArray(int i10) {
            return new VorbisComment[i10];
        }
    }

    public VorbisComment(String str, String str2) {
        this.f20869b = str;
        this.f20870c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || VorbisComment.class != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.f20869b.equals(vorbisComment.f20869b) && this.f20870c.equals(vorbisComment.f20870c);
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
        return ((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20869b.hashCode()) * 31) + this.f20870c.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.f20869b;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c4 = 0;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c4 = 1;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                builder.K(this.f20870c);
                return;
            case 1:
                builder.V(this.f20870c);
                return;
            case 2:
                builder.O(this.f20870c);
                return;
            case 3:
                builder.J(this.f20870c);
                return;
            case 4:
                builder.L(this.f20870c);
                return;
            default:
                return;
        }
    }

    public String toString() {
        String str = this.f20869b;
        String str2 = this.f20870c;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length());
        sb2.append("VC: ");
        sb2.append(str);
        sb2.append("=");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20869b);
        parcel.writeString(this.f20870c);
    }

    public VorbisComment(Parcel parcel) {
        this.f20869b = (String) j0.j(parcel.readString());
        this.f20870c = (String) j0.j(parcel.readString());
    }
}
