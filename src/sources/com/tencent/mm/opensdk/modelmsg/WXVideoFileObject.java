package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WXVideoFileObject implements WXMediaMessage.IMediaObject {
    public static final int FILE_SIZE_LIMIT = 104857600;
    private static final String TAG = "MicroMsg.SDK.WXVideoFileObject";
    public static final int WXVideoFileShareSceneCommon = 0;
    public static final int WXVideoFileShareSceneFromWX = 1;
    public String filePath;
    public int shareScene;
    public String shareTicket;

    public WXVideoFileObject() {
        this.shareScene = 0;
        this.filePath = null;
    }

    public WXVideoFileObject(String str) {
        this.shareScene = 0;
        this.filePath = str;
    }

    private int getFileSize(String str) {
        return d.getFileSize(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        String str2 = this.filePath;
        if (str2 == null || str2.length() == 0) {
            str = "checkArgs fail, filePath is null";
        } else {
            if (getFileSize(this.filePath) <= 104857600) {
                return true;
            }
            str = "checkArgs fail, video file size is too large";
        }
        Log.e(TAG, str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putInt("_wxvideofileobject_shareScene", this.shareScene);
        bundle.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 38;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.shareScene = bundle.getInt("_wxvideofileobject_shareScene", 0);
        this.shareTicket = bundle.getString("_wxvideofileobject_shareTicketh");
    }
}
