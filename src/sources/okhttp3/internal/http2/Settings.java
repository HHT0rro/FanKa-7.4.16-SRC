package okhttp3.internal.http2;

import kotlin.collections.l;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Settings.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* compiled from: Settings.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        l.m(this.values, 0, 0, 0, 6, null);
    }

    public final int get(int i10) {
        return this.values[i10];
    }

    public final boolean getEnablePush(boolean z10) {
        return (this.set & 4) != 0 ? this.values[2] == 1 : z10;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int i10) {
        return (this.set & 32) != 0 ? this.values[5] : i10;
    }

    public final int getMaxHeaderListSize(int i10) {
        return (this.set & 64) != 0 ? this.values[6] : i10;
    }

    public final boolean isSet(int i10) {
        return ((1 << i10) & this.set) != 0;
    }

    public final void merge(@NotNull Settings other) {
        s.i(other, "other");
        for (int i10 = 0; i10 < 10; i10++) {
            if (other.isSet(i10)) {
                set(i10, other.get(i10));
            }
        }
    }

    @NotNull
    public final Settings set(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.values;
            if (i10 < iArr.length) {
                this.set = (1 << i10) | this.set;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
