package com.hifive.sdk.entity;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CompanySheetList {
    private final int currentPage;
    private final int pageSize;

    @NotNull
    private final List<Record> records;
    private final int totalCount;
    private final int totalPage;

    public CompanySheetList(int i10, int i11, @NotNull List<Record> records, int i12, int i13) {
        s.j(records, "records");
        this.currentPage = i10;
        this.pageSize = i11;
        this.records = records;
        this.totalCount = i12;
        this.totalPage = i13;
    }

    public static /* synthetic */ CompanySheetList copy$default(CompanySheetList companySheetList, int i10, int i11, List list, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = companySheetList.currentPage;
        }
        if ((i14 & 2) != 0) {
            i11 = companySheetList.pageSize;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            list = companySheetList.records;
        }
        List list2 = list;
        if ((i14 & 8) != 0) {
            i12 = companySheetList.totalCount;
        }
        int i16 = i12;
        if ((i14 & 16) != 0) {
            i13 = companySheetList.totalPage;
        }
        return companySheetList.copy(i10, i15, list2, i16, i13);
    }

    public final int component1() {
        return this.currentPage;
    }

    public final int component2() {
        return this.pageSize;
    }

    @NotNull
    public final List<Record> component3() {
        return this.records;
    }

    public final int component4() {
        return this.totalCount;
    }

    public final int component5() {
        return this.totalPage;
    }

    @NotNull
    public final CompanySheetList copy(int i10, int i11, @NotNull List<Record> records, int i12, int i13) {
        s.j(records, "records");
        return new CompanySheetList(i10, i11, records, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CompanySheetList) {
                CompanySheetList companySheetList = (CompanySheetList) obj;
                if (this.currentPage == companySheetList.currentPage) {
                    if ((this.pageSize == companySheetList.pageSize) && s.d(this.records, companySheetList.records)) {
                        if (this.totalCount == companySheetList.totalCount) {
                            if (this.totalPage == companySheetList.totalPage) {
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
    public final List<Record> getRecords() {
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
        List<Record> list = this.records;
        return ((((i10 + (list != null ? list.hashCode() : 0)) * 31) + this.totalCount) * 31) + this.totalPage;
    }

    @NotNull
    public String toString() {
        return "CompanySheetList(currentPage=" + this.currentPage + ", pageSize=" + this.pageSize + ", records=" + ((Object) this.records) + ", totalCount=" + this.totalCount + ", totalPage=" + this.totalPage + ")";
    }
}
