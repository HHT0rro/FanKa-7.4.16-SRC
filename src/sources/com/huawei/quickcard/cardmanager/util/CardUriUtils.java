package com.huawei.quickcard.cardmanager.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardUriUtils {
    public static final String COMBO_CARD_SCHEME = "flayout";
    public static final String PARAM_MIN_PLATFORM_VER = "minPlatformVer";
    public static final String PARAM_MIN_SDK_VER = "minSdkVer";
    public static final String PARAM_SIGN = "sign";
    public static final String PARAM_VER = "ver";
    public static final String QUICK_CARD_SCHEME = "fastView";

    /* renamed from: a, reason: collision with root package name */
    private static final String f33563a = "@";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33564b = "CardUriUtils";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33565c = "_";

    private static boolean a(@NonNull String str) {
        return str.contains(f33563a);
    }

    public static boolean check(@NonNull String str) {
        ManagerLogUtil.i(f33564b, "check uri: " + str);
        if (TextUtils.isEmpty(str)) {
            ManagerLogUtil.e(f33564b, "uri is empty");
            return false;
        }
        return check(parse(str));
    }

    @NonNull
    public static String getCardName(@Nullable CardBean cardBean) {
        if (cardBean == null) {
            return "";
        }
        return cardBean.getCardId() + "_" + cardBean.getVer() + "_" + cardBean.getMinPlatformVersion();
    }

    @NonNull
    public static CardBean parse(@NonNull String str) {
        if (a.b(str)) {
            return a.a(str);
        }
        CardBean cardBean = new CardBean();
        if (a(str)) {
            ManagerLogUtil.e(f33564b, "unsupported card url::" + str);
            return cardBean;
        }
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if ("fastView".equals(scheme)) {
                cardBean.setType("quick");
                cardBean.setMinPlatformVersion(NumUtils.parseInt(parse.getQueryParameter("minPlatformVer"), 0));
            } else if ("flayout".equals(scheme)) {
                cardBean.setType("combo");
                cardBean.setMinPlatformVersion(NumUtils.parseInt(parse.getQueryParameter(PARAM_MIN_SDK_VER), 0));
            } else {
                ManagerLogUtil.w(f33564b, "uri scheme not support:" + str);
                return cardBean;
            }
            cardBean.setCardId(parse.getHost());
            cardBean.setVer(NumUtils.parseInt(parse.getQueryParameter("ver"), 0));
            String queryParameter = parse.getQueryParameter(PARAM_SIGN);
            if (queryParameter != null) {
                cardBean.setSign(queryParameter);
            }
            a.a(str, cardBean);
        } catch (Exception unused) {
            ManagerLogUtil.e(f33564b, "parse card uri failed, card uri: " + str);
        }
        return cardBean;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final byte[] f33566a = new byte[0];

        /* renamed from: b, reason: collision with root package name */
        private static final Map<String, CardBean> f33567b = new HashMap(5);

        private a() {
        }

        public static CardBean a(@NonNull String str) {
            CardBean cardBean;
            synchronized (f33566a) {
                cardBean = f33567b.get(str);
            }
            return cardBean;
        }

        public static boolean b(@NonNull String str) {
            boolean containsKey;
            synchronized (f33566a) {
                containsKey = f33567b.containsKey(str);
            }
            return containsKey;
        }

        public static void a(@NonNull String str, CardBean cardBean) {
            synchronized (f33566a) {
                f33567b.put(str, cardBean);
            }
        }
    }

    public static boolean check(@NonNull CardBean cardBean) {
        if (TextUtils.isEmpty(cardBean.getType())) {
            ManagerLogUtil.e(f33564b, "illegal scheme");
            return false;
        }
        if (cardBean.getMinPlatformVersion() == 0) {
            ManagerLogUtil.e(f33564b, "illegal minPlatformVer or minSdkVer");
            return false;
        }
        if (TextUtils.isEmpty(cardBean.getCardId())) {
            ManagerLogUtil.e(f33564b, "illegal cardId empty");
            return false;
        }
        if (cardBean.getVer() != 0) {
            return true;
        }
        ManagerLogUtil.e(f33564b, "illegal card version");
        return false;
    }
}
