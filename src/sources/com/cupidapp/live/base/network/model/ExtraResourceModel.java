package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraResourceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExtraResourceModel implements Serializable {

    @Nullable
    private final String key;

    @Nullable
    private final List<String> url;

    public ExtraResourceModel(@Nullable String str, @Nullable List<String> list) {
        this.key = str;
        this.url = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraResourceModel copy$default(ExtraResourceModel extraResourceModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = extraResourceModel.key;
        }
        if ((i10 & 2) != 0) {
            list = extraResourceModel.url;
        }
        return extraResourceModel.copy(str, list);
    }

    public final boolean checkFirstUrlIsValid() {
        String str;
        List<String> list = this.url;
        if (list != null && (str = (String) CollectionsKt___CollectionsKt.V(list)) != null) {
            if (str.length() > 0) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final String component1() {
        return this.key;
    }

    @Nullable
    public final List<String> component2() {
        return this.url;
    }

    @NotNull
    public final ExtraResourceModel copy(@Nullable String str, @Nullable List<String> list) {
        return new ExtraResourceModel(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraResourceModel)) {
            return false;
        }
        ExtraResourceModel extraResourceModel = (ExtraResourceModel) obj;
        return s.d(this.key, extraResourceModel.key) && s.d(this.url, extraResourceModel.url);
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final List<String> getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.key;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.url;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ExtraResourceModel(key=" + this.key + ", url=" + ((Object) this.url) + ")";
    }
}
