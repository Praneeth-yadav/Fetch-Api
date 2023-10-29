package com.fetch.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EntityScan
public class Item {

    private String shortDescription;
    private String price;
}
