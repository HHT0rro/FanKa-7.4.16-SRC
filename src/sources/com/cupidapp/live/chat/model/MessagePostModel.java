package com.cupidapp.live.chat.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessagePostModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MessagePostModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f13175id;

    @Nullable
    private final ImageModel image;

    @NotNull
    private final String type;

    @Nullable
    private final VideoModel video;

    public MessagePostModel(@NotNull String id2, @NotNull String type, @Nullable ImageModel imageModel, @Nullable VideoModel videoModel) {
        s.i(id2, "id");
        s.i(type, "type");
        this.f13175id = id2;
        this.type = type;
        this.image = imageModel;
        this.video = videoModel;
    }

    @NotNull
    public final String getId() {
        return this.f13175id;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }
}
