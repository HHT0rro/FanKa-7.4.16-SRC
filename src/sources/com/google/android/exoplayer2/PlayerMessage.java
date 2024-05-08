package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Clock;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PlayerMessage {
    private final Clock clock;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Looper looper;

    @Nullable
    private Object payload;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;
    private long positionMs = -9223372036854775807L;
    private boolean deleteAfterDelivery = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface Sender {
        void c(PlayerMessage playerMessage);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface Target {
        void i(int i10, @Nullable Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i10, Clock clock, Looper looper) {
        this.sender = sender;
        this.target = target;
        this.timeline = timeline;
        this.looper = looper;
        this.clock = clock;
        this.windowIndex = i10;
    }

    public synchronized boolean blockUntilDelivered() throws InterruptedException {
        com.google.android.exoplayer2.util.a.g(this.isSent);
        com.google.android.exoplayer2.util.a.g(this.looper.getThread() != Thread.currentThread());
        while (!this.isProcessed) {
            wait();
        }
        return this.isDelivered;
    }

    public synchronized PlayerMessage cancel() {
        com.google.android.exoplayer2.util.a.g(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public Looper getLooper() {
        return this.looper;
    }

    @Nullable
    public Object getPayload() {
        return this.payload;
    }

    public long getPositionMs() {
        return this.positionMs;
    }

    public Target getTarget() {
        return this.target;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public int getType() {
        return this.type;
    }

    public int getWindowIndex() {
        return this.windowIndex;
    }

    public synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public synchronized void markAsProcessed(boolean z10) {
        this.isDelivered = z10 | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }

    public PlayerMessage send() {
        com.google.android.exoplayer2.util.a.g(!this.isSent);
        if (this.positionMs == -9223372036854775807L) {
            com.google.android.exoplayer2.util.a.a(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.c(this);
        return this;
    }

    public PlayerMessage setDeleteAfterDelivery(boolean z10) {
        com.google.android.exoplayer2.util.a.g(!this.isSent);
        this.deleteAfterDelivery = z10;
        return this;
    }

    @Deprecated
    public PlayerMessage setHandler(Handler handler) {
        return setLooper(handler.getLooper());
    }

    public PlayerMessage setLooper(Looper looper) {
        com.google.android.exoplayer2.util.a.g(!this.isSent);
        this.looper = looper;
        return this;
    }

    public PlayerMessage setPayload(@Nullable Object obj) {
        com.google.android.exoplayer2.util.a.g(!this.isSent);
        this.payload = obj;
        return this;
    }

    public PlayerMessage setPosition(long j10) {
        com.google.android.exoplayer2.util.a.g(!this.isSent);
        this.positionMs = j10;
        return this;
    }

    public PlayerMessage setType(int i10) {
        com.google.android.exoplayer2.util.a.g(!this.isSent);
        this.type = i10;
        return this;
    }

    public PlayerMessage setPosition(int i10, long j10) {
        com.google.android.exoplayer2.util.a.g(!this.isSent);
        com.google.android.exoplayer2.util.a.a(j10 != -9223372036854775807L);
        if (i10 >= 0 && (this.timeline.q() || i10 < this.timeline.p())) {
            this.windowIndex = i10;
            this.positionMs = j10;
            return this;
        }
        throw new IllegalSeekPositionException(this.timeline, i10, j10);
    }

    public synchronized boolean blockUntilDelivered(long j10) throws InterruptedException, TimeoutException {
        boolean z10;
        com.google.android.exoplayer2.util.a.g(this.isSent);
        com.google.android.exoplayer2.util.a.g(this.looper.getThread() != Thread.currentThread());
        long a10 = this.clock.a() + j10;
        while (true) {
            z10 = this.isProcessed;
            if (z10 || j10 <= 0) {
                break;
            }
            this.clock.c();
            wait(j10);
            j10 = a10 - this.clock.a();
        }
        if (!z10) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.isDelivered;
    }
}
