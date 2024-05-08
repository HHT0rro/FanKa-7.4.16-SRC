package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UShort.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n implements Comparable<n> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f51044c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final short f51045b;

    /* compiled from: UShort.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ n(short s2) {
        this.f51045b = s2;
    }

    public static final /* synthetic */ n a(short s2) {
        return new n(s2);
    }

    public static short b(short s2) {
        return s2;
    }

    public static boolean c(short s2, Object obj) {
        return (obj instanceof n) && s2 == ((n) obj).h();
    }

    public static int f(short s2) {
        return s2;
    }

    @NotNull
    public static String g(short s2) {
        return String.valueOf(s2 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(n nVar) {
        return s.k(h() & 65535, nVar.h() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f51045b, obj);
    }

    public final /* synthetic */ short h() {
        return this.f51045b;
    }

    public int hashCode() {
        return f(this.f51045b);
    }

    @NotNull
    public String toString() {
        return g(this.f51045b);
    }
}
