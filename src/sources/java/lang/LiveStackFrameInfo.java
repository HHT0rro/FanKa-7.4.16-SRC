package java.lang;

import java.lang.LiveStackFrame;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class LiveStackFrameInfo extends StackFrameInfo implements LiveStackFrame {
    private static Object[] EMPTY_ARRAY = new Object[0];
    private static final int MODE_COMPILED = 2;
    private static final int MODE_INTERPRETED = 1;
    private Object[] locals;
    private int mode;
    private Object[] monitors;
    private Object[] operands;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveStackFrameInfo(StackWalker walker) {
        super(walker);
        Object[] objArr = EMPTY_ARRAY;
        this.monitors = objArr;
        this.locals = objArr;
        this.operands = objArr;
        this.mode = 0;
    }

    @Override // java.lang.LiveStackFrame
    public Object[] getMonitors() {
        return this.monitors;
    }

    @Override // java.lang.LiveStackFrame
    public Object[] getLocals() {
        return this.locals;
    }

    @Override // java.lang.LiveStackFrame
    public Object[] getStack() {
        return this.operands;
    }

    @Override // java.lang.StackFrameInfo
    public String toString() {
        StringBuilder retVal = new StringBuilder(super.toString());
        if (this.mode != 0) {
            retVal.append("(");
            if ((this.mode & 1) == 1) {
                retVal.append(" interpreted ");
            }
            if ((this.mode & 2) == 2) {
                retVal.append(" compiled ");
            }
            retVal.append(")");
        }
        return retVal.toString();
    }

    static LiveStackFrame.PrimitiveSlot asPrimitive(int value) {
        return new PrimitiveSlot32(value);
    }

    static LiveStackFrame.PrimitiveSlot asPrimitive(long value) {
        return new PrimitiveSlot64(value);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class PrimitiveSlot32 extends LiveStackFrame.PrimitiveSlot {
        final int value;

        PrimitiveSlot32(int value) {
            this.value = value;
        }

        @Override // java.lang.LiveStackFrame.PrimitiveSlot
        public int size() {
            return 4;
        }

        @Override // java.lang.LiveStackFrame.PrimitiveSlot
        public int intValue() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class PrimitiveSlot64 extends LiveStackFrame.PrimitiveSlot {
        final long value;

        PrimitiveSlot64(long value) {
            this.value = value;
        }

        @Override // java.lang.LiveStackFrame.PrimitiveSlot
        public int size() {
            return 8;
        }

        @Override // java.lang.LiveStackFrame.PrimitiveSlot
        public long longValue() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }
}
