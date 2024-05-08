package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RecordInfo {

    @NotNull
    private final String createTime;
    private final int sheetId;

    @NotNull
    private final String sheetName;
    private final int type;

    public RecordInfo(@NotNull String createTime, int i10, @NotNull String sheetName, int i11) {
        s.j(createTime, "createTime");
        s.j(sheetName, "sheetName");
        this.createTime = createTime;
        this.sheetId = i10;
        this.sheetName = sheetName;
        this.type = i11;
    }

    public static /* synthetic */ RecordInfo copy$default(RecordInfo recordInfo, String str, int i10, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = recordInfo.createTime;
        }
        if ((i12 & 2) != 0) {
            i10 = recordInfo.sheetId;
        }
        if ((i12 & 4) != 0) {
            str2 = recordInfo.sheetName;
        }
        if ((i12 & 8) != 0) {
            i11 = recordInfo.type;
        }
        return recordInfo.copy(str, i10, str2, i11);
    }

    @NotNull
    public final String component1() {
        return this.createTime;
    }

    public final int component2() {
        return this.sheetId;
    }

    @NotNull
    public final String component3() {
        return this.sheetName;
    }

    public final int component4() {
        return this.type;
    }

    @NotNull
    public final RecordInfo copy(@NotNull String createTime, int i10, @NotNull String sheetName, int i11) {
        s.j(createTime, "createTime");
        s.j(sheetName, "sheetName");
        return new RecordInfo(createTime, i10, sheetName, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RecordInfo) {
                RecordInfo recordInfo = (RecordInfo) obj;
                if (s.d(this.createTime, recordInfo.createTime)) {
                    if ((this.sheetId == recordInfo.sheetId) && s.d(this.sheetName, recordInfo.sheetName)) {
                        if (this.type == recordInfo.type) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getCreateTime() {
        return this.createTime;
    }

    public final int getSheetId() {
        return this.sheetId;
    }

    @NotNull
    public final String getSheetName() {
        return this.sheetName;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.createTime;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.sheetId) * 31;
        String str2 = this.sheetName;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "RecordInfo(createTime=" + this.createTime + ", sheetId=" + this.sheetId + ", sheetName=" + this.sheetName + ", type=" + this.type + ")";
    }
}
