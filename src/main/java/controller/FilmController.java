/**
 * FileName:    PonoController
 * Author:      sealllsea
 * Date:        2018/9/10 13:34
 * Description:
 */
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Film;
import service.FilmService;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    FilmService filmService;


}
