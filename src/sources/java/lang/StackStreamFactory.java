package java.lang;

import dalvik.annotation.optimization.FastNative;
import java.lang.StackWalker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StackStreamFactory {
    private static final int BATCH_SIZE = 32;
    private static final int DEFAULT_MODE = 0;
    private static final int FILL_CLASS_REFS_ONLY = 2;
    private static final int FILL_LIVE_STACK_FRAMES = 256;
    private static final int GET_CALLER_CLASS = 4;
    private static final int LARGE_BATCH_SIZE = 256;
    private static final int MIN_BATCH_SIZE = 8;
    private static final int SHOW_HIDDEN_FRAMES = 32;
    private static final int SMALL_BATCH = 8;
    private static final Set<Class<?>> stackWalkImplClasses = init();
    static final boolean isDebug = "true".equals(GetPropertyAction.privilegedGetProperty("stackwalk.debug"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum WalkerState {
        NEW,
        OPEN,
        CLOSED
    }

    /* renamed from: -$$Nest$smnativeGetStackAnchor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3150$$Nest$smnativeGetStackAnchor() {
        return nativeGetStackAnchor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    public static native int nativeFetchStackFrameInfo(long j10, Object obj, int i10, int i11, int i12, Object[] objArr);

    @FastNative
    private static native Object nativeGetStackAnchor();

    private StackStreamFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> StackFrameTraverser<T> makeStackTraverser(StackWalker walker, Function<? super Stream<StackWalker.StackFrame>, ? extends T> function) {
        if (walker.hasLocalsOperandsOption()) {
            return new LiveStackInfoTraverser(walker, function);
        }
        return new StackFrameTraverser<>(walker, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CallerClassFinder makeCallerFinder(StackWalker walker) {
        return new CallerClassFinder(walker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractStackWalker<R, T> {
        protected Object anchor;
        protected int depth;
        protected FrameBuffer<? extends T> frameBuffer;
        protected final int maxDepth;
        protected final long mode;
        protected final Thread thread;
        protected final StackWalker walker;

        protected abstract int batchSize(int i10);

        protected abstract R consumeFrames();

        protected abstract void initFrameBuffer();

        protected AbstractStackWalker(StackWalker walker, int mode) {
            this(walker, mode, Integer.MAX_VALUE);
        }

        protected AbstractStackWalker(StackWalker walker, int mode, int maxDepth) {
            this.thread = Thread.currentThread();
            this.mode = toStackWalkMode(walker, mode);
            this.walker = walker;
            this.maxDepth = maxDepth;
            this.depth = 0;
        }

        private int toStackWalkMode(StackWalker walker, int mode) {
            int newMode = mode;
            if (walker.hasOption(StackWalker.Option.SHOW_HIDDEN_FRAMES) && (mode & 2) != 2) {
                newMode |= 32;
            }
            if (walker.hasLocalsOperandsOption()) {
                return newMode | 256;
            }
            return newMode;
        }

        protected int getNextBatchSize() {
            int lastBatchSize = this.depth == 0 ? 0 : this.frameBuffer.curBatchFrameCount();
            int nextBatchSize = batchSize(lastBatchSize);
            if (StackStreamFactory.isDebug) {
                System.err.println("last batch size = " + lastBatchSize + " next batch size = " + nextBatchSize);
            }
            if (nextBatchSize >= 8) {
                return nextBatchSize;
            }
            return 8;
        }

        final void checkState(WalkerState state) {
            if (this.thread != Thread.currentThread()) {
                throw new IllegalStateException("Invalid thread walking this stack stream: " + Thread.currentThread().getName() + " " + this.thread.getName());
            }
            switch (AnonymousClass1.$SwitchMap$java$lang$StackStreamFactory$WalkerState[state.ordinal()]) {
                case 1:
                    if (this.anchor != null) {
                        throw new IllegalStateException("This stack stream is being reused.");
                    }
                    return;
                case 2:
                    if (this.anchor == null) {
                        throw new IllegalStateException("This stack stream is not valid for walking.");
                    }
                    return;
                case 3:
                    if (this.anchor != null) {
                        throw new IllegalStateException("This stack stream is not closed.");
                    }
                    return;
                default:
                    return;
            }
        }

        private void close() {
            this.anchor = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final R walk() {
            checkState(WalkerState.NEW);
            try {
                return beginStackWalk();
            } finally {
                close();
            }
        }

        private boolean skipReflectionFrames() {
            return (this.walker.hasOption(StackWalker.Option.SHOW_REFLECT_FRAMES) || this.walker.hasOption(StackWalker.Option.SHOW_HIDDEN_FRAMES)) ? false : true;
        }

        final Class<?> peekFrame() {
            while (this.frameBuffer.isActive() && this.depth < this.maxDepth) {
                if (this.frameBuffer.isEmpty()) {
                    getNextBatch();
                } else {
                    Class<?> c4 = this.frameBuffer.get();
                    if (skipReflectionFrames() && StackStreamFactory.isReflectionFrame(c4)) {
                        if (StackStreamFactory.isDebug) {
                            System.err.println("  skip: frame " + this.frameBuffer.getIndex() + " " + ((Object) c4));
                        }
                        this.frameBuffer.next();
                        this.depth++;
                    } else {
                        return c4;
                    }
                }
            }
            return null;
        }

        private R doStackWalk(Object anchor, int skipFrames, int batchSize, int bufStartIndex, int bufEndIndex) {
            checkState(WalkerState.NEW);
            this.frameBuffer.check(skipFrames);
            if (StackStreamFactory.isDebug) {
                System.err.format("doStackWalk: skip %d start %d end %d%n", Integer.valueOf(skipFrames), Integer.valueOf(bufStartIndex), Integer.valueOf(bufEndIndex));
            }
            this.anchor = anchor;
            this.frameBuffer.setBatch(this.depth, bufStartIndex, bufEndIndex);
            return consumeFrames();
        }

        private int getNextBatch() {
            int nextBatchSize = Math.min(this.maxDepth - this.depth, getNextBatchSize());
            if (!this.frameBuffer.isActive() || nextBatchSize <= 0) {
                if (StackStreamFactory.isDebug) {
                    System.out.format("  more stack walk done%n", new Object[0]);
                }
                this.frameBuffer.freeze();
                return 0;
            }
            return fetchStackFrames(nextBatchSize);
        }

        final Class<?> nextFrame() {
            if (!hasNext()) {
                return null;
            }
            Class<?> c4 = this.frameBuffer.next();
            this.depth++;
            return c4;
        }

        final boolean hasNext() {
            return peekFrame() != null;
        }

        private R beginStackWalk() {
            initFrameBuffer();
            return callStackWalk(this.mode, 0, this.frameBuffer.curBatchFrameCount(), this.frameBuffer.startIndex(), this.frameBuffer.frames());
        }

        private int fetchStackFrames(int batchSize) {
            int startIndex = this.frameBuffer.startIndex();
            this.frameBuffer.resize(startIndex, batchSize);
            int endIndex = fetchStackFrames(this.mode, this.anchor, batchSize, startIndex, this.frameBuffer.frames());
            if (StackStreamFactory.isDebug) {
                System.out.format("  more stack walk requesting %d got %d to %d frames%n", Integer.valueOf(batchSize), Integer.valueOf(this.frameBuffer.startIndex()), Integer.valueOf(endIndex));
            }
            int numFrames = endIndex - startIndex;
            if (numFrames == 0) {
                this.frameBuffer.freeze();
            } else {
                this.frameBuffer.setBatch(this.depth, startIndex, endIndex);
            }
            return numFrames;
        }

        private R callStackWalk(long mode, int skipframes, int batchSize, int startIndex, T[] frames) {
            checkFrameType(mode, frames);
            Object nativeAnchor = StackStreamFactory.m3150$$Nest$smnativeGetStackAnchor();
            if (nativeAnchor == null) {
                return null;
            }
            Object anchor = new LibcoreAnchor(nativeAnchor);
            int endIndex = fetchStackFrames(mode, anchor, batchSize, startIndex, frames);
            return doStackWalk(anchor, skipframes, batchSize, startIndex, endIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class LibcoreAnchor {
            private final Object nativeAnchor;
            private int stackLevel;

            private LibcoreAnchor(Object nativeAnchor) {
                this.stackLevel = 0;
                this.nativeAnchor = nativeAnchor;
            }
        }

        private void checkFrameType(long mode, T[] frames) {
            if (frames instanceof StackFrameInfo[]) {
                return;
            }
            if ((2 & mode) != 0 && (frames instanceof Class[])) {
            } else {
                throw new UnsupportedOperationException("Frame array type isn't supported yet:" + frames.getClass().getName());
            }
        }

        private int fetchStackFrames(long mode, Object anchor, int batchSize, int startIndex, T[] frames) {
            Objects.requireNonNull(anchor, "internal anchor can't be null");
            checkFrameType(mode, frames);
            LibcoreAnchor stacks = (LibcoreAnchor) anchor;
            int startTraceIndex = stacks.stackLevel;
            int endIndex = StackStreamFactory.nativeFetchStackFrameInfo(mode, stacks.nativeAnchor, startTraceIndex, batchSize, startIndex, frames);
            stacks.stackLevel += endIndex - startIndex;
            return endIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.lang.StackStreamFactory$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$StackStreamFactory$WalkerState;

        static {
            int[] iArr = new int[WalkerState.values().length];
            $SwitchMap$java$lang$StackStreamFactory$WalkerState = iArr;
            try {
                iArr[WalkerState.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$lang$StackStreamFactory$WalkerState[WalkerState.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$lang$StackStreamFactory$WalkerState[WalkerState.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class StackFrameTraverser<T> extends AbstractStackWalker<T, StackFrameInfo> implements Spliterator<StackWalker.StackFrame> {
        private static final int CHARACTERISTICS = 1040;
        final Function<? super Stream<StackWalker.StackFrame>, ? extends T> function;

        static {
            StackStreamFactory.stackWalkImplClasses.add(StackFrameTraverser.class);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class StackFrameBuffer extends FrameBuffer<StackFrameInfo> {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private StackFrameInfo[] stackFrames;

            StackFrameBuffer(int initialBatchSize) {
                super(initialBatchSize);
                this.stackFrames = new StackFrameInfo[initialBatchSize];
                for (int i10 = 2; i10 < initialBatchSize; i10++) {
                    this.stackFrames[i10] = new StackFrameInfo(StackFrameTraverser.this.walker);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.lang.StackStreamFactory.FrameBuffer
            public StackFrameInfo[] frames() {
                return this.stackFrames;
            }

            @Override // java.lang.StackStreamFactory.FrameBuffer
            void resize(int startIndex, int elements) {
                if (!isActive()) {
                    throw new IllegalStateException("inactive frame buffer can't be resized");
                }
                int size = startIndex + elements;
                StackFrameInfo[] stackFrameInfoArr = this.stackFrames;
                if (stackFrameInfoArr.length < size) {
                    StackFrameInfo[] newFrames = new StackFrameInfo[size];
                    System.arraycopy(stackFrameInfoArr, 0, newFrames, 0, startIndex);
                    this.stackFrames = newFrames;
                }
                for (int i10 = startIndex; i10 < size; i10++) {
                    this.stackFrames[i10] = new StackFrameInfo(StackFrameTraverser.this.walker);
                }
                this.currentBatchSize = size;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.lang.StackStreamFactory.FrameBuffer
            public StackFrameInfo nextStackFrame() {
                if (isEmpty()) {
                    throw new NoSuchElementException("origin=" + this.origin + " fence=" + this.fence);
                }
                StackFrameInfo frame = this.stackFrames[this.origin];
                this.origin++;
                return frame;
            }

            @Override // java.lang.StackStreamFactory.FrameBuffer
            final Class<?> at(int index) {
                return this.stackFrames[index].declaringClass();
            }
        }

        StackFrameTraverser(StackWalker walker, Function<? super Stream<StackWalker.StackFrame>, ? extends T> function) {
            this(walker, function, 0);
        }

        StackFrameTraverser(StackWalker walker, Function<? super Stream<StackWalker.StackFrame>, ? extends T> function, int mode) {
            super(walker, mode);
            this.function = function;
        }

        StackWalker.StackFrame nextStackFrame() {
            if (!hasNext()) {
                return null;
            }
            StackFrameInfo stackFrameInfo = (StackFrameInfo) this.frameBuffer.nextStackFrame();
            this.depth++;
            return stackFrameInfo;
        }

        @Override // java.lang.StackStreamFactory.AbstractStackWalker
        protected T consumeFrames() {
            checkState(WalkerState.OPEN);
            Stream<StackWalker.StackFrame> stream = StreamSupport.stream(this, false);
            Function<? super Stream<StackWalker.StackFrame>, ? extends T> function = this.function;
            if (function != null) {
                return function.apply(stream);
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.StackStreamFactory.AbstractStackWalker
        protected void initFrameBuffer() {
            this.frameBuffer = new StackFrameBuffer(getNextBatchSize());
        }

        @Override // java.lang.StackStreamFactory.AbstractStackWalker
        protected int batchSize(int lastBatchFrameCount) {
            if (lastBatchFrameCount == 0) {
                int initialBatchSize = Math.max(this.walker.estimateDepth(), 8);
                return Math.min(initialBatchSize, 256);
            }
            if (lastBatchFrameCount <= 32) {
                return Math.min(lastBatchFrameCount * 2, 32);
            }
            return lastBatchFrameCount;
        }

        @Override // java.util.Spliterator
        public Spliterator<StackWalker.StackFrame> trySplit() {
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.maxDepth;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 1040;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super StackWalker.StackFrame> action) {
            StackWalker.StackFrame frame;
            checkState(WalkerState.OPEN);
            for (int n10 = 0; n10 < this.maxDepth && (frame = nextStackFrame()) != null; n10++) {
                action.accept(frame);
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super StackWalker.StackFrame> action) {
            checkState(WalkerState.OPEN);
            int index = this.frameBuffer.getIndex();
            if (hasNext()) {
                StackWalker.StackFrame frame = nextStackFrame();
                action.accept(frame);
                if (StackStreamFactory.isDebug) {
                    System.err.println("tryAdvance: " + index + " " + ((Object) frame));
                    return true;
                }
                return true;
            }
            if (StackStreamFactory.isDebug) {
                System.err.println("tryAdvance: " + index + " NO element");
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CallerClassFinder extends AbstractStackWalker<Integer, Class<?>> {
        private Class<?> caller;

        static {
            StackStreamFactory.stackWalkImplClasses.add(CallerClassFinder.class);
        }

        CallerClassFinder(StackWalker walker) {
            super(walker, 6);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class ClassBuffer extends FrameBuffer<Class<?>> {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            Class<?>[] classes;

            ClassBuffer(int batchSize) {
                super(batchSize);
                this.classes = new Class[batchSize];
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.StackStreamFactory.FrameBuffer
            public Class<?>[] frames() {
                return this.classes;
            }

            @Override // java.lang.StackStreamFactory.FrameBuffer
            final Class<?> at(int index) {
                return this.classes[index];
            }

            @Override // java.lang.StackStreamFactory.FrameBuffer
            void resize(int startIndex, int elements) {
                if (!isActive()) {
                    throw new IllegalStateException("inactive frame buffer can't be resized");
                }
                int size = startIndex + elements;
                if (this.classes.length < size) {
                    Class<?>[] prev = this.classes;
                    Class<?>[] clsArr = new Class[size];
                    this.classes = clsArr;
                    System.arraycopy(prev, 0, clsArr, 0, startIndex);
                }
                this.currentBatchSize = size;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Class<?> findCaller() {
            walk();
            return this.caller;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.StackStreamFactory.AbstractStackWalker
        public Integer consumeFrames() {
            checkState(WalkerState.OPEN);
            int n10 = 0;
            Class<?>[] frames = new Class[2];
            while (n10 < 2) {
                Class<?> nextFrame = nextFrame();
                this.caller = nextFrame;
                if (nextFrame == null) {
                    break;
                }
                if (!StackStreamFactory.isMethodHandleFrame(nextFrame) && !StackStreamFactory.isReflectionFrame(this.caller)) {
                    frames[n10] = this.caller;
                    n10++;
                }
            }
            if (frames[1] == null) {
                throw new IllegalCallerException("no caller frame");
            }
            return Integer.valueOf(n10);
        }

        @Override // java.lang.StackStreamFactory.AbstractStackWalker
        protected void initFrameBuffer() {
            this.frameBuffer = new ClassBuffer(getNextBatchSize());
        }

        @Override // java.lang.StackStreamFactory.AbstractStackWalker
        protected int batchSize(int lastBatchFrameCount) {
            return 8;
        }

        @Override // java.lang.StackStreamFactory.AbstractStackWalker
        protected int getNextBatchSize() {
            return 8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LiveStackInfoTraverser<T> extends StackFrameTraverser<T> {
        static {
            StackStreamFactory.stackWalkImplClasses.add(LiveStackInfoTraverser.class);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class LiveStackFrameBuffer extends FrameBuffer<LiveStackFrameInfo> {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private LiveStackFrameInfo[] stackFrames;

            LiveStackFrameBuffer(int initialBatchSize) {
                super(initialBatchSize);
                this.stackFrames = new LiveStackFrameInfo[initialBatchSize];
                for (int i10 = 2; i10 < initialBatchSize; i10++) {
                    this.stackFrames[i10] = new LiveStackFrameInfo(LiveStackInfoTraverser.this.walker);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.StackStreamFactory.FrameBuffer
            public LiveStackFrameInfo[] frames() {
                return this.stackFrames;
            }

            @Override // java.lang.StackStreamFactory.FrameBuffer
            void resize(int startIndex, int elements) {
                if (!isActive()) {
                    throw new IllegalStateException("inactive frame buffer can't be resized");
                }
                int size = startIndex + elements;
                LiveStackFrameInfo[] liveStackFrameInfoArr = this.stackFrames;
                if (liveStackFrameInfoArr.length < size) {
                    LiveStackFrameInfo[] newFrames = new LiveStackFrameInfo[size];
                    System.arraycopy(liveStackFrameInfoArr, 0, newFrames, 0, startIndex);
                    this.stackFrames = newFrames;
                }
                for (int i10 = startIndex(); i10 < size; i10++) {
                    this.stackFrames[i10] = new LiveStackFrameInfo(LiveStackInfoTraverser.this.walker);
                }
                this.currentBatchSize = size;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.StackStreamFactory.FrameBuffer
            public LiveStackFrameInfo nextStackFrame() {
                if (isEmpty()) {
                    throw new NoSuchElementException("origin=" + this.origin + " fence=" + this.fence);
                }
                LiveStackFrameInfo frame = this.stackFrames[this.origin];
                this.origin++;
                return frame;
            }

            @Override // java.lang.StackStreamFactory.FrameBuffer
            final Class<?> at(int index) {
                return this.stackFrames[index].declaringClass();
            }
        }

        LiveStackInfoTraverser(StackWalker walker, Function<? super Stream<StackWalker.StackFrame>, ? extends T> function) {
            super(walker, function, 0);
        }

        @Override // java.lang.StackStreamFactory.StackFrameTraverser, java.lang.StackStreamFactory.AbstractStackWalker
        protected void initFrameBuffer() {
            this.frameBuffer = new LiveStackFrameBuffer(getNextBatchSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class FrameBuffer<F> {
        static final int START_POS = 2;
        int currentBatchSize;
        int fence;
        int origin;

        abstract Class<?> at(int i10);

        abstract F[] frames();

        abstract void resize(int i10, int i11);

        FrameBuffer(int initialBatchSize) {
            if (initialBatchSize < 8) {
                throw new IllegalArgumentException(initialBatchSize + " < minimum batch size: 8");
            }
            this.origin = 2;
            this.fence = 0;
            this.currentBatchSize = initialBatchSize;
        }

        int startIndex() {
            return 2;
        }

        F nextStackFrame() {
            throw new InternalError("should not reach here");
        }

        final int curBatchFrameCount() {
            return this.currentBatchSize - 2;
        }

        final boolean isEmpty() {
            int i10 = this.origin;
            int i11 = this.fence;
            return i10 >= i11 || (i10 == 2 && i11 == 0);
        }

        final void freeze() {
            this.origin = 0;
            this.fence = 0;
        }

        final boolean isActive() {
            int i10;
            int i11 = this.origin;
            return i11 > 0 && ((i10 = this.fence) == 0 || i11 < i10 || i10 == this.currentBatchSize);
        }

        final Class<?> next() {
            if (isEmpty()) {
                throw new NoSuchElementException("origin=" + this.origin + " fence=" + this.fence);
            }
            Class<?> c4 = at(this.origin);
            this.origin++;
            if (StackStreamFactory.isDebug) {
                int index = this.origin - 1;
                System.out.format("  next frame at %d: %s (origin %d fence %d)%n", Integer.valueOf(index), Objects.toString(c4), Integer.valueOf(index), Integer.valueOf(this.fence));
            }
            return c4;
        }

        final Class<?> get() {
            if (isEmpty()) {
                throw new NoSuchElementException("origin=" + this.origin + " fence=" + this.fence);
            }
            return at(this.origin);
        }

        final int getIndex() {
            return this.origin;
        }

        final void setBatch(int depth, int startIndex, int endIndex) {
            if (startIndex <= 0 || endIndex <= 0) {
                throw new IllegalArgumentException("startIndex=" + startIndex + " endIndex=" + endIndex);
            }
            this.origin = startIndex;
            this.fence = endIndex;
            if (depth == 0 && endIndex > 0) {
                for (int i10 = 2; i10 < this.fence; i10++) {
                    Class<?> c4 = at(i10);
                    if (StackStreamFactory.isDebug) {
                        System.err.format("  frame %d: %s%n", Integer.valueOf(i10), c4);
                    }
                    if (StackStreamFactory.filterStackWalkImpl(c4)) {
                        this.origin++;
                    } else {
                        return;
                    }
                }
            }
        }

        final void check(int skipFrames) {
            int index = skipFrames + 2;
            if (this.origin != index) {
                throw new IllegalStateException("origin " + this.origin + " != " + index);
            }
        }
    }

    private static boolean checkStackWalkModes() {
        return true;
    }

    private static Set<Class<?>> init() {
        if (!checkStackWalkModes()) {
            throw new InternalError("StackWalker mode values do not match with JVM");
        }
        Set<Class<?>> classes = new HashSet<>();
        classes.add(StackWalker.class);
        classes.add(StackStreamFactory.class);
        classes.add(AbstractStackWalker.class);
        return classes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean filterStackWalkImpl(Class<?> c4) {
        return stackWalkImplClasses.contains(c4) || c4.getName().startsWith("java.util.stream.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMethodHandleFrame(Class<?> c4) {
        return c4.getName().startsWith("java.lang.invoke.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isReflectionFrame(Class<?> c4) {
        return c4 == Method.class || c4 == Constructor.class || c4.getName().startsWith("java.lang.invoke.LambdaForm");
    }
}
