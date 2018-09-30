package com.management.devices.common.enums;

/**
 * Created by NhatNV on Dec 03, 2014 16:39.
 */
public enum ResponseCode {
  SUCCESS("000", "Giao dich thanh cong"),
  //check InMessage
  DUPLICATED("001", "Giao dich bi trung lap"),
  NOT_ENOUGH_TIME_TO_PROCESS("002", "Khong du thoi gian xu ly giao dich"),
  INVALID_TRANSACTION_TYPE("003", "Loai giao dich khong hop le"),
  INVALID_PROVIDER_CODE("004", "Ma nha cung cap khong hop le"),
  INVALID_PROVIDER_TRANSACTION_TYPE("005", "Nha cung cap khong ho tro dich vu"),
  INVALID_PARTNER_CODE("006", "Ma doi tac khong hop le"),
  INVALID_PARTNER_PROVIDER_TRANSACTION_TYPE("007", "Doi tac khong duoc su dung dich vu cua nha cung cap"),
  INVALID_MERCHANT_CODE("008", "Ma merchant khong hop le"),
  INVALID_MERCHANT_TRANSACTION_TYPE("009", "Merchant khong ho tro dich vu"),
  INVALID_SIGNATURE("010", "Chu ky khong hop le"),
  //check RegisterAccount
  INVALID_CUSTOMER_NAME("021", "Ten khach hang khong hop le"),
  INVALID_ID_NUMBER("022", "So chung minh khong hop le"),
  INVALID_PIN("023", "Ma PIN khong hop le"),
  INVALID_RETYPE_PIN("024", "Ma PIN xac nhan khong hop le"),
  INVALID_PHONE("025", "So dien thoai khong hop le"),
  ACCOUNT_EXISTED("026", "Tai khoan vi da ton tai"),
  ACCOUNT_REGISTERED_BY_ANOTHER_IDNUMBER("027", "Tai khoan vi da duoc dang ky boi khach hang co CMND khac"),
  //verify Account
  ACCOUNT_NOT_EXISTED_CHANNEL("030", "Tai khoan vi chua dang ky kenh dich vu"),
  ACCOUNT_IS_DESTROYED_CHANNEL("031", "Tai khoan vi da bi huy kenh dich vu"),
  ACCOUNT_IS_LOCKED_CHANNEL("032", "Tai khoan vi da bi khoa kenh dich vu"),
  ACCOUNT_IS_CREATED_CHANNEL("033", "Tai khoan vi chua duoc duyet kenh dich vu"),
  INVALID_DECRYPT_PIN("034", "Khong giai ma duoc ma PIN"),
  PIN_IS_CORRECTED("035", "Ma PIN khong dung"),

  ALLOW_ACCESS_LIMITED("036", "Vuot gioi han so luong truy cap cho phep"),
  SESSION_NOT_EXISTED("037", "Session khong ton tai"),
  INVALID_SESSION("038", "Session khong hop le"),
  SESSION_EXPIRED("039", "Session het thoi gian hieu luc"),
  //get eDongInfo
  ACCOUNT_NOT_EXISTED("040", "Tai khoan vi chua dang ky"),
  ACCOUNT_IS_DESTROYED("041", "Tai khoan vi da bi huy"),
  ACCOUNT_IS_LOCKED("042", "Tai khoan vi da bi khoa"),
  ACCOUNT_IS_CREATED("043", "Tai khoan vi chua duoc duyet"),
  //otp
  OTP_LIMITED("044", "Vuot so luong OTP cho phep"),
  OTP_NOT_EXISTED("045", "OTP khong ton tai"),
  INVALID_OTP("046", "OTP khong hop le"),
  OTP_EXPIRED("047", "OTP het thoi gian hieu luc"),

