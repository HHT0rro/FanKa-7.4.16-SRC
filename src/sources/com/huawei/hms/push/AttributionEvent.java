package com.huawei.hms.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum AttributionEvent {
    APP_START_COMPLETE(1),
    OPEN_PRIVACY_PAGE(2),
    REJECT_PRIVACY(3),
    AGREED_PRIVACY(4),
    PERMISSION_GRANTED(5),
    PERMISSION_DENIED(6),
    OPEN_LANDING_PAGE(7);


    /* renamed from: a, reason: collision with root package name */
    private final int f30348a;

    AttributionEvent(int i10) {
        this.f30348a = i10;
    }

    public int getEventId() {
        return this.f30348a;
    }
}
