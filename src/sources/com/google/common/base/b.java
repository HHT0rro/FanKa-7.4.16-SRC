package com.google.common.base;

import org.apache.commons.io.IOUtils;

/* compiled from: CharMatcher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b implements p<Character> {

    /* compiled from: CharMatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a extends e {

        /* renamed from: c, reason: collision with root package name */
        public static final a f25951c = new a();

        public a() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c4) {
            return c4 <= 127;
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class AbstractC0223b extends b {
        @Override // com.google.common.base.p
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class c extends AbstractC0223b {

        /* renamed from: b, reason: collision with root package name */
        public final char f25952b;

        /* renamed from: c, reason: collision with root package name */
        public final char f25953c;

        public c(char c4, char c10) {
            o.d(c10 >= c4);
            this.f25952b = c4;
            this.f25953c = c10;
        }

        @Override // com.google.common.base.b
        public boolean g(char c4) {
            return this.f25952b <= c4 && c4 <= this.f25953c;
        }

        public String toString() {
            String j10 = b.j(this.f25952b);
            String j11 = b.j(this.f25953c);
            StringBuilder sb2 = new StringBuilder(String.valueOf(j10).length() + 27 + String.valueOf(j11).length());
            sb2.append("CharMatcher.inRange('");
            sb2.append(j10);
            sb2.append("', '");
            sb2.append(j11);
            sb2.append("')");
            return sb2.toString();
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d extends AbstractC0223b {

        /* renamed from: b, reason: collision with root package name */
        public final char f25954b;

        public d(char c4) {
            this.f25954b = c4;
        }

        @Override // com.google.common.base.b
        public boolean g(char c4) {
            return c4 == this.f25954b;
        }

        public String toString() {
            String j10 = b.j(this.f25954b);
            StringBuilder sb2 = new StringBuilder(String.valueOf(j10).length() + 18);
            sb2.append("CharMatcher.is('");
            sb2.append(j10);
            sb2.append("')");
            return sb2.toString();
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class e extends AbstractC0223b {

        /* renamed from: b, reason: collision with root package name */
        public final String f25955b;

        public e(String str) {
            this.f25955b = (String) o.r(str);
        }

        public final String toString() {
            return this.f25955b;
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class f extends e {

        /* renamed from: c, reason: collision with root package name */
        public static final f f25956c = new f();

        public f() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.b
        public int e(CharSequence charSequence, int i10) {
            o.u(i10, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.b
        public boolean g(char c4) {
            return false;
        }

        @Override // com.google.common.base.b
        public boolean h(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class g extends e {

        /* renamed from: c, reason: collision with root package name */
        public static final int f25957c = Integer.numberOfLeadingZeros(31);

        /* renamed from: d, reason: collision with root package name */
        public static final g f25958d = new g();

        public g() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c4) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c4) >>> f25957c) == c4;
        }
    }

    public static b c() {
        return a.f25951c;
    }

    public static b d(char c4, char c10) {
        return new c(c4, c10);
    }

    public static b f(char c4) {
        return new d(c4);
    }

    public static b i() {
        return f.f25956c;
    }

    public static String j(char c4) {
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c4 & 15);
            c4 = (char) (c4 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static b k() {
        return g.f25958d;
    }

    @Deprecated
    public boolean b(Character ch) {
        return g(ch.charValue());
    }

    public int e(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        o.u(i10, length);
        while (i10 < length) {
            if (g(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public abstract boolean g(char c4);

    public boolean h(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!g(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
