/**
 * FileName:    T_progressServiceImpl
 * Author:      sealllsea
 * Date:        2018/9/17 13:49
 * Description:
 */
package service.impl;

import mapper.T_progressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import po.T_progress;
import service.T_progressService;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service
public class T_progressServiceImpl implements T_progressService {
    @Autowired
    private T_progressMapper t_progressMapper;

    @Override
    public List<T_progress> selectAll() {
        return t_progressMapper.selectAll();
    }
}
