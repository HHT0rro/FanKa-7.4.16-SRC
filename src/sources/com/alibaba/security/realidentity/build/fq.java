package com.alibaba.security.realidentity.build;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.security.realidentity.build.fq;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.util.Map;

/* compiled from: MultipartUploadRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class fq<T extends fq> extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3670a;

    /* renamed from: b, reason: collision with root package name */
    public String f3671b;

    /* renamed from: c, reason: collision with root package name */
    public String f3672c;

    /* renamed from: d, reason: collision with root package name */
    public String f3673d;

    /* renamed from: e, reason: collision with root package name */
    public long f3674e;

    /* renamed from: f, reason: collision with root package name */
    public fu f3675f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f3676g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f3677h;

    /* renamed from: i, reason: collision with root package name */
    public by<T> f3678i;

    private fq(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    private void b(String str) {
        this.f3670a = str;
    }

    private void c(String str) {
        this.f3671b = str;
    }

    private void d(String str) {
        this.f3673d = str;
    }

    private String i() {
        return this.f3672c;
    }

    public final String a() {
        return this.f3670a;
    }

    public final by<T> e() {
        return this.f3678i;
    }

    public final long f() {
        return this.f3674e;
    }

    public final Map<String, String> g() {
        return this.f3676g;
    }

    public final Map<String, String> h() {
        return this.f3677h;
    }

    public fq(String str, String str2, String str3, fu fuVar) {
        this.f3674e = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.f3670a = str;
        this.f3671b = str2;
        this.f3673d = str3;
        this.f3675f = fuVar;
    }

    private void a(fu fuVar) {
        this.f3675f = fuVar;
    }

    public final String b() {
        return this.f3671b;
    }

    public final String c() {
        return this.f3673d;
    }

    public final fu d() {
        return this.f3675f;
    }

    private void a(by<T> byVar) {
        this.f3678i = byVar;
    }

    private void b(Map<String, String> map) {
        this.f3677h = map;
    }

    public final void a(long j10) {
        this.f3674e = j10;
    }

    private void a(Map<String, String> map) {
        this.f3676g = map;
    }

    public final void a(String str) {
        this.f3672c = str;
    }
}
