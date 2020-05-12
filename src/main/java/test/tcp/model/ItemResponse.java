package test.tcp.model;

import java.util.Date;

import lombok.Data;

/**
 * ItemResponse
 */
@Data
public class ItemResponse {

    private Integer id;
    private String title;
    private String description;
    private Date timestamp;



}