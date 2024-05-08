package com.jd.ad.sdk.jad_xg;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.mdt.service.JADEventService;

/* compiled from: JADEventServiceImplementor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_er implements JADEventService {
    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportClickEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, i20, i21, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportCloseEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExceptionEvent(@NonNull String str, int i10, @NonNull String str2) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, i10, str2);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExposureEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, int i15, int i16, int i17, int i18, String str3, int i19, int i20) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, i15, i16, i17, i18, JsonUtils.parse2JSONObject(str3), i19, i20, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadClickEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, i20, i21, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadCloseEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, long j12, int i15, int i16, int i17, int i18, int i19) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, j12, i15, i16, i17, i18, i19, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadExposureEvent(String str, String str2, int i10, int i11, int i12, int i13, int i14, long j10, long j11, int i15, int i16, int i17, int i18, String str3, int i19, int i20) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, i14, j10, j11, i15, i16, i17, i18, JsonUtils.parse2JSONObject(str3), i19, i20, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, long j11, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 1, j11, i14, i15, i16, i17, i18, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadResponseEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 0, 0L, i14, i15, i16, i17, i18, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderFailedEvent(@NonNull String str, int i10, @NonNull String str2, int i11) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, 10, i10, str2, i11);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, long j11, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 1, j11, i14, i15, i16, i17, i18, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRequestErrorEvent(@NonNull String str, int i10, @NonNull String str2) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, 7, i10, str2, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportResponseEvent(@NonNull String str, @NonNull String str2, int i10, int i11, int i12, int i13, long j10, int i14, int i15, int i16, int i17, int i18) {
        com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, str2, 1, i10, i11, i12, i13, j10, 0, 0L, i14, i15, i16, i17, i18, 0);
    }
}
