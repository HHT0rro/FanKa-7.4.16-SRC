package androidx.media.utils;

import androidx.annotation.RestrictTo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class MediaConstants {
    public static final String BROWSER_ROOT_HINTS_KEY_MEDIA_ART_SIZE_PIXELS = "android.media.extras.MEDIA_ART_SIZE_HINT_PIXELS";
    public static final String BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_LIMIT = "androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_LIMIT";
    public static final String BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_SUPPORTED_FLAGS = "androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS";
    public static final String BROWSER_SERVICE_EXTRAS_KEY_SEARCH_SUPPORTED = "android.media.browse.SEARCH_SUPPORTED";
    public static final String DESCRIPTION_EXTRAS_KEY_COMPLETION_STATUS = "android.media.extra.PLAYBACK_STATUS";
    public static final String DESCRIPTION_EXTRAS_KEY_CONTENT_STYLE_BROWSABLE = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT";
    public static final String DESCRIPTION_EXTRAS_KEY_CONTENT_STYLE_GROUP_TITLE = "android.media.browse.CONTENT_STYLE_GROUP_TITLE_HINT";
    public static final String DESCRIPTION_EXTRAS_KEY_CONTENT_STYLE_PLAYABLE = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT";
    public static final int DESCRIPTION_EXTRAS_VALUE_COMPLETION_STATUS_FULLY_PLAYED = 2;
    public static final int DESCRIPTION_EXTRAS_VALUE_COMPLETION_STATUS_NOT_PLAYED = 0;
    public static final int DESCRIPTION_EXTRAS_VALUE_COMPLETION_STATUS_PARTIALLY_PLAYED = 1;
    public static final int DESCRIPTION_EXTRAS_VALUE_CONTENT_STYLE_CATEGORY_GRID_ITEM = 4;
    public static final int DESCRIPTION_EXTRAS_VALUE_CONTENT_STYLE_CATEGORY_LIST_ITEM = 3;
    public static final int DESCRIPTION_EXTRAS_VALUE_CONTENT_STYLE_GRID_ITEM = 2;
    public static final int DESCRIPTION_EXTRAS_VALUE_CONTENT_STYLE_LIST_ITEM = 1;
    public static final String METADATA_KEY_CONTENT_ID = "androidx.media.MediaMetadatCompat.METADATA_KEY_CONTENT_ID";
    public static final String METADATA_KEY_IS_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_IS_EXPLICIT = "android.media.IS_EXPLICIT";
    public static final long METADATA_VALUE_ATTRIBUTE_PRESENT = 1;
    public static final String PLAYBACK_STATE_EXTRAS_KEY_ERROR_RESOLUTION_ACTION_INTENT = "android.media.extras.ERROR_RESOLUTION_ACTION_INTENT";
    public static final String PLAYBACK_STATE_EXTRAS_KEY_ERROR_RESOLUTION_ACTION_LABEL = "android.media.extras.ERROR_RESOLUTION_ACTION_LABEL";
    public static final String PLAYBACK_STATE_EXTRAS_KEY_MEDIA_ID = "androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID";
    public static final String SESSION_EXTRAS_KEY_ACCOUNT_NAME = "androidx.media.MediaSessionCompat.Extras.KEY_ACCOUNT_NAME";
    public static final String SESSION_EXTRAS_KEY_ACCOUNT_TYPE = "androidx.media.MediaSessionCompat.Extras.KEY_ACCOUNT_TYPE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String SESSION_EXTRAS_KEY_AUTHTOKEN = "androidx.media.MediaSessionCompat.Extras.KEY_AUTHTOKEN";
    public static final String SESSION_EXTRAS_KEY_SLOT_RESERVATION_SKIP_TO_NEXT = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT";
    public static final String SESSION_EXTRAS_KEY_SLOT_RESERVATION_SKIP_TO_PREV = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS";

    private MediaConstants() {
    }
}
