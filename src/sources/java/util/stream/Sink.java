package java.util.stream;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Sink<T> extends Consumer<T> {
    default void begin(long size) {
    }

    default void end() {
    }

    default boolean cancellationRequested() {
        return false;
    }

    default void accept(int value) {
        throw new IllegalStateException("called wrong accept method");
    }

    default void accept(long value) {
        throw new IllegalStateException("called wrong accept method");
    }

    default void accept(double value) {
        throw new IllegalStateException("called wrong accept method");
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfInt extends Sink<Integer>, IntConsumer {
        @Override // java.util.function.IntConsumer
        void accept(int i10);

        @Override // java.util.function.Consumer
        default void accept(Integer i10) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            }
            accept(i10.intValue());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfLong extends Sink<Long>, LongConsumer {
        @Override // java.util.function.LongConsumer
        void accept(long j10);

        @Override // java.util.function.Consumer
        default void accept(Long i10) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Sink.OfLong.accept(Long)");
            }
            accept(i10.longValue());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfDouble extends Sink<Double>, DoubleConsumer {
        @Override // java.util.stream.Sink, java.util.function.DoubleConsumer
        void accept(double d10);

        @Override // java.util.function.Consumer
        default void accept(Double i10) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            }
            accept(i10.doubleValue());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ChainedReference<T, E_OUT> implements Sink<T> {
        protected final Sink<? super E_OUT> downstream;

        public ChainedReference(Sink<? super E_OUT> downstream) {
            this.downstream = (Sink) Objects.requireNonNull(downstream);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.downstream.begin(size);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ChainedInt<E_OUT> implements OfInt {
        protected final Sink<? super E_OUT> downstream;

        public ChainedInt(Sink<? super E_OUT> downstream) {
            this.downstream = (Sink) Objects.requireNonNull(downstream);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.downstream.begin(size);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ChainedLong<E_OUT> implements OfLong {
        protected final Sink<? super E_OUT> downstream;

        public ChainedLong(Sink<? super E_OUT> downstream) {
            this.downstream = (Sink) Objects.requireNonNull(downstream);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.downstream.begin(size);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ChainedDouble<E_OUT> implements OfDouble {
        protected final Sink<? super E_OUT> downstream;

        public ChainedDouble(Sink<? super E_OUT> downstream) {
            this.downstream = (Sink) Objects.requireNonNull(downstream);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.downstream.begin(size);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }
    }
}
