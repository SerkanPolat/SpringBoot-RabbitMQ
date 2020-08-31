package com.sp.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Bildiri implements Serializable {
    private String BildiriId;
    private String BildiriIcerik;
    private Date OlusturulmaTarihi;

    @Override
    public String toString() {
        return BildiriIcerik;
    }
}
