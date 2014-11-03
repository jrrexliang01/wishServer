package com.wish.www.server.pojo;

import java.util.Date;


public class ShopCommodity {
	private Integer id;
	
	private Integer shopId;					//店铺id
	
	private String sku;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	private Integer oldCommodityId;		//原商品id
	
	private String commodityId;		//商品id
	
	private String commoditySourceAddress;		//商品源地址
	
	private String commoditySourceName;			//商品源名称
	
	private String parentSku;					//
	
	private String commodityNumber;		//商品编号
	
	private String commodityMsrp;		//MSRP	
	
	private Double commodityCost;	//成本价
	
	private Double commodityReferenceCost;	//参考成本价
	
	private Double commodityTotalPrice;		//总价
	
	private Double commoditySalesPrice;		//销售价
	
	private Double commodityFreight;		//运费
	
	private Double commodityWeightQuan;		//权重
	
	private Double commodityWeight;		//重量
	
	private String  commodityColour;		//颜色
	
	private String commodityPrimaryPic;		//主图
	
	private String commodityPic1;	                            //
                                                               
	private String commodityPic2;	                            //
                                                                
	private String commodityPic3;	                            //
	                                                           
	private String commodityPic4;	                            //
	                                                            
	private String commodityPic5;	                            //
	                                                            
	private String commodityPic6;	                            //
	                                                            
	private String commodityPic7;	                            //
	                                                            
	private String commodityPic8;	                            //
	                                                            
	private String commodityPic9;	                            //
	                                                            
	private String commodityPic10;	                            //
	                                                           
	private String commodityPic11;	                            //
	                                                           
	private String commodityPic12;	                            //
	                                                            
	private String commodityPic13;	                            //
	                                                           
	private String commodityPic14;	                            //
	                                                            
	private String commodityPic15;
	
	private String comKeyword;		//关键字
	
	private String commodityKeyword;		//主关键字
	
	private String commodityCustomKeyword;

	private String commodityName;			//商品名称
	
	private String commoditySize;		//大小
	
	private String commodityVariablePic;	//变量图
	
	private Integer commodityStock;		//库存
	
	
	
	private Integer commodityBought;		//销量
	
	private Integer commoditySaves;			//收藏数
	
	private String commodityShopName;		//商品店铺名称
	
	private String commodityNameList;		//商品名的全排列字符串
	
	private Integer commodityIsEnable;		//是否可用
	
	private String commodityLogisticsTime;	//物流时间
	
	private Double commodityMarketplacePrice;		//市场价
	
	private Double commodityAmericaPrice;		//美金
	
	private Integer delFlg;						//是否删除
	
	private Integer shopCommodityState;				//店铺商品状态
	
	private Date upTime;					//上架时间
	
	private Date updateTime;				//更新时间
	
	private Date downTime;					//下架时间
	
	
	private String createUserName;			
	
	private String createTime;
	
	private String commodityDescription;	//描述
	
	private Integer commodityType;
	

