package java.lang;

import java.lang.StackWalker;
import java.util.EnumSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
interface LiveStackFrame extends StackWalker.StackFrame {
    Object[] getLocals();

    Object[] getMonitors();

    Object[] getStack();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class PrimitiveSlot {
        public abstract int size();

        public int intValue() {
            throw new UnsupportedOperationException("this " + size() + "-byte primitive");
        }

        public long longValue() {
            throw new UnsupportedOperationException("this " + size() + "-byte primitive");
        }
    }

    static StackWalker getStackWalker() {
        return getStackWalker(EnumSet.noneOf(StackWalker.Option.class));
    }

    static StackWalker getStackWalker(Set<StackWalker.Option> options) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("liveStackFrames"));
        }
        return StackWalker.newInstance(options, StackWalker.ExtendedOption.LOCALS_AND_OPERANDS);
    }
}
