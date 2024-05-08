package com.huawei.flexiblelayout.parser;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.a1;
import com.huawei.flexiblelayout.css.CSSDefinition;
import com.huawei.flexiblelayout.d1;
import com.huawei.hmf.tasks.Task;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLDataParser {

    /* renamed from: a, reason: collision with root package name */
    private static FLDataParser f28298a;

    /* renamed from: b, reason: collision with root package name */
    private static final SparseArray<FLDataParser> f28299b = new SparseArray<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final FLEngine f28301a;

        /* renamed from: b, reason: collision with root package name */
        private DataKeys f28302b;

        /* renamed from: c, reason: collision with root package name */
        private List<CSSDefinition> f28303c;

        /* renamed from: d, reason: collision with root package name */
        private FLDataDelegate f28304d;

        /* renamed from: e, reason: collision with root package name */
        private List<CardProvider> f28305e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f28306f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f28307g = false;

        /* renamed from: h, reason: collision with root package name */
        private FLayout f28308h;

        public Builder(FLEngine fLEngine) {
            this.f28301a = fLEngine;
        }

        public Builder addCSSDefinition(CSSDefinition cSSDefinition) {
            if (cSSDefinition != null) {
                if (this.f28303c == null) {
                    this.f28303c = new ArrayList();
                }
                this.f28303c.add(cSSDefinition);
            }
            return this;
        }

        public Builder addCardProvider(CardProvider cardProvider) {
            if (this.f28305e == null) {
                this.f28305e = new ArrayList();
            }
            this.f28305e.add(cardProvider);
            return this;
        }

        public Builder asDefault() {
            this.f28307g = true;
            return this;
        }

        public FLDataParser build() {
            if (this.f28306f) {
                d1 d1Var = new d1(this.f28301a);
                d1Var.a(this.f28302b);
                d1Var.a(this.f28303c);
                d1Var.a(this.f28304d);
                return d1Var;
            }
            a1 a1Var = new a1(this.f28301a);
            a1Var.a(this.f28302b);
            a1Var.a(this.f28303c);
            a1Var.a(this.f28304d);
            a1Var.b(this.f28305e);
            if (this.f28307g) {
                FLDataParser unused = FLDataParser.f28298a = a1Var;
            }
            if (this.f28308h != null) {
                if (FLDataParser.f28299b.get(this.f28308h.hashCode()) == null) {
                    FLDataParser.b(this.f28308h);
                }
                FLDataParser.f28299b.put(this.f28308h.hashCode(), a1Var);
            }
            return a1Var;
        }

        @Deprecated
        public Builder requireFusionParser(boolean z10) {
            this.f28306f = z10;
            return this;
        }

        public Builder setDataDelegate(FLDataDelegate fLDataDelegate) {
            this.f28304d = fLDataDelegate;
            return this;
        }

        public Builder setDataKeys(DataKeys dataKeys) {
            this.f28302b = dataKeys;
            return this;
        }

        public Builder asDefault(FLayout fLayout) {
            this.f28308h = fLayout;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final FLayout fLayout) {
        fLayout.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.huawei.flexiblelayout.parser.FLDataParser.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy(LifecycleOwner lifecycleOwner) {
                if (lifecycleOwner != null) {
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    FLDataParser.f28299b.remove(FLayout.this.hashCode());
                }
            }
        });
    }

    public static Builder builder(FLEngine fLEngine) {
        return new Builder(fLEngine);
    }

    public static FLDataParser getDefault() {
        return f28298a;
    }

    @NonNull
    public abstract Task<FLDataStream> parse(String str);

    @NonNull
    public abstract Task<FLDataStream> parse(JSONArray jSONArray);

    @NonNull
    public abstract Task<FLDataStream> parse(JSONObject jSONObject);

    public static FLDataParser getDefault(FLayout fLayout) {
        FLDataParser fLDataParser = f28299b.get(fLayout.hashCode());
        return fLDataParser == null ? f28298a : fLDataParser;
    }
}
