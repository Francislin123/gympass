package com.gympass.app.api.models;

import lombok.Data;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Data
public class Driver {

    private String id;
    private String name;

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
