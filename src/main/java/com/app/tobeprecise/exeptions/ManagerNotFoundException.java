package com.app.tobeprecise.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ManagerNotFoundException extends IllegalArgumentException{

    public ManagerNotFoundException() {
        super();
    }
}
