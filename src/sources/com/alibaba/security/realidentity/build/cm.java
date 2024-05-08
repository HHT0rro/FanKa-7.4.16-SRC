package com.alibaba.security.realidentity.build;

import com.google.android.material.datepicker.UtcDates;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: OSSFederationToken.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cm {

    /* renamed from: a, reason: collision with root package name */
    public String f3345a;

    /* renamed from: b, reason: collision with root package name */
    public String f3346b;

    /* renamed from: c, reason: collision with root package name */
    public String f3347c;

    /* renamed from: d, reason: collision with root package name */
    public long f3348d;

    public cm(String str, String str2, String str3, long j10) {
        this.f3345a = str;
        this.f3346b = str2;
        this.f3347c = str3;
        this.f3348d = j10;
    }

    private String a() {
        return this.f3345a;
    }

    private String b() {
        return this.f3346b;
    }

    private String c() {
        return this.f3347c;
    }

    private long d() {
        return this.f3348d;
    }

    public final String toString() {
        return "OSSFederationToken [tempAk=" + this.f3345a + ", tempSk=" + this.f3346b + ", securityToken=" + this.f3347c + ", expiration=" + this.f3348d + "]";
    }

    private void a(String str) {
        this.f3347c = str;
    }

    private void b(String str) {
        this.f3345a = str;
    }

    private void c(String str) {
        this.f3346b = str;
    }

    private void d(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
            this.f3348d = simpleDateFormat.parse(str).getTime() / 1000;
        } catch (ParseException e2) {
            if (cd.a()) {
                e2.printStackTrace();
            }
            this.f3348d = (cr.a() / 1000) + 30;
        }
    }

    private void a(long j10) {
        this.f3348d = j10;
    }

    public cm(String str, String str2, String str3, String str4) {
        this.f3345a = str;
        this.f3346b = str2;
        this.f3347c = str3;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
            this.f3348d = simpleDateFormat.parse(str4).getTime() / 1000;
        } catch (ParseException e2) {
            if (cd.a()) {
                e2.printStackTrace();
            }
            this.f3348d = (cr.a() / 1000) + 30;
        }
    }
}
