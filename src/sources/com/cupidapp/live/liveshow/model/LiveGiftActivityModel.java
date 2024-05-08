package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveGiftActivityModel implements Serializable {

    @NotNull
    private final ImageModel icon;

    @Nullable
    private final String path;

    public LiveGiftActivityModel(@NotNull ImageModel icon, @Nullable String str) {
        s.i(icon, "icon");
        this.icon = icon;
        this.path = str;
    }

    public static /* synthetic */ LiveGiftActivityModel copy$default(LiveGiftActivityModel liveGiftActivityModel, ImageModel imageModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = liveGiftActivityModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = liveGiftActivityModel.path;
        }
        return liveGiftActivityModel.copy(imageModel, str);
    }

    @NotNull
    public final ImageModel component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.path;
    }

    @NotNull
    public final LiveGiftActivityModel copy(@NotNull ImageModel icon, @Nullable String str) {
        s.i(icon, "icon");
        return new LiveGiftActivityModel(icon, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveGiftActivityModel)) {
            return false;
        }
        LiveGiftActivityModel liveGiftActivityModel = (LiveGiftActivityModel) obj;
        return s.d(this.icon, liveGiftActivityModel.icon) && s.d(this.path, liveGiftActivityModel.path);
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        int hashCode = this.icon.hashCode() * 31;
        String str = this.path;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "LiveGiftActivityModel(icon=" + ((Object) imageModel) + ", path=" + this.path + ")";
    }
}
