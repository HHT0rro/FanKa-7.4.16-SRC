package com.huawei.openalliance.ad.download;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DownloadTask {
    private boolean allowedMobileNetowrk;
    private long downloadedSize;
    private long fileTotalSize;
    private int pauseReason;
    private int priority;
    private int progress;
    private String sha256;
    private String url;

    @com.huawei.openalliance.ad.annotations.d
    private final byte[] lock = new byte[0];

    @com.huawei.openalliance.ad.annotations.d
    private int status = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        public static final int Code = 0;
        public static final int I = 2;
        public static final int V = 1;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int B() {
        int i10;
        synchronized (this.lock) {
            i10 = this.status;
        }
        return i10;
    }

    public int C() {
        return this.priority;
    }

    public String Code() {
        return this.url;
    }

    public void Code(int i10) {
        synchronized (this.lock) {
            this.status = i10;
        }
    }

    public void Code(long j10) {
        this.fileTotalSize = j10;
    }

    public void Code(String str) {
        this.url = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(boolean z10) {
        this.allowedMobileNetowrk = z10;
    }

    public int D() {
        return this.pauseReason;
    }

    public String F() {
        return Code();
    }

    public long I() {
        return this.fileTotalSize;
    }

    public void I(int i10) {
        this.progress = i10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int S() {
        return this.progress;
    }

    public String V() {
        return this.sha256;
    }

    public void V(int i10) {
        this.priority = i10;
    }

    public void V(long j10) {
        this.downloadedSize = j10;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public long Z() {
        return this.downloadedSize;
    }

    public void Z(int i10) {
        this.pauseReason = i10;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof DownloadTask) && TextUtils.equals(F(), ((DownloadTask) obj).F())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return F() != null ? F().hashCode() : super.hashCode();
    }
}
