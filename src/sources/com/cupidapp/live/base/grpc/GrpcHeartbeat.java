package com.cupidapp.live.base.grpc;

import android.os.Handler;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GrpcHeartbeat.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GrpcHeartbeat {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_BEAT_DURATION = 50000;
    private static final long DEFAULT_BEAT_TIMEOUT = 60000;
    private static final long SECOND = 1000;
    private final long beatDuration;

    @Nullable
    private OnBeatListener beatListener;
    private final long beatTimeout;
    private long lastUpdateTime;

    @NotNull
    private Runnable pingRunnable;
    private boolean running;

    @NotNull
    private Runnable timeoutRunnable;

    @NotNull
    private final Handler workHandler;

    /* compiled from: GrpcHeartbeat.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GrpcHeartbeat.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnBeatListener {
        void onPing();

        void onTimeout();
    }

    public GrpcHeartbeat(@NotNull Handler workHandler, long j10, long j11) {
        kotlin.jvm.internal.s.i(workHandler, "workHandler");
        this.workHandler = workHandler;
        this.beatDuration = j10;
        this.beatTimeout = j11;
        this.pingRunnable = new Runnable() { // from class: com.cupidapp.live.base.grpc.f
            @Override // java.lang.Runnable
            public final void run() {
                GrpcHeartbeat.pingRunnable$lambda$0(GrpcHeartbeat.this);
            }
        };
        this.timeoutRunnable = new Runnable() { // from class: com.cupidapp.live.base.grpc.g
            @Override // java.lang.Runnable
            public final void run() {
                GrpcHeartbeat.timeoutRunnable$lambda$1(GrpcHeartbeat.this);
            }
        };
    }

    private final void ping() {
        this.workHandler.postDelayed(this.pingRunnable, this.beatDuration);
        OnBeatListener onBeatListener = this.beatListener;
        if (onBeatListener != null) {
            onBeatListener.onPing();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pingRunnable$lambda$0(GrpcHeartbeat this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.ping();
    }

    private final void timeout() {
        long currentTimeMillis = (this.lastUpdateTime + 60000) - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            this.workHandler.removeCallbacks(this.timeoutRunnable);
            this.workHandler.postDelayed(this.timeoutRunnable, currentTimeMillis);
        } else {
            OnBeatListener onBeatListener = this.beatListener;
            if (onBeatListener != null) {
                onBeatListener.onTimeout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void timeoutRunnable$lambda$1(GrpcHeartbeat this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.timeout();
    }

    public final void start(@Nullable OnBeatListener onBeatListener) {
        this.beatListener = onBeatListener;
        if (this.running) {
            return;
        }
        this.running = true;
        this.workHandler.post(this.pingRunnable);
        this.workHandler.postDelayed(this.timeoutRunnable, this.beatTimeout);
    }

    public final void stop() {
        this.beatListener = null;
        if (this.running) {
            this.running = false;
            this.workHandler.removeCallbacks(this.timeoutRunnable);
            this.workHandler.removeCallbacks(this.pingRunnable);
        }
    }

    public final void update() {
        if (this.running) {
            this.lastUpdateTime = System.currentTimeMillis();
        }
    }

    public /* synthetic */ GrpcHeartbeat(Handler handler, long j10, long j11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i10 & 2) != 0 ? DEFAULT_BEAT_DURATION : j10, (i10 & 4) != 0 ? 60000L : j11);
    }
}
