package java.util;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class OptionalDouble {
    private static final OptionalDouble EMPTY = new OptionalDouble();
    private final boolean isPresent;
    private final double value;

    private OptionalDouble() {
        this.isPresent = false;
        this.value = Double.NaN;
    }

    public static OptionalDouble empty() {
        return EMPTY;
    }

    private OptionalDouble(double value) {
        this.isPresent = true;
        this.value = value;
    }

    public static OptionalDouble of(double value) {
        return new OptionalDouble(value);
    }

    public double getAsDouble() {
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

    public void ifPresent(DoubleConsumer action) {
        if (this.isPresent) {
            action.accept(this.value);
        }
    }

    public void ifPresentOrElse(DoubleConsumer action, Runnable emptyAction) {
        if (this.isPresent) {
            action.accept(this.value);
        } else {
            emptyAction.run();
        }
    }

    public DoubleStream stream() {
        if (this.isPresent) {
            return DoubleStream.of(this.value);
        }
        return DoubleStream.empty();
    }

    public double orElse(double other) {
        return this.isPresent ? this.value : other;
    }

    public double orElseGet(DoubleSupplier supplier) {
        return this.isPresent ? this.value : supplier.getAsDouble();
    }

    public double orElseThrow() {
        if (!this.isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }

    public <X extends Throwable> double orElseThrow(Supplier<? extends X> exceptionSupplier) throws Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw exceptionSupplier.get();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptionalDouble) {
            OptionalDouble other = (OptionalDouble) obj;
            boolean z10 = this.isPresent;
            if (z10 && other.isPresent) {
                if (Double.compare(this.value, other.value) == 0) {
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
            return Double.hashCode(this.value);
        }
        return 0;
    }

    public String toString() {
        if (this.isPresent) {
            return String.format("OptionalDouble[%s]", Double.valueOf(this.value));
        }
        return "OptionalDouble.empty";
    }
}
