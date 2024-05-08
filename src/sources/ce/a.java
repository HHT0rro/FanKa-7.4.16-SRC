package ce;

import kotlin.collections.q;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Progressions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements Iterable<Character>, zd.a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final C0028a f1594e = new C0028a(null);

    /* renamed from: b, reason: collision with root package name */
    public final char f1595b;

    /* renamed from: c, reason: collision with root package name */
    public final char f1596c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1597d;

    /* compiled from: Progressions.kt */
    /* renamed from: ce.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0028a {
        public C0028a() {
        }

        public /* synthetic */ C0028a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(char c4, char c10, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1595b = c4;
            this.f1596c = (char) ud.c.c(c4, c10, i10);
            this.f1597d = i10;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final char b() {
        return this.f1595b;
    }

    public final char c() {
        return this.f1596c;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public q iterator2() {
        return new b(this.f1595b, this.f1596c, this.f1597d);
    }
}
