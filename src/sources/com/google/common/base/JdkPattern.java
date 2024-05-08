package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class JdkPattern extends e implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public final Matcher f25945a;

        public a(Matcher matcher) {
            this.f25945a = (Matcher) o.r(matcher);
        }

        @Override // com.google.common.base.d
        public boolean a() {
            return this.f25945a.find();
        }
    }

    public JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) o.r(pattern);
    }

    @Override // com.google.common.base.e
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.e
    public d matcher(CharSequence charSequence) {
        return new a(this.pattern.matcher(charSequence));
    }

    @Override // com.google.common.base.e
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.e
    public String toString() {
        return this.pattern.toString();
    }
}
