package com.huawei.flexiblelayout;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.BlockNodeData;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.FLUnionDataGroup;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy;
import com.huawei.flexiblelayout.layoutstrategy.ReactLayoutStrategy;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.DataItem;
import com.huawei.flexiblelayout.parser.DataKeys;
import com.huawei.flexiblelayout.parser.FLDataDelegate;
import com.huawei.flexiblelayout.parser.FLDataParser;
import com.huawei.flexiblelayout.parser.FLDataStream;
import com.huawei.flexiblelayout.parser.csslink.CSSLinkManager;
import com.huawei.flexiblelayout.parser.csslink.LinkProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DataStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c1 implements FLDataStream {

    /* renamed from: g, reason: collision with root package name */
    private static final String f27746g = "DataStream";

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f27747h = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final DataItem f27748a = DataItem.rootIt();

    /* renamed from: b, reason: collision with root package name */
    private final FLDataSource f27749b = new FLDataSource();

    /* renamed from: c, reason: collision with root package name */
    private int f27750c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final FLEngine f27751d;

    /* renamed from: e, reason: collision with root package name */
    private final FLDataParser f27752e;

    /* renamed from: f, reason: collision with root package name */
    private final FLDataDelegate f27753f;

    /* compiled from: DataStream.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FLDataSource f27754a;

        public a(FLDataSource fLDataSource) {
            this.f27754a = fLDataSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            c1.this.a(this.f27754a);
        }
    }

    public c1(FLEngine fLEngine, FLDataParser fLDataParser, FLDataDelegate fLDataDelegate) {
        this.f27751d = fLEngine;
        this.f27752e = fLDataParser;
        this.f27753f = fLDataDelegate;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataStream
    public void apply(FLDataSource fLDataSource) {
        apply(fLDataSource, true);
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataStream
    public int getResult() {
        return this.f27750c;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataStream
    public DataItem getRoot() {
        return this.f27748a;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataStream
    public void setResult(int i10) {
        this.f27750c = i10;
    }

    @NonNull
    private FLDataGroup a(@NonNull FLDataSource fLDataSource, @NonNull DataItem dataItem) {
        FLDataGroup a10 = a(fLDataSource, dataItem.getId(), dataItem.getData().optInt(DataKeys.unionId()));
        if (a10 != null) {
            return a10;
        }
        FLDataGroup build = FLDataGroup.create().id(dataItem.getId()).data(dataItem.getData()).flex(dataItem.getGroupLayoutStrategy()).build();
        CSSLinkManager.getInstance().putLinkProvider(build, dataItem.getLinkProvider());
        return build;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataStream
    public void apply(FLDataSource fLDataSource, boolean z10) {
        if (z10 && Looper.myLooper() != Looper.getMainLooper()) {
            f27747h.post(new a(fLDataSource));
        } else {
            a(fLDataSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FLDataSource fLDataSource) {
        while (this.f27749b.getDataGroupSize() != 0) {
            FLDataGroup dataGroupByIndex = this.f27749b.getDataGroupByIndex(0);
            this.f27749b.removeGroup(dataGroupByIndex);
            a(dataGroupByIndex, fLDataSource);
        }
    }

    public void a() {
        for (DataItem dataItem : this.f27748a.getChildList()) {
            FLDataGroup a10 = a(this.f27749b, dataItem);
            List<FLNodeData> a11 = a(a10, dataItem);
            FLDataGroup a12 = a(this.f27749b, a10, dataItem);
            if (a12 != null) {
                a12.addData(a11);
                if (!a12.isAttached()) {
                    this.f27749b.addGroup(a12);
                }
            }
        }
    }

    private void a(@NonNull FLDataGroup fLDataGroup, @NonNull FLDataSource fLDataSource) {
        int optInt = fLDataGroup.getData().optInt(DataKeys.unionId());
        FLDataGroup a10 = a(fLDataSource, fLDataGroup.getId(), optInt);
        if (optInt == 0) {
            if (a10 != null) {
                if (a10 instanceof FLUnionDataGroup) {
                    Log.w(f27746g, "Unreachable, not expected FLUnionDataGroup.");
                    return;
                } else {
                    a(fLDataGroup, a10);
                    return;
                }
            }
            fLDataSource.addGroup(fLDataGroup);
            return;
        }
        if (a10 != null) {
            if (a10 instanceof FLUnionDataGroup) {
                ((FLUnionDataGroup) a10).addGroup(fLDataGroup);
                return;
            } else {
                Log.w(f27746g, "Unreachable, expected FLUnionDataGroup.");
                return;
            }
        }
        GroupLayoutStrategy groupLayoutStrategy = fLDataGroup.getGroupLayoutStrategy();
        FLUnionDataGroup fLUnionDataGroup = new FLUnionDataGroup(optInt, Jsons.newJson(), groupLayoutStrategy);
        if (groupLayoutStrategy instanceof ReactLayoutStrategy) {
            ((ReactLayoutStrategy) groupLayoutStrategy).setLineBreakMode(ReactLayoutStrategy.LineBreakMode.loose);
        }
        CSSLinkManager.getInstance().putLinkProvider(fLUnionDataGroup, CSSLinkManager.getInstance().getLinkProvider(fLDataGroup));
        CSSLinkManager.getInstance().putLinkProvider(fLDataGroup, null);
        fLUnionDataGroup.addGroup(fLDataGroup);
        fLDataSource.addGroup(fLUnionDataGroup);
    }

    public static FLDataGroup a(@NonNull FLDataSource fLDataSource, int i10, int i11) {
        if (i11 != 0) {
            i10 = i11;
        }
        int dataGroupSize = fLDataSource.getDataGroupSize();
        for (int i12 = 0; i12 < dataGroupSize; i12++) {
            FLDataGroup dataGroupByIndex = fLDataSource.getDataGroupByIndex(i12);
            if (dataGroupByIndex.getId() == i10 && dataGroupByIndex.getData().optInt(DataKeys.unionId()) == i11) {
                return dataGroupByIndex;
            }
        }
        return null;
    }

    public static void a(@NonNull FLDataGroup fLDataGroup, FLDataGroup fLDataGroup2) {
        FLDataGroup.Cursor newCursor = fLDataGroup.newCursor(0);
        FLDataGroup.PendingDataSet addData = fLDataGroup2.addData();
        while (newCursor.hasNext()) {
            addData.add(newCursor.next());
        }
        addData.commit();
    }

    private List<FLNodeData> a(FLDataGroup fLDataGroup, DataItem dataItem) {
        FLayoutSpec.FNodeSpec nodeSpec;
        LinkProvider linkProvider = CSSLinkManager.getInstance().getLinkProvider(fLDataGroup);
        List<DataItem> childList = dataItem.getChildList();
        ArrayList arrayList = new ArrayList(childList.size());
        for (DataItem dataItem2 : childList) {
            b.C0271b a10 = new b.C0271b().a(linkProvider);
            if (dataItem2.isCombo()) {
                a10.a(this.f27752e).a(dataItem2.getData());
                nodeSpec = dataItem2.comboSpec();
            } else {
                nodeSpec = dataItem2.nodeSpec();
                Iterator<DataItem> iterator2 = dataItem2.getChildList().iterator2();
                while (iterator2.hasNext()) {
                    a(nodeSpec, iterator2.next());
                }
            }
            FLNodeData build = nodeSpec.build(a10.a());
            if (build instanceof BlockNodeData) {
                a(fLDataGroup, dataItem2, ((BlockNodeData) build).c(), arrayList);
            } else {
                FLNodeData a11 = a(fLDataGroup, build, dataItem2);
                if (a11 != null) {
                    arrayList.add(a11);
                }
            }
        }
        return arrayList;
    }

    private void a(FLDataGroup fLDataGroup, DataItem dataItem, List<FLCardData> list, List<FLNodeData> list2) {
        FLNodeData fLNodeData;
        for (FLCardData fLCardData : list) {
            if (!(fLCardData instanceof FLNodeData)) {
                fLNodeData = FLayoutSpec.node().build();
                fLNodeData.addChild(fLCardData);
            } else {
                fLNodeData = (FLNodeData) fLCardData;
            }
            FLNodeData a10 = a(fLDataGroup, fLNodeData, dataItem);
            if (a10 != null) {
                list2.add(a10);
            }
        }
    }

    private void a(FLayoutSpec.FNodeSpec fNodeSpec, DataItem dataItem) {
        if (dataItem.isNode()) {
            FLayoutSpec.FNodeSpec nodeSpec = dataItem.nodeSpec();
            Iterator<DataItem> iterator2 = dataItem.getChildList().iterator2();
            while (iterator2.hasNext()) {
                a(nodeSpec, iterator2.next());
            }
            fNodeSpec.child(nodeSpec);
            return;
        }
        fNodeSpec.child(dataItem.cardSpec());
    }

    @Nullable
    public FLNodeData a(FLDataGroup fLDataGroup, FLNodeData fLNodeData, DataItem dataItem) {
        FLDataDelegate fLDataDelegate = this.f27753f;
        return fLDataDelegate != null ? fLDataDelegate.onApplyNode(fLDataGroup, fLNodeData, dataItem) : fLNodeData;
    }

    @Nullable
    public FLDataGroup a(FLDataSource fLDataSource, FLDataGroup fLDataGroup, DataItem dataItem) {
        FLDataDelegate fLDataDelegate = this.f27753f;
        return fLDataDelegate != null ? fLDataDelegate.onApplyGroup(fLDataSource, fLDataGroup, dataItem) : fLDataGroup;
    }
}
