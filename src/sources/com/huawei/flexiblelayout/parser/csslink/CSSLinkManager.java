package com.huawei.flexiblelayout.parser.csslink;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSLinkManager {

    /* renamed from: b, reason: collision with root package name */
    private static final CSSLinkManager f28345b = new CSSLinkManager();

    /* renamed from: a, reason: collision with root package name */
    private final Map<FLDataGroup, LinkProvider> f28346a = new WeakHashMap();

    public static CSSLinkManager getInstance() {
        return f28345b;
    }

    public CSSLink findCssLink(@NonNull FLCardData fLCardData) {
        LinkProvider linkProvider;
        FLDataGroup findDataGroup = FLDataSource.findDataGroup(fLCardData);
        if (findDataGroup == null || (linkProvider = getLinkProvider(findDataGroup)) == null) {
            return null;
        }
        return linkProvider.getCssLink();
    }

    public LinkProvider getLinkProvider(@NonNull FLDataGroup fLDataGroup) {
        return this.f28346a.get(fLDataGroup);
    }

    public void putLinkProvider(@NonNull FLDataGroup fLDataGroup, @Nullable LinkProvider linkProvider) {
        if (linkProvider != null) {
            this.f28346a.put(fLDataGroup, linkProvider);
        } else {
            this.f28346a.remove(fLDataGroup);
        }
    }
}
