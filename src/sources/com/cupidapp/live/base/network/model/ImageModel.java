package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImageModel implements Serializable {
    private final boolean debugLog;
    private final int height;

    @NotNull
    private final String imageId;

    @Nullable
    private final List<String> patterns;

    @Nullable
    private final String urlPatternWidth;

    @Nullable
    private String urlPatternWidthHeight;

    @Nullable
    private List<String> urlPatternWidthHeightMirrors;

    @Nullable
    private List<String> urlPatternWidthMirrors;

    @Nullable
    private final List<ImageVariant> variants;
    private final int width;

    public ImageModel(@NotNull String imageId, int i10, int i11, boolean z10, @Nullable List<String> list, @Nullable List<ImageVariant> list2, @Nullable String str, @Nullable String str2, @Nullable List<String> list3, @Nullable List<String> list4) {
        s.i(imageId, "imageId");
        this.imageId = imageId;
        this.width = i10;
        this.height = i11;
        this.debugLog = z10;
        this.patterns = list;
        this.variants = list2;
        this.urlPatternWidth = str;
        this.urlPatternWidthHeight = str2;
        this.urlPatternWidthMirrors = list3;
        this.urlPatternWidthHeightMirrors = list4;
    }

    private final List<String> compatibilityUrlList(int i10) {
        int i11 = this.width;
        if (i10 < i11) {
            i11 = (int) (i10 * (Math.max(i11, this.height) / Math.min(this.width, this.height)));
        }
        int min = Math.min(this.width, i11);
        List<String> patternList = getPatternList();
        if (patternList != null) {
            ArrayList arrayList = new ArrayList(t.t(patternList, 10));
            Iterator<String> iterator2 = patternList.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(p.B(iterator2.next(), "%@", String.valueOf(min), false));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private final List<String> getPatternList() {
        List<String> list = this.patterns;
        if (list != null) {
            return list;
        }
        List<String> list2 = this.urlPatternWidthMirrors;
        if (list2 != null) {
            return list2;
        }
        String[] strArr = new String[1];
        String str = this.urlPatternWidth;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        return kotlin.collections.s.o(strArr);
    }

    @NotNull
    public final String component1() {
        return this.imageId;
    }

    @Nullable
    public final List<String> component10() {
        return this.urlPatternWidthHeightMirrors;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final boolean component4() {
        return this.debugLog;
    }

    @Nullable
    public final List<String> component5() {
        return this.patterns;
    }

    @Nullable
    public final List<ImageVariant> component6() {
        return this.variants;
    }

    @Nullable
    public final String component7() {
        return this.urlPatternWidth;
    }

    @Nullable
    public final String component8() {
        return this.urlPatternWidthHeight;
    }

    @Nullable
    public final List<String> component9() {
        return this.urlPatternWidthMirrors;
    }

    @NotNull
    public final ImageModel copy(@NotNull String imageId, int i10, int i11, boolean z10, @Nullable List<String> list, @Nullable List<ImageVariant> list2, @Nullable String str, @Nullable String str2, @Nullable List<String> list3, @Nullable List<String> list4) {
        s.i(imageId, "imageId");
        return new ImageModel(imageId, i10, i11, z10, list, list2, str, str2, list3, list4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageModel)) {
            return false;
        }
        ImageModel imageModel = (ImageModel) obj;
        return s.d(this.imageId, imageModel.imageId) && this.width == imageModel.width && this.height == imageModel.height && this.debugLog == imageModel.debugLog && s.d(this.patterns, imageModel.patterns) && s.d(this.variants, imageModel.variants) && s.d(this.urlPatternWidth, imageModel.urlPatternWidth) && s.d(this.urlPatternWidthHeight, imageModel.urlPatternWidthHeight) && s.d(this.urlPatternWidthMirrors, imageModel.urlPatternWidthMirrors) && s.d(this.urlPatternWidthHeightMirrors, imageModel.urlPatternWidthHeightMirrors);
    }

    @NotNull
    public final List<String> getBiggerSizeImageUrl(int i10) {
        if (this.variants != null) {
            ArrayList arrayList = new ArrayList();
            for (ImageVariant imageVariant : this.variants) {
                if (imageVariant.getWidth() >= i10) {
                    arrayList.add(imageVariant.getUrl());
                }
            }
            return arrayList;
        }
        return compatibilityUrlList(i10);
    }

    public final boolean getDebugLog() {
        return this.debugLog;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getImageId() {
        return this.imageId;
    }

    @Nullable
    public final List<String> getPatterns() {
        return this.patterns;
    }

    public final int getScaleHeightByWidth(int i10) {
        return (int) ((i10 * this.height) / this.width);
    }

    public final int getScaleWidthByHeight(int i10) {
        return (int) ((this.width * i10) / this.height);
    }

    @NotNull
    public final List<String> getSmallerSizeImageUrl(int i10) {
        if (this.variants != null) {
            ArrayList arrayList = new ArrayList();
            for (ImageVariant imageVariant : this.variants) {
                if (imageVariant.getWidth() <= i10) {
                    arrayList.add(imageVariant.getUrl());
                }
            }
            return arrayList;
        }
        return compatibilityUrlList(i10);
    }

    @Nullable
    public final String getUrl(int i10) {
        return (String) CollectionsKt___CollectionsKt.V(getUrlList(i10));
    }

    @NotNull
    public final List<String> getUrlList(int i10) {
        List<ImageVariant> list = this.variants;
        if (list != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ImageVariant imageVariant : list) {
                Integer valueOf = Integer.valueOf(imageVariant.getWidth());
                Object obj = linkedHashMap.get(valueOf);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(valueOf, obj);
                }
                ((List) obj).add(imageVariant);
            }
            Collection h10 = linkedHashMap.h();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : h10) {
                if (((Number) obj2).intValue() >= i10) {
                    arrayList.add(obj2);
                }
            }
            Integer num = (Integer) CollectionsKt___CollectionsKt.i0(arrayList);
            if (num == null) {
                num = (Integer) CollectionsKt___CollectionsKt.g0(linkedHashMap.h());
            }
            List list2 = (List) linkedHashMap.get(num);
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList(t.t(list2, 10));
                Iterator<E> iterator2 = list2.iterator2();
                while (iterator2.hasNext()) {
                    arrayList2.add(((ImageVariant) iterator2.next()).getUrl());
                }
                return arrayList2;
            }
            return kotlin.collections.s.j();
        }
        return compatibilityUrlList(i10);
    }

    @Nullable
    public final String getUrlPatternWidth() {
        return this.urlPatternWidth;
    }

    @Nullable
    public final String getUrlPatternWidthHeight() {
        return this.urlPatternWidthHeight;
    }

    @Nullable
    public final List<String> getUrlPatternWidthHeightMirrors() {
        return this.urlPatternWidthHeightMirrors;
    }

    @Nullable
    public final List<String> getUrlPatternWidthMirrors() {
        return this.urlPatternWidthMirrors;
    }

    @Nullable
    public final List<ImageVariant> getVariants() {
        return this.variants;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.imageId.hashCode() * 31) + this.width) * 31) + this.height) * 31;
        boolean z10 = this.debugLog;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        List<String> list = this.patterns;
        int hashCode2 = (i11 + (list == null ? 0 : list.hashCode())) * 31;
        List<ImageVariant> list2 = this.variants;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.urlPatternWidth;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.urlPatternWidthHeight;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list3 = this.urlPatternWidthMirrors;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.urlPatternWidthHeightMirrors;
        return hashCode6 + (list4 != null ? list4.hashCode() : 0);
    }

    public final void setUrlPatternWidthHeight(@Nullable String str) {
        this.urlPatternWidthHeight = str;
    }

    public final void setUrlPatternWidthHeightMirrors(@Nullable List<String> list) {
        this.urlPatternWidthHeightMirrors = list;
    }

    public final void setUrlPatternWidthMirrors(@Nullable List<String> list) {
        this.urlPatternWidthMirrors = list;
    }

    @NotNull
    public String toString() {
        String str = this.imageId;
        int i10 = this.width;
        int i11 = this.height;
        boolean z10 = this.debugLog;
        List<String> list = this.patterns;
        List<ImageVariant> list2 = this.variants;
        return "ImageModel(imageId=" + str + ", width=" + i10 + ", height=" + i11 + ", debugLog=" + z10 + ", patterns=" + ((Object) list) + ", variants=" + ((Object) list2) + ", urlPatternWidth=" + this.urlPatternWidth + ", urlPatternWidthHeight=" + this.urlPatternWidthHeight + ", urlPatternWidthMirrors=" + ((Object) this.urlPatternWidthMirrors) + ", urlPatternWidthHeightMirrors=" + ((Object) this.urlPatternWidthHeightMirrors) + ")";
    }
}
