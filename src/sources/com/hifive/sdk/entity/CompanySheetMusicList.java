package com.hifive.sdk.entity;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CompanySheetMusicList {
    private final int currentPage;
    private final int pageSize;

    @NotNull
    private final List<Object> records;
    private final int totalCount;
    private final int totalPage;

    public CompanySheetMusicList(int i10, int i11, @NotNull List<? extends Object> records, int i12, int i13) {
        s.j(records, "records");
        this.currentPage = i10;
        this.pageSize = i11;
        this.records = records;
        this.totalCount = i12;
        this.totalPage = i13;
    }

    public static /* synthetic */ CompanySheetMusicList copy$default(CompanySheetMusicList companySheetMusicList, int i10, int i11, List list, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = companySheetMusicList.currentPage;
        }
        if ((i14 & 2) != 0) {
            i11 = companySheetMusicList.pageSize;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            list = companySheetMusicList.records;
        }
        List list2 = list;
        if ((i14 & 8) != 0) {
            i12 = companySheetMusicList.totalCount;
        }
        int i16 = i12;
        if ((i14 & 16) != 0) {
            i13 = companySheetMusicList.totalPage;
        }
        return companySheetMusicList.copy(i10, i15, list2, i16, i13);
    }

    public final int component1() {
        return this.currentPage;
    }

    public final int component2() {
        return this.pageSize;
    }

    @NotNull
    public final List<Object> component3() {
        return this.records;
    }

    public final int component4() {
        return this.totalCount;
    }

    public final int component5() {
        return this.totalPage;
    }

    @NotNull
    public final CompanySheetMusicList copy(int i10, int i11, @NotNull List<? extends Object> records, int i12, int i13) {
        s.j(records, "records");
        return new CompanySheetMusicList(i10, i11, records, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CompanySheetMusicList) {
                CompanySheetMusicList companySheetMusicList = (CompanySheetMusicList) obj;
                if (this.currentPage == companySheetMusicList.currentPage) {
                    if ((this.pageSize == companySheetMusicList.pageSize) && s.d(this.records, companySheetMusicList.records)) {
                        if (this.totalCount == companySheetMusicList.totalCount) {
                            if (this.totalPage == companySheetMusicList.totalPage) {
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
    public final List<Object> getRecords() {
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
        List<Object> list = this.records;
        return ((((i10 + (list != null ? list.hashCode() : 0)) * 31) + this.totalCount) * 31) + this.totalPage;
    }

    @NotNull
    public String toString() {
        return "CompanySheetMusicList(currentPage=" + this.currentPage + ", pageSize=" + this.pageSize + ", records=" + ((Object) this.records) + ", totalCount=" + this.totalCount + ", totalPage=" + this.totalPage + ")";
    }
}
