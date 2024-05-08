package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaMetadata {
    public static final MediaMetadata E = new Builder().F();
    public static final g<MediaMetadata> F = a5.a.f700a;

    @Nullable
    public final Integer A;

    @Nullable
    public final CharSequence B;

    @Nullable
    public final CharSequence C;

    @Nullable
    public final Bundle D;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f19584a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final CharSequence f19585b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final CharSequence f19586c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final CharSequence f19587d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final CharSequence f19588e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final CharSequence f19589f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final CharSequence f19590g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final Uri f19591h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final byte[] f19592i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final Integer f19593j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final Uri f19594k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final Integer f19595l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final Integer f19596m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public final Integer f19597n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public final Boolean f19598o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    @Deprecated
    public final Integer f19599p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public final Integer f19600q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public final Integer f19601r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public final Integer f19602s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public final Integer f19603t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public final Integer f19604u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public final Integer f19605v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public final CharSequence f19606w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public final CharSequence f19607x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public final CharSequence f19608y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public final Integer f19609z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Builder {

        @Nullable
        public CharSequence A;

        @Nullable
        public CharSequence B;

        @Nullable
        public Bundle C;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f19610a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public CharSequence f19611b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public CharSequence f19612c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public CharSequence f19613d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public CharSequence f19614e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public CharSequence f19615f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public CharSequence f19616g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public Uri f19617h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public byte[] f19618i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public Integer f19619j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public Uri f19620k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        public Integer f19621l;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        public Integer f19622m;

        /* renamed from: n, reason: collision with root package name */
        @Nullable
        public Integer f19623n;

        /* renamed from: o, reason: collision with root package name */
        @Nullable
        public Boolean f19624o;

        /* renamed from: p, reason: collision with root package name */
        @Nullable
        public Integer f19625p;

        /* renamed from: q, reason: collision with root package name */
        @Nullable
        public Integer f19626q;

        /* renamed from: r, reason: collision with root package name */
        @Nullable
        public Integer f19627r;

        /* renamed from: s, reason: collision with root package name */
        @Nullable
        public Integer f19628s;

        /* renamed from: t, reason: collision with root package name */
        @Nullable
        public Integer f19629t;

        /* renamed from: u, reason: collision with root package name */
        @Nullable
        public Integer f19630u;

        /* renamed from: v, reason: collision with root package name */
        @Nullable
        public CharSequence f19631v;

        /* renamed from: w, reason: collision with root package name */
        @Nullable
        public CharSequence f19632w;

        /* renamed from: x, reason: collision with root package name */
        @Nullable
        public CharSequence f19633x;

        /* renamed from: y, reason: collision with root package name */
        @Nullable
        public Integer f19634y;

        /* renamed from: z, reason: collision with root package name */
        @Nullable
        public Integer f19635z;

        public static /* synthetic */ j1 E(Builder builder) {
            Objects.requireNonNull(builder);
            return null;
        }

        public static /* synthetic */ j1 b(Builder builder) {
            Objects.requireNonNull(builder);
            return null;
        }

        public MediaMetadata F() {
            return new MediaMetadata(this);
        }

        public Builder G(byte[] bArr, int i10) {
            if (this.f19618i == null || com.google.android.exoplayer2.util.j0.c(Integer.valueOf(i10), 3) || !com.google.android.exoplayer2.util.j0.c(this.f19619j, 3)) {
                this.f19618i = (byte[]) bArr.clone();
                this.f19619j = Integer.valueOf(i10);
            }
            return this;
        }

        public Builder H(Metadata metadata) {
            for (int i10 = 0; i10 < metadata.d(); i10++) {
                metadata.c(i10).populateMediaMetadata(this);
            }
            return this;
        }

        public Builder I(List<Metadata> list) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                Metadata metadata = list.get(i10);
                for (int i11 = 0; i11 < metadata.d(); i11++) {
                    metadata.c(i11).populateMediaMetadata(this);
                }
            }
            return this;
        }

        public Builder J(@Nullable CharSequence charSequence) {
            this.f19613d = charSequence;
            return this;
        }

        public Builder K(@Nullable CharSequence charSequence) {
            this.f19612c = charSequence;
            return this;
        }

        public Builder L(@Nullable CharSequence charSequence) {
            this.f19611b = charSequence;
            return this;
        }

        public Builder M(@Nullable CharSequence charSequence) {
            this.f19632w = charSequence;
            return this;
        }

        public Builder N(@Nullable CharSequence charSequence) {
            this.f19633x = charSequence;
            return this;
        }

        public Builder O(@Nullable CharSequence charSequence) {
            this.f19616g = charSequence;
            return this;
        }

        public Builder P(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.f19627r = num;
            return this;
        }

        public Builder Q(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.f19626q = num;
            return this;
        }

        public Builder R(@Nullable Integer num) {
            this.f19625p = num;
            return this;
        }

        public Builder S(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.f19630u = num;
            return this;
        }

        public Builder T(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.f19629t = num;
            return this;
        }

        public Builder U(@Nullable Integer num) {
            this.f19628s = num;
            return this;
        }

        public Builder V(@Nullable CharSequence charSequence) {
            this.f19610a = charSequence;
            return this;
        }

        public Builder W(@Nullable Integer num) {
            this.f19622m = num;
            return this;
        }

        public Builder X(@Nullable Integer num) {
            this.f19621l = num;
            return this;
        }

        public Builder Y(@Nullable CharSequence charSequence) {
            this.f19631v = charSequence;
            return this;
        }

        public Builder() {
        }

        public Builder(MediaMetadata mediaMetadata) {
            this.f19610a = mediaMetadata.f19584a;
            this.f19611b = mediaMetadata.f19585b;
            this.f19612c = mediaMetadata.f19586c;
            this.f19613d = mediaMetadata.f19587d;
            this.f19614e = mediaMetadata.f19588e;
            this.f19615f = mediaMetadata.f19589f;
            this.f19616g = mediaMetadata.f19590g;
            this.f19617h = mediaMetadata.f19591h;
            this.f19618i = mediaMetadata.f19592i;
            this.f19619j = mediaMetadata.f19593j;
            this.f19620k = mediaMetadata.f19594k;
            this.f19621l = mediaMetadata.f19595l;
            this.f19622m = mediaMetadata.f19596m;
            this.f19623n = mediaMetadata.f19597n;
            this.f19624o = mediaMetadata.f19598o;
            this.f19625p = mediaMetadata.f19600q;
            this.f19626q = mediaMetadata.f19601r;
            this.f19627r = mediaMetadata.f19602s;
            this.f19628s = mediaMetadata.f19603t;
            this.f19629t = mediaMetadata.f19604u;
            this.f19630u = mediaMetadata.f19605v;
            this.f19631v = mediaMetadata.f19606w;
            this.f19632w = mediaMetadata.f19607x;
            this.f19633x = mediaMetadata.f19608y;
            this.f19634y = mediaMetadata.f19609z;
            this.f19635z = mediaMetadata.A;
            this.A = mediaMetadata.B;
            this.B = mediaMetadata.C;
            this.C = mediaMetadata.D;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return com.google.android.exoplayer2.util.j0.c(this.f19584a, mediaMetadata.f19584a) && com.google.android.exoplayer2.util.j0.c(this.f19585b, mediaMetadata.f19585b) && com.google.android.exoplayer2.util.j0.c(this.f19586c, mediaMetadata.f19586c) && com.google.android.exoplayer2.util.j0.c(this.f19587d, mediaMetadata.f19587d) && com.google.android.exoplayer2.util.j0.c(this.f19588e, mediaMetadata.f19588e) && com.google.android.exoplayer2.util.j0.c(this.f19589f, mediaMetadata.f19589f) && com.google.android.exoplayer2.util.j0.c(this.f19590g, mediaMetadata.f19590g) && com.google.android.exoplayer2.util.j0.c(this.f19591h, mediaMetadata.f19591h) && com.google.android.exoplayer2.util.j0.c(null, null) && com.google.android.exoplayer2.util.j0.c(null, null) && Arrays.equals(this.f19592i, mediaMetadata.f19592i) && com.google.android.exoplayer2.util.j0.c(this.f19593j, mediaMetadata.f19593j) && com.google.android.exoplayer2.util.j0.c(this.f19594k, mediaMetadata.f19594k) && com.google.android.exoplayer2.util.j0.c(this.f19595l, mediaMetadata.f19595l) && com.google.android.exoplayer2.util.j0.c(this.f19596m, mediaMetadata.f19596m) && com.google.android.exoplayer2.util.j0.c(this.f19597n, mediaMetadata.f19597n) && com.google.android.exoplayer2.util.j0.c(this.f19598o, mediaMetadata.f19598o) && com.google.android.exoplayer2.util.j0.c(this.f19600q, mediaMetadata.f19600q) && com.google.android.exoplayer2.util.j0.c(this.f19601r, mediaMetadata.f19601r) && com.google.android.exoplayer2.util.j0.c(this.f19602s, mediaMetadata.f19602s) && com.google.android.exoplayer2.util.j0.c(this.f19603t, mediaMetadata.f19603t) && com.google.android.exoplayer2.util.j0.c(this.f19604u, mediaMetadata.f19604u) && com.google.android.exoplayer2.util.j0.c(this.f19605v, mediaMetadata.f19605v) && com.google.android.exoplayer2.util.j0.c(this.f19606w, mediaMetadata.f19606w) && com.google.android.exoplayer2.util.j0.c(this.f19607x, mediaMetadata.f19607x) && com.google.android.exoplayer2.util.j0.c(this.f19608y, mediaMetadata.f19608y) && com.google.android.exoplayer2.util.j0.c(this.f19609z, mediaMetadata.f19609z) && com.google.android.exoplayer2.util.j0.c(this.A, mediaMetadata.A) && com.google.android.exoplayer2.util.j0.c(this.B, mediaMetadata.B) && com.google.android.exoplayer2.util.j0.c(this.C, mediaMetadata.C);
    }

    public int hashCode() {
        return com.google.common.base.l.b(this.f19584a, this.f19585b, this.f19586c, this.f19587d, this.f19588e, this.f19589f, this.f19590g, this.f19591h, null, null, Integer.valueOf(Arrays.hashCode(this.f19592i)), this.f19593j, this.f19594k, this.f19595l, this.f19596m, this.f19597n, this.f19598o, this.f19600q, this.f19601r, this.f19602s, this.f19603t, this.f19604u, this.f19605v, this.f19606w, this.f19607x, this.f19608y, this.f19609z, this.A, this.B, this.C);
    }

    public MediaMetadata(Builder builder) {
        this.f19584a = builder.f19610a;
        this.f19585b = builder.f19611b;
        this.f19586c = builder.f19612c;
        this.f19587d = builder.f19613d;
        this.f19588e = builder.f19614e;
        this.f19589f = builder.f19615f;
        this.f19590g = builder.f19616g;
        this.f19591h = builder.f19617h;
        Builder.E(builder);
        Builder.b(builder);
        this.f19592i = builder.f19618i;
        this.f19593j = builder.f19619j;
        this.f19594k = builder.f19620k;
        this.f19595l = builder.f19621l;
        this.f19596m = builder.f19622m;
        this.f19597n = builder.f19623n;
        this.f19598o = builder.f19624o;
        this.f19599p = builder.f19625p;
        this.f19600q = builder.f19625p;
        this.f19601r = builder.f19626q;
        this.f19602s = builder.f19627r;
        this.f19603t = builder.f19628s;
        this.f19604u = builder.f19629t;
        this.f19605v = builder.f19630u;
        this.f19606w = builder.f19631v;
        this.f19607x = builder.f19632w;
        this.f19608y = builder.f19633x;
        this.f19609z = builder.f19634y;
        this.A = builder.f19635z;
        this.B = builder.A;
        this.C = builder.B;
        this.D = builder.C;
    }
}
