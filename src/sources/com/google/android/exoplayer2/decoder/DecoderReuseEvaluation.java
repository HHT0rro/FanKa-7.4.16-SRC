package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.a;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DecoderReuseEvaluation {

    /* renamed from: a, reason: collision with root package name */
    public final String f19888a;

    /* renamed from: b, reason: collision with root package name */
    public final Format f19889b;

    /* renamed from: c, reason: collision with root package name */
    public final Format f19890c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19891d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19892e;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public @interface DecoderReuseResult {
    }

    public DecoderReuseEvaluation(String str, Format format, Format format2, int i10, int i11) {
        a.a(i10 == 0 || i11 == 0);
        this.f19888a = a.d(str);
        this.f19889b = (Format) a.e(format);
        this.f19890c = (Format) a.e(format2);
        this.f19891d = i10;
        this.f19892e = i11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DecoderReuseEvaluation.class != obj.getClass()) {
            return false;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
        return this.f19891d == decoderReuseEvaluation.f19891d && this.f19892e == decoderReuseEvaluation.f19892e && this.f19888a.equals(decoderReuseEvaluation.f19888a) && this.f19889b.equals(decoderReuseEvaluation.f19889b) && this.f19890c.equals(decoderReuseEvaluation.f19890c);
    }

    public int hashCode() {
        return ((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f19891d) * 31) + this.f19892e) * 31) + this.f19888a.hashCode()) * 31) + this.f19889b.hashCode()) * 31) + this.f19890c.hashCode();
    }
}
