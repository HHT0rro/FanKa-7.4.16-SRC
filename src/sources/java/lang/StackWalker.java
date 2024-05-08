package java.lang;

import java.lang.invoke.MethodType;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import jdk.internal.reflect.CallerSensitive;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StackWalker {
    static final EnumSet<Option> DEFAULT_EMPTY_OPTION;
    private static final StackWalker DEFAULT_WALKER;
    private final int estimateDepth;
    private final ExtendedOption extendedOption;
    private final Set<Option> options;
    final boolean retainClassRef;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    enum ExtendedOption {
        LOCALS_AND_OPERANDS
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Option {
        RETAIN_CLASS_REFERENCE,
        SHOW_REFLECT_FRAMES,
        SHOW_HIDDEN_FRAMES
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface StackFrame {
        int getByteCodeIndex();

        String getClassName();

        Class<?> getDeclaringClass();

        String getFileName();

        int getLineNumber();

        String getMethodName();

        boolean isNativeMethod();

        StackTraceElement toStackTraceElement();

        default MethodType getMethodType() {
            throw new UnsupportedOperationException();
        }

        default String getDescriptor() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        EnumSet<Option> noneOf = EnumSet.noneOf(Option.class);
        DEFAULT_EMPTY_OPTION = noneOf;
        DEFAULT_WALKER = new StackWalker(noneOf);
    }

    public static StackWalker getInstance() {
        return DEFAULT_WALKER;
    }

    public static StackWalker getInstance(Option option) {
        return getInstance(EnumSet.of((Option) Objects.requireNonNull(option)));
    }

    public static StackWalker getInstance(Set<Option> options) {
        if (options.isEmpty()) {
            return DEFAULT_WALKER;
        }
        EnumSet<Option> optionSet = toEnumSet(options);
        checkPermission(optionSet);
        return new StackWalker(optionSet);
    }

    public static StackWalker getInstance(Set<Option> options, int estimateDepth) {
        if (estimateDepth <= 0) {
            throw new IllegalArgumentException("estimateDepth must be > 0");
        }
        EnumSet<Option> optionSet = toEnumSet(options);
        checkPermission(optionSet);
        return new StackWalker(optionSet, estimateDepth);
    }

    private StackWalker(EnumSet<Option> options) {
        this(options, 0, null);
    }

    private StackWalker(EnumSet<Option> options, int estimateDepth) {
        this(options, estimateDepth, null);
    }

    private StackWalker(EnumSet<Option> options, int estimateDepth, ExtendedOption extendedOption) {
        this.options = options;
        this.estimateDepth = estimateDepth;
        this.extendedOption = extendedOption;
        this.retainClassRef = hasOption(Option.RETAIN_CLASS_REFERENCE);
    }

    private static void checkPermission(Set<Option> options) {
        Objects.requireNonNull(options);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null && options.contains(Option.RETAIN_CLASS_REFERENCE)) {
            sm.checkPermission(new RuntimePermission("getStackWalkerWithClassReference"));
        }
    }

    private static EnumSet<Option> toEnumSet(Set<Option> options) {
        Objects.requireNonNull(options);
        if (options.isEmpty()) {
            return DEFAULT_EMPTY_OPTION;
        }
        return EnumSet.copyOf((Collection) options);
    }

    @CallerSensitive
    public <T> T walk(Function<? super Stream<StackFrame>, ? extends T> function) {
        Objects.requireNonNull(function);
        return StackStreamFactory.makeStackTraverser(this, function).walk();
    }

    @CallerSensitive
    public void forEach(final Consumer<? super StackFrame> action) {
        Objects.requireNonNull(action);
        StackStreamFactory.makeStackTraverser(this, new Function() { // from class: java.lang.StackWalker$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return StackWalker.lambda$forEach$0(Consumer.this, (Stream) obj);
            }
        }).walk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$forEach$0(Consumer action, Stream s2) {
        s2.forEach(action);
        return null;
    }

    @CallerSensitive
    public Class<?> getCallerClass() {
        if (!this.retainClassRef) {
            throw new UnsupportedOperationException("This stack walker does not have RETAIN_CLASS_REFERENCE access");
        }
        return StackStreamFactory.makeCallerFinder(this).findCaller();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StackWalker newInstance(Set<Option> options, ExtendedOption extendedOption) {
        EnumSet<Option> optionSet = toEnumSet(options);
        checkPermission(optionSet);
        return new StackWalker(optionSet, 0, extendedOption);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int estimateDepth() {
        return this.estimateDepth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasOption(Option option) {
        return this.options.contains(option);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasLocalsOperandsOption() {
        return this.extendedOption == ExtendedOption.LOCALS_AND_OPERANDS;
    }
}
