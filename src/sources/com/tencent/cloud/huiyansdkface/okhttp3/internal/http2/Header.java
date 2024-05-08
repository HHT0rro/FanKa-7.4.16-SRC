package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.android.internal.logging.nano.MetricsProto;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.ByteString;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Header {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f41825a = ByteString.encodeUtf8(u.bD);

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f41826b = ByteString.encodeUtf8(":status");

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f41827c = ByteString.encodeUtf8(":method");

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f41828d = ByteString.encodeUtf8(":path");

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f41829e = ByteString.encodeUtf8(":scheme");

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f41830f = ByteString.encodeUtf8(":authority");

    /* renamed from: g, reason: collision with root package name */
    public final ByteString f41831g;

    /* renamed from: h, reason: collision with root package name */
    public final ByteString f41832h;

    /* renamed from: i, reason: collision with root package name */
    public final int f41833i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Listener {
        void onHeaders(Headers headers);
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.f41831g = byteString;
        this.f41832h = byteString2;
        this.f41833i = byteString.size() + 32 + byteString2.size();
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.f41831g.equals(header.f41831g) && this.f41832h.equals(header.f41832h);
    }

    public int hashCode() {
        return ((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f41831g.hashCode()) * 31) + this.f41832h.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.f41831g.utf8(), this.f41832h.utf8());
    }
}
