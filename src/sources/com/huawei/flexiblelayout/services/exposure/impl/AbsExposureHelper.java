package com.huawei.flexiblelayout.services.exposure.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.services.exposure.CardExposureService;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;
import com.huawei.flexiblelayout.services.exposure.NonExposureTarget;
import com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper;
import com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer;
import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObjectPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbsExposureHelper implements VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public static final String f28516a = "__noExposure__";

    /* renamed from: b, reason: collision with root package name */
    public static final String f28517b = "__exposure_param__";

    /* renamed from: c, reason: collision with root package name */
    public static final String f28518c = "exposureMode";
    public final FrameEventDispatcher<ExposureEvent> mExposureDispatcher;

    @NonNull
    public final FLayout mLayout;

    @NonNull
    public final ExposureParam mParam;
    public boolean mLayoutVisible = false;
    public final FrameEventDispatcher<VisibilityEvent> mVisibilityDispatcher = new VisibilityEventDispatcher();

    public AbsExposureHelper(@NonNull FLayout fLayout, @NonNull ExposureParam exposureParam) {
        this.mLayout = fLayout;
        this.mParam = exposureParam;
        this.mExposureDispatcher = new ExposureEventDispatcher((CardExposureServiceImpl) FLEngine.getInstance(fLayout.getView().getContext()).getService(CardExposureService.class));
    }

    @Nullable
    private static ExposureParam a(@NonNull FLCardData fLCardData) {
        Object tag = fLCardData.getTag(f28517b);
        if (tag instanceof ExposureParam) {
            return (ExposureParam) tag;
        }
        FLMap optMap = fLCardData.getData().optMap(f28517b);
        if (optMap == null) {
            if (!fLCardData.getData().optBoolean(f28516a, false)) {
                return null;
            }
            ExposureParam exposureParam = new ExposureParam();
            exposureParam.setExposureMode("none");
            fLCardData.setTag(f28517b, exposureParam);
            return exposureParam;
        }
        String optString = optMap.optString(f28518c, "");
        if (!ExposureParam.ExposureMode.values.contains(optString)) {
            return null;
        }
        ExposureParam exposureParam2 = new ExposureParam();
        exposureParam2.setExposureMode(optString);
        fLCardData.setTag(f28517b, exposureParam2);
        return exposureParam2;
    }

    @NonNull
    public static ExposureParam getDerivedExposureParam(@NonNull ExposureParam exposureParam) {
        ExposureParam exposureParam2 = new ExposureParam();
        exposureParam2.setExposureMode(exposureParam.getExposureMode());
        exposureParam2.setVisibleAreaCalculator(exposureParam.getVisibleAreaCalculator());
        return exposureParam2;
    }

    public abstract void dispatchLayoutVisibility(boolean z10);

    public abstract void dispatchScroll(int i10);

    public void dispatchVisibilityEvent(@NonNull Visit visit, boolean z10) {
        ArrayList<FLCell<?>> arrayList = new ArrayList();
        visit.visit(new AnonymousClass1(z10, arrayList));
        boolean z11 = arrayList.size() == 1;
        for (FLCell<?> fLCell : arrayList) {
            FLCardData fLCardData = (FLCardData) fLCell.getData();
            if (!z10 || fLCardData.isVisible()) {
                int i10 = z10 ? !needCalArea(z11, fLCardData) ? 1 : 0 : 2;
                ExposureEvent exposureEvent = (ExposureEvent) ReusableObjectPool.getInstance().acquire(ExposureEvent.class);
                exposureEvent.assign(this.mLayout, fLCell, i10, getExposureMode((FLCardData) fLCell.getData()));
                this.mExposureDispatcher.a((FrameEventDispatcher<ExposureEvent>) exposureEvent);
            }
        }
    }

    @Nullable
    public AbsExposureHelper getEmbeddedHelper(@NonNull FLayout fLayout) {
        ExposureTaskImpl findTask = ExposureTaskImpl.findTask(fLayout);
        if (findTask == null && fLayout.getView() != null) {
            ((CardExposureService) FLEngine.getInstance(fLayout.getView().getContext()).getService(CardExposureService.class)).setup(fLayout, getDerivedExposureParam(this.mParam));
            findTask = ExposureTaskImpl.findTask(fLayout);
        }
        if (findTask == null) {
            return null;
        }
        return findTask.getHelper();
    }

    @NonNull
    @ExposureParam.ExposureMode
    public String getExposureMode(@NonNull FLCardData fLCardData) {
        ExposureParam a10 = a(fLCardData);
        if (a10 != null) {
            return a10.getExposureMode();
        }
        return this.mParam.getExposureMode();
    }

    @NonNull
    public ExposureParam getParam() {
        return this.mParam;
    }

    public boolean isLayoutVisible() {
        return this.mLayoutVisible;
    }

    public abstract boolean needCalArea(boolean z10, @NonNull FLCardData fLCardData);

    public boolean needExposure(@NonNull FLCell<?> fLCell) {
        if ((fLCell.getData() instanceof FLCardData) && !fLCell.getClass().isAnnotationPresent(NonExposureTarget.class)) {
            return !TextUtils.equals(getExposureMode((FLCardData) r0), "none");
        }
        return false;
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.VisibilityListener
    public void onVisibilityChanged(boolean z10) {
        if (z10) {
            this.mLayoutVisible = true;
            dispatchLayoutVisibility(true);
        } else {
            dispatchLayoutVisibility(false);
            this.mLayoutVisible = false;
        }
    }

    /* renamed from: com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class AnonymousClass1 implements Visitor {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f28519a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f28520b;

        public AnonymousClass1(boolean z10, List list) {
            this.f28519a = z10;
            this.f28520b = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(@NonNull FLCell<?> fLCell) {
            if (fLCell instanceof FLayoutContainer) {
                FLayoutContainer.BoundFLayout boundFLayout = ((FLayoutContainer) fLCell).getBoundFLayout();
                final boolean z10 = this.f28519a;
                boundFLayout.whenBound(new FLayoutContainer.BoundFLayout.Listener() { // from class: com.huawei.flexiblelayout.services.exposure.impl.a
                    @Override // com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer.BoundFLayout.Listener
                    public final void onBind(FLayout fLayout) {
                        AbsExposureHelper.AnonymousClass1.this.a(z10, fLayout);
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitCard(@NonNull FLCell<?> fLCell) {
            if (fLCell instanceof VisibilityListener) {
                VisibilityEvent visibilityEvent = (VisibilityEvent) ReusableObjectPool.getInstance().acquire(VisibilityEvent.class);
                visibilityEvent.a(Objects.hash(AbsExposureHelper.this.mLayout, fLCell.getData()), (VisibilityListener) fLCell, this.f28519a);
                AbsExposureHelper.this.mVisibilityDispatcher.a((FrameEventDispatcher<VisibilityEvent>) visibilityEvent);
            }
            if (AbsExposureHelper.this.needExposure(fLCell)) {
                this.f28520b.add(fLCell);
            }
            a(fLCell);
            return true;
        }

        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitNode(@NonNull FLNode<?> fLNode) {
            a(fLNode);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z10, FLayout fLayout) {
            AbsExposureHelper embeddedHelper = AbsExposureHelper.this.getEmbeddedHelper(fLayout);
            if (embeddedHelper != null) {
                embeddedHelper.onVisibilityChanged(z10);
            }
        }
    }
}
