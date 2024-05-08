package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.text.MessageFormat;
import java.util.logging.Level;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ChannelLoggerImpl extends ChannelLogger {
    private final TimeProvider time;
    private final ChannelTracer tracer;

    /* renamed from: io.grpc.internal.ChannelLoggerImpl$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel;

        static {
            int[] iArr = new int[ChannelLogger.ChannelLogLevel.values().length];
            $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel = iArr;
            try {
                iArr[ChannelLogger.ChannelLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[ChannelLogger.ChannelLogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[ChannelLogger.ChannelLogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ChannelLoggerImpl(ChannelTracer channelTracer, TimeProvider timeProvider) {
        this.tracer = (ChannelTracer) o.s(channelTracer, "tracer");
        this.time = (TimeProvider) o.s(timeProvider, "time");
    }

    private boolean isTraceable(ChannelLogger.ChannelLogLevel channelLogLevel) {
        return channelLogLevel != ChannelLogger.ChannelLogLevel.DEBUG && this.tracer.isTraceEnabled();
    }

    public static void logOnly(InternalLogId internalLogId, ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        Level javaLogLevel = toJavaLogLevel(channelLogLevel);
        if (ChannelTracer.logger.isLoggable(javaLogLevel)) {
            ChannelTracer.logOnly(internalLogId, javaLogLevel, str);
        }
    }

    private static Level toJavaLogLevel(ChannelLogger.ChannelLogLevel channelLogLevel) {
        int i10 = AnonymousClass1.$SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[channelLogLevel.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return Level.FINE;
        }
        if (i10 != 3) {
            return Level.FINEST;
        }
        return Level.FINER;
    }

    private static InternalChannelz.ChannelTrace.Event.Severity toTracerSeverity(ChannelLogger.ChannelLogLevel channelLogLevel) {
        int i10 = AnonymousClass1.$SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[channelLogLevel.ordinal()];
        if (i10 == 1) {
            return InternalChannelz.ChannelTrace.Event.Severity.CT_ERROR;
        }
        if (i10 != 2) {
            return InternalChannelz.ChannelTrace.Event.Severity.CT_INFO;
        }
        return InternalChannelz.ChannelTrace.Event.Severity.CT_WARNING;
    }

    private void trace(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        if (channelLogLevel == ChannelLogger.ChannelLogLevel.DEBUG) {
            return;
        }
        this.tracer.traceOnly(new InternalChannelz.ChannelTrace.Event.Builder().setDescription(str).setSeverity(toTracerSeverity(channelLogLevel)).setTimestampNanos(this.time.currentTimeNanos()).build());
    }

    @Override // io.grpc.ChannelLogger
    public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        logOnly(this.tracer.getLogId(), channelLogLevel, str);
        if (isTraceable(channelLogLevel)) {
            trace(channelLogLevel, str);
        }
    }

    public static void logOnly(InternalLogId internalLogId, ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
        Level javaLogLevel = toJavaLogLevel(channelLogLevel);
        if (ChannelTracer.logger.isLoggable(javaLogLevel)) {
            ChannelTracer.logOnly(internalLogId, javaLogLevel, MessageFormat.format(str, objArr));
        }
    }

    @Override // io.grpc.ChannelLogger
    public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
        log(channelLogLevel, (isTraceable(channelLogLevel) || ChannelTracer.logger.isLoggable(toJavaLogLevel(channelLogLevel))) ? MessageFormat.format(str, objArr) : null);
    }
}
