package com.huawei.quickcard.framework.ui;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.watcher.IWatchAttrCallback;
import com.huawei.quickcard.watcher.IWatcherManager;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a<T extends View> implements IWatchAttrCallback {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33963c = "WatcherCallback";

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<T> f33964a;

    /* renamed from: b, reason: collision with root package name */
    private final CardContext f33965b;

    public a(@NonNull T t2, CardContext cardContext) {
        this.f33965b = cardContext;
        this.f33964a = new WeakReference<>(t2);
    }

    private void a(@NonNull T t2, String str, @NonNull QuickCardValue quickCardValue) {
        if (quickCardValue.isDp() || quickCardValue.isSp()) {
            CardContext cardContext = (CardContext) t2.getTag(R.id.quick_card_context);
            IWatcherManager watcherManager = cardContext.getWatcherManager();
            watcherManager.watchDPAttr(t2.hashCode(), str, quickCardValue, new a(t2, cardContext));
            if (quickCardValue.isSp()) {
                watcherManager.watchSPAttr(t2.hashCode(), str, quickCardValue, new a(t2, cardContext));
            }
        }
    }

    @Override // com.huawei.quickcard.watcher.IWatchAttrCallback
    public void onUpdate(String str, Object obj) {
        QuickCardValue quickCardValue;
        WeakReference<T> weakReference = this.f33964a;
        if (weakReference == null) {
            return;
        }
        T t2 = weakReference.get();
        Component component = ViewUtils.getComponent(t2);
        if (component == null) {
            CardLogUtils.w(f33963c, "unknown component for " + StrUtils.objDesc(t2));
            return;
        }
        if (obj instanceof QuickCardValue) {
            quickCardValue = (QuickCardValue) obj;
        } else {
            quickCardValue = component.toQuickCardValue(str, obj);
        }
        a(t2, str, quickCardValue);
        ValueUtils.obtainPropertyCacheBeanFromView(t2).saveAttrOrStyle(str, quickCardValue);
        RenderCommand buildRenderCommand = component.buildRenderCommand(t2, str, quickCardValue);
        if (buildRenderCommand != null) {
            RenderPipeline renderPipeline = new RenderPipeline();
            renderPipeline.addCommand(buildRenderCommand);
            if (ViewUtils.hasCSSTag(this.f33965b, t2)) {
                component.bindAllPseudoStylesRenderCommand(t2, renderPipeline);
            }
            renderPipeline.render(this.f33965b, t2);
        }
    }
}
