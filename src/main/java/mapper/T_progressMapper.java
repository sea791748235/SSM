package mapper;

import java.util.List;
import po.T_progress;

public interface T_progressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_progress record);

    T_progress selectByPrimaryKey(Integer id);

    List<T_progress> selectAll();

    int updateByPrimaryKey(T_progress record);
}