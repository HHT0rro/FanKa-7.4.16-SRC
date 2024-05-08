package com.huawei.flexiblelayout.parser.csslink;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.css.CSSDefinition;
import com.huawei.flexiblelayout.css.CSSLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LinkProvider {

    /* renamed from: a, reason: collision with root package name */
    private final List<CSSDefinition> f28347a;

    /* renamed from: b, reason: collision with root package name */
    private String f28348b;

    public LinkProvider(@NonNull List<CSSDefinition> list) {
        this.f28347a = list;
    }

    @Nullable
    public CSSLink getCssLink() {
        if (TextUtils.isEmpty(this.f28348b)) {
            return null;
        }
        CSSLink.a aVar = new CSSLink.a();
        Iterator<CSSDefinition> iterator2 = this.f28347a.iterator2();
        while (iterator2.hasNext()) {
            CSSLink link = iterator2.next().getLink(this.f28348b);
            if (link != null) {
                aVar.a(link);
            }
        }
        return aVar.a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final LinkProvider f28349a;

        public Builder(@NonNull List<CSSDefinition> list) {
            this.f28349a = new LinkProvider(list);
        }

        public LinkProvider build() {
            return this.f28349a;
        }

        public Builder setLink(String str) {
            this.f28349a.f28348b = str;
            return this;
        }

        public Builder(CSSDefinition cSSDefinition) {
            ArrayList arrayList = new ArrayList();
            if (cSSDefinition != null) {
                arrayList.add(cSSDefinition);
            }
            this.f28349a = new LinkProvider(arrayList);
        }
    }
}
