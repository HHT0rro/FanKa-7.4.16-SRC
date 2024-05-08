package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: ULong.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k implements Comparable<k> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f51039c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final long f51040b;

    /* compiled from: ULong.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ k(long j10) {
        this.f51040b = j10;
    }

    public static final /* synthetic */ k a(long j10) {
        return new k(j10);
    }

    public static long b(long j10) {
        return j10;
    }

    public static boolean c(long j10, Object obj) {
        return (obj instanceof k) && j10 == ((k) obj).h();
    }

    public static int f(long j10) {
        return b2.a.a(j10);
    }

    @NotNull
    public static String g(long j10) {
        return q.c(j10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(k kVar) {
        return q.b(h(), kVar.h());
    }

    public boolean equals(Object obj) {
        return c(this.f51040b, obj);
    }

    public final /* synthetic */ long h() {
        return this.f51040b;
    }

    public int hashCode() {
        return f(this.f51040b);
    }

    @NotNull
    public String toString() {
        return g(this.f51040b);
    }
}
