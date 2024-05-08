package com.kwad.components.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6),
    FEED_TYPE_TEXT_NEW(7),
    FEED_TYPE_CONTENT_11(11),
    FEED_TYPE_CONTENT_12(12),
    FEED_TYPE_CONTENT_13(13);

    private int type;

    FeedType(int i10) {
        this.type = i10;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        int be2 = a.be(e.dQ(adTemplate));
        int i10 = adTemplate.type;
        FeedType feedType = FEED_TYPE_TEXT_ABOVE_GROUP;
        if (i10 > feedType.type) {
            return true;
        }
        FeedType fromInt = fromInt(i10);
        if (be2 != 1) {
            if (be2 == 2) {
                return (fromInt == FEED_TYPE_UNKNOWN || fromInt == feedType) ? false : true;
            }
            if (be2 == 3) {
                return fromInt != FEED_TYPE_UNKNOWN;
            }
            if (be2 != 8) {
                return false;
            }
        }
        return fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW || fromInt == FEED_TYPE_TEXT_IMMERSE;
    }

    @NonNull
    public static FeedType fromInt(int i10) {
        for (FeedType feedType : values()) {
            if (feedType.type == i10) {
                return feedType;
            }
        }
        if (isH5Type(i10)) {
            return FEED_TYPE_TEXT_NEW;
        }
        return FEED_TYPE_UNKNOWN;
    }

    private static boolean isH5Type(int i10) {
        return i10 == 7 || i10 == 8 || i10 == 14 || i10 == 15 || i10 == 16 || i10 == 17 || i10 == 18 || i10 == 19 || i10 >= 2000;
    }

    public final int getType() {
        return this.type;
    }
}
