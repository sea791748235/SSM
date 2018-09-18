/**
 * FileName:    PonoServiceImpl
 * Author:      sealllsea
 * Date:        2018/9/10 13:30
 * Description:
 */
package service.impl;

import mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import po.Film;
import service.FilmService;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    public FilmMapper filmMapper;

    public List<Film> getAllFilm(){
        List<Film> list=filmMapper.getAllFilm();
        return list;
    }
}
