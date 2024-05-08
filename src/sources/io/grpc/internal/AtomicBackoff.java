package io.grpc.internal;

import com.google.common.base.o;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AtomicBackoff {
    private static final Logger log = Logger.getLogger(AtomicBackoff.class.getName());
    private final String name;
    private final AtomicLong value;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class State {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final long savedValue;

        public void backoff() {
            long j10 = this.savedValue;
            long max = Math.max(2 * j10, j10);
            if (AtomicBackoff.this.value.compareAndSet(this.savedValue, max)) {
                AtomicBackoff.log.log(Level.WARNING, "Increased {0} to {1}", new Object[]{AtomicBackoff.this.name, Long.valueOf(max)});
            }
        }

        public long get() {
            return this.savedValue;
        }

        private State(long j10) {
            this.savedValue = j10;
        }
    }

    public AtomicBackoff(String str, long j10) {
        AtomicLong atomicLong = new AtomicLong();
        this.value = atomicLong;
        o.e(j10 > 0, "value must be positive");
        this.name = str;
        atomicLong.set(j10);
    }

    public State getState() {
        return new State(this.value.get());
    }
}
