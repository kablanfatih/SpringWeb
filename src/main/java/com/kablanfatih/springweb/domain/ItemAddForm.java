package com.kablanfatih.springweb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class ItemAddForm {

    @NotEmpty
    @Size(min = 2, max = 50)
    private String itemType;

    @NotNull
    private int amount = 1;
}
