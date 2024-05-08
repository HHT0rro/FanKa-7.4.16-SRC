package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    public boolean checkSubscriptionOnce;
    public long completions;
    public int establishedFusionMode;
    public int initialFusionMode;
    public Thread lastThread;
    public CharSequence tag;
    public boolean timeout;
    public final List<T> values = new VolatileSizeArrayList();
    public final List<Throwable> errors = new VolatileSizeArrayList();
    public final CountDownLatch done = new CountDownLatch(1);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum TestWaitStrategy implements Runnable {
        SPIN { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.1
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
            }
        },
        YIELD { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.2
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.3
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1);
            }
        },
        SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.4
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(10);
            }
        },
        SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.5
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(100);
            }
        },
        SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.6
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1000);
            }
        };

        public static void sleep(int i10) {
            try {
                Thread.sleep(i10);
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public static String valueAndClass(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    public final U assertComplete() {
        long j10 = this.completions;
        if (j10 == 0) {
            throw fail("Not completed");
        }
        if (j10 <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j10);
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    public final U assertErrorMessage(String str) {
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        }
        if (size == 1) {
            String message = this.errors.get(0).getMessage();
            if (ObjectHelper.equals(str, message)) {
                return this;
            }
            throw fail("Error message differs; exptected: " + str + " but was: " + message);
        }
        throw fail("Multiple errors");
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U assertNever(T t2) {
        int size = this.values.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (ObjectHelper.equals(this.values.get(i10), t2)) {
                throw fail("Value at position " + i10 + " is equal to " + valueAndClass(t2) + "; Expected them to be different");
            }
        }
        return this;
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + ((Object) this.errors));
    }

    public final U assertNoTimeout() {
        if (this.timeout) {
            throw fail("Timeout?!");
        }
        return this;
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertNotComplete() {
        long j10 = this.completions;
        if (j10 == 1) {
            throw fail("Completed!");
        }
        if (j10 <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j10);
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.done.getCount() != 0) {
            return this;
        }
        throw fail("Subscriber terminated!");
    }

    public final U assertResult(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.done.getCount() == 0) {
            long j10 = this.completions;
            if (j10 <= 1) {
                int size = this.errors.size();
                if (size > 1) {
                    throw fail("Terminated with multiple errors: " + size);
                }
                if (j10 == 0 || size == 0) {
                    return this;
                }
                throw fail("Terminated with multiple completions and errors: " + j10);
            }
            throw fail("Terminated with multiple completions: " + j10);
        }
        throw fail("Subscriber still running!");
    }

    public final U assertTimeout() {
        if (this.timeout) {
            return this;
        }
        throw fail("No timeout?!");
    }

    public final U assertValue(T t2) {
        if (this.values.size() == 1) {
            T t10 = this.values.get(0);
            if (ObjectHelper.equals(t2, t10)) {
                return this;
            }
            throw fail("expected: " + valueAndClass(t2) + " but was: " + valueAndClass(t10));
        }
        throw fail("expected: " + valueAndClass(t2) + " but was: " + ((Object) this.values));
    }

    public final U assertValueAt(int i10, T t2) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        }
        if (i10 < size) {
            T t10 = this.values.get(i10);
            if (ObjectHelper.equals(t2, t10)) {
                return this;
            }
            throw fail("expected: " + valueAndClass(t2) + " but was: " + valueAndClass(t10));
        }
        throw fail("Invalid index: " + i10);
    }

    public final U assertValueCount(int i10) {
        int size = this.values.size();
        if (size == i10) {
            return this;
        }
        throw fail("Value counts differ; expected: " + i10 + " but was: " + size);
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> iterator2 = this.values.iterator2();
        Iterator<? extends T> iterator22 = iterable.iterator2();
        int i10 = 0;
        while (true) {
            hasNext = iterator22.hasNext();
            hasNext2 = iterator2.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = iterator22.next();
            T next2 = iterator2.next();
            if (!ObjectHelper.equals(next, next2)) {
                throw fail("Values at position " + i10 + " differ; expected: " + valueAndClass(next) + " but was: " + valueAndClass(next2));
            }
            i10++;
        }
        if (hasNext2) {
            throw fail("More values received than expected (" + i10 + ")");
        }
        if (!hasNext) {
            return this;
        }
        throw fail("Fewer values received than expected (" + i10 + ")");
    }

    public final U assertValueSequenceOnly(Iterable<? extends T> iterable) {
        return (U) assertSubscribed().assertValueSequence(iterable).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (T t2 : this.values) {
            if (!collection.contains(t2)) {
                throw fail("Value not in the expected collection: " + valueAndClass(t2));
            }
        }
        return this;
    }

    public final U assertValueSetOnly(Collection<? extends T> collection) {
        return (U) assertSubscribed().assertValueSet(collection).assertNoErrors().assertNotComplete();
    }

    public final U assertValues(T... tArr) {
        int size = this.values.size();
        if (size != tArr.length) {
            throw fail("Value count differs; expected: " + tArr.length + " " + Arrays.toString(tArr) + " but was: " + size + " " + ((Object) this.values));
        }
        for (int i10 = 0; i10 < size; i10++) {
            T t2 = this.values.get(i10);
            T t10 = tArr[i10];
            if (!ObjectHelper.equals(t10, t2)) {
                throw fail("Values at position " + i10 + " differ; expected: " + valueAndClass(t10) + " but was: " + valueAndClass(t2));
            }
        }
        return this;
    }

    public final U assertValuesOnly(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final U awaitCount(int i10) {
        return awaitCount(i10, TestWaitStrategy.SLEEP_10MS, 5000L);
    }

    public final U awaitDone(long j10, TimeUnit timeUnit) {
        try {
            if (!this.done.await(j10, timeUnit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e2) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e2);
        }
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U clearTimeout() {
        this.timeout = false;
        return this;
    }

    public final long completions() {
        return this.completions;
    }

    public final int errorCount() {
        return this.errors.size();
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    public final AssertionError fail(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append(str);
        sb2.append(" (");
        sb2.append("latch = ");
        sb2.append(this.done.getCount());
        sb2.append(", ");
        sb2.append("values = ");
        sb2.append(this.values.size());
        sb2.append(", ");
        sb2.append("errors = ");
        sb2.append(this.errors.size());
        sb2.append(", ");
        sb2.append("completions = ");
        sb2.append(this.completions);
        if (this.timeout) {
            sb2.append(", timeout!");
        }
        if (isDisposed()) {
            sb2.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb2.append(", tag = ");
            sb2.append(charSequence);
        }
        sb2.append(')');
        AssertionError assertionError = new AssertionError((Object) sb2.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.errors));
            }
        }
        return assertionError;
    }

    public final List<List<Object>> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        ArrayList arrayList2 = new ArrayList();
        for (long j10 = 0; j10 < this.completions; j10++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean isTerminated() {
        return this.done.getCount() == 0;
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final List<T> values() {
        return this.values;
    }

    public final U withTag(CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    public final U awaitCount(int i10, Runnable runnable) {
        return awaitCount(i10, runnable, 5000L);
    }

    public final U assertError(Predicate<Throwable> predicate) {
        int size = this.errors.size();
        if (size != 0) {
            boolean z10 = false;
            Iterator<Throwable> iterator2 = this.errors.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                try {
                    if (predicate.test(iterator2.next())) {
                        z10 = true;
                        break;
                    }
                } catch (Exception e2) {
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            if (!z10) {
                throw fail("Error not present");
            }
            if (size == 1) {
                return this;
            }
            throw fail("Error present but other errors as well");
        }
        throw fail("No errors");
    }

    public final boolean await(long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean z10 = this.done.getCount() == 0 || this.done.await(j10, timeUnit);
        this.timeout = !z10;
        return z10;
    }

    public final U awaitCount(int i10, Runnable runnable, long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j10 > 0 && System.currentTimeMillis() - currentTimeMillis >= j10) {
                this.timeout = true;
                break;
            }
            if (this.done.getCount() == 0 || this.values.size() >= i10) {
                break;
            }
            runnable.run();
        }
        return this;
    }

    public final boolean awaitTerminalEvent(long j10, TimeUnit timeUnit) {
        try {
            return await(j10, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    public final U assertNever(Predicate<? super T> predicate) {
        int size = this.values.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                if (predicate.test(this.values.get(i10))) {
                    throw fail("Value at position " + i10 + " matches predicate " + predicate.toString() + ", which was not expected.");
                }
            } catch (Exception e2) {
                throw ExceptionHelper.wrapOrThrow(e2);
            }
        }
        return this;
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, (Predicate) predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    public final U assertValueAt(int i10, Predicate<T> predicate) {
        if (this.values.size() != 0) {
            if (i10 < this.values.size()) {
                try {
                    if (predicate.test(this.values.get(i10))) {
                        return this;
                    }
                    throw fail("Value not present");
                } catch (Exception e2) {
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            throw fail("Invalid index: " + i10);
        }
        throw fail("No values");
    }
}
