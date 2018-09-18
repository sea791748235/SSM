/**
 * FileName:    DataSourceHolder
 * Author:      sealllsea
 * Date:        2018/9/10 11:24
 * Description:
 */
package web;

public class DataSourceHolder {
    private static final ThreadLocal<String> dataSources=new ThreadLocal<String>();
    public static void setDataSources(String dataSource){
        dataSources.set(dataSource);
    }

    public static String getDataSources(){
        return dataSources.get();
    }
}
