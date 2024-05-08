package com.huawei.quickcard.video.processor;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.video.VideoAttributes;
import com.huawei.quickcard.video.view.IVideoHost;
import com.huawei.quickcard.video.view.VideoHostView;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoCommonAttribute implements PropertyProcessor<VideoHostView> {
    private void a(IVideoHost iVideoHost, boolean z10) {
        iVideoHost.setAutoPlay(z10);
    }

    private void b(IVideoHost iVideoHost, String str) {
        iVideoHost.setOrientation(str);
    }

    private void c(IVideoHost iVideoHost, String str) {
        iVideoHost.setPoster(str);
    }

    private void d(IVideoHost iVideoHost, boolean z10) {
        iVideoHost.setTitleBar(z10);
    }

    private void e(IVideoHost iVideoHost, String str) {
        iVideoHost.setVideoURI(str);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return false;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1869997381:
                if (str.equals(VideoAttributes.Style.TITLEBAR)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1489619886:
                if (str.equals("objectFit")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1439500848:
                if (str.equals("orientation")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1137356649:
                if (str.equals(VideoAttributes.Style.AUTO_STOP_LENGTH)) {
                    c4 = 3;
                    break;
                }
                break;
            case -982450867:
                if (str.equals(VideoAttributes.Style.POSTER)) {
                    c4 = 4;
                    break;
                }
                break;
            case -566933834:
                if (str.equals(VideoAttributes.Style.CONTROLS)) {
                    c4 = 5;
                    break;
                }
                break;
            case -42220100:
                if (str.equals(VideoAttributes.Style.AUTO_GO_ON_LENGTH)) {
                    c4 = 6;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c4 = 7;
                    break;
                }
                break;
            case 104264043:
                if (str.equals("muted")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1575916830:
                if (str.equals(VideoAttributes.Style.FULLSCREEN_ENABLE)) {
                    c4 = 11;
                    break;
                }
                break;
            case 1733075952:
                if (str.equals(VideoAttributes.Style.MULTI_PLAY_ENABLE)) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1788670583:
                if (str.equals(VideoAttributes.Style.BLOCK_AUTO_CONTINUE_PLAY)) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 5:
            case 11:
                return ParserHelper.parseToBool(obj, true);
            case 1:
                return ParserHelper.parseToString(obj, "contain");
            case 2:
                return ParserHelper.parseToString(obj, VideoAttributes.CommonValue.DEFAULT_ORIENTATION);
            case 3:
            case 6:
                return ParserHelper.parseToDP(obj, 0.0f);
            case 4:
            case 7:
            case '\t':
                return ParserHelper.parseToString(obj, "");
            case '\b':
            case '\n':
            case '\f':
            case '\r':
                return ParserHelper.parseToBool(obj, false);
            default:
                return new QuickCardValue();
        }
    }

    private void a(IVideoHost iVideoHost, String str) {
        iVideoHost.setObjectFit(str);
    }

    private void b(IVideoHost iVideoHost, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            iVideoHost.setFullScreenEnable(true);
        } else {
            iVideoHost.setFullScreenEnable(quickCardValue.getBoolean());
        }
    }

    private void c(IVideoHost iVideoHost, boolean z10) {
        iVideoHost.setMuted(z10);
    }

    private void d(IVideoHost iVideoHost, String str) {
        iVideoHost.setTitle(str);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull VideoHostView videoHostView, String str, QuickCardValue quickCardValue) {
        if (videoHostView == null || str == null || quickCardValue == null) {
            return;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1869997381:
                if (str.equals(VideoAttributes.Style.TITLEBAR)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1489619886:
                if (str.equals("objectFit")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1439500848:
                if (str.equals("orientation")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1137356649:
                if (str.equals(VideoAttributes.Style.AUTO_STOP_LENGTH)) {
                    c4 = 3;
                    break;
                }
                break;
            case -982450867:
                if (str.equals(VideoAttributes.Style.POSTER)) {
                    c4 = 4;
                    break;
                }
                break;
            case -566933834:
                if (str.equals(VideoAttributes.Style.CONTROLS)) {
                    c4 = 5;
                    break;
                }
                break;
            case -42220100:
                if (str.equals(VideoAttributes.Style.AUTO_GO_ON_LENGTH)) {
                    c4 = 6;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c4 = 7;
                    break;
                }
                break;
            case 104264043:
                if (str.equals("muted")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1575916830:
                if (str.equals(VideoAttributes.Style.FULLSCREEN_ENABLE)) {
                    c4 = 11;
                    break;
                }
                break;
            case 1733075952:
                if (str.equals(VideoAttributes.Style.MULTI_PLAY_ENABLE)) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1788670583:
                if (str.equals(VideoAttributes.Style.BLOCK_AUTO_CONTINUE_PLAY)) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                d(videoHostView, quickCardValue.getBoolean());
                return;
            case 1:
                a(videoHostView, quickCardValue.getString());
                return;
            case 2:
                b(videoHostView, quickCardValue.getString());
                return;
            case 3:
                b(videoHostView, quickCardValue);
                return;
            case 4:
                c(videoHostView, quickCardValue.getString());
                return;
            case 5:
                a((IVideoHost) videoHostView, quickCardValue);
                return;
            case 6:
                a(videoHostView, quickCardValue);
                return;
            case 7:
                e(videoHostView, quickCardValue.getString());
                return;
            case '\b':
                c(videoHostView, quickCardValue.getBoolean());
                return;
            case '\t':
                d(videoHostView, quickCardValue.getString());
                return;
            case '\n':
                a((IVideoHost) videoHostView, quickCardValue.getBoolean());
                return;
            case 11:
                b((IVideoHost) videoHostView, quickCardValue);
                return;
            case '\f':
                b(videoHostView, quickCardValue.getBoolean());
                return;
            case '\r':
                a(videoHostView, quickCardValue.getBoolean());
                return;
            default:
                return;
        }
    }

    private void a(IVideoHost iVideoHost, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            iVideoHost.setControls(true);
        } else {
            iVideoHost.setControls(quickCardValue.getBoolean());
        }
    }

    private void b(@NonNull VideoHostView videoHostView, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            videoHostView.setAutoStopLength(-1);
        } else {
            videoHostView.setAutoStopLength(ViewUtils.dip2IntPx(videoHostView, quickCardValue.getDp()));
        }
    }

    private void a(@NonNull VideoHostView videoHostView, boolean z10) {
        videoHostView.setBlockAutoContinuePlay(z10);
    }

    private void a(@NonNull VideoHostView videoHostView, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            videoHostView.setAutoGoOnLength(-1);
        } else {
            videoHostView.setAutoGoOnLength(ViewUtils.dip2IntPx(videoHostView, quickCardValue.getDp()));
        }
    }

    private void b(IVideoHost iVideoHost, boolean z10) {
        iVideoHost.setMultiPlayEnable(z10);
    }
}
