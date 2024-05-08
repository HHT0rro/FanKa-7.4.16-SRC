package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Atom.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f20127a;

    /* compiled from: Atom.java */
    /* renamed from: com.google.android.exoplayer2.extractor.mp4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0188a extends a {

        /* renamed from: b, reason: collision with root package name */
        public final long f20128b;

        /* renamed from: c, reason: collision with root package name */
        public final List<b> f20129c;

        /* renamed from: d, reason: collision with root package name */
        public final List<C0188a> f20130d;

        public C0188a(int i10, long j10) {
            super(i10);
            this.f20128b = j10;
            this.f20129c = new ArrayList();
            this.f20130d = new ArrayList();
        }

        public void d(C0188a c0188a) {
            this.f20130d.add(c0188a);
        }

        public void e(b bVar) {
            this.f20129c.add(bVar);
        }

        @Nullable
        public C0188a f(int i10) {
            int size = this.f20130d.size();
            for (int i11 = 0; i11 < size; i11++) {
                C0188a c0188a = this.f20130d.get(i11);
                if (c0188a.f20127a == i10) {
                    return c0188a;
                }
            }
            return null;
        }

        @Nullable
        public b g(int i10) {
            int size = this.f20129c.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = this.f20129c.get(i11);
                if (bVar.f20127a == i10) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.a
        public String toString() {
            String a10 = a.a(this.f20127a);
            String arrays = Arrays.toString(this.f20129c.toArray());
            String arrays2 = Arrays.toString(this.f20130d.toArray());
            StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
            sb2.append(a10);
            sb2.append(" leaves: ");
            sb2.append(arrays);
            sb2.append(" containers: ");
            sb2.append(arrays2);
            return sb2.toString();
        }
    }

    /* compiled from: Atom.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f20131b;

        public b(int i10, ParsableByteArray parsableByteArray) {
            super(i10);
            this.f20131b = parsableByteArray;
        }
    }

    public a(int i10) {
        this.f20127a = i10;
    }

    public static String a(int i10) {
        StringBuilder sb2 = new StringBuilder(4);
        sb2.append((char) ((i10 >> 24) & 255));
        sb2.append((char) ((i10 >> 16) & 255));
        sb2.append((char) ((i10 >> 8) & 255));
        sb2.append((char) (i10 & 255));
        return sb2.toString();
    }

    public static int b(int i10) {
        return i10 & 16777215;
    }

    public static int c(int i10) {
        return (i10 >> 24) & 255;
    }

    public String toString() {
        return a(this.f20127a);
    }
}
