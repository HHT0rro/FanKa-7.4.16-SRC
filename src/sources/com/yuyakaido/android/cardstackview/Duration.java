package com.yuyakaido.android.cardstackview;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum Duration {
    Fast(100),
    Normal(200),
    Slow(500);

    public final int duration;

    Duration(int i10) {
        this.duration = i10;
    }

    public static Duration fromVelocity(int i10) {
        if (i10 < 1000) {
            return Slow;
        }
        if (i10 < 5000) {
            return Normal;
        }
        return Fast;
    }
}
