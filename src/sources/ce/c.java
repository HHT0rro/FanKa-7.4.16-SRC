package ce;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c extends ce.a implements g<Character> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f1602f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final c f1603g = new c(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(char c4, char c10) {
        super(c4, c10, 1);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (b() != cVar.b() || c() != cVar.c()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // ce.g
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Character getEndInclusive() {
        return Character.valueOf(c());
    }

    @Override // ce.g
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Character getStart() {
        return Character.valueOf(b());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + c();
    }

    public boolean isEmpty() {
        return s.k(b(), c()) > 0;
    }

    @NotNull
    public String toString() {
        return b() + ".." + c();
    }
}
