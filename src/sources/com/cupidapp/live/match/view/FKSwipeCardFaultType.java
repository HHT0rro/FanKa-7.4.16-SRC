package com.cupidapp.live.match.view;

import com.cupidapp.live.R$string;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKSwipeCardFaultPromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FKSwipeCardFaultType {
    NoLocationPermission("NO_LOCATION_INFO", R$string.unable_get_your_location),
    UnAvailableInternet("UNABLE_TO_CONNECT_TO_SERVER", R$string.unable_to_connect_to_server),
    NoEligibleUsers("NO_MEET_CONDITION_USERS", R$string.no_eligible_users),
    BrowsedAllUsers("BROWSE_ALL_RECOMMENDED_USERS", R$string.browsed_all_users),
    MaintenanceServer("UNDER_MAINTENANCE", R$string.server_is_under_maintenance);


    @NotNull
    private final String reason;
    private final int title;

    FKSwipeCardFaultType(String str, int i10) {
        this.reason = str;
        this.title = i10;
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    public final int getTitle() {
        return this.title;
    }
}
