/**
 * FileName:    T_progressService
 * Author:      sealllsea
 * Date:        2018/9/17 13:47
 * Description:
 */
package service;

import po.T_progress;

import java.util.List;

public interface T_progressService {
    List<T_progress> selectAll();
}
