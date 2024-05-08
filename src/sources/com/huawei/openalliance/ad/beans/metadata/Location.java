package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.utils.ag;

@DataKeep
@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Location {
    private int clctSource;
    private Long clctTime;
    private Integer lastfix;

    @c(Code = "lat")
    @com.huawei.openalliance.ad.annotations.a
    private Double latitude;

    @d
    private com.huawei.openalliance.ad.beans.inner.b locationSwitches;

    @c(Code = "lon")
    @com.huawei.openalliance.ad.annotations.a
    private Double longitude;

    public Location() {
    }

    @com.huawei.openalliance.ad.annotations.b
    public Location(Double d10, Double d11) {
        Code(d10);
        V(d11);
    }

    public Integer B() {
        return this.lastfix;
    }

    public int C() {
        return this.clctSource;
    }

    public Location Code() {
        Location location = new Location();
        location.longitude = this.longitude;
        location.latitude = this.latitude;
        location.lastfix = this.lastfix;
        location.clctTime = this.clctTime;
        location.clctSource = this.clctSource;
        return location;
    }

    public void Code(int i10) {
        this.clctSource = i10;
    }

    public void Code(com.huawei.openalliance.ad.beans.inner.b bVar) {
        this.locationSwitches = bVar;
    }

    public void Code(Double d10) {
        this.longitude = ag.Code(d10, 4, 4);
    }

    public void Code(Integer num) {
        this.lastfix = num;
    }

    public void Code(Long l10) {
        this.clctTime = l10;
    }

    public Double I() {
        return this.latitude;
    }

    public com.huawei.openalliance.ad.beans.inner.b S() {
        return this.locationSwitches;
    }

    public Double V() {
        return this.longitude;
    }

    public void V(Double d10) {
        this.latitude = ag.Code(d10, 4, 4);
    }

    public Long Z() {
        return this.clctTime;
    }
}
