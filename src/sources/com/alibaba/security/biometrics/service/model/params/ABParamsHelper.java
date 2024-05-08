package com.alibaba.security.biometrics.service.model.params;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.util.params.ParamsHelper;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.StringUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ABParamsHelper extends ParamsHelper<ALBiometricsParams> implements ALBiometricsKeys {
    private static final String TAG = "ABParamsHelper";

    public ABParamsHelper(Bundle bundle) {
        super(bundle);
        initDefaults(bundle);
    }

    private void initBiometricsConfig(Bundle bundle) {
        ALBiometricsParams aLBiometricsParams;
        BiometricsConfig biometricsConfig;
        if (bundle == null || bundle.getString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG) == null || (aLBiometricsParams = (ALBiometricsParams) getParams()) == null || (biometricsConfig = aLBiometricsParams.biometricsConfig) == null) {
            return;
        }
        int i10 = biometricsConfig.adjustStep;
        if (i10 >= 0) {
            setParam(ALBiometricsKeys.KEY_STEP_ADJUST, Boolean.valueOf(i10 == 1));
        }
        int i11 = biometricsConfig.actionCount;
        if (i11 >= 0) {
            setParam(ALBiometricsKeys.KEY_ACTION_COUNT, Integer.valueOf(i11));
        }
        String str = biometricsConfig.actions;
        if (str != null) {
            try {
                String[] split = str.split("\\|");
                int[] iArr = new int[split.length];
                for (int i12 = 0; i12 < split.length; i12++) {
                    iArr[i12] = Integer.parseInt(split[i12]);
                }
                setParam("strategy", iArr);
            } catch (Throwable th) {
                RPLogging.e(TAG, th);
            }
        }
        int i13 = biometricsConfig.lessImageMode;
        if (i13 >= 0) {
            setParam(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, Boolean.valueOf(i13 == 1));
        }
        int i14 = biometricsConfig.bigImageSize;
        if (i14 >= 0) {
            setParam(ALBiometricsKeys.KEY_BIG_IMAGE_SIZE, Integer.valueOf(i14));
        }
        int i15 = biometricsConfig.detectWrongAction;
        if (i15 >= 0) {
            setParam(ALBiometricsKeys.KEY_DETECT_WRONG_ACTION, Boolean.valueOf(i15 == 1));
        }
        int i16 = biometricsConfig.detectOcclusion;
        if (i16 >= 0) {
            setParam(ALBiometricsKeys.KEY_DETECT_OCCLUSION, Boolean.valueOf(i16 == 1));
        }
        int i17 = biometricsConfig.imageCount;
        if (i17 >= 0) {
            setParam(ALBiometricsKeys.KEY_IMG_COUNT, Integer.valueOf(i17));
        }
        int i18 = biometricsConfig.imageIntervals;
        if (i18 >= 0) {
            setParam(ALBiometricsKeys.KEY_IMG_INTERVALS, Integer.valueOf(i18));
        }
        int i19 = biometricsConfig.enableRecap;
        if (i19 >= 0) {
            setParam(ALBiometricsKeys.KEY_RECAP_ENABLE, Boolean.valueOf(i19 == 1));
        }
        int i20 = biometricsConfig.recapMode;
        if (i20 >= 0) {
            setParam(ALBiometricsKeys.KEY_RECAP_MODE, Integer.valueOf(i20));
        }
        float f10 = biometricsConfig.recapThreshold;
        if (f10 > -1.0f) {
            setParam("recapThreshold", Float.valueOf(f10));
        }
        String str2 = biometricsConfig.recognizeTargetData;
        String str3 = (str2 == null && (str2 = biometricsConfig.recognizeTemplateFeature) == null) ? null : str2;
        if (str3 != null) {
            try {
                setParam(ALBiometricsKeys.KEY_FACE_RECOGNIZE_TARGET_DATA, StringUtils.hexStringToBytes(str3));
            } catch (Throwable th2) {
                RPLogging.e(TAG, th2);
            }
        }
        int i21 = biometricsConfig.displayWaitingView;
        if (i21 >= 0) {
            setParam(ALBiometricsKeys.KEY_NEED_DISPLAY_WAITING_VIEW, Boolean.valueOf(i21 == 1));
        }
        int i22 = biometricsConfig.reflectILThreshold;
        if (i22 >= 0) {
            setParam(ALBiometricsKeys.KEY_REFLECT_IL_THRESHOLD, Integer.valueOf(i22));
        }
        float f11 = biometricsConfig.reflectDistanceThreshold;
        if (f11 > -1.0f) {
            setParam(ALBiometricsKeys.KEY_REFLECT_DISTANCE_THRESHOLD, Float.valueOf(f11));
        }
        int i23 = biometricsConfig.reflectPrevFailThreshold;
        if (i23 >= 0) {
            setParam(ALBiometricsKeys.KEY_REFLECT_PREV_FAIL_THRESHOLD, Integer.valueOf(i23));
        }
        int i24 = biometricsConfig.actionWhileCheckFail;
        if (i24 >= 0) {
            setParam("actionWhileCheckFail", Integer.valueOf(i24));
        }
        String str4 = biometricsConfig.strategyWhileCheckFail;
        if (str4 != null) {
            try {
                String[] split2 = str4.split("\\|");
                int[] iArr2 = new int[split2.length];
                for (int i25 = 0; i25 < split2.length; i25++) {
                    iArr2[i25] = Integer.parseInt(split2[i25]);
                }
                setParam("strategyWhileCheckFail", iArr2);
            } catch (Throwable th3) {
                RPLogging.e(TAG, th3);
            }
        }
        int i26 = biometricsConfig.bgDetectTimeIntervals;
        if (i26 >= 0) {
            setParam(ALBiometricsKeys.KEY_BG_DETECT_TIME_INTERVALS, Integer.valueOf(i26));
        }
        int i27 = biometricsConfig.bgDetectColorThreshold;
        if (i27 >= 0) {
            setParam(ALBiometricsKeys.KEY_BG_DETECT_COLOR_THRESHOLD, Integer.valueOf(i27));
        }
        int i28 = biometricsConfig.needSuccessVideo;
        if (i28 >= 0) {
            setParam("needSuccessVideo", Boolean.valueOf(i28 == 1));
        }
        int i29 = biometricsConfig.needFailVideo;
        if (i29 >= 0) {
            setParam("needFailVideo", Boolean.valueOf(i29 == 1));
        }
        String str5 = biometricsConfig.licenseData;
        if (str5 != null) {
            try {
                setParam(ALBiometricsKeys.KEY_LICENSE_DATA, StringUtils.hexStringToBytes(str5));
            } catch (Throwable th4) {
                RPLogging.e(TAG, th4);
            }
        }
        String str6 = biometricsConfig.licenseTimeData;
        if (str6 != null) {
            try {
                setParam(ALBiometricsKeys.KEY_LICENSE_TIME_DATA, StringUtils.hexStringToBytes(str6));
            } catch (Throwable th5) {
                RPLogging.e(TAG, th5);
            }
        }
    }

    private void initDefaults(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ALBiometricsParams params = getParams();
        int i10 = params.actionCount;
        if (i10 == 1) {
            if (!bundle.containsKey(ALBiometricsKeys.KEY_STEP_ADJUST)) {
                setParam(ALBiometricsKeys.KEY_STEP_ADJUST, Boolean.FALSE);
            }
        } else if (i10 == 0) {
            setParam(ALBiometricsKeys.KEY_STEP_ADJUST, Boolean.TRUE);
        }
        if (!bundle.containsKey(ALBiometricsKeys.KEY_FACE_IMG_CHECK_ENABLE)) {
            if (params.actionCount > 0) {
                setParam(ALBiometricsKeys.KEY_FACE_IMG_CHECK_ENABLE, Boolean.TRUE);
            } else {
                setParam(ALBiometricsKeys.KEY_FACE_IMG_CHECK_ENABLE, Boolean.FALSE);
            }
        }
        if (!bundle.containsKey(ALBiometricsKeys.KEY_FACE_RECOGNIZE_RETRY)) {
            if (params.actionCount > 0) {
                setParam(ALBiometricsKeys.KEY_FACE_RECOGNIZE_RETRY, Boolean.TRUE);
            } else {
                setParam(ALBiometricsKeys.KEY_FACE_RECOGNIZE_RETRY, Boolean.FALSE);
            }
        }
        initBiometricsConfig(bundle);
    }
}