  //check blacklist - whitelist
  ACCOUNT_REJECTED_BY_WHITELIST("050", "Tai khoan bi tu choi dich vu boi whitelist"),
  ACCOUNT_ACCEPTED_BY_BLACKLIST("051", "Tai khoan bi chan dich vu boi blacklist"),
  //check limit
  LIMITED_1("052", "Han muc giao dich < max"),
  LIMITED_2("053", "Han muc giao dich <= max"),
  LIMITED_3("054", "Han muc giao dich > min"),
  LIMITED_4("055", "Han muc giao dich >= min"),
  LIMITED_5("056", "Han muc dich vu tong tien trong ngay < max"),
  LIMITED_6("057", "Han muc dich vu tong tien trong ngay <= max"),
  LIMITED_7("058", "Han muc dich vu so lan trong ngay < max"),
  LIMITED_8("059", "Han muc dich vu so lan trong ngay <= max"),
  LIMITED_9("060", "Han muc tong tien ghi no trong ngay <= max"),
  //loadcash
  ACCOUNT_PARTNER_NOT_EXISTED("061", "Tai khoan vi cua doi tac khong ton tai"),
  ACCOUNT_PARTNER_IS_DESTROYED("062", "Tai khoan vi cua doi tac da bi huy"),
  ACCOUNT_PARTNER_IS_LOCKED("063", "Tai khoan vi cua doi tac da bi khoa"),
  ACCOUNT_PARTNER_IS_CREATED("064", "Tai khoan vi cua doi tac chua duoc duyet"),
  INVALID_ACCOUNT_PARTNER_TYPE("065", "Loai tai khoan doi tac khong hop le"),
  ACCOUNT_LOADCASH_NOT_EXISTED("066", "Tai khoan vi duoc nap khong ton tai"),
  ACCOUNT_LOADCASH_IS_DESTROYED("067", "Tai khoan vi duoc nap da bi huy"),
  ACCOUNT_LOADCASH_IS_LOCKED("068", "Tai khoan vi duoc nap da bi khoa"),
  ACCOUNT_LOADCASH_IS_CREATED("069", "Tai khoan vi duoc nap chua duoc duyet"),
  INVALID_ACCOUNT_LOADCASH_TYPE("070", "Loai tai khoan duoc nap khong hop le"),
  //transfer2purse
  DEBIT_ACCOUNT_NOT_EXISTED("071", "Tai khoan ghi no khong ton tai"),
  DEBIT_ACCOUNT_IS_DESTROYED("072", "Tai khoan ghi no da bi huy"),
  DEBIT_ACCOUNT_IS_LOCKED("073", "Tai khoan ghi no da bi khoa"),
  DEBIT_ACCOUNT_IS_CREATED("074", "Tai khoan ghi no chua duoc duyet"),
  INVALID_ACCOUNT_DEBIT("075", "Loai tai khoan ghi no khong hop le"),

  CREDIT_ACCOUNT_NOT_EXISTED("076", "Tai khoan ghi no khong ton tai"),
  CREDIT_ACCOUNT_IS_DESTROYED("077", "Tai khoan ghi no da bi huy"),
  CREDIT_ACCOUNT_IS_LOCKED("078", "Tai khoan ghi no da bi khoa"),
  CREDIT_ACCOUNT_IS_CREATED("079", "Tai khoan ghi no chua duoc duyet"),
  INVALID_ACCOUNT_CREDIT("080", "Loai tai khoan ghi no khong hop le"),

  DEBIT_ACCOUNT_NOT_CHANGED_PIN("081", "Tai khoan ghi no chua doi PIN"),
  INVALID_AMOUNT("082", "So tien giao dich khong hop le"),
  NOT_ENOUGH_MONEY("083", "Khong du tien de thuc hien giao dich"),

