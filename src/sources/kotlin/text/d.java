package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Strings.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d implements kotlin.sequences.g<IntRange> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final CharSequence f51105a;

    /* renamed from: b, reason: collision with root package name */
    public final int f51106b;

    /* renamed from: c, reason: collision with root package name */
    public final int f51107c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> f51108d;

    /* compiled from: Strings.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<IntRange>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        public int f51109b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f51110c;

        /* renamed from: d, reason: collision with root package name */
        public int f51111d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public IntRange f51112e;

        /* renamed from: f, reason: collision with root package name */
        public int f51113f;

        public a() {
            int f10 = ce.n.f(d.this.f51106b, 0, d.this.f51105a.length());
            this.f51110c = f10;
            this.f51111d = f10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f51114g.f51107c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r6 = this;
                int r0 = r6.f51111d
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f51109b = r1
                r0 = 0
                r6.f51112e = r0
                goto L9e
            Lc:
                kotlin.text.d r0 = kotlin.text.d.this
                int r0 = kotlin.text.d.d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f51113f
                int r0 = r0 + r3
                r6.f51113f = r0
                kotlin.text.d r4 = kotlin.text.d.this
                int r4 = kotlin.text.d.d(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f51111d
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f51110c
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.c(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.R(r4)
                r0.<init>(r1, r4)
                r6.f51112e = r0
                r6.f51111d = r2
                goto L9c
            L47:
                kotlin.text.d r0 = kotlin.text.d.this
                kotlin.jvm.functions.Function2 r0 = kotlin.text.d.b(r0)
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.c(r4)
                int r5 = r6.f51111d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.mo1743invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f51110c
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.c(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.R(r4)
                r0.<init>(r1, r4)
                r6.f51112e = r0
                r6.f51111d = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f51110c
                kotlin.ranges.IntRange r4 = ce.n.i(r4, r2)
                r6.f51112e = r4
                int r2 = r2 + r0
                r6.f51110c = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f51111d = r2
            L9c:
                r6.f51109b = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.d.a.a():void");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntRange next() {
            if (this.f51109b == -1) {
                a();
            }
            if (this.f51109b != 0) {
                IntRange intRange = this.f51112e;
                s.g(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f51112e = null;
                this.f51109b = -1;
                return intRange;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f51109b == -1) {
                a();
            }
            return this.f51109b == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull CharSequence input, int i10, int i11, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        s.i(input, "input");
        s.i(getNextMatch, "getNextMatch");
        this.f51105a = input;
        this.f51106b = i10;
        this.f51107c = i11;
        this.f51108d = getNextMatch;
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<IntRange> iterator() {
        return new a();
    }
}
