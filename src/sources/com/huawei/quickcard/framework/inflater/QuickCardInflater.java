package com.huawei.quickcard.framework.inflater;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.IRecyclerHost;
import com.huawei.quickcard.a2;
import com.huawei.quickcard.b2;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.c2;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.IVirtualView;
import com.huawei.quickcard.framework.IVirtualViewParent;
import com.huawei.quickcard.framework.bean.CardElement;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.bean.ThemeBean;
import com.huawei.quickcard.framework.condition.ConditionalChild;
import com.huawei.quickcard.framework.condition.ConditionalData;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.framework.ui.ComponentRegistry;
import com.huawei.quickcard.framework.ui.RenderPipeline;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.j0;
import com.huawei.quickcard.p0;
import com.huawei.quickcard.utils.ExpressionUtils;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.ThemeUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.div.CardRootLayout;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardInflater implements CardInflater {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33852b = "QuickCardInflater";

    /* renamed from: a, reason: collision with root package name */
    private final CardContext f33853a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f33854a;

        private b() {
            this.f33854a = 0;
        }
    }

    public QuickCardInflater(CardContext cardContext) {
        this.f33853a = cardContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(CardElement cardElement, ViewGroup viewGroup) {
        if (viewGroup != 0) {
            if (viewGroup instanceof IRecyclerHost) {
                ((IRecyclerHost) viewGroup).addChildItem(cardElement);
                return;
            }
            String attrString = cardElement.getAttrString("for");
            String attrString2 = cardElement.getAttrString("if");
            if (!TextUtils.isEmpty(attrString) || !TextUtils.isEmpty(attrString2)) {
                ValueUtils.obtainPropertyCacheBeanFromView(viewGroup).obtainConditionChildren().a(viewGroup, StrUtils.strip(attrString), StrUtils.strip(attrString2), cardElement);
                return;
            }
        }
        KeyEvent.Callback a10 = a(cardElement, viewGroup, -1);
        List<CardElement> children = cardElement.getChildren();
        if (children != null) {
            if (a10 instanceof IVirtualViewParent) {
                IVirtualViewParent iVirtualViewParent = (IVirtualViewParent) a10;
                a(iVirtualViewParent, iVirtualViewParent, children, ThemeUtils.getVirtualRefs(a10.hashCode(), this.f33853a.getThemeBean()));
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) a10;
            Iterator<CardElement> iterator2 = children.iterator2();
            while (iterator2.hasNext()) {
                a(iterator2.next(), viewGroup2);
            }
            if (viewGroup2 instanceof IRecyclerHost) {
                ((IRecyclerHost) viewGroup2).endAddChildItem(this.f33853a);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View forceInflateView(CardElement cardElement, ViewGroup viewGroup, int i10) {
        View a10 = a(cardElement, viewGroup, i10);
        List<CardElement> children = cardElement.getChildren();
        if (children != null) {
            if (a10 instanceof IVirtualViewParent) {
                IVirtualViewParent iVirtualViewParent = (IVirtualViewParent) a10;
                a(iVirtualViewParent, iVirtualViewParent, children, ThemeUtils.getVirtualRefs(a10.hashCode(), this.f33853a.getThemeBean()));
                return a10;
            }
            ViewGroup viewGroup2 = (ViewGroup) a10;
            Iterator<CardElement> iterator2 = children.iterator2();
            while (iterator2.hasNext()) {
                a(iterator2.next(), viewGroup2);
            }
            if (viewGroup2 instanceof IRecyclerHost) {
                ((IRecyclerHost) viewGroup2).endAddChildItem(this.f33853a);
            }
        }
        return a10;
    }

    @Override // com.huawei.quickcard.framework.inflater.CardInflater
    public void inflate(QuickCardBean quickCardBean) {
        if (quickCardBean == null || quickCardBean.getCard() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        IWatcherManager watcherManager = this.f33853a.getWatcherManager();
        watcherManager.collectNewWatchers(arrayList);
        a(quickCardBean.getCard(), this.f33853a.getRoot().getRootViewGroup());
        watcherManager.stopCollectNewWatchers(arrayList);
        watcherManager.setCommonWatchers(arrayList);
    }

    public void inflateConditionChildren(ViewGroup viewGroup, String str) {
        ConditionalChild conditionalChild;
        if (this.f33853a == null) {
            return;
        }
        List<ConditionalChild> a10 = ValueUtils.obtainPropertyCacheBeanFromView(viewGroup).obtainConditionChildren().a();
        if (a10.isEmpty()) {
            CardLogUtils.e(f33852b, "items is empty but in onUpdate");
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= a10.size()) {
                conditionalChild = null;
                break;
            }
            ConditionalChild conditionalChild2 = a10.get(i10);
            if (StrUtils.equals(conditionalChild2.getCardElement().getRef(), str)) {
                conditionalChild = conditionalChild2;
                break;
            }
            i10++;
        }
        if (conditionalChild == null) {
            CardLogUtils.e(f33852b, "foundItem is null");
            return;
        }
        String forChains = ExpressionUtils.getForChains(viewGroup);
        b bVar = new b();
        j0 forCondition = conditionalChild.getForCondition();
        if (forCondition == null) {
            a(viewGroup, str, conditionalChild, bVar, forChains);
        } else {
            Object a11 = forCondition.a(this.f33853a);
            if (a11 instanceof CardDataObject) {
                a(viewGroup, str, conditionalChild, bVar, (CardDataObject) a11, forChains);
            } else {
                CardLogUtils.e(f33852b, "can not loop data");
                a(viewGroup, str, conditionalChild, bVar, null, forChains);
                return;
            }
        }
        while (true) {
            i10++;
            if (i10 >= a10.size()) {
                return;
            } else {
                a10.get(i10).updateInsertIndex(bVar.f33854a);
            }
        }
    }

    private void a(IVirtualViewParent iVirtualViewParent, IVirtualViewParent iVirtualViewParent2, List<CardElement> list, Set<Object> set) {
        for (CardElement cardElement : list) {
            IVirtualView a10 = a(cardElement.getType());
            HashSet hashSet = null;
            if (a10 != null && set != null) {
                if (cardElement.getChildren() == null) {
                    set.add(cardElement.getRef());
                } else {
                    HashMap hashMap = new HashMap();
                    HashSet hashSet2 = new HashSet();
                    hashMap.put(cardElement.getRef(), hashSet2);
                    set.add(hashMap);
                    hashSet = hashSet2;
                }
            }
            if (iVirtualViewParent2 != null) {
                iVirtualViewParent2.addChild(cardElement.getRef(), a10);
            }
            a(iVirtualViewParent, cardElement);
            if (cardElement.getChildren() != null && (a10 instanceof IVirtualViewParent)) {
                a(iVirtualViewParent, (IVirtualViewParent) a10, cardElement.getChildren(), hashSet);
            }
        }
    }

    private IVirtualView a(String str) {
        return c2.a(str);
    }

    private void a(IVirtualViewParent iVirtualViewParent, CardElement cardElement) {
        Map<String, QuickCardValue> attributes = cardElement.getAttributes();
        Map<String, Map<String, QuickCardValue>> styles = cardElement.getStyles();
        ThemeBean themeBean = this.f33853a.getThemeBean();
        if (themeBean != null) {
            b2 splitVirtualAttrsAndStyles = ThemeUtils.splitVirtualAttrsAndStyles(iVirtualViewParent, cardElement.getRef(), cardElement.getType(), themeBean);
            if (attributes == null) {
                attributes = new HashMap<>();
            }
            if (styles == null) {
                styles = new HashMap<>();
            }
            ThemeUtils.replaceVirtualAttrsAndStyles(this.f33853a.getCurrentTheme(), splitVirtualAttrsAndStyles, attributes, styles);
        }
        a2.a(iVirtualViewParent, cardElement.getRef(), cardElement.getType(), attributes);
        a2.b(iVirtualViewParent, cardElement.getRef(), cardElement.getType(), styles);
        iVirtualViewParent.renderChildren();
    }

    private View a(CardElement cardElement, ViewGroup viewGroup, int i10) {
        View view;
        Component component = ComponentRegistry.get(cardElement.getType());
        if (component == null) {
            throw new IllegalArgumentException("component " + cardElement.getType() + " not register.");
        }
        if (viewGroup != null) {
            if (Attributes.Component.ROOT.equals(cardElement.getRef())) {
                view = new CardRootLayout(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            } else {
                view = this.f33853a.getViewPool().getView(cardElement.getType());
            }
            ThemeBean themeBean = this.f33853a.getThemeBean();
            if (themeBean != null) {
                themeBean.saveView(cardElement.getRef(), view);
            }
            view.setTag(R.id.quick_card_context, this.f33853a);
            view.setTag(R.id.quick_card_type, cardElement.getType());
            viewGroup.addView(view, i10);
            int hashCode = cardElement.getRef().hashCode();
            this.f33853a.getRefsToComponents().put(hashCode, component);
            this.f33853a.getRefsToViews().put(hashCode, view);
            if (view instanceof IComponentSupport) {
                ((IComponentSupport) view).onViewCreated(this.f33853a);
            }
            ValueUtils.obtainPropertyCacheBeanFromView(view).setComponentName(cardElement.getComponentType());
            a(component, view, cardElement);
            return view;
        }
        throw new IllegalArgumentException("make view failed, parent is null.");
    }

    private void a(Component component, View view, CardElement cardElement) {
        RenderPipeline renderPipeline = new RenderPipeline();
        Map<String, QuickCardValue> attributes = cardElement.getAttributes();
        Map<String, Map<String, QuickCardValue>> styles = cardElement.getStyles();
        ThemeBean themeBean = this.f33853a.getThemeBean();
        if (themeBean != null) {
            if (attributes == null) {
                attributes = new HashMap<>();
            }
            if (styles == null) {
                styles = new HashMap<>();
            }
            ThemeUtils.replaceAttrsAndStyles(themeBean, this.f33853a.getCurrentTheme(), attributes, styles, cardElement.getRef());
        }
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(view);
        if (attributes != null) {
            obtainPropertyCacheBeanFromView.setAttrNames(attributes.h());
            component.bindAttributesRenderCommand(view, attributes, renderPipeline);
        }
        if (styles != null) {
            obtainPropertyCacheBeanFromView.setStyleNames(styles.h());
            obtainPropertyCacheBeanFromView.setIsAnimationView(cardElement.getHasAnimation());
            component.bindStylesRenderCommand(view, styles, renderPipeline);
        }
        if (renderPipeline.isEmpty()) {
            return;
        }
        if (ViewUtils.hasCSSTag(this.f33853a, view)) {
            component.bindAllPseudoStylesRenderCommand(view, renderPipeline);
        }
        renderPipeline.render(this.f33853a, view);
    }

    private void a(ViewGroup viewGroup, String str, ConditionalChild conditionalChild, b bVar, CardDataObject cardDataObject, String str2) {
        p0 p0Var;
        ConditionalData conditionalData;
        String str3;
        int i10;
        String str4 = str;
        j0 forCondition = conditionalChild.getForCondition();
        if (forCondition == null) {
            return;
        }
        p0 ifCondition = conditionalChild.getIfCondition();
        int insertIndex = conditionalChild.getInsertIndex();
        IWatcherManager watcherManager = this.f33853a.getWatcherManager();
        if (cardDataObject == null) {
            a(watcherManager, viewGroup, str, bVar, insertIndex);
            return;
        }
        boolean isArray = cardDataObject.isArray();
        String[] keys = cardDataObject.keys();
        int i11 = 0;
        while (i11 < keys.length) {
            if (ifCondition == null || ifCondition.a(this.f33853a)) {
                ConditionalData conditionalData2 = ValueUtils.getConditionalData(viewGroup.getChildAt(insertIndex));
                if (conditionalData2 != null && StrUtils.equals(conditionalData2.getRef(), str4)) {
                    int i12 = i11;
                    p0Var = ifCondition;
                    int i13 = insertIndex;
                    String a10 = a(isArray, forCondition, i11, keys, str2);
                    conditionalData2.setForChains(str2, a10);
                    List<Watcher> watchers = conditionalData2.getWatchers();
                    if (watchers == null) {
                        return;
                    }
                    ExpressionUtils.updateWatcherScript(watchers, a10, watcherManager, true);
                    insertIndex = i13 + 1;
                    str3 = str;
                    conditionalData = conditionalData2;
                    i10 = i12;
                } else {
                    int i14 = i11;
                    p0Var = ifCondition;
                    int i15 = insertIndex;
                    ArrayList arrayList = new ArrayList();
                    watcherManager.collectNewWatchers(arrayList);
                    String a11 = a(isArray, forCondition, i11, keys, str2);
                    int i16 = i15 + 1;
                    View forceInflateView = forceInflateView(conditionalChild.getCardElement(), viewGroup, i15);
                    bVar.f33854a++;
                    watcherManager.stopCollectNewWatchers(arrayList);
                    ExpressionUtils.updateWatcherScript(arrayList, a11, watcherManager, false);
                    PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(forceInflateView);
                    str3 = str;
                    conditionalData = new ConditionalData(forCondition, p0Var, str3);
                    conditionalData.setViewHashCode(forceInflateView.hashCode());
                    conditionalData.setConditionalView(forceInflateView);
                    i10 = i14;
                    conditionalData.setForAliasData(i10, isArray, keys[i10]);
                    conditionalData.setForChains(str2, a11);
                    obtainPropertyCacheBeanFromView.setConditionalData(conditionalData);
                    conditionalData.setWatchers(arrayList);
                    ConditionalData findSuperConditionData = ConditionalData.findSuperConditionData(watcherManager, forceInflateView);
                    if (findSuperConditionData != null) {
                        findSuperConditionData.addChildWithForCondition(forceInflateView);
                    }
                    insertIndex = i16;
                }
                conditionalData.updateAllChildren(this.f33853a);
            } else {
                i10 = i11;
                p0Var = ifCondition;
                str3 = str4;
            }
            i11 = i10 + 1;
            str4 = str3;
            ifCondition = p0Var;
        }
        a(watcherManager, viewGroup, str, bVar, insertIndex);
    }

    private void a(IWatcherManager iWatcherManager, ViewGroup viewGroup, String str, b bVar, int i10) {
        while (true) {
            View childAt = viewGroup.getChildAt(i10);
            ConditionalData conditionalData = ValueUtils.getConditionalData(childAt);
            if (conditionalData == null || !StrUtils.equals(conditionalData.getRef(), str)) {
                return;
            }
            iWatcherManager.removeWatchersByConditionData(conditionalData);
            iWatcherManager.removeConditionalDPSWatcher(conditionalData);
            ConditionalData findSuperConditionData = ConditionalData.findSuperConditionData(iWatcherManager, childAt);
            if (findSuperConditionData != null) {
                findSuperConditionData.removeChildWithForCondition(childAt);
            }
            ViewParent parent = childAt.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(childAt);
                bVar.f33854a--;
            }
        }
    }

    private void a(ViewGroup viewGroup, String str, ConditionalChild conditionalChild, b bVar, String str2) {
        List<Watcher> watchers;
        p0 ifCondition = conditionalChild.getIfCondition();
        if (ifCondition == null) {
            return;
        }
        int insertIndex = conditionalChild.getInsertIndex();
        IWatcherManager watcherManager = this.f33853a.getWatcherManager();
        boolean a10 = ifCondition.a(this.f33853a);
        View childAt = viewGroup.getChildAt(insertIndex);
        ConditionalData conditionalData = ValueUtils.getConditionalData(childAt);
        boolean z10 = conditionalData != null && StrUtils.equals(conditionalData.getRef(), str);
        if (!a10 || z10) {
            if (!a10 && z10) {
                watcherManager.removeWatchersByConditionData(conditionalData);
                watcherManager.removeConditionalDPSWatcher(conditionalData);
                ConditionalData findSuperConditionData = ConditionalData.findSuperConditionData(watcherManager, childAt);
                if (findSuperConditionData != null) {
                    findSuperConditionData.removeChildWithForCondition(childAt);
                }
                viewGroup.removeViewAt(insertIndex);
                bVar.f33854a--;
                return;
            }
            if (!z10 || ValueUtils.obtainPropertyCacheBeanFromView(childAt).getConditionalData() == null || (watchers = conditionalData.getWatchers()) == null) {
                return;
            }
            conditionalData.setForChains(str2, str2);
            ExpressionUtils.updateWatcherScript(watchers, str2, watcherManager, true);
            conditionalData.updateAllChildren(this.f33853a);
            return;
        }
        ArrayList arrayList = new ArrayList();
        watcherManager.collectNewWatchers(arrayList);
        View forceInflateView = forceInflateView(conditionalChild.getCardElement(), viewGroup, insertIndex);
        bVar.f33854a++;
        watcherManager.stopCollectNewWatchers(arrayList);
        ExpressionUtils.updateWatcherScript(arrayList, str2, watcherManager, false);
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(forceInflateView);
        ConditionalData conditionalData2 = new ConditionalData(null, ifCondition, str);
        conditionalData2.setViewHashCode(forceInflateView.hashCode());
        conditionalData2.setConditionalView(forceInflateView);
        conditionalData2.setForChains(str2, str2);
        obtainPropertyCacheBeanFromView.setConditionalData(conditionalData2);
        conditionalData2.setWatchers(arrayList);
        ConditionalData findSuperConditionData2 = ConditionalData.findSuperConditionData(watcherManager, forceInflateView);
        if (findSuperConditionData2 != null) {
            findSuperConditionData2.addChildWithForCondition(forceInflateView);
        }
        conditionalData2.updateAllChildren(this.f33853a);
    }

    private String a(boolean z10, j0 j0Var, int i10, String[] strArr, String str) {
        if (z10) {
            return ExpressionUtils.computeForChains(j0Var, i10, str);
        }
        return ExpressionUtils.computeForChains(j0Var, i10, strArr[i10], str);
    }
}
