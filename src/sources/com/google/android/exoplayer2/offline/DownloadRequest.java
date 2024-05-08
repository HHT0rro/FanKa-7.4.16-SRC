package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f20996b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f20997c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20998d;

    /* renamed from: e, reason: collision with root package name */
    public final List<StreamKey> f20999e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final byte[] f21000f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f21001g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f21002h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class UnsupportedRequestException extends IOException {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<DownloadRequest> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadRequest[] newArray(int i10) {
            return new DownloadRequest[i10];
        }
    }

    public DownloadRequest(Parcel parcel) {
        this.f20996b = (String) j0.j(parcel.readString());
        this.f20997c = Uri.parse((String) j0.j(parcel.readString()));
        this.f20998d = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f20999e = Collections.unmodifiableList(arrayList);
        this.f21000f = parcel.createByteArray();
        this.f21001g = parcel.readString();
        this.f21002h = (byte[]) j0.j(parcel.createByteArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f20996b.equals(downloadRequest.f20996b) && this.f20997c.equals(downloadRequest.f20997c) && j0.c(this.f20998d, downloadRequest.f20998d) && this.f20999e.equals(downloadRequest.f20999e) && Arrays.equals(this.f21000f, downloadRequest.f21000f) && j0.c(this.f21001g, downloadRequest.f21001g) && Arrays.equals(this.f21002h, downloadRequest.f21002h);
    }

    public final int hashCode() {
        int hashCode = ((this.f20996b.hashCode() * 31 * 31) + this.f20997c.hashCode()) * 31;
        String str = this.f20998d;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f20999e.hashCode()) * 31) + Arrays.hashCode(this.f21000f)) * 31;
        String str2 = this.f21001g;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f21002h);
    }

    public String toString() {
        String str = this.f20998d;
        String str2 = this.f20996b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(u.bD);
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20996b);
        parcel.writeString(this.f20997c.toString());
        parcel.writeString(this.f20998d);
        parcel.writeInt(this.f20999e.size());
        for (int i11 = 0; i11 < this.f20999e.size(); i11++) {
            parcel.writeParcelable(this.f20999e.get(i11), 0);
        }
        parcel.writeByteArray(this.f21000f);
        parcel.writeString(this.f21001g);
        parcel.writeByteArray(this.f21002h);
    }
}