	public Integer getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(Integer commodityType) {
		this.commodityType = commodityType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOldCommodityId() {
		return oldCommodityId;
	}

	public void setOldCommodityId(Integer oldCommodityId) {
		this.oldCommodityId = oldCommodityId;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommoditySourceAddress() {
		return commoditySourceAddress;
	}

	public void setCommoditySourceAddress(String commoditySourceAddress) {
		this.commoditySourceAddress = commoditySourceAddress;
	}

	public String getCommoditySourceName() {
		return commoditySourceName;
	}

	public void setCommoditySourceName(String commoditySourceName) {
		this.commoditySourceName = commoditySourceName;
	}

	public String getParentSku() {
		return parentSku;
	}

	public void setParentSku(String parentSku) {
		this.parentSku = parentSku;
	}

	public String getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(String commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public String getCommodityMsrp() {
		return commodityMsrp;
	}

	public void setCommodityMsrp(String commodityMsrp) {
		this.commodityMsrp = commodityMsrp;
	}

	public Double getCommodityCost() {
		return commodityCost;
	}

	public void setCommodityCost(Double commodityCost) {
		this.commodityCost = commodityCost;
	}

	public Double getCommodityReferenceCost() {
		return commodityReferenceCost;
	}

	public void setCommodityReferenceCost(Double commodityReferenceCost) {
		this.commodityReferenceCost = commodityReferenceCost;
	}

	public Double getCommodityTotalPrice() {
		return commodityTotalPrice;
	}

	public void setCommodityTotalPrice(Double commodityTotalPrice) {
		this.commodityTotalPrice = commodityTotalPrice;
	}

	public Double getCommoditySalesPrice() {
		return commoditySalesPrice;
	}

	public void setCommoditySalesPrice(Double commoditySalesPrice) {
		this.commoditySalesPrice = commoditySalesPrice;
	}

	public Double getCommodityFreight() {
		return commodityFreight;
	}

	public void setCommodityFreight(Double commodityFreight) {
		this.commodityFreight = commodityFreight;
	}

	public Double getCommodityWeightQuan() {
		return commodityWeightQuan;
	}

	public void setCommodityWeightQuan(Double commodityWeightQuan) {
		this.commodityWeightQuan = commodityWeightQuan;
	}

	public Double getCommodityWeight() {
		return commodityWeight;
	}

	public void setCommodityWeight(Double commodityWeight) {
		this.commodityWeight = commodityWeight;
	}

	public String getCommodityColour() {
		return commodityColour;
	}

	public void setCommodityColour(String commodityColour) {
		this.commodityColour = commodityColour;
	}

	public String getCommodityPrimaryPic() {
		return commodityPrimaryPic;
	}

	public void setCommodityPrimaryPic(String commodityPrimaryPic) {
		this.commodityPrimaryPic = commodityPrimaryPic;
	}

	public String getCommodityPic1() {
		return commodityPic1;
	}

	public void setCommodityPic1(String commodityPic1) {
		this.commodityPic1 = commodityPic1;
	}

	public String getCommodityPic2() {
		return commodityPic2;
	}

	public void setCommodityPic2(String commodityPic2) {
		this.commodityPic2 = commodityPic2;
	}

	public String getCommodityPic3() {
		return commodityPic3;
	}

	public void setCommodityPic3(String commodityPic3) {
		this.commodityPic3 = commodityPic3;
	}

	public String getCommodityPic4() {
		return commodityPic4;
	}

	public void setCommodityPic4(String commodityPic4) {
		this.commodityPic4 = commodityPic4;
	}

	public String getCommodityPic5() {
		return commodityPic5;
	}

	public void setCommodityPic5(String commodityPic5) {
		this.commodityPic5 = commodityPic5;
	}

	public String getCommodityPic6() {
		return commodityPic6;
	}

	public void setCommodityPic6(String commodityPic6) {
		this.commodityPic6 = commodityPic6;
	}

	public String getCommodityPic7() {
		return commodityPic7;
	}

	public void setCommodityPic7(String commodityPic7) {
		this.commodityPic7 = commodityPic7;
	}

	public String getCommodityPic8() {
		return commodityPic8;
	}

	public void setCommodityPic8(String commodityPic8) {
		this.commodityPic8 = commodityPic8;
	}

	public String getCommodityPic9() {
		return commodityPic9;
	}

	public void setCommodityPic9(String commodityPic9) {
		this.commodityPic9 = commodityPic9;
	}

	public String getCommodityPic10() {
		return commodityPic10;
	}

	public void setCommodityPic10(String commodityPic10) {
		this.commodityPic10 = commodityPic10;
	}

	public String getCommodityPic11() {
		return commodityPic11;
	}

	public void setCommodityPic11(String commodityPic11) {
		this.commodityPic11 = commodityPic11;
	}

	public String getCommodityPic12() {
		return commodityPic12;
	}

	public void setCommodityPic12(String commodityPic12) {
		this.commodityPic12 = commodityPic12;
	}

	public String getCommodityPic13() {
		return commodityPic13;
	}

	public void setCommodityPic13(String commodityPic13) {
		this.commodityPic13 = commodityPic13;
	}

	public String getCommodityPic14() {
		return commodityPic14;
	}

	public void setCommodityPic14(String commodityPic14) {
		this.commodityPic14 = commodityPic14;
	}

	public String getCommodityPic15() {
		return commodityPic15;
	}

	public void setCommodityPic15(String commodityPic15) {
		this.commodityPic15 = commodityPic15;
	}
	
	public String getComKeyword() {
		return comKeyword;
	}

	public void setComKeyword(String comKeyword) {
		this.comKeyword = comKeyword;
	}

	public String getCommodityKeyword() {
		return commodityKeyword;
	}

	public void setCommodityKeyword(String commodityKeyword) {
		this.commodityKeyword = commodityKeyword;
	}

	public String getCommodityCustomKeyword() {
		return commodityCustomKeyword;
	}

	public void setCommodityCustomKeyword(String commodityCustomKeyword) {
		this.commodityCustomKeyword = commodityCustomKeyword;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommoditySize() {
		return commoditySize;
	}

	public void setCommoditySize(String commoditySize) {
		this.commoditySize = commoditySize;
	}

	public String getCommodityVariablePic() {
		return commodityVariablePic;
	}

	public void setCommodityVariablePic(String commodityVariablePic) {
		this.commodityVariablePic = commodityVariablePic;
	}

	public Integer getCommodityStock() {
		return commodityStock;
	}

	public void setCommodityStock(Integer commodityStock) {
		this.commodityStock = commodityStock;
	}

	public String getCommodityDescription() {
		return commodityDescription;
	}

	public void setCommodityDescription(String commodityDescription) {
		this.commodityDescription = commodityDescription;
	}

	public Integer getCommodityBought() {
		return commodityBought;
	}

	public void setCommodityBought(Integer commodityBought) {
		this.commodityBought = commodityBought;
	}

	public Integer getCommoditySaves() {
		return commoditySaves;
	}

	public void setCommoditySaves(Integer commoditySaves) {
		this.commoditySaves = commoditySaves;
	}

	public String getCommodityShopName() {
		return commodityShopName;
	}

	public void setCommodityShopName(String commodityShopName) {
		this.commodityShopName = commodityShopName;
	}

	public String getCommodityNameList() {
		return commodityNameList;
	}

	public void setCommodityNameList(String commodityNameList) {
		this.commodityNameList = commodityNameList;
	}

	public Integer getCommodityIsEnable() {
		return commodityIsEnable;
	}

	public void setCommodityIsEnable(Integer commodityIsEnable) {
		this.commodityIsEnable = commodityIsEnable;
	}

	public String getCommodityLogisticsTime() {
		return commodityLogisticsTime;
	}

	public void setCommodityLogisticsTime(String commodityLogisticsTime) {
		this.commodityLogisticsTime = commodityLogisticsTime;
	}

	public Double getCommodityMarketplacePrice() {
		return commodityMarketplacePrice;
	}

	public void setCommodityMarketplacePrice(Double commodityMarketplacePrice) {
		this.commodityMarketplacePrice = commodityMarketplacePrice;
	}


	public Double getCommodityAmericaPrice() {
		return commodityAmericaPrice;
	}

	public void setCommodityAmericaPrice(Double commodityAmericaPrice) {
		this.commodityAmericaPrice = commodityAmericaPrice;
	}

	public Integer getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Integer delFlg) {
		this.delFlg = delFlg;
	}

	public Integer getShopCommodityState() {
		return shopCommodityState;
	}

	public void setShopCommodityState(Integer shopCommodityState) {
		this.shopCommodityState = shopCommodityState;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDownTime() {
		return downTime;
	}

	public void setDownTime(Date downTime) {
		this.downTime = downTime;
	}


	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}
