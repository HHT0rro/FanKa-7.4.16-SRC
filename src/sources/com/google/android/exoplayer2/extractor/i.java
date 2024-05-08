package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import d5.o;

/* compiled from: SeekMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface i {

    /* compiled from: SeekMap.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final o f20077a;

        /* renamed from: b, reason: collision with root package name */
        public final o f20078b;

        public a(o oVar) {
            this(oVar, oVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f20077a.equals(aVar.f20077a) && this.f20078b.equals(aVar.f20078b);
        }

        public int hashCode() {
            return (this.f20077a.hashCode() * 31) + this.f20078b.hashCode();
        }

        public String toString() {
            String sb2;
            String valueOf = String.valueOf(this.f20077a);
            if (this.f20077a.equals(this.f20078b)) {
                sb2 = "";
            } else {
                String valueOf2 = String.valueOf(this.f20078b);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 2);
                sb3.append(", ");
                sb3.append(valueOf2);
                sb2 = sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder(valueOf.length() + 2 + String.valueOf(sb2).length());
            sb4.append("[");
            sb4.append(valueOf);
            sb4.append(sb2);
            sb4.append("]");
            return sb4.toString();
        }

        public a(o oVar, o oVar2) {
            this.f20077a = (o) com.google.android.exoplayer2.util.a.e(oVar);
            this.f20078b = (o) com.google.android.exoplayer2.util.a.e(oVar2);
        }
    }

    /* compiled from: SeekMap.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b implements i {

        /* renamed from: a, reason: collision with root package name */
        public final long f20079a;

        /* renamed from: b, reason: collision with root package name */
        public final a f20080b;

        public b(long j10) {
            this(j10, 0L);
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public a d(long j10) {
            return this.f20080b;
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public boolean e() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public long i() {
            return this.f20079a;
        }

        public b(long j10, long j11) {
            this.f20079a = j10;
            this.f20080b = new a(j11 == 0 ? o.f48643c : new o(0L, j11));
        }
    }

    a d(long j10);

    boolean e();

    long i();
}
