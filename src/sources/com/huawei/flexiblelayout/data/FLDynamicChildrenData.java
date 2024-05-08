package com.huawei.flexiblelayout.data;

import android.os.Looper;
import com.huawei.flexiblelayout.card.FLProvider;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.FLDataParser;
import com.huawei.flexiblelayout.parser.FLDataStream;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLDynamicChildrenData extends FLCardData implements FLProvider {

    /* renamed from: l, reason: collision with root package name */
    private static final String f28065l = "FLDynamicChildrenData";

    /* renamed from: j, reason: collision with root package name */
    @JsonPacked("layoutData")
    private String f28066j;

    /* renamed from: k, reason: collision with root package name */
    @JsonPacked("dataSource")
    private FLDataSource f28067k;

    public FLDynamicChildrenData(String str) {
        super(str);
    }

    private FLDataStream a(FLDataParser fLDataParser) throws ExecutionException, InterruptedException {
        final AtomicReference atomicReference = new AtomicReference();
        Task<FLDataStream> parse = fLDataParser.parse(this.f28066j);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            atomicReference.set(Tasks.await(parse));
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            parse.addOnCompleteListener(Executors.newSingleThreadExecutor(), new OnCompleteListener() { // from class: com.huawei.flexiblelayout.data.k
                @Override // com.huawei.hmf.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FLDynamicChildrenData.a(AtomicReference.this, countDownLatch, task);
                }
            });
            countDownLatch.await();
        }
        return (FLDataStream) atomicReference.get();
    }

    private boolean c() {
        FLDataSource fLDataSource = this.f28067k;
        return fLDataSource != null && fLDataSource.getSize() > 0;
    }

    public void copyTo(FLDataSource fLDataSource) {
        if (fLDataSource == null || !c()) {
            return;
        }
        for (int i10 = 0; i10 < this.f28067k.getDataGroupSize(); i10++) {
            fLDataSource.addGroup(this.f28067k.getDataGroupByIndex(i10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.card.FLProvider
    public List<? extends FLCardData> supply(FLDataParser fLDataParser, FLDataGroup fLDataGroup, FLNodeData fLNodeData) {
        if (this.f28067k == null) {
            try {
                this.f28067k = new FLDataSource();
                a(fLDataParser).apply(this.f28067k, false);
                if (!c()) {
                    return Collections.emptyList();
                }
            } catch (Exception e2) {
                Log.e(f28065l, "Parse layout-data exception:" + e2.getMessage());
                return Collections.emptyList();
            }
        }
        if (fLNodeData instanceof ChildDataSourceSupported) {
            ((ChildDataSourceSupported) fLNodeData).addChildDataSource(this.f28067k);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int dataGroupSize = this.f28067k.getDataGroupSize();
        for (int i10 = 0; i10 < dataGroupSize; i10++) {
            FLDataGroup.Cursor cursor = this.f28067k.getDataGroupByIndex(i10).getCursor();
            cursor.moveToFirst();
            while (true) {
                FLNodeData next = cursor.next();
                if (next != null) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void copyTo(FLNodeData fLNodeData) {
        if (fLNodeData == null || !c()) {
            return;
        }
        FLDataGroup.Cursor cursor = this.f28067k.getCursor(0);
        while (true) {
            FLNodeData next = cursor.next();
            if (next == null) {
                return;
            } else {
                fLNodeData.addChild(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AtomicReference atomicReference, CountDownLatch countDownLatch, Task task) {
        atomicReference.set(task.getResult());
        countDownLatch.countDown();
    }
}
