/**
 * FileName:    DynamicDataSource
 * Author:      sealllsea
 * Date:        2018/9/10 11:28
 * Description:
 */
package web;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey(){
        return DataSourceHolder.getDataSources();
    }
}
