package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ElecConsumeInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f8826a;

    /* renamed from: b, reason: collision with root package name */
    private int f8827b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f8828c;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f8829d = new ArrayList();

    public int getConsumeEnergy() {
        return this.f8826a;
    }

    public List<Integer> getLeftEnergy() {
        return this.f8829d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.f8828c;
    }

    public int getRunOutStepIndex() {
        return this.f8827b;
    }

    public void setConsumeEnergy(int i10) {
        this.f8826a = i10;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.f8829d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.f8828c = latLonPoint;
    }

    public void setRunOutStepIndex(int i10) {
        this.f8827b = i10;
    }
}
