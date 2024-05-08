package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.h;
import com.google.android.exoplayer2.util.j0;
import com.huawei.openalliance.ad.constant.u;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: RtspAuthenticationInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f21910a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21911b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21912c;

    /* renamed from: d, reason: collision with root package name */
    public final String f21913d;

    public c(int i10, String str, String str2, String str3) {
        this.f21910a = i10;
        this.f21911b = str;
        this.f21912c = str2;
        this.f21913d = str3;
    }

    public String a(h.a aVar, Uri uri, int i10) throws ParserException {
        int i11 = this.f21910a;
        if (i11 == 1) {
            return b(aVar);
        }
        if (i11 == 2) {
            return c(aVar, uri, i10);
        }
        throw ParserException.createForManifestWithUnsupportedFeature(null, new UnsupportedOperationException());
    }

    public final String b(h.a aVar) {
        String str = aVar.f22001a;
        String str2 = aVar.f22002b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(u.bD);
        sb2.append(str2);
        return Base64.encodeToString(h.b(sb2.toString()), 0);
    }

    public final String c(h.a aVar, Uri uri, int i10) throws ParserException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String o10 = h.o(i10);
            String str = aVar.f22001a;
            String str2 = this.f21911b;
            String str3 = aVar.f22002b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
            sb2.append(str);
            sb2.append(u.bD);
            sb2.append(str2);
            sb2.append(u.bD);
            sb2.append(str3);
            String T0 = j0.T0(messageDigest.digest(h.b(sb2.toString())));
            String valueOf = String.valueOf(uri);
            StringBuilder sb3 = new StringBuilder(String.valueOf(o10).length() + 1 + valueOf.length());
            sb3.append(o10);
            sb3.append(u.bD);
            sb3.append(valueOf);
            String T02 = j0.T0(messageDigest.digest(h.b(sb3.toString())));
            String str4 = this.f21912c;
            StringBuilder sb4 = new StringBuilder(String.valueOf(T0).length() + 2 + String.valueOf(str4).length() + String.valueOf(T02).length());
            sb4.append(T0);
            sb4.append(u.bD);
            sb4.append(str4);
            sb4.append(u.bD);
            sb4.append(T02);
            String T03 = j0.T0(messageDigest.digest(h.b(sb4.toString())));
            return this.f21913d.isEmpty() ? j0.D("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", aVar.f22001a, this.f21911b, this.f21912c, uri, T03) : j0.D("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", aVar.f22001a, this.f21911b, this.f21912c, uri, T03, this.f21913d);
        } catch (NoSuchAlgorithmException e2) {
            throw ParserException.createForManifestWithUnsupportedFeature(null, e2);
        }
    }
}
