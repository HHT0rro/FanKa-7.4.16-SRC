package io.grpc.okhttp;

import com.baidu.mobads.sdk.internal.bs;
import com.google.common.base.o;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OkHttpFrameLogger {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final Level level;
    private final Logger logger;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum Direction {
        INBOUND,
        OUTBOUND
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum SettingParams {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);

        private final int bit;

        SettingParams(int i10) {
            this.bit = i10;
        }

        public int getBit() {
            return this.bit;
        }
    }

    public OkHttpFrameLogger(Level level, Class<?> cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    private boolean isEnabled() {
        return this.logger.isLoggable(this.level);
    }

    private static String toString(Settings settings) {
        EnumMap enumMap = new EnumMap(SettingParams.class);
        for (SettingParams settingParams : SettingParams.values()) {
            if (settings.isSet(settingParams.getBit())) {
                enumMap.put((EnumMap) settingParams, (SettingParams) Integer.valueOf(settings.get(settingParams.getBit())));
            }
        }
        return enumMap.toString();
    }

    public void logData(Direction direction, int i10, Buffer buffer, int i11, boolean z10) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " DATA: streamId=" + i10 + " endStream=" + z10 + " length=" + i11 + " bytes=" + toString(buffer));
        }
    }

    public void logGoAway(Direction direction, int i10, ErrorCode errorCode, ByteString byteString) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " GO_AWAY: lastStreamId=" + i10 + " errorCode=" + ((Object) errorCode) + " length=" + byteString.size() + " bytes=" + toString(new Buffer().write(byteString)));
        }
    }

    public void logHeaders(Direction direction, int i10, List<Header> list, boolean z10) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " HEADERS: streamId=" + i10 + " headers=" + ((Object) list) + " endStream=" + z10);
        }
    }

    public void logPing(Direction direction, long j10) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " PING: ack=false bytes=" + j10);
        }
    }

    public void logPingAck(Direction direction, long j10) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " PING: ack=true bytes=" + j10);
        }
    }

    public void logPriority(Direction direction, int i10, int i11, int i12, boolean z10) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " PRIORITY: streamId=" + i10 + " streamDependency=" + i11 + " weight=" + i12 + " exclusive=" + z10);
        }
    }

    public void logPushPromise(Direction direction, int i10, int i11, List<Header> list) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " PUSH_PROMISE: streamId=" + i10 + " promisedStreamId=" + i11 + " headers=" + ((Object) list));
        }
    }

    public void logRstStream(Direction direction, int i10, ErrorCode errorCode) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " RST_STREAM: streamId=" + i10 + " errorCode=" + ((Object) errorCode));
        }
    }

    public void logSettings(Direction direction, Settings settings) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " SETTINGS: ack=false settings=" + toString(settings));
        }
    }

    public void logSettingsAck(Direction direction) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " SETTINGS: ack=true");
        }
    }

    public void logWindowsUpdate(Direction direction, int i10, long j10) {
        if (isEnabled()) {
            this.logger.log(this.level, ((Object) direction) + " WINDOW_UPDATE: streamId=" + i10 + " windowSizeIncrement=" + j10);
        }
    }

    public OkHttpFrameLogger(Level level, Logger logger) {
        this.level = (Level) o.s(level, DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL);
        this.logger = (Logger) o.s(logger, bs.f9946a);
    }

    private static String toString(Buffer buffer) {
        if (buffer.size() <= 64) {
            return buffer.snapshot().hex();
        }
        return buffer.snapshot((int) Math.min(buffer.size(), 64L)).hex() + "...";
    }
}
