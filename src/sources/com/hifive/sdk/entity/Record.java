package com.hifive.sdk.entity;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Record {

    @NotNull
    private final Cover cover;

    @NotNull
    private final String describe;
    private final int free;

    @NotNull
    private final List<Object> music;
    private final int musicTotal;
    private final int price;
    private final int sheetId;

    @NotNull
    private final String sheetName;

    @NotNull
    private final List<Tag> tag;
    private final int type;

    public Record(@NotNull Cover cover, @NotNull String describe, int i10, @NotNull List<? extends Object> music, int i11, int i12, int i13, @NotNull String sheetName, @NotNull List<Tag> tag, int i14) {
        s.j(cover, "cover");
        s.j(describe, "describe");
        s.j(music, "music");
        s.j(sheetName, "sheetName");
        s.j(tag, "tag");
        this.cover = cover;
        this.describe = describe;
        this.free = i10;
        this.music = music;
        this.musicTotal = i11;
        this.price = i12;
        this.sheetId = i13;
        this.sheetName = sheetName;
        this.tag = tag;
        this.type = i14;
    }

    @NotNull
    public final Cover component1() {
        return this.cover;
    }

    public final int component10() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.describe;
    }

    public final int component3() {
        return this.free;
    }

    @NotNull
    public final List<Object> component4() {
        return this.music;
    }

    public final int component5() {
        return this.musicTotal;
    }

    public final int component6() {
        return this.price;
    }

    public final int component7() {
        return this.sheetId;
    }

    @NotNull
    public final String component8() {
        return this.sheetName;
    }

    @NotNull
    public final List<Tag> component9() {
        return this.tag;
    }

    @NotNull
    public final Record copy(@NotNull Cover cover, @NotNull String describe, int i10, @NotNull List<? extends Object> music, int i11, int i12, int i13, @NotNull String sheetName, @NotNull List<Tag> tag, int i14) {
        s.j(cover, "cover");
        s.j(describe, "describe");
        s.j(music, "music");
        s.j(sheetName, "sheetName");
        s.j(tag, "tag");
        return new Record(cover, describe, i10, music, i11, i12, i13, sheetName, tag, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Record) {
                Record record = (Record) obj;
                if (s.d(this.cover, record.cover) && s.d(this.describe, record.describe)) {
                    if ((this.free == record.free) && s.d(this.music, record.music)) {
                        if (this.musicTotal == record.musicTotal) {
                            if (this.price == record.price) {
                                if ((this.sheetId == record.sheetId) && s.d(this.sheetName, record.sheetName) && s.d(this.tag, record.tag)) {
                                    if (this.type == record.type) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Cover getCover() {
        return this.cover;
    }

    @NotNull
    public final String getDescribe() {
        return this.describe;
    }

    public final int getFree() {
        return this.free;
    }

    @NotNull
    public final List<Object> getMusic() {
        return this.music;
    }

    public final int getMusicTotal() {
        return this.musicTotal;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getSheetId() {
        return this.sheetId;
    }

    @NotNull
    public final String getSheetName() {
        return this.sheetName;
    }

    @NotNull
    public final List<Tag> getTag() {
        return this.tag;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        Cover cover = this.cover;
        int hashCode = (cover != null ? cover.hashCode() : 0) * 31;
        String str = this.describe;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.free) * 31;
        List<Object> list = this.music;
        int hashCode3 = (((((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.musicTotal) * 31) + this.price) * 31) + this.sheetId) * 31;
        String str2 = this.sheetName;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Tag> list2 = this.tag;
        return ((hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "Record(cover=" + ((Object) this.cover) + ", describe=" + this.describe + ", free=" + this.free + ", music=" + ((Object) this.music) + ", musicTotal=" + this.musicTotal + ", price=" + this.price + ", sheetId=" + this.sheetId + ", sheetName=" + this.sheetName + ", tag=" + ((Object) this.tag) + ", type=" + this.type + ")";
    }
}
