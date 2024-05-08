package com.hifive.sdk.entity;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicBean<T> {
    private int currentPage;
    private boolean isRecommand;
    private int pageSize;
    private List<T> records;
    private int totalCount;
    private int totalPage;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public boolean isRecommand() {
        return this.isRecommand;
    }
}
