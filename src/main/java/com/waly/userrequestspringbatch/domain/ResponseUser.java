package com.waly.userrequestspringbatch.domain;

import com.waly.userrequestspringbatch.dto.UserDTO;

import java.util.List;

public class ResponseUser {

    private List<UserDTO> content;

    public List<UserDTO> getContent() {
        return content;
    }

}
