
package com.doublechaintech.retailscm.retailstoremembercoupon;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class RetailStoreMemberCouponTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_member_coupon_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_NUMBER = "number";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_OWNER,COLUMN_NUMBER,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_OWNER,COLUMN_NUMBER,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "retail_store_member_coupon_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(12)","","名称","",""},
                new String[]{"owner","varchar(48)","","业主","retail_store_member_data","id"},
                new String[]{"number","varchar(28)","","数","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "生超会员优惠券", new String[]{
                "create unique index idx4id_ver_of_retail_store_member_coupon on retail_store_member_coupon_data (id, version);",
                "create  index idx4last_update_time_of_retail_store_member_coupon on retail_store_member_coupon_data (last_update_time);"
         }, new String[]{
                "alter table retail_store_member_coupon_data add constraint pk4id_of_retail_store_member_coupon_data primary key (id);",
                "alter table retail_store_member_coupon_data add constraint fk4owner_of_retail_store_member_coupon_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


