package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftFragmentsModel implements Serializable {

    @NotNull
    private final String name;

    @NotNull
    private final String url;

    public GiftFragmentsModel(@NotNull String name, @NotNull String url) {
        s.i(name, "name");
        s.i(url, "url");
        this.name = name;
        this.url = url;
    }

    public static /* synthetic */ GiftFragmentsModel copy$default(GiftFragmentsModel giftFragmentsModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = giftFragmentsModel.name;
        }
        if ((i10 & 2) != 0) {
            str2 = giftFragmentsModel.url;
        }
        return giftFragmentsModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final GiftFragmentsModel copy(@NotNull String name, @NotNull String url) {
        s.i(name, "name");
        s.i(url, "url");
        return new GiftFragmentsModel(name, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftFragmentsModel)) {
            return false;
        }
        GiftFragmentsModel giftFragmentsModel = (GiftFragmentsModel) obj;
        return s.d(this.name, giftFragmentsModel.name) && s.d(this.url, giftFragmentsModel.url);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "GiftFragmentsModel(name=" + this.name + ", url=" + this.url + ")";
    }
}
