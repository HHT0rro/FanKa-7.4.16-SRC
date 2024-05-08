package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.template.view.DynamicTemplateView;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class dq {
    public final Object[] Code = new Object[2];
    private final Context I;
    private static final Class<?>[] Z = {Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor<? extends View>> B = new HashMap<>();
    private static final ClassLoader C = dq.class.getClassLoader();

    public dq(Context context) {
        this.I = context;
    }

    private Context Code() {
        return this.I;
    }

    private View Code(String str, Context context, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        String V = V(str);
        if (TextUtils.isEmpty(V)) {
            throw new InflateException("Tag " + V + " is not defined!");
        }
        try {
            Object[] objArr = this.Code;
            Object obj = objArr[0];
            objArr[0] = context;
            try {
                return -1 == V.indexOf(46) ? Code(V, attributeSet) : Code(V, (String) null, attributeSet);
            } finally {
                this.Code[0] = obj;
            }
        } catch (InflateException e2) {
            throw e2;
        } catch (Exception e10) {
            throw new InflateException("error processing class " + V, e10);
        }
    }

    private View Code(String str, AttributeSet attributeSet) {
        return Code(str, "android.view.", attributeSet);
    }

    private View Code(XmlPullParser xmlPullParser, ViewGroup viewGroup) {
        int next;
        View Code;
        synchronized (this.Code) {
            gl.V("DynamicTemplateCreator", "create");
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            Object[] objArr = this.Code;
            Context context = (Context) objArr[0];
            objArr[0] = this.I;
            do {
                try {
                    try {
                        next = xmlPullParser.next();
                        if (next == 2) {
                            break;
                        }
                    } catch (XmlPullParserException e2) {
                        throw new InflateException(e2.getMessage(), e2);
                    } catch (Throwable th) {
                        throw new InflateException(xmlPullParser.getPositionDescription(), th);
                    }
                } finally {
                    Object[] objArr2 = this.Code;
                    objArr2[0] = context;
                    objArr2[1] = null;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + " no start tag");
            }
            Code = Code(xmlPullParser, viewGroup, this.I, asAttributeSet, viewGroup, xmlPullParser.getName());
        }
        return Code;
    }

    private View Code(XmlPullParser xmlPullParser, ViewGroup viewGroup, Context context, AttributeSet attributeSet, View view, String str) {
        View Code = Code(str, context, attributeSet);
        ViewGroup.LayoutParams generateLayoutParams = viewGroup != null ? viewGroup.generateLayoutParams(attributeSet) : null;
        Code(xmlPullParser, Code, attributeSet);
        if (viewGroup != null) {
            viewGroup.addView(Code, generateLayoutParams);
        }
        return viewGroup == null ? Code : view;
    }

    public static dq Code(Context context) {
        return new dr(context);
    }

    private DynamicTemplateView Code(Reader reader) {
        StringBuilder sb2;
        String message;
        DynamicTemplateView dynamicTemplateView = new DynamicTemplateView(Code());
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(reader);
            Code(newPullParser, dynamicTemplateView);
        } catch (XmlPullParserException e2) {
            gl.I("DynamicTemplateCreator", "create error in create XmlPullParserFactory" + e2.getClass().getSimpleName());
            sb2 = new StringBuilder();
            sb2.append("create error in create XmlPullParserFactory");
            message = e2.getMessage();
            sb2.append(message);
            gl.Code("DynamicTemplateCreator", sb2.toString());
            return dynamicTemplateView;
        } catch (Throwable th) {
            gl.I("DynamicTemplateCreator", "create error" + th.getClass().getSimpleName());
            sb2 = new StringBuilder();
            sb2.append("create error");
            message = th.getMessage();
            sb2.append(message);
            gl.Code("DynamicTemplateCreator", sb2.toString());
            return dynamicTemplateView;
        }
        return dynamicTemplateView;
    }

    private Constructor<? extends View> Code(String str, Class<? extends View> cls) {
        Constructor<? extends View> constructor = cls.getConstructor(Z);
        constructor.setAccessible(true);
        B.put(str, constructor);
        return constructor;
    }

    private final boolean Code(Constructor<? extends View> constructor) {
        ClassLoader classLoader;
        ClassLoader classLoader2 = constructor.getDeclaringClass().getClassLoader();
        if (classLoader2 == C || classLoader2 == (classLoader = this.I.getClassLoader())) {
            return true;
        }
        do {
            classLoader = classLoader.getParent();
            if (classLoader == null) {
                return false;
            }
        } while (classLoader2 != classLoader);
        return true;
    }

    public final View Code(String str, String str2, AttributeSet attributeSet) {
        String str3;
        HashMap<String, Constructor<? extends View>> hashMap = B;
        Constructor<? extends View> constructor = hashMap.get(str);
        Class<? extends View> cls = null;
        if (constructor != null && !Code(constructor)) {
            hashMap.remove(str);
            constructor = null;
        }
        if (constructor == null) {
            try {
                ClassLoader classLoader = this.I.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                cls = classLoader.loadClass(str3).asSubclass(View.class);
                constructor = Code(str, cls);
            } catch (NoSuchMethodException e2) {
                throw new InflateException("error processing " + str, e2);
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new InflateException("error processing " + ((Object) cls), e11);
            }
        }
        Object[] objArr = this.Code;
        Object obj = objArr[0];
        if (objArr[0] == null) {
            objArr[0] = this.I;
        }
        objArr[1] = attributeSet;
        View newInstance = constructor.newInstance(objArr);
        this.Code[0] = obj;
        return newInstance;
    }

    public DynamicTemplateView Code(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Code(new StringReader(str));
        }
        gl.I("DynamicTemplateCreator", "create - input xml layout is empty");
        return new DynamicTemplateView(Code());
    }

    public void Code(XmlPullParser xmlPullParser, View view, Context context, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                View Code = Code(xmlPullParser.getName(), context, attributeSet);
                ViewGroup viewGroup = (ViewGroup) view;
                ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                Code(xmlPullParser, Code, attributeSet);
                viewGroup.addView(Code, generateLayoutParams);
            }
        }
    }

    public final void Code(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) {
        Code(xmlPullParser, view, view.getContext(), attributeSet);
    }

    public String V(String str) {
        return str;
    }
}
