package com.irisdt.client.login;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class LoginAndRegisterProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cLoginAndRegisterProtos.proto\u0012\u0017com.irisdt.client.login\"\u0093\u0003\n\u0015LoginAndRegisterProto\u0012-\n\u0005event\u0018\u0001 \u0001(\u000e2\u001e.com.irisdt.client.login.Event\u0012\r\n\u0005phone\u0018\u0002 \u0001(\t\u0012\u000f\n\u0007account\u0018\u0003 \u0001(\t\u0012\f\n\u0004name\u0018\u0004 \u0001(\t\u0012\u0010\n\bbirthday\u0018\u0005 \u0001(\t\u0012\f\n\u0004type\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006reason\u0018\u0007 \u0001(\t\u0012\u000f\n\u0007is_true\u0018\b \u0001(\b\u0012\u000f\n\u0007content\u0018\t \u0001(\t\u0012\f\n\u0004mode\u0018\n \u0001(\t\u0012\u0010\n\bposition\u0018\u000b \u0001(\t\u0012\f\n\u0004time\u0018\f \u0001(\u0003\u0012\u0012\n\ntarget_uid\u0018\r \u0001(\t\u0012\u0011\n\ttask_type\u0018\u000e \u0001(\t\u0012\u0010\n\bsub_type\u0018\u000f \u0001(\t\u0012\n\n\u0002id\u0018\u0010 \u0001(\t\u0012\u0014\n\faccount_type\u0018\u0011 \u0001(\t\u00125\n\tenum_type\u0018\u0012 \u0001(\u000e2\".com.irisdt.client.login.Enum_type\u0012\u000b\n\u0003num\u0018\u0013 \u0001(\u0005*\u0092\u0011\n\u0005Event\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0013\n\u000fLOGIN_BTN_CLICK\u0010\u0001\u0012\u001f\n\u001bLOGIN_REGISTER_PRIVACY_SHOW\u0010\u0002\u0012&\n\"LOGIN_REGISTER_PRIVACY_AGREE_CLICK\u0010\u0003\u0012)\n%LOGIN_REGISTER_PRIVACY_DISAGREE_CLICK\u0010\u0004\u0012\u001c\n\u0018LOGIN_REGISTER_PAGE_SHOW\u0010\u0005\u0012\u001c\n\u0018LOGIN_REGISTER_ONE_CLICK\u0010\u0006\u0012\u001e\n\u001aLOGIN_REGISTER_OTHER_CLICK\u0010\u0007\u0012+\n'LOGIN_REGISTER_OTHER_ACCOUNT_NEXT_CLICK\u0010\b\u00123\n/LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_CLICK\u0010\t\u0012<\n8LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_LEAST_SIX_SHOW\u0010\n\u00128\n4LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_ERROR_SHOW\u0010\u000b\u0012)\n%LOGIN_REGISTER_OTHER_PHONE_NEXT_CLICK\u0010\f\u0012,\n(LOGIN_REGISTER_OTHER_PHONE_INVALID_CLICK\u0010\r\u00121\n-LOGIN_REGISTER_OTHER_PHONE_USE_PASSWORD_CLICK\u0010\u000e\u00122\n.LOGIN_REGISTER_OTHER_PHONE_PASSWORD_NEXT_CLICK\u0010\u000f\u0012,\n(LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_SHOW\u0010\u0010\u00122\n.LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_CLICK\u0010\u0011\u0012;\n7LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_NICK_USED_SHOW\u0010\u0012\u00122\n.LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SHOW\u0010\u0013\u0012:\n6LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_UPLOAD_CLICK\u0010\u0014\u0012#\n\u001fLOGIN_REGISTER_SUCCESS_REGISTER\u0010\u0015\u0012$\n LOGIN_REGISTER_NOTICE_OPEN_CLICK\u0010\u0016\u0012%\n!LOGIN_REGISTER_NOTICE_CLOSE_CLICK\u0010\u0017\u00128\n4LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SKIP_CLICK\u0010\u0018\u0012 \n\u001cLOGIN_REGISTER_LOGIN_SUCCESS\u0010\u0019\u0012\u001a\n\u0016GET_VERIFY_CODE_RESULT\u0010\u001a\u0012\u0018\n\u0014ONE_CLICK_LOGIN_FAIL\u0010\u001b\u0012\u0013\n\u000fUPLOAD_PORTRAIT\u0010\u001c\u0012\u0011\n\rPUSH_OPEN_APP\u0010\u001d\u0012\u001d\n\u0019FILL_IN_ACCOUNT_PAGE_SHOW\u0010\u001e\u0012\u0018\n\u0014LOGIN_REGISTER_CLICK\u0010\u001f\u0012\u001d\n\u0019LOGIN_REGISTER_OTHER_SHOW\u0010 \u0012*\n&LOGIN_REGISTER_OTHER_WEIBO_LOGIN_CLICK\u0010!\u0012#\n\u001fLOGIN_REGISTER_OTHER_HELP_CLICK\u0010\"\u0012#\n\u001fLOGIN_REGISTER_OTHER_NEXT_CLICK\u0010#\u0012(\n$LOGIN_REGISTER_OTHER_VERIFY_ACC_SHOW\u0010$\u00120\n,LOGIN_REGISTER_OTHER_VERIFY_ACC_RESEND_CLICK\u0010%\u00124\n0LOGIN_REGISTER_OTHER_VERIFY_ACC_FAIL_RETURN_SHOW\u0010&\u0012*\n&LOGIN_REGISTER_OTHER_USE_PASSWORD_SHOW\u0010'\u0012/\n+LOGIN_REGISTER_OTHER_USE_PASSWORD_NEXT_SHOW\u0010(\u00121\n-LOGIN_REGISTER_OTHER_USE_PASSWORD_FORGET_SHOW\u0010)\u00124\n0LOGIN_REGISTER_OTHER_USE_PASSWORD_TOO_SHORT_SHOW\u0010*\u00120\n,LOGIN_REGISTER_OTHER_USE_PASSWORD_ERROR_SHOW\u0010+\u0012$\n LOGIN_REGISTER_SET_PASSWORD_SHOW\u0010,\u0012*\n&LOGIN_REGISTER_SET_PASSWORD_SAVE_CLICK\u0010-\u0012,\n(LOGIN_REGISTER_SET_PASSWORD_SUCCESS_SHOW\u0010.\u0012\u0017\n\u0013LOGIN_REGISTER_SHOW\u0010/\u00123\n/LOGIN_REGISTER_USER_AND_PRIVACY_AUTH_ICON_CLICK\u00100\u0012+\n'LOGIN_REGISTER_OPERATOR_AUTH_ICON_CLICK\u00101\u0012\u0018\n\u0014SWITCH_ACCOUNT_CLICK\u00102\u0012\u001a\n\u0016REMOVE_ACCOUNT_SUCCESS\u00103\u0012\u000f\n\u000bLOG_IN_FAIL\u00104\u0012\u0012\n\u000eAPP_ACTIVATION\u00105\u0012\u0014\n\u0010REGISTER_SUCCESS\u00106*\u008e\u0001\n\tEnum_type\u0012\u0015\n\u0011UNKNOWN_ENUM_TYPE\u0010\u0000\u0012\u001a\n\u0016ONE_CLICK_REGISTRATION\u0010\u0001\u0012\u0017\n\u0013MOBILE_REGISTRATION\u0010\u0002\u0012\u0010\n\fCHINA_MOBILE\u0010\u0003\u0012\u0010\n\fCHINA_UNICOM\u0010\u0004\u0012\u0011\n\rCHINA_TELECOM\u0010\u0005B\u0015¢\u0002\u0012LOGIN_AND_REGISTERb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_login_LoginAndRegisterProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_login_LoginAndRegisterProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Enum_type implements ProtocolMessageEnum {
        UNKNOWN_ENUM_TYPE(0),
        ONE_CLICK_REGISTRATION(1),
        MOBILE_REGISTRATION(2),
        CHINA_MOBILE(3),
        CHINA_UNICOM(4),
        CHINA_TELECOM(5),
        UNRECOGNIZED(-1);

        public static final int CHINA_MOBILE_VALUE = 3;
        public static final int CHINA_TELECOM_VALUE = 5;
        public static final int CHINA_UNICOM_VALUE = 4;
        public static final int MOBILE_REGISTRATION_VALUE = 2;
        public static final int ONE_CLICK_REGISTRATION_VALUE = 1;
        public static final int UNKNOWN_ENUM_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Enum_type> internalValueMap = new Internal.EnumLiteMap<Enum_type>() { // from class: com.irisdt.client.login.LoginAndRegisterProtos.Enum_type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Enum_type findValueByNumber(int i10) {
                return Enum_type.forNumber(i10);
            }
        };
        private static final Enum_type[] VALUES = values();

        Enum_type(int i10) {
            this.value = i10;
        }

        public static Enum_type forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_ENUM_TYPE;
            }
            if (i10 == 1) {
                return ONE_CLICK_REGISTRATION;
            }
            if (i10 == 2) {
                return MOBILE_REGISTRATION;
            }
            if (i10 == 3) {
                return CHINA_MOBILE;
            }
            if (i10 == 4) {
                return CHINA_UNICOM;
            }
            if (i10 != 5) {
                return null;
            }
            return CHINA_TELECOM;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Enum_type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Enum_type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Enum_type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN(0),
        LOGIN_BTN_CLICK(1),
        LOGIN_REGISTER_PRIVACY_SHOW(2),
        LOGIN_REGISTER_PRIVACY_AGREE_CLICK(3),
        LOGIN_REGISTER_PRIVACY_DISAGREE_CLICK(4),
        LOGIN_REGISTER_PAGE_SHOW(5),
        LOGIN_REGISTER_ONE_CLICK(6),
        LOGIN_REGISTER_OTHER_CLICK(7),
        LOGIN_REGISTER_OTHER_ACCOUNT_NEXT_CLICK(8),
        LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_CLICK(9),
        LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_LEAST_SIX_SHOW(10),
        LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_ERROR_SHOW(11),
        LOGIN_REGISTER_OTHER_PHONE_NEXT_CLICK(12),
        LOGIN_REGISTER_OTHER_PHONE_INVALID_CLICK(13),
        LOGIN_REGISTER_OTHER_PHONE_USE_PASSWORD_CLICK(14),
        LOGIN_REGISTER_OTHER_PHONE_PASSWORD_NEXT_CLICK(15),
        LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_SHOW(16),
        LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_CLICK(17),
        LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_NICK_USED_SHOW(18),
        LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SHOW(19),
        LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_UPLOAD_CLICK(20),
        LOGIN_REGISTER_SUCCESS_REGISTER(21),
        LOGIN_REGISTER_NOTICE_OPEN_CLICK(22),
        LOGIN_REGISTER_NOTICE_CLOSE_CLICK(23),
        LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SKIP_CLICK(24),
        LOGIN_REGISTER_LOGIN_SUCCESS(25),
        GET_VERIFY_CODE_RESULT(26),
        ONE_CLICK_LOGIN_FAIL(27),
        UPLOAD_PORTRAIT(28),
        PUSH_OPEN_APP(29),
        FILL_IN_ACCOUNT_PAGE_SHOW(30),
        LOGIN_REGISTER_CLICK(31),
        LOGIN_REGISTER_OTHER_SHOW(32),
        LOGIN_REGISTER_OTHER_WEIBO_LOGIN_CLICK(33),
        LOGIN_REGISTER_OTHER_HELP_CLICK(34),
        LOGIN_REGISTER_OTHER_NEXT_CLICK(35),
        LOGIN_REGISTER_OTHER_VERIFY_ACC_SHOW(36),
        LOGIN_REGISTER_OTHER_VERIFY_ACC_RESEND_CLICK(37),
        LOGIN_REGISTER_OTHER_VERIFY_ACC_FAIL_RETURN_SHOW(38),
        LOGIN_REGISTER_OTHER_USE_PASSWORD_SHOW(39),
        LOGIN_REGISTER_OTHER_USE_PASSWORD_NEXT_SHOW(40),
        LOGIN_REGISTER_OTHER_USE_PASSWORD_FORGET_SHOW(41),
        LOGIN_REGISTER_OTHER_USE_PASSWORD_TOO_SHORT_SHOW(42),
        LOGIN_REGISTER_OTHER_USE_PASSWORD_ERROR_SHOW(43),
        LOGIN_REGISTER_SET_PASSWORD_SHOW(44),
        LOGIN_REGISTER_SET_PASSWORD_SAVE_CLICK(45),
        LOGIN_REGISTER_SET_PASSWORD_SUCCESS_SHOW(46),
        LOGIN_REGISTER_SHOW(47),
        LOGIN_REGISTER_USER_AND_PRIVACY_AUTH_ICON_CLICK(48),
        LOGIN_REGISTER_OPERATOR_AUTH_ICON_CLICK(49),
        SWITCH_ACCOUNT_CLICK(50),
        REMOVE_ACCOUNT_SUCCESS(51),
        LOG_IN_FAIL(52),
        APP_ACTIVATION(53),
        REGISTER_SUCCESS(54),
        UNRECOGNIZED(-1);

        public static final int APP_ACTIVATION_VALUE = 53;
        public static final int FILL_IN_ACCOUNT_PAGE_SHOW_VALUE = 30;
        public static final int GET_VERIFY_CODE_RESULT_VALUE = 26;
        public static final int LOGIN_BTN_CLICK_VALUE = 1;
        public static final int LOGIN_REGISTER_CLICK_VALUE = 31;
        public static final int LOGIN_REGISTER_LOGIN_SUCCESS_VALUE = 25;
        public static final int LOGIN_REGISTER_NOTICE_CLOSE_CLICK_VALUE = 23;
        public static final int LOGIN_REGISTER_NOTICE_OPEN_CLICK_VALUE = 22;
        public static final int LOGIN_REGISTER_ONE_CLICK_VALUE = 6;
        public static final int LOGIN_REGISTER_OPERATOR_AUTH_ICON_CLICK_VALUE = 49;
        public static final int LOGIN_REGISTER_OTHER_ACCOUNT_NEXT_CLICK_VALUE = 8;
        public static final int LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_CLICK_VALUE = 9;
        public static final int LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_ERROR_SHOW_VALUE = 11;
        public static final int LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_LEAST_SIX_SHOW_VALUE = 10;
        public static final int LOGIN_REGISTER_OTHER_CLICK_VALUE = 7;
        public static final int LOGIN_REGISTER_OTHER_HELP_CLICK_VALUE = 34;
        public static final int LOGIN_REGISTER_OTHER_NEXT_CLICK_VALUE = 35;
        public static final int LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_CLICK_VALUE = 17;
        public static final int LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_NICK_USED_SHOW_VALUE = 18;
        public static final int LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SHOW_VALUE = 19;
        public static final int LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SKIP_CLICK_VALUE = 24;
        public static final int LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_UPLOAD_CLICK_VALUE = 20;
        public static final int LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_SHOW_VALUE = 16;
        public static final int LOGIN_REGISTER_OTHER_PHONE_INVALID_CLICK_VALUE = 13;
        public static final int LOGIN_REGISTER_OTHER_PHONE_NEXT_CLICK_VALUE = 12;
        public static final int LOGIN_REGISTER_OTHER_PHONE_PASSWORD_NEXT_CLICK_VALUE = 15;
        public static final int LOGIN_REGISTER_OTHER_PHONE_USE_PASSWORD_CLICK_VALUE = 14;
        public static final int LOGIN_REGISTER_OTHER_SHOW_VALUE = 32;
        public static final int LOGIN_REGISTER_OTHER_USE_PASSWORD_ERROR_SHOW_VALUE = 43;
        public static final int LOGIN_REGISTER_OTHER_USE_PASSWORD_FORGET_SHOW_VALUE = 41;
        public static final int LOGIN_REGISTER_OTHER_USE_PASSWORD_NEXT_SHOW_VALUE = 40;
        public static final int LOGIN_REGISTER_OTHER_USE_PASSWORD_SHOW_VALUE = 39;
        public static final int LOGIN_REGISTER_OTHER_USE_PASSWORD_TOO_SHORT_SHOW_VALUE = 42;
        public static final int LOGIN_REGISTER_OTHER_VERIFY_ACC_FAIL_RETURN_SHOW_VALUE = 38;
        public static final int LOGIN_REGISTER_OTHER_VERIFY_ACC_RESEND_CLICK_VALUE = 37;
        public static final int LOGIN_REGISTER_OTHER_VERIFY_ACC_SHOW_VALUE = 36;
        public static final int LOGIN_REGISTER_OTHER_WEIBO_LOGIN_CLICK_VALUE = 33;
        public static final int LOGIN_REGISTER_PAGE_SHOW_VALUE = 5;
        public static final int LOGIN_REGISTER_PRIVACY_AGREE_CLICK_VALUE = 3;
        public static final int LOGIN_REGISTER_PRIVACY_DISAGREE_CLICK_VALUE = 4;
        public static final int LOGIN_REGISTER_PRIVACY_SHOW_VALUE = 2;
        public static final int LOGIN_REGISTER_SET_PASSWORD_SAVE_CLICK_VALUE = 45;
        public static final int LOGIN_REGISTER_SET_PASSWORD_SHOW_VALUE = 44;
        public static final int LOGIN_REGISTER_SET_PASSWORD_SUCCESS_SHOW_VALUE = 46;
        public static final int LOGIN_REGISTER_SHOW_VALUE = 47;
        public static final int LOGIN_REGISTER_SUCCESS_REGISTER_VALUE = 21;
        public static final int LOGIN_REGISTER_USER_AND_PRIVACY_AUTH_ICON_CLICK_VALUE = 48;
        public static final int LOG_IN_FAIL_VALUE = 52;
        public static final int ONE_CLICK_LOGIN_FAIL_VALUE = 27;
        public static final int PUSH_OPEN_APP_VALUE = 29;
        public static final int REGISTER_SUCCESS_VALUE = 54;
        public static final int REMOVE_ACCOUNT_SUCCESS_VALUE = 51;
        public static final int SWITCH_ACCOUNT_CLICK_VALUE = 50;
        public static final int UNKNOWN_VALUE = 0;
        public static final int UPLOAD_PORTRAIT_VALUE = 28;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.irisdt.client.login.LoginAndRegisterProtos.Event.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i10) {
                return Event.forNumber(i10);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i10) {
            this.value = i10;
        }

        public static Event forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return LOGIN_BTN_CLICK;
                case 2:
                    return LOGIN_REGISTER_PRIVACY_SHOW;
                case 3:
                    return LOGIN_REGISTER_PRIVACY_AGREE_CLICK;
                case 4:
                    return LOGIN_REGISTER_PRIVACY_DISAGREE_CLICK;
                case 5:
                    return LOGIN_REGISTER_PAGE_SHOW;
                case 6:
                    return LOGIN_REGISTER_ONE_CLICK;
                case 7:
                    return LOGIN_REGISTER_OTHER_CLICK;
                case 8:
                    return LOGIN_REGISTER_OTHER_ACCOUNT_NEXT_CLICK;
                case 9:
                    return LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_CLICK;
                case 10:
                    return LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_LEAST_SIX_SHOW;
                case 11:
                    return LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_ERROR_SHOW;
                case 12:
                    return LOGIN_REGISTER_OTHER_PHONE_NEXT_CLICK;
                case 13:
                    return LOGIN_REGISTER_OTHER_PHONE_INVALID_CLICK;
                case 14:
                    return LOGIN_REGISTER_OTHER_PHONE_USE_PASSWORD_CLICK;
                case 15:
                    return LOGIN_REGISTER_OTHER_PHONE_PASSWORD_NEXT_CLICK;
                case 16:
                    return LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_SHOW;
                case 17:
                    return LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_CLICK;
                case 18:
                    return LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_NEXT_NICK_USED_SHOW;
                case 19:
                    return LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SHOW;
                case 20:
                    return LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_UPLOAD_CLICK;
                case 21:
                    return LOGIN_REGISTER_SUCCESS_REGISTER;
                case 22:
                    return LOGIN_REGISTER_NOTICE_OPEN_CLICK;
                case 23:
                    return LOGIN_REGISTER_NOTICE_CLOSE_CLICK;
                case 24:
                    return LOGIN_REGISTER_OTHER_PHONE_ARCHIVES_PHOTO_SKIP_CLICK;
                case 25:
                    return LOGIN_REGISTER_LOGIN_SUCCESS;
                case 26:
                    return GET_VERIFY_CODE_RESULT;
                case 27:
                    return ONE_CLICK_LOGIN_FAIL;
                case 28:
                    return UPLOAD_PORTRAIT;
                case 29:
                    return PUSH_OPEN_APP;
                case 30:
                    return FILL_IN_ACCOUNT_PAGE_SHOW;
                case 31:
                    return LOGIN_REGISTER_CLICK;
                case 32:
                    return LOGIN_REGISTER_OTHER_SHOW;
                case 33:
                    return LOGIN_REGISTER_OTHER_WEIBO_LOGIN_CLICK;
                case 34:
                    return LOGIN_REGISTER_OTHER_HELP_CLICK;
                case 35:
                    return LOGIN_REGISTER_OTHER_NEXT_CLICK;
                case 36:
                    return LOGIN_REGISTER_OTHER_VERIFY_ACC_SHOW;
                case 37:
                    return LOGIN_REGISTER_OTHER_VERIFY_ACC_RESEND_CLICK;
                case 38:
                    return LOGIN_REGISTER_OTHER_VERIFY_ACC_FAIL_RETURN_SHOW;
                case 39:
                    return LOGIN_REGISTER_OTHER_USE_PASSWORD_SHOW;
                case 40:
                    return LOGIN_REGISTER_OTHER_USE_PASSWORD_NEXT_SHOW;
                case 41:
                    return LOGIN_REGISTER_OTHER_USE_PASSWORD_FORGET_SHOW;
                case 42:
                    return LOGIN_REGISTER_OTHER_USE_PASSWORD_TOO_SHORT_SHOW;
                case 43:
                    return LOGIN_REGISTER_OTHER_USE_PASSWORD_ERROR_SHOW;
                case 44:
                    return LOGIN_REGISTER_SET_PASSWORD_SHOW;
                case 45:
                    return LOGIN_REGISTER_SET_PASSWORD_SAVE_CLICK;
                case 46:
                    return LOGIN_REGISTER_SET_PASSWORD_SUCCESS_SHOW;
                case 47:
                    return LOGIN_REGISTER_SHOW;
                case 48:
                    return LOGIN_REGISTER_USER_AND_PRIVACY_AUTH_ICON_CLICK;
                case 49:
                    return LOGIN_REGISTER_OPERATOR_AUTH_ICON_CLICK;
                case 50:
                    return SWITCH_ACCOUNT_CLICK;
                case 51:
                    return REMOVE_ACCOUNT_SUCCESS;
                case 52:
                    return LOG_IN_FAIL;
                case 53:
                    return APP_ACTIVATION;
                case 54:
                    return REGISTER_SUCCESS;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Event valueOf(int i10) {
            return forNumber(i10);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class LoginAndRegisterProto extends GeneratedMessageV3 implements LoginAndRegisterProtoOrBuilder {
        public static final int ACCOUNT_FIELD_NUMBER = 3;
        public static final int ACCOUNT_TYPE_FIELD_NUMBER = 17;
        public static final int BIRTHDAY_FIELD_NUMBER = 5;
        public static final int CONTENT_FIELD_NUMBER = 9;
        public static final int ENUM_TYPE_FIELD_NUMBER = 18;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int ID_FIELD_NUMBER = 16;
        public static final int IS_TRUE_FIELD_NUMBER = 8;
        public static final int MODE_FIELD_NUMBER = 10;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int NUM_FIELD_NUMBER = 19;
        public static final int PHONE_FIELD_NUMBER = 2;
        public static final int POSITION_FIELD_NUMBER = 11;
        public static final int REASON_FIELD_NUMBER = 7;
        public static final int SUB_TYPE_FIELD_NUMBER = 15;
        public static final int TARGET_UID_FIELD_NUMBER = 13;
        public static final int TASK_TYPE_FIELD_NUMBER = 14;
        public static final int TIME_FIELD_NUMBER = 12;
        public static final int TYPE_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private volatile Object accountType_;
        private volatile Object account_;
        private volatile Object birthday_;
        private volatile Object content_;
        private int enumType_;
        private int event_;
        private volatile Object id_;
        private boolean isTrue_;
        private byte memoizedIsInitialized;
        private volatile Object mode_;
        private volatile Object name_;
        private int num_;
        private volatile Object phone_;
        private volatile Object position_;
        private volatile Object reason_;
        private volatile Object subType_;
        private volatile Object targetUid_;
        private volatile Object taskType_;
        private long time_;
        private volatile Object type_;
        private static final LoginAndRegisterProto DEFAULT_INSTANCE = new LoginAndRegisterProto();
        private static final Parser<LoginAndRegisterProto> PARSER = new AbstractParser<LoginAndRegisterProto>() { // from class: com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProto.1
            @Override // com.google.protobuf.Parser
            public LoginAndRegisterProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LoginAndRegisterProto(codedInputStream, extensionRegistryLite);
            }
        };

        private LoginAndRegisterProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LoginAndRegisterProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LoginAndRegisterProtos.internal_static_com_irisdt_client_login_LoginAndRegisterProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static LoginAndRegisterProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LoginAndRegisterProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<LoginAndRegisterProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LoginAndRegisterProto)) {
                return super.equals(obj);
            }
            LoginAndRegisterProto loginAndRegisterProto = (LoginAndRegisterProto) obj;
            return this.event_ == loginAndRegisterProto.event_ && getPhone().equals(loginAndRegisterProto.getPhone()) && getAccount().equals(loginAndRegisterProto.getAccount()) && getName().equals(loginAndRegisterProto.getName()) && getBirthday().equals(loginAndRegisterProto.getBirthday()) && getType().equals(loginAndRegisterProto.getType()) && getReason().equals(loginAndRegisterProto.getReason()) && getIsTrue() == loginAndRegisterProto.getIsTrue() && getContent().equals(loginAndRegisterProto.getContent()) && getMode().equals(loginAndRegisterProto.getMode()) && getPosition().equals(loginAndRegisterProto.getPosition()) && getTime() == loginAndRegisterProto.getTime() && getTargetUid().equals(loginAndRegisterProto.getTargetUid()) && getTaskType().equals(loginAndRegisterProto.getTaskType()) && getSubType().equals(loginAndRegisterProto.getSubType()) && getId().equals(loginAndRegisterProto.getId()) && getAccountType().equals(loginAndRegisterProto.getAccountType()) && this.enumType_ == loginAndRegisterProto.enumType_ && getNum() == loginAndRegisterProto.getNum() && this.unknownFields.equals(loginAndRegisterProto.unknownFields);
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getAccount() {
            Object obj = this.account_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.account_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getAccountBytes() {
            Object obj = this.account_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.account_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getAccountType() {
            Object obj = this.accountType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.accountType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getAccountTypeBytes() {
            Object obj = this.accountType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.accountType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getBirthday() {
            Object obj = this.birthday_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.birthday_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getBirthdayBytes() {
            Object obj = this.birthday_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.birthday_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public Enum_type getEnumType() {
            Enum_type valueOf = Enum_type.valueOf(this.enumType_);
            return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getEnumTypeValue() {
            return this.enumType_;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            return valueOf == null ? Event.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getMode() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getModeBytes() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LoginAndRegisterProto> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getPhone() {
            Object obj = this.phone_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.phone_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getPhoneBytes() {
            Object obj = this.phone_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.phone_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getPosition() {
            Object obj = this.position_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.position_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeEnumSize = this.event_ != Event.UNKNOWN.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.event_) : 0;
            if (!getPhoneBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.phone_);
            }
            if (!getAccountBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.account_);
            }
            if (!getNameBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(4, this.name_);
            }
            if (!getBirthdayBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(5, this.birthday_);
            }
            if (!getTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(6, this.type_);
            }
            if (!getReasonBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(7, this.reason_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                computeEnumSize += CodedOutputStream.computeBoolSize(8, z10);
            }
            if (!getContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(9, this.content_);
            }
            if (!getModeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(10, this.mode_);
            }
            if (!getPositionBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(11, this.position_);
            }
            long j10 = this.time_;
            if (j10 != 0) {
                computeEnumSize += CodedOutputStream.computeInt64Size(12, j10);
            }
            if (!getTargetUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(13, this.targetUid_);
            }
            if (!getTaskTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(14, this.taskType_);
            }
            if (!getSubTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(15, this.subType_);
            }
            if (!getIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(16, this.id_);
            }
            if (!getAccountTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(17, this.accountType_);
            }
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(18, this.enumType_);
            }
            int i11 = this.num_;
            if (i11 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(19, i11);
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getSubType() {
            Object obj = this.subType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getSubTypeBytes() {
            Object obj = this.subType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.subType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getTaskType() {
            Object obj = this.taskType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.taskType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getTaskTypeBytes() {
            Object obj = this.taskType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.taskType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getPhone().hashCode()) * 37) + 3) * 53) + getAccount().hashCode()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 5) * 53) + getBirthday().hashCode()) * 37) + 6) * 53) + getType().hashCode()) * 37) + 7) * 53) + getReason().hashCode()) * 37) + 8) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 9) * 53) + getContent().hashCode()) * 37) + 10) * 53) + getMode().hashCode()) * 37) + 11) * 53) + getPosition().hashCode()) * 37) + 12) * 53) + Internal.hashLong(getTime())) * 37) + 13) * 53) + getTargetUid().hashCode()) * 37) + 14) * 53) + getTaskType().hashCode()) * 37) + 15) * 53) + getSubType().hashCode()) * 37) + 16) * 53) + getId().hashCode()) * 37) + 17) * 53) + getAccountType().hashCode()) * 37) + 18) * 53) + this.enumType_) * 37) + 19) * 53) + getNum()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LoginAndRegisterProtos.internal_static_com_irisdt_client_login_LoginAndRegisterProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginAndRegisterProto.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new LoginAndRegisterProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getPhoneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.phone_);
            }
            if (!getAccountBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.account_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.name_);
            }
            if (!getBirthdayBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.birthday_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.type_);
            }
            if (!getReasonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.reason_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                codedOutputStream.writeBool(8, z10);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.content_);
            }
            if (!getModeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.mode_);
            }
            if (!getPositionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.position_);
            }
            long j10 = this.time_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(12, j10);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.targetUid_);
            }
            if (!getTaskTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.taskType_);
            }
            if (!getSubTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.subType_);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.id_);
            }
            if (!getAccountTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.accountType_);
            }
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                codedOutputStream.writeEnum(18, this.enumType_);
            }
            int i10 = this.num_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(19, i10);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoginAndRegisterProtoOrBuilder {
            private Object accountType_;
            private Object account_;
            private Object birthday_;
            private Object content_;
            private int enumType_;
            private int event_;
            private Object id_;
            private boolean isTrue_;
            private Object mode_;
            private Object name_;
            private int num_;
            private Object phone_;
            private Object position_;
            private Object reason_;
            private Object subType_;
            private Object targetUid_;
            private Object taskType_;
            private long time_;
            private Object type_;

            private Builder() {
                this.event_ = 0;
                this.phone_ = "";
                this.account_ = "";
                this.name_ = "";
                this.birthday_ = "";
                this.type_ = "";
                this.reason_ = "";
                this.content_ = "";
                this.mode_ = "";
                this.position_ = "";
                this.targetUid_ = "";
                this.taskType_ = "";
                this.subType_ = "";
                this.id_ = "";
                this.accountType_ = "";
                this.enumType_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LoginAndRegisterProtos.internal_static_com_irisdt_client_login_LoginAndRegisterProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAccount() {
                this.account_ = LoginAndRegisterProto.getDefaultInstance().getAccount();
                onChanged();
                return this;
            }

            public Builder clearAccountType() {
                this.accountType_ = LoginAndRegisterProto.getDefaultInstance().getAccountType();
                onChanged();
                return this;
            }

            public Builder clearBirthday() {
                this.birthday_ = LoginAndRegisterProto.getDefaultInstance().getBirthday();
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = LoginAndRegisterProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearEnumType() {
                this.enumType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = LoginAndRegisterProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearMode() {
                this.mode_ = LoginAndRegisterProto.getDefaultInstance().getMode();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = LoginAndRegisterProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPhone() {
                this.phone_ = LoginAndRegisterProto.getDefaultInstance().getPhone();
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = LoginAndRegisterProto.getDefaultInstance().getPosition();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = LoginAndRegisterProto.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearSubType() {
                this.subType_ = LoginAndRegisterProto.getDefaultInstance().getSubType();
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = LoginAndRegisterProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearTaskType() {
                this.taskType_ = LoginAndRegisterProto.getDefaultInstance().getTaskType();
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = LoginAndRegisterProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getAccount() {
                Object obj = this.account_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.account_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getAccountBytes() {
                Object obj = this.account_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.account_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getAccountType() {
                Object obj = this.accountType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.accountType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getAccountTypeBytes() {
                Object obj = this.accountType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.accountType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getBirthday() {
                Object obj = this.birthday_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.birthday_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getBirthdayBytes() {
                Object obj = this.birthday_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.birthday_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.content_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LoginAndRegisterProtos.internal_static_com_irisdt_client_login_LoginAndRegisterProto_descriptor;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public Enum_type getEnumType() {
                Enum_type valueOf = Enum_type.valueOf(this.enumType_);
                return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getEnumTypeValue() {
                return this.enumType_;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                return valueOf == null ? Event.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getMode() {
                Object obj = this.mode_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.mode_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getModeBytes() {
                Object obj = this.mode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getPhone() {
                Object obj = this.phone_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.phone_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getPhoneBytes() {
                Object obj = this.phone_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.phone_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getPosition() {
                Object obj = this.position_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.position_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getPositionBytes() {
                Object obj = this.position_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.position_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reason_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getSubType() {
                Object obj = this.subType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.subType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getSubTypeBytes() {
                Object obj = this.subType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.subType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.targetUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getTaskType() {
                Object obj = this.taskType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.taskType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getTaskTypeBytes() {
                Object obj = this.taskType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.taskType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public long getTime() {
                return this.time_;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.type_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LoginAndRegisterProtos.internal_static_com_irisdt_client_login_LoginAndRegisterProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginAndRegisterProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAccount(String str) {
                Objects.requireNonNull(str);
                this.account_ = str;
                onChanged();
                return this;
            }

            public Builder setAccountBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.account_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAccountType(String str) {
                Objects.requireNonNull(str);
                this.accountType_ = str;
                onChanged();
                return this;
            }

            public Builder setAccountTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.accountType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setBirthday(String str) {
                Objects.requireNonNull(str);
                this.birthday_ = str;
                onChanged();
                return this;
            }

            public Builder setBirthdayBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.birthday_ = byteString;
                onChanged();
                return this;
            }

            public Builder setContent(String str) {
                Objects.requireNonNull(str);
                this.content_ = str;
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }

            public Builder setEnumType(Enum_type enum_type) {
                Objects.requireNonNull(enum_type);
                this.enumType_ = enum_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setEnumTypeValue(int i10) {
                this.enumType_ = i10;
                onChanged();
                return this;
            }

            public Builder setEvent(Event event) {
                Objects.requireNonNull(event);
                this.event_ = event.getNumber();
                onChanged();
                return this;
            }

            public Builder setEventValue(int i10) {
                this.event_ = i10;
                onChanged();
                return this;
            }

            public Builder setId(String str) {
                Objects.requireNonNull(str);
                this.id_ = str;
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.id_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z10) {
                this.isTrue_ = z10;
                onChanged();
                return this;
            }

            public Builder setMode(String str) {
                Objects.requireNonNull(str);
                this.mode_ = str;
                onChanged();
                return this;
            }

            public Builder setModeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mode_ = byteString;
                onChanged();
                return this;
            }

            public Builder setName(String str) {
                Objects.requireNonNull(str);
                this.name_ = str;
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNum(int i10) {
                this.num_ = i10;
                onChanged();
                return this;
            }

            public Builder setPhone(String str) {
                Objects.requireNonNull(str);
                this.phone_ = str;
                onChanged();
                return this;
            }

            public Builder setPhoneBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.phone_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPosition(String str) {
                Objects.requireNonNull(str);
                this.position_ = str;
                onChanged();
                return this;
            }

            public Builder setPositionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.position_ = byteString;
                onChanged();
                return this;
            }

            public Builder setReason(String str) {
                Objects.requireNonNull(str);
                this.reason_ = str;
                onChanged();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.reason_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSubType(String str) {
                Objects.requireNonNull(str);
                this.subType_ = str;
                onChanged();
                return this;
            }

            public Builder setSubTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.subType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTargetUid(String str) {
                Objects.requireNonNull(str);
                this.targetUid_ = str;
                onChanged();
                return this;
            }

            public Builder setTargetUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.targetUid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTaskType(String str) {
                Objects.requireNonNull(str);
                this.taskType_ = str;
                onChanged();
                return this;
            }

            public Builder setTaskTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.taskType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTime(long j10) {
                this.time_ = j10;
                onChanged();
                return this;
            }

            public Builder setType(String str) {
                Objects.requireNonNull(str);
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LoginAndRegisterProto build() {
                LoginAndRegisterProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LoginAndRegisterProto buildPartial() {
                LoginAndRegisterProto loginAndRegisterProto = new LoginAndRegisterProto(this);
                loginAndRegisterProto.event_ = this.event_;
                loginAndRegisterProto.phone_ = this.phone_;
                loginAndRegisterProto.account_ = this.account_;
                loginAndRegisterProto.name_ = this.name_;
                loginAndRegisterProto.birthday_ = this.birthday_;
                loginAndRegisterProto.type_ = this.type_;
                loginAndRegisterProto.reason_ = this.reason_;
                loginAndRegisterProto.isTrue_ = this.isTrue_;
                loginAndRegisterProto.content_ = this.content_;
                loginAndRegisterProto.mode_ = this.mode_;
                loginAndRegisterProto.position_ = this.position_;
                loginAndRegisterProto.time_ = this.time_;
                loginAndRegisterProto.targetUid_ = this.targetUid_;
                loginAndRegisterProto.taskType_ = this.taskType_;
                loginAndRegisterProto.subType_ = this.subType_;
                loginAndRegisterProto.id_ = this.id_;
                loginAndRegisterProto.accountType_ = this.accountType_;
                loginAndRegisterProto.enumType_ = this.enumType_;
                loginAndRegisterProto.num_ = this.num_;
                onBuilt();
                return loginAndRegisterProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LoginAndRegisterProto getDefaultInstanceForType() {
                return LoginAndRegisterProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.phone_ = "";
                this.account_ = "";
                this.name_ = "";
                this.birthday_ = "";
                this.type_ = "";
                this.reason_ = "";
                this.isTrue_ = false;
                this.content_ = "";
                this.mode_ = "";
                this.position_ = "";
                this.time_ = 0L;
                this.targetUid_ = "";
                this.taskType_ = "";
                this.subType_ = "";
                this.id_ = "";
                this.accountType_ = "";
                this.enumType_ = 0;
                this.num_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LoginAndRegisterProto) {
                    return mergeFrom((LoginAndRegisterProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LoginAndRegisterProto loginAndRegisterProto) {
                if (loginAndRegisterProto == LoginAndRegisterProto.getDefaultInstance()) {
                    return this;
                }
                if (loginAndRegisterProto.event_ != 0) {
                    setEventValue(loginAndRegisterProto.getEventValue());
                }
                if (!loginAndRegisterProto.getPhone().isEmpty()) {
                    this.phone_ = loginAndRegisterProto.phone_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getAccount().isEmpty()) {
                    this.account_ = loginAndRegisterProto.account_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getName().isEmpty()) {
                    this.name_ = loginAndRegisterProto.name_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getBirthday().isEmpty()) {
                    this.birthday_ = loginAndRegisterProto.birthday_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getType().isEmpty()) {
                    this.type_ = loginAndRegisterProto.type_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getReason().isEmpty()) {
                    this.reason_ = loginAndRegisterProto.reason_;
                    onChanged();
                }
                if (loginAndRegisterProto.getIsTrue()) {
                    setIsTrue(loginAndRegisterProto.getIsTrue());
                }
                if (!loginAndRegisterProto.getContent().isEmpty()) {
                    this.content_ = loginAndRegisterProto.content_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getMode().isEmpty()) {
                    this.mode_ = loginAndRegisterProto.mode_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getPosition().isEmpty()) {
                    this.position_ = loginAndRegisterProto.position_;
                    onChanged();
                }
                if (loginAndRegisterProto.getTime() != 0) {
                    setTime(loginAndRegisterProto.getTime());
                }
                if (!loginAndRegisterProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = loginAndRegisterProto.targetUid_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getTaskType().isEmpty()) {
                    this.taskType_ = loginAndRegisterProto.taskType_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getSubType().isEmpty()) {
                    this.subType_ = loginAndRegisterProto.subType_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getId().isEmpty()) {
                    this.id_ = loginAndRegisterProto.id_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getAccountType().isEmpty()) {
                    this.accountType_ = loginAndRegisterProto.accountType_;
                    onChanged();
                }
                if (loginAndRegisterProto.enumType_ != 0) {
                    setEnumTypeValue(loginAndRegisterProto.getEnumTypeValue());
                }
                if (loginAndRegisterProto.getNum() != 0) {
                    setNum(loginAndRegisterProto.getNum());
                }
                mergeUnknownFields(loginAndRegisterProto.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.phone_ = "";
                this.account_ = "";
                this.name_ = "";
                this.birthday_ = "";
                this.type_ = "";
                this.reason_ = "";
                this.content_ = "";
                this.mode_ = "";
                this.position_ = "";
                this.targetUid_ = "";
                this.taskType_ = "";
                this.subType_ = "";
                this.id_ = "";
                this.accountType_ = "";
                this.enumType_ = 0;
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProto.J()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.login.LoginAndRegisterProtos$LoginAndRegisterProto r3 = (com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.irisdt.client.login.LoginAndRegisterProtos$LoginAndRegisterProto r4 = (com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProto) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.login.LoginAndRegisterProtos.LoginAndRegisterProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.login.LoginAndRegisterProtos$LoginAndRegisterProto$Builder");
            }
        }

        public static Builder newBuilder(LoginAndRegisterProto loginAndRegisterProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(loginAndRegisterProto);
        }

        public static LoginAndRegisterProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private LoginAndRegisterProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.phone_ = "";
            this.account_ = "";
            this.name_ = "";
            this.birthday_ = "";
            this.type_ = "";
            this.reason_ = "";
            this.content_ = "";
            this.mode_ = "";
            this.position_ = "";
            this.targetUid_ = "";
            this.taskType_ = "";
            this.subType_ = "";
            this.id_ = "";
            this.accountType_ = "";
            this.enumType_ = 0;
        }

        public static LoginAndRegisterProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LoginAndRegisterProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static LoginAndRegisterProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static LoginAndRegisterProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static LoginAndRegisterProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(InputStream inputStream) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LoginAndRegisterProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LoginAndRegisterProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private LoginAndRegisterProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.event_ = codedInputStream.readEnum();
                            case 18:
                                this.phone_ = codedInputStream.readStringRequireUtf8();
                            case 26:
                                this.account_ = codedInputStream.readStringRequireUtf8();
                            case 34:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 42:
                                this.birthday_ = codedInputStream.readStringRequireUtf8();
                            case 50:
                                this.type_ = codedInputStream.readStringRequireUtf8();
                            case 58:
                                this.reason_ = codedInputStream.readStringRequireUtf8();
                            case 64:
                                this.isTrue_ = codedInputStream.readBool();
                            case 74:
                                this.content_ = codedInputStream.readStringRequireUtf8();
                            case 82:
                                this.mode_ = codedInputStream.readStringRequireUtf8();
                            case 90:
                                this.position_ = codedInputStream.readStringRequireUtf8();
                            case 96:
                                this.time_ = codedInputStream.readInt64();
                            case 106:
                                this.targetUid_ = codedInputStream.readStringRequireUtf8();
                            case 114:
                                this.taskType_ = codedInputStream.readStringRequireUtf8();
                            case 122:
                                this.subType_ = codedInputStream.readStringRequireUtf8();
                            case 130:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            case 138:
                                this.accountType_ = codedInputStream.readStringRequireUtf8();
                            case 144:
                                this.enumType_ = codedInputStream.readEnum();
                            case 152:
                                this.num_ = codedInputStream.readInt32();
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    z10 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface LoginAndRegisterProtoOrBuilder extends MessageOrBuilder {
        String getAccount();

        ByteString getAccountBytes();

        String getAccountType();

        ByteString getAccountTypeBytes();

        String getBirthday();

        ByteString getBirthdayBytes();

        String getContent();

        ByteString getContentBytes();

        Enum_type getEnumType();

        int getEnumTypeValue();

        Event getEvent();

        int getEventValue();

        String getId();

        ByteString getIdBytes();

        boolean getIsTrue();

        String getMode();

        ByteString getModeBytes();

        String getName();

        ByteString getNameBytes();

        int getNum();

        String getPhone();

        ByteString getPhoneBytes();

        String getPosition();

        ByteString getPositionBytes();

        String getReason();

        ByteString getReasonBytes();

        String getSubType();

        ByteString getSubTypeBytes();

        String getTargetUid();

        ByteString getTargetUidBytes();

        String getTaskType();

        ByteString getTaskTypeBytes();

        long getTime();

        String getType();

        ByteString getTypeBytes();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_client_login_LoginAndRegisterProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_login_LoginAndRegisterProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{com.huawei.hianalytics.core.storage.Event.TAG, "Phone", "Account", "Name", "Birthday", "Type", "Reason", "IsTrue", "Content", "Mode", "Position", "Time", "TargetUid", "TaskType", "SubType", "Id", "AccountType", "EnumType", "Num"});
    }

    private LoginAndRegisterProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
