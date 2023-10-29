package com.fetch.api.controller;

import com.fetch.api.entity.Id;
import com.fetch.api.entity.RequestJson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@RestController
@Service
@RequestMapping("/receipts")
public class receipts {
    public HashMap<UUID,AtomicInteger> hashMap=new HashMap<>();
    @PostMapping("/test")
    public void Test(){
        System.out.println("Working");

    }
    @GetMapping("/{id}/points")
    public ResponseEntity<Map<String, AtomicInteger>> Test(@RequestParam UUID id){
        System.out.println(id);
       AtomicInteger price= hashMap.get(id);
        Map<String, AtomicInteger> response = Collections.singletonMap("points", price);

        return ResponseEntity.ok(response);


    }
    @PostMapping("/process")
    public Id Process(@RequestBody RequestJson request) {
//        System.out.println("request body:" + request.getTotal());
        AtomicInteger price= new AtomicInteger();
        System.out.println("Price start: "+price);
//        price.addAndGet(request.getRetailer().length());
        request.getRetailer().chars().forEach(c->{
            int count=0;
            if(Character.isLetter(c)){
                count++;
            }
            price.addAndGet(count);
        }
        );
        System.out.println("Price: name:    "+price);
        System.out.println(Double.parseDouble(request.getTotal())%1);
        System.out.println("dollar rounded "+((Double.parseDouble(request.getTotal())%1)==0.00));
        if((Double.parseDouble(request.getTotal())%1)==0.00){
            price.addAndGet( 50);
            System.out.println("Price: if price is rounded :    "+price);
        }
        System.out.println("dollar 0.25 "+((Double.parseDouble(request.getTotal())%(0.25))==0.00));
        if((Double.parseDouble(request.getTotal())%(0.25))==0.00){
            price.addAndGet( 25);
            System.out.println("Price: 0.25 :   "+price);
        }
        System.out.println("items quantity points "+(request.getItems().size()/2)*5);
        price.addAndGet((request.getItems().size() / 2) * 5);

        request.getItems().stream().forEach(item -> {

                    System.out.println("Desc: " + item.getShortDescription() + "   length: " + item.getShortDescription().strip().length());
if(item.getShortDescription().strip().length()%3==0){
    System.out.println("value   :   "+Double.parseDouble(item.getPrice()) * 0.2);
    price.addAndGet((int) Math.ceil(Double.parseDouble(item.getPrice()) * 0.2));
}
                }
        );
        System.out.println("Price: after desc lenght "+price);
        LocalDate date=LocalDate.parse(request.getPurchaseDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(date.getDayOfMonth());
        if((date.getDayOfMonth()%2)==1){
            int u=price.addAndGet(6);
            System.out.println("updated price for date "+u);
        }
        System.out.println("Price: after date:  "+price);
        LocalTime time=LocalTime.parse(request.getPurchaseTime(),DateTimeFormatter.ofPattern("HH:mm"));
        if (time.isAfter(LocalTime.of(14,0)) && time.isBefore(LocalTime.of(16,0))) {
            System.out.println("The time is after 2:00 PM and before 4:00 PM.");
            price.addAndGet(10);
        } else {

            System.out.println("The time is not within the specified range.");
        }

        UUID id = UUID.randomUUID();
        Id id1=new Id(id);
        System.out.println("Price: "+price);
        hashMap.put(id, price);
//        System.out.println( "value:"+hashMap.get(id));
        return id1;

    }

}
