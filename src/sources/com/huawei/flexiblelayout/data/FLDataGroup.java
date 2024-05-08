package com.huawei.flexiblelayout.data;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.changed.FLAddedDataRequest;
import com.huawei.flexiblelayout.data.changed.FLDataChangedRequest;
import com.huawei.flexiblelayout.data.changed.FLModifyDataRequest;
import com.huawei.flexiblelayout.data.changed.FLRemovedDataRequest;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.j0;
import com.huawei.flexiblelayout.layoutstrategy.DefaultLayoutStrategy;
import com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLDataGroup implements com.huawei.flexiblelayout.data.a {

    /* renamed from: i, reason: collision with root package name */
    private static Handler f28040i = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    private static final int f28041j = -1;

    /* renamed from: k, reason: collision with root package name */
    public static final String f28042k = "__DataGroupTag__";

    /* renamed from: a, reason: collision with root package name */
    private final int f28043a;

    /* renamed from: b, reason: collision with root package name */
    private final h<FLNodeData> f28044b;

    /* renamed from: c, reason: collision with root package name */
    private c f28045c;

    /* renamed from: d, reason: collision with root package name */
    private GroupLayoutStrategy f28046d;

    /* renamed from: g, reason: collision with root package name */
    private final j0 f28049g;

    /* renamed from: h, reason: collision with root package name */
    private final FLMap f28050h;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28048f = false;

    /* renamed from: e, reason: collision with root package name */
    private final Cursor f28047e = new Cursor(this, null);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f28051a = -1;

        /* renamed from: b, reason: collision with root package name */
        private FLMap f28052b;

        /* renamed from: c, reason: collision with root package name */
        private GroupLayoutStrategy f28053c;

        public FLDataGroup build() {
            return new FLDataGroup(this.f28051a, this.f28052b, this.f28053c);
        }

        public Builder data(FLMap fLMap) {
            this.f28052b = fLMap;
            return this;
        }

        public Builder flex(GroupLayoutStrategy groupLayoutStrategy) {
            this.f28053c = groupLayoutStrategy;
            return this;
        }

        public Builder id(int i10) {
            this.f28051a = i10;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class Cursor implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private int f28054a;

        /* renamed from: b, reason: collision with root package name */
        private int f28055b;

        /* renamed from: c, reason: collision with root package name */
        private FLDataGroup f28056c;

        public /* synthetic */ Cursor(FLDataGroup fLDataGroup, a aVar) {
            this();
        }

        public FLNodeData current() {
            return FLDataGroup.this.b(this.f28055b);
        }

        public int currentIndex() {
            return this.f28055b;
        }

        public FLDataGroup getDataGroup() {
            return this.f28056c;
        }

        public int getSize() {
            return FLDataGroup.this.f28044b.b();
        }

        public boolean hasNext() {
            return FLDataGroup.this.b(this.f28054a) != null;
        }

        public int indexOf(FLNodeData fLNodeData) {
            return FLDataGroup.this.f28044b.b((h) fLNodeData);
        }

        public void moveToFirst() {
            this.f28054a = 0;
            this.f28055b = 0;
        }

        public void moveToLast() {
            int b4 = FLDataGroup.this.f28044b.b() - 1;
            this.f28054a = b4;
            this.f28055b = b4;
        }

        public FLNodeData next() {
            FLNodeData b4 = FLDataGroup.this.b(this.f28054a);
            int i10 = this.f28054a;
            this.f28055b = i10;
            this.f28054a = i10 + 1;
            return b4;
        }

        private Cursor() {
            this.f28056c = FLDataGroup.this;
            this.f28054a = 0;
            this.f28055b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i10) {
            this.f28054a = i10;
            this.f28055b = i10;
        }

        @NonNull
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Cursor m2857clone() {
            try {
                return (Cursor) super.clone();
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class PendingDataSet {

        /* renamed from: a, reason: collision with root package name */
        private List<FLNodeData> f28058a = new ArrayList();

        public PendingDataSet() {
        }

        public PendingDataSet add(FLNodeData fLNodeData) {
            this.f28058a.add(fLNodeData);
            return this;
        }

        public void commit() {
            FLDataGroup.this.addData(this.f28058a);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FLCardData f28060a;

        public a(FLCardData fLCardData) {
            this.f28060a = fLCardData;
        }

        private void a(FLNodeData fLNodeData) {
            FLDataChangedRequest fLRemovedDataRequest;
            int indexToPosition = FLDataGroup.this.f28046d.indexToPosition(FLDataGroup.this.f28044b.b((h) fLNodeData));
            int a10 = FLDataGroup.this.f28049g.a(fLNodeData);
            if (a10 != 0) {
                if (a10 > 0) {
                    fLRemovedDataRequest = new FLAddedDataRequest(FLDataGroup.this, FLDataGroup.this.f28046d.indexToPosition(a10 - 1));
                } else {
                    fLRemovedDataRequest = new FLRemovedDataRequest(FLDataGroup.this, indexToPosition);
                }
                FLDataGroup.this.a(fLRemovedDataRequest);
            } else {
                b(fLNodeData);
            }
            fLNodeData.a();
        }

        private void b(FLNodeData fLNodeData) {
            int b4 = FLDataGroup.this.f28044b.b((h) fLNodeData);
            if (b4 != -1) {
                FLDataGroup fLDataGroup = FLDataGroup.this;
                FLModifyDataRequest fLModifyDataRequest = new FLModifyDataRequest(fLDataGroup, fLDataGroup.f28046d.indexToPosition(b4));
                fLModifyDataRequest.setPayload(fLNodeData);
                FLDataGroup.this.a(fLModifyDataRequest);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            FLCardData fLCardData = this.f28060a;
            if (fLCardData instanceof FLNodeData) {
                FLNodeData fLNodeData = (FLNodeData) fLCardData;
                if (fLNodeData.b()) {
                    a(fLNodeData);
                } else {
                    b(fLNodeData);
                }
            }
        }
    }

    public FLDataGroup(int i10, FLMap fLMap, GroupLayoutStrategy groupLayoutStrategy) {
        this.f28046d = DefaultLayoutStrategy.getInstance();
        this.f28043a = i10;
        this.f28050h = fLMap;
        if (groupLayoutStrategy != null) {
            this.f28046d = groupLayoutStrategy;
        }
        h<FLNodeData> hVar = new h<>(this.f28046d);
        this.f28044b = hVar;
        this.f28049g = new j0(hVar);
    }

    public static Builder create() {
        return new Builder();
    }

    public void addData(FLNodeData fLNodeData) {
        int size = getSize();
        a(fLNodeData);
        if (this.f28048f) {
            a(new FLAddedDataRequest(this, size, 1));
        }
    }

    public h<FLNodeData> getChildren() {
        return this.f28044b;
    }

    public Cursor getCursor() {
        return this.f28047e;
    }

    public FLMap getData() {
        return this.f28050h;
    }

    public GroupLayoutStrategy getGroupLayoutStrategy() {
        return this.f28046d;
    }

    public int getId() {
        return this.f28043a;
    }

    public int getSize() {
        return this.f28046d.getSize(this.f28044b.b());
    }

    public final boolean isAttached() {
        return this.f28048f;
    }

    public Cursor newCursor(int i10) {
        Cursor cursor = new Cursor(this, null);
        cursor.a(i10);
        return cursor;
    }

    public void removeAllData() {
        int b4 = this.f28044b.b();
        while (this.f28044b.b() != 0) {
            FLNodeData b10 = this.f28044b.b(0);
            if (b10 != null) {
                b10.a((com.huawei.flexiblelayout.data.a) null);
            }
        }
        if (b4 <= 0 || !this.f28048f) {
            return;
        }
        a(new FLRemovedDataRequest(this, 0, b4));
    }

    public void removeData(FLNodeData fLNodeData) {
        fLNodeData.a((com.huawei.flexiblelayout.data.a) null);
        int indexToPosition = this.f28046d.indexToPosition(this.f28044b.b((h<FLNodeData>) fLNodeData));
        if (this.f28044b.c(fLNodeData) && this.f28048f) {
            a(new FLRemovedDataRequest(this, indexToPosition, 1));
        }
    }

    @Override // com.huawei.flexiblelayout.data.a
    public void update(FLCardData fLCardData) {
        f28040i.post(new a(fLCardData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FLNodeData b(int i10) {
        if (i10 >= this.f28044b.b()) {
            return null;
        }
        return this.f28044b.a(i10);
    }

    public void c() {
        int size = getSize();
        this.f28044b.c();
        int size2 = getSize();
        if (size2 < size) {
            a(new FLRemovedDataRequest(this, size2, size - size2));
        }
    }

    public FLMap getData(FLCardData fLCardData) {
        return getData();
    }

    public void a(c cVar) {
        this.f28045c = cVar;
    }

    public void b() {
        this.f28048f = false;
        a(new FLRemovedDataRequest(this, 0, getSize()));
    }

    public Cursor a(int i10) {
        this.f28047e.a(this.f28046d.positionToIndex(i10));
        return this.f28047e;
    }

    public void addData(Collection<FLNodeData> collection) {
        int size = getSize();
        Iterator<FLNodeData> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            a(iterator2.next());
        }
        if (this.f28048f) {
            a(new FLAddedDataRequest(this, size, getSize() - size));
        }
    }

    private void a(FLNodeData fLNodeData) {
        if (fLNodeData == null) {
            return;
        }
        fLNodeData.a(this);
        fLNodeData.b(this.f28046d.getIdentifier());
        fLNodeData.setTag(f28042k, this);
        this.f28044b.a((h<FLNodeData>) fLNodeData);
    }

    public PendingDataSet addData() {
        return new PendingDataSet();
    }

    public void a() {
        this.f28048f = true;
        this.f28044b.c();
        a(new FLAddedDataRequest(this, 0, getSize()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FLDataChangedRequest fLDataChangedRequest) {
        c cVar = this.f28045c;
        if (cVar == null || fLDataChangedRequest == null) {
            return;
        }
        cVar.requestDataChanged(fLDataChangedRequest);
    }
}
