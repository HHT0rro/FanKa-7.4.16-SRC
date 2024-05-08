package com.huawei.qcardsupport.cards;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.action.BaseAction;
import com.huawei.flexiblelayout.card.interation.CellFinder;
import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.CSSView;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.csslink.CSSLinkManager;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.flexiblelayout.script.IScriptService;
import com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable;
import com.huawei.flexiblelayout.services.action.CardActionService;
import com.huawei.flexiblelayout.services.lazyrender.FLLazyRenderService;
import com.huawei.qcardsupport.qcard.QCardView;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QCard extends FLCell<QCardData> implements DataChangedWatchable.DataChangedListener, FLLazyRenderService.LazyRenderListener {
    public static final String TYPE = "qcard";

    /* renamed from: g, reason: collision with root package name */
    private static final String f33099g = "QCard";

    /* renamed from: h, reason: collision with root package name */
    private static final String f33100h = "$data";

    /* renamed from: i, reason: collision with root package name */
    private static final String f33101i = "$extra";

    /* renamed from: j, reason: collision with root package name */
    private static final String f33102j = "$group";

    /* renamed from: k, reason: collision with root package name */
    private static final String f33103k = "$context";

    /* renamed from: l, reason: collision with root package name */
    private static final String f33104l = "$card";

    /* renamed from: a, reason: collision with root package name */
    private QCardView f33105a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private QCardData f33106b;

    /* renamed from: c, reason: collision with root package name */
    private String f33107c;

    /* renamed from: d, reason: collision with root package name */
    private FLLazyRenderService f33108d;

    /* renamed from: e, reason: collision with root package name */
    private FLContext f33109e;

    /* renamed from: f, reason: collision with root package name */
    private FLDataGroup f33110f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements QCardView.QCardRenderListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QCardView f33111a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FLContext f33112b;

        public a(QCardView qCardView, FLContext fLContext) {
            this.f33111a = qCardView;
            this.f33112b = fLContext;
        }

        @Override // com.huawei.qcardsupport.qcard.QCardView.QCardRenderListener
        public void onRendered(boolean z10, String str) {
            QCard qCard = QCard.this;
            qCard.a(qCard.f33105a.getView(), QCard.this.f33106b);
            if (z10 && QCard.this.a(this.f33111a)) {
                BaseAction.bindTo(this.f33112b, QCard.this.f33105a.getView(), QCard.this);
            }
        }
    }

    public void click(FLContext fLContext, String str, Object obj) {
        CardActionService cardActionService;
        if (fLContext == null || (cardActionService = (CardActionService) FLEngine.getInstance(fLContext.getContext()).getService(CardActionService.class)) == null) {
            return;
        }
        cardActionService.click(fLContext, this, new CardActionService.Action(str, obj));
    }

    public FLCell findCell(String str) {
        return new CellFinder(this).findByXPath(str);
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        String str = this.f33107c;
        return str != null ? str : TYPE;
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable.DataChangedListener
    public void onDataChanged(@NonNull Object obj, @NonNull String str, @Nullable Object obj2, @Nullable Object obj3) {
        QCardData qCardData = this.f33106b;
        if (qCardData != null && obj == qCardData.a()) {
            if (this.f33105a == null || Objects.equals(obj2, obj3)) {
                return;
            }
            this.f33105a.notifyDataChanged("$extra" + str, obj2, obj3);
            return;
        }
        Log.w(f33099g, "Unreachable.");
    }

    @Override // com.huawei.flexiblelayout.services.lazyrender.FLLazyRenderService.LazyRenderListener
    public void onRender() {
        a(this.f33109e, this.f33110f, this.f33106b);
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public void setVisibility(int i10) {
        if (getRootView() != null) {
            QCardData qCardData = this.f33106b;
            if (qCardData == null || !qCardData.isVisible()) {
                i10 = 8;
            }
            getRootView().setVisibility(i10);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public void unbind(FLContext fLContext) {
        super.unbind(fLContext);
        QCardView qCardView = this.f33105a;
        if (qCardView != null) {
            qCardView.unbind();
        }
        QCardData qCardData = this.f33106b;
        if (qCardData != null) {
            qCardData.a().removeListener(this);
        }
        FLLazyRenderService fLLazyRenderService = this.f33108d;
        if (fLLazyRenderService != null) {
            fLLazyRenderService.unregisterLazyRenderListener(this);
            this.f33108d = null;
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public final void bind(FLContext fLContext, FLDataGroup fLDataGroup, QCardData qCardData) {
        FLLazyRenderService.LazyRenderParam lazyRenderParam;
        QCardData qCardData2 = this.f33106b;
        if (qCardData2 != null) {
            qCardData2.a().removeListener(this);
        }
        this.f33109e = fLContext;
        this.f33110f = fLDataGroup;
        this.f33106b = qCardData;
        qCardData.a().addListener(this);
        if (!qCardData.c()) {
            FLLazyRenderService fLLazyRenderService = (FLLazyRenderService) FLEngine.getInstance(fLContext.getContext()).getService(FLLazyRenderService.class, fLContext.getFLayout());
            this.f33108d = fLLazyRenderService;
            if (fLLazyRenderService != null && (lazyRenderParam = fLLazyRenderService.getLazyRenderParam()) != null && lazyRenderParam.lazyRender()) {
                this.f33108d.registerLazyRenderListener(this);
                return;
            }
        }
        a(fLContext, fLDataGroup, qCardData);
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public View build(FLContext fLContext, QCardData qCardData, ViewGroup viewGroup) {
        if (qCardData != null) {
            String qCardUri = qCardData.getQCardUri();
            if (!TextUtils.isEmpty(qCardUri)) {
                this.f33107c = qCardData.getQCardName();
                IScriptContext a10 = a(fLContext.getScriptService(), qCardUri);
                if (a10 == null) {
                    Log.e(f33099g, "Failed to acquire js-context.");
                    return null;
                }
                QCardView qCardView = new QCardView(fLContext.getContext());
                this.f33105a = qCardView;
                qCardView.setScriptContext(a10);
                this.f33105a.addJsInterface(f33103k, fLContext, true);
                this.f33105a.addJsInterface(f33104l, this, true);
                this.f33105a.render(qCardUri);
                setRootView(this.f33105a.getView());
                a(this.f33105a.getView(), qCardData);
                return this.f33105a.getView();
            }
        }
        Log.e(f33099g, "The card uri must not be null or empty.");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.flexiblelayout.card.FLCell
    public QCardData getData() {
        return this.f33106b;
    }

    public void click(FLContext fLContext, String str) {
        click(fLContext, str, null);
    }

    private void a(FLContext fLContext, FLDataGroup fLDataGroup, QCardData qCardData) {
        if (fLContext.getFLayout().getLayoutDelegate() != null) {
            fLContext.getFLayout().getLayoutDelegate().onCardBind(fLContext, this, qCardData);
        }
        QCardView qCardView = this.f33105a;
        if (qCardView != null) {
            a(fLContext, qCardView);
            this.f33105a.addJsInterface(f33104l, this, true);
            this.f33105a.addJsInterface("$data", qCardData.b());
            this.f33105a.addJsInterface("$extra", qCardData.a());
            this.f33105a.addJsInterface(f33102j, fLDataGroup);
            this.f33105a.bind();
        }
        setReady(true);
        this.f33106b.a(true);
    }

    public void click(FLContext fLContext) {
        click(fLContext, CardActionService.CARD_CLICK_ACTION, null);
    }

    private void a(FLContext fLContext, QCardView qCardView) {
        if (qCardView.isRendered()) {
            if (a(qCardView)) {
                BaseAction.bindTo(fLContext, this.f33105a.getView(), this);
                return;
            }
            return;
        }
        qCardView.setRenderListener(new a(qCardView, fLContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(QCardView qCardView) {
        return qCardView.getToolkitLevel() < 1001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, FLCardData fLCardData) {
        if (this.f33105a.isRendered()) {
            CSSRule cssRule = fLCardData.getCssRule();
            CSSLink parent = cssRule != null ? cssRule.getParent() : null;
            if (parent == null) {
                parent = CSSLinkManager.getInstance().findCssLink(fLCardData);
            }
            if (cssRule == null && parent == null) {
                return;
            }
            CSSView.wrap(view, cssRule).cssLink(parent).render();
        }
    }

    @Nullable
    private IScriptContext a(IScriptService iScriptService, String str) {
        IScriptContext findContext = iScriptService.findContext(str);
        return findContext == null ? iScriptService.acquireContext(str) : findContext;
    }
}
