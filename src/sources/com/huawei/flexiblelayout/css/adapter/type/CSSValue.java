package com.huawei.flexiblelayout.css.adapter.type;

import com.huawei.flexiblelayout.css.CSSRule;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class CSSValue {
    private List<LinkedRule> mLinkedRules;
    private CSSRule mParent;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class LinkedRule {
        private CSSRule mCssRule;
        private String mSelectExpr;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class Builder {
            private CSSRule mCSSRule;
            private String mSelectExpr;

            public Builder(String str, CSSRule cSSRule) {
                this.mSelectExpr = str;
                this.mCSSRule = cSSRule;
            }

            public LinkedRule build() {
                LinkedRule linkedRule = new LinkedRule();
                linkedRule.mSelectExpr = this.mSelectExpr;
                linkedRule.mCssRule = this.mCSSRule;
                return linkedRule;
            }
        }

        public CSSRule getCssRule() {
            return this.mCssRule;
        }

        public String getSelectExpr() {
            return this.mSelectExpr;
        }

        private LinkedRule() {
        }
    }

    public void addLinkedRule(LinkedRule linkedRule) {
        if (this.mLinkedRules == null) {
            this.mLinkedRules = new ArrayList();
        }
        this.mLinkedRules.add(linkedRule);
    }

    public List<LinkedRule> getLinkedRules() {
        return this.mLinkedRules;
    }

    public CSSRule getParent() {
        return this.mParent;
    }

    public void setParent(CSSRule cSSRule) {
        this.mParent = cSSRule;
    }
}
