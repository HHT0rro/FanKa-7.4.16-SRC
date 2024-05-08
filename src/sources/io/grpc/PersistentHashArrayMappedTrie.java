package io.grpc;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class PersistentHashArrayMappedTrie {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CollisionLeaf<K, V> implements Node<K, V> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final K[] keys;
        private final V[] values;

        public CollisionLeaf(K k10, V v2, K k11, V v10) {
            this(new Object[]{k10, k11}, new Object[]{v2, v10});
        }

        private int indexOfKey(K k10) {
            int i10 = 0;
            while (true) {
                K[] kArr = this.keys;
                if (i10 >= kArr.length) {
                    return -1;
                }
                if (kArr[i10] == k10) {
                    return i10;
                }
                i10++;
            }
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public V get(K k10, int i10, int i11) {
            int i12 = 0;
            while (true) {
                K[] kArr = this.keys;
                if (i12 >= kArr.length) {
                    return null;
                }
                if (kArr[i12] == k10) {
                    return this.values[i12];
                }
                i12++;
            }
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public Node<K, V> put(K k10, V v2, int i10, int i11) {
            int hashCode = this.keys[0].hashCode();
            if (hashCode != i10) {
                return CompressedIndex.combine(new Leaf(k10, v2), i10, this, hashCode, i11);
            }
            int indexOfKey = indexOfKey(k10);
            if (indexOfKey != -1) {
                K[] kArr = this.keys;
                Object[] copyOf = Arrays.copyOf(kArr, kArr.length);
                Object[] copyOf2 = Arrays.copyOf(this.values, this.keys.length);
                copyOf[indexOfKey] = k10;
                copyOf2[indexOfKey] = v2;
                return new CollisionLeaf(copyOf, copyOf2);
            }
            K[] kArr2 = this.keys;
            Object[] copyOf3 = Arrays.copyOf(kArr2, kArr2.length + 1);
            Object[] copyOf4 = Arrays.copyOf(this.values, this.keys.length + 1);
            K[] kArr3 = this.keys;
            copyOf3[kArr3.length] = k10;
            copyOf4[kArr3.length] = v2;
            return new CollisionLeaf(copyOf3, copyOf4);
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public int size() {
            return this.values.length;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CollisionLeaf(");
            for (int i10 = 0; i10 < this.values.length; i10++) {
                sb2.append("(key=");
                sb2.append((Object) this.keys[i10]);
                sb2.append(" value=");
                sb2.append((Object) this.values[i10]);
                sb2.append(") ");
            }
            sb2.append(")");
            return sb2.toString();
        }

        private CollisionLeaf(K[] kArr, V[] vArr) {
            this.keys = kArr;
            this.values = vArr;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CompressedIndex<K, V> implements Node<K, V> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int BITS = 5;
        private static final int BITS_MASK = 31;
        public final int bitmap;
        private final int size;
        public final Node<K, V>[] values;

        private CompressedIndex(int i10, Node<K, V>[] nodeArr, int i11) {
            this.bitmap = i10;
            this.values = nodeArr;
            this.size = i11;
        }

        public static <K, V> Node<K, V> combine(Node<K, V> node, int i10, Node<K, V> node2, int i11, int i12) {
            int indexBit = indexBit(i10, i12);
            int indexBit2 = indexBit(i11, i12);
            if (indexBit == indexBit2) {
                Node combine = combine(node, i10, node2, i11, i12 + 5);
                return new CompressedIndex(indexBit, new Node[]{combine}, combine.size());
            }
            if (uncompressedIndex(i10, i12) > uncompressedIndex(i11, i12)) {
                node2 = node;
                node = node2;
            }
            return new CompressedIndex(indexBit | indexBit2, new Node[]{node, node2}, node.size() + node2.size());
        }

        private int compressedIndex(int i10) {
            return Integer.bitCount((i10 - 1) & this.bitmap);
        }

        private static int indexBit(int i10, int i11) {
            return 1 << uncompressedIndex(i10, i11);
        }

        private static int uncompressedIndex(int i10, int i11) {
            return (i10 >>> i11) & 31;
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public V get(K k10, int i10, int i11) {
            int indexBit = indexBit(i10, i11);
            if ((this.bitmap & indexBit) == 0) {
                return null;
            }
            return this.values[compressedIndex(indexBit)].get(k10, i10, i11 + 5);
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public Node<K, V> put(K k10, V v2, int i10, int i11) {
            int indexBit = indexBit(i10, i11);
            int compressedIndex = compressedIndex(indexBit);
            int i12 = this.bitmap;
            if ((i12 & indexBit) == 0) {
                int i13 = i12 | indexBit;
                Node<K, V>[] nodeArr = this.values;
                Node[] nodeArr2 = new Node[nodeArr.length + 1];
                System.arraycopy(nodeArr, 0, nodeArr2, 0, compressedIndex);
                nodeArr2[compressedIndex] = new Leaf(k10, v2);
                Node<K, V>[] nodeArr3 = this.values;
                System.arraycopy(nodeArr3, compressedIndex, nodeArr2, compressedIndex + 1, nodeArr3.length - compressedIndex);
                return new CompressedIndex(i13, nodeArr2, size() + 1);
            }
            Node<K, V>[] nodeArr4 = this.values;
            Node[] nodeArr5 = (Node[]) Arrays.copyOf(nodeArr4, nodeArr4.length);
            nodeArr5[compressedIndex] = this.values[compressedIndex].put(k10, v2, i10, i11 + 5);
            return new CompressedIndex(this.bitmap, nodeArr5, (size() + nodeArr5[compressedIndex].size()) - this.values[compressedIndex].size());
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public int size() {
            return this.size;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CompressedIndex(");
            sb2.append(String.format("bitmap=%s ", Integer.toBinaryString(this.bitmap)));
            for (Node<K, V> node : this.values) {
                sb2.append((Object) node);
                sb2.append(" ");
            }
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Leaf<K, V> implements Node<K, V> {
        private final K key;
        private final V value;

        public Leaf(K k10, V v2) {
            this.key = k10;
            this.value = v2;
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public V get(K k10, int i10, int i11) {
            if (this.key == k10) {
                return this.value;
            }
            return null;
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public Node<K, V> put(K k10, V v2, int i10, int i11) {
            int hashCode = this.key.hashCode();
            if (hashCode != i10) {
                return CompressedIndex.combine(new Leaf(k10, v2), i10, this, hashCode, i11);
            }
            if (this.key == k10) {
                return new Leaf(k10, v2);
            }
            return new CollisionLeaf(this.key, this.value, k10, v2);
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public int size() {
            return 1;
        }

        public String toString() {
            return String.format("Leaf(key=%s value=%s)", this.key, this.value);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Node<K, V> {
        V get(K k10, int i10, int i11);

        Node<K, V> put(K k10, V v2, int i10, int i11);

        int size();
    }

    private PersistentHashArrayMappedTrie() {
    }

    public static <K, V> V get(Node<K, V> node, K k10) {
        if (node == null) {
            return null;
        }
        return node.get(k10, k10.hashCode(), 0);
    }

    public static <K, V> Node<K, V> put(Node<K, V> node, K k10, V v2) {
        if (node == null) {
            return new Leaf(k10, v2);
        }
        return node.put(k10, v2, k10.hashCode(), 0);
    }
}
