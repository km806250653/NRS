package cn.hncu.mapper;

import cn.hncu.pojo.Examine;
import cn.hncu.pojo.ExamineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamineMapper {
    int countByExample(ExamineExample example);

    int deleteByExample(ExamineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Examine record);

    int insertSelective(Examine record);

    List<Examine> selectByExampleWithBLOBs(ExamineExample example);

    List<Examine> selectByExample(ExamineExample example);

    Examine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Examine record, @Param("example") ExamineExample example);

    int updateByExampleWithBLOBs(@Param("record") Examine record, @Param("example") ExamineExample example);

    int updateByExample(@Param("record") Examine record, @Param("example") ExamineExample example);

    int updateByPrimaryKeySelective(Examine record);

    int updateByPrimaryKeyWithBLOBs(Examine record);

    int updateByPrimaryKey(Examine record);
}