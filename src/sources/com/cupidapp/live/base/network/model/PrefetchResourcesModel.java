package com.cupidapp.live.base.network.model;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PrefetchResourcesModel {

    @NotNull
    private final String key;

    @NotNull
    private final List<String> url;

    public PrefetchResourcesModel(@NotNull String key, @NotNull List<String> url) {
        s.i(key, "key");
        s.i(url, "url");
        this.key = key;
        this.url = url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrefetchResourcesModel copy$default(PrefetchResourcesModel prefetchResourcesModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = prefetchResourcesModel.key;
        }
        if ((i10 & 2) != 0) {
            list = prefetchResourcesModel.url;
        }
        return prefetchResourcesModel.copy(str, list);
    }

    public final boolean checkFirstUrlIsValid() {
        String str = (String) CollectionsKt___CollectionsKt.V(this.url);
        if (str != null) {
            if (str.length() > 0) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @NotNull
    public final List<String> component2() {
        return this.url;
    }

    @NotNull
    public final PrefetchResourcesModel copy(@NotNull String key, @NotNull List<String> url) {
        s.i(key, "key");
        s.i(url, "url");
        return new PrefetchResourcesModel(key, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrefetchResourcesModel)) {
            return false;
        }
        PrefetchResourcesModel prefetchResourcesModel = (PrefetchResourcesModel) obj;
        return s.d(this.key, prefetchResourcesModel.key) && s.d(this.url, prefetchResourcesModel.url);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final List<String> getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "PrefetchResourcesModel(key=" + this.key + ", url=" + ((Object) this.url) + ")";
    }
}
