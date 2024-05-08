package com.cupidapp.live.mediapicker.newmediapicker.data;

import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PreviewMediaData.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PreviewMediaData {

    @NotNull
    public static final PreviewMediaData INSTANCE = new PreviewMediaData();

    @NotNull
    private static final List<LocalMedia> mediaList = new ArrayList();

    private PreviewMediaData() {
    }

    public final boolean addList(@NotNull List<LocalMedia> list) {
        s.i(list, "list");
        return mediaList.addAll(list);
    }

    public final void clear() {
        mediaList.clear();
    }

    @NotNull
    public final LocalMedia get(int i10) {
        return mediaList.get(i10);
    }

    public final int index(@NotNull LocalMedia media) {
        s.i(media, "media");
        return mediaList.indexOf(media);
    }

    public final void setList(@NotNull List<LocalMedia> list) {
        s.i(list, "list");
        List<LocalMedia> list2 = mediaList;
        list2.clear();
        list2.addAll(list);
    }

    public final int size() {
        return mediaList.size();
    }
}
