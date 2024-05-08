package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;
    public transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i10) {
        return new CompactLinkedHashMap<>(i10);
    }

    private int getPredecessor(int i10) {
        return ((int) (link(i10) >>> 32)) - 1;
    }

    private long link(int i10) {
        return requireLinks()[i10];
    }

    private long[] requireLinks() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void setLink(int i10, long j10) {
        requireLinks()[i10] = j10;
    }

    private void setPredecessor(int i10, int i11) {
        setLink(i10, (link(i10) & 4294967295L) | ((i11 + 1) << 32));
    }

    private void setSucceeds(int i10, int i11) {
        if (i10 == -2) {
            this.firstEntry = i11;
        } else {
            setSuccessor(i10, i11);
        }
        if (i11 == -2) {
            this.lastEntry = i10;
        } else {
            setPredecessor(i11, i10);
        }
    }

    private void setSuccessor(int i10, int i11) {
        setLink(i10, (link(i10) & (-4294967296L)) | ((i11 + 1) & 4294967295L));
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i10) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i10), getSuccessor(i10));
            setSucceeds(this.lastEntry, i10);
            setSucceeds(i10, -2);
            incrementModCount();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i10, int i11) {
        return i10 >= size() ? i11 : i10;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int allocArrays() {
        int allocArrays = super.allocArrays();
        this.links = new long[allocArrays];
        return allocArrays;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = this.links;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return convertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> createHashFloodingResistantDelegate(int i10) {
        return new LinkedHashMap(i10, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i10) {
        return ((int) link(i10)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i10) {
        super.init(i10);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i10, K k10, V v2, int i11, int i12) {
        super.insertEntry(i10, k10, v2, i11, i12);
        setSucceeds(this.lastEntry, i10);
        setSucceeds(i10, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i10, int i11) {
        int size = size() - 1;
        super.moveLastEntry(i10, i11);
        setSucceeds(getPredecessor(i10), getSuccessor(i10));
        if (i10 < size) {
            setSucceeds(getPredecessor(size), i10);
            setSucceeds(i10, getSuccessor(size));
        }
        setLink(size, 0L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i10) {
        super.resizeEntries(i10);
        this.links = Arrays.copyOf(requireLinks(), i10);
    }

    public CompactLinkedHashMap(int i10) {
        this(i10, false);
    }

    public CompactLinkedHashMap(int i10, boolean z10) {
        super(i10);
        this.accessOrder = z10;
    }
}
