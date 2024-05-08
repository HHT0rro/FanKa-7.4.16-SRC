package com.bytedance.sdk.openadsdk.api.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.model.DownloadShortInfo;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private DownloadShortInfo f11092m;

    public l(DownloadShortInfo downloadShortInfo) {
        this.f11092m = downloadShortInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        switch (i10) {
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS /* 223700 */:
                return (T) Boolean.valueOf(equals(valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS_PARAMETER, Object.class)));
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_HASH_CODE /* 223701 */:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public int dk() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    public long ej() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    public boolean equals(Object obj) {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    public boolean hc() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    public long l() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    public long m() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.f38402id;
        }
        return -1L;
    }

    public int n() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    public String np() {
        DownloadShortInfo downloadShortInfo = this.f11092m;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.b().g(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ID, m()).f(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_STATUS, dk()).g(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES, ej()).g(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES, l()).i(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME, np()).f(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FAIL_STATUS, n()).j(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ONLY_WIFI, hc()).a();
    }
}
