package com.BookMyShow.exceptions;

import com.BookMyShow.exceptions.common.AppException;
import java.util.Map;
import static com.BookMyShow.exceptions.errorCodes.CommonErrorCode.RECORD_NOT_FOUND;

public class RecordNotFoundException extends AppException {

    public RecordNotFoundException(String recordType,String recordKey){
        super(RECORD_NOT_FOUND, Map.of(recordKey,String.format("%s (%s) not found",recordType,recordKey)));
    }
}
