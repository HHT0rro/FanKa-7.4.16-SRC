package com.yuyakaido.android.cardstackview;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum SwipeableMethod {
    AutomaticAndManual,
    Automatic,
    Manual,
    None;

    public boolean canSwipe() {
        return canSwipeAutomatically() || canSwipeManually();
    }

    public boolean canSwipeAutomatically() {
        return this == AutomaticAndManual || this == Automatic;
    }

    public boolean canSwipeManually() {
        return this == AutomaticAndManual || this == Manual;
    }
}
