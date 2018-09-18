/**
 * FileName:    DynamicDataSourceUtil
 * Author:      sealllsea
 * Date:        2018/9/10 10:47
 * Description:
 */
package web;

public enum  DynamicDataSourceEnum {
    DS_ORACLE("ds_oracle"),DS_MYSQL("ds_mysql");
    private String key;
    DynamicDataSourceEnum(String key){
        this.key=key;
    }

    public String getKey(){
        return key;
    }

    public void setKey(String key){
        this.key=key;
    }
}

