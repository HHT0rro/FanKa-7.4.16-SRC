package org.apache.commons.lang3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Functions {

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailableBiConsumer<O1, O2, T extends Throwable> {
        void accept(O1 o12, O2 o22) throws Throwable;
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailableBiFunction<I1, I2, O, T extends Throwable> {
        O apply(I1 i12, I2 i22) throws Throwable;
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailableBiPredicate<O1, O2, T extends Throwable> {
        boolean test(O1 o12, O2 o22) throws Throwable;
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailableCallable<O, T extends Throwable> {
        O call() throws Throwable;
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailableConsumer<O, T extends Throwable> {
        void accept(O o10) throws Throwable;
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailableFunction<I, O, T extends Throwable> {
        O apply(I i10) throws Throwable;
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailablePredicate<O, T extends Throwable> {
        boolean test(O o10) throws Throwable;
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface FailableRunnable<T extends Throwable> {
        void run() throws Throwable;
    }

    public static <O, T extends Throwable> void accept(FailableConsumer<O, T> failableConsumer, O o10) {
        try {
            failableConsumer.accept(o10);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> failableFunction, I i10) {
        try {
            return failableFunction.apply(i10);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O, T extends Throwable> O call(FailableCallable<O, T> failableCallable) {
        try {
            return failableCallable.call();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static RuntimeException rethrow(Throwable th) {
        Objects.requireNonNull(th, "The Throwable must not be null.");
        if (!(th instanceof RuntimeException)) {
            if (!(th instanceof Error)) {
                if (th instanceof IOException) {
                    throw new UncheckedIOException((IOException) th);
                }
                throw new UndeclaredThrowableException(th);
            }
            throw ((Error) th);
        }
        throw ((RuntimeException) th);
    }

    public static <T extends Throwable> void run(FailableRunnable<T> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> failablePredicate, O o10) {
        try {
            return failablePredicate.test(o10);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            failableConsumer = new FailableConsumer() { // from class: org.apache.commons.lang3.a
                @Override // org.apache.commons.lang3.Functions.FailableConsumer
                public final void accept(Object obj) {
                    Functions.rethrow((Throwable) obj);
                }
            };
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable2 : failableRunnableArr) {
                Objects.requireNonNull(failableRunnable2, "A resource action must not be null.");
            }
        }
        Throwable th = null;
        try {
            failableRunnable.run();
        } catch (Throwable th2) {
            th = th2;
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable3 : failableRunnableArr) {
                try {
                    failableRunnable3.run();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    }
                }
            }
        }
        if (th != null) {
            try {
                failableConsumer.accept(th);
            } catch (Throwable th4) {
                throw rethrow(th4);
            }
        }
    }

    public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> failableBiConsumer, O1 o12, O2 o22) {
        try {
            failableBiConsumer.accept(o12, o22);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <I1, I2, O, T extends Throwable> O apply(FailableBiFunction<I1, I2, O, T> failableBiFunction, I1 i12, I2 i22) {
        try {
            return failableBiFunction.apply(i12, i22);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> failableBiPredicate, O1 o12, O2 o22) {
        try {
            return failableBiPredicate.test(o12, o22);
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, null, failableRunnableArr);
    }
}
