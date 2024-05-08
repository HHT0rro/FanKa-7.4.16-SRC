package kc;

import com.xiaomi.push.h5;
import com.xiaomi.push.p5;
import com.xiaomi.push.q5;
import com.xiaomi.push.u5;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f0 implements p5 {
    public static h5 a(XmlPullParser xmlPullParser) {
        String[] strArr;
        String[] strArr2;
        String str;
        ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
                strArr3[i10] = xmlPullParser.getAttributeName(i10);
                strArr4[i10] = u5.e(xmlPullParser.getAttributeValue(i10));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new h5(name, namespace, strArr, strArr2, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                h5 a10 = a(xmlPullParser);
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
        }
    }

    public void b() {
        q5.a().e("all", "xm:chat", this);
    }

    public h5 c(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }
}
