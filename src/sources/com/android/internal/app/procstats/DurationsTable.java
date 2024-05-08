package com.android.internal.app.procstats;

import com.android.internal.app.procstats.SparseMappingTable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DurationsTable extends SparseMappingTable.Table {
    public DurationsTable(SparseMappingTable tableData) {
        super(tableData);
    }

    public void addDurations(DurationsTable from) {
        int N = from.getKeyCount();
        for (int i10 = 0; i10 < N; i10++) {
            int key = from.getKeyAt(i10);
            addDuration(SparseMappingTable.getIdFromKey(key), from.getValue(key));
        }
    }

    public void addDuration(int state, long value) {
        int key = getOrAddKey((byte) state, 1);
        setValue(key, getValue(key) + value);
    }
}
