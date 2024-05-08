package java.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>(null);
    private final T value;

    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    private Optional(T value) {
        this.value = value;
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(Objects.requireNonNull(value));
    }

    public static <T> Optional<T> ofNullable(T t2) {
        return t2 == null ? (Optional<T>) EMPTY : new Optional<>(t2);
    }

    public T get() {
        T t2 = this.value;
        if (t2 == null) {
            throw new NoSuchElementException("No value present");
        }
        return t2;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public void ifPresent(Consumer<? super T> consumer) {
        T t2 = this.value;
        if (t2 != null) {
            consumer.accept(t2);
        }
    }

    public void ifPresentOrElse(Consumer<? super T> consumer, Runnable runnable) {
        T t2 = this.value;
        if (t2 != null) {
            consumer.accept(t2);
        } else {
            runnable.run();
        }
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (isPresent()) {
            return predicate.test(this.value) ? this : empty();
        }
        return this;
    }

    public <U> Optional<U> map(Function<? super T, ? extends U> function) {
        Objects.requireNonNull(function);
        if (!isPresent()) {
            return empty();
        }
        return ofNullable(function.apply(this.value));
    }

    public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> function) {
        Objects.requireNonNull(function);
        if (!isPresent()) {
            return empty();
        }
        return (Optional) Objects.requireNonNull(function.apply(this.value));
    }

    public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier) {
        Objects.requireNonNull(supplier);
        if (isPresent()) {
            return this;
        }
        return (Optional) Objects.requireNonNull(supplier.get());
    }

    public Stream<T> stream() {
        if (!isPresent()) {
            return Stream.empty();
        }
        return Stream.of(this.value);
    }

    public T orElse(T other) {
        T t2 = this.value;
        return t2 != null ? t2 : other;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        T t2 = this.value;
        return t2 != null ? t2 : supplier.get();
    }

    public T orElseThrow() {
        T t2 = this.value;
        if (t2 == null) {
            throw new NoSuchElementException("No value present");
        }
        return t2;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws Throwable {
        T t2 = this.value;
        if (t2 != null) {
            return t2;
        }
        throw exceptionSupplier.get();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        Optional<?> other = (Optional) obj;
        return Objects.equals(this.value, other.value);
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    public String toString() {
        if (this.value != null) {
            return "Optional[" + ((Object) this.value) + "]";
        }
        return "Optional.empty";
    }
}
