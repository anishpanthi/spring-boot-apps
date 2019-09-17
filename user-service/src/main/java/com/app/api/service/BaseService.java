package com.app.api.service;

import com.app.api.dto.CrudResponseDto;
import com.app.api.exception.ApiException;
import com.app.api.util.Constants;
import com.app.api.util.DateUtil;

import java.util.List;
import java.util.Optional;

/**
 * @author Anish Panthi
 */
public interface BaseService<T, DT, ID> {

    List<DT> findAll() throws ApiException;

    DT findOne(ID id) throws ApiException;

    Object save(DT dt) throws ApiException;

    Object update(DT dt) throws ApiException;

    Object delete(DT dt) throws ApiException;

    Optional<T> findByUsername(String username);

    default Object prepareSuccessCrudStatusDto(String operation) {
        CrudResponseDto crudResponseDto = new CrudResponseDto();
        crudResponseDto.setTimeStamp(DateUtil.getLocalDateNow());
        crudResponseDto.setStatus(Constants.SUCCESS);
        String message = "";
        switch (operation) {
            case Constants.SAVE:
                message = "Record inserted successfully!!!";
                break;
            case Constants.UPDATE:
                message = "Record updated successfully!!!";
                break;
            case Constants.DELETE:
                message = "Record deleted successfully!!!";
                break;

        }
        crudResponseDto.setMessage(message);
        return crudResponseDto;
    }

    default void throwCrudError(String operation) throws ApiException {
        String operationErrorMessage = "";
        switch (operation) {
            case Constants.SAVE:
                operationErrorMessage = "Unable to save record!!!";
                break;
            case Constants.UPDATE:
                operationErrorMessage = "Unable to update record!!!";
                break;
            case Constants.DELETE:
                operationErrorMessage = "Unable to delete record!!!";
                break;
        }
        throw new ApiException(operationErrorMessage);
    }
}
