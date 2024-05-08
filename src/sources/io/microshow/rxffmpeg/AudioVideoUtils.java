package io.microshow.rxffmpeg;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AudioVideoUtils {
    public static long getDuration(String str) {
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrack(mediaExtractor));
            long j10 = trackFormat.containsKey("durationUs") ? trackFormat.getLong("durationUs") : 0L;
            mediaExtractor.release();
            return j10;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int getFitBitRate(int i10) {
        if (i10 <= 230400) {
            return 1024000;
        }
        if (i10 <= 307200) {
            return 1536000;
        }
        if (i10 <= 384000) {
            return 1843200;
        }
        if (i10 <= 522240) {
            return 2097152;
        }
        if (i10 <= 921600) {
            return 2621440;
        }
        if (i10 <= 2088960) {
            return EffectsSDKEffectConstants.FaceExtraModel.BEF_MOBILE_FACE_240_DETECT_FASTMODE;
        }
        return 3584000;
    }

    public static int getVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata) / 1000;
    }

    public static int getVideoHeight(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
        if (!"90".equals(extractMetadata3) && !"270".equals(extractMetadata3)) {
            extractMetadata = extractMetadata2;
        }
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata);
    }

    public static int getVideoRotation(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata);
    }

    public static int getVideoWidth(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
        if ("90".equals(extractMetadata3) || "270".equals(extractMetadata3)) {
            extractMetadata = extractMetadata2;
        }
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata);
    }

    public static boolean isHorizontalVideo(String str) {
        return getVideoWidth(str) >= getVideoHeight(str);
    }

    public static int selectAudioTrack(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i10 = 0; i10 < trackCount; i10++) {
            if (mediaExtractor.getTrackFormat(i10).getString(DatabaseSourceInfoStorage.COLUMN_MIME).startsWith("audio/")) {
                return i10;
            }
        }
        return -1;
    }

    public static int selectVideoTrack(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i10 = 0; i10 < trackCount; i10++) {
            if (mediaExtractor.getTrackFormat(i10).getString(DatabaseSourceInfoStorage.COLUMN_MIME).startsWith("video/")) {
                return i10;
            }
        }
        return -1;
    }
}
