package com.hifive.sdk.entity;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SheetList {
    private final int currentPage;
    private final int pageSize;

    @NotNull
    private final List<RecordInfo> records;
    private final int totalCount;
    private final int totalPage;

    public SheetList(int i10, int i11, @NotNull List<RecordInfo> records, int i12, int i13) {
        s.j(records, "records");
        this.currentPage = i10;
        this.pageSize = i11;
        this.records = records;
        this.totalCount = i12;
        this.totalPage = i13;
    }

    public static /* synthetic */ SheetList copy$default(SheetList sheetList, int i10, int i11, List list, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = sheetList.currentPage;
        }
        if ((i14 & 2) != 0) {
            i11 = sheetList.pageSize;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            list = sheetList.records;
        }
        List list2 = list;
        if ((i14 & 8) != 0) {
            i12 = sheetList.totalCount;
        }
        int i16 = i12;
        if ((i14 & 16) != 0) {
            i13 = sheetList.totalPage;
        }
        return sheetList.copy(i10, i15, list2, i16, i13);
    }

    public final int component1() {
        return this.currentPage;
    }

    public final int component2() {
        return this.pageSize;
    }

    @NotNull
    public final List<RecordInfo> component3() {
        return this.records;
    }

    public final int component4() {
        return this.totalCount;
    }

    public final int component5() {
        return this.totalPage;
    }

    @NotNull
    public final SheetList copy(int i10, int i11, @NotNull List<RecordInfo> records, int i12, int i13) {
        s.j(records, "records");
        return new SheetList(i10, i11, records, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SheetList) {
                SheetList sheetList = (SheetList) obj;
                if (this.currentPage == sheetList.currentPage) {
                    if ((this.pageSize == sheetList.pageSize) && s.d(this.records, sheetList.records)) {
                        if (this.totalCount == sheetList.totalCount) {
                            if (this.totalPage == sheetList.totalPage) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final List<RecordInfo> getRecords() {
        return this.records;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    public int hashCode() {
        int i10 = ((this.currentPage * 31) + this.pageSize) * 31;
        List<RecordInfo> list = this.records;
        return ((((i10 + (list != null ? list.hashCode() : 0)) * 31) + this.totalCount) * 31) + this.totalPage;
    }

    @NotNull
    public String toString() {
        return "SheetList(currentPage=" + this.currentPage + ", pageSize=" + this.pageSize + ", records=" + ((Object) this.records) + ", totalCount=" + this.totalCount + ", totalPage=" + this.totalPage + ")";
    }
}
