package com.pandmuerto.petcitas.model.flow;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class GenericFlow implements Serializable {
    @Serial
    private static final long serialVersionUID = -1064245407494698793L;

    private String message;

    private String code;

    private String status;

    private Serializable request;

    private Serializable response;

    private List<Serializable> responses;
}
