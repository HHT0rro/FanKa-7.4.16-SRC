package com.cupidapp.live.base.network.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ABTestResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ABTestKey {
    STORY_LABEL_TEST("storyLabelTest"),
    FEED_LIVE_ENTRANCE_TEST("feedTopTagTest"),
    SUPER_BOOST_PURCHASE_DEFAULT_TAB("superBoostPurchaseDefaultTab"),
    RETRIEVE_ALOHA_NOTIFY("retrieveAlohaNotify"),
    SUPER_BOOST_ENTRANCE("superBoostEntrance"),
    FEED_SPREAD_MENU("feedSuperBoost0318"),
    VISITOR_NEW_TEST("visitorNewTest");


    @NotNull
    private final String value;

    ABTestKey(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
