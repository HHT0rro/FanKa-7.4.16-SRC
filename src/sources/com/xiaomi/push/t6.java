package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class t6 {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f48372a;

    /* renamed from: b, reason: collision with root package name */
    public final b7 f48373b;

    /* renamed from: c, reason: collision with root package name */
    public x6 f48374c;

    public t6(jo joVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f48372a = byteArrayOutputStream;
        b7 b7Var = new b7(byteArrayOutputStream);
        this.f48373b = b7Var;
        this.f48374c = joVar.a(b7Var);
    }

    public byte[] a(jb jbVar) {
        this.f48372a.reset();
        jbVar.b(this.f48374c);
        return this.f48372a.toByteArray();
    }
}
