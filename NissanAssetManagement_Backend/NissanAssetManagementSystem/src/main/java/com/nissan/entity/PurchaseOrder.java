package com.nissan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "tblPurchaseOrder")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer pd_id;
	
	private String pd_order_no = UUID.randomUUID().toString().toUpperCase();
	
	private Integer ad_id;
	
	@ManyToOne
	@JoinColumn(name = "ad_id", insertable = false, updatable = false)
	@JsonIgnore
	private AssetDefinition assetDefination;
	
	private Integer at_id;
	
	@ManyToOne
	@JoinColumn(name = "at_id", insertable = false, updatable = false)
	@JsonIgnore
	private AssetType assetType;
	
	private Integer pd_qty;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime pd_date;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime pd_ddate;
	
	private Integer po_status_id;
	
	@ManyToOne
	@JoinColumn(name = "po_status_id", insertable = false, updatable = false)
	@JsonIgnore
	private PurchaseOrderStatus purchaseOrderStatus;
	
	private Integer vd_id;
	
	@ManyToOne
	@JoinColumn(name = "vd_id", insertable = false, updatable = false)
	@JsonIgnore
	private Vendor vendor;
	
}
