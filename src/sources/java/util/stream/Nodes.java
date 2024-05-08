package java.util.stream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.stream.Node;
import java.util.stream.Nodes;
import java.util.stream.Sink;
import java.util.stream.SpinedBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Nodes {
    static final String BAD_SIZE = "Stream size exceeds max array size";
    static final long MAX_ARRAY_SIZE = 2147483639;
    private static final Node EMPTY_NODE = new EmptyNode.OfRef();
    private static final Node.OfInt EMPTY_INT_NODE = new EmptyNode.OfInt();
    private static final Node.OfLong EMPTY_LONG_NODE = new EmptyNode.OfLong();
    private static final Node.OfDouble EMPTY_DOUBLE_NODE = new EmptyNode.OfDouble();
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    private Nodes() {
        throw new Error("no instances");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> IntFunction<T[]> castingArray() {
        return new IntFunction() { // from class: java.util.stream.Nodes$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return Nodes.lambda$castingArray$0(i10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$castingArray$0(int size) {
        return new Object[size];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.Nodes$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$stream$StreamShape;

        static {
            int[] iArr = new int[StreamShape.values().length];
            $SwitchMap$java$util$stream$StreamShape = iArr;
            try {
                iArr[StreamShape.REFERENCE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.INT_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.LONG_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Node<T> emptyNode(StreamShape shape) {
        switch (AnonymousClass1.$SwitchMap$java$util$stream$StreamShape[shape.ordinal()]) {
            case 1:
                return EMPTY_NODE;
            case 2:
                return EMPTY_INT_NODE;
            case 3:
                return EMPTY_LONG_NODE;
            case 4:
                return EMPTY_DOUBLE_NODE;
            default:
                throw new IllegalStateException("Unknown shape " + ((Object) shape));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Node<T> conc(StreamShape shape, Node<T> left, Node<T> right) {
        switch (AnonymousClass1.$SwitchMap$java$util$stream$StreamShape[shape.ordinal()]) {
            case 1:
                return new ConcNode(left, right);
            case 2:
                return new ConcNode.OfInt((Node.OfInt) left, (Node.OfInt) right);
            case 3:
                return new ConcNode.OfLong((Node.OfLong) left, (Node.OfLong) right);
            case 4:
                return new ConcNode.OfDouble((Node.OfDouble) left, (Node.OfDouble) right);
            default:
                throw new IllegalStateException("Unknown shape " + ((Object) shape));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Node<T> node(T[] array) {
        return new ArrayNode(array);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Node<T> node(Collection<T> c4) {
        return new CollectionNode(c4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Node.Builder<T> builder(long exactSizeIfKnown, IntFunction<T[]> generator) {
        if (exactSizeIfKnown >= 0 && exactSizeIfKnown < MAX_ARRAY_SIZE) {
            return new FixedNodeBuilder(exactSizeIfKnown, generator);
        }
        return builder();
    }

    static <T> Node.Builder<T> builder() {
        return new SpinedNodeBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Node.OfInt node(int[] array) {
        return new IntArrayNode(array);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Node.Builder.OfInt intBuilder(long exactSizeIfKnown) {
        if (exactSizeIfKnown >= 0 && exactSizeIfKnown < MAX_ARRAY_SIZE) {
            return new IntFixedNodeBuilder(exactSizeIfKnown);
        }
        return intBuilder();
    }

    static Node.Builder.OfInt intBuilder() {
        return new IntSpinedNodeBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Node.OfLong node(long[] array) {
        return new LongArrayNode(array);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Node.Builder.OfLong longBuilder(long exactSizeIfKnown) {
        if (exactSizeIfKnown >= 0 && exactSizeIfKnown < MAX_ARRAY_SIZE) {
            return new LongFixedNodeBuilder(exactSizeIfKnown);
        }
        return longBuilder();
    }

    static Node.Builder.OfLong longBuilder() {
        return new LongSpinedNodeBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Node.OfDouble node(double[] array) {
        return new DoubleArrayNode(array);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Node.Builder.OfDouble doubleBuilder(long exactSizeIfKnown) {
        if (exactSizeIfKnown >= 0 && exactSizeIfKnown < MAX_ARRAY_SIZE) {
            return new DoubleFixedNodeBuilder(exactSizeIfKnown);
        }
        return doubleBuilder();
    }

    static Node.Builder.OfDouble doubleBuilder() {
        return new DoubleSpinedNodeBuilder();
    }

    public static <P_IN, P_OUT> Node<P_OUT> collect(PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<P_OUT[]> generator) {
        long size = helper.exactOutputSizeIfKnown(spliterator);
        if (size < 0 || !spliterator.hasCharacteristics(16384)) {
            Node<P_OUT> node = (Node) new CollectorTask.OfRef(helper, generator, spliterator).invoke();
            return flattenTree ? flatten(node, generator) : node;
        }
        if (size >= MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        P_OUT[] array = generator.apply((int) size);
        new SizedCollectorTask.OfRef(spliterator, helper, array).invoke();
        return node(array);
    }

    public static <P_IN> Node.OfInt collectInt(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator, boolean flattenTree) {
        long size = helper.exactOutputSizeIfKnown(spliterator);
        if (size < 0 || !spliterator.hasCharacteristics(16384)) {
            Node.OfInt node = (Node.OfInt) new CollectorTask.OfInt(helper, spliterator).invoke();
            return flattenTree ? flattenInt(node) : node;
        }
        if (size >= MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        int[] array = new int[(int) size];
        new SizedCollectorTask.OfInt(spliterator, helper, array).invoke();
        return node(array);
    }

    public static <P_IN> Node.OfLong collectLong(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator, boolean flattenTree) {
        long size = helper.exactOutputSizeIfKnown(spliterator);
        if (size < 0 || !spliterator.hasCharacteristics(16384)) {
            Node.OfLong node = (Node.OfLong) new CollectorTask.OfLong(helper, spliterator).invoke();
            return flattenTree ? flattenLong(node) : node;
        }
        if (size >= MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        long[] array = new long[(int) size];
        new SizedCollectorTask.OfLong(spliterator, helper, array).invoke();
        return node(array);
    }

    public static <P_IN> Node.OfDouble collectDouble(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator, boolean flattenTree) {
        long size = helper.exactOutputSizeIfKnown(spliterator);
        if (size < 0 || !spliterator.hasCharacteristics(16384)) {
            Node.OfDouble node = (Node.OfDouble) new CollectorTask.OfDouble(helper, spliterator).invoke();
            return flattenTree ? flattenDouble(node) : node;
        }
        if (size >= MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        double[] array = new double[(int) size];
        new SizedCollectorTask.OfDouble(spliterator, helper, array).invoke();
        return node(array);
    }

    public static <T> Node<T> flatten(Node<T> node, IntFunction<T[]> generator) {
        if (node.getChildCount() > 0) {
            long size = node.count();
            if (size >= MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(BAD_SIZE);
            }
            T[] array = generator.apply((int) size);
            new ToArrayTask.OfRef(node, array, 0).invoke();
            return node(array);
        }
        return node;
    }

    public static Node.OfInt flattenInt(Node.OfInt node) {
        if (node.getChildCount() > 0) {
            long size = node.count();
            if (size >= MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(BAD_SIZE);
            }
            int[] array = new int[(int) size];
            new ToArrayTask.OfInt(node, array, 0).invoke();
            return node(array);
        }
        return node;
    }

    public static Node.OfLong flattenLong(Node.OfLong node) {
        if (node.getChildCount() > 0) {
            long size = node.count();
            if (size >= MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(BAD_SIZE);
            }
            long[] array = new long[(int) size];
            new ToArrayTask.OfLong(node, array, 0).invoke();
            return node(array);
        }
        return node;
    }

    public static Node.OfDouble flattenDouble(Node.OfDouble node) {
        if (node.getChildCount() > 0) {
            long size = node.count();
            if (size >= MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(BAD_SIZE);
            }
            double[] array = new double[(int) size];
            new ToArrayTask.OfDouble(node, array, 0).invoke();
            return node(array);
        }
        return node;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class EmptyNode<T, T_ARR, T_CONS> implements Node<T> {
        EmptyNode() {
        }

        @Override // java.util.stream.Node
        public T[] asArray(IntFunction<T[]> generator) {
            return generator.apply(0);
        }

        public void copyInto(T_ARR array, int offset) {
        }

        @Override // java.util.stream.Node
        public long count() {
            return 0L;
        }

        public void forEach(T_CONS consumer) {
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static class OfRef<T> extends EmptyNode<T, T[], Consumer<? super T>> {
            @Override // java.util.stream.Node
            public /* bridge */ /* synthetic */ void copyInto(Object[] objArr, int i10) {
                super.copyInto((OfRef<T>) objArr, i10);
            }

            @Override // java.util.stream.Node
            public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
                super.forEach((OfRef<T>) consumer);
            }

            private OfRef() {
            }

            @Override // java.util.stream.Node
            public Spliterator<T> spliterator() {
                return Spliterators.emptySpliterator();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfInt extends EmptyNode<Integer, int[], IntConsumer> implements Node.OfInt {
            OfInt() {
            }

            @Override // java.util.stream.Node
            public Spliterator.OfInt spliterator() {
                return Spliterators.emptyIntSpliterator();
            }

            @Override // java.util.stream.Node.OfPrimitive
            public int[] asPrimitiveArray() {
                return Nodes.EMPTY_INT_ARRAY;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfLong extends EmptyNode<Long, long[], LongConsumer> implements Node.OfLong {
            OfLong() {
            }

            @Override // java.util.stream.Node
            public Spliterator.OfLong spliterator() {
                return Spliterators.emptyLongSpliterator();
            }

            @Override // java.util.stream.Node.OfPrimitive
            public long[] asPrimitiveArray() {
                return Nodes.EMPTY_LONG_ARRAY;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfDouble extends EmptyNode<Double, double[], DoubleConsumer> implements Node.OfDouble {
            OfDouble() {
            }

            @Override // java.util.stream.Node
            public Spliterator.OfDouble spliterator() {
                return Spliterators.emptyDoubleSpliterator();
            }

            @Override // java.util.stream.Node.OfPrimitive
            public double[] asPrimitiveArray() {
                return Nodes.EMPTY_DOUBLE_ARRAY;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ArrayNode<T> implements Node<T> {
        final T[] array;
        int curSize;

        ArrayNode(long size, IntFunction<T[]> generator) {
            if (size >= Nodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(Nodes.BAD_SIZE);
            }
            this.array = generator.apply((int) size);
            this.curSize = 0;
        }

        ArrayNode(T[] array) {
            this.array = array;
            this.curSize = array.length;
        }

        @Override // java.util.stream.Node
        public Spliterator<T> spliterator() {
            return Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java.util.stream.Node
        public void copyInto(T[] dest, int destOffset) {
            System.arraycopy(this.array, 0, dest, destOffset, this.curSize);
        }

        @Override // java.util.stream.Node
        public T[] asArray(IntFunction<T[]> generator) {
            T[] tArr = this.array;
            if (tArr.length == this.curSize) {
                return tArr;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java.util.stream.Node
        public void forEach(Consumer<? super T> consumer) {
            for (int i10 = 0; i10 < this.curSize; i10++) {
                consumer.accept(this.array[i10]);
            }
        }

        public String toString() {
            return String.format("ArrayNode[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class CollectionNode<T> implements Node<T> {

        /* renamed from: c, reason: collision with root package name */
        private final Collection<T> f50506c;

        CollectionNode(Collection<T> c4) {
            this.f50506c = c4;
        }

        @Override // java.util.stream.Node
        public Spliterator<T> spliterator() {
            return this.f50506c.stream().spliterator2();
        }

        @Override // java.util.stream.Node
        public void copyInto(T[] array, int offset) {
            for (T t2 : this.f50506c) {
                array[offset] = t2;
                offset++;
            }
        }

        @Override // java.util.stream.Node
        public T[] asArray(IntFunction<T[]> intFunction) {
            Collection<T> collection = this.f50506c;
            return (T[]) collection.toArray(intFunction.apply(collection.size()));
        }

        @Override // java.util.stream.Node
        public long count() {
            return this.f50506c.size();
        }

        @Override // java.util.stream.Node
        public void forEach(Consumer<? super T> consumer) {
            this.f50506c.forEach(consumer);
        }

        public String toString() {
            return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.f50506c.size()), this.f50506c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractConcNode<T, T_NODE extends Node<T>> implements Node<T> {
        protected final T_NODE left;
        protected final T_NODE right;
        private final long size;

        AbstractConcNode(T_NODE left, T_NODE right) {
            this.left = left;
            this.right = right;
            this.size = left.count() + right.count();
        }

        @Override // java.util.stream.Node
        public int getChildCount() {
            return 2;
        }

        @Override // java.util.stream.Node
        public T_NODE getChild(int i10) {
            if (i10 == 0) {
                return this.left;
            }
            if (i10 == 1) {
                return this.right;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.stream.Node
        public long count() {
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ConcNode<T> extends AbstractConcNode<T, Node<T>> implements Node<T> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ConcNode(Node<T> left, Node<T> right) {
            super(left, right);
        }

        @Override // java.util.stream.Node
        public Spliterator<T> spliterator() {
            return new InternalNodeSpliterator.OfRef(this);
        }

        @Override // java.util.stream.Node
        public void copyInto(T[] array, int offset) {
            Objects.requireNonNull(array);
            this.left.copyInto(array, offset);
            this.right.copyInto(array, ((int) this.left.count()) + offset);
        }

        @Override // java.util.stream.Node
        public T[] asArray(IntFunction<T[]> generator) {
            long size = count();
            if (size >= Nodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(Nodes.BAD_SIZE);
            }
            T[] array = generator.apply((int) size);
            copyInto(array, 0);
            return array;
        }

        @Override // java.util.stream.Node
        public void forEach(Consumer<? super T> consumer) {
            this.left.forEach(consumer);
            this.right.forEach(consumer);
        }

        @Override // java.util.stream.Node
        public Node<T> truncate(long from, long to, IntFunction<T[]> generator) {
            if (from == 0 && to == count()) {
                return this;
            }
            long leftCount = this.left.count();
            if (from >= leftCount) {
                return this.right.truncate(from - leftCount, to - leftCount, generator);
            }
            if (to <= leftCount) {
                return this.left.truncate(from, to, generator);
            }
            return Nodes.conc(getShape(), this.left.truncate(from, leftCount, generator), this.right.truncate(0L, to - leftCount, generator));
        }

        public String toString() {
            if (count() < 32) {
                return String.format("ConcNode[%s.%s]", this.left, this.right);
            }
            return String.format("ConcNode[size=%d]", Long.valueOf(count()));
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static abstract class OfPrimitive<E, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>, T_NODE extends Node.OfPrimitive<E, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends AbstractConcNode<E, T_NODE> implements Node.OfPrimitive<E, T_CONS, T_ARR, T_SPLITR, T_NODE> {
            @Override // java.util.stream.Nodes.AbstractConcNode, java.util.stream.Node
            public /* bridge */ /* synthetic */ Node.OfPrimitive getChild(int i10) {
                return (Node.OfPrimitive) super.getChild(i10);
            }

            OfPrimitive(T_NODE left, T_NODE right) {
                super(left, right);
            }

            @Override // java.util.stream.Node.OfPrimitive
            public void forEach(T_CONS consumer) {
                ((Node.OfPrimitive) this.left).forEach((Node.OfPrimitive) consumer);
                ((Node.OfPrimitive) this.right).forEach((Node.OfPrimitive) consumer);
            }

            @Override // java.util.stream.Node.OfPrimitive
            public void copyInto(T_ARR array, int offset) {
                ((Node.OfPrimitive) this.left).copyInto((Node.OfPrimitive) array, offset);
                ((Node.OfPrimitive) this.right).copyInto((Node.OfPrimitive) array, ((int) ((Node.OfPrimitive) this.left).count()) + offset);
            }

            @Override // java.util.stream.Node.OfPrimitive
            public T_ARR asPrimitiveArray() {
                long size = count();
                if (size >= Nodes.MAX_ARRAY_SIZE) {
                    throw new IllegalArgumentException(Nodes.BAD_SIZE);
                }
                T_ARR array = newArray((int) size);
                copyInto((OfPrimitive<E, T_CONS, T_ARR, T_SPLITR, T_NODE>) array, 0);
                return array;
            }

            public String toString() {
                if (count() < 32) {
                    return String.format("%s[%s.%s]", getClass().getName(), this.left, this.right);
                }
                return String.format("%s[size=%d]", getClass().getName(), Long.valueOf(count()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, Node.OfInt> implements Node.OfInt {
            /* JADX INFO: Access modifiers changed from: package-private */
            public OfInt(Node.OfInt left, Node.OfInt right) {
                super(left, right);
            }

            @Override // java.util.stream.Node
            public Spliterator.OfInt spliterator() {
                return new InternalNodeSpliterator.OfInt(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, Node.OfLong> implements Node.OfLong {
            /* JADX INFO: Access modifiers changed from: package-private */
            public OfLong(Node.OfLong left, Node.OfLong right) {
                super(left, right);
            }

            @Override // java.util.stream.Node
            public Spliterator.OfLong spliterator() {
                return new InternalNodeSpliterator.OfLong(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, Node.OfDouble> implements Node.OfDouble {
            /* JADX INFO: Access modifiers changed from: package-private */
            public OfDouble(Node.OfDouble left, Node.OfDouble right) {
                super(left, right);
            }

            @Override // java.util.stream.Node
            public Spliterator.OfDouble spliterator() {
                return new InternalNodeSpliterator.OfDouble(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class InternalNodeSpliterator<T, S extends Spliterator<T>, N extends Node<T>> implements Spliterator<T> {
        int curChildIndex;
        N curNode;
        S lastNodeSpliterator;
        S tryAdvanceSpliterator;
        Deque<N> tryAdvanceStack;

        InternalNodeSpliterator(N curNode) {
            this.curNode = curNode;
        }

        protected final Deque<N> initStack() {
            ArrayDeque arrayDeque = new ArrayDeque(8);
            int i10 = this.curNode.getChildCount();
            while (true) {
                i10--;
                if (i10 >= this.curChildIndex) {
                    arrayDeque.addFirst(this.curNode.getChild(i10));
                } else {
                    return arrayDeque;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected final N findNextLeafNode(Deque<N> deque) {
            while (true) {
                N n10 = (N) deque.pollFirst();
                if (n10 != null) {
                    if (n10.getChildCount() != 0) {
                        for (int i10 = n10.getChildCount() - 1; i10 >= 0; i10--) {
                            deque.addFirst(n10.getChild(i10));
                        }
                    } else if (n10.count() > 0) {
                        return n10;
                    }
                } else {
                    return null;
                }
            }
        }

        protected final boolean initTryAdvance() {
            if (this.curNode == null) {
                return false;
            }
            if (this.tryAdvanceSpliterator == null) {
                S s2 = this.lastNodeSpliterator;
                if (s2 == null) {
                    Deque<N> initStack = initStack();
                    this.tryAdvanceStack = initStack;
                    N findNextLeafNode = findNextLeafNode(initStack);
                    if (findNextLeafNode != null) {
                        this.tryAdvanceSpliterator = (S) findNextLeafNode.spliterator();
                        return true;
                    }
                    this.curNode = null;
                    return false;
                }
                this.tryAdvanceSpliterator = s2;
                return true;
            }
            return true;
        }

        @Override // java.util.Spliterator
        public final S trySplit() {
            if (this.curNode == null || this.tryAdvanceSpliterator != null) {
                return null;
            }
            S s2 = this.lastNodeSpliterator;
            if (s2 != null) {
                return (S) s2.trySplit();
            }
            if (this.curChildIndex < r0.getChildCount() - 1) {
                N n10 = this.curNode;
                int i10 = this.curChildIndex;
                this.curChildIndex = i10 + 1;
                return n10.getChild(i10).spliterator();
            }
            N n11 = (N) this.curNode.getChild(this.curChildIndex);
            this.curNode = n11;
            if (n11.getChildCount() == 0) {
                S s10 = (S) this.curNode.spliterator();
                this.lastNodeSpliterator = s10;
                return (S) s10.trySplit();
            }
            this.curChildIndex = 0;
            N n12 = this.curNode;
            this.curChildIndex = 0 + 1;
            return n12.getChild(0).spliterator();
        }

        @Override // java.util.Spliterator
        public final long estimateSize() {
            if (this.curNode == null) {
                return 0L;
            }
            S s2 = this.lastNodeSpliterator;
            if (s2 != null) {
                return s2.estimateSize();
            }
            long size = 0;
            for (int i10 = this.curChildIndex; i10 < this.curNode.getChildCount(); i10++) {
                size += this.curNode.getChild(i10).count();
            }
            return size;
        }

        @Override // java.util.Spliterator
        public final int characteristics() {
            return 64;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfRef<T> extends InternalNodeSpliterator<T, Spliterator<T>, Node<T>> {
            OfRef(Node<T> curNode) {
                super(curNode);
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> consumer) {
                Node<T> findNextLeafNode;
                if (!initTryAdvance()) {
                    return false;
                }
                boolean tryAdvance = this.tryAdvanceSpliterator.tryAdvance(consumer);
                if (!tryAdvance) {
                    if (this.lastNodeSpliterator == null && (findNextLeafNode = findNextLeafNode(this.tryAdvanceStack)) != null) {
                        this.tryAdvanceSpliterator = findNextLeafNode.spliterator();
                        return this.tryAdvanceSpliterator.tryAdvance(consumer);
                    }
                    this.curNode = null;
                }
                return tryAdvance;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Spliterator
            public void forEachRemaining(Consumer<? super T> consumer) {
                if (this.curNode == null) {
                    return;
                }
                if (this.tryAdvanceSpliterator == null) {
                    if (this.lastNodeSpliterator == null) {
                        Deque<Node<T>> stack = initStack();
                        while (true) {
                            Node<T> leaf = findNextLeafNode(stack);
                            if (leaf != null) {
                                leaf.forEach(consumer);
                            } else {
                                this.curNode = null;
                                return;
                            }
                        }
                    } else {
                        this.lastNodeSpliterator.forEachRemaining(consumer);
                        return;
                    }
                }
                do {
                } while (tryAdvance(consumer));
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static abstract class OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, N extends Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N>> extends InternalNodeSpliterator<T, T_SPLITR, N> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            @Override // java.util.stream.Nodes.InternalNodeSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(N cur) {
                super(cur);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS consumer) {
                Node.OfPrimitive ofPrimitive;
                if (!initTryAdvance()) {
                    return false;
                }
                boolean hasNext = ((Spliterator.OfPrimitive) this.tryAdvanceSpliterator).tryAdvance((Spliterator.OfPrimitive) consumer);
                if (!hasNext) {
                    if (this.lastNodeSpliterator == null && (ofPrimitive = (Node.OfPrimitive) findNextLeafNode(this.tryAdvanceStack)) != null) {
                        this.tryAdvanceSpliterator = ofPrimitive.spliterator();
                        return ((Spliterator.OfPrimitive) this.tryAdvanceSpliterator).tryAdvance((Spliterator.OfPrimitive) consumer);
                    }
                    this.curNode = null;
                }
                return hasNext;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS consumer) {
                if (this.curNode == null) {
                    return;
                }
                if (this.tryAdvanceSpliterator == null) {
                    if (this.lastNodeSpliterator == null) {
                        Deque<N> stack = initStack();
                        while (true) {
                            Node.OfPrimitive ofPrimitive = (Node.OfPrimitive) findNextLeafNode(stack);
                            if (ofPrimitive != null) {
                                ofPrimitive.forEach((Node.OfPrimitive) consumer);
                            } else {
                                this.curNode = null;
                                return;
                            }
                        }
                    } else {
                        ((Spliterator.OfPrimitive) this.lastNodeSpliterator).forEachRemaining((Spliterator.OfPrimitive) consumer);
                        return;
                    }
                }
                do {
                } while (tryAdvance((OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N>) consumer));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, Node.OfInt> implements Spliterator.OfInt {
            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((OfInt) intConsumer);
            }

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((OfInt) intConsumer);
            }

            @Override // java.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive, java.util.stream.Nodes.InternalNodeSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            OfInt(Node.OfInt cur) {
                super(cur);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, Node.OfLong> implements Spliterator.OfLong {
            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((OfLong) longConsumer);
            }

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((OfLong) longConsumer);
            }

            @Override // java.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive, java.util.stream.Nodes.InternalNodeSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            OfLong(Node.OfLong cur) {
                super(cur);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, Node.OfDouble> implements Spliterator.OfDouble {
            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((OfDouble) doubleConsumer);
            }

            @Override // java.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive, java.util.stream.Nodes.InternalNodeSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            OfDouble(Node.OfDouble cur) {
                super(cur);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class FixedNodeBuilder<T> extends ArrayNode<T> implements Node.Builder<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        FixedNodeBuilder(long size, IntFunction<T[]> generator) {
            super(size, generator);
        }

        @Override // java.util.stream.Node.Builder
        /* renamed from: build */
        public Node<T> build2() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
            return this;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            if (size != this.array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(size), Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            if (this.curSize < this.array.length) {
                T[] tArr = this.array;
                int i10 = this.curSize;
                this.curSize = i10 + 1;
                tArr[i10] = t2;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.array.length)));
        }

        @Override // java.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
        }

        @Override // java.util.stream.Nodes.ArrayNode
        public String toString() {
            return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SpinedNodeBuilder<T> extends SpinedBuffer<T> implements Node<T>, Node.Builder<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean building = false;

        SpinedNodeBuilder() {
        }

        @Override // java.util.stream.SpinedBuffer, java.lang.Iterable
        public Spliterator<T> spliterator() {
            return super.spliterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.stream.SpinedBuffer, java.lang.Iterable
        public void forEach(Consumer<? super T> consumer) {
            super.forEach(consumer);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.building = true;
            clear();
            ensureCapacity(size);
        }

        @Override // java.util.stream.SpinedBuffer, java.util.function.Consumer
        public void accept(T t2) {
            super.accept((SpinedNodeBuilder<T>) t2);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.building = false;
        }

        @Override // java.util.stream.SpinedBuffer, java.util.stream.Node
        public void copyInto(T[] array, int offset) {
            super.copyInto(array, offset);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.stream.SpinedBuffer, java.util.stream.Node
        public T[] asArray(IntFunction<T[]> intFunction) {
            return (T[]) super.asArray(intFunction);
        }

        @Override // java.util.stream.Node.Builder
        /* renamed from: build */
        public Node<T> build2() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class IntArrayNode implements Node.OfInt {
        final int[] array;
        int curSize;

        IntArrayNode(long size) {
            if (size >= Nodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(Nodes.BAD_SIZE);
            }
            this.array = new int[(int) size];
            this.curSize = 0;
        }

        IntArrayNode(int[] array) {
            this.array = array;
            this.curSize = array.length;
        }

        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        public Spliterator.OfInt spliterator() {
            return Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java.util.stream.Node.OfPrimitive
        public int[] asPrimitiveArray() {
            int[] iArr = this.array;
            int length = iArr.length;
            int i10 = this.curSize;
            if (length == i10) {
                return iArr;
            }
            return Arrays.copyOf(iArr, i10);
        }

        @Override // java.util.stream.Node.OfPrimitive
        public void copyInto(int[] dest, int destOffset) {
            System.arraycopy((Object) this.array, 0, (Object) dest, destOffset, this.curSize);
        }

        @Override // java.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java.util.stream.Node.OfPrimitive
        public void forEach(IntConsumer consumer) {
            for (int i10 = 0; i10 < this.curSize; i10++) {
                consumer.accept(this.array[i10]);
            }
        }

        public String toString() {
            return String.format("IntArrayNode[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class LongArrayNode implements Node.OfLong {
        final long[] array;
        int curSize;

        LongArrayNode(long size) {
            if (size >= Nodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(Nodes.BAD_SIZE);
            }
            this.array = new long[(int) size];
            this.curSize = 0;
        }

        LongArrayNode(long[] array) {
            this.array = array;
            this.curSize = array.length;
        }

        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        public Spliterator.OfLong spliterator() {
            return Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java.util.stream.Node.OfPrimitive
        public long[] asPrimitiveArray() {
            long[] jArr = this.array;
            int length = jArr.length;
            int i10 = this.curSize;
            if (length == i10) {
                return jArr;
            }
            return Arrays.copyOf(jArr, i10);
        }

        @Override // java.util.stream.Node.OfPrimitive
        public void copyInto(long[] dest, int destOffset) {
            System.arraycopy((Object) this.array, 0, (Object) dest, destOffset, this.curSize);
        }

        @Override // java.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java.util.stream.Node.OfPrimitive
        public void forEach(LongConsumer consumer) {
            for (int i10 = 0; i10 < this.curSize; i10++) {
                consumer.accept(this.array[i10]);
            }
        }

        public String toString() {
            return String.format("LongArrayNode[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DoubleArrayNode implements Node.OfDouble {
        final double[] array;
        int curSize;

        DoubleArrayNode(long size) {
            if (size >= Nodes.MAX_ARRAY_SIZE) {
                throw new IllegalArgumentException(Nodes.BAD_SIZE);
            }
            this.array = new double[(int) size];
            this.curSize = 0;
        }

        DoubleArrayNode(double[] array) {
            this.array = array;
            this.curSize = array.length;
        }

        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        public Spliterator.OfDouble spliterator() {
            return Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java.util.stream.Node.OfPrimitive
        public double[] asPrimitiveArray() {
            double[] dArr = this.array;
            int length = dArr.length;
            int i10 = this.curSize;
            if (length == i10) {
                return dArr;
            }
            return Arrays.copyOf(dArr, i10);
        }

        @Override // java.util.stream.Node.OfPrimitive
        public void copyInto(double[] dest, int destOffset) {
            System.arraycopy((Object) this.array, 0, (Object) dest, destOffset, this.curSize);
        }

        @Override // java.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java.util.stream.Node.OfPrimitive
        public void forEach(DoubleConsumer consumer) {
            for (int i10 = 0; i10 < this.curSize; i10++) {
                consumer.accept(this.array[i10]);
            }
        }

        public String toString() {
            return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class IntFixedNodeBuilder extends IntArrayNode implements Node.Builder.OfInt {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        IntFixedNodeBuilder(long size) {
            super(size);
        }

        @Override // java.util.stream.Node.Builder.OfInt, java.util.stream.Node.Builder
        /* renamed from: build */
        public Node<Integer> build2() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
            return this;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            if (size != this.array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(size), Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfInt, java.util.function.IntConsumer
        public void accept(int i10) {
            if (this.curSize < this.array.length) {
                int[] iArr = this.array;
                int i11 = this.curSize;
                this.curSize = i11 + 1;
                iArr[i11] = i10;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.array.length)));
        }

        @Override // java.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
        }

        @Override // java.util.stream.Nodes.IntArrayNode
        public String toString() {
            return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class LongFixedNodeBuilder extends LongArrayNode implements Node.Builder.OfLong {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        LongFixedNodeBuilder(long size) {
            super(size);
        }

        @Override // java.util.stream.Node.Builder.OfLong, java.util.stream.Node.Builder
        /* renamed from: build */
        public Node<Long> build2() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
            return this;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            if (size != this.array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(size), Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfLong, java.util.function.LongConsumer
        public void accept(long i10) {
            if (this.curSize < this.array.length) {
                long[] jArr = this.array;
                int i11 = this.curSize;
                this.curSize = i11 + 1;
                jArr[i11] = i10;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.array.length)));
        }

        @Override // java.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
        }

        @Override // java.util.stream.Nodes.LongArrayNode
        public String toString() {
            return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class DoubleFixedNodeBuilder extends DoubleArrayNode implements Node.Builder.OfDouble {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        DoubleFixedNodeBuilder(long size) {
            super(size);
        }

        @Override // java.util.stream.Node.Builder.OfDouble, java.util.stream.Node.Builder
        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public Node<Double> build2() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
            return this;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            if (size != this.array.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(size), Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double i10) {
            if (this.curSize < this.array.length) {
                double[] dArr = this.array;
                int i11 = this.curSize;
                this.curSize = i11 + 1;
                dArr[i11] = i10;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.array.length)));
        }

        @Override // java.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)));
            }
        }

        @Override // java.util.stream.Nodes.DoubleArrayNode
        public String toString() {
            return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class IntSpinedNodeBuilder extends SpinedBuffer.OfInt implements Node.OfInt, Node.Builder.OfInt {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean building = false;

        IntSpinedNodeBuilder() {
        }

        @Override // java.util.stream.SpinedBuffer.OfInt, java.lang.Iterable
        public Spliterator.OfInt spliterator() {
            return super.spliterator();
        }

        @Override // java.util.stream.SpinedBuffer.OfInt, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public void forEach(IntConsumer consumer) {
            super.forEach((Object) consumer);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.building = true;
            clear();
            ensureCapacity(size);
        }

        @Override // java.util.stream.SpinedBuffer.OfInt, java.util.function.IntConsumer
        public void accept(int i10) {
            super.accept(i10);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.building = false;
        }

        @Override // java.util.stream.SpinedBuffer.OfInt, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public void copyInto(int[] array, int offset) throws IndexOutOfBoundsException {
            super.copyInto((Object) array, offset);
        }

        @Override // java.util.stream.SpinedBuffer.OfInt, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public int[] asPrimitiveArray() {
            return (int[]) super.asPrimitiveArray();
        }

        @Override // java.util.stream.Node.Builder.OfInt, java.util.stream.Node.Builder
        /* renamed from: build */
        public Node<Integer> build2() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LongSpinedNodeBuilder extends SpinedBuffer.OfLong implements Node.OfLong, Node.Builder.OfLong {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean building = false;

        LongSpinedNodeBuilder() {
        }

        @Override // java.util.stream.SpinedBuffer.OfLong, java.lang.Iterable
        public Spliterator.OfLong spliterator() {
            return super.spliterator();
        }

        @Override // java.util.stream.SpinedBuffer.OfLong, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public void forEach(LongConsumer consumer) {
            super.forEach((Object) consumer);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.building = true;
            clear();
            ensureCapacity(size);
        }

        @Override // java.util.stream.SpinedBuffer.OfLong, java.util.function.LongConsumer
        public void accept(long i10) {
            super.accept(i10);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.building = false;
        }

        @Override // java.util.stream.SpinedBuffer.OfLong, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public void copyInto(long[] array, int offset) {
            super.copyInto((Object) array, offset);
        }

        @Override // java.util.stream.SpinedBuffer.OfLong, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public long[] asPrimitiveArray() {
            return (long[]) super.asPrimitiveArray();
        }

        @Override // java.util.stream.Node.Builder.OfLong, java.util.stream.Node.Builder
        /* renamed from: build */
        public Node<Long> build2() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DoubleSpinedNodeBuilder extends SpinedBuffer.OfDouble implements Node.OfDouble, Node.Builder.OfDouble {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean building = false;

        DoubleSpinedNodeBuilder() {
        }

        @Override // java.util.stream.SpinedBuffer.OfDouble, java.lang.Iterable
        public Spliterator.OfDouble spliterator() {
            return super.spliterator();
        }

        @Override // java.util.stream.SpinedBuffer.OfDouble, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public void forEach(DoubleConsumer consumer) {
            super.forEach((Object) consumer);
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.building = true;
            clear();
            ensureCapacity(size);
        }

        @Override // java.util.stream.SpinedBuffer.OfDouble, java.util.function.DoubleConsumer
        public void accept(double i10) {
            super.accept(i10);
        }

        @Override // java.util.stream.Sink
        public void end() {
            this.building = false;
        }

        @Override // java.util.stream.SpinedBuffer.OfDouble, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public void copyInto(double[] array, int offset) {
            super.copyInto((Object) array, offset);
        }

        @Override // java.util.stream.SpinedBuffer.OfDouble, java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public double[] asPrimitiveArray() {
            return (double[]) super.asPrimitiveArray();
        }

        @Override // java.util.stream.Node.Builder.OfDouble, java.util.stream.Node.Builder
        /* renamed from: build */
        public Node<Double> build2() {
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class SizedCollectorTask<P_IN, P_OUT, T_SINK extends Sink<P_OUT>, K extends SizedCollectorTask<P_IN, P_OUT, T_SINK, K>> extends CountedCompleter<Void> implements Sink<P_OUT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected int fence;
        protected final PipelineHelper<P_OUT> helper;
        protected int index;
        protected long length;
        protected long offset;
        protected final Spliterator<P_IN> spliterator;
        protected final long targetSize;

        abstract K makeChild(Spliterator<P_IN> spliterator, long j10, long j11);

        SizedCollectorTask(Spliterator<P_IN> spliterator, PipelineHelper<P_OUT> helper, int arrayLength) {
            this.spliterator = spliterator;
            this.helper = helper;
            this.targetSize = AbstractTask.suggestTargetSize(spliterator.estimateSize());
            this.offset = 0L;
            this.length = arrayLength;
        }

        SizedCollectorTask(K parent, Spliterator<P_IN> spliterator, long offset, long length, int arrayLength) {
            super(parent);
            this.spliterator = spliterator;
            this.helper = parent.helper;
            this.targetSize = parent.targetSize;
            this.offset = offset;
            this.length = length;
            if (offset < 0 || length < 0 || (offset + length) - 1 >= arrayLength) {
                throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(offset), Long.valueOf(offset), Long.valueOf(length), Integer.valueOf(arrayLength)));
            }
        }

        @Override // java.util.concurrent.CountedCompleter
        public void compute() {
            Spliterator<P_IN> leftSplit;
            SizedCollectorTask<P_IN, P_OUT, T_SINK, K> task = this;
            Spliterator<P_IN> rightSplit = this.spliterator;
            while (rightSplit.estimateSize() > task.targetSize && (leftSplit = rightSplit.trySplit()) != null) {
                task.setPendingCount(1);
                long leftSplitSize = leftSplit.estimateSize();
                task.makeChild(leftSplit, task.offset, leftSplitSize).fork();
                task = task.makeChild(rightSplit, task.offset + leftSplitSize, task.length - leftSplitSize);
            }
            task.helper.wrapAndCopyInto(task, rightSplit);
            task.propagateCompletion();
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            long j10 = this.length;
            if (size > j10) {
                throw new IllegalStateException("size passed to Sink.begin exceeds array length");
            }
            int i10 = (int) this.offset;
            this.index = i10;
            this.fence = i10 + ((int) j10);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfRef<P_IN, P_OUT> extends SizedCollectorTask<P_IN, P_OUT, Sink<P_OUT>, OfRef<P_IN, P_OUT>> implements Sink<P_OUT> {
            private final P_OUT[] array;

            OfRef(Spliterator<P_IN> spliterator, PipelineHelper<P_OUT> helper, P_OUT[] array) {
                super(spliterator, helper, array.length);
                this.array = array;
            }

            OfRef(OfRef<P_IN, P_OUT> parent, Spliterator<P_IN> spliterator, long offset, long length) {
                super(parent, spliterator, offset, length, parent.array.length);
                this.array = parent.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.Nodes.SizedCollectorTask
            public OfRef<P_IN, P_OUT> makeChild(Spliterator<P_IN> spliterator, long offset, long size) {
                return new OfRef<>(this, spliterator, offset, size);
            }

            @Override // java.util.function.Consumer
            public void accept(P_OUT value) {
                if (this.index >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                P_OUT[] p_outArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                p_outArr[i10] = value;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfInt<P_IN> extends SizedCollectorTask<P_IN, Integer, Sink.OfInt, OfInt<P_IN>> implements Sink.OfInt {
            private final int[] array;

            OfInt(Spliterator<P_IN> spliterator, PipelineHelper<Integer> helper, int[] array) {
                super(spliterator, helper, array.length);
                this.array = array;
            }

            OfInt(OfInt<P_IN> parent, Spliterator<P_IN> spliterator, long offset, long length) {
                super(parent, spliterator, offset, length, parent.array.length);
                this.array = parent.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.Nodes.SizedCollectorTask
            public OfInt<P_IN> makeChild(Spliterator<P_IN> spliterator, long offset, long size) {
                return new OfInt<>(this, spliterator, offset, size);
            }

            @Override // java.util.stream.Sink, java.util.stream.Sink.OfInt, java.util.function.IntConsumer
            public void accept(int value) {
                if (this.index >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                int[] iArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                iArr[i10] = value;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfLong<P_IN> extends SizedCollectorTask<P_IN, Long, Sink.OfLong, OfLong<P_IN>> implements Sink.OfLong {
            private final long[] array;

            OfLong(Spliterator<P_IN> spliterator, PipelineHelper<Long> helper, long[] array) {
                super(spliterator, helper, array.length);
                this.array = array;
            }

            OfLong(OfLong<P_IN> parent, Spliterator<P_IN> spliterator, long offset, long length) {
                super(parent, spliterator, offset, length, parent.array.length);
                this.array = parent.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.Nodes.SizedCollectorTask
            public OfLong<P_IN> makeChild(Spliterator<P_IN> spliterator, long offset, long size) {
                return new OfLong<>(this, spliterator, offset, size);
            }

            @Override // java.util.stream.Sink, java.util.stream.Sink.OfLong, java.util.function.LongConsumer
            public void accept(long value) {
                if (this.index >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                long[] jArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                jArr[i10] = value;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfDouble<P_IN> extends SizedCollectorTask<P_IN, Double, Sink.OfDouble, OfDouble<P_IN>> implements Sink.OfDouble {
            private final double[] array;

            OfDouble(Spliterator<P_IN> spliterator, PipelineHelper<Double> helper, double[] array) {
                super(spliterator, helper, array.length);
                this.array = array;
            }

            OfDouble(OfDouble<P_IN> parent, Spliterator<P_IN> spliterator, long offset, long length) {
                super(parent, spliterator, offset, length, parent.array.length);
                this.array = parent.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.Nodes.SizedCollectorTask
            public OfDouble<P_IN> makeChild(Spliterator<P_IN> spliterator, long offset, long size) {
                return new OfDouble<>(this, spliterator, offset, size);
            }

            @Override // java.util.stream.Sink, java.util.function.DoubleConsumer
            public void accept(double value) {
                if (this.index >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                double[] dArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                dArr[i10] = value;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ToArrayTask<T, T_NODE extends Node<T>, K extends ToArrayTask<T, T_NODE, K>> extends CountedCompleter<Void> {
        protected final T_NODE node;
        protected final int offset;

        abstract void copyNodeToArray();

        abstract K makeChild(int i10, int i11);

        ToArrayTask(T_NODE node, int offset) {
            this.node = node;
            this.offset = offset;
        }

        ToArrayTask(K parent, T_NODE node, int offset) {
            super(parent);
            this.node = node;
            this.offset = offset;
        }

        @Override // java.util.concurrent.CountedCompleter
        public void compute() {
            ToArrayTask<T, T_NODE, K> task = this;
            while (task.node.getChildCount() != 0) {
                task.setPendingCount(task.node.getChildCount() - 1);
                int size = 0;
                int i10 = 0;
                while (i10 < task.node.getChildCount() - 1) {
                    K leftTask = task.makeChild(i10, task.offset + size);
                    size = (int) (size + leftTask.node.count());
                    leftTask.fork();
                    i10++;
                }
                task = task.makeChild(i10, task.offset + size);
            }
            task.copyNodeToArray();
            task.propagateCompletion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfRef<T> extends ToArrayTask<T, Node<T>, OfRef<T>> {
            private final T[] array;

            private OfRef(Node<T> node, T[] array, int offset) {
                super(node, offset);
                this.array = array;
            }

            private OfRef(OfRef<T> parent, Node<T> node, int offset) {
                super(parent, node, offset);
                this.array = parent.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.Nodes.ToArrayTask
            public OfRef<T> makeChild(int childIndex, int offset) {
                return new OfRef<>(this, this.node.getChild(childIndex), offset);
            }

            @Override // java.util.stream.Nodes.ToArrayTask
            void copyNodeToArray() {
                this.node.copyInto(this.array, this.offset);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static class OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends ToArrayTask<T, T_NODE, OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> {
            private final T_ARR array;

            private OfPrimitive(T_NODE node, T_ARR array, int offset) {
                super(node, offset);
                this.array = array;
            }

            private OfPrimitive(OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE> parent, T_NODE node, int offset) {
                super(parent, node, offset);
                this.array = parent.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.Nodes.ToArrayTask
            public OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE> makeChild(int childIndex, int offset) {
                return new OfPrimitive<>(this, ((Node.OfPrimitive) this.node).getChild(childIndex), offset);
            }

            @Override // java.util.stream.Nodes.ToArrayTask
            void copyNodeToArray() {
                ((Node.OfPrimitive) this.node).copyInto((Node.OfPrimitive) this.array, this.offset);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, Node.OfInt> {
            private OfInt(Node.OfInt node, int[] array, int offset) {
                super(node, array, offset);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, Node.OfLong> {
            private OfLong(Node.OfLong node, long[] array, int offset) {
                super(node, array, offset);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, Node.OfDouble> {
            private OfDouble(Node.OfDouble node, double[] array, int offset) {
                super(node, array, offset);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class CollectorTask<P_IN, P_OUT, T_NODE extends Node<P_OUT>, T_BUILDER extends Node.Builder<P_OUT>> extends AbstractTask<P_IN, P_OUT, T_NODE, CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER>> {
        protected final LongFunction<T_BUILDER> builderFactory;
        protected final BinaryOperator<T_NODE> concFactory;
        protected final PipelineHelper<P_OUT> helper;

        CollectorTask(PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator, LongFunction<T_BUILDER> builderFactory, BinaryOperator<T_NODE> concFactory) {
            super(helper, spliterator);
            this.helper = helper;
            this.builderFactory = builderFactory;
            this.concFactory = concFactory;
        }

        CollectorTask(CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER> parent, Spliterator<P_IN> spliterator) {
            super(parent, spliterator);
            this.helper = parent.helper;
            this.builderFactory = parent.builderFactory;
            this.concFactory = parent.concFactory;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER> makeChild(Spliterator<P_IN> spliterator) {
            return new CollectorTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public T_NODE doLeaf() {
            return (T_NODE) ((Node.Builder) this.helper.wrapAndCopyInto(this.builderFactory.apply(this.helper.exactOutputSizeIfKnown(this.spliterator)), this.spliterator)).build2();
        }

        @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter<?> countedCompleter) {
            if (!isLeaf()) {
                setLocalResult((Node) this.concFactory.apply((Node) ((CollectorTask) this.leftChild).getLocalResult(), (Node) ((CollectorTask) this.rightChild).getLocalResult()));
            }
            super.onCompletion(countedCompleter);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfRef<P_IN, P_OUT> extends CollectorTask<P_IN, P_OUT, Node<P_OUT>, Node.Builder<P_OUT>> {
            OfRef(PipelineHelper<P_OUT> helper, final IntFunction<P_OUT[]> generator, Spliterator<P_IN> spliterator) {
                super(helper, spliterator, new LongFunction() { // from class: java.util.stream.Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda0
                    @Override // java.util.function.LongFunction
                    public final Object apply(long j10) {
                        Node.Builder builder;
                        builder = Nodes.builder(j10, IntFunction.this);
                        return builder;
                    }
                }, new BinaryOperator() { // from class: java.util.stream.Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda1
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new Nodes.ConcNode((Node) obj, (Node) obj2);
                    }
                });
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfInt<P_IN> extends CollectorTask<P_IN, Integer, Node.OfInt, Node.Builder.OfInt> {
            OfInt(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator) {
                super(helper, spliterator, new LongFunction() { // from class: java.util.stream.Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda0
                    @Override // java.util.function.LongFunction
                    public final Object apply(long j10) {
                        return Nodes.intBuilder(j10);
                    }
                }, new BinaryOperator() { // from class: java.util.stream.Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda1
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new Nodes.ConcNode.OfInt((Node.OfInt) obj, (Node.OfInt) obj2);
                    }
                });
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfLong<P_IN> extends CollectorTask<P_IN, Long, Node.OfLong, Node.Builder.OfLong> {
            OfLong(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator) {
                super(helper, spliterator, new LongFunction() { // from class: java.util.stream.Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda0
                    @Override // java.util.function.LongFunction
                    public final Object apply(long j10) {
                        return Nodes.longBuilder(j10);
                    }
                }, new BinaryOperator() { // from class: java.util.stream.Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda1
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new Nodes.ConcNode.OfLong((Node.OfLong) obj, (Node.OfLong) obj2);
                    }
                });
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfDouble<P_IN> extends CollectorTask<P_IN, Double, Node.OfDouble, Node.Builder.OfDouble> {
            OfDouble(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator) {
                super(helper, spliterator, new LongFunction() { // from class: java.util.stream.Nodes$CollectorTask$OfDouble$$ExternalSyntheticLambda0
                    @Override // java.util.function.LongFunction
                    public final Object apply(long j10) {
                        return Nodes.doubleBuilder(j10);
                    }
                }, new BinaryOperator() { // from class: java.util.stream.Nodes$CollectorTask$OfDouble$$ExternalSyntheticLambda1
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new Nodes.ConcNode.OfDouble((Node.OfDouble) obj, (Node.OfDouble) obj2);
                    }
                });
            }
        }
    }
}
