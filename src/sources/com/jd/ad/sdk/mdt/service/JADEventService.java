package com.jd.ad.sdk.mdt.service;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface JADEventService {
    void reportClickEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19, int i20, int i21);

    void reportCloseEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19);

    void reportExceptionEvent(@NonNull String str, int i10, @NonNull String str2);

    void reportExposureEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, int i15, int i16, int i17, int i18, String str3, int i19, int i20);

    void reportPreloadClickEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19, int i20, int i21);

    void reportPreloadCloseEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19);

    void reportPreloadExposureEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, int i15, int i16, int i17, int i18, String str3, int i19, int i20);

    void reportPreloadRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, long j11, int i14, int i15, int i16, int i17, int i18);

    void reportPreloadResponseEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, int i14, int i15, int i16, int i17, int i18);

    void reportRenderFailedEvent(@NonNull String str, int i10, @NonNull String str2, int i11);

    void reportRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, long j11, int i14, int i15, int i16, int i17, int i18);

    void reportRequestErrorEvent(@NonNull String str, int i10, @NonNull String str2);

    void reportResponseEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, int i14, int i15, int i16, int i17, int i18);
}
