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
public final class LiveCoverTagModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f15098id;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String text;

    public LiveCoverTagModel(@NotNull String id2, @Nullable ImageModel imageModel, @Nullable String str) {
        s.i(id2, "id");
        this.f15098id = id2;
        this.image = imageModel;
        this.text = str;
    }

    public static /* synthetic */ LiveCoverTagModel copy$default(LiveCoverTagModel liveCoverTagModel, String str, ImageModel imageModel, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveCoverTagModel.f15098id;
        }
        if ((i10 & 2) != 0) {
            imageModel = liveCoverTagModel.image;
        }
        if ((i10 & 4) != 0) {
            str2 = liveCoverTagModel.text;
        }
        return liveCoverTagModel.copy(str, imageModel, str2);
    }

    @NotNull
    public final String component1() {
        return this.f15098id;
    }

    @Nullable
    public final ImageModel component2() {
        return this.image;
    }

    @Nullable
    public final String component3() {
        return this.text;
    }

    @NotNull
    public final LiveCoverTagModel copy(@NotNull String id2, @Nullable ImageModel imageModel, @Nullable String str) {
        s.i(id2, "id");
        return new LiveCoverTagModel(id2, imageModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveCoverTagModel)) {
            return false;
        }
        LiveCoverTagModel liveCoverTagModel = (LiveCoverTagModel) obj;
        return s.d(this.f15098id, liveCoverTagModel.f15098id) && s.d(this.image, liveCoverTagModel.image) && s.d(this.text, liveCoverTagModel.text);
    }

    @NotNull
    public final String getId() {
        return this.f15098id;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode = this.f15098id.hashCode() * 31;
        ImageModel imageModel = this.image;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.text;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.f15098id;
        ImageModel imageModel = this.image;
        return "LiveCoverTagModel(id=" + str + ", image=" + ((Object) imageModel) + ", text=" + this.text + ")";
    }
}
