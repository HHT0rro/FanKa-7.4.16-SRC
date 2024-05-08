package com.alimm.tanx.core.constant;

import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxAdType implements NotConfused {
    public static final int FEED = 2;
    public static final String FEED_STRING = "flow";
    public static final int REWARD = 4;
    public static final String REWARD_STRING = "reward";
    public static final int REWARD_VIDEO = 3;
    public static final String REWARD_VIDEO_STRING = "rewardVideo";
    public static final int SPLASH = 1;
    public static final String SPLASH_STRING = "screen";
    public static final int TABLE_SCREEN = 5;
    public static final String TABLE_SCREEN_STRING = "tableScreen";

    public static String getAdTypeStr(int i10) {
        if (i10 == 1) {
            return SPLASH_STRING;
        }
        if (i10 == 2) {
            return FEED_STRING;
        }
        if (i10 == 3) {
            return REWARD_VIDEO_STRING;
        }
        if (i10 == 4) {
            return REWARD_STRING;
        }
        if (i10 != 5) {
            return null;
        }
        return TABLE_SCREEN_STRING;
    }
}
