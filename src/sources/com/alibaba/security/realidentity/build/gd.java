package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.util.Map;

/* compiled from: PutObjectRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gd extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3719a;

    /* renamed from: b, reason: collision with root package name */
    public String f3720b;

    /* renamed from: c, reason: collision with root package name */
    public String f3721c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f3722d;

    /* renamed from: e, reason: collision with root package name */
    public fu f3723e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f3724f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f3725g;

    /* renamed from: h, reason: collision with root package name */
    public by<gd> f3726h;

    /* renamed from: i, reason: collision with root package name */
    public bz f3727i;

    public gd(String str, String str2, String str3) {
        this(str, str2, str3, (byte) 0);
    }

    private String a() {
        return this.f3719a;
    }

    private String b() {
        return this.f3720b;
    }

    private String c() {
        return this.f3721c;
    }

    private byte[] d() {
        return this.f3722d;
    }

    private fu e() {
        return this.f3723e;
    }

    private by<gd> f() {
        return this.f3726h;
    }

    private bz g() {
        return this.f3727i;
    }

    private Map<String, String> h() {
        return this.f3724f;
    }

    private Map<String, String> i() {
        return this.f3725g;
    }

    private gd(String str, String str2, String str3, byte b4) {
        this.f3719a = str;
        this.f3720b = str2;
        this.f3721c = str3;
        this.f3723e = null;
    }

    private void a(String str) {
        this.f3719a = str;
    }

    private void b(String str) {
        this.f3720b = str;
    }

    private void c(String str) {
        this.f3721c = str;
    }

    private void a(byte[] bArr) {
        this.f3722d = bArr;
    }

    private void b(Map<String, String> map) {
        this.f3725g = map;
    }

    private void a(fu fuVar) {
        this.f3723e = fuVar;
    }

    private void a(by<gd> byVar) {
        this.f3726h = byVar;
    }

    private void a(bz bzVar) {
        this.f3727i = bzVar;
    }

    private gd(String str, String str2, byte[] bArr) {
        this(str, str2, bArr, (byte) 0);
    }

    private void a(Map<String, String> map) {
        this.f3724f = map;
    }

    private gd(String str, String str2, byte[] bArr, byte b4) {
        this.f3719a = str;
        this.f3720b = str2;
        this.f3722d = bArr;
        this.f3723e = null;
    }
}
