package wseemann.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.kuaishou.weapon.p0.t;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FFmpegMediaMetadataRetriever {
    public static Bitmap.Config IN_PREFERRED_CONFIG = null;
    private static final String[] JNI_LIBRARIES;
    public static final String METADATA_CHAPTER_COUNT = "chapter_count";
    public static final String METADATA_KEY_ALBUM = "album";
    public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final String METADATA_KEY_ARTIST = "artist";
    public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
    public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
    public static final String METADATA_KEY_COMMENT = "comment";
    public static final String METADATA_KEY_COMPOSER = "composer";
    public static final String METADATA_KEY_COPYRIGHT = "copyright";
    public static final String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final String METADATA_KEY_DATE = "date";
    public static final String METADATA_KEY_DISC = "disc";
    public static final String METADATA_KEY_DURATION = "duration";
    public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final String METADATA_KEY_ENCODER = "encoder";
    public static final String METADATA_KEY_FILENAME = "filename";
    public static final String METADATA_KEY_FILESIZE = "filesize";
    public static final String METADATA_KEY_FRAMERATE = "framerate";
    public static final String METADATA_KEY_GENRE = "genre";
    public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final String METADATA_KEY_LANGUAGE = "language";
    public static final String METADATA_KEY_PERFORMER = "performer";
    public static final String METADATA_KEY_PUBLISHER = "publisher";
    public static final String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final String METADATA_KEY_TITLE = "title";
    public static final String METADATA_KEY_TRACK = "track";
    public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final String METADATA_KEY_VIDEO_HEIGHT = "video_height";
    public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final String METADATA_KEY_VIDEO_WIDTH = "video_width";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    private static final String TAG = "FFmpegMediaMetadataRetriever";
    private long mNativeContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class Metadata {
        public static final int BOOLEAN_VAL = 3;
        public static final int BYTE_ARRAY_VAL = 7;
        public static final int DATE_VAL = 6;
        public static final int DOUBLE_VAL = 5;
        public static final int INTEGER_VAL = 2;
        public static final int LONG_VAL = 4;
        public static final int STRING_VAL = 1;
        private HashMap<String, String> mParcel;

        public Metadata() {
        }

        private boolean checkMetadataId(String str) {
            return true;
        }

        private void checkType(String str, int i10) {
            String str2 = this.mParcel.get(str);
            if (str2 != null) {
                return;
            }
            throw new IllegalStateException("Wrong type " + i10 + " but got " + str2);
        }

        public HashMap<String, String> getAll() {
            return this.mParcel;
        }

        public boolean getBoolean(String str) {
            checkType(str, 3);
            return Integer.valueOf(this.mParcel.get(str)).intValue() == 1;
        }

        public byte[] getByteArray(String str) {
            checkType(str, 7);
            return this.mParcel.get(str).getBytes();
        }

        public Date getDate(String str) {
            checkType(str, 6);
            long longValue = Long.valueOf(this.mParcel.get(str)).longValue();
            String str2 = this.mParcel.get(str);
            if (str2.length() == 0) {
                return new Date(longValue);
            }
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(str2));
            calendar.setTimeInMillis(longValue);
            return calendar.getTime();
        }

        public double getDouble(String str) {
            checkType(str, 5);
            return Double.valueOf(this.mParcel.get(str)).doubleValue();
        }

        public int getInt(String str) {
            checkType(str, 2);
            return Integer.valueOf(this.mParcel.get(str)).intValue();
        }

        public long getLong(String str) {
            checkType(str, 4);
            return Long.valueOf(this.mParcel.get(str)).longValue();
        }

        public String getString(String str) {
            checkType(str, 1);
            return String.valueOf(this.mParcel.get(str));
        }

        public boolean has(String str) {
            if (checkMetadataId(str)) {
                return this.mParcel.containsKey(str);
            }
            throw new IllegalArgumentException("Invalid key: " + str);
        }

        public boolean parse(HashMap<String, String> hashMap) {
            if (hashMap == null) {
                return false;
            }
            this.mParcel = hashMap;
            return true;
        }
    }

    static {
        String[] strArr = {"crypto", "ssl", "avutil", "swscale", "avcodec", "avformat", "ffmpeg_mediametadataretriever_jni"};
        JNI_LIBRARIES = strArr;
        for (String str : strArr) {
            System.loadLibrary(str);
        }
        native_init();
    }

    public FFmpegMediaMetadataRetriever() {
        native_setup();
    }

    private native byte[] _getFrameAtTime(long j10, int i10);

    private native byte[] _getScaledFrameAtTime(long j10, int i10, int i11, int i12);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IllegalArgumentException;

    private final native void native_finalize();

    private final native HashMap<String, String> native_getMetadata(boolean z10, boolean z11, HashMap<String, String> hashMap);

    private static native void native_init();

    private native void native_setup();

    public native String extractMetadata(String str);

    public native String extractMetadataFromChapter(String str, int i10);

    public void finalize() throws Throwable {
        try {
            native_finalize();
        } finally {
            super.finalize();
        }
    }

    public native byte[] getEmbeddedPicture();

    public Bitmap getFrameAtTime(long j10, int i10) {
        if (i10 >= 0 && i10 <= 3) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            byte[] _getFrameAtTime = _getFrameAtTime(j10, i10);
            if (_getFrameAtTime != null) {
                return BitmapFactory.decodeByteArray(_getFrameAtTime, 0, _getFrameAtTime.length, options);
            }
            return null;
        }
        throw new IllegalArgumentException("Unsupported option: " + i10);
    }

    public Metadata getMetadata() {
        Metadata metadata = new Metadata();
        HashMap<String, String> native_getMetadata = native_getMetadata(false, false, null);
        if (native_getMetadata != null && metadata.parse(native_getMetadata)) {
            return metadata;
        }
        return null;
    }

    public Bitmap getScaledFrameAtTime(long j10, int i10, int i11, int i12) {
        if (i10 >= 0 && i10 <= 3) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j10, i10, i11, i12);
            if (_getScaledFrameAtTime != null) {
                return BitmapFactory.decodeByteArray(_getScaledFrameAtTime, 0, _getScaledFrameAtTime.length, options);
            }
            return null;
        }
        throw new IllegalArgumentException("Unsupported option: " + i10);
    }

    public native void release();

    public native void setDataSource(FileDescriptor fileDescriptor, long j10, long j11) throws IllegalArgumentException;

    public native void setDataSource(String str) throws IllegalArgumentException;

    public void setDataSource(String str, Map<String, String> map) throws IllegalArgumentException {
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        int i10 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i10] = entry.getKey();
            strArr2[i10] = entry.getValue();
            i10++;
        }
        _setDataSource(str, strArr, strArr2);
    }

    public native void setSurface(Object obj);

    public Bitmap getFrameAtTime(long j10) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        byte[] _getFrameAtTime = _getFrameAtTime(j10, 2);
        if (_getFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getFrameAtTime, 0, _getFrameAtTime.length, options);
        }
        return null;
    }

    public Bitmap getScaledFrameAtTime(long j10, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j10, 2, i10, i11);
        if (_getScaledFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getScaledFrameAtTime, 0, _getScaledFrameAtTime.length, options);
        }
        return null;
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalArgumentException {
        setDataSource(fileDescriptor, 0L, 576460752303423487L);
    }

    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException {
        if (uri != null) {
            String scheme = uri.getScheme();
            if (scheme != null && !scheme.equals("file")) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    try {
                        AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, t.f36226k);
                        if (openAssetFileDescriptor != null) {
                            FileDescriptor fileDescriptor = openAssetFileDescriptor.getFileDescriptor();
                            if (fileDescriptor.valid()) {
                                if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                                    setDataSource(fileDescriptor);
                                } else {
                                    setDataSource(fileDescriptor, openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
                                }
                                try {
                                    openAssetFileDescriptor.close();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException();
                    } catch (FileNotFoundException unused2) {
                        throw new IllegalArgumentException();
                    }
                } catch (SecurityException unused3) {
                    if (0 != 0) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused4) {
                        }
                    }
                    setDataSource(uri.toString());
                    return;
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            }
            setDataSource(uri.getPath());
            return;
        }
        throw new IllegalArgumentException();
    }

    public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1L, 2);
    }
}
