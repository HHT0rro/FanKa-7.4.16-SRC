package com.google.android.exoplayer2.util;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.bb;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;

/* compiled from: FileTypes.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(@Nullable String str) {
        char c4;
        if (str == null) {
            return -1;
        }
        String t2 = q.t(str);
        t2.hashCode();
        switch (t2.hashCode()) {
            case -2123537834:
                if (t2.equals("audio/eac3-joc")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -1662384011:
                if (t2.equals("video/mp2p")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -1662384007:
                if (t2.equals("video/mp2t")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -1662095187:
                if (t2.equals("video/webm")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -1606874997:
                if (t2.equals("audio/amr-wb")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -1487394660:
                if (t2.equals(bb.V)) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -1248337486:
                if (t2.equals("application/mp4")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -1004728940:
                if (t2.equals("text/vtt")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case -387023398:
                if (t2.equals("audio/x-matroska")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case -43467528:
                if (t2.equals("application/webm")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case 13915911:
                if (t2.equals("video/x-flv")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 187078296:
                if (t2.equals("audio/ac3")) {
                    c4 = 11;
                    break;
                }
                c4 = 65535;
                break;
            case 187078297:
                if (t2.equals("audio/ac4")) {
                    c4 = '\f';
                    break;
                }
                c4 = 65535;
                break;
            case 187078669:
                if (t2.equals("audio/amr")) {
                    c4 = CharUtils.CR;
                    break;
                }
                c4 = 65535;
                break;
            case 187090232:
                if (t2.equals("audio/mp4")) {
                    c4 = 14;
                    break;
                }
                c4 = 65535;
                break;
            case 187091926:
                if (t2.equals("audio/ogg")) {
                    c4 = 15;
                    break;
                }
                c4 = 65535;
                break;
            case 187099443:
                if (t2.equals("audio/wav")) {
                    c4 = 16;
                    break;
                }
                c4 = 65535;
                break;
            case 1331848029:
                if (t2.equals(bb.Code)) {
                    c4 = 17;
                    break;
                }
                c4 = 65535;
                break;
            case 1503095341:
                if (t2.equals("audio/3gpp")) {
                    c4 = 18;
                    break;
                }
                c4 = 65535;
                break;
            case 1504578661:
                if (t2.equals("audio/eac3")) {
                    c4 = 19;
                    break;
                }
                c4 = 65535;
                break;
            case 1504619009:
                if (t2.equals("audio/flac")) {
                    c4 = 20;
                    break;
                }
                c4 = 65535;
                break;
            case 1504831518:
                if (t2.equals("audio/mpeg")) {
                    c4 = 21;
                    break;
                }
                c4 = 65535;
                break;
            case 1505118770:
                if (t2.equals("audio/webm")) {
                    c4 = 22;
                    break;
                }
                c4 = 65535;
                break;
            case 2039520277:
                if (t2.equals("video/x-matroska")) {
                    c4 = 23;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
            case 11:
            case 19:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case '\b':
            case '\t':
            case 22:
            case 23:
                return 6;
            case 4:
            case '\r':
            case 18:
                return 3;
            case 5:
                return 14;
            case 6:
            case 14:
            case 17:
                return 8;
            case 7:
                return 13;
            case '\n':
                return 5;
            case '\f':
                return 1;
            case 15:
                return 9;
            case 16:
                return 12;
            case 20:
                return 4;
            case 21:
                return 7;
            default:
                return -1;
        }
    }

    public static int b(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        return (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) ? 14 : -1;
    }
}
