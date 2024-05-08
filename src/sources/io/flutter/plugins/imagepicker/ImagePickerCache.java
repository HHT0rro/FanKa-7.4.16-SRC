package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugins.imagepicker.Messages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ImagePickerCache {
    private static final String FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY = "flutter_image_picker_image_path";
    public static final String MAP_KEY_ERROR = "error";
    public static final String MAP_KEY_IMAGE_QUALITY = "imageQuality";
    public static final String MAP_KEY_MAX_HEIGHT = "maxHeight";
    public static final String MAP_KEY_MAX_WIDTH = "maxWidth";
    public static final String MAP_KEY_PATH_LIST = "pathList";
    public static final String MAP_KEY_TYPE = "type";
    private static final String MAP_TYPE_VALUE_IMAGE = "image";
    private static final String MAP_TYPE_VALUE_VIDEO = "video";

    @VisibleForTesting
    public static final String SHARED_PREFERENCES_NAME = "flutter_image_picker_shared_preference";
    private static final String SHARED_PREFERENCE_ERROR_CODE_KEY = "flutter_image_picker_error_code";
    private static final String SHARED_PREFERENCE_ERROR_MESSAGE_KEY = "flutter_image_picker_error_message";
    private static final String SHARED_PREFERENCE_IMAGE_QUALITY_KEY = "flutter_image_picker_image_quality";
    private static final String SHARED_PREFERENCE_MAX_HEIGHT_KEY = "flutter_image_picker_max_height";
    private static final String SHARED_PREFERENCE_MAX_WIDTH_KEY = "flutter_image_picker_max_width";
    private static final String SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY = "flutter_image_picker_pending_image_uri";
    private static final String SHARED_PREFERENCE_TYPE_KEY = "flutter_image_picker_type";

    @NonNull
    private final Context context;

    /* renamed from: io.flutter.plugins.imagepicker.ImagePickerCache$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType;

        static {
            int[] iArr = new int[CacheType.values().length];
            $SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType = iArr;
            try {
                iArr[CacheType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType[CacheType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum CacheType {
        IMAGE,
        VIDEO
    }

    public ImagePickerCache(@NonNull Context context) {
        this.context = context;
    }

    private void setType(String str) {
        this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit().putString(SHARED_PREFERENCE_TYPE_KEY, str).apply();
    }

    public void clear() {
        this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit().clear().apply();
    }

    public Map<String, Object> getCacheMap() {
        Messages.CacheRetrievalType cacheRetrievalType;
        Set<String> stringSet;
        HashMap hashMap = new HashMap();
        boolean z10 = false;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        boolean z11 = true;
        if (sharedPreferences.contains(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY) && (stringSet = sharedPreferences.getStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, null)) != null) {
            hashMap.put(MAP_KEY_PATH_LIST, new ArrayList(stringSet));
            z10 = true;
        }
        if (sharedPreferences.contains(SHARED_PREFERENCE_ERROR_CODE_KEY)) {
            Messages.CacheRetrievalError.Builder builder = new Messages.CacheRetrievalError.Builder();
            builder.setCode(sharedPreferences.getString(SHARED_PREFERENCE_ERROR_CODE_KEY, ""));
            if (sharedPreferences.contains(SHARED_PREFERENCE_ERROR_MESSAGE_KEY)) {
                builder.setMessage(sharedPreferences.getString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, ""));
            }
            hashMap.put("error", builder.build());
        } else {
            z11 = z10;
        }
        if (z11) {
            if (sharedPreferences.contains(SHARED_PREFERENCE_TYPE_KEY)) {
                if (sharedPreferences.getString(SHARED_PREFERENCE_TYPE_KEY, "").equals("video")) {
                    cacheRetrievalType = Messages.CacheRetrievalType.VIDEO;
                } else {
                    cacheRetrievalType = Messages.CacheRetrievalType.IMAGE;
                }
                hashMap.put("type", cacheRetrievalType);
            }
            if (sharedPreferences.contains(SHARED_PREFERENCE_MAX_WIDTH_KEY)) {
                hashMap.put("maxWidth", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, 0L))));
            }
            if (sharedPreferences.contains(SHARED_PREFERENCE_MAX_HEIGHT_KEY)) {
                hashMap.put("maxHeight", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, 0L))));
            }
            hashMap.put(MAP_KEY_IMAGE_QUALITY, Integer.valueOf(sharedPreferences.getInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100)));
        }
        return hashMap;
    }

    public String retrievePendingCameraMediaUriPath() {
        return this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, "");
    }

    public void saveDimensionWithOutputOptions(Messages.ImageSelectionOptions imageSelectionOptions) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        if (imageSelectionOptions.getMaxWidth() != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, Double.doubleToRawLongBits(imageSelectionOptions.getMaxWidth().doubleValue()));
        }
        if (imageSelectionOptions.getMaxHeight() != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, Double.doubleToRawLongBits(imageSelectionOptions.getMaxHeight().doubleValue()));
        }
        edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, imageSelectionOptions.getQuality().intValue());
        edit.apply();
    }

    public void savePendingCameraMediaUriPath(Uri uri) {
        this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit().putString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, uri.getPath()).apply();
    }

    public void saveResult(@Nullable ArrayList<String> arrayList, @Nullable String str, @Nullable String str2) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        if (arrayList != null) {
            edit.putStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, new HashSet(arrayList));
        }
        if (str != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_CODE_KEY, str);
        }
        if (str2 != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, str2);
        }
        edit.apply();
    }

    public void saveType(CacheType cacheType) {
        int i10 = AnonymousClass1.$SwitchMap$io$flutter$plugins$imagepicker$ImagePickerCache$CacheType[cacheType.ordinal()];
        if (i10 == 1) {
            setType("image");
        } else {
            if (i10 != 2) {
                return;
            }
            setType("video");
        }
    }
}
