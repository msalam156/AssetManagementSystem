package com.nissan.dto;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PurchaseOrderDTO {
	
	private Integer pd_id;
	
    private String pd_order_no;
    
    private String ad_name;
    
    private String at_name;
    
    private Integer pd_qty;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime pd_date;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime pd_ddate;
    
    private String po_status;
    
    private String vd_name;

}
