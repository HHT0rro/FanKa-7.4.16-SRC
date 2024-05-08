package java.util.stream;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;
import java.util.stream.SpinedBuffer;
import java.util.stream.StreamSpliterators;
import java.util.stream.Streams;
import java.util.stream.WhileOps;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Stream<T> extends BaseStream<T, Stream<T>> {
    boolean allMatch(Predicate<? super T> predicate);

    boolean anyMatch(Predicate<? super T> predicate);

    <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> biConsumer, BiConsumer<R, R> biConsumer2);

    <R, A> R collect(Collector<? super T, A, R> collector);

    long count();

    Stream<T> distinct();

    Stream<T> filter(Predicate<? super T> predicate);

    Optional<T> findAny();

    Optional<T> findFirst();

    <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> function);

    DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> function);

    IntStream flatMapToInt(Function<? super T, ? extends IntStream> function);

    LongStream flatMapToLong(Function<? super T, ? extends LongStream> function);

    void forEach(Consumer<? super T> consumer);

    void forEachOrdered(Consumer<? super T> consumer);

    Stream<T> limit(long j10);

    <R> Stream<R> map(Function<? super T, ? extends R> function);

    DoubleStream mapToDouble(ToDoubleFunction<? super T> toDoubleFunction);

    IntStream mapToInt(ToIntFunction<? super T> toIntFunction);

    LongStream mapToLong(ToLongFunction<? super T> toLongFunction);

    Optional<T> max(Comparator<? super T> comparator);

    Optional<T> min(Comparator<? super T> comparator);

    boolean noneMatch(Predicate<? super T> predicate);

    Stream<T> peek(Consumer<? super T> consumer);

    <U> U reduce(U u10, BiFunction<U, ? super T, U> biFunction, BinaryOperator<U> binaryOperator);

    T reduce(T t2, BinaryOperator<T> binaryOperator);

    Optional<T> reduce(BinaryOperator<T> binaryOperator);

    Stream<T> skip(long j10);

    Stream<T> sorted();

    Stream<T> sorted(Comparator<? super T> comparator);

    Object[] toArray();

    <A> A[] toArray(IntFunction<A[]> intFunction);

    default <R> Stream<R> mapMulti(final BiConsumer<? super T, ? super Consumer<R>> mapper) {
        Objects.requireNonNull(mapper);
        return flatMap(new Function() { // from class: java.util.stream.Stream$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Stream.lambda$mapMulti$0(BiConsumer.this, obj);
            }
        });
    }

    static /* synthetic */ Stream lambda$mapMulti$0(BiConsumer mapper, Object e2) {
        SpinedBuffer spinedBuffer = new SpinedBuffer();
        mapper.accept(e2, spinedBuffer);
        return StreamSupport.stream(spinedBuffer.spliterator(), false);
    }

    default IntStream mapMultiToInt(final BiConsumer<? super T, ? super IntConsumer> mapper) {
        Objects.requireNonNull(mapper);
        return flatMapToInt(new Function() { // from class: java.util.stream.Stream$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Stream.lambda$mapMultiToInt$1(BiConsumer.this, obj);
            }
        });
    }

    static /* synthetic */ IntStream lambda$mapMultiToInt$1(BiConsumer mapper, Object e2) {
        SpinedBuffer.OfInt buffer = new SpinedBuffer.OfInt();
        mapper.accept(e2, buffer);
        return StreamSupport.intStream(buffer.spliterator(), false);
    }

    default LongStream mapMultiToLong(final BiConsumer<? super T, ? super LongConsumer> mapper) {
        Objects.requireNonNull(mapper);
        return flatMapToLong(new Function() { // from class: java.util.stream.Stream$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Stream.lambda$mapMultiToLong$2(BiConsumer.this, obj);
            }
        });
    }

    static /* synthetic */ LongStream lambda$mapMultiToLong$2(BiConsumer mapper, Object e2) {
        SpinedBuffer.OfLong buffer = new SpinedBuffer.OfLong();
        mapper.accept(e2, buffer);
        return StreamSupport.longStream(buffer.spliterator(), false);
    }

    default DoubleStream mapMultiToDouble(final BiConsumer<? super T, ? super DoubleConsumer> mapper) {
        Objects.requireNonNull(mapper);
        return flatMapToDouble(new Function() { // from class: java.util.stream.Stream$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Stream.lambda$mapMultiToDouble$3(BiConsumer.this, obj);
            }
        });
    }

    static /* synthetic */ DoubleStream lambda$mapMultiToDouble$3(BiConsumer mapper, Object e2) {
        SpinedBuffer.OfDouble buffer = new SpinedBuffer.OfDouble();
        mapper.accept(e2, buffer);
        return StreamSupport.doubleStream(buffer.spliterator(), false);
    }

    default Stream<T> takeWhile(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return StreamSupport.stream(new WhileOps.UnorderedWhileSpliterator.OfRef.Taking(spliterator2(), true, predicate), isParallel()).onClose(new Stream$$ExternalSyntheticLambda1(this));
    }

    default Stream<T> dropWhile(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return StreamSupport.stream(new WhileOps.UnorderedWhileSpliterator.OfRef.Dropping(spliterator2(), true, predicate), isParallel()).onClose(new Stream$$ExternalSyntheticLambda1(this));
    }

    default List<T> toList() {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(toArray())));
    }

    static <T> Builder<T> builder() {
        return new Streams.StreamBuilderImpl();
    }

    static <T> Stream<T> empty() {
        return StreamSupport.stream(Spliterators.emptySpliterator(), false);
    }

    static <T> Stream<T> of(T t2) {
        return StreamSupport.stream(new Streams.StreamBuilderImpl(t2), false);
    }

    static <T> Stream<T> ofNullable(T t2) {
        return t2 == null ? empty() : StreamSupport.stream(new Streams.StreamBuilderImpl(t2), false);
    }

    @SafeVarargs
    static <T> Stream<T> of(T... values) {
        return Arrays.stream(values);
    }

    static <T> Stream<T> iterate(final T seed, final UnaryOperator<T> f10) {
        Objects.requireNonNull(f10);
        Spliterator<T> spliterator = new Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO) { // from class: java.util.stream.Stream.1
            T prev;
            boolean started;

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> consumer) {
                T t2;
                Objects.requireNonNull(consumer);
                if (this.started) {
                    t2 = f10.apply(this.prev);
                } else {
                    t2 = (T) seed;
                    this.started = true;
                }
                this.prev = t2;
                consumer.accept(t2);
                return true;
            }
        };
        return StreamSupport.stream(spliterator, false);
    }

    static <T> Stream<T> iterate(final T seed, final Predicate<? super T> hasNext, final UnaryOperator<T> next) {
        Objects.requireNonNull(next);
        Objects.requireNonNull(hasNext);
        Spliterator<T> spliterator = new Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO) { // from class: java.util.stream.Stream.2
            boolean finished;
            T prev;
            boolean started;

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> consumer) {
                T t2;
                Objects.requireNonNull(consumer);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    t2 = next.apply(this.prev);
                } else {
                    t2 = (T) seed;
                    this.started = true;
                }
                if (!hasNext.test(t2)) {
                    this.prev = null;
                    this.finished = true;
                    return false;
                }
                this.prev = t2;
                consumer.accept(t2);
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Spliterator
            public void forEachRemaining(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                Object apply = this.started ? next.apply(this.prev) : seed;
                this.prev = null;
                while (hasNext.test(apply)) {
                    action.accept(apply);
                    apply = next.apply(apply);
                }
            }
        };
        return StreamSupport.stream(spliterator, false);
    }

    static <T> Stream<T> generate(Supplier<? extends T> s2) {
        Objects.requireNonNull(s2);
        return StreamSupport.stream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfRef(Long.MAX_VALUE, s2), false);
    }

    static <T> Stream<T> concat(Stream<? extends T> a10, Stream<? extends T> b4) {
        Objects.requireNonNull(a10);
        Objects.requireNonNull(b4);
        Spliterator<T> split = new Streams.ConcatSpliterator.OfRef<>(a10.spliterator2(), b4.spliterator2());
        Stream<T> stream = StreamSupport.stream(split, a10.isParallel() || b4.isParallel());
        return stream.onClose(Streams.composedClose(a10, b4));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Builder<T> extends Consumer<T> {
        @Override // java.util.function.Consumer
        void accept(T t2);

        Stream<T> build();

        default Builder<T> add(T t2) {
            accept(t2);
            return this;
        }
    }
}
