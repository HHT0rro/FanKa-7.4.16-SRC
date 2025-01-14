package org.greenrobot.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.greenrobot.greendao.converter.PropertyConverter;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public @interface Convert {
    Class columnType();

    Class<? extends PropertyConverter> converter();
}
