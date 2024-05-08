package com.amap.api.col.p0003l;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* compiled from: Table.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ld {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<CharsetDecoder> f6883b = new ThreadLocal<CharsetDecoder>() { // from class: com.amap.api.col.3l.ld.1
        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Charset> f6882a = new ThreadLocal<Charset>() { // from class: com.amap.api.col.3l.ld.2
        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ Charset initialValue() {
            return a();
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<CharBuffer> f6884c = new ThreadLocal<>();
}
