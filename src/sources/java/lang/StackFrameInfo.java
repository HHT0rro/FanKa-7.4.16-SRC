package java.lang;

import java.lang.StackWalker;
import java.lang.invoke.MethodType;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StackFrameInfo implements StackWalker.StackFrame {
    private int bci;
    private Class<?> declaringClass;
    private String fileName;
    private int lineNumber;
    private String methodName;
    private MethodType methodType;
    private final boolean retainClassRef;
    private volatile StackTraceElement ste;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackFrameInfo(StackWalker walker) {
        this.retainClassRef = walker.retainClassRef;
    }

    StackFrameInfo(boolean retainClassRef) {
        this.retainClassRef = retainClassRef;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> declaringClass() {
        return this.declaringClass;
    }

    @Override // java.lang.StackWalker.StackFrame
    public String getClassName() {
        return declaringClass().getName();
    }

    @Override // java.lang.StackWalker.StackFrame
    public Class<?> getDeclaringClass() {
        ensureRetainClassRefEnabled();
        return declaringClass();
    }

    @Override // java.lang.StackWalker.StackFrame
    public String getMethodName() {
        return this.methodName;
    }

    @Override // java.lang.StackWalker.StackFrame
    public MethodType getMethodType() {
        ensureRetainClassRefEnabled();
        return this.methodType;
    }

    @Override // java.lang.StackWalker.StackFrame
    public String getDescriptor() {
        return this.methodType.toMethodDescriptorString();
    }

    @Override // java.lang.StackWalker.StackFrame
    public int getByteCodeIndex() {
        if (isNativeMethod()) {
            return -1;
        }
        return this.bci;
    }

    @Override // java.lang.StackWalker.StackFrame
    public String getFileName() {
        return this.fileName;
    }

    @Override // java.lang.StackWalker.StackFrame
    public int getLineNumber() {
        if (isNativeMethod()) {
            return -2;
        }
        return this.lineNumber;
    }

    @Override // java.lang.StackWalker.StackFrame
    public boolean isNativeMethod() {
        return this.lineNumber == -2;
    }

    public String toString() {
        return toStackTraceElement().toString();
    }

    @Override // java.lang.StackWalker.StackFrame
    public StackTraceElement toStackTraceElement() {
        StackTraceElement s2 = this.ste;
        if (s2 == null) {
            synchronized (this) {
                s2 = this.ste;
                if (s2 == null) {
                    StackTraceElement of = StackTraceElement.of(this);
                    s2 = of;
                    this.ste = of;
                }
            }
        }
        return s2;
    }

    private void ensureRetainClassRefEnabled() {
        if (!this.retainClassRef) {
            throw new UnsupportedOperationException("No access to RETAIN_CLASS_REFERENCE");
        }
    }
}
