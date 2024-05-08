package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();

    /* renamed from: a, reason: collision with root package name */
    private final Uri f29775a;

    /* renamed from: b, reason: collision with root package name */
    private final int f29776b;

    /* renamed from: c, reason: collision with root package name */
    private final int f29777c;

    public WebServerPic(Uri uri, int i10, int i11) throws IllegalArgumentException {
        this.f29775a = uri;
        this.f29776b = i10;
        this.f29777c = i11;
        if (uri == null) {
            throw new IllegalArgumentException("url is not able to be null");
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.f29777c;
    }

    public final Uri getUrl() {
        return this.f29775a;
    }

    public final int getWidth() {
        return this.f29776b;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "Image %dx%d %s", Integer.valueOf(this.f29776b), Integer.valueOf(this.f29777c), this.f29775a.toString());
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i10, false);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public WebServerPic(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }
}
