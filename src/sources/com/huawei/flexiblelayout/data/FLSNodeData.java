package com.huawei.flexiblelayout.data;

import com.huawei.flexiblelayout.data.FLDataGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLSNodeData extends FLNodeData {

    /* renamed from: n, reason: collision with root package name */
    private int f28073n;

    /* renamed from: o, reason: collision with root package name */
    private int f28074o;

    /* renamed from: p, reason: collision with root package name */
    private FLDataSource f28075p;

    /* renamed from: q, reason: collision with root package name */
    private final List<FLCardData> f28076q;

    public FLSNodeData(String str) {
        super(str);
        this.f28076q = new ArrayList();
    }

    private void d() {
        Iterator<FLCardData> iterator2 = this.f28076q.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().update();
        }
        this.f28076q.clear();
    }

    @Override // com.huawei.flexiblelayout.data.FLNodeData
    public void addChild(FLCardData fLCardData) {
        if (!(fLCardData instanceof FLNodeData)) {
            FLNodeData build = FLayoutSpec.node().build();
            build.addChild(fLCardData);
            fLCardData = build;
        }
        super.addChild(fLCardData);
        final List<FLCardData> list = this.f28076q;
        list.getClass();
        fLCardData.a(new a() { // from class: com.huawei.flexiblelayout.data.l
            @Override // com.huawei.flexiblelayout.data.a
            public final void update(FLCardData fLCardData2) {
                List.this.add(fLCardData2);
            }
        });
    }

    public void appendToGroup(FLDataGroup fLDataGroup) {
        FLDataGroup.PendingDataSet addData = fLDataGroup.addData();
        for (FLCardData fLCardData : super.c()) {
            fLCardData.a((FLCardData) null);
            addData.add((FLNodeData) fLCardData);
        }
        addData.commit();
        d();
    }

    public FLDataSource getDataSource() {
        return this.f28075p;
    }

    public int getLastPosition() {
        return this.f28073n;
    }

    public int getSpaceOffset() {
        return this.f28074o;
    }

    public void setDataSource(FLDataSource fLDataSource) {
        this.f28075p = fLDataSource;
    }

    public void setLastPosition(int i10) {
        this.f28073n = i10;
    }

    public void setSpaceOffset(int i10) {
        this.f28074o = i10;
    }
}
