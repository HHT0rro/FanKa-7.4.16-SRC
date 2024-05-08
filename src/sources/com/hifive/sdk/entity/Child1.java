package com.hifive.sdk.entity;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Child1 {

    @NotNull
    private final List<Object> child;

    @NotNull
    private final Object coverUrl;
    private final int pid;
    private final int tagId;

    @NotNull
    private final String tagName;

    public Child1(@NotNull List<? extends Object> child, @NotNull Object coverUrl, int i10, int i11, @NotNull String tagName) {
        s.j(child, "child");
        s.j(coverUrl, "coverUrl");
        s.j(tagName, "tagName");
        this.child = child;
        this.coverUrl = coverUrl;
        this.pid = i10;
        this.tagId = i11;
        this.tagName = tagName;
    }

    public static /* synthetic */ Child1 copy$default(Child1 child1, List list, Object obj, int i10, int i11, String str, int i12, Object obj2) {
        if ((i12 & 1) != 0) {
            list = child1.child;
        }
        if ((i12 & 2) != 0) {
            obj = child1.coverUrl;
        }
        Object obj3 = obj;
        if ((i12 & 4) != 0) {
            i10 = child1.pid;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = child1.tagId;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            str = child1.tagName;
        }
        return child1.copy(list, obj3, i13, i14, str);
    }

    @NotNull
    public final List<Object> component1() {
        return this.child;
    }

    @NotNull
    public final Object component2() {
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
    public final Child1 copy(@NotNull List<? extends Object> child, @NotNull Object coverUrl, int i10, int i11, @NotNull String tagName) {
        s.j(child, "child");
        s.j(coverUrl, "coverUrl");
        s.j(tagName, "tagName");
        return new Child1(child, coverUrl, i10, i11, tagName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Child1) {
                Child1 child1 = (Child1) obj;
                if (s.d(this.child, child1.child) && s.d(this.coverUrl, child1.coverUrl)) {
                    if (this.pid == child1.pid) {
                        if (!(this.tagId == child1.tagId) || !s.d(this.tagName, child1.tagName)) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<Object> getChild() {
        return this.child;
    }

    @NotNull
    public final Object getCoverUrl() {
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
        List<Object> list = this.child;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Object obj = this.coverUrl;
        int hashCode2 = (((((hashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.pid) * 31) + this.tagId) * 31;
        String str = this.tagName;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Child1(child=" + ((Object) this.child) + ", coverUrl=" + this.coverUrl + ", pid=" + this.pid + ", tagId=" + this.tagId + ", tagName=" + this.tagName + ")";
    }
}
