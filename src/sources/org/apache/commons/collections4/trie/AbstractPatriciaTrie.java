package org.apache.commons.collections4.trie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.trie.AbstractBitwiseTrie;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractPatriciaTrie<K, V> extends AbstractBitwiseTrie<K, V> {
    private static final long serialVersionUID = 5155253417231339498L;
    private volatile transient Set<Map.Entry<K, V>> entrySet;
    private volatile transient Set<K> keySet;
    public transient int modCount;
    private transient TrieEntry<K, V> root;
    private transient int size;
    private volatile transient Collection<V> values;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private EntryIterator() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return nextEntry();
            }
        }

        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TrieEntry<K, V> entry;
            return (obj instanceof Map.Entry) && (entry = AbstractPatriciaTrie.this.getEntry(((Map.Entry) obj).getKey())) != null && entry.equals(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            AbstractPatriciaTrie.this.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class KeySet extends AbstractSet<K> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class KeyIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> {
            private KeyIterator() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return nextEntry().getKey();
            }
        }

        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size = size();
            AbstractPatriciaTrie.this.remove(obj);
            return size != size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class PrefixRangeEntrySet extends AbstractPatriciaTrie<K, V>.RangeEntrySet {
        private final AbstractPatriciaTrie<K, V>.PrefixRangeMap delegate;
        private int expectedModCount;
        private TrieEntry<K, V> prefixStart;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private boolean lastOne;
            private final int lengthInBits;
            private final int offset;
            private final K prefix;
            private TrieEntry<K, V> subtree;

            public EntryIterator(TrieEntry<K, V> trieEntry, K k10, int i10, int i11) {
                super();
                this.subtree = trieEntry;
                this.next = AbstractPatriciaTrie.this.followLeft(trieEntry);
                this.prefix = k10;
                this.offset = i10;
                this.lengthInBits = i11;
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
            public TrieEntry<K, V> findNext(TrieEntry<K, V> trieEntry) {
                return AbstractPatriciaTrie.this.nextEntryInSubtree(trieEntry, this.subtree);
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public void remove() {
                TrieEntry<K, V> trieEntry = this.subtree;
                int i10 = trieEntry.bitIndex;
                boolean z10 = this.current == trieEntry;
                super.remove();
                if (i10 != this.subtree.bitIndex || z10) {
                    this.subtree = AbstractPatriciaTrie.this.subtree(this.prefix, this.offset, this.lengthInBits);
                }
                if (this.lengthInBits >= this.subtree.bitIndex) {
                    this.lastOne = true;
                }
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                TrieEntry<K, V> nextEntry = nextEntry();
                if (this.lastOne) {
                    this.next = null;
                }
                return nextEntry;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class SingletonIterator implements Iterator<Map.Entry<K, V>> {
            private final TrieEntry<K, V> entry;
            private int hit = 0;

            public SingletonIterator(TrieEntry<K, V> trieEntry) {
                this.entry = trieEntry;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.hit == 0;
            }

            @Override // java.util.Iterator
            public void remove() {
                int i10 = this.hit;
                if (i10 == 1) {
                    this.hit = i10 + 1;
                    AbstractPatriciaTrie.this.removeEntry(this.entry);
                    return;
                }
                throw new IllegalStateException();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                int i10 = this.hit;
                if (i10 == 0) {
                    this.hit = i10 + 1;
                    return this.entry;
                }
                throw new NoSuchElementException();
            }
        }

        public PrefixRangeEntrySet(AbstractPatriciaTrie<K, V>.PrefixRangeMap prefixRangeMap) {
            super(prefixRangeMap);
            this.expectedModCount = 0;
            this.delegate = prefixRangeMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            AbstractPatriciaTrie abstractPatriciaTrie = AbstractPatriciaTrie.this;
            if (abstractPatriciaTrie.modCount != this.expectedModCount) {
                this.prefixStart = abstractPatriciaTrie.subtree(((PrefixRangeMap) this.delegate).prefix, ((PrefixRangeMap) this.delegate).offsetInBits, ((PrefixRangeMap) this.delegate).lengthInBits);
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            if (this.prefixStart == null) {
                return Collections.emptySet().iterator2();
            }
            int i10 = ((PrefixRangeMap) this.delegate).lengthInBits;
            TrieEntry<K, V> trieEntry = this.prefixStart;
            if (i10 > trieEntry.bitIndex) {
                return new SingletonIterator(trieEntry);
            }
            return new EntryIterator(trieEntry, ((PrefixRangeMap) this.delegate).prefix, ((PrefixRangeMap) this.delegate).offsetInBits, ((PrefixRangeMap) this.delegate).lengthInBits);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.delegate.fixup();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class PrefixRangeMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private transient int expectedModCount;
        private K fromKey;
        private final int lengthInBits;
        private final int offsetInBits;
        private final K prefix;
        private int size;
        private K toKey;

        /* JADX INFO: Access modifiers changed from: private */
        public int fixup() {
            Map.Entry<K, V> entry;
            if (this.size == -1 || AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
                Iterator<Map.Entry<K, V>> iterator2 = super.entrySet().iterator2();
                this.size = 0;
                if (iterator2.hasNext()) {
                    entry = iterator2.next();
                    this.size = 1;
                } else {
                    entry = null;
                }
                K key = entry == null ? null : entry.getKey();
                this.fromKey = key;
                if (key != null) {
                    TrieEntry<K, V> previousEntry = AbstractPatriciaTrie.this.previousEntry((TrieEntry) entry);
                    this.fromKey = previousEntry == null ? null : previousEntry.getKey();
                }
                this.toKey = this.fromKey;
                while (iterator2.hasNext()) {
                    this.size++;
                    entry = iterator2.next();
                }
                K key2 = entry == null ? null : entry.getKey();
                this.toKey = key2;
                if (key2 != null) {
                    TrieEntry<K, V> nextEntry = AbstractPatriciaTrie.this.nextEntry((TrieEntry) entry);
                    this.toKey = nextEntry != null ? nextEntry.getKey() : null;
                }
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            return this.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterator<Map.Entry<K, V>> iterator2 = AbstractPatriciaTrie.this.entrySet().iterator2();
            Set<K> h10 = h();
            while (iterator2.hasNext()) {
                if (h10.contains(iterator2.next().getKey())) {
                    iterator2.remove();
                }
            }
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new PrefixRangeEntrySet(this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public SortedMap<K, V> createRangeMap(K k10, boolean z10, K k11, boolean z11) {
            return new RangeEntryMap(k10, z10, k11, z11);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            TrieEntry<K, V> higherEntry;
            fixup();
            K k10 = this.fromKey;
            if (k10 == null) {
                higherEntry = AbstractPatriciaTrie.this.firstEntry();
            } else {
                higherEntry = AbstractPatriciaTrie.this.higherEntry(k10);
            }
            K key = higherEntry != null ? higherEntry.getKey() : null;
            if (higherEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key)) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inFromRange(K k10, boolean z10) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k10);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inRange(K k10) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k10);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inRange2(K k10) {
            return inRange(k10);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inToRange(K k10, boolean z10) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k10);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return false;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return false;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            TrieEntry<K, V> lowerEntry;
            fixup();
            K k10 = this.toKey;
            if (k10 == null) {
                lowerEntry = AbstractPatriciaTrie.this.lastEntry();
            } else {
                lowerEntry = AbstractPatriciaTrie.this.lowerEntry(k10);
            }
            K key = lowerEntry != null ? lowerEntry.getKey() : null;
            if (lowerEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key)) {
                throw new NoSuchElementException();
            }
            return key;
        }

        private PrefixRangeMap(K k10, int i10, int i11) {
            super();
            this.fromKey = null;
            this.toKey = null;
            this.expectedModCount = 0;
            this.size = -1;
            this.prefix = k10;
            this.offsetInBits = i10;
            this.lengthInBits = i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class RangeEntryMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private final boolean fromInclusive;
        private final K fromKey;
        private final boolean toInclusive;
        private final K toKey;

        public RangeEntryMap(AbstractPatriciaTrie abstractPatriciaTrie, K k10, K k11) {
            this(k10, true, k11, false);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new RangeEntrySet(this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public SortedMap<K, V> createRangeMap(K k10, boolean z10, K k11, boolean z11) {
            return new RangeEntryMap(k10, z10, k11, z11);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            TrieEntry<K, V> higherEntry;
            K k10 = this.fromKey;
            if (k10 == null) {
                higherEntry = AbstractPatriciaTrie.this.firstEntry();
            } else if (this.fromInclusive) {
                higherEntry = AbstractPatriciaTrie.this.ceilingEntry(k10);
            } else {
                higherEntry = AbstractPatriciaTrie.this.higherEntry(k10);
            }
            K key = higherEntry != null ? higherEntry.getKey() : null;
            if (higherEntry == null || !(this.toKey == null || inToRange(key, false))) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return this.fromInclusive;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return this.toInclusive;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            TrieEntry<K, V> lowerEntry;
            K k10 = this.toKey;
            if (k10 == null) {
                lowerEntry = AbstractPatriciaTrie.this.lastEntry();
            } else if (this.toInclusive) {
                lowerEntry = AbstractPatriciaTrie.this.floorEntry(k10);
            } else {
                lowerEntry = AbstractPatriciaTrie.this.lowerEntry(k10);
            }
            K key = lowerEntry != null ? lowerEntry.getKey() : null;
            if (lowerEntry == null || !(this.fromKey == null || inFromRange(key, false))) {
                throw new NoSuchElementException();
            }
            return key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RangeEntryMap(K k10, boolean z10, K k11, boolean z11) {
            super();
            if (k10 == 0 && k11 == 0) {
                throw new IllegalArgumentException("must have a from or to!");
            }
            if (k10 != 0 && k11 != 0 && AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k10, k11) > 0) {
                throw new IllegalArgumentException("fromKey > toKey");
            }
            this.fromKey = k10;
            this.fromInclusive = z10;
            this.toKey = k11;
            this.toInclusive = z11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class RangeEntrySet extends AbstractSet<Map.Entry<K, V>> {
        private final AbstractPatriciaTrie<K, V>.RangeMap delegate;
        private transient int expectedModCount;
        private transient int size = -1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private final K excludedKey;

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public boolean hasNext() {
                TrieEntry<K, V> trieEntry = this.next;
                return (trieEntry == null || AbstractBitwiseTrie.compare(trieEntry.key, this.excludedKey)) ? false : true;
            }

            private EntryIterator(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
                super(trieEntry);
                this.excludedKey = trieEntry2 != null ? trieEntry2.getKey() : null;
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                TrieEntry<K, V> trieEntry = this.next;
                if (trieEntry != null && !AbstractBitwiseTrie.compare(trieEntry.key, this.excludedKey)) {
                    return nextEntry();
                }
                throw new NoSuchElementException();
            }
        }

        public RangeEntrySet(AbstractPatriciaTrie<K, V>.RangeMap rangeMap) {
            Objects.requireNonNull(rangeMap, "delegate");
            this.delegate = rangeMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TrieEntry<K, V> entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            Object key = entry2.getKey();
            return this.delegate.inRange(key) && (entry = AbstractPatriciaTrie.this.getEntry(key)) != null && AbstractBitwiseTrie.compare(entry.getValue(), entry2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !iterator2().hasNext();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            TrieEntry<K, V> ceilingEntry;
            K fromKey = this.delegate.getFromKey();
            K toKey = this.delegate.getToKey();
            if (fromKey == null) {
                ceilingEntry = AbstractPatriciaTrie.this.firstEntry();
            } else {
                ceilingEntry = AbstractPatriciaTrie.this.ceilingEntry(fromKey);
            }
            return new EntryIterator(ceilingEntry, toKey != null ? AbstractPatriciaTrie.this.ceilingEntry(toKey) : null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            TrieEntry<K, V> entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            Object key = entry2.getKey();
            if (!this.delegate.inRange(key) || (entry = AbstractPatriciaTrie.this.getEntry(key)) == null || !AbstractBitwiseTrie.compare(entry.getValue(), entry2.getValue())) {
                return false;
            }
            AbstractPatriciaTrie.this.removeEntry(entry);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            if (this.size == -1 || this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
                this.size = 0;
                Iterator<Map.Entry<K, V>> iterator2 = iterator2();
                while (iterator2.hasNext()) {
                    this.size++;
                    iterator2.next();
                }
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            return this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public abstract class RangeMap extends AbstractMap<K, V> implements SortedMap<K, V> {
        private volatile transient Set<Map.Entry<K, V>> entrySet;

        private RangeMap() {
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return AbstractPatriciaTrie.this.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return AbstractPatriciaTrie.this.containsKey(obj);
            }
            return false;
        }

        public abstract Set<Map.Entry<K, V>> createEntrySet();

        public abstract SortedMap<K, V> createRangeMap(K k10, boolean z10, K k11, boolean z11);

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = createEntrySet();
            }
            return this.entrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return (V) AbstractPatriciaTrie.this.get(obj);
            }
            return null;
        }

        public abstract K getFromKey();

        public abstract K getToKey();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k10) {
            if (inRange2(k10)) {
                return createRangeMap(getFromKey(), isFromInclusive(), k10, isToInclusive());
            }
            throw new IllegalArgumentException("ToKey is out of range: " + ((Object) k10));
        }

        public boolean inFromRange(K k10, boolean z10) {
            Object fromKey = getFromKey();
            boolean isFromInclusive = isFromInclusive();
            int compare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k10, fromKey);
            return (isFromInclusive || z10) ? compare >= 0 : compare > 0;
        }

        public boolean inRange(K k10) {
            Object fromKey = getFromKey();
            Object toKey = getToKey();
            if (fromKey == null || inFromRange(k10, false)) {
                return toKey == null || inToRange(k10, false);
            }
            return false;
        }

        public boolean inRange2(K k10) {
            return (getFromKey() == null || inFromRange(k10, false)) && (getToKey() == null || inToRange(k10, true));
        }

        public boolean inToRange(K k10, boolean z10) {
            Object toKey = getToKey();
            boolean isToInclusive = isToInclusive();
            int compare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k10, toKey);
            return (isToInclusive || z10) ? compare <= 0 : compare < 0;
        }

        public abstract boolean isFromInclusive();

        public abstract boolean isToInclusive();

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k10, V v2) {
            if (inRange(k10)) {
                return (V) AbstractPatriciaTrie.this.put(k10, v2);
            }
            throw new IllegalArgumentException("Key is out of range: " + ((Object) k10));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return (V) AbstractPatriciaTrie.this.remove(obj);
            }
            return null;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            if (inRange2(k10)) {
                if (inRange2(k11)) {
                    return createRangeMap(k10, isFromInclusive(), k11, isToInclusive());
                }
                throw new IllegalArgumentException("ToKey is out of range: " + ((Object) k11));
            }
            throw new IllegalArgumentException("FromKey is out of range: " + ((Object) k10));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k10) {
            if (inRange2(k10)) {
                return createRangeMap(k10, isFromInclusive(), getToKey(), isToInclusive());
            }
            throw new IllegalArgumentException("FromKey is out of range: " + ((Object) k10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Reference<E> {
        private E item;

        private Reference() {
        }

        public E get() {
            return this.item;
        }

        public void set(E e2) {
            this.item = e2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TrieEntry<K, V> extends AbstractBitwiseTrie.BasicEntry<K, V> {
        private static final long serialVersionUID = 4596023148184140013L;
        public int bitIndex;
        public TrieEntry<K, V> left;
        public TrieEntry<K, V> parent;
        public TrieEntry<K, V> predecessor;
        public TrieEntry<K, V> right;

        public TrieEntry(K k10, V v2, int i10) {
            super(k10, v2);
            this.bitIndex = i10;
            this.parent = null;
            this.left = this;
            this.right = null;
            this.predecessor = this;
        }

        public boolean isEmpty() {
            return this.key == null;
        }

        public boolean isExternalNode() {
            return !isInternalNode();
        }

        public boolean isInternalNode() {
            return (this.left == this || this.right == this) ? false : true;
        }

        @Override // org.apache.commons.collections4.trie.AbstractBitwiseTrie.BasicEntry
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.bitIndex == -1) {
                sb2.append("RootEntry(");
            } else {
                sb2.append("Entry(");
            }
            sb2.append("key=");
            sb2.append((Object) getKey());
            sb2.append(" [");
            sb2.append(this.bitIndex);
            sb2.append("], ");
            sb2.append("value=");
            sb2.append((Object) getValue());
            sb2.append(", ");
            TrieEntry<K, V> trieEntry = this.parent;
            if (trieEntry != null) {
                if (trieEntry.bitIndex == -1) {
                    sb2.append("parent=");
                    sb2.append("ROOT");
                } else {
                    sb2.append("parent=");
                    sb2.append((Object) this.parent.getKey());
                    sb2.append(" [");
                    sb2.append(this.parent.bitIndex);
                    sb2.append("]");
                }
            } else {
                sb2.append("parent=");
                sb2.append("null");
            }
            sb2.append(", ");
            TrieEntry<K, V> trieEntry2 = this.left;
            if (trieEntry2 != null) {
                if (trieEntry2.bitIndex == -1) {
                    sb2.append("left=");
                    sb2.append("ROOT");
                } else {
                    sb2.append("left=");
                    sb2.append((Object) this.left.getKey());
                    sb2.append(" [");
                    sb2.append(this.left.bitIndex);
                    sb2.append("]");
                }
            } else {
                sb2.append("left=");
                sb2.append("null");
            }
            sb2.append(", ");
            TrieEntry<K, V> trieEntry3 = this.right;
            if (trieEntry3 != null) {
                if (trieEntry3.bitIndex == -1) {
                    sb2.append("right=");
                    sb2.append("ROOT");
                } else {
                    sb2.append("right=");
                    sb2.append((Object) this.right.getKey());
                    sb2.append(" [");
                    sb2.append(this.right.bitIndex);
                    sb2.append("]");
                }
            } else {
                sb2.append("right=");
                sb2.append("null");
            }
            sb2.append(", ");
            TrieEntry<K, V> trieEntry4 = this.predecessor;
            if (trieEntry4 != null) {
                if (trieEntry4.bitIndex == -1) {
                    sb2.append("predecessor=");
                    sb2.append("ROOT");
                } else {
                    sb2.append("predecessor=");
                    sb2.append((Object) this.predecessor.getKey());
                    sb2.append(" [");
                    sb2.append(this.predecessor.bitIndex);
                    sb2.append("]");
                }
            }
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class TrieMapIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> implements OrderedMapIterator<K, V> {
        public TrieEntry<K, V> previous;

        private TrieMapIterator() {
            super();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry != null) {
                return trieEntry.getKey();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry != null) {
                return trieEntry.getValue();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.previous != null;
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
        public TrieEntry<K, V> nextEntry() {
            TrieEntry<K, V> nextEntry = super.nextEntry();
            this.previous = nextEntry;
            return nextEntry;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return previousEntry().getKey();
        }

        public TrieEntry<K, V> previousEntry() {
            int i10 = this.expectedModCount;
            AbstractPatriciaTrie abstractPatriciaTrie = AbstractPatriciaTrie.this;
            if (i10 == abstractPatriciaTrie.modCount) {
                TrieEntry<K, V> trieEntry = this.previous;
                if (trieEntry != null) {
                    this.previous = abstractPatriciaTrie.previousEntry(trieEntry);
                    this.next = this.current;
                    this.current = trieEntry;
                    return trieEntry;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v2) {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry != null) {
                return trieEntry.setValue(v2);
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class Values extends AbstractCollection<V> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class ValueIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<V> {
            private ValueIterator() {
                super();
            }

            @Override // java.util.Iterator
            public V next() {
                return nextEntry().getValue();
            }
        }

        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Iterator<V> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                if (AbstractBitwiseTrie.compare(iterator2.next(), obj)) {
                    iterator2.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }
    }

    public AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        super(keyAnalyzer);
        this.root = new TrieEntry<>(null, null, -1);
        this.size = 0;
        this.modCount = 0;
    }

    private SortedMap<K, V> getPrefixMapByBits(K k10, int i10, int i11) {
        int i12 = i10 + i11;
        if (i12 <= lengthInBits(k10)) {
            return i12 == 0 ? this : new PrefixRangeMap(k10, i10, i11);
        }
        throw new IllegalArgumentException(i10 + " + " + i11 + " > " + lengthInBits(k10));
    }

    private void incrementModCount() {
        this.modCount++;
    }

    public static boolean isValidUplink(TrieEntry<?, ?> trieEntry, TrieEntry<?, ?> trieEntry2) {
        return (trieEntry == null || trieEntry.bitIndex > trieEntry2.bitIndex || trieEntry.isEmpty()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.root = new TrieEntry<>(null, null, -1);
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void removeExternalEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry != this.root) {
            if (trieEntry.isExternalNode()) {
                TrieEntry<K, V> trieEntry2 = trieEntry.parent;
                TrieEntry<K, V> trieEntry3 = trieEntry.left;
                if (trieEntry3 == trieEntry) {
                    trieEntry3 = trieEntry.right;
                }
                if (trieEntry2.left == trieEntry) {
                    trieEntry2.left = trieEntry3;
                } else {
                    trieEntry2.right = trieEntry3;
                }
                if (trieEntry3.bitIndex > trieEntry2.bitIndex) {
                    trieEntry3.parent = trieEntry2;
                    return;
                } else {
                    trieEntry3.predecessor = trieEntry2;
                    return;
                }
            }
            throw new IllegalArgumentException(((Object) trieEntry) + " is not an external Entry!");
        }
        throw new IllegalArgumentException("Cannot delete root Entry!");
    }

    private void removeInternalEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry != this.root) {
            if (trieEntry.isInternalNode()) {
                TrieEntry<K, V> trieEntry2 = trieEntry.predecessor;
                trieEntry2.bitIndex = trieEntry.bitIndex;
                TrieEntry<K, V> trieEntry3 = trieEntry2.parent;
                TrieEntry<K, V> trieEntry4 = trieEntry2.left;
                if (trieEntry4 == trieEntry) {
                    trieEntry4 = trieEntry2.right;
                }
                if (trieEntry2.predecessor == trieEntry2 && trieEntry3 != trieEntry) {
                    trieEntry2.predecessor = trieEntry3;
                }
                if (trieEntry3.left == trieEntry2) {
                    trieEntry3.left = trieEntry4;
                } else {
                    trieEntry3.right = trieEntry4;
                }
                if (trieEntry4.bitIndex > trieEntry3.bitIndex) {
                    trieEntry4.parent = trieEntry3;
                }
                TrieEntry<K, V> trieEntry5 = trieEntry.left;
                if (trieEntry5.parent == trieEntry) {
                    trieEntry5.parent = trieEntry2;
                }
                TrieEntry<K, V> trieEntry6 = trieEntry.right;
                if (trieEntry6.parent == trieEntry) {
                    trieEntry6.parent = trieEntry2;
                }
                TrieEntry<K, V> trieEntry7 = trieEntry.parent;
                if (trieEntry7.left == trieEntry) {
                    trieEntry7.left = trieEntry2;
                } else {
                    trieEntry7.right = trieEntry2;
                }
                trieEntry2.parent = trieEntry7;
                TrieEntry<K, V> trieEntry8 = trieEntry.left;
                trieEntry2.left = trieEntry8;
                trieEntry2.right = trieEntry.right;
                if (isValidUplink(trieEntry8, trieEntry2)) {
                    trieEntry2.left.predecessor = trieEntry2;
                }
                if (isValidUplink(trieEntry2.right, trieEntry2)) {
                    trieEntry2.right.predecessor = trieEntry2;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(((Object) trieEntry) + " is not an internal Entry!");
        }
        throw new IllegalArgumentException("Cannot delete root Entry!");
    }

    private boolean selectR(TrieEntry<K, V> trieEntry, int i10, K k10, int i11, Reference<Map.Entry<K, V>> reference) {
        int i12 = trieEntry.bitIndex;
        if (i12 <= i10) {
            if (trieEntry.isEmpty()) {
                return true;
            }
            reference.set(trieEntry);
            return false;
        }
        if (!isBitSet(k10, i12, i11)) {
            if (selectR(trieEntry.left, trieEntry.bitIndex, k10, i11, reference)) {
                return selectR(trieEntry.right, trieEntry.bitIndex, k10, i11, reference);
            }
        } else if (selectR(trieEntry.right, trieEntry.bitIndex, k10, i11, reference)) {
            return selectR(trieEntry.left, trieEntry.bitIndex, k10, i11, reference);
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public TrieEntry<K, V> addEntry(TrieEntry<K, V> trieEntry, int i10) {
        TrieEntry<K, V> trieEntry2;
        int i11;
        TrieEntry<K, V> trieEntry3 = this.root;
        TrieEntry<K, V> trieEntry4 = trieEntry3.left;
        while (true) {
            TrieEntry<K, V> trieEntry5 = trieEntry4;
            trieEntry2 = trieEntry3;
            trieEntry3 = trieEntry5;
            int i12 = trieEntry3.bitIndex;
            i11 = trieEntry.bitIndex;
            if (i12 >= i11 || i12 <= trieEntry2.bitIndex) {
                break;
            }
            if (!isBitSet(trieEntry.key, i12, i10)) {
                trieEntry4 = trieEntry3.left;
            } else {
                trieEntry4 = trieEntry3.right;
            }
        }
        trieEntry.predecessor = trieEntry;
        if (!isBitSet(trieEntry.key, i11, i10)) {
            trieEntry.left = trieEntry;
            trieEntry.right = trieEntry3;
        } else {
            trieEntry.left = trieEntry3;
            trieEntry.right = trieEntry;
        }
        trieEntry.parent = trieEntry2;
        int i13 = trieEntry3.bitIndex;
        if (i13 >= trieEntry.bitIndex) {
            trieEntry3.parent = trieEntry;
        }
        int i14 = trieEntry2.bitIndex;
        if (i13 <= i14) {
            trieEntry3.predecessor = trieEntry;
        }
        if (trieEntry2 != this.root && isBitSet(trieEntry.key, i14, i10)) {
            trieEntry2.right = trieEntry;
        } else {
            trieEntry2.left = trieEntry;
        }
        return trieEntry;
    }

    public TrieEntry<K, V> ceilingEntry(K k10) {
        int lengthInBits = lengthInBits(k10);
        if (lengthInBits == 0) {
            if (!this.root.isEmpty()) {
                return this.root;
            }
            return firstEntry();
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k10, lengthInBits);
        if (compareKeys(k10, nearestEntryForKey.key)) {
            return nearestEntryForKey;
        }
        int bitIndex = bitIndex(k10, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k10, null, bitIndex);
            addEntry(trieEntry, lengthInBits);
            incrementSize();
            TrieEntry<K, V> nextEntry = nextEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return nextEntry;
        }
        if (KeyAnalyzer.isNullBitKey(bitIndex)) {
            if (!this.root.isEmpty()) {
                return this.root;
            }
            return firstEntry();
        }
        if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
            return nearestEntryForKey;
        }
        throw new IllegalStateException("invalid lookup: " + ((Object) k10));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        TrieEntry<K, V> trieEntry = this.root;
        trieEntry.key = null;
        trieEntry.bitIndex = -1;
        trieEntry.value = null;
        trieEntry.parent = null;
        trieEntry.left = trieEntry;
        trieEntry.right = null;
        trieEntry.predecessor = trieEntry;
        this.size = 0;
        incrementModCount();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return getKeyAnalyzer();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        K castKey = castKey(obj);
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(castKey, lengthInBits(castKey));
        return !nearestEntryForKey.isEmpty() && compareKeys(castKey, nearestEntryForKey.key);
    }

    public void decrementSize() {
        this.size--;
        incrementModCount();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet();
        }
        return this.entrySet;
    }

    public TrieEntry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return followLeft(this.root);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        if (size() != 0) {
            return firstEntry().getKey();
        }
        throw new NoSuchElementException();
    }

    public TrieEntry<K, V> floorEntry(K k10) {
        int lengthInBits = lengthInBits(k10);
        if (lengthInBits == 0) {
            if (this.root.isEmpty()) {
                return null;
            }
            return this.root;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k10, lengthInBits);
        if (compareKeys(k10, nearestEntryForKey.key)) {
            return nearestEntryForKey;
        }
        int bitIndex = bitIndex(k10, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k10, null, bitIndex);
            addEntry(trieEntry, lengthInBits);
            incrementSize();
            TrieEntry<K, V> previousEntry = previousEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return previousEntry;
        }
        if (KeyAnalyzer.isNullBitKey(bitIndex)) {
            if (this.root.isEmpty()) {
                return null;
            }
            return this.root;
        }
        if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
            return nearestEntryForKey;
        }
        throw new IllegalStateException("invalid lookup: " + ((Object) k10));
    }

    public TrieEntry<K, V> followLeft(TrieEntry<K, V> trieEntry) {
        while (true) {
            TrieEntry<K, V> trieEntry2 = trieEntry.left;
            if (trieEntry2.isEmpty()) {
                trieEntry2 = trieEntry.right;
            }
            if (trieEntry2.bitIndex <= trieEntry.bitIndex) {
                return trieEntry2;
            }
            trieEntry = trieEntry2;
        }
    }

    public TrieEntry<K, V> followRight(TrieEntry<K, V> trieEntry) {
        if (trieEntry.right == null) {
            return null;
        }
        while (true) {
            TrieEntry<K, V> trieEntry2 = trieEntry.right;
            if (trieEntry2.bitIndex <= trieEntry.bitIndex) {
                return trieEntry2;
            }
            trieEntry = trieEntry2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        TrieEntry<K, V> entry = getEntry(obj);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public TrieEntry<K, V> getEntry(Object obj) {
        K castKey = castKey(obj);
        if (castKey == null) {
            return null;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(castKey, lengthInBits(castKey));
        if (nearestEntryForKey.isEmpty() || !compareKeys(castKey, nearestEntryForKey.key)) {
            return null;
        }
        return nearestEntryForKey;
    }

    public TrieEntry<K, V> getNearestEntryForKey(K k10, int i10) {
        TrieEntry<K, V> trieEntry = this.root;
        TrieEntry<K, V> trieEntry2 = trieEntry.left;
        while (true) {
            TrieEntry<K, V> trieEntry3 = trieEntry2;
            TrieEntry<K, V> trieEntry4 = trieEntry;
            trieEntry = trieEntry3;
            int i11 = trieEntry.bitIndex;
            if (i11 <= trieEntry4.bitIndex) {
                return trieEntry;
            }
            if (!isBitSet(k10, i11, i10)) {
                trieEntry2 = trieEntry.left;
            } else {
                trieEntry2 = trieEntry.right;
            }
        }
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k10) {
        return new RangeEntryMap(this, null, k10);
    }

    public TrieEntry<K, V> higherEntry(K k10) {
        int lengthInBits = lengthInBits(k10);
        if (lengthInBits == 0) {
            if (!this.root.isEmpty()) {
                if (size() > 1) {
                    return nextEntry(this.root);
                }
                return null;
            }
            return firstEntry();
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k10, lengthInBits);
        if (compareKeys(k10, nearestEntryForKey.key)) {
            return nextEntry(nearestEntryForKey);
        }
        int bitIndex = bitIndex(k10, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k10, null, bitIndex);
            addEntry(trieEntry, lengthInBits);
            incrementSize();
            TrieEntry<K, V> nextEntry = nextEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return nextEntry;
        }
        if (KeyAnalyzer.isNullBitKey(bitIndex)) {
            if (!this.root.isEmpty()) {
                return firstEntry();
            }
            if (size() > 1) {
                return nextEntry(firstEntry());
            }
            return null;
        }
        if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
            return nextEntry(nearestEntryForKey);
        }
        throw new IllegalStateException("invalid lookup: " + ((Object) k10));
    }

    public void incrementSize() {
        this.size++;
        incrementModCount();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        if (this.keySet == null) {
            this.keySet = new KeySet();
        }
        return this.keySet;
    }

    public TrieEntry<K, V> lastEntry() {
        return followRight(this.root.left);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        TrieEntry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public TrieEntry<K, V> lowerEntry(K k10) {
        int lengthInBits = lengthInBits(k10);
        if (lengthInBits == 0) {
            return null;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k10, lengthInBits);
        if (compareKeys(k10, nearestEntryForKey.key)) {
            return previousEntry(nearestEntryForKey);
        }
        int bitIndex = bitIndex(k10, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k10, null, bitIndex);
            addEntry(trieEntry, lengthInBits);
            incrementSize();
            TrieEntry<K, V> previousEntry = previousEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return previousEntry;
        }
        if (KeyAnalyzer.isNullBitKey(bitIndex)) {
            return null;
        }
        if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
            return previousEntry(nearestEntryForKey);
        }
        throw new IllegalStateException("invalid lookup: " + ((Object) k10));
    }

    public TrieEntry<K, V> nextEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry == null) {
            return firstEntry();
        }
        return nextEntryImpl(trieEntry.predecessor, trieEntry, null);
    }

    public TrieEntry<K, V> nextEntryImpl(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2, TrieEntry<K, V> trieEntry3) {
        TrieEntry<K, V> trieEntry4;
        TrieEntry<K, V> trieEntry5;
        if (trieEntry2 == null || trieEntry != trieEntry2.predecessor) {
            while (!trieEntry.left.isEmpty() && trieEntry2 != (trieEntry4 = trieEntry.left)) {
                if (isValidUplink(trieEntry4, trieEntry)) {
                    return trieEntry.left;
                }
                trieEntry = trieEntry.left;
            }
        }
        if (trieEntry.isEmpty() || (trieEntry5 = trieEntry.right) == null) {
            return null;
        }
        if (trieEntry2 != trieEntry5) {
            if (isValidUplink(trieEntry5, trieEntry)) {
                return trieEntry.right;
            }
            return nextEntryImpl(trieEntry.right, trieEntry2, trieEntry3);
        }
        while (true) {
            TrieEntry<K, V> trieEntry6 = trieEntry.parent;
            TrieEntry<K, V> trieEntry7 = trieEntry6.right;
            if (trieEntry != trieEntry7) {
                if (trieEntry == trieEntry3 || trieEntry7 == null) {
                    return null;
                }
                if (trieEntry2 != trieEntry7 && isValidUplink(trieEntry7, trieEntry6)) {
                    return trieEntry.parent.right;
                }
                TrieEntry<K, V> trieEntry8 = trieEntry.parent;
                TrieEntry<K, V> trieEntry9 = trieEntry8.right;
                if (trieEntry9 == trieEntry8) {
                    return null;
                }
                return nextEntryImpl(trieEntry9, trieEntry2, trieEntry3);
            }
            if (trieEntry == trieEntry3) {
                return null;
            }
            trieEntry = trieEntry6;
        }
    }

    public TrieEntry<K, V> nextEntryInSubtree(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
        if (trieEntry == null) {
            return firstEntry();
        }
        return nextEntryImpl(trieEntry.predecessor, trieEntry, trieEntry2);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k10) {
        TrieEntry<K, V> nextEntry;
        Objects.requireNonNull(k10);
        TrieEntry<K, V> entry = getEntry(k10);
        if (entry == null || (nextEntry = nextEntry(entry)) == null) {
            return null;
        }
        return nextEntry.getKey();
    }

    @Override // org.apache.commons.collections4.Trie
    public SortedMap<K, V> prefixMap(K k10) {
        return getPrefixMapByBits(k10, 0, lengthInBits(k10));
    }

    public TrieEntry<K, V> previousEntry(TrieEntry<K, V> trieEntry) {
        TrieEntry<K, V> trieEntry2;
        TrieEntry<K, V> trieEntry3 = trieEntry.predecessor;
        if (trieEntry3 != null) {
            if (trieEntry3.right == trieEntry) {
                if (isValidUplink(trieEntry3.left, trieEntry3)) {
                    return trieEntry.predecessor.left;
                }
                return followRight(trieEntry.predecessor.left);
            }
            while (true) {
                trieEntry2 = trieEntry3.parent;
                if (trieEntry2 == null || trieEntry3 != trieEntry2.left) {
                    break;
                }
                trieEntry3 = trieEntry2;
            }
            if (trieEntry2 == null) {
                return null;
            }
            if (isValidUplink(trieEntry2.left, trieEntry2)) {
                TrieEntry<K, V> trieEntry4 = trieEntry3.parent.left;
                TrieEntry<K, V> trieEntry5 = this.root;
                if (trieEntry4 != trieEntry5) {
                    return trieEntry4;
                }
                if (trieEntry5.isEmpty()) {
                    return null;
                }
                return this.root;
            }
            return followRight(trieEntry3.parent.left);
        }
        throw new IllegalArgumentException("must have come from somewhere!");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k10) {
        TrieEntry<K, V> previousEntry;
        Objects.requireNonNull(k10);
        TrieEntry<K, V> entry = getEntry(k10);
        if (entry == null || (previousEntry = previousEntry(entry)) == null) {
            return null;
        }
        return previousEntry.getKey();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v2) {
        Objects.requireNonNull(k10, "Key cannot be null");
        int lengthInBits = lengthInBits(k10);
        if (lengthInBits == 0) {
            if (this.root.isEmpty()) {
                incrementSize();
            } else {
                incrementModCount();
            }
            return this.root.setKeyValue(k10, v2);
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k10, lengthInBits);
        if (compareKeys(k10, nearestEntryForKey.key)) {
            if (nearestEntryForKey.isEmpty()) {
                incrementSize();
            } else {
                incrementModCount();
            }
            return nearestEntryForKey.setKeyValue(k10, v2);
        }
        int bitIndex = bitIndex(k10, nearestEntryForKey.key);
        if (!KeyAnalyzer.isOutOfBoundsIndex(bitIndex)) {
            if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
                addEntry(new TrieEntry<>(k10, v2, bitIndex), lengthInBits);
                incrementSize();
                return null;
            }
            if (KeyAnalyzer.isNullBitKey(bitIndex)) {
                if (this.root.isEmpty()) {
                    incrementSize();
                } else {
                    incrementModCount();
                }
                return this.root.setKeyValue(k10, v2);
            }
            if (KeyAnalyzer.isEqualBitKey(bitIndex) && nearestEntryForKey != this.root) {
                incrementModCount();
                return nearestEntryForKey.setKeyValue(k10, v2);
            }
        }
        throw new IllegalArgumentException("Failed to put: " + ((Object) k10) + " -> " + ((Object) v2) + ", " + bitIndex);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        K castKey = castKey(obj);
        int lengthInBits = lengthInBits(castKey);
        TrieEntry<K, V> trieEntry = this.root;
        TrieEntry<K, V> trieEntry2 = trieEntry.left;
        while (true) {
            TrieEntry<K, V> trieEntry3 = trieEntry2;
            TrieEntry<K, V> trieEntry4 = trieEntry;
            trieEntry = trieEntry3;
            int i10 = trieEntry.bitIndex;
            if (i10 <= trieEntry4.bitIndex) {
                break;
            }
            if (!isBitSet(castKey, i10, lengthInBits)) {
                trieEntry2 = trieEntry.left;
            } else {
                trieEntry2 = trieEntry.right;
            }
        }
        if (trieEntry.isEmpty() || !compareKeys(castKey, trieEntry.key)) {
            return null;
        }
        return removeEntry(trieEntry);
    }

    public V removeEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry != this.root) {
            if (trieEntry.isInternalNode()) {
                removeInternalEntry(trieEntry);
            } else {
                removeExternalEntry(trieEntry);
            }
        }
        decrementSize();
        return trieEntry.setKeyValue(null, null);
    }

    public Map.Entry<K, V> select(K k10) {
        int lengthInBits = lengthInBits(k10);
        Reference<Map.Entry<K, V>> reference = new Reference<>();
        if (selectR(this.root.left, -1, k10, lengthInBits, reference)) {
            return null;
        }
        return reference.get();
    }

    public K selectKey(K k10) {
        Map.Entry<K, V> select = select(k10);
        if (select == null) {
            return null;
        }
        return select.getKey();
    }

    public V selectValue(K k10) {
        Map.Entry<K, V> select = select(k10);
        if (select == null) {
            return null;
        }
        return select.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k10, K k11) {
        return new RangeEntryMap(this, k10, k11);
    }

    public TrieEntry<K, V> subtree(K k10, int i10, int i11) {
        TrieEntry<K, V> trieEntry;
        TrieEntry<K, V> trieEntry2 = this.root;
        TrieEntry<K, V> trieEntry3 = trieEntry2.left;
        while (true) {
            TrieEntry<K, V> trieEntry4 = trieEntry3;
            trieEntry = trieEntry2;
            trieEntry2 = trieEntry4;
            int i12 = trieEntry2.bitIndex;
            if (i12 <= trieEntry.bitIndex || i11 <= i12) {
                break;
            }
            if (!isBitSet(k10, i12 + i10, i10 + i11)) {
                trieEntry3 = trieEntry2.left;
            } else {
                trieEntry3 = trieEntry2.right;
            }
        }
        if (trieEntry2.isEmpty()) {
            trieEntry2 = trieEntry;
        }
        if (trieEntry2.isEmpty()) {
            return null;
        }
        int i13 = i10 + i11;
        if (trieEntry2 == this.root && lengthInBits(trieEntry2.getKey()) < i13) {
            return null;
        }
        boolean isBitSet = isBitSet(k10, i13 - 1, i13);
        K k11 = trieEntry2.key;
        if (isBitSet != isBitSet(k11, i11 - 1, lengthInBits(k11))) {
            return null;
        }
        int bitIndex = getKeyAnalyzer().bitIndex(k10, i10, i11, trieEntry2.key, 0, lengthInBits(trieEntry2.getKey()));
        if (bitIndex < 0 || bitIndex >= i11) {
            return trieEntry2;
        }
        return null;
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k10) {
        return new RangeEntryMap(this, k10, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        if (this.values == null) {
            this.values = new Values();
        }
        return this.values;
    }

    @Override // org.apache.commons.collections4.trie.AbstractBitwiseTrie, org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new TrieMapIterator();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public abstract class TrieIterator<E> implements Iterator<E> {
        public TrieEntry<K, V> current;
        public int expectedModCount;
        public TrieEntry<K, V> next;

        public TrieIterator() {
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            this.next = AbstractPatriciaTrie.this.nextEntry(null);
        }

        public TrieEntry<K, V> findNext(TrieEntry<K, V> trieEntry) {
            return AbstractPatriciaTrie.this.nextEntry(trieEntry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        public TrieEntry<K, V> nextEntry() {
            if (this.expectedModCount == AbstractPatriciaTrie.this.modCount) {
                TrieEntry<K, V> trieEntry = this.next;
                if (trieEntry != null) {
                    this.next = findNext(trieEntry);
                    this.current = trieEntry;
                    return trieEntry;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry != null) {
                int i10 = this.expectedModCount;
                AbstractPatriciaTrie abstractPatriciaTrie = AbstractPatriciaTrie.this;
                if (i10 == abstractPatriciaTrie.modCount) {
                    this.current = null;
                    abstractPatriciaTrie.removeEntry(trieEntry);
                    this.expectedModCount = AbstractPatriciaTrie.this.modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException();
        }

        public TrieIterator(TrieEntry<K, V> trieEntry) {
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            this.next = trieEntry;
        }
    }

    public AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer, Map<? extends K, ? extends V> map) {
        super(keyAnalyzer);
        this.root = new TrieEntry<>(null, null, -1);
        this.size = 0;
        this.modCount = 0;
        putAll(map);
    }
}
