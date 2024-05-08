package com.cupidapp.live.mediapicker.newmediapicker.data;

import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaPicked;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePickedData.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePickedData {
    private static final int MAX_PICKED_IMAGE_COUNT = 9;
    private static int frozenCount;

    @NotNull
    public static final ImagePickedData INSTANCE = new ImagePickedData();

    @NotNull
    private static final List<LocalMediaPicked> imagePickedList = new ArrayList();

    @NotNull
    private static final Map<LocalMedia, Integer> imagePickedSequenceMap = new LinkedHashMap();

    @NotNull
    private static List<LocalMediaPicked> imageAllPreviewList = new ArrayList();

    /* compiled from: ImagePickedData.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface OnPickedStatusChangedListener {
        void a();

        void b(int i10);

        void onRemoved(int i10, int i11);
    }

    private ImagePickedData() {
    }

    public final void clear() {
        frozenCount = 0;
        imagePickedSequenceMap.clear();
        imagePickedList.clear();
        imageAllPreviewList.clear();
    }

    public final void clearNotFrozenItem() {
        int size = size() - 1;
        int i10 = frozenCount;
        if (i10 > size) {
            return;
        }
        while (true) {
            imagePickedSequenceMap.remove(imagePickedList.remove(size).getMedia());
            if (size == i10) {
                return;
            } else {
                size--;
            }
        }
    }

    public final void clearPreviewList() {
        imageAllPreviewList.clear();
    }

    public final int getFrozenCount() {
        return frozenCount;
    }

    @Nullable
    public final LocalMediaPicked getItem(int i10) {
        if (i10 < 0) {
            return null;
        }
        List<LocalMediaPicked> list = imagePickedList;
        if (i10 >= list.size()) {
            return null;
        }
        list.get(i10);
        return null;
    }

    @NotNull
    public final List<LocalMediaPicked> getList() {
        return CollectionsKt___CollectionsKt.x0(imagePickedList);
    }

    @NotNull
    public final List<String> getPathList() {
        ArrayList arrayList = new ArrayList();
        Iterator<LocalMediaPicked> iterator2 = imagePickedList.iterator2();
        while (iterator2.hasNext()) {
            String d10 = iterator2.next().getMedia().d();
            if (d10 != null) {
                arrayList.add(d10);
            }
        }
        return arrayList;
    }

    @NotNull
    public final LocalMediaPicked getPreviewItem(int i10) {
        return imagePickedList.get(i10);
    }

    @NotNull
    public final List<LocalMediaPicked> getSubList(int i10) {
        return imagePickedList.subList(i10, size());
    }

    public final int index(@NotNull LocalMedia media) {
        s.i(media, "media");
        Integer num = imagePickedSequenceMap.get(media);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final boolean isEmpty() {
        return imagePickedList.isEmpty();
    }

    public final void pick(@NotNull LocalMediaPicked item, @Nullable OnPickedStatusChangedListener onPickedStatusChangedListener) {
        s.i(item, "item");
        int index = index(item.getMedia());
        if (index == -1) {
            if (size() >= 9) {
                if (onPickedStatusChangedListener != null) {
                    onPickedStatusChangedListener.a();
                    return;
                }
                return;
            }
            Map<LocalMedia, Integer> map = imagePickedSequenceMap;
            LocalMedia media = item.getMedia();
            List<LocalMediaPicked> list = imagePickedList;
            map.put(media, Integer.valueOf(list.size()));
            list.add(item);
            if (onPickedStatusChangedListener != null) {
                onPickedStatusChangedListener.b(size());
                return;
            }
            return;
        }
        if (index >= frozenCount) {
            remove(index);
            if (onPickedStatusChangedListener != null) {
                onPickedStatusChangedListener.onRemoved(index, size());
            }
        }
    }

    public final void remove(int i10) {
        if (i10 < 0 || i10 >= imagePickedList.size()) {
            return;
        }
        int size = size();
        for (int i11 = i10 + 1; i11 < size; i11++) {
            imagePickedSequenceMap.put(imagePickedList.get(i11).getMedia(), Integer.valueOf(i11 - 1));
        }
        imagePickedSequenceMap.remove(imagePickedList.remove(i10).getMedia());
    }

    public final void setFrozenCount(int i10) {
        frozenCount = i10;
    }

    public final int size() {
        return imagePickedList.size();
    }

    public final void updatePreviewList() {
        imageAllPreviewList = CollectionsKt___CollectionsKt.z0(imagePickedList);
    }
}
