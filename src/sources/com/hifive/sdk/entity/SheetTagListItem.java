package com.hifive.sdk.entity;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SheetTagListItem {

    @NotNull
    private final List<Child1> child;

    @NotNull
    private final String coverUrl;
    private final int pid;
    private final int tagId;

    @NotNull
    private final String tagName;

    public SheetTagListItem(@NotNull List<Child1> child, @NotNull String coverUrl, int i10, int i11, @NotNull String tagName) {
        s.j(child, "child");
        s.j(coverUrl, "coverUrl");
        s.j(tagName, "tagName");
        this.child = child;
        this.coverUrl = coverUrl;
        this.pid = i10;
        this.tagId = i11;
        this.tagName = tagName;
    }

    public static /* synthetic */ SheetTagListItem copy$default(SheetTagListItem sheetTagListItem, List list, String str, int i10, int i11, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = sheetTagListItem.child;
        }
        if ((i12 & 2) != 0) {
            str = sheetTagListItem.coverUrl;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            i10 = sheetTagListItem.pid;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = sheetTagListItem.tagId;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            str2 = sheetTagListItem.tagName;
        }
        return sheetTagListItem.copy(list, str3, i13, i14, str2);
    }

    @NotNull
    public final List<Child1> component1() {
        return this.child;
    }

    @NotNull
    public final String component2() {
        return this.coverUrl;
    }

    public final int component3() {
        return this.pid;
    }

    public final int component4() {
        return this.tagId;
    }

    @NotNull
    public final String component5() {
        return this.tagName;
    }

    @NotNull
    public final SheetTagListItem copy(@NotNull List<Child1> child, @NotNull String coverUrl, int i10, int i11, @NotNull String tagName) {
        s.j(child, "child");
        s.j(coverUrl, "coverUrl");
        s.j(tagName, "tagName");
        return new SheetTagListItem(child, coverUrl, i10, i11, tagName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SheetTagListItem) {
                SheetTagListItem sheetTagListItem = (SheetTagListItem) obj;
                if (s.d(this.child, sheetTagListItem.child) && s.d(this.coverUrl, sheetTagListItem.coverUrl)) {
                    if (this.pid == sheetTagListItem.pid) {
                        if (!(this.tagId == sheetTagListItem.tagId) || !s.d(this.tagName, sheetTagListItem.tagName)) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<Child1> getChild() {
        return this.child;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getPid() {
        return this.pid;
    }

    public final int getTagId() {
        return this.tagId;
    }

    @NotNull
    public final String getTagName() {
        return this.tagName;
    }

    public int hashCode() {
        List<Child1> list = this.child;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.coverUrl;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.pid) * 31) + this.tagId) * 31;
        String str2 = this.tagName;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SheetTagListItem(child=" + ((Object) this.child) + ", coverUrl=" + this.coverUrl + ", pid=" + this.pid + ", tagId=" + this.tagId + ", tagName=" + this.tagName + ")";
    }
}
