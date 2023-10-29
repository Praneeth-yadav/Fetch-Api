package com.fetch.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityScan
public class RequestJson {
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;


    private List<Item> items;

    private String total;


}
