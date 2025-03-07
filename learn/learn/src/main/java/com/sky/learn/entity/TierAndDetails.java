package com.sky.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TierAndDetails {

    @Field("tier")
    private String tier;
    @Field("id")
    private String id;
    @Field("active")
    private boolean active;
    @Field("benefits")
    private List<String> benefits;
}
