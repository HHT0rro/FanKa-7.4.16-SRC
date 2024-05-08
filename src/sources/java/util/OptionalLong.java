package java.util;

import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.LongStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class OptionalLong {
    private static final OptionalLong EMPTY = new OptionalLong();
    private final boolean isPresent;
    private final long value;

    private OptionalLong() {
        this.isPresent = false;
        this.value = 0L;
    }

    public static OptionalLong empty() {
        return EMPTY;
    }

    private OptionalLong(long value) {
        this.isPresent = true;
        this.value = value;
    }

    public static OptionalLong of(long value) {
        return new OptionalLong(value);
    }

    public long getAsLong() {
        if (!this.isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(LongConsumer action) {
        if (this.isPresent) {
            action.accept(this.value);
        }
    }

    public void ifPresentOrElse(LongConsumer action, Runnable emptyAction) {
        if (this.isPresent) {
            action.accept(this.value);
        } else {
            emptyAction.run();
        }
    }

    public LongStream stream() {
        if (this.isPresent) {
            return LongStream.of(this.value);
        }
        return LongStream.empty();
    }

    public long orElse(long other) {
        return this.isPresent ? this.value : other;
    }

    public long orElseGet(LongSupplier supplier) {
        return this.isPresent ? this.value : supplier.getAsLong();
    }

    public long orElseThrow() {
        if (!this.isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }

    public <X extends Throwable> long orElseThrow(Supplier<? extends X> exceptionSupplier) throws Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw exceptionSupplier.get();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptionalLong) {
            OptionalLong other = (OptionalLong) obj;
            boolean z10 = this.isPresent;
            if (z10 && other.isPresent) {
                if (this.value == other.value) {
                    return true;
                }
            } else if (z10 == other.isPresent) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.isPresent) {
            return Long.hashCode(this.value);
        }
        return 0;
    }

    public String toString() {
        if (this.isPresent) {
            return String.format("OptionalLong[%s]", Long.valueOf(this.value));
        }
        return "OptionalLong.empty";
    }
}
