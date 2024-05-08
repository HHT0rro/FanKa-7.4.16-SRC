package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UByte.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g implements Comparable<g> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f50946c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final byte f50947b;

    /* compiled from: UByte.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ g(byte b4) {
        this.f50947b = b4;
    }

    public static final /* synthetic */ g a(byte b4) {
        return new g(b4);
    }

    public static byte b(byte b4) {
        return b4;
    }

    public static boolean c(byte b4, Object obj) {
        return (obj instanceof g) && b4 == ((g) obj).h();
    }

    public static int f(byte b4) {
        return b4;
    }

    @NotNull
    public static String g(byte b4) {
        return String.valueOf(b4 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(g gVar) {
        return s.k(h() & 255, gVar.h() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f50947b, obj);
    }

    public final /* synthetic */ byte h() {
        return this.f50947b;
    }

    public int hashCode() {
        return f(this.f50947b);
    }

    @NotNull
    public String toString() {
        return g(this.f50947b);
    }
}
