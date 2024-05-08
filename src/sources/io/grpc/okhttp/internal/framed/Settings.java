package io.grpc.okhttp.internal.framed;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Settings {
    public static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    public static final int COUNT = 10;
    public static final int CURRENT_CWND = 5;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    public static final int DOWNLOAD_BANDWIDTH = 2;
    public static final int DOWNLOAD_RETRANS_RATE = 6;
    public static final int ENABLE_PUSH = 2;
    public static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    public static final int FLOW_CONTROL_OPTIONS = 10;
    public static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    public static final int PERSISTED = 2;
    public static final int PERSIST_VALUE = 1;
    public static final int ROUND_TRIP_TIME = 3;
    public static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    public void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    public int flags(int i10) {
        int i11 = isPersisted(i10) ? 2 : 0;
        return persistValue(i10) ? i11 | 1 : i11;
    }

    public int get(int i10) {
        return this.values[i10];
    }

    public int getClientCertificateVectorSize(int i10) {
        return (this.set & 256) != 0 ? this.values[8] : i10;
    }

    public int getCurrentCwnd(int i10) {
        return (this.set & 32) != 0 ? this.values[5] : i10;
    }

    public int getDownloadBandwidth(int i10) {
        return (this.set & 4) != 0 ? this.values[2] : i10;
    }

    public int getDownloadRetransRate(int i10) {
        return (this.set & 64) != 0 ? this.values[6] : i10;
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

    public int getInitialWindowSize(int i10) {
        return (this.set & 128) != 0 ? this.values[7] : i10;
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

    public int getRoundTripTime(int i10) {
        return (this.set & 8) != 0 ? this.values[3] : i10;
    }

    public int getUploadBandwidth(int i10) {
        return (this.set & 2) != 0 ? this.values[1] : i10;
    }

    public boolean isFlowControlDisabled() {
        return (((this.set & 1024) != 0 ? this.values[10] : 0) & 1) != 0;
    }

    public boolean isPersisted(int i10) {
        return ((1 << i10) & this.persisted) != 0;
    }

    public boolean isSet(int i10) {
        return ((1 << i10) & this.set) != 0;
    }

    public void merge(Settings settings) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (settings.isSet(i10)) {
                set(i10, settings.flags(i10), settings.get(i10));
            }
        }
    }

    public boolean persistValue(int i10) {
        return ((1 << i10) & this.persistValue) != 0;
    }

    public Settings set(int i10, int i11, int i12) {
        int[] iArr = this.values;
        if (i10 >= iArr.length) {
            return this;
        }
        int i13 = 1 << i10;
        this.set |= i13;
        if ((i11 & 1) != 0) {
            this.persistValue |= i13;
        } else {
            this.persistValue &= ~i13;
        }
        if ((i11 & 2) != 0) {
            this.persisted |= i13;
        } else {
            this.persisted &= ~i13;
        }
        iArr[i10] = i12;
        return this;
    }

    public int size() {
        return Integer.bitCount(this.set);
    }
}
