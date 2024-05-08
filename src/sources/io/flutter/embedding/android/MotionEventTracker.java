package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MotionEventTracker {
    private static MotionEventTracker INSTANCE = null;
    private static final String TAG = "MotionEventTracker";
    private final LongSparseArray<MotionEvent> eventById = new LongSparseArray<>();
    private final PriorityQueue<Long> unusedEvents = new PriorityQueue<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MotionEventId {
        private static final AtomicLong ID_COUNTER = new AtomicLong(0);

        /* renamed from: id, reason: collision with root package name */
        private final long f49936id;

        private MotionEventId(long j10) {
            this.f49936id = j10;
        }

        @NonNull
        public static MotionEventId createUnique() {
            return from(ID_COUNTER.incrementAndGet());
        }

        @NonNull
        public static MotionEventId from(long j10) {
            return new MotionEventId(j10);
        }

        public long getId() {
            return this.f49936id;
        }
    }

    private MotionEventTracker() {
    }

    @NonNull
    public static MotionEventTracker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MotionEventTracker();
        }
        return INSTANCE;
    }

    @Nullable
    public MotionEvent pop(@NonNull MotionEventId motionEventId) {
        while (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() < motionEventId.f49936id) {
            this.eventById.remove(this.unusedEvents.poll().longValue());
        }
        if (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() == motionEventId.f49936id) {
            this.unusedEvents.poll();
        }
        MotionEvent motionEvent = this.eventById.get(motionEventId.f49936id);
        this.eventById.remove(motionEventId.f49936id);
        return motionEvent;
    }

    @NonNull
    public MotionEventId track(@NonNull MotionEvent motionEvent) {
        MotionEventId createUnique = MotionEventId.createUnique();
        this.eventById.put(createUnique.f49936id, MotionEvent.obtain(motionEvent));
        this.unusedEvents.add(Long.valueOf(createUnique.f49936id));
        return createUnique;
    }
}