  LOCK_TRANSACTION_NOT_EXISTS("084", "Giao dich lock khong ton tai"),
  UNLOCK_TRANSACTION_EXISTS("085", "Giao dich da duoc unlock"),
  SETTLEMENT_FAILURE_NOT_UNLOCK("086", "Thanh toan NCC loi va unlock loi"),
  DEBIT_DUPLICATED_CREDIT("087", "Tai khoan ghi no trung tai khoan ghi co"),
  INVALID_CUSTOMER_CODE("088", "Ma khach hang khong dung dinh dang"),
  SETTLEMENT_SUCCESS_DEBIT_FAILURE("089", "Thanh toan NCC thanh cong ,cat tien eDong loi"),
  NOT_REGISTER_BANK_ACCOUNT("090", "Chua dang ky tai khoan ngan hang"),
  TRANSFER_FAILURE_NOT_UNLOCK("091", "Chuyen khoan loi va unlock loi"),
  WITHDRAW_FAILURE_NOT_UNLOCK("092", "Rut tien loi va unlock loi"),
  NOT_FOUND_TRANSACTION("093", "Khong co giao dich nao duoc tim thay"),
  TRANSACTION_NOT_EXIST("094", "Giao dich khong ton tai"),
  TRANSACTION_STATE_INVALID("095", "Trang thai giao dich khong hop le"),
  TRANSACTION_IS_REFUND("096", "Giao dich goc la giao dich huy"),
  TRANSACTION_LOCK_NOT_MATCHED("097","Giao dich lock khong dung so tien"),

  ECPGW_PARTNER_NOT_EXIST("800", "Doi tac khong ton tai"),
  ECPGW_PARTNER_DISABLE("801", "Doi tac da bi khoa"),
  ECPGW_INVALID_IP("802", "IP khong duoc phep truy cap"),
  ECPGW_NOT_SUPPORT_MTI("803", "Ban tin sai MTI"),
  ECPGW_INVALID_SIGNATURE("804", "Ban tin sai chu ky"),
  ECPGW_ACCOUNT_NOT_EXIST("805", "Ma tai khoan khach hang khong ton tai"),
  ECPGW_INVALID_AMOUNT("806", "So tien khong hop le"),
  ECPGW_DUPLICATE("807", "Giao dich bi duplicated"),
  ECPGW_INVALID_SERVICE("808", "Doi tac khong duoc su dung dich vu"),
  ECPGW_DB_FAILURE("809", "Loi truy cap co so du lieu"),
  ECPGW_TRANSACTION_SUSPICION("810", "Giao dich nghi ngo"),
  ECPGW_BILL_EXPIRED("811", "Hoa don da het han thanh toan"),
  ECPGW_INVALID_BILL("812", "Hoa don khong ton tai"),
  ECPGW_INVALID_ACCOUNT("813", "Sai ma khach hang/ma hoa don"),
  ECPGW_BILL_PAYED("814", "Loi hoa don da thanh toan"),
  ECPGW_OUT_OF_CODE_PAYED("815", "Het menh gia the trong kho"),
  ECPGW_SERVICE_NOT_AVAILABLE_FOR_PROVIDER("816", "Dich vu nay khong duoc cho phep voi nha cung cap"),
  ECPGW_MONEY_NOT_ENOUGH("817", "Tien ECPay ben doi tac khong du thuc hien giao dich thanh toan"),
  ECPGW_CUSTOMER_NOT_DEBT("818", "Khach hang khong con no"),
  ECPGW_TIMEOUT("819", "Timeout voi nha cung cap dich vu"),
  ECPGW_REFUNDED("820", "Giao dich hoan tra thanh cong"),
  ECPGW_SYSTEM_ERROR("821", "Loi he thong"),
  ECPGW_GET_CARD_ERROR("822", "Lay ma the loi"),
  ECPGW_ROUTING_ERROR("823", "Loi duong truyen network"),
  ECPGW_OTHER_ERROR("824", "Giao dich loi"),

  FAILURE("900", "Giao dich loi"),
  ROUTING_ERROR("998", "Message chua duoc cau hinh routing"),
  SYSTEM_ERROR("999", "Loi he thong");

  public String text;
  public String code;

  ResponseCode(String _code, String _text) {
    this.code = _code;
    this.text = _text;
  }
}
