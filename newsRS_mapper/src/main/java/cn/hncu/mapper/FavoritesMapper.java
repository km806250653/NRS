package cn.hncu.mapper;

import cn.hncu.pojo.Favorites;
import cn.hncu.pojo.FavoritesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoritesMapper {
    int countByExample(FavoritesExample example);

    int deleteByExample(FavoritesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Favorites record);

    int insertSelective(Favorites record);

    List<Favorites> selectByExample(FavoritesExample example);

    Favorites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Favorites record, @Param("example") FavoritesExample example);

    int updateByExample(@Param("record") Favorites record, @Param("example") FavoritesExample example);

    int updateByPrimaryKeySelective(Favorites record);

    int updateByPrimaryKey(Favorites record);
}