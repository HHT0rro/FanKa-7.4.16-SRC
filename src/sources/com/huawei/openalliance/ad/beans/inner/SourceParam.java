package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.inter.data.AdContentData;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SourceParam {
    private boolean checkDigest;
    private boolean cleanDisk;

    @d
    private AdContentData contentRecord;
    private long limit;

    @d
    private String loadFailReason;
    private String sha256;
    private int sptImgFormat;
    private String subDir;
    private String url;
    private boolean useDiskCache;

    public SourceParam() {
        this.limit = 53687091200L;
        this.sptImgFormat = 1;
        this.checkDigest = false;
        this.useDiskCache = false;
        this.cleanDisk = false;
    }

    public SourceParam(String str, int i10, String str2) {
        this.sptImgFormat = 1;
        this.checkDigest = false;
        this.useDiskCache = false;
        this.cleanDisk = false;
        this.url = str;
        this.limit = i10 * 1024;
        this.sha256 = str2;
    }

    public String B() {
        return this.url;
    }

    public boolean C() {
        return this.checkDigest;
    }

    public void Code(int i10) {
        this.limit = i10 * 1024;
    }

    public void Code(long j10) {
        this.limit = j10;
    }

    public void Code(AdContentData adContentData) {
        this.contentRecord = adContentData;
    }

    public void Code(String str) {
        this.subDir = str;
    }

    public void Code(boolean z10) {
        this.cleanDisk = z10;
    }

    public boolean Code() {
        return this.cleanDisk;
    }

    public String D() {
        return this.loadFailReason;
    }

    public AdContentData F() {
        return this.contentRecord;
    }

    public String I() {
        return this.sha256;
    }

    public void I(String str) {
        this.url = str;
    }

    public void I(boolean z10) {
        this.useDiskCache = z10;
    }

    public int L() {
        return this.sptImgFormat;
    }

    public boolean S() {
        return this.useDiskCache;
    }

    public String V() {
        return this.subDir;
    }

    public void V(int i10) {
        this.sptImgFormat = i10;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    public void V(boolean z10) {
        this.checkDigest = z10;
    }

    public long Z() {
        return this.limit;
    }

    public void Z(String str) {
        this.loadFailReason = str;
    }
}
