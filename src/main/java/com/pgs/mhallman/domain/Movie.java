package com.pgs.mhallman.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by mhallman on 26.06.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

    int id;

    private String name;

    private String directory;

}
