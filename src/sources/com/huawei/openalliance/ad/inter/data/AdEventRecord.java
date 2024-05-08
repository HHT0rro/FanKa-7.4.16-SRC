package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdEventRecord {

    /* renamed from: ad, reason: collision with root package name */
    private d f32444ad;
    private long endTime;
    private Long eventTime;
    private String eventType;
    private long startTime;

    @com.huawei.openalliance.ad.annotations.b
    public AdEventRecord() {
    }

    @com.huawei.openalliance.ad.annotations.b
    public AdEventRecord(c cVar, long j10, long j11, String str, Long l10) {
        this.f32444ad = cVar;
        this.startTime = j10;
        this.endTime = j11;
        this.eventType = str;
        this.eventTime = l10;
    }

    public Long B() {
        return this.eventTime;
    }

    public d Code() {
        return this.f32444ad;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(long j10) {
        this.startTime = j10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(d dVar) {
        this.f32444ad = dVar;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(Long l10) {
        this.eventTime = l10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(String str) {
        this.eventType = str;
    }

    public long I() {
        return this.endTime;
    }

    public long V() {
        return this.startTime;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(long j10) {
        this.endTime = j10;
    }

    public String Z() {
        return this.eventType;
    }
}
