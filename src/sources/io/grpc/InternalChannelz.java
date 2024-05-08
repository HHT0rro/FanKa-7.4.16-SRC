package io.grpc;

import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import java.net.SocketAddress;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalChannelz {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger log = Logger.getLogger(InternalChannelz.class.getName());
    private static final InternalChannelz INSTANCE = new InternalChannelz();
    private final ConcurrentNavigableMap<Long, InternalInstrumented<ServerStats>> servers = new ConcurrentSkipListMap();
    private final ConcurrentNavigableMap<Long, InternalInstrumented<ChannelStats>> rootChannels = new ConcurrentSkipListMap();
    private final ConcurrentMap<Long, InternalInstrumented<ChannelStats>> subchannels = new ConcurrentHashMap();
    private final ConcurrentMap<Long, InternalInstrumented<SocketStats>> otherSockets = new ConcurrentHashMap();
    private final ConcurrentMap<Long, ServerSocketMap> perServerSockets = new ConcurrentHashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ChannelStats {
        public final long callsFailed;
        public final long callsStarted;
        public final long callsSucceeded;
        public final ChannelTrace channelTrace;
        public final long lastCallStartedNanos;
        public final List<InternalWithLogId> sockets;
        public final ConnectivityState state;
        public final List<InternalWithLogId> subchannels;
        public final String target;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private long callsFailed;
            private long callsStarted;
            private long callsSucceeded;
            private ChannelTrace channelTrace;
            private long lastCallStartedNanos;
            private ConnectivityState state;
            private String target;
            private List<InternalWithLogId> subchannels = Collections.emptyList();
            private List<InternalWithLogId> sockets = Collections.emptyList();

            public ChannelStats build() {
                return new ChannelStats(this.target, this.state, this.channelTrace, this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedNanos, this.subchannels, this.sockets);
            }

            public Builder setCallsFailed(long j10) {
                this.callsFailed = j10;
                return this;
            }

            public Builder setCallsStarted(long j10) {
                this.callsStarted = j10;
                return this;
            }

            public Builder setCallsSucceeded(long j10) {
                this.callsSucceeded = j10;
                return this;
            }

            public Builder setChannelTrace(ChannelTrace channelTrace) {
                this.channelTrace = channelTrace;
                return this;
            }

            public Builder setLastCallStartedNanos(long j10) {
                this.lastCallStartedNanos = j10;
                return this;
            }

            public Builder setSockets(List<InternalWithLogId> list) {
                o.x(this.subchannels.isEmpty());
                this.sockets = Collections.unmodifiableList((List) o.r(list));
                return this;
            }

            public Builder setState(ConnectivityState connectivityState) {
                this.state = connectivityState;
                return this;
            }

            public Builder setSubchannels(List<InternalWithLogId> list) {
                o.x(this.sockets.isEmpty());
                this.subchannels = Collections.unmodifiableList((List) o.r(list));
                return this;
            }

            public Builder setTarget(String str) {
                this.target = str;
                return this;
            }
        }

        private ChannelStats(String str, ConnectivityState connectivityState, ChannelTrace channelTrace, long j10, long j11, long j12, long j13, List<InternalWithLogId> list, List<InternalWithLogId> list2) {
            o.y(list.isEmpty() || list2.isEmpty(), "channels can have subchannels only, subchannels can have either sockets OR subchannels, neither can have both");
            this.target = str;
            this.state = connectivityState;
            this.channelTrace = channelTrace;
            this.callsStarted = j10;
            this.callsSucceeded = j11;
            this.callsFailed = j12;
            this.lastCallStartedNanos = j13;
            this.subchannels = (List) o.r(list);
            this.sockets = (List) o.r(list2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ChannelTrace {
        public final long creationTimeNanos;
        public final List<Event> events;
        public final long numEventsLogged;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private Long creationTimeNanos;
            private List<Event> events = Collections.emptyList();
            private Long numEventsLogged;

            public ChannelTrace build() {
                o.s(this.numEventsLogged, "numEventsLogged");
                o.s(this.creationTimeNanos, "creationTimeNanos");
                return new ChannelTrace(this.numEventsLogged.longValue(), this.creationTimeNanos.longValue(), this.events);
            }

            public Builder setCreationTimeNanos(long j10) {
                this.creationTimeNanos = Long.valueOf(j10);
                return this;
            }

            public Builder setEvents(List<Event> list) {
                this.events = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public Builder setNumEventsLogged(long j10) {
                this.numEventsLogged = Long.valueOf(j10);
                return this;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Event {
            public final InternalWithLogId channelRef;
            public final String description;
            public final Severity severity;
            public final InternalWithLogId subchannelRef;
            public final long timestampNanos;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public static final class Builder {
                private InternalWithLogId channelRef;
                private String description;
                private Severity severity;
                private InternalWithLogId subchannelRef;
                private Long timestampNanos;

                public Event build() {
                    o.s(this.description, "description");
                    o.s(this.severity, "severity");
                    o.s(this.timestampNanos, "timestampNanos");
                    o.y(this.channelRef == null || this.subchannelRef == null, "at least one of channelRef and subchannelRef must be null");
                    return new Event(this.description, this.severity, this.timestampNanos.longValue(), this.channelRef, this.subchannelRef);
                }

                public Builder setChannelRef(InternalWithLogId internalWithLogId) {
                    this.channelRef = internalWithLogId;
                    return this;
                }

                public Builder setDescription(String str) {
                    this.description = str;
                    return this;
                }

                public Builder setSeverity(Severity severity) {
                    this.severity = severity;
                    return this;
                }

                public Builder setSubchannelRef(InternalWithLogId internalWithLogId) {
                    this.subchannelRef = internalWithLogId;
                    return this;
                }

                public Builder setTimestampNanos(long j10) {
                    this.timestampNanos = Long.valueOf(j10);
                    return this;
                }
            }

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public enum Severity {
                CT_UNKNOWN,
                CT_INFO,
                CT_WARNING,
                CT_ERROR
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof Event)) {
                    return false;
                }
                Event event = (Event) obj;
                return l.a(this.description, event.description) && l.a(this.severity, event.severity) && this.timestampNanos == event.timestampNanos && l.a(this.channelRef, event.channelRef) && l.a(this.subchannelRef, event.subchannelRef);
            }

            public int hashCode() {
                return l.b(this.description, this.severity, Long.valueOf(this.timestampNanos), this.channelRef, this.subchannelRef);
            }

            public String toString() {
                return j.c(this).d("description", this.description).d("severity", this.severity).c("timestampNanos", this.timestampNanos).d("channelRef", this.channelRef).d("subchannelRef", this.subchannelRef).toString();
            }

            private Event(String str, Severity severity, long j10, InternalWithLogId internalWithLogId, InternalWithLogId internalWithLogId2) {
                this.description = str;
                this.severity = (Severity) o.s(severity, "severity");
                this.timestampNanos = j10;
                this.channelRef = internalWithLogId;
                this.subchannelRef = internalWithLogId2;
            }
        }

        private ChannelTrace(long j10, long j11, List<Event> list) {
            this.numEventsLogged = j10;
            this.creationTimeNanos = j11;
            this.events = list;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class OtherSecurity {
        public final Object any;
        public final String name;

        public OtherSecurity(String str, Object obj) {
            this.name = (String) o.r(str);
            o.y(obj == null || obj.getClass().getName().endsWith("com.google.protobuf.Any"), "the 'any' object must be of type com.google.protobuf.Any");
            this.any = obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class RootChannelList {
        public final List<InternalInstrumented<ChannelStats>> channels;
        public final boolean end;

        public RootChannelList(List<InternalInstrumented<ChannelStats>> list, boolean z10) {
            this.channels = (List) o.r(list);
            this.end = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerList {
        public final boolean end;
        public final List<InternalInstrumented<ServerStats>> servers;

        public ServerList(List<InternalInstrumented<ServerStats>> list, boolean z10) {
            this.servers = (List) o.r(list);
            this.end = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerSocketMap extends ConcurrentSkipListMap<Long, InternalInstrumented<SocketStats>> {
        private static final long serialVersionUID = -7883772124944661414L;

        private ServerSocketMap() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerSocketsList {
        public final boolean end;
        public final List<InternalWithLogId> sockets;

        public ServerSocketsList(List<InternalWithLogId> list, boolean z10) {
            this.sockets = list;
            this.end = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerStats {
        public final long callsFailed;
        public final long callsStarted;
        public final long callsSucceeded;
        public final long lastCallStartedNanos;
        public final List<InternalInstrumented<SocketStats>> listenSockets;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private long callsFailed;
            private long callsStarted;
            private long callsSucceeded;
            private long lastCallStartedNanos;
            public List<InternalInstrumented<SocketStats>> listenSockets = new ArrayList();

            public Builder addListenSockets(List<InternalInstrumented<SocketStats>> list) {
                o.s(list, "listenSockets");
                Iterator<InternalInstrumented<SocketStats>> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    this.listenSockets.add((InternalInstrumented) o.s(iterator2.next(), "null listen socket"));
                }
                return this;
            }

            public ServerStats build() {
                return new ServerStats(this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedNanos, this.listenSockets);
            }

            public Builder setCallsFailed(long j10) {
                this.callsFailed = j10;
                return this;
            }

            public Builder setCallsStarted(long j10) {
                this.callsStarted = j10;
                return this;
            }

            public Builder setCallsSucceeded(long j10) {
                this.callsSucceeded = j10;
                return this;
            }

            public Builder setLastCallStartedNanos(long j10) {
                this.lastCallStartedNanos = j10;
                return this;
            }
        }

        public ServerStats(long j10, long j11, long j12, long j13, List<InternalInstrumented<SocketStats>> list) {
            this.callsStarted = j10;
            this.callsSucceeded = j11;
            this.callsFailed = j12;
            this.lastCallStartedNanos = j13;
            this.listenSockets = (List) o.r(list);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SocketOptions {
        public final Integer lingerSeconds;
        public final Map<String, String> others;
        public final Integer soTimeoutMillis;
        public final TcpInfo tcpInfo;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private Integer lingerSeconds;
            private final Map<String, String> others = new HashMap();
            private TcpInfo tcpInfo;
            private Integer timeoutMillis;

            public Builder addOption(String str, String str2) {
                this.others.put(str, (String) o.r(str2));
                return this;
            }

            public SocketOptions build() {
                return new SocketOptions(this.timeoutMillis, this.lingerSeconds, this.tcpInfo, this.others);
            }

            public Builder setSocketOptionLingerSeconds(Integer num) {
                this.lingerSeconds = num;
                return this;
            }

            public Builder setSocketOptionTimeoutMillis(Integer num) {
                this.timeoutMillis = num;
                return this;
            }

            public Builder setTcpInfo(TcpInfo tcpInfo) {
                this.tcpInfo = tcpInfo;
                return this;
            }

            public Builder addOption(String str, int i10) {
                this.others.put(str, Integer.toString(i10));
                return this;
            }

            public Builder addOption(String str, boolean z10) {
                this.others.put(str, Boolean.toString(z10));
                return this;
            }
        }

        public SocketOptions(Integer num, Integer num2, TcpInfo tcpInfo, Map<String, String> map) {
            o.r(map);
            this.soTimeoutMillis = num;
            this.lingerSeconds = num2;
            this.tcpInfo = tcpInfo;
            this.others = Collections.unmodifiableMap(new HashMap(map));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SocketStats {
        public final TransportStats data;
        public final SocketAddress local;
        public final SocketAddress remote;
        public final Security security;
        public final SocketOptions socketOptions;

        public SocketStats(TransportStats transportStats, SocketAddress socketAddress, SocketAddress socketAddress2, SocketOptions socketOptions, Security security) {
            this.data = transportStats;
            this.local = (SocketAddress) o.s(socketAddress, "local socket");
            this.remote = socketAddress2;
            this.socketOptions = (SocketOptions) o.r(socketOptions);
            this.security = security;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TcpInfo {
        public final int advmss;
        public final int ato;
        public final int backoff;
        public final int caState;
        public final int fackets;
        public final int lastAckRecv;
        public final int lastAckSent;
        public final int lastDataRecv;
        public final int lastDataSent;
        public final int lost;
        public final int options;
        public final int pmtu;
        public final int probes;
        public final int rcvMss;
        public final int rcvSsthresh;
        public final int rcvWscale;
        public final int reordering;
        public final int retrans;
        public final int retransmits;
        public final int rto;
        public final int rtt;
        public final int rttvar;
        public final int sacked;
        public final int sndCwnd;
        public final int sndMss;
        public final int sndSsthresh;
        public final int sndWscale;
        public final int state;
        public final int unacked;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private int advmss;
            private int ato;
            private int backoff;
            private int caState;
            private int fackets;
            private int lastAckRecv;
            private int lastAckSent;
            private int lastDataRecv;
            private int lastDataSent;
            private int lost;
            private int options;
            private int pmtu;
            private int probes;
            private int rcvMss;
            private int rcvSsthresh;
            private int rcvWscale;
            private int reordering;
            private int retrans;
            private int retransmits;
            private int rto;
            private int rtt;
            private int rttvar;
            private int sacked;
            private int sndCwnd;
            private int sndMss;
            private int sndSsthresh;
            private int sndWscale;
            private int state;
            private int unacked;

            public TcpInfo build() {
                return new TcpInfo(this.state, this.caState, this.retransmits, this.probes, this.backoff, this.options, this.sndWscale, this.rcvWscale, this.rto, this.ato, this.sndMss, this.rcvMss, this.unacked, this.sacked, this.lost, this.retrans, this.fackets, this.lastDataSent, this.lastAckSent, this.lastDataRecv, this.lastAckRecv, this.pmtu, this.rcvSsthresh, this.rtt, this.rttvar, this.sndSsthresh, this.sndCwnd, this.advmss, this.reordering);
            }

            public Builder setAdvmss(int i10) {
                this.advmss = i10;
                return this;
            }

            public Builder setAto(int i10) {
                this.ato = i10;
                return this;
            }

            public Builder setBackoff(int i10) {
                this.backoff = i10;
                return this;
            }

            public Builder setCaState(int i10) {
                this.caState = i10;
                return this;
            }

            public Builder setFackets(int i10) {
                this.fackets = i10;
                return this;
            }

            public Builder setLastAckRecv(int i10) {
                this.lastAckRecv = i10;
                return this;
            }

            public Builder setLastAckSent(int i10) {
                this.lastAckSent = i10;
                return this;
            }

            public Builder setLastDataRecv(int i10) {
                this.lastDataRecv = i10;
                return this;
            }

            public Builder setLastDataSent(int i10) {
                this.lastDataSent = i10;
                return this;
            }

            public Builder setLost(int i10) {
                this.lost = i10;
                return this;
            }

            public Builder setOptions(int i10) {
                this.options = i10;
                return this;
            }

            public Builder setPmtu(int i10) {
                this.pmtu = i10;
                return this;
            }

            public Builder setProbes(int i10) {
                this.probes = i10;
                return this;
            }

            public Builder setRcvMss(int i10) {
                this.rcvMss = i10;
                return this;
            }

            public Builder setRcvSsthresh(int i10) {
                this.rcvSsthresh = i10;
                return this;
            }

            public Builder setRcvWscale(int i10) {
                this.rcvWscale = i10;
                return this;
            }

            public Builder setReordering(int i10) {
                this.reordering = i10;
                return this;
            }

            public Builder setRetrans(int i10) {
                this.retrans = i10;
                return this;
            }

            public Builder setRetransmits(int i10) {
                this.retransmits = i10;
                return this;
            }

            public Builder setRto(int i10) {
                this.rto = i10;
                return this;
            }

            public Builder setRtt(int i10) {
                this.rtt = i10;
                return this;
            }

            public Builder setRttvar(int i10) {
                this.rttvar = i10;
                return this;
            }

            public Builder setSacked(int i10) {
                this.sacked = i10;
                return this;
            }

            public Builder setSndCwnd(int i10) {
                this.sndCwnd = i10;
                return this;
            }

            public Builder setSndMss(int i10) {
                this.sndMss = i10;
                return this;
            }

            public Builder setSndSsthresh(int i10) {
                this.sndSsthresh = i10;
                return this;
            }

            public Builder setSndWscale(int i10) {
                this.sndWscale = i10;
                return this;
            }

            public Builder setState(int i10) {
                this.state = i10;
                return this;
            }

            public Builder setUnacked(int i10) {
                this.unacked = i10;
                return this;
            }
        }

        public TcpInfo(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38) {
            this.state = i10;
            this.caState = i11;
            this.retransmits = i12;
            this.probes = i13;
            this.backoff = i14;
            this.options = i15;
            this.sndWscale = i16;
            this.rcvWscale = i17;
            this.rto = i18;
            this.ato = i19;
            this.sndMss = i20;
            this.rcvMss = i21;
            this.unacked = i22;
            this.sacked = i23;
            this.lost = i24;
            this.retrans = i25;
            this.fackets = i26;
            this.lastDataSent = i27;
            this.lastAckSent = i28;
            this.lastDataRecv = i29;
            this.lastAckRecv = i30;
            this.pmtu = i31;
            this.rcvSsthresh = i32;
            this.rtt = i33;
            this.rttvar = i34;
            this.sndSsthresh = i35;
            this.sndCwnd = i36;
            this.advmss = i37;
            this.reordering = i38;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TransportStats {
        public final long keepAlivesSent;
        public final long lastLocalStreamCreatedTimeNanos;
        public final long lastMessageReceivedTimeNanos;
        public final long lastMessageSentTimeNanos;
        public final long lastRemoteStreamCreatedTimeNanos;
        public final long localFlowControlWindow;
        public final long messagesReceived;
        public final long messagesSent;
        public final long remoteFlowControlWindow;
        public final long streamsFailed;
        public final long streamsStarted;
        public final long streamsSucceeded;

        public TransportStats(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
            this.streamsStarted = j10;
            this.lastLocalStreamCreatedTimeNanos = j11;
            this.lastRemoteStreamCreatedTimeNanos = j12;
            this.streamsSucceeded = j13;
            this.streamsFailed = j14;
            this.messagesSent = j15;
            this.messagesReceived = j16;
            this.keepAlivesSent = j17;
            this.lastMessageSentTimeNanos = j18;
            this.lastMessageReceivedTimeNanos = j19;
            this.localFlowControlWindow = j20;
            this.remoteFlowControlWindow = j21;
        }
    }

    private static <T extends InternalInstrumented<?>> void add(Map<Long, T> map, T t2) {
        map.put(Long.valueOf(t2.getLogId().getId()), t2);
    }

    private static <T extends InternalInstrumented<?>> boolean contains(Map<Long, T> map, InternalLogId internalLogId) {
        return map.containsKey(Long.valueOf(internalLogId.getId()));
    }

    private InternalInstrumented<SocketStats> getServerSocket(long j10) {
        Iterator<ServerSocketMap> iterator2 = this.perServerSockets.values().iterator2();
        while (iterator2.hasNext()) {
            InternalInstrumented<SocketStats> internalInstrumented = iterator2.next().get(Long.valueOf(j10));
            if (internalInstrumented != null) {
                return internalInstrumented;
            }
        }
        return null;
    }

    public static long id(InternalWithLogId internalWithLogId) {
        return internalWithLogId.getLogId().getId();
    }

    public static InternalChannelz instance() {
        return INSTANCE;
    }

    private static <T extends InternalInstrumented<?>> void remove(Map<Long, T> map, T t2) {
        map.remove(Long.valueOf(id(t2)));
    }

    public void addClientSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        add(this.otherSockets, internalInstrumented);
    }

    public void addListenSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        add(this.otherSockets, internalInstrumented);
    }

    public void addRootChannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        add(this.rootChannels, internalInstrumented);
    }

    public void addServer(InternalInstrumented<ServerStats> internalInstrumented) {
        this.perServerSockets.put(Long.valueOf(id(internalInstrumented)), new ServerSocketMap());
        add(this.servers, internalInstrumented);
    }

    public void addServerSocket(InternalInstrumented<ServerStats> internalInstrumented, InternalInstrumented<SocketStats> internalInstrumented2) {
        add(this.perServerSockets.get(Long.valueOf(id(internalInstrumented))), internalInstrumented2);
    }

    public void addSubchannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        add(this.subchannels, internalInstrumented);
    }

    public boolean containsClientSocket(InternalLogId internalLogId) {
        return contains(this.otherSockets, internalLogId);
    }

    public boolean containsServer(InternalLogId internalLogId) {
        return contains(this.servers, internalLogId);
    }

    public boolean containsSubchannel(InternalLogId internalLogId) {
        return contains(this.subchannels, internalLogId);
    }

    public InternalInstrumented<ChannelStats> getChannel(long j10) {
        return this.rootChannels.get(Long.valueOf(j10));
    }

    public InternalInstrumented<ChannelStats> getRootChannel(long j10) {
        return this.rootChannels.get(Long.valueOf(j10));
    }

    public RootChannelList getRootChannels(long j10, int i10) {
        ArrayList arrayList = new ArrayList();
        Iterator<InternalInstrumented<ChannelStats>> iterator2 = this.rootChannels.tailMap((ConcurrentNavigableMap<Long, InternalInstrumented<ChannelStats>>) Long.valueOf(j10)).values().iterator2();
        while (iterator2.hasNext() && arrayList.size() < i10) {
            arrayList.add(iterator2.next());
        }
        return new RootChannelList(arrayList, !iterator2.hasNext());
    }

    public InternalInstrumented<ServerStats> getServer(long j10) {
        return this.servers.get(Long.valueOf(j10));
    }

    public ServerSocketsList getServerSockets(long j10, long j11, int i10) {
        ServerSocketMap serverSocketMap = this.perServerSockets.get(Long.valueOf(j10));
        if (serverSocketMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<InternalInstrumented<SocketStats>> iterator2 = serverSocketMap.tailMap((ServerSocketMap) Long.valueOf(j11)).values().iterator2();
        while (arrayList.size() < i10 && iterator2.hasNext()) {
            arrayList.add(iterator2.next());
        }
        return new ServerSocketsList(arrayList, !iterator2.hasNext());
    }

    public ServerList getServers(long j10, int i10) {
        ArrayList arrayList = new ArrayList(i10);
        Iterator<InternalInstrumented<ServerStats>> iterator2 = this.servers.tailMap((ConcurrentNavigableMap<Long, InternalInstrumented<ServerStats>>) Long.valueOf(j10)).values().iterator2();
        while (iterator2.hasNext() && arrayList.size() < i10) {
            arrayList.add(iterator2.next());
        }
        return new ServerList(arrayList, !iterator2.hasNext());
    }

    public InternalInstrumented<SocketStats> getSocket(long j10) {
        InternalInstrumented<SocketStats> internalInstrumented = this.otherSockets.get(Long.valueOf(j10));
        return internalInstrumented != null ? internalInstrumented : getServerSocket(j10);
    }

    public InternalInstrumented<ChannelStats> getSubchannel(long j10) {
        return this.subchannels.get(Long.valueOf(j10));
    }

    public void removeClientSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        remove(this.otherSockets, internalInstrumented);
    }

    public void removeListenSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        remove(this.otherSockets, internalInstrumented);
    }

    public void removeRootChannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        remove(this.rootChannels, internalInstrumented);
    }

    public void removeServer(InternalInstrumented<ServerStats> internalInstrumented) {
        remove(this.servers, internalInstrumented);
        this.perServerSockets.remove(Long.valueOf(id(internalInstrumented)));
    }

    public void removeServerSocket(InternalInstrumented<ServerStats> internalInstrumented, InternalInstrumented<SocketStats> internalInstrumented2) {
        remove(this.perServerSockets.get(Long.valueOf(id(internalInstrumented))), internalInstrumented2);
    }

    public void removeSubchannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        remove(this.subchannels, internalInstrumented);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Security {
        public final OtherSecurity other;
        public final Tls tls;

        public Security(Tls tls) {
            this.tls = (Tls) o.r(tls);
            this.other = null;
        }

        public Security(OtherSecurity otherSecurity) {
            this.tls = null;
            this.other = (OtherSecurity) o.r(otherSecurity);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Tls {
        public final String cipherSuiteStandardName;
        public final Certificate localCert;
        public final Certificate remoteCert;

        public Tls(String str, Certificate certificate, Certificate certificate2) {
            this.cipherSuiteStandardName = str;
            this.localCert = certificate;
            this.remoteCert = certificate2;
        }

        public Tls(SSLSession sSLSession) {
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate = null;
            Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e2) {
                InternalChannelz.log.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e2);
            }
            this.cipherSuiteStandardName = cipherSuite;
            this.localCert = certificate2;
            this.remoteCert = certificate;
        }
    }
}
