package com.amap.api.col.p0003l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DTDownloadInfo.java */
@hi(a = "update_item_download_info")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bj {

    /* renamed from: a, reason: collision with root package name */
    @hj(a = "mAdcode", b = 6)
    private String f5125a;

    /* renamed from: b, reason: collision with root package name */
    @hj(a = "fileLength", b = 5)
    private long f5126b;

    /* renamed from: c, reason: collision with root package name */
    @hj(a = "splitter", b = 2)
    private int f5127c;

    /* renamed from: d, reason: collision with root package name */
    @hj(a = "startPos", b = 5)
    private long f5128d;

    /* renamed from: e, reason: collision with root package name */
    @hj(a = "endPos", b = 5)
    private long f5129e;

    public bj() {
        this.f5125a = "";
        this.f5126b = 0L;
        this.f5127c = 0;
        this.f5128d = 0L;
        this.f5129e = 0L;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }

    public bj(String str, long j10, int i10, long j11, long j12) {
        this.f5125a = str;
        this.f5126b = j10;
        this.f5127c = i10;
        this.f5128d = j11;
        this.f5129e = j12;
    }
}
