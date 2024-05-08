package com.cupidapp.live.chat.viewholder;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatRecommendViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatRecommendImageUiModel {

    @NotNull
    private final List<ImageModel> imageList;

    public ChatRecommendImageUiModel(@NotNull List<ImageModel> imageList) {
        s.i(imageList, "imageList");
        this.imageList = imageList;
    }

    @NotNull
    public final List<ImageModel> getImageList() {
        return this.imageList;
    }
}
