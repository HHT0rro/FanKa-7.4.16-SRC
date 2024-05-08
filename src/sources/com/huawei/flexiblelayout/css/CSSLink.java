package com.huawei.flexiblelayout.css;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.css.CSSRule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSLink {
    public final Map<String, CSSRule> mCssRules = new ArrayMap();
    public String mName;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final b f27950a = new b();

        public a a(CSSLink cSSLink) {
            this.f27950a.a(cSSLink);
            return this;
        }

        @NonNull
        public CSSLink a() {
            return this.f27950a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b extends CSSLink {

        /* renamed from: a, reason: collision with root package name */
        private final List<CSSLink> f27951a = new ArrayList();

        public void a(CSSLink cSSLink) {
            if (cSSLink == null) {
                return;
            }
            if (TextUtils.isEmpty(this.mName)) {
                this.mName = cSSLink.getName();
            }
            this.f27951a.add(cSSLink);
        }

        @Override // com.huawei.flexiblelayout.css.CSSLink
        public CSSRule getRule(String str) {
            if (this.mCssRules.containsKey(str)) {
                return this.mCssRules.get(str);
            }
            CSSRule.a aVar = new CSSRule.a();
            int size = this.f27951a.size();
            for (int i10 = 0; i10 < size; i10++) {
                CSSRule rule = this.f27951a.get(i10).getRule(str);
                if (rule != null) {
                    aVar.a(rule);
                }
            }
            CSSRule a10 = aVar.a();
            if (a10.getPropertyNames().length == 0) {
                return null;
            }
            a10.setParent(this);
            this.mCssRules.put(str, a10);
            return a10;
        }
    }

    public void a(String str) {
        this.mName = str;
    }

    public void addRule(String str, CSSRule cSSRule) {
        if (cSSRule != null) {
            this.mCssRules.put(str, cSSRule);
        }
    }

    public String getName() {
        return this.mName;
    }

    public CSSRule getRule(String str) {
        CSSRule cSSRule = this.mCssRules.get(str);
        if (cSSRule != null) {
            cSSRule.setParent(this);
        }
        return cSSRule;
    }
}
