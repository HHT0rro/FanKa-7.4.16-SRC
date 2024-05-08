package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: UInt.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i implements Comparable<i> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f50950c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final int f50951b;

    /* compiled from: UInt.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ i(int i10) {
        this.f50951b = i10;
    }

    public static final /* synthetic */ i a(int i10) {
        return new i(i10);
    }

    public static int b(int i10) {
        return i10;
    }

    public static boolean c(int i10, Object obj) {
        return (obj instanceof i) && i10 == ((i) obj).h();
    }

    public static int f(int i10) {
        return i10;
    }

    @NotNull
    public static String g(int i10) {
        return String.valueOf(i10 & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(i iVar) {
        return q.a(h(), iVar.h());
    }

    public boolean equals(Object obj) {
        return c(this.f50951b, obj);
    }

    public final /* synthetic */ int h() {
        return this.f50951b;
    }

    public int hashCode() {
        return f(this.f50951b);
    }

    @NotNull
    public String toString() {
        return g(this.f50951b);
    }
}
