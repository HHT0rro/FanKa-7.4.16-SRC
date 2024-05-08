package com.alimm.tanx.core.ut;

import android.view.WindowManagerPolicyConstants;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum AdUtConstants {
    SCREEN_VIEW_EXPOSURE_MONITOR(1000000, "screen_view_exposure_monitor"),
    FLOW_VIEW_EXPOSURE_MONITOR(1000001, "flow_view_exposure_monitor"),
    EXCEPTION_MSG(1000002, "exception_msg"),
    TABLE_SCREEN_EXPOSURE_MONITOR(1000005, "table_screen_exposure_monitor"),
    SDK_ERROR_CODE(1000404, "sdk_error_code"),
    SPLASH_CACHE_EXSIT(WindowManagerPolicyConstants.STRICT_MODE_LAYER, "splash_cache_exsit"),
    AD_TIMER(1010001, "ad_timer"),
    SCREEN_JSON_CHECK(1010002, "screen_json_check"),
    CACHE_CHECK(1010003, "cache_check"),
    FILE_SIZE_CHECK(1010004, "file_size_check"),
    BIDDING_CHECK(1020000, "bidding_check"),
    SCREEN_VIEW_CREATE(1030000, "screen_view_create"),
    FLOW_VIEW_CREATE(1030001, "flow_view_create"),
    REWARD_VIDEO_VIEW_CREATE(1030002, "reward_video_view_create"),
    TABLE_SCREEN_VIEW_CREATE(1030003, "table_screen_view_create"),
    WEB_START_LOAD(1030009, "web_start_load"),
    WEB_DID_MOUNT(1030010, "web_did_mount"),
    SHAKE_DESTROY(1031000, "shake_destroy"),
    METHOD_INVOKE(1040000, "method_invoke"),
    METHOD_INVOKE_CALLBACK(1040001, "method_invoke_callback"),
    IS_REWARD_VALID(1050000, "is_reward_valid"),
    CLOSE_AD_VIDEO_PROGRESS(1050001, "close_ad_video_progress"),
    PLAY_END_CLICK_TIME(1050002, "play_end_click_time"),
    AD_REQUEST(WindowManagerPolicyConstants.SCREEN_FREEZE_LAYER_BASE, "ad_request"),
    START_IMP(3010000, "start_imp"),
    SCREEN_VIEW_CLICK(4010000, "screen_view_click"),
    FLOW_VIEW_CLICK(4010001, "flow_view_click"),
    SHAKE_NAVIGATE(4010002, "shake_navigate"),
    REWARD_VIDEO_NAVIGATE(4010003, "middle_page_click"),
    REWARD_NEW_BROWSE_NAVIGATE(4010004, "reward_new_browse_navigate"),
    FLOW_VIEW_INTERACTION_CLICK(4010007, "flow_view_interaction_click"),
    TABLE_SCREEN_CLICK(4010009, "table_screen_click"),
    SCREEN_VIEW_CANCEL(4020000, "screen_view_cancel"),
    FLOW_VIEW_CANCEL(4020001, "flow_view_cancel"),
    LANDING_H5(5010000, "landing_h5"),
    DEEP_LINK_OPEN(6010000, "deep_link_open"),
    IMP_REQUEST(7010000, "imp_request"),
    CLICK_REQUEST(7020000, "click_track_request"),
    DOWN_H5_ZIP(8010000, "down_h5_zip"),
    SHAKE(1000099, OperationBi.ACTION_SHAKE_AREA),
    INTO_METHOD(1000100, "into_method"),
    IMAGE_MONITOR(1000003, "image_monitor"),
    IMAGE_LOADER_MONITOR(1000004, "image_loader_monitor");

    public String arg1;
    public int eventId;

    AdUtConstants(int i10, String str) {
        this.eventId = i10;
        this.arg1 = str;
    }
}