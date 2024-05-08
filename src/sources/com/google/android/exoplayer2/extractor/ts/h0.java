package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* compiled from: TsPayloadReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface h0 {

    /* compiled from: TsPayloadReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f20462a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20463b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f20464c;

        public a(String str, int i10, byte[] bArr) {
            this.f20462a = str;
            this.f20463b = i10;
            this.f20464c = bArr;
        }
    }

    /* compiled from: TsPayloadReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f20465a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f20466b;

        /* renamed from: c, reason: collision with root package name */
        public final List<a> f20467c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f20468d;

        public b(int i10, @Nullable String str, @Nullable List<a> list, byte[] bArr) {
            List<a> unmodifiableList;
            this.f20465a = i10;
            this.f20466b = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.f20467c = unmodifiableList;
            this.f20468d = bArr;
        }
    }

    /* compiled from: TsPayloadReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        @Nullable
        h0 a(int i10, b bVar);

        SparseArray<h0> b();
    }

    /* compiled from: TsPayloadReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f20469a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20470b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20471c;

        /* renamed from: d, reason: collision with root package name */
        public int f20472d;

        /* renamed from: e, reason: collision with root package name */
        public String f20473e;

        public d(int i10, int i11) {
            this(Integer.MIN_VALUE, i10, i11);
        }

        public void a() {
            int i10 = this.f20472d;
            int i11 = i10 == Integer.MIN_VALUE ? this.f20470b : i10 + this.f20471c;
            this.f20472d = i11;
            String str = this.f20469a;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11);
            sb2.append(str);
            sb2.append(i11);
            this.f20473e = sb2.toString();
        }

        public String b() {
            d();
            return this.f20473e;
        }

        public int c() {
            d();
            return this.f20472d;
        }

        public final void d() {
            if (this.f20472d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public d(int i10, int i11, int i12) {
            String str;
            if (i10 != Integer.MIN_VALUE) {
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(i10);
                sb2.append("/");
                str = sb2.toString();
            } else {
                str = "";
            }
            this.f20469a = str;
            this.f20470b = i11;
            this.f20471c = i12;
            this.f20472d = Integer.MIN_VALUE;
            this.f20473e = "";
        }
    }

    void a();

    void b(com.google.android.exoplayer2.util.f0 f0Var, d5.e eVar, d dVar);

    void c(ParsableByteArray parsableByteArray, int i10) throws ParserException;
}
