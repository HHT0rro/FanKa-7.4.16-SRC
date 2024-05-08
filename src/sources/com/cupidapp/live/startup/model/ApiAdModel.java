package com.cupidapp.live.startup.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ApiAdModel {

    @NotNull
    private final AdResourceModel resource;

    public ApiAdModel(@NotNull AdResourceModel resource) {
        s.i(resource, "resource");
        this.resource = resource;
    }

    public static /* synthetic */ ApiAdModel copy$default(ApiAdModel apiAdModel, AdResourceModel adResourceModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            adResourceModel = apiAdModel.resource;
        }
        return apiAdModel.copy(adResourceModel);
    }

    @NotNull
    public final AdResourceModel component1() {
        return this.resource;
    }

    @NotNull
    public final ApiAdModel copy(@NotNull AdResourceModel resource) {
        s.i(resource, "resource");
        return new ApiAdModel(resource);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ApiAdModel) && s.d(this.resource, ((ApiAdModel) obj).resource);
    }

    @NotNull
    public final AdResourceModel getResource() {
        return this.resource;
    }

    public int hashCode() {
        return this.resource.hashCode();
    }

    @NotNull
    public String toString() {
        return "ApiAdModel(resource=" + ((Object) this.resource) + ")";
    }
}
