package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ExoPlaybackException extends PlaybackException {
    public static final g<ExoPlaybackException> CREATOR = a5.a.f700a;
    private static final int FIELD_IS_RECOVERABLE = 1006;
    private static final int FIELD_RENDERER_FORMAT = 1004;
    private static final int FIELD_RENDERER_FORMAT_SUPPORT = 1005;
    private static final int FIELD_RENDERER_INDEX = 1003;
    private static final int FIELD_RENDERER_NAME = 1002;
    private static final int FIELD_TYPE = 1001;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    public final boolean isRecoverable;

    @Nullable
    public final com.google.android.exoplayer2.source.q mediaPeriodId;

    @Nullable
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;

    @Nullable
    public final String rendererName;
    public final int type;

    private ExoPlaybackException(int i10, Throwable th, int i11) {
        this(i10, th, null, i11, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, null, str, 1001, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th, String str, int i10, @Nullable Format format, int i11, boolean z10, int i12) {
        return new ExoPlaybackException(1, th, null, i12, str, i10, format, format == null ? 4 : i11, z10);
    }

    public static ExoPlaybackException createForSource(IOException iOException, int i10) {
        return new ExoPlaybackException(0, iOException, i10);
    }

    @Deprecated
    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return createForUnexpected(runtimeException, 1000);
    }

    private static String deriveMessage(int i10, @Nullable String str, @Nullable String str2, int i11, @Nullable Format format, int i12) {
        String str3;
        if (i10 == 0) {
            str3 = "Source error";
        } else if (i10 != 1) {
            str3 = i10 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            String valueOf = String.valueOf(format);
            String c4 = h.c(i12);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 53 + valueOf.length() + String.valueOf(c4).length());
            sb2.append(str2);
            sb2.append(" error, index=");
            sb2.append(i11);
            sb2.append(", format=");
            sb2.append(valueOf);
            sb2.append(", format_supported=");
            sb2.append(c4);
            str3 = sb2.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String valueOf2 = String.valueOf(str3);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 2 + String.valueOf(str).length());
        sb3.append(valueOf2);
        sb3.append(": ");
        sb3.append(str);
        return sb3.toString();
    }

    @CheckResult
    public ExoPlaybackException copyWithMediaPeriodId(@Nullable com.google.android.exoplayer2.source.q qVar) {
        return new ExoPlaybackException((String) com.google.android.exoplayer2.util.j0.j(getMessage()), getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, qVar, this.timestampMs, this.isRecoverable);
    }

    @Override // com.google.android.exoplayer2.PlaybackException
    public boolean errorInfoEquals(@Nullable PlaybackException playbackException) {
        if (!super.errorInfoEquals(playbackException)) {
            return false;
        }
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) com.google.android.exoplayer2.util.j0.j(playbackException);
        return this.type == exoPlaybackException.type && com.google.android.exoplayer2.util.j0.c(this.rendererName, exoPlaybackException.rendererName) && this.rendererIndex == exoPlaybackException.rendererIndex && com.google.android.exoplayer2.util.j0.c(this.rendererFormat, exoPlaybackException.rendererFormat) && this.rendererFormatSupport == exoPlaybackException.rendererFormatSupport && com.google.android.exoplayer2.util.j0.c(this.mediaPeriodId, exoPlaybackException.mediaPeriodId) && this.isRecoverable == exoPlaybackException.isRecoverable;
    }

    public Exception getRendererException() {
        com.google.android.exoplayer2.util.a.g(this.type == 1);
        return (Exception) com.google.android.exoplayer2.util.a.e(getCause());
    }

    public IOException getSourceException() {
        com.google.android.exoplayer2.util.a.g(this.type == 0);
        return (IOException) com.google.android.exoplayer2.util.a.e(getCause());
    }

    public RuntimeException getUnexpectedException() {
        com.google.android.exoplayer2.util.a.g(this.type == 2);
        return (RuntimeException) com.google.android.exoplayer2.util.a.e(getCause());
    }

    @Override // com.google.android.exoplayer2.PlaybackException
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(PlaybackException.keyForField(1001), this.type);
        bundle.putString(PlaybackException.keyForField(1002), this.rendererName);
        bundle.putInt(PlaybackException.keyForField(1003), this.rendererIndex);
        bundle.putParcelable(PlaybackException.keyForField(1004), this.rendererFormat);
        bundle.putInt(PlaybackException.keyForField(1005), this.rendererFormatSupport);
        bundle.putBoolean(PlaybackException.keyForField(1006), this.isRecoverable);
        return bundle;
    }

    private ExoPlaybackException(int i10, @Nullable Throwable th, @Nullable String str, int i11, @Nullable String str2, int i12, @Nullable Format format, int i13, boolean z10) {
        this(deriveMessage(i10, str, str2, i12, format, i13), th, i11, i10, str2, i12, format, i13, null, SystemClock.elapsedRealtime(), z10);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException, int i10) {
        return new ExoPlaybackException(2, runtimeException, i10);
    }

    private ExoPlaybackException(Bundle bundle) {
        super(bundle);
        this.type = bundle.getInt(PlaybackException.keyForField(1001), 2);
        this.rendererName = bundle.getString(PlaybackException.keyForField(1002));
        this.rendererIndex = bundle.getInt(PlaybackException.keyForField(1003), -1);
        this.rendererFormat = (Format) bundle.getParcelable(PlaybackException.keyForField(1004));
        this.rendererFormatSupport = bundle.getInt(PlaybackException.keyForField(1005), 4);
        this.isRecoverable = bundle.getBoolean(PlaybackException.keyForField(1006), false);
        this.mediaPeriodId = null;
    }

    private ExoPlaybackException(String str, @Nullable Throwable th, int i10, int i11, @Nullable String str2, int i12, @Nullable Format format, int i13, @Nullable com.google.android.exoplayer2.source.q qVar, long j10, boolean z10) {
        super(str, th, i10, j10);
        com.google.android.exoplayer2.util.a.a(!z10 || i11 == 1);
        com.google.android.exoplayer2.util.a.a(th != null || i11 == 3);
        this.type = i11;
        this.rendererName = str2;
        this.rendererIndex = i12;
        this.rendererFormat = format;
        this.rendererFormatSupport = i13;
        this.mediaPeriodId = qVar;
        this.isRecoverable = z10;
    }
}
