package com.alibaba.security.common.http.ok.internal.http2;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    public int get(int i10) {
        return this.values[i10];
    }

    public boolean getEnablePush(boolean z10) {
        return ((this.set & 4) != 0 ? this.values[2] : z10 ? 1 : 0) == 1;
    }

    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public int getMaxConcurrentStreams(int i10) {
        return (this.set & 16) != 0 ? this.values[4] : i10;
    }

    public int getMaxFrameSize(int i10) {
        return (this.set & 32) != 0 ? this.values[5] : i10;
    }

    public int getMaxHeaderListSize(int i10) {
        return (this.set & 64) != 0 ? this.values[6] : i10;
    }

    public boolean isSet(int i10) {
        return ((1 << i10) & this.set) != 0;
    }

    public void merge(Settings settings) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (settings.isSet(i10)) {
                set(i10, settings.get(i10));
            }
        }
    }

    public Settings set(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.values;
            if (i10 < iArr.length) {
                this.set = (1 << i10) | this.set;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public int size() {
        return Integer.bitCount(this.set);
    }
}
