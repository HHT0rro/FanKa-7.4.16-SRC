package com.cupidapp.live.base.grpc;

import android.os.Handler;
import android.os.HandlerThread;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcHeartbeat;
import com.cupidapp.live.base.sensorslog.TrackAppErrorType;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.okhttp.OkHttpChannelBuilder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GrpcIMBase.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class GrpcIMBase {

    @NotNull
    private static final String CD_CONNECT_CANCEL = "finka_connector_cancel";

    @NotNull
    private static final String CD_CONNECT_TIMEOUT = "finka_connector_connect_timeout";

    @NotNull
    private static final String CD_PING_TIMEOUT = "finka_connector_ping_timeout";

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final boolean DEBUG = false;
    private static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    private static final long IDLE_TIME = 300;
    public static final int MINUTE = 60000;
    public static final int SECOND = 1000;

    @NotNull
    public static final String TAG = "GrpcIM";

    @Nullable
    private ManagedChannel channel;

    @Nullable
    private ClientCall<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> clientCall;
    private int currentConnectTimes;
    private boolean grpcIsConnecting;

    @Nullable
    private GrpcHeartbeat heartbeat;

    @Nullable
    private Handler workHandler;

    @Nullable
    private HandlerThread workThread;

    @NotNull
    private final AtomicBoolean running = new AtomicBoolean(false);

    @NotNull
    private final int[] RETRY_DELAY_TIME = {3000, 3000, 3000, 5000, 5000, 5000, 10000, 10000, 10000, 20000, 20000, 20000, 30000, 30000, 30000, 60000};

    @NotNull
    private final ClientCall.Listener<CuConnectorOuterClass.ConnectorMessage> callListener = new GrpcIMBase$callListener$1(this);

    @NotNull
    private final Runnable retryConnectRunnable = new Runnable() { // from class: com.cupidapp.live.base.grpc.o
        @Override // java.lang.Runnable
        public final void run() {
            GrpcIMBase.retryConnectRunnable$lambda$0(GrpcIMBase.this);
        }
    };

    @NotNull
    private final Runnable connectTimeoutRunnable = new Runnable() { // from class: com.cupidapp.live.base.grpc.l
        @Override // java.lang.Runnable
        public final void run() {
            GrpcIMBase.connectTimeoutRunnable$lambda$1(GrpcIMBase.this);
        }
    };

    /* compiled from: GrpcIMBase.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GrpcIMBase.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.Code.values().length];
            try {
                iArr[Status.Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.Code.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void cancelConnector() {
        runInWorkThread$default(this, new Runnable() { // from class: com.cupidapp.live.base.grpc.m
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIMBase.cancelConnector$lambda$6(GrpcIMBase.this);
            }
        }, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelConnector$lambda$6(GrpcIMBase this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ClientCall<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> clientCall = this$0.clientCall;
        if (clientCall != null) {
            clientCall.cancel(CD_CONNECT_CANCEL, null);
        }
    }

    private final void cancelWorkRunnable(Runnable runnable) {
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connect$lambda$2(GrpcIMBase this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.realConnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectTimeoutRunnable$lambda$1(GrpcIMBase this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ClientCall<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> clientCall = this$0.clientCall;
        if (clientCall != null) {
            clientCall.cancel(CD_CONNECT_TIMEOUT, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void connectorClosed(io.grpc.Status r4, io.grpc.Metadata r5) {
        /*
            r3 = this;
            java.lang.Runnable r5 = r3.connectTimeoutRunnable
            r3.cancelWorkRunnable(r5)
            com.cupidapp.live.base.grpc.GrpcHeartbeat r5 = r3.heartbeat
            if (r5 == 0) goto Lc
            r5.stop()
        Lc:
            r5 = 0
            r0 = 1
            if (r4 == 0) goto L34
            io.grpc.Status$Code r1 = r4.getCode()
            if (r1 != 0) goto L18
            r1 = -1
            goto L20
        L18:
            int[] r2 = com.cupidapp.live.base.grpc.GrpcIMBase.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
        L20:
            if (r1 == r0) goto L32
            r2 = 2
            if (r1 == r2) goto L26
            goto L34
        L26:
            java.lang.String r1 = r4.getDescription()
            java.lang.String r2 = "finka_connector_cancel"
            boolean r1 = kotlin.jvm.internal.s.d(r1, r2)
            if (r1 == 0) goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            if (r1 == 0) goto L49
            long r1 = r3.getRetryDelayTime()
            r3.reportGrpcDisconnection(r1, r4)
            java.lang.Runnable r4 = r3.retryConnectRunnable
            r3.runInWorkThread(r4, r1)
            int r4 = r3.currentConnectTimes
            int r4 = r4 + r0
            r3.currentConnectTimes = r4
            goto L4e
        L49:
            java.util.concurrent.atomic.AtomicBoolean r4 = r3.running
            r4.set(r5)
        L4e:
            r3.onConnectorClosed()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.grpc.GrpcIMBase.connectorClosed(io.grpc.Status, io.grpc.Metadata):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectorReady() {
        cancelWorkRunnable(this.connectTimeoutRunnable);
        this.currentConnectTimes = 0;
        onConnectorReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectorReceived(CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        GrpcHeartbeat grpcHeartbeat = this.heartbeat;
        if (grpcHeartbeat != null) {
            grpcHeartbeat.update();
        }
        onConnectorReceived(connectorMessage);
    }

    private final void destroyChannel() {
        ManagedChannel managedChannel = this.channel;
        if (managedChannel != null && !managedChannel.isShutdown()) {
            managedChannel.shutdownNow();
        }
        this.channel = null;
    }

    private final long getRetryDelayTime() {
        int i10 = this.currentConnectTimes;
        int[] iArr = this.RETRY_DELAY_TIME;
        if (i10 >= iArr.length) {
            i10 = iArr.length - 1;
        }
        return iArr[i10];
    }

    private final void init(final String str, final int i10) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (this.workThread == null) {
            HandlerThread handlerThread = new HandlerThread("finka-grpc-im-connector");
            this.workThread = handlerThread;
            handlerThread.start();
            this.workHandler = new Handler(handlerThread.getLooper());
        }
        runInWorkThread$default(this, new Runnable() { // from class: com.cupidapp.live.base.grpc.q
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIMBase.init$lambda$10(GrpcIMBase.this, str, i10);
            }
        }, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$10(GrpcIMBase this$0, String str, int i10) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (this$0.channel == null) {
            this$0.channel = ((OkHttpChannelBuilder) ((OkHttpChannelBuilder) OkHttpChannelBuilder.forAddress(str, i10).usePlaintext().directExecutor()).keepAliveWithoutCalls(true).idleTimeout(300L, TimeUnit.SECONDS)).build();
        }
    }

    private final void realConnect() {
        try {
            this.running.set(true);
            ManagedChannel managedChannel = this.channel;
            this.clientCall = managedChannel != null ? managedChannel.newCall(CuConnectorGrpc.getCommunicateMethod(), CallOptions.DEFAULT) : null;
            runInWorkThread(this.connectTimeoutRunnable, 30000L);
            ClientCall<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> clientCall = this.clientCall;
            if (clientCall != null) {
                clientCall.start(this.callListener, new Metadata());
                clientCall.request(Integer.MAX_VALUE);
            }
        } catch (Exception unused) {
            cancelWorkRunnable(this.connectTimeoutRunnable);
            onConnectorClosed();
            this.running.set(false);
        }
    }

    private final void reportGrpcDisconnection(long j10, Status status) {
        if (j10 == 60000) {
            Status.Code code = status != null ? status.getCode() : null;
            j1.f.f50231a.a(TrackAppErrorType.GRPC_DISCONNECTION, "code=" + ((Object) code) + "  description=" + (status != null ? status.getDescription() : null) + "  cause=" + ((Object) (status != null ? status.getCause() : null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retryConnectRunnable$lambda$0(GrpcIMBase this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.realConnect();
    }

    public static /* synthetic */ void runInMainThread$default(GrpcIMBase grpcIMBase, Runnable runnable, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runInMainThread");
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        grpcIMBase.runInMainThread(runnable, j10);
    }

    public static /* synthetic */ void runInWorkThread$default(GrpcIMBase grpcIMBase, Runnable runnable, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runInWorkThread");
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        grpcIMBase.runInWorkThread(runnable, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMessage$lambda$3(GrpcIMBase this$0, CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.sendMessageDirect(connectorMessage);
    }

    public final void connect(@Nullable String str, int i10) {
        if (this.running.get()) {
            return;
        }
        this.running.set(true);
        init(str, i10);
        runInWorkThread$default(this, new Runnable() { // from class: com.cupidapp.live.base.grpc.n
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIMBase.connect$lambda$2(GrpcIMBase.this);
            }
        }, 0L, 2, null);
    }

    public final void disconnect() {
        if (this.running.get()) {
            cancelWorkRunnable(this.retryConnectRunnable);
            cancelConnector();
        }
    }

    public final boolean getGrpcIsConnecting() {
        return this.grpcIsConnecting;
    }

    public abstract void onConnectorClosed();

    public abstract void onConnectorPing();

    public abstract void onConnectorPingTimeout();

    public abstract void onConnectorReady();

    public abstract void onConnectorReceived(@Nullable CuConnectorOuterClass.ConnectorMessage connectorMessage);

    public final void runInMainThread(@NotNull Runnable r10, long j10) {
        kotlin.jvm.internal.s.i(r10, "r");
        AppApplication.f11612d.h().j().postDelayed(r10, j10);
    }

    public final void runInWorkThread(@NotNull Runnable r10, long j10) {
        kotlin.jvm.internal.s.i(r10, "r");
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.postDelayed(r10, j10);
        }
    }

    public final void sendMessage(@Nullable final CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        runInWorkThread$default(this, new Runnable() { // from class: com.cupidapp.live.base.grpc.p
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIMBase.sendMessage$lambda$3(GrpcIMBase.this, connectorMessage);
            }
        }, 0L, 2, null);
    }

    public final void sendMessageDirect(@Nullable CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        ClientCall<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> clientCall;
        if (connectorMessage == null || (clientCall = this.clientCall) == null || !clientCall.isReady()) {
            return;
        }
        clientCall.sendMessage(connectorMessage);
    }

    public final void setGrpcIsConnecting(boolean z10) {
        this.grpcIsConnecting = z10;
    }

    public final void startHeartbeat() {
        Handler handler = this.workHandler;
        if (handler != null && this.heartbeat == null) {
            this.heartbeat = new GrpcHeartbeat(handler, 0L, 0L, 6, null);
        }
        GrpcHeartbeat grpcHeartbeat = this.heartbeat;
        if (grpcHeartbeat != null) {
            grpcHeartbeat.start(new GrpcHeartbeat.OnBeatListener() { // from class: com.cupidapp.live.base.grpc.GrpcIMBase$startHeartbeat$2
                @Override // com.cupidapp.live.base.grpc.GrpcHeartbeat.OnBeatListener
                public void onPing() {
                    GrpcIMBase.this.onConnectorPing();
                }

                @Override // com.cupidapp.live.base.grpc.GrpcHeartbeat.OnBeatListener
                public void onTimeout() {
                    ClientCall clientCall;
                    clientCall = GrpcIMBase.this.clientCall;
                    if (clientCall != null) {
                        clientCall.cancel("finka_connector_ping_timeout", null);
                    }
                    GrpcIMBase.this.onConnectorPingTimeout();
                }
            });
        }
    }

    public final void stopHeartbeat() {
        GrpcHeartbeat grpcHeartbeat = this.heartbeat;
        if (grpcHeartbeat != null) {
            grpcHeartbeat.stop();
        }
    }
}
