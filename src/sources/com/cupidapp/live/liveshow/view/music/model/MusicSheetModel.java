package com.cupidapp.live.liveshow.view.music.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMusicDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MusicSheetModel {

    @NotNull
    private final String sheetId;

    @NotNull
    private final String sheetName;

    public MusicSheetModel(@NotNull String sheetId, @NotNull String sheetName) {
        s.i(sheetId, "sheetId");
        s.i(sheetName, "sheetName");
        this.sheetId = sheetId;
        this.sheetName = sheetName;
    }

    public static /* synthetic */ MusicSheetModel copy$default(MusicSheetModel musicSheetModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = musicSheetModel.sheetId;
        }
        if ((i10 & 2) != 0) {
            str2 = musicSheetModel.sheetName;
        }
        return musicSheetModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.sheetId;
    }

    @NotNull
    public final String component2() {
        return this.sheetName;
    }

    @NotNull
    public final MusicSheetModel copy(@NotNull String sheetId, @NotNull String sheetName) {
        s.i(sheetId, "sheetId");
        s.i(sheetName, "sheetName");
        return new MusicSheetModel(sheetId, sheetName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicSheetModel)) {
            return false;
        }
        MusicSheetModel musicSheetModel = (MusicSheetModel) obj;
        return s.d(this.sheetId, musicSheetModel.sheetId) && s.d(this.sheetName, musicSheetModel.sheetName);
    }

    @NotNull
    public final String getSheetId() {
        return this.sheetId;
    }

    @NotNull
    public final String getSheetName() {
        return this.sheetName;
    }

    public int hashCode() {
        return (this.sheetId.hashCode() * 31) + this.sheetName.hashCode();
    }

    @NotNull
    public String toString() {
        return "MusicSheetModel(sheetId=" + this.sheetId + ", sheetName=" + this.sheetName + ")";
    }
}
