package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.alibaba.security.realidentity.build.cs;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.g0;
import com.wangmai.okhttp.model.HttpHeaders;
import java.util.List;
import java.util.Map;

/* compiled from: RtspHeaders.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f21938b = new b().e();

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableListMultimap<String, String> f21939a;

    /* compiled from: RtspHeaders.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableListMultimap.a<String, String> f21940a = new ImmutableListMultimap.a<>();

        public b b(String str, String str2) {
            this.f21940a.c(e.c(str.trim()), str2.trim());
            return this;
        }

        public b c(List<String> list) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                String[] N0 = j0.N0(list.get(i10), ":\\s?");
                if (N0.length == 2) {
                    b(N0[0], N0[1]);
                }
            }
            return this;
        }

        public b d(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public e e() {
            return new e(this);
        }
    }

    public static String c(String str) {
        return com.google.common.base.a.a(str, HttpHeaders.HEAD_KEY_ACCEPT) ? HttpHeaders.HEAD_KEY_ACCEPT : com.google.common.base.a.a(str, "Allow") ? "Allow" : com.google.common.base.a.a(str, cs.K) ? cs.K : com.google.common.base.a.a(str, "Bandwidth") ? "Bandwidth" : com.google.common.base.a.a(str, "Blocksize") ? "Blocksize" : com.google.common.base.a.a(str, "Cache-Control") ? "Cache-Control" : com.google.common.base.a.a(str, HttpHeaders.HEAD_KEY_CONNECTION) ? HttpHeaders.HEAD_KEY_CONNECTION : com.google.common.base.a.a(str, "Content-Base") ? "Content-Base" : com.google.common.base.a.a(str, "Content-Encoding") ? "Content-Encoding" : com.google.common.base.a.a(str, "Content-Language") ? "Content-Language" : com.google.common.base.a.a(str, "Content-Length") ? "Content-Length" : com.google.common.base.a.a(str, "Content-Location") ? "Content-Location" : com.google.common.base.a.a(str, "Content-Type") ? "Content-Type" : com.google.common.base.a.a(str, "CSeq") ? "CSeq" : com.google.common.base.a.a(str, "Date") ? "Date" : com.google.common.base.a.a(str, "Expires") ? "Expires" : com.google.common.base.a.a(str, "Proxy-Authenticate") ? "Proxy-Authenticate" : com.google.common.base.a.a(str, "Proxy-Require") ? "Proxy-Require" : com.google.common.base.a.a(str, "Public") ? "Public" : com.google.common.base.a.a(str, "Range") ? "Range" : com.google.common.base.a.a(str, "RTP-Info") ? "RTP-Info" : com.google.common.base.a.a(str, "RTCP-Interval") ? "RTCP-Interval" : com.google.common.base.a.a(str, "Scale") ? "Scale" : com.google.common.base.a.a(str, "Session") ? "Session" : com.google.common.base.a.a(str, "Speed") ? "Speed" : com.google.common.base.a.a(str, "Supported") ? "Supported" : com.google.common.base.a.a(str, "Timestamp") ? "Timestamp" : com.google.common.base.a.a(str, "Transport") ? "Transport" : com.google.common.base.a.a(str, "User-Agent") ? "User-Agent" : com.google.common.base.a.a(str, "Via") ? "Via" : com.google.common.base.a.a(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }

    public ImmutableListMultimap<String, String> b() {
        return this.f21939a;
    }

    @Nullable
    public String d(String str) {
        ImmutableList<String> e2 = e(str);
        if (e2.isEmpty()) {
            return null;
        }
        return (String) g0.f(e2);
    }

    public ImmutableList<String> e(String str) {
        return this.f21939a.get((ImmutableListMultimap<String, String>) c(str));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f21939a.equals(((e) obj).f21939a);
        }
        return false;
    }

    public int hashCode() {
        return this.f21939a.hashCode();
    }

    public e(b bVar) {
        this.f21939a = bVar.f21940a.h();
    }
}
