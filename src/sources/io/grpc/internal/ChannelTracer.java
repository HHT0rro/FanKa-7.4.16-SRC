package io.grpc.internal;

import com.google.common.base.o;
import com.mobile.auth.BuildConfig;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ChannelTracer {
    public static final Logger logger = Logger.getLogger(ChannelLogger.class.getName());
    private final long channelCreationTimeNanos;
    private final Collection<InternalChannelz.ChannelTrace.Event> events;
    private int eventsLogged;
    private final Object lock = new Object();
    private final InternalLogId logId;

    /* renamed from: io.grpc.internal.ChannelTracer$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity;

        static {
            int[] iArr = new int[InternalChannelz.ChannelTrace.Event.Severity.values().length];
            $SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity = iArr;
            try {
                iArr[InternalChannelz.ChannelTrace.Event.Severity.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity[InternalChannelz.ChannelTrace.Event.Severity.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ChannelTracer(InternalLogId internalLogId, final int i10, long j10, String str) {
        o.s(str, "description");
        this.logId = (InternalLogId) o.s(internalLogId, "logId");
        if (i10 > 0) {
            this.events = new ArrayDeque<InternalChannelz.ChannelTrace.Event>() { // from class: io.grpc.internal.ChannelTracer.1
                @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean add(InternalChannelz.ChannelTrace.Event event) {
                    if (size() == i10) {
                        removeFirst();
                    }
                    ChannelTracer.access$008(ChannelTracer.this);
                    return super.add((AnonymousClass1) event);
                }
            };
        } else {
            this.events = null;
        }
        this.channelCreationTimeNanos = j10;
        reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription(str + " created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(j10).build());
    }

    public static /* synthetic */ int access$008(ChannelTracer channelTracer) {
        int i10 = channelTracer.eventsLogged;
        channelTracer.eventsLogged = i10 + 1;
        return i10;
    }

    public static void logOnly(InternalLogId internalLogId, Level level, String str) {
        Logger logger2 = logger;
        if (logger2.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + ((Object) internalLogId) + "] " + str);
            logRecord.setLoggerName(logger2.getName());
            logRecord.setSourceClassName(logger2.getName());
            logRecord.setSourceMethodName(BuildConfig.FLAVOR_type);
            logger2.log(logRecord);
        }
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public boolean isTraceEnabled() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.events != null;
        }
        return z10;
    }

    public void reportEvent(InternalChannelz.ChannelTrace.Event event) {
        Level level;
        int i10 = AnonymousClass2.$SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity[event.severity.ordinal()];
        if (i10 == 1) {
            level = Level.FINE;
        } else if (i10 != 2) {
            level = Level.FINEST;
        } else {
            level = Level.FINER;
        }
        traceOnly(event);
        logOnly(this.logId, level, event.description);
    }

    public void traceOnly(InternalChannelz.ChannelTrace.Event event) {
        synchronized (this.lock) {
            Collection<InternalChannelz.ChannelTrace.Event> collection = this.events;
            if (collection != null) {
                collection.add(event);
            }
        }
    }

    public void updateBuilder(InternalChannelz.ChannelStats.Builder builder) {
        synchronized (this.lock) {
            if (this.events == null) {
                return;
            }
            builder.setChannelTrace(new InternalChannelz.ChannelTrace.Builder().setNumEventsLogged(this.eventsLogged).setCreationTimeNanos(this.channelCreationTimeNanos).setEvents(new ArrayList(this.events)).build());
        }
    }
}
