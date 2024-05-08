package com.nirvana.tools.logger.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMLoggerRecord extends ACMRecord {
    public static final int LOG_LEVEL_CRASH = 6;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_REALTIME = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 4;
    private int level = 2;

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i10) {
        this.level = i10;
    }
}
