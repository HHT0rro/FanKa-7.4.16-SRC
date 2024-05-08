package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AgHmsUpdateState {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f31907c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static volatile AgHmsUpdateState f31908d;

    /* renamed from: a, reason: collision with root package name */
    private HmsCheckedState f31909a = HmsCheckedState.UNCHECKED;

    /* renamed from: b, reason: collision with root package name */
    private int f31910b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f31908d == null) {
            synchronized (f31907c) {
                if (f31908d == null) {
                    f31908d = new AgHmsUpdateState();
                }
            }
        }
        return f31908d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f31909a;
    }

    public int getTargetVersionCode() {
        return this.f31910b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f31910b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() != HmsCheckedState.NEED_UPDATE) {
            return;
        }
        setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        setTargetVersionCode(0);
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f31909a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i10) {
        this.f31910b = i10;
    }
}
