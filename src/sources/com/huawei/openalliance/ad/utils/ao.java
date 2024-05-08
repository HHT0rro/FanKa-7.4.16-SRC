package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.beans.metadata.Permission;
import com.huawei.openalliance.ad.beans.metadata.TextState;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.beans.metadata.v3.Asset;
import com.huawei.openalliance.ad.beans.metadata.v3.MotionData;
import com.huawei.openalliance.ad.beans.metadata.v3.TemplateData;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Data;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Image;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.ImageExt;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Title;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Video;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ao extends ObjectInputStream {
    private static final Class[] Code = {String.class, ArrayList.class, CopyOnWriteArrayList.class, LinkedList.class, HashMap.class, HashSet.class, Integer.class, Float.class, Boolean.class, Long.class, Byte.class, Character.class, Short.class, Double.class, Number.class, ImageInfo.class, VideoInfo.class, AppInfo.class, Permission.class, PermissionEntity.class, VideoInfo.class, ApkInfo.class, MetaData.class, AdContentData.class, InstallConfig.class, Om.class, ImpEX.class, DelayInfo.class, MediaFile.class, AdTimeStatistics.class, TextState.class, InteractCfg.class, ContentExt.class, FeedbackInfo.class, AdSource.class, com.huawei.openalliance.ad.beans.metadata.a.class, TemplateData.class, MotionData.class, Asset.class, Image.class, ImageExt.class, Video.class, Title.class, Data.class, AdvertiserInfo.class, DefaultTemplate.class};

    public ao(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        Class[] clsArr = Code;
        int length = clsArr.length;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (clsArr[i10].getName().equals(objectStreamClass.getName())) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            return super.resolveClass(objectStreamClass);
        }
        throw new ClassNotFoundException("Class " + objectStreamClass.getName() + " is not allowed!");
    }
}
