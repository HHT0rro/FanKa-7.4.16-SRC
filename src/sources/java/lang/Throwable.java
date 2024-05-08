package java.lang;

import dalvik.annotation.optimization.FastNative;
import dalvik.annotation.optimization.NeverInline;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import libcore.util.EmptyArray;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Throwable implements Serializable {
    private static final String CAUSE_CAPTION = "Caused by: ";
    private static Throwable[] EMPTY_THROWABLE_ARRAY = null;
    private static final String NULL_CAUSE_MESSAGE = "Cannot suppress a null exception.";
    private static final String SELF_SUPPRESSION_MESSAGE = "Self-suppression not permitted";
    private static final String SUPPRESSED_CAPTION = "Suppressed: ";
    private static final long serialVersionUID = -3042686055658047285L;
    private transient Object backtrace;
    private Throwable cause;
    private String detailMessage;
    private StackTraceElement[] stackTrace;
    private List<Throwable> suppressedExceptions;

    @FastNative
    private static native Object nativeFillInStackTrace();

    @FastNative
    private static native StackTraceElement[] nativeGetStackTrace(Object obj);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SentinelHolder {
        public static final StackTraceElement STACK_TRACE_ELEMENT_SENTINEL;
        public static final StackTraceElement[] STACK_TRACE_SENTINEL;

        private SentinelHolder() {
        }

        static {
            StackTraceElement stackTraceElement = new StackTraceElement("", "", null, Integer.MIN_VALUE);
            STACK_TRACE_ELEMENT_SENTINEL = stackTraceElement;
            STACK_TRACE_SENTINEL = new StackTraceElement[]{stackTraceElement};
        }
    }

    public Throwable() {
        this.cause = this;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        this.suppressedExceptions = Collections.emptyList();
        fillInStackTrace();
    }

    public Throwable(String message) {
        this.cause = this;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        this.suppressedExceptions = Collections.emptyList();
        fillInStackTrace();
        this.detailMessage = message;
    }

    public Throwable(String message, Throwable cause) {
        this.cause = this;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        this.suppressedExceptions = Collections.emptyList();
        fillInStackTrace();
        this.detailMessage = message;
        this.cause = cause;
    }

    public Throwable(Throwable cause) {
        this.cause = this;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        this.suppressedExceptions = Collections.emptyList();
        fillInStackTrace();
        this.detailMessage = cause == null ? null : cause.toString();
        this.cause = cause;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Throwable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        this.cause = this;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        this.suppressedExceptions = Collections.emptyList();
        if (writableStackTrace) {
            fillInStackTrace();
        } else {
            this.stackTrace = null;
        }
        this.detailMessage = message;
        this.cause = cause;
        if (!enableSuppression) {
            this.suppressedExceptions = null;
        }
    }

    public String getMessage() {
        return this.detailMessage;
    }

    public String getLocalizedMessage() {
        return getMessage();
    }

    public synchronized Throwable getCause() {
        Throwable th;
        th = this.cause;
        if (th == this) {
            th = null;
        }
        return th;
    }

    public synchronized Throwable initCause(Throwable cause) {
        if (this.cause != this) {
            throw new IllegalStateException("Can't overwrite cause with " + Objects.toString(cause, "a null"), this);
        }
        if (cause == this) {
            throw new IllegalArgumentException("Self-causation not permitted", this);
        }
        this.cause = cause;
        return this;
    }

    final void setCause(Throwable t2) {
        this.cause = t2;
    }

    public String toString() {
        String s2 = getClass().getName();
        String message = getLocalizedMessage();
        return message != null ? s2 + ": " + message : s2;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream s2) {
        printStackTrace(new WrappedPrintStream(s2));
    }

    private void printStackTrace(PrintStreamOrWriter s2) {
        Set<Throwable> dejaVu = Collections.newSetFromMap(new IdentityHashMap());
        dejaVu.add(this);
        synchronized (s2.lock()) {
            s2.println(this);
            StackTraceElement[] trace = getOurStackTrace();
            for (StackTraceElement traceElement : trace) {
                s2.println("\tat " + ((Object) traceElement));
            }
            for (Throwable se : getSuppressed()) {
                se.printEnclosedStackTrace(s2, trace, SUPPRESSED_CAPTION, "\t", dejaVu);
            }
            Throwable ourCause = getCause();
            if (ourCause != null) {
                ourCause.printEnclosedStackTrace(s2, trace, CAUSE_CAPTION, "", dejaVu);
            }
        }
    }

    private void printEnclosedStackTrace(PrintStreamOrWriter s2, StackTraceElement[] enclosingTrace, String caption, String prefix, Set<Throwable> dejaVu) {
        if (dejaVu.contains(this)) {
            s2.println(prefix + caption + "[CIRCULAR REFERENCE: " + ((Object) this) + "]");
            return;
        }
        dejaVu.add(this);
        StackTraceElement[] trace = getOurStackTrace();
        int m10 = trace.length - 1;
        int m11 = m10;
        for (int n10 = enclosingTrace.length - 1; m11 >= 0 && n10 >= 0 && trace[m11].equals(enclosingTrace[n10]); n10--) {
            m11--;
        }
        int framesInCommon = (trace.length - 1) - m11;
        s2.println(prefix + caption + ((Object) this));
        for (int i10 = 0; i10 <= m11; i10++) {
            s2.println(prefix + "\tat " + ((Object) trace[i10]));
        }
        if (framesInCommon != 0) {
            s2.println(prefix + "\t... " + framesInCommon + " more");
        }
        Throwable[] suppressed = getSuppressed();
        int length = suppressed.length;
        int i11 = 0;
        while (i11 < length) {
            Throwable se = suppressed[i11];
            se.printEnclosedStackTrace(s2, trace, SUPPRESSED_CAPTION, prefix + "\t", dejaVu);
            i11++;
            length = length;
            suppressed = suppressed;
        }
        Throwable ourCause = getCause();
        if (ourCause != null) {
            ourCause.printEnclosedStackTrace(s2, trace, CAUSE_CAPTION, prefix, dejaVu);
        }
    }

    public void printStackTrace(PrintWriter s2) {
        printStackTrace(new WrappedPrintWriter(s2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class PrintStreamOrWriter {
        abstract Object lock();

        abstract void println(Object obj);

        private PrintStreamOrWriter() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream) {
            super();
            this.printStream = printStream;
        }

        @Override // java.lang.Throwable.PrintStreamOrWriter
        Object lock() {
            return this.printStream;
        }

        @Override // java.lang.Throwable.PrintStreamOrWriter
        void println(Object o10) {
            this.printStream.println(o10);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter) {
            super();
            this.printWriter = printWriter;
        }

        @Override // java.lang.Throwable.PrintStreamOrWriter
        Object lock() {
            return this.printWriter;
        }

        @Override // java.lang.Throwable.PrintStreamOrWriter
        void println(Object o10) {
            this.printWriter.println(o10);
        }
    }

    @NeverInline
    public synchronized Throwable fillInStackTrace() {
        if (this.stackTrace != null || this.backtrace != null) {
            this.backtrace = nativeFillInStackTrace();
            this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        }
        return this;
    }

    public StackTraceElement[] getStackTrace() {
        return (StackTraceElement[]) getOurStackTrace().clone();
    }

    private synchronized StackTraceElement[] getOurStackTrace() {
        StackTraceElement[] stackTraceElementArr;
        if (this.stackTrace != EmptyArray.STACK_TRACE_ELEMENT && ((stackTraceElementArr = this.stackTrace) != null || this.backtrace == null)) {
            if (stackTraceElementArr == null) {
                return EmptyArray.STACK_TRACE_ELEMENT;
            }
            return this.stackTrace;
        }
        StackTraceElement[] nativeGetStackTrace = nativeGetStackTrace(this.backtrace);
        this.stackTrace = nativeGetStackTrace;
        this.backtrace = null;
        if (nativeGetStackTrace == null) {
            return EmptyArray.STACK_TRACE_ELEMENT;
        }
        return this.stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        StackTraceElement[] defensiveCopy = (StackTraceElement[]) stackTrace.clone();
        for (int i10 = 0; i10 < defensiveCopy.length; i10++) {
            if (defensiveCopy[i10] == null) {
                throw new NullPointerException("stackTrace[" + i10 + "]");
            }
        }
        synchronized (this) {
            if (this.stackTrace == null && this.backtrace == null) {
                return;
            }
            this.stackTrace = defensiveCopy;
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        List<Throwable> candidateSuppressedExceptions = this.suppressedExceptions;
        this.suppressedExceptions = Collections.emptyList();
        StackTraceElement[] candidateStackTrace = this.stackTrace;
        this.stackTrace = new StackTraceElement[0];
        if (candidateSuppressedExceptions != null) {
            int suppressedSize = validateSuppressedExceptionsList(candidateSuppressedExceptions);
            if (suppressedSize > 0) {
                ArrayList<Throwable> suppList = new ArrayList<>(Math.min(100, suppressedSize));
                for (Throwable t2 : candidateSuppressedExceptions) {
                    Objects.requireNonNull(t2, NULL_CAUSE_MESSAGE);
                    if (t2 == this) {
                        throw new IllegalArgumentException(SELF_SUPPRESSION_MESSAGE);
                    }
                    suppList.add(t2);
                }
                this.suppressedExceptions = suppList;
            }
        } else {
            this.suppressedExceptions = null;
        }
        if (candidateStackTrace != null) {
            StackTraceElement[] candidateStackTrace2 = (StackTraceElement[]) candidateStackTrace.clone();
            if (candidateStackTrace2.length >= 1) {
                if (candidateStackTrace2.length == 1 && SentinelHolder.STACK_TRACE_ELEMENT_SENTINEL.equals(candidateStackTrace2[0])) {
                    this.stackTrace = null;
                    return;
                }
                for (StackTraceElement ste : candidateStackTrace2) {
                    Objects.requireNonNull(ste, "null StackTraceElement in serial stream.");
                }
                this.stackTrace = candidateStackTrace2;
            }
        }
    }

    private int validateSuppressedExceptionsList(List<Throwable> deserSuppressedExceptions) throws IOException {
        int size = deserSuppressedExceptions.size();
        if (size < 0) {
            throw new StreamCorruptedException("Negative list size reported.");
        }
        return size;
    }

    private synchronized void writeObject(ObjectOutputStream s2) throws IOException {
        getOurStackTrace();
        StackTraceElement[] oldStackTrace = this.stackTrace;
        if (oldStackTrace == null) {
            try {
                this.stackTrace = SentinelHolder.STACK_TRACE_SENTINEL;
            } catch (Throwable th) {
                th = th;
                this.stackTrace = oldStackTrace;
                throw th;
            }
        }
        try {
            s2.defaultWriteObject();
            this.stackTrace = oldStackTrace;
        } catch (Throwable th2) {
            th = th2;
            this.stackTrace = oldStackTrace;
            throw th;
        }
    }

    public final synchronized void addSuppressed(Throwable exception) {
        if (exception == this) {
            throw new IllegalArgumentException(SELF_SUPPRESSION_MESSAGE, exception);
        }
        Objects.requireNonNull(exception, NULL_CAUSE_MESSAGE);
        List<Throwable> list = this.suppressedExceptions;
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            this.suppressedExceptions = new ArrayList(1);
        }
        this.suppressedExceptions.add(exception);
    }

    public final synchronized Throwable[] getSuppressed() {
        if (EMPTY_THROWABLE_ARRAY == null) {
            EMPTY_THROWABLE_ARRAY = new Throwable[0];
        }
        List<Throwable> list = this.suppressedExceptions;
        if (list != null && !list.isEmpty()) {
            return (Throwable[]) this.suppressedExceptions.toArray(EMPTY_THROWABLE_ARRAY);
        }
        return EMPTY_THROWABLE_ARRAY;
    }
}
