package com.tencent.vasdolly.reader;

import com.tencent.vasdolly.common.ChannelConstants;
import com.tencent.vasdolly.common.V1SchemeUtil;
import com.tencent.vasdolly.common.V2SchemeUtil;
import com.tencent.vasdolly.common.V3SchemeUtil;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ChannelReader {
    public static boolean containV1Signature(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return V1SchemeUtil.containV1Signature(file);
        }
        return false;
    }

    public static boolean containV2Signature(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return V2SchemeUtil.containV2Signature(file);
        }
        return false;
    }

    public static boolean containV3Signature(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return V3SchemeUtil.containV3Signature(file);
        }
        return false;
    }

    public static String getChannelByV1(File file) {
        try {
            return V1SchemeUtil.readChannel(file);
        } catch (Exception unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have channel info from Zip Comment");
            return "";
        }
    }

    public static String getChannelByV2(File file) {
        System.out.println("try to read channel info from apk : " + file.getAbsolutePath());
        return IdValueReader.getStringValueById(file, ChannelConstants.CHANNEL_BLOCK_ID);
    }

    public static boolean verifyChannelByV1(File file, String str) {
        if (str != null) {
            return str.equals(getChannelByV1(file));
        }
        return false;
    }

    public static boolean verifyChannelByV2(File file, String str) {
        if (str != null) {
            return str.equals(getChannelByV2(file));
        }
        return false;
    }
}
